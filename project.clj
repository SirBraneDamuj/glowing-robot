(defproject indexing "0.1.0"
  :description "A:NR image downloader from netrunnercards.info"
  :license {:name "Eclipse Public License"
            :url "http://www.eclipse.org/legal/epl-v10.html"}
  :dependencies [[org.clojure/clojure "1.5.1"]
                 [clj-http "0.7.6"]]
  :main indexing.core
  :profiles {:uberjar {:aot :all}})
