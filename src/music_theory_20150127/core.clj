;; ref.
;; https://github.com/overtone/overtone/blob/master/src/overtone/music/pitch.clj

(ns music-theory-20150127.core
  (:use [overtone.live]
        [overtone.inst.sampled-piano]))

(defn play-chord [root quality]
  (doseq [note (chord root quality)]
    (sampled-piano note)))

(defn play [chords]
  (let [time (now)]
    (doseq [a-chord chords]
      (let [t       (+ time (a-chord 0))
            root    (a-chord 1)
            quality (a-chord 2)]
        (at t (play-chord root quality))))))

;; fly me to the moon
(defn fly-me []
  (play [[0    :A4 :minor7]
         [1600 :D4 :minor7]
         [3200 :G4 :7]
         [4800 :C4 :major7]]))

;;; dominant demo
;; (play-chord :C4 :major)
;; (stop-all)
;; (play-chord :G3 :7)

;; basics
(defn basic-0 []
  (play [[0    :C4 :major7]
         [1000 :D4 :minor7]
         [2000 :E4 :minor7]
         [3000 :F4 :major7]
         [4000 :G4 :7]
         [5000 :A4 :minor7]
         [6000 :B4 :m7-5]]))

(defn basic-1 []
  (play [[0    :C4 :major7]
         [1000 :C4 :major7]
         [2000 :C4 :major7]
         [3000 :C4 :major7]]))

(defn basic-2 []
  (play [[0    :C4 :major7]
         [1000 :C4 :major7]
         [2000 :E4 :minor7]
         [3000 :C4 :major7]]))

(defn basic-3 []
  (play [[0    :C4 :major7]
         [1000 :C4 :major7]
         [2000 :G3 :7]
         [3000 :C4 :major7]]))

(defn basic-4 []
  (play [[0    :C4 :major7]
         [1000 :F3 :major7]
         [2000 :G3 :7]
         [3000 :C4 :major7]]))

(defn basic-5 []
  (play [[0    :E4  :minor7]
         [1000 :D4  :minor7]
         [2000 :Db4 :7]
         [3000 :C4  :major7]]))

