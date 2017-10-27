;; The first three lines of this file were inserted by DrRacket. They record metadata
;; about the language level of this file in a form that our tools can easily process.
#reader(lib "htdp-beginner-abbr-reader.ss" "lang")((modname space-invaders-starter) (read-case-sensitive #t) (teachpacks ()) (htdp-settings #(#t constructor repeating-decimal #f #t none #f () #f)))


(require 2htdp/universe)
(require 2htdp/image)
;(require lang/htdp-beginner)



;; Space Invaders


;; Constants:

(define WIDTH  300)
(define HEIGHT 500)

(define INVADER-X-SPEED 0.5)  ;speeds (not velocities) in pixels per tick
(define INVADER-Y-SPEED 0.5)
(define TANK-SPEED 2)
(define MISSILE-SPEED 10)

(define HIT-RANGE 10)

(define INVADE-RATE 100)

(define BACKGROUND (empty-scene WIDTH HEIGHT))

(define INVADER
  (overlay/xy (ellipse 10 15 "outline" "blue")              ;cockpit cover
              -5 6
              (ellipse 20 10 "solid"   "blue")))            ;saucer

(define TANK
  (overlay/xy (overlay (ellipse 28 8 "solid" "black")       ;tread center
                       (ellipse 30 10 "solid" "green"))     ;tread outline
              5 -14
              (above (rectangle 5 10 "solid" "black")       ;gun
                     (rectangle 20 10 "solid" "black"))))   ;main body

(define TANK-HEIGHT/2 (/ (image-height TANK) 2))

(define MISSILE (ellipse 5 15 "solid" "red"))



;; Data Definitions:

(define-struct game (invaders missiles t))
;; Game is (make-game  (listof Invader) (listof Missile) Tank)
;; interp. the current state of a space invaders game
;;         with the current invaders, missiles and tank position

;; Game constants defined below Missile data definition

#;
(define (fn-for-game s)
  (... (fn-for-loinvader (game-invaders s))
       (fn-for-lom (game-missiles s))
       (fn-for-tank (game-tank s))))



(define-struct tank (x dir))
;; Tank is (make-tank Number Integer[-1, 1])
;; interp. the tank location is x, HEIGHT - TANK-HEIGHT in screen coordinates
;;         the tank moves TANK-SPEED pixels per clock tick left if dir -1, right if dir 1

(define T0 (make-tank (/ WIDTH 2) 1))   ;center going right
(define T1 (make-tank 50 1))            ;going right
(define T2 (make-tank 50 -1))           ;going left

#;
(define (fn-for-tank t)
  (... (tank-x t) (tank-dx t)))



(define-struct invader (x y dx))
;; Invader is (make-invader Number Number Number)
;; interp. the invader is at (x, y) in screen coordinates
;;         the invader along x by dx pixels per clock tick

(define I1 (make-invader 150 100 12))           ;not landed, moving right
(define I2 (make-invader 150 HEIGHT -10))       ;exactly landed, moving left
(define I3 (make-invader 150 (+ HEIGHT 10) 10)) ;> landed, moving right


#;
(define (fn-for-invader invader)
  (... (invader-x invader) (invader-y invader) (invader-dx invader)))


(define-struct missile (x y))
;; Missile is (make-missile Number Number)
;; interp. the missile's location is x y in screen coordinates

(define M1 (make-missile 150 300))                       ;not hit U1
(define M2 (make-missile (invader-x I1) (+ (invader-y I1) 10)))  ;exactly hit U1
(define M3 (make-missile (invader-x I1) (+ (invader-y I1)  5)))  ;> hit U1

#;
(define (fn-for-missile m)
  (... (missile-x m) (missile-y m)))



(define G0 (make-game empty empty T0))
(define G1 (make-game empty empty T1))
(define G2 (make-game (list I1) (list M1) T1))
(define G3 (make-game (list I1 I2) (list M1 M2) T1))

;; ListOfInvader is one of:
;; - empty
;; - (cons Invader LOI)
;; interp. a list of invaders
(define LOI0 empty)
(define LOI1 (cons I1 empty))
(define LOI2 (cons I1 (cons I2 empty)))
(define LOI3 (cons I1 (cons I2 (cons I3 empty))))

