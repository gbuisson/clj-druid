(ns clj-druid.client-test
  (:require [clojure.test :refer :all]
            [clj-druid.validations-test :as f]
            [clj-druid.client :refer :all]))


(deftest test-connect-zookeeper
  (connect {:zk {:host "192.168.59.103:2181"
                :discovery-path "/discovery"
                :node-type "broker"}}))


(deftest test-connect-user
  (connect {:hosts ["http://localhost:8082/druid/v2/"]}))


(deftest test-query

  (connect {:zk {:host "192.168.59.103:2181"
                 :discovery-path "/discovery"
                 :node-type "broker"}})

  (query randomized :groupBy f/valid-groupby-query))