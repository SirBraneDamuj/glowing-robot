(ns glowing-robot.files)

(def guid-prefix "bc0f047c-01b1-427f-a439-d451eda")

(defn set-folder
  "gets the folder for a set"
  [s]
  (let [folder (str "Sets/" (:guid s) "/")]
    (.mkdirs (clojure.java.io/file folder))
    folder))

(defn card-guid
  "creates the card guid"
  [id]
  (str guid-prefix id))

(defn card-filename
  "gets the full filename for a card and set"
  [s card]
  (println (:title card))
  (str (set-folder s) (card-guid (:indexkey card)) ".png"))

(defn write-file
  [filename data]
  (with-open [w (clojure.java.io/output-stream filename)]
    (.write w data)))
