(ns ccc-web.webserver
  (:require [clojure.pprint :refer [pprint]]
            [compojure.core :refer :all]
            [compojure.route :as route]
            [compojure.handler :as handler]
            [ring.adapter.jetty :as jetty]
            [hiccup.core :refer :all]
            [hiccup.page :refer :all]
            [hiccup.middleware :refer [wrap-base-url]]
            [ccc-web.database :as db]))

(defn index-page
  []
  (html5 {:lang "en"}
         [:head
          [:title "What's New Pussycat?"]
          [:link {:rel "stylesheet"
                  :href "//netdna.bootstrapcdn.com/bootstrap/3.0.2/css/bootstrap.min.css"}]]
         [:body
          [:nav.navbar.navbar-default {:role "navigation"}
           [:div.navbar-header
            [:div.navbar-brand "What's New Pussycat?"]]]
          [:div#main.container
           [:img.thumbnail {:src "/kitty.jpg"
                            :alt "Kitty"}]
           [:div "The time is "
            [:span.label.label-default (db/current-time)]]]])) 

(defroutes main-routes
  (GET "/" [] (index-page))

  (route/resources "/")
  (route/not-found "Page not found"))

(def app
  (-> main-routes
      handler/site
      wrap-base-url))
