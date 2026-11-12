(ns sequence)

(def list1 [1 2 3 4 5])
(def list2 [6 7 8 9 10])

(println "----- ORIGINAL COLLECTIONS -----")
(println "Collection 1:" list1)
(println "Collection 2:" list2)

(println "\n----- MAP: SQUARE EACH ELEMENT -----")
(println "List 1:" (map #(* % %) list1))
(println "List 2:" (map #(* % %) list2))

(println "\n----- FILTER: EVEN NUMBERS -----")
(println "List 1:" (filter even? list1))
(println "List 2:" (filter even? list2))

(println "\n----- REDUCE: SUM OF ELEMENTS -----")
(println "List 1 Sum:" (reduce + list1))
(println "List 2 Sum:" (reduce + list2))

(println "\n----- TAKE AND DROP -----")
(println "Take first 3 from List 1:" (take 3 list1))
(println "Drop first 3 from List 1:" (drop 3 list1))

(println "Take first 4 from List 2:" (take 4 list2))
(println "Drop first 4 from List 2:" (drop 4 list2))

(println "\n----- THREADING MACRO (->>) -----")

(def result1
  (->> list1
       (filter even?)
       (map #(* % %))
       (reduce +)))

(def result2
  (->> list2
       (filter even?)
       (map #(* % %))
       (reduce +)))

(println "List 1: Sum of squares of even numbers:" result1)
(println "List 2: Sum of squares of even numbers:" result2)