;; inner urge
(def ^:private maj7+11 #{0 4 7 11 18})
(def ^:private maj7-5+13 #{0 4 6 11 21})
(def ^:private maj7-5    #{0 4 6 11})

(defn inner-1 []
  (play [[0    :F#4 :m7-5]
         [1000 :F#4 :m7-5]
         [2000 :F#4 :m7-5]
         [3000 :F#4 :m7-5]
         [4000 :F4  maj7+11]
         [5000 :F4  maj7+11]
         [6000 :F4  maj7+11]
         [7000 :F4  maj7+11]]))

(defn inner-2 []
  (play [[0000 :C4 maj7-5+13]
         [1000 :C4 maj7-5+13]
         [2000 :C4 maj7-5+13]
         [3000 :C4 maj7-5+13]
         [4000 :F4 maj7+11]
         [5000 :F4 maj7+11]
         [6000 :F4 maj7+11]
         [7000 :F4 maj7+11]]))

(defn inner-2-1 []
  (play [[0000 :C4 maj7-5]
         [1000 :C4 maj7-5]
         [2000 :C4 maj7-5]
         [3000 :C4 maj7-5]
         [4000 :F4 maj7+11]
         [5000 :F4 maj7+11]
         [6000 :F4 maj7+11]
         [7000 :F4 maj7+11]]))

(defn inner-3 []
  (play [[0000  :C4  maj7-5]
         [1000  :C4  maj7-5]
         [2000  :C4  maj7-5]
         [3000  :C4  maj7-5]
         [4000  :F4  maj7+11]
         [5000  :F4  maj7+11]
         [6000  :F4  maj7+11]
         [7000  :F4  maj7+11]
         [8000  :Eb4 maj7+11]
         [9000  :Eb4 maj7+11]
         [10000 :Eb4 maj7+11]
         [11000 :Eb4 maj7+11]
         [12000 :Db4 maj7+11]
         [13000 :Db4 maj7+11]
         [14000 :Db4 maj7+11]
         [15000 :Db4 maj7+11]]))

(defn inner-4 []
  (play [[0000 :E4  maj7+11]
         [1000 :Db4 maj7+11]
         [2000 :D4  maj7+11]
         [3000 :B3  maj7+11]
         [4000 :C4  :major7]
         [5000 :A3  :major7]
         [6000 :Bb3 :7]
         [7000 :G3  :major7]]))

(defn inner-5 []
  (play [[0000 :Bb3 :7]
         [1000 :G3  :major7]
         [2000 :C4 #{0 4 11 18}]]))

;; proto cosmos

(defn proto-1 []
  (play [[000  :F#4 :m9]
         [500  :E4  :m9]
         [1000 :D4  :m9]]))

(defn proto-2 []
  (play [[000  :F#4 :m9]
         [500  :E4  :m9]
         [1000 :D4  :m9]
         [1500 :C#4 :m9]]))

(defn proto-2-1 []
  (play [[0 :C#4 :m9]]))

;; (proto-1)
;; (stop-all)
;; (proto-2-1)

(defn proto-3 []
  (play [[0000  :C#4 :m9]
         [1000  :C#4 :m9]
         [2000  :C#4 :m9]
         [3000  :C#4 :m9]
         [4000  :A3  maj7+11]
         [5000  :A3  maj7+11]
         [6000  :A3  maj7+11]
         [7000  :A3  maj7+11]
         [8000  :C4  :major7]
         [9000  :B3  :major7]
         [10000 :E4  :minor7]
         [11000 :A3  #{0 7 10 14 17}]]))

(defn proto-4 []
  (play [[0000 :C4  :major7]
         [1000 :B3  :major7]
         [2000 :E4  :minor7]
         [3000 :A3  #{0 7 10 14 17}]]))

(stop-all)
(proto-1)

;; teen town
(defn teen-1 []
  (play [[0000 :C4 :7]
         [1500 :A3 :7]
         [3000 :F4 :7]
         [4500 :D4 :7]]))

(defn teen-2 []
  (play [[0000 :A3 :7]
         [1500 :F4 :7]
         [3000 :D4 :7]
         [4500 :C4 :7]]))

(defn teen-3 []
  (play [[0000 :F4 :7]
         [1500 :D4 :7]
         [3000 :C4 :7]
         [4500 :A3 :7]]))

(defn teen-4 []
  (play [[0000 :D4 :7]
         [1500 :C4 :7]
         [3000 :A3 :7]
         [4500 :F4 :7]]))

;; spiral
(defn spiral-1 []
  (play [[0    :F#4 #{0   10 14 17 21}]
         [1200 :E4  #{0   10 14 17 21}]
         [2400 :Eb4 #{0   10 14 17 21}]
         [3000 :F4  #{0   10 14 17 21}]
         [3600 :G4  #{0   10 14 17 21}]
         [4200 :Ab4 #{0   10 14 17 21}]]))

(defn sus7-1 []
  (play [[0 :G3 :7sus4]]))

(defn min7on4 []
  (play [[0 :G3 #{0 7 10 14 17}]]))

(defn maj7on2 []
  (play [[0 :G3 #{0   10 14 17 21}]]))

;; windows

(defn win-1 []
  (play [[0000 :Ab3 :7]
         [1000 :A3  :7]
         [2000 :Ab3 :7]
         [3000 :A3  :7]]))

(defn fiesta-1 []
  (play [[0000 :E4 :major]
         [1000 :E4 :major]
         [2000 :F4 :major]
         [3000 :F4 :major]
         [4000 :G4 :major]
         [5000 :F4 :major]
         [6000 :E4 :major]
         [7000 :E4 :major]]))

(defn win-2 []
  (play [[0000 :Ab3 :major7]
         [1000 :A3  :7]
         [2000 :Ab3 :major7]
         [3000 :A3  :7]]))

;; humpty dumpty
(defn humpty-1 []
  (play [[0000 :Eb4 :major7]
         [1000 :D4  :major7]
         [2000 :Gb4 :major7]
         [3000 :F4  :major7]]))

(defn humppty-2 []
  (play [[0000 :A3  :7]
         [1000 :Bb3 :major7]
         [2000 :Bb3 :minor7]
         [3000 :Bb3 :minor7]]))

(defn humpty-3 []
  (play [[0000 :Bb3 :minor7]
         [1000 :Bb3 :minor7]
         [2000 :D4  :minor7]
         [3000 :B3  :minor7]
         [4000 :Ab3 :minor7]
         [5000 :Ab3 :minor7]
         [6000 :F3  :minor7]
         [7000 :Ab3 :minor7]
         [8000 :Gb3 :major7]
         [9000 :Bb3 :7]]))

(defn humpty-4 []
  (play [[0000 :Gb3 :major7]
         [1000 :Bb3 :7]
         [2000 :Eb3 :major7]]))

(defn humpty-5 []
  (play [[0000 :Gb3 :major7]
         [1000 :E3  :major7]
         [2000 :D3  :7]
         [3000 :Db3 :minor7]
         [3500 :Gb3 :7]
         [4000 :B3  :major7]
         [5000 :Bb3 :7]
         [6000 :Eb4 :minor7]
         [7000 :C4  :minor7]
         [7500 :A4  :minor7]]))

;; peg
(def ^:private dom7+9 #{0 4 7 10 14})

(defn peg-1 []
  (play [[0000 :G4  :major7]
         [1000 :F#4 dom7+9]
         [2000 :F4  :major7]
         [3000 :E4  dom7+9]
         [4000 :Eb4 :major7]
         [5000 :D4  dom7+9]]))
