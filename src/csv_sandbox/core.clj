(ns csv-sandbox.core
  (:gen-class)
  (:require [clojure.data.csv :as csv]
           [clojure.java.io :as io]))


(defn file->list [path]
  (with-open [input-file (io/reader path)]
    (doall
     (csv/read-csv input-file))))

(defn list->dicts [[header & body]]
  (let [keys (map keyword header)]
    (map #(zipmap keys %)
         body)))

(defn file->dicts [path]
  (list->dicts (file->list path)))

(defn -main
  "I don't do a whole lot ... yet."
  [& args]
  (println "Hello, World!"))
