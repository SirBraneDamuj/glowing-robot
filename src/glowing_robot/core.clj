(ns glowing-robot.core
  (:gen-class)
  (:require [glowing-robot.cards :as cards]
            [glowing-robot.files :as files]))

(defn -main
  "raggle fraggle"
  [& args]
  (doseq [s cards/sets
          :let [set-list (cards/set-list s)]]
    (println (:set s))
    (doseq [c set-list]
      (files/write-file
        (files/card-filename s c)
        (cards/image c)))))
    
    