#;
(define (fn-for-loi loi)
  (cond [(false? loi) (...)]
        [else
         (... (fn-for-invader (first loi))
              (fn-for-loi (rest loi)))]))

;; Template rules used:
;; - one-of: 2 cases
;; - atomic distinct: empty
;; - compound: 2 fields
;; - reference: (first loi) is Invader
;; - self-reference: (rest loi) is ListOfInvader

;; ListOfMissile is one of:
;; - empty
;; - (cons Missile LOM)
;; interp. a list of missiles
(define LOM0 empty)
(define LOM1 (cons M1 empty))
(define LOM2 (cons M1 (cons M2 empty)))
(define LOM3 (cons M1 (cons M2 (cons M3 empty))))

#;
(define (fn-for-lom lom)
  (cond [(false? lom) (...)]
        [else
         (... (fn-for-missile (first lom))
              (fn-for-lom (rest lom)))]))

;; Template rules used:
;; - one of: 2 cases
;; - atomic distinct: empty
;; - compound: 2 fields
;; - reference: (first lom) is a Missile
;; - self-reference: (rest lom) is a List Of Missile 

;; Functions

;; Game -> Game
;; start the world with (main G0)
;; 
(define (main s)
  (big-bang s                    ; Game
            (on-tick   tock)     ; Game -> Game
            (to-draw   render)   ; Game -> Image
            (stop-when end-game?)      ; Game -> Boolean
            (on-key    handle-key)))    ; Game KeyEvent -> Game

;; Game -> Game
;; produce the next status of the game

(check-expect (tock (make-game empty empty (make-tank 100 1)))
              (make-game empty empty (make-tank (+ 100 (* TANK-SPEED 1)) 1)))
(check-expect (tock (make-game (cons (make-invader 100 100 10) empty)
                               (cons (make-missile 50 50) empty)
                               (make-tank 100 -1)))
              (make-game (cons (make-invader (+ 100 (* INVADER-X-SPEED 10)) (+ 100 (* INVADER-Y-SPEED 10)) 10) empty)
                         (cons (make-missile 50 (- 50 MISSILE-SPEED)) empty)
                         (make-tank (+ 100 (* TANK-SPEED -1)) -1)))

              
;(define (tock s) s) ; stub

(define (tock s)
  (make-game (control-invaders (game-invaders s) (game-missiles s))
       (control-missiles (game-missiles s))
       (control-tank (game-t s))))

;; ListOfInvaders -> ListOfInvaders
;; produces a next list of invaders moving by dx and INVADER-X-SPEED, INVADER-Y-SPEED
;;  turn back if INVADER reach the walls
;;  creates an invader after 100 ticks
;;  removes any invaders that are shoot down.

(define (control-invaders loi lom)
  (filter-invaders (move-invaders (create-an-invader loi)) lom))

;; ListOfInvaders -> ListOfInvaders
;; inserts an invader randomly by the chance of 30%

;(define (create-an-invader loi) loi) ; stub

(define (create-an-invader loi)
  (if (< (random 10) 1) ; 30% chance to create a new invader
      (cons (make-invader (random 300) 0 (random 10)) loi)
      loi))

;; ListOfInvaders -> ListOfInvaders
;; produces the next invaders after a tick
;;  if any invader hits the walls, turn back; change dx to the opposite
(check-expect (move-invaders empty) empty)
(check-expect (move-invaders (list (make-invader 100 100 10)))
              (list (make-invader (+ 100 (* 10 INVADER-X-SPEED)) (+ 100 (* (abs 10) INVADER-Y-SPEED)) 10)))
(check-expect (move-invaders (list (make-invader 100 100 10) (make-invader 150 150 -10)))
              (list (make-invader (+ 100 (*  10 INVADER-X-SPEED)) (+ 100 (*  (abs 10) INVADER-Y-SPEED))  10)
                    (make-invader (+ 150 (* -10 INVADER-X-SPEED)) (+ 150 (* (abs -10) INVADER-Y-SPEED)) -10)))
