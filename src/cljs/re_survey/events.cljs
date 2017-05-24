(ns re-survey.events
    (:require [re-frame.core :as re-frame]
              [re-survey.db :as db]))

(re-frame/reg-event-db
 :initialize-db
 (fn  [_ _]
   db/default-db))

(re-frame/reg-event-db
 :set-active-panel
 (fn [db [_ active-panel]]
   (assoc db :active-panel active-panel)))

(re-frame/reg-event-db
 :select-option
 (fn [db [_ title option]]
   (update-in db [:summary title option] (fnil inc 0))))
