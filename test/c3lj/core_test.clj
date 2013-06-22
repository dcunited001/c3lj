(ns c3lj.core-test
  (:require [clojure.test :refer :all]
            [c3lj.core :refer :all]))

(deftest a-test
  (testing "FIXME, I fail."
    (is (= 0 1))))

(deftest serializer-interest
  (testing "Serializer - ccnb - interest message"
    (is (=
      (c3lj.core/ser-intmsg 16r01d2f2faa55041524300fa9d000102000000) (
"<Interest>
  <Name>
    <Component ccnbencoding="text">PARC</Component>
    <Component ccnbencoding="base64Binary">AAEC</Component>
  </Name>
</Interest>")))))
