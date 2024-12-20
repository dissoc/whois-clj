(defproject whois-clj "0.1.0-SNAPSHOT"
  :description "simple whois client for clojure"
  :license {:name "EPL-2.0 OR GPL-2.0-or-later WITH Classpath-exception-2.0"
            :url  "https://www.eclipse.org/legal/epl-2.0/"}
  :dependencies [[commons-net/commons-net "3.11.1"]
                 [org.clojure/clojure "1.11.1"]]
  :repl-options {:init-ns whois-clj.core})
