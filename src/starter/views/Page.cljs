(ns starter.views.page
  (:require [starter.services.state :refer [handle-state-change]]))



(defn render [active]
  [:div.Page {:class active}
    [:p {:on-click #(handle-state-change "update-active-view" "")}"Go Back"]
    [:h2 "I'm a page that takes my state"]
[:h2 "I'm a page that takes my state"]
[:h2 "I'm a page that takes my state"]
[:h2 "I'm a page that takes my state"]
[:h2 "I'm a page that takes my state"]
[:h2 "I'm a page that takes my state"]
[:h2 "I'm a page that takes my state"]
[:h2 "I'm a page that takes my state"]
[:h2 "I'm a page that takes my state"]
[:h2 "I'm a page that takes my state"]
[:h2 "I'm a page that takes my state"]
[:h2 "I'm a page that takes my state"]
[:h2 "I'm a page that takes my state"]
[:h2 "I'm a page that takes my state"]
[:h2 "I'm a page that takes my state"]
[:h2 "I'm a page that takes my state"]
[:h2 "I'm a page that takes my state"]
[:h2 "I'm a page that takes my state"]
[:h2 "I'm a page that takes my state"]
[:h2 "I'm a page that takes my state"]
[:h2 "I'm a page that takes my state"]
[:h2 "I'm a page that takes my state"]
[:h2 "I'm a page that takes my state"]
[:h2 "I'm a page that takes my state"]])