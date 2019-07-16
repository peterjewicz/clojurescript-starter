(ns starter.core
    (:require [reagent.core :as reagent :refer [atom]]
              [starter.components.textbox :as textbox]
              [starter.views.page :as page]
              [starter.services.state :refer [app-state handle-state-change]]))

(enable-console-print!)

(defn core []
  [:div.Main
    [:p {:on-click #(handle-state-change "update-state-text" "New Text")} "Click to update state text"]
    [textbox/render (:text @app-state)]
    [page/render (:example-page (:active-page @app-state))]
    [:h3 {:on-click #(handle-state-change "update-active-view" "example-page")} "click me to open a new page"]])

(reagent/render-component [core]
                          (. js/document (getElementById "app")))

(defn on-js-reload []
  ;; optionally touch your app-state to force rerendering depending on
  ;; your application
  ;; (swap! app-state update-in [:__figwheel_counter] inc)
)
