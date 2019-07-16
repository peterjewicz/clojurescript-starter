(ns starter.services.state
    (:require [reagent.core :as reagent :refer [atom]]
              [starter.services.textstate :refer [update-state-text]]
))

(defonce app-state (atom {:text "Hello world!"
                          :active-page {:example-page false}}))

; TODO move these two scrolling functions into a state helper file
; Don't want them cluttering up this namespace
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



(defn update-active-view [app-state payload]
  (swap! app-state conj {:active-page {(keyword payload) "active"}})
  (handle-scroll-func payload))


(defmulti handle-state-change (fn [action] (:type action)))
  (defmethod handle-state-change "update-active-view"
    [action]
    (update-active-view app-state (:value action)))
  (defmethod handle-state-change "update-state-text"
    [action]
    (update-state-text app-state (:value action)))