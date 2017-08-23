(ns clojabulary.handler
  (:require [compojure.core :refer :all]
            [compojure.route :as route]
            [ring.middleware.defaults :refer [wrap-defaults site-defaults]]
            [clojabulary.dictionary :refer :all]
            [clojabulary.templating :as templating]))

(defroutes app-routes
  (GET "/" [] (templating/body "Clojabulary" (templating/list @dictionary)))
  (route/not-found "Not Found"))

(def app
  (wrap-defaults app-routes site-defaults))
