(ns predicates)

(defn sum-f [f g x]
  (+ (f x) (g x)))

(defn less-than [n]
  (fn [k] (< k n)))

(defn equal-to [n]
  (fn [k] (== k n)))

(defn set->predicate [a-set]
  (fn [a-key] (contains? a-set a-key)))

(defn pred-and [pred1 pred2]
  (fn [x] (and (pred1 x) (pred2 x))))

(defn pred-or [pred1 pred2]
  (fn [x] (or (pred1 x) (pred2 x))))

(defn whitespace? [character]
  (Character/isWhitespace character))

(defn blank? [string]
  (cond
    (= nil string) true
    (empty? string) true
    (every? whitespace? string) true
    :else false))

(defn has-award? [book award]
  (let [awards (:awards book)]
    (contains? awards award)))

(defn HAS-ALL-THE-AWARDS? [book awards]
  (let [book-awards (:awards book)]
    (every? (fn [award] (contains? book-awards award)) awards)))

(defn my-some [pred a-seq]
  (let [mapped (map pred a-seq)
        filtered (filter (fn [x] (= x true) mapped))]
    (first filtered)))

(defn my-every? [pred a-seq]
  :-)

(defn prime? [n]
  :-)
;^^
