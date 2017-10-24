;; The first three lines of this file were inserted by DrRacket. They record metadata
;; about the language level of this file in a form that our tools can easily process.
#reader(lib "htdp-intermediate-reader.ss" "lang")((modname find-fold-function) (read-case-sensitive #t) (teachpacks ()) (htdp-settings #(#t constructor repeating-decimal #f #t none #f () #f)))
(define-struct elt (name data subs))

(define F1 (make-elt "F1" 1 empty))
(define F2 (make-elt "F2" 2 empty))
(define F3 (make-elt "F3" 3 empty))
(define D4 (make-elt "D4" 0 (list F1 F2)))
(define D5 (make-elt "D5" 0 (list F3)))
(define D6 (make-elt "D6" 0 (list D4 D5)))

(define (fold-element c1 c2 b e)
  (local [(define (fn-for-element e) ; -> X
            (c1 (elt-name e)    ;String
                 (elt-data e)    ;Integer
                 (fn-for-loe (elt-subs e))))

          (define (fn-for-loe loe) ; -> Y
            (cond [(empty? loe) b]
                  [else
                   (c2 (fn-for-element (first loe))
                        (fn-for-loe (rest loe)))]))]
    (fn-for-element e)))

(define (find n e) (local [(define (c1 s d loe) (if (string=? s n)
                                                    d
                                                    loe))
                           (define (c2 c1 loe) (if (not (false? c1))
                                              c1
                                              loe))]
                     (fold-element c1 c2 false e)))
#;
(define (find n e)
  (local [(define (find--element n e)
            (if (string=? (elt-name e) n)
                (elt-data e) 
                (find--loe n (elt-subs e))))
          
          (define (find--loe n loe)
            (cond [(empty? loe) false]
                  [else
                     (if (not (false? (find--element n (first loe)))) 
                         (find--element n (first loe))
                         (find--loe n (rest loe)))]))]
    
    (find--element n e)))

(find "D6" D6)