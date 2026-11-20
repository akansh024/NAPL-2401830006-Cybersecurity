
(ns java-interoperability
  (:import [java.util ArrayList HashMap]))

(println "Absolute Value:" (Math/abs -25))
(println "Current Time:" (System/currentTimeMillis))

(def list1 (new ArrayList))
(def map1 (new HashMap))

(.add list1 "Apple")
(.add list1 "Mango")
(.put map1 "Name" "Akansh")
(.put map1 "Age" 18)

(println "Java ArrayList:" list1)
(println "Java HashMap:" map1)

(def clj-list [1 2 3 4])
(def java-list (java.util.ArrayList. clj-list))

(println "Clojure to Java:" java-list)

(def converted-list (vec java-list))
(println "Java to Clojure:" converted-list)
