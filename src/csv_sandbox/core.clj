(ns csv-sandbox.core
  (:gen-class)
  (:require [clojure.data.csv :as csv]
           [clojure.java.io :as io]))





(defn file->list [path]
  (with-open [input-file (io/reader path)]
    (doall
     (csv/read-csv input-file))))

(defn list->dicts [[header & body]]
  (map (fn [line]
         (reduce
          (fn [val [k v]] (assoc val (keyword k) v))
          {}
          (map (fn [k v] [k v]) header line)))
       body))

(defn file->dicts [path]
  (list->dicts (file->dicts path)))

(defn -main
  "I don't do a whole lot ... yet."
  [& args]
  (println "Hello, World!"))
