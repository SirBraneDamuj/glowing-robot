(ns indexing.cards
  (:require [clj-http.client :as client]))

(defn root
  [s]
  (str "http://netrunnercards.info" s))

(defn route
  "adds the root URL"
  [s]
  (root (str "/api" s)))

(def sets (read-string (slurp "resources/sets.clj")))

(defn request
  "makes a request"
  [url options]
  (:body (client/get url options)))

(defn request-image
  "gets an image"
  [url]
  (request url {:as :byte-array}))

(defn request-json
  "makes a json request"
  [url]
  (request url {:as :json
                :coerce :always}))

(defn set-list
  "gets the list of cards for a set"
  [s]
  (request-json (route (str "/search/" (:search s)))))

(defn image
  "gets the raw image data for a card"
  [card]
  (request-image (root (:imagesrc card))))
