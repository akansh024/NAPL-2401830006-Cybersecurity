
(defn my-error []
  (throw (ex-info "Custom Error" {:type :error})))

(try
  (/ 10 0)
  (catch ArithmeticException e
    (println "Arithmetic Error"))
  (finally
    (println "First block completed")))

(try
  (.length nil)
  (catch NullPointerException e
    (println "Null Pointer Error"))
  (finally
    (println "Second block completed")))

(try
  (my-error)
  (catch clojure.lang.ExceptionInfo e
    (println "Custom Error:" (ex-message e))
    (println "Error Data:" (ex-data e))
    (println "Program recovered"))
  (finally
    (println "Third block completed")))