(check-expect (move-invaders (list (make-invader 290 200 10) (make-invader 10 100 -10)))
              (list (make-invader (+ 290 (* -10 INVADER-X-SPEED)) (+ 200 (* (abs -10) INVADER-Y-SPEED)) -10)
                    (make-invader (+ 10 (* 10 INVADER-X-SPEED))   (+ 100 (* (abs 10)  INVADER-Y-SPEED))  10)))

;(define (move-invaders loi) loi) ;stub

(define (move-invaders loi)
  (cond [(empty? loi) empty]
        [else
         (if (hit-wall? (first loi))
             (cons (move-an-invader (change-dx (first loi)))      (move-invaders (rest loi)))
             (cons (move-an-invader (first loi)) (move-invaders (rest loi))))]))

;; Invader -> Boolean
;; produces true if the invader hit the walls, meaning x <= 10 or x >= 290
(check-expect (hit-wall? (make-invader 50 50 10))   false)
(check-expect (hit-wall? (make-invader 9 100 -10))   true)
(check-expect (hit-wall? (make-invader 291 200 10))  true)


;(define (hit-wall? i) false) ;stub

(define (hit-wall? i)
  (cond [(and (<= (invader-x i) 10) (< (invader-dx i) 0))
         true]
        [(and (>= (invader-x i) 290) (> (invader-dx i) 0))
         true]
        [else false]))

;; Invader -> Invader
;; change the dx to the (- dx)

(define (change-dx i)
  (make-invader (invader-x i) (invader-y i) (- (invader-dx i))))

;; Invader -> Invader
;; produces the next invader by increasing x and y by (* dx INVADER-X-SPEED)

(define (move-an-invader i)
  (make-invader (+ (invader-x i) (* (invader-dx i) INVADER-X-SPEED))
                (+ (invader-y i) (* (abs (invader-dx i)) INVADER-Y-SPEED))
                (invader-dx i))) ; stub

;; ListOfInvaders ListOfMissiles -> ListOfInvaders
;; removes any invader that hits by missiles, x-missile in [x-10, x+10] of invaders and y-missile - y-invader < HIT-RANGE 
(check-expect (filter-invaders empty empty) empty)
(check-expect (filter-invaders (list (make-invader 150 100 10)) (list (make-missile 150 50))) (list (make-invader 150 100 10)))
(check-expect (filter-invaders (list (make-invader 150 100 10) (make-invader 100 200 10)) (list (make-missile 105 209))) (list (make-invader 150 100 10)))
(check-expect (filter-invaders (list (make-invader 150 100 10) (make-invader 100 200 10)) (list (make-missile 145 108)))
              (list (make-invader 100 200 10)))

;(define (filter-invaders loi lom) loi) ; stub

(define (filter-invaders loi lom)
  (cond [(empty? loi) empty]
        [else
         (if (hit-missile? (first loi) lom)
             (filter-invaders (rest loi) lom)
             (cons (first loi) (filter-invaders (rest loi) lom)))]))

;; Invader ListOfMissiles -> Boolean
;; produces true if the invader hit by any missile

(define (hit-missile? i lom)
  (cond [(empty? lom) false]
        [else
         (if (hit-invader? i (first lom))
             true
             (hit-missile? i (rest lom)))]))

;; Invader Missile -> Boolean
;; produces true if the missile hits the invader

(define (hit-invader? i m)
  (if (and (< (missile-x m) (+ (invader-x i) 10))
           (> (missile-x m) (- (invader-x i) 10))
           (< (abs (- (missile-y m) (invader-y i))) HIT-RANGE))
      true
      false))
  
;; ListOfMissiles -> ListOfMissiles
;; produces a next list of missiles moving by y direction a MISSILE-SPEED
;; the missile is disappeared when reach y = -15
(check-expect (control-missiles empty) empty)
(check-expect (control-missiles (cons (make-missile 50 50) empty))
              (cons (make-missile 50 (- 50 MISSILE-SPEED)) empty))
(check-expect (control-missiles (cons (make-missile 50 50) (cons (make-missile 100 -15) empty)))
              (cons (make-missile 50 (- 50 MISSILE-SPEED)) empty))

;(define (control-missiles lom) lom) ; stub

(define (control-missiles lom)
  (filter-missiles (increase-missiles lom)))


;; ListOfMissile -> ListOfMissile
;; produces a next list of missiles moving by y direction a MISSILE-SPEED

