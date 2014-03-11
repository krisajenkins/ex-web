(ns ex-web.database
  (:require [yesql.core :refer [defqueries]])
  (:import [java.util Date]))

;;; Define a DB descriptor.
(def db-spec {:subprotocol "derby"
              :subname (gensym "memory:")
              :create true})

(defqueries "ex_web/queries.sql")

;;; In-memory Database wrangling:
(defonce schema-created?
  (boolean
   (create-log-table! db-spec)))

;;; Actual Work:
(defn current-time
  []
  (-> (current-database-time db-spec)
      first
      :time))

;; (insert-log! db-spec "/" (Date.))
;; (fetch-logs db-spec)
