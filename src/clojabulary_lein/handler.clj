(ns clojabulary-lein.handler
  (:require [compojure.core :refer :all]
            [compojure.route :as route]
            [ring.middleware.defaults :refer [wrap-defaults site-defaults]]
            [clojabulary-lein.dictionary :refer :all]
            [clojabulary-lein.templating :as templating]))

(defroutes app-routes
  (GET "/" [] (templating/body "Clojabulary" (templating/list @dictionary)))
  (route/not-found "Not Found"))

(def app
  (wrap-defaults app-routes site-defaults))
