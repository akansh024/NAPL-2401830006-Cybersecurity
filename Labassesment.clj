(ns data-pipeline.app
  (:require [clojure.data.json :as json]
            [next.jdbc :as jdbc]
            [ring.adapter.jetty :as jetty]))

(def dataset
  [{:id 1 :name "Akansh"   :score 88 :active true}
   {:id 2 :name "hrishit"  :score 92 :active true}
   {:id 3 :name "aditya"   :score 45 :active false}
   {:id 4 :name "kartikey" :score 76 :active true}])

(def processed
  (->> dataset
       (filter :active)
       (map (fn [x] {:id (:id x)
                     :name (.toUpperCase (:name x))
                     :score (:score x)
                     :date (str (java.util.Date.))}))))

(def total
  (reduce + (map :score processed)))

(def ds (jdbc/get-datasource {:dbtype "sqlite" :dbname "app.db"}))

(defn save-to-db! []
  (try
    (jdbc/execute! ds ["CREATE TABLE IF NOT EXISTS students (id INT PRIMARY KEY, name TEXT, score INT, date TEXT)"])
    (doseq [s processed]
      (jdbc/execute! ds ["INSERT OR REPLACE INTO students VALUES (?, ?, ?, ?)"
                         (:id s) (:name s) (:score s) (:date s)]))
    (catch Exception e
      (println "Write error:" (.getMessage e)))))

(defn read-from-db []
  (try
    (jdbc/execute! ds ["SELECT * FROM students"])
    (catch Exception e
      {:error (.getMessage e)})))

(defn handler [_]
  {:status  200
   :headers {"Content-Type" "application/json"}
   :body    (json/write-str {:total total :students (read-from-db)})})

(defn -main [& _]
  (save-to-db!)
  (jetty/run-jetty handler {:port 3000 :join? true}))

(apply -main *command-line-args*)