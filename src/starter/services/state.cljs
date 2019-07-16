(ns starter.services.state
    (:require [reagent.core :as reagent :refer [atom]]
              [starter.services.textstate :refer [update-state-text]]
))

(defonce app-state (atom {:text "Hello world!"
                          :active-page {:example-page false}}))

(defn update-scroll-position [val scroll]
  "Updates the store with our current scroll position to re-position back on home view"
  (if scroll
      (.scrollTo js/window 0 (:scrollOffset @app-state)))
  (swap! app-state conj {:scrollOffset val}))


(defn handle-scroll-func [payload]
  "adds class to body preventing weird scroll on fixed position over scrolling main window"
  (if (= payload "")
    (do
      (.remove (.-classList (.-body js/document)) "hide-scroll")
      (update-scroll-position 0 true)) ; this should be instant
    (do
      (update-scroll-position (.-pageYOffset js/window) false)
      (js/setTimeout #(.add (.-classList (.-body js/document)) "hide-scroll") 100))))

(defn update-state-text [payload]
  "example of updating the state based on the payload"
  (swap! app-state conj {:text payload}))

(defn update-active-view [payload]
  (swap! app-state conj {:active-page {(keyword payload) "active"}})
  (handle-scroll-func payload))

(defn handle-state-change [action payload]
  "Accept an action function to dispatch and passes it the current payload"
  (let [fn-var ((ns-publics 'starter.services.state) (symbol action))]
       (fn-var payload)))
