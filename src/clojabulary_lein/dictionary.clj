(ns clojabulary-lein.dictionary
  (:require [compojure.core :refer :all]
            [compojure.route :as route]
            [ring.middleware.defaults :refer [wrap-defaults site-defaults]]))

(def dictionary(atom {}))

(defn add_word[word] (swap! dictionary conj word))

(defn word_count[](count (deref dictionary)))

(defn words[] (@dictionary))
                       
(defn find_word[word](get @dictionary word))
