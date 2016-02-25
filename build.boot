#!/usr/bin/env boot
(set-env!
 :resource-paths #{"src"}
 :dependencies '[[org.clojure/clojure "1.8.0" :scope "provided"]
                 [org.clojure/tools.logging "0.3.1"]
                 [newrelic-platform/metrics-publish "2.0.1"]
                 [com.novemberain/langohr "3.5.1"]])

(deftask build
  "Builds an uberjar of this project that can be run with java -jar"
  []
  (comp
   (aot :namespace '#{pivotal-agent})
   (pom :project 'pivotal-agent
        :version "1.0.0")
   (uber)
   (jar :main 'pivotal-agent :file "pivotal-agent.jar")))

(defn -main [& args]
  (require 'clj-pivotal-agent)
  (apply (resolve 'pivotal-agent/-main) args))
