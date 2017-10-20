(ns clojabulary.handler-test
  (:require [clojure.test :refer :all]
            [ring.mock.request :as mock]
            [clojabulary.handler :refer :all]))


(deftest test-app
  (testing "listing"
    (let [response (app (mock/request :get "/"))]
      (is (= (:status response) 200))
      (is (.contains (:body response) "<title>Clojabulary</title>"))))

  (testing "not-found route"
    (let [response (app (mock/request :get "/invalid"))]
      (is (= (:status response) 404))))
  
  (testing "find a word"
    (let [response (app (mock/request :get "/?word=makan"))]
          (is (= (:status response 200))))))
  
