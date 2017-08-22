(ns clojabulary-lein.dictionary-test
  (:require [clojure.test :refer :all]
            [clojabulary-lein.dictionary :refer :all]))

(deftest test-dictionary
  (testing "can add word"
    (let [word {"food", "makanan"}]
      (add_word word)
      (is (= (word_count) 1)))))
  
  

(deftest test-dictionary-access 
  (testing "can get all words"
    (do
      (add_word {"food" "makanan"})
      (add_word {"drink" "minuman"})
      (is (= (word_count) 2))))
  
  (testing "can find single word"
    (do
      (add_word {"food" "makanan"})
      (is (= (find_word "food") "makanan")))))
  

  
  


        
       
      
  
  
  

  
