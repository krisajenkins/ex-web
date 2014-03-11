(defproject ex-web "0.1.0-SNAPSHOT"
  :description "FIXME: write description"
  :url "http://example.com/FIXME"
  :license {:name "Eclipse Public License"
            :url "http://www.eclipse.org/legal/epl-v10.html"}
  :dependencies [
                 ;; Clojure
                 [org.clojure/clojure "1.5.1"]

                 ;; Web
                 [compojure "1.1.6"]
                 [ring "1.2.1"]
                 [hiccup "1.0.5"]

                 ;; Database
                 [org.clojure/java.jdbc "0.3.3"]]
  :plugins [[lein-ring "0.8.8"]]
  :ring {:handler ex-web.webserver/app}
  :profiles {:dev {:dependencies [[org.apache.derby/derby "10.10.1.1"]]}})
