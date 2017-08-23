(ns clojabulary.dictionary-test
  (:require [clojure.test :refer :all]
            [clojabulary.dictionary :refer :all]))

(def initialWordCount 4)


(deftest test-dictionary
  (testing "can add word"
    (let [word {"food", "makanan"}]
      (add_word word)
      (is (= (word_count) (+ initialWordCount 1))))))
  
  

(deftest test-dictionary-access 
  (testing "can get all words"
    (do
      (add_word {"food" "makanan"})
      (add_word {"drink" "minuman"})
      (is (= (word_count) (+ initialWordCount 2)))))
  
  (testing "can find single word"
    (do
      (add_word {"food" "makanan"})
      (is (= (find_word "food") "makanan")))))
  

  
  


        
       
      
  
  
  

  
