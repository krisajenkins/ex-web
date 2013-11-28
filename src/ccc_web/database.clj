(ns ccc-web.database
  (:require [clojure.java.jdbc :as sql]))

(def derby-db {:subprotocol "derby"
               :subname (gensym "memory:")
               :create true})



(defn current-time
  []
  (-> (sql/query derby-db ["SELECT current_timestamp AS time FROM sysibm.sysdummy1"])
      first
      :time))
