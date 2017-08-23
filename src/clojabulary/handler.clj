(ns clojabulary.handler
  (:require [compojure.core :refer :all]
            [compojure.route :as route]
            [ring.middleware.defaults :refer [wrap-defaults site-defaults]]
            [clojabulary.dictionary :refer :all]
            [clojabulary.templating :as templating]
            [ring.util.response :as response]))

(defroutes app-routes
  (GET "/" [] (templating/body "Clojabulary" (templating/display-list @dictionary)))
  (POST "/" [indonesian english] 
    (do 
      (add_word {indonesian english})
      (response/redirect "/")))
      
  (route/not-found "Not Found"))

  

(def app
  (wrap-defaults app-routes site-defaults))
