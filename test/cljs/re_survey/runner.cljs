(ns re-survey.runner
    (:require [doo.runner :refer-macros [doo-tests]]
              [re-survey.core-test]))

(doo-tests 're-survey.core-test)
