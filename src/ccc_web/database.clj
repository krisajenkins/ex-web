(ns ccc-web.database
  (:require [clojure.java.jdbc :as sql])
  (:import [java.util Date]))

(def db-spec {:subprotocol "derby"
               :subname (gensym "memory:")
               :create true})

(defonce schema
  (do
    (sql/execute! db-spec ["CREATE TABLE log (uri VARCHAR(200), time DATE)"])
     :ok))

(defn current-time
  []
  (-> (sql/query db-spec ["SELECT current_timestamp AS time FROM sysibm.sysdummy1"])
      first
      :time))

;; (sql/insert! db-spec :log
;;              {:uri "/" :time (Date.)}
;;              {:uri "/" :time (Date.)})

;; (sql/query db-spec ["SELECT * FROM log"])
