(ns clojabulary.templating
  (:use [hiccup.page :only (html5 include-css include-js)]
        [hiccup.form :refer :all]
        [ring.util.anti-forgery]))
  

(defn body [title & content]
  (html5 
    [:head
     [:title title]
     (include-css "https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css")          
     (include-css "https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap-theme.min.css")]
       
    [:body
     [:div {:class "container"}
      [:a {:href "/"} [:h1 title]]
      [:div {:class "row"}
       [:div {:class "col-md-4"} [:h2 "Find"] 
        (form-to [:get "/"]
         [:div {:class "form-group"}
          (label {:class "control-label"} "word" "Word")
          (text-field {:class "form-control"} "word")]
         [:div {:class "form-group"}
          (submit-button "Find")])]
       [:div {:class "col-md-4"} "&nbsp;"] 
       [:div {:class "col-md-4"} [:h2 "Add word"] 
        (form-to [:post "/"]
          (anti-forgery-field)
         [:div {:class "form-group"}
          (label {:class "control-label"} "indonesian" "Indonesian")
          (text-field {:class "form-control"} "indonesian")]
         [:div {:class "form-group"}
          (label {:class "control-label"} "english" "English")
          (text-field {:class "form-control"} "english")]
         [:div {:class "form-group"}
          (submit-button "Add")])]]
          
      [:div {:class "row"}  content]]]))
           
           
           
            
            
            
            
          
          
           
                 
          
         
           
                

            
          
          

(defn display-list [dict]
  [:div {:class "col-md-12"}
   [:h2 "Current Words"] 
   [:table {:class "table"} 
    (for [entry (seq dict)] 
      [:tr [:td (get entry 0)] [:td (get entry 1)]])]])
