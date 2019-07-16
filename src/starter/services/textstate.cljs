(ns starter.services.textstate)
    ; (:require [reagent.core :as reagent :refer [atom]]
    ;           [starter.services.state :refer [app-state]]))

(declare app-state)

(defn update-state-text [payload]
  (print app-state)
  "example of updating the state based on the payload"
  (swap! app-state conj (:text payload)))