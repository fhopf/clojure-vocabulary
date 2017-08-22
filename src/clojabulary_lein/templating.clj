(ns clojabulary-lein.templating
  (:use [hiccup.page :only (html5 include-css include-js)]))

(defn body [title & content]
  (html5 [:head
          [:title title]
          (include-css "//netdna.bootstrapcdn.com/twitter-bootstrap/2.3.1/css/bootstrap-combined.min.css")
          
          [:body
           [:div {:class "container"} content]]]))

(defn list [dict]
  dict)
