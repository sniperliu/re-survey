(ns re-survey.views
    (:require [re-frame.core :as re-frame]))

;; survey
(defn option
  [opt]
  [:div.elem-radio-check
   [:input {:type "checkbox"}]
   [:label opt]])

(defn title
  [t]
  [:label {:class "q-title"} t])

(defn question
  [{t :title options :options}]
  [:div.question
   [title t]
   [:div
    (for [opt options]
      ^{:key opt} [option opt])]])

(defn survey-panel
  []
  (let [srv (re-frame/subscribe [:survey])]
    (fn []
      [:div#main.form
       [:form
        (for [qn @srv]
          ^{:key (:title qn)} [question qn])]])))


;; home

(defn home-panel []
  (let [name (re-frame/subscribe [:name])]
    (fn []
      [:div (str "Hello from " @name ". This is the Home Page.")
       [:div [:a {:href "#/about"} "go to About Page"]]])))


;; about

(defn about-panel []
  (fn []
    [:div "This is the About Page."
     [:div [:a {:href "#/"} "go to Home Page"]]]))


;; main

(defn- panels [panel-name]
  (case panel-name
    :home-panel [home-panel]
    :about-panel [about-panel]
    [:div]))

(defn show-panel [panel-name]
  [panels panel-name])

(defn main-panel []
  (let [active-panel (re-frame/subscribe [:active-panel])]
    (fn []
      [show-panel @active-panel])))
