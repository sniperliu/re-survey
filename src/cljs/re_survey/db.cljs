(ns re-survey.db)

(def default-db
  {:name "re-survey"
   :summary {}
   :survey [{:title "Which domains are you interested in clojure/clojurescript?"
             :options ["Web Development"
                       "Data Science"
                       "Artificial Intelligence"
                       "Scientific Calculation"]}]})