(define (increase-missiles lom)
  (cond [(empty? lom) empty]
        [else
         (cons (increase-a-missile (first lom))
               (increase-missiles (rest lom)))]))

;; Missile -> Missile
;; produces a next missile

(define (increase-a-missile m)
  (make-missile (missile-x m) (- (missile-y m) MISSILE-SPEED)))

;; ListOfMissile -> ListOfMissile
;; removes all the missiles that reach over the screen, y <= -15

;(define (filter-missiles lom) lom) ;stub

(define (filter-missiles lom)
  (cond [(empty? lom) empty]
        [else
         (cond [(over-high? (first lom))
                (filter-missiles (rest lom))]
               [else
                (cons (first lom) (filter-missiles (rest lom)))])]))

;; Missile -> Boolean
;; return true if a missile over the screen, y <= -15

(define (over-high? m)
  (if (<= (missile-y m) -15)
      true
      false))



;; Tank -> Tank
;; produces a next tank, moves a TANK-SPEED pixel to right if dir = 1, otherwise to left
;; if the tank hit the edges, turn back, tank-x <= 15 or >= 285, change dir = - dir
(check-expect (control-tank (make-tank 50 1)) (make-tank (+ 50 (* 1 TANK-SPEED)) 1))
(check-expect (control-tank (make-tank 50 -1)) (make-tank (+ 50 (* -1 TANK-SPEED)) -1))
(check-expect (control-tank (make-tank 15 -1)) (make-tank (+ 15 (* 1 TANK-SPEED)) 1))
(check-expect (control-tank (make-tank 285 1)) (make-tank (+ 285 (* -1 TANK-SPEED)) -1))

;(define (control-tank t) t) ; stub

(define (control-tank t)
  (cond [(or (<= (tank-x t) 15) (>= (tank-x t) 285))
         (make-tank (+ (tank-x t) (* (- (tank-dir t)) TANK-SPEED)) (- (tank-dir t)))]
        [else
         (make-tank (+ (tank-x t) (* (tank-dir t) TANK-SPEED)) (tank-dir t))]))

;; Game -> Image
;; produces an image with a game status

(check-expect (render (make-game LOI0 LOM0 T0)) (place-image TANK (tank-x T0) (- HEIGHT TANK-HEIGHT/2)
                                                    BACKGROUND))
(check-expect (render (make-game LOI1 LOM1 T1))
              (place-image TANK (tank-x T1) (- HEIGHT TANK-HEIGHT/2)
                           (place-image INVADER (invader-x I1) (invader-y I1)
                                        (place-image MISSILE (missile-x M1) (missile-y M1)
                                                     BACKGROUND))))
(check-expect (render (make-game LOI2 LOM2 T2))
              (place-image TANK (tank-x T2) (- HEIGHT TANK-HEIGHT/2)
                           (place-image INVADER (invader-x I1) (invader-y I1)
                                        (place-image MISSILE (missile-x M1) (missile-y M1)
                                                     (place-image INVADER (invader-x I2) (invader-y I2)
                                                                  (place-image MISSILE (missile-x M2) (missile-y M2)
                                                                               BACKGROUND))))))              
;(define (render s) BACKGROUND) ; stub

(define (render s)
  (place-images (append (render-invaders (game-invaders s))
                        (render-missiles (game-missiles s))
                        (list TANK))
                (append (posn-invaders (game-invaders s))
                        (posn-missiles (game-missiles s))
                        (list (make-posn (tank-x (game-t s)) (- HEIGHT TANK-HEIGHT/2))))
                BACKGROUND))

;; ListOfInvader -> ListOfImages
;; produces the images of all invaders
(check-expect (render-invaders LOI2)
              (list INVADER INVADER empty-image))
;(define (render-invaders loi) BACKGROUND) ; stub

(define (render-invaders loi)
  (cond [(empty? loi) (list empty-image)]
        [else
         (append (list INVADER) (render-invaders (rest loi)))]))


;; ListOfMissiles -> ListOfImages
;; produces the images of all missiles

;(define (render-missiles lom) (list empty-image)) ; stub

