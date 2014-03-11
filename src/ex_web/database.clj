(ns ex-web.database
  (:require [clojure.java.jdbc :as sql])
  (:import [java.util Date]))

;;; Define a DB descriptor.
(def db-spec {:subprotocol "derby"
              :subname (gensym "memory:")
              :create true})

;;; In-memory Database wrangling:
(defonce schema-created?
  (boolean
   (sql/execute! db-spec ["CREATE TABLE log (uri VARCHAR(200), time DATE)"])))

(defn drop-db
  []
  (sql/get-connection (-> db-spec
                          (dissoc :create)
                          (assoc :drop true))))

;;; Actual Work:
(defn current-time
  []
  (-> (sql/query db-spec
                 ["SELECT current_timestamp AS time FROM sysibm.sysdummy1"])
      first
      :time))

;; (sql/insert! db-spec :log
;;              {:uri "/" :time (Date.)}
;;              {:uri "/" :time (Date.)})

;; (sql/query db-spec ["SELECT * FROM log"])
