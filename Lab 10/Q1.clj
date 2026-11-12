(ns immutable)

(println "----- LIST OPERATIONS -----")

(def my-list '(10 20 30 40))

(println "Original List:" my-list)
(println "First Element:" (first my-list))
(println "Rest of List:" (rest my-list))

(def new-list (conj my-list 5))

(println "Original List after conj:" my-list)
(println "New List after conj:" new-list)


(println "\n----- VECTOR OPERATIONS -----")

(def my-vector [10 20 30 40])

(println "Original Vector:" my-vector)

(def new-vector (conj my-vector 50))

(println "New Vector after conj:" new-vector)
(println "Element at Index 2:" (get my-vector 2))
(println "Count of Elements:" (count my-vector))

(println "Original Vector:" my-vector)


(println "\n----- MAP OPERATIONS -----")

(def my-map {:name "Rahul" :age 20 :course "Cybersecurity"})

(println "Original Map:" my-map)

(def new-map (assoc my-map :city "Delhi"))

(println "New Map after assoc:" new-map)

(def updated-map (dissoc my-map :age))

(println "New Map after dissoc:" updated-map)
(println "Value of name:" (get my-map :name))

(println "Original Map:" my-map)


(println "\n----- SET OPERATIONS -----")

(def my-set #{10 20 30 40})

(println "Original Set:" my-set)

(def new-set (conj my-set 50))

(println "New Set after conj:" new-set)

(def updated-set (disj my-set 20))

(println "New Set after disj:" updated-set)

(println "Contains 30:" (contains? my-set 30))

(println "Original Set:" my-set)