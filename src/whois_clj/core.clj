(ns whois-clj.core
  (:require
   [clojure.string :as s :refer [lower-case split-lines trim triml]])
  (:import
   (org.apache.commons.net.whois WhoisClient)))

(defn string->kw [s]
  (-> s
      trim
      lower-case
      (s/replace " " "-")
      keyword))

(def stop-keys #{"URL of the ICANN Whois Inaccuracy Complaint Form"
                 ">>> Last update of whois database"
                 "NOTICE"
                 "TERMS OF USE"})

(defn parse
  "basic parser"
  [response]
  (loop [elements (split-lines response)
         result   {}]
    (let [[k v] (map triml (-> elements first (s/split #":")))]
      (if (or (contains? stop-keys k) (empty? k))
        result
        (let [kw (string->kw k)]
          (recur (rest elements)
                 (update result kw #(if %
                                      (if (vector? %)
                                        (conj % v)
                                        [% v])
                                      v))))))))

(defn whois [host]
  (let [client (new WhoisClient)
        _      (.connect client WhoisClient/DEFAULT_HOST)
        result (.query client host)]
    (parse result)))