(define (render-missiles lom)
  (cond [(empty? lom) (list empty-image)]
        [else
         (append (list MISSILE) (render-missiles (rest lom)))]))

;; ListOfInvaders -> ListOfPosn
;; produces a list of positions of the invaders

;(define (posn-invaders loi) (make-posn 0 0)) ; stub

(define (posn-invaders loi)
  (cond [(empty? loi) (list (make-posn 0 0))]
        [else
         (append (list (make-posn (invader-x (first loi)) (invader-y (first loi)))) (posn-invaders (rest loi)))]))

;; ListOfMissiles -> ListOfPosn
;; produces a list of positions of the missiles

;(define (posn-missiles lom) (list (make-posn 0 0))) ; stub

(define (posn-missiles lom)
  (cond [(empty? lom) (list (make-posn 0 0))]
        [else
         (append (list (make-posn (missile-x (first lom)) (missile-y (first lom)))) (posn-missiles (rest lom)))]))

;; Game KeyEvent -> Game
;; produces a new missile with the x position equals to x position of the tank when "space" is down
;;  change the tank dir to negative if "left" is down, to positive if "right" is down
(check-expect (handle-key (make-game empty empty (make-tank 100  1))     "a") (make-game empty empty (make-tank 100  1)))
(check-expect (handle-key (make-game empty empty (make-tank 100  1))  "left") (make-game empty empty (make-tank 100 -1)))
(check-expect (handle-key (make-game empty empty (make-tank 100 -1))  "left") (make-game empty empty (make-tank 100 -1)))
(check-expect (handle-key (make-game empty empty (make-tank 100 -1)) "right") (make-game empty empty (make-tank 100  1)))
(check-expect (handle-key (make-game empty empty (make-tank 100  1)) "right") (make-game empty empty (make-tank 100  1)))

(check-expect (handle-key (make-game empty empty (make-tank 100  1)) " ")
              (make-game empty (list (make-missile 100 (- HEIGHT TANK-HEIGHT/2))) (make-tank 100 1)))
(check-expect (handle-key (make-game empty (list (make-missile 150 50)) (make-tank 200 -1)) " ")
              (make-game empty (list (make-missile 200 (- HEIGHT TANK-HEIGHT/2)) (make-missile 150 50)) (make-tank 200 -1)))
              
;(define (handle-key s ke) s) ; stub

(define (handle-key s ke)
  (cond [(key=? ke "left")  (make-game (game-invaders s) (game-missiles s)                (move-to-left (game-t s)))]
        [(key=? ke "right") (make-game (game-invaders s) (game-missiles s)               (move-to-right (game-t s)))]
        [(key=? ke " ") (make-game (game-invaders s) (shoot-a-missile (game-missiles s) (game-t s)) (game-t s))]
        [else s]))

;; ListOfMissiles Tank -> ListOfMissiles
;; produces a new missile at the x postition of the tank

;(define (shoot-a-missile lom t) lom) ; stub

(define (shoot-a-missile lom t)
  (append (list (make-missile (tank-x t) (- HEIGHT TANK-HEIGHT/2))) lom))

;; Tank -> Tank
;; changes the tank dir to 1

;(define (move-to-right t) t) ;stub

(define (move-to-right t)
  (make-tank (tank-x t) 1))

;; Tank -> Tank
;; changes the tank dir to -1

;(define (move-to-left t) t) ; stub

(define (move-to-left t)
  (make-tank (tank-x t) -1))

;; Game -> Boolean
;; stop the world state if any invaders reach the bottom
(check-expect (end-game? (make-game empty empty (make-tank 100 1))) false)
(check-expect (end-game? (make-game (list (make-invader 50 100 10)) empty (make-tank 100 1))) false)
(check-expect (end-game? (make-game (list (make-invader 100 501 -10)) empty (make-tank 200 -1))) true)

;(define (end-game? s) false) ; stub

(define (end-game? s)
  (if (check-invaders? (game-invaders s))
      true
      false))

;; ListOfInvaders -> Boolean
;; return true if any invaders reach the bottom, y > 500

(define (check-invaders? loi)
  (cond [(empty? loi) false]
        [else
         (if (> (invader-y (first loi)) 500)
             true
             (check-invaders? (rest loi)))]))

(main G0)