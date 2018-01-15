
#lang racket

(provide (all-defined-out)) ;; so we can put tests in a second file

;; put your code below

(define (sequence l h s)
  (if (> l h)
      null
      (cons l (sequence (+ l s) h s))))

(define (string-append-map xs suf)
  (map (lambda (x) (string-append x suf)) xs))

(define (list-nth-mod xs n)
  (cond [(< n 0) (error "list-nth-mod: negative number")]
        [(null? xs) (error "list-nth-mod: empty list")]
        [(car (list-tail xs (remainder n (length xs))))]))

(define ones
  (lambda () (cons 1 ones)))

;(define (stream x)
;  (lambda () (cons x (stream (* x 2)))))

(define (stream-for-n-steps s n)
  (if (= n 0)
      null
      (cons (car (s)) (stream-for-n-steps (cdr (s)) (- n 1)))))

(define funny-number-stream
  (letrec ([f (lambda (x) (if (= (remainder x 5) 0)
                              (cons (- x) (lambda () (f (+ x 1))))
                              (cons x (lambda () (f (+ x 1))))))])
    (lambda () (f 1))))

(define dan-then-dog
  (letrec ([x "dan.jpg"]
           [y "dog.jpg"]
           [f1 (lambda () (cons x (lambda () (f2))))]
           [f2 (lambda () (cons y (lambda () (f1))))])
    (lambda () (f1))))

(define (stream-add-zero s)
  (lambda () (cons (cons 0 (car (s))) (stream-add-zero (cdr (s))))))

(define (cycle-lists xs ys)
  (letrec ([f (lambda (n) 
                (cons (cons (list-nth-mod xs n) (list-nth-mod ys n))
                      (lambda () (f (+ n 1)))))])
    (lambda () (f 0))))

(define (vector-assoc v vec)
  (letrec ([f (lambda (x) (if (> x (vector-length vec))
                              #f
                              (if (equal? v (car (vector-ref vec x)))
                                  (vector-ref vec x)
                                  (f (+ x 1)))))])
    (f 0)))

(define (cached-assoc xs n)
  (letrec ([cached (make-vector n #f)]
           [y 0]
           [f (lambda (v)
                (letrec ([h (lambda (x) (cond [(>= x n) #f]
                                              [(equal? #f (vector-ref cached x)) #f]
                                              [(equal? v (car (vector-ref cached x))) (vector-ref cached x)]
                                              [else (h (+ x 1))]))]
                         [ans (h 0)])
                  (if ans
                      (begin (print "Using cached") ans)
                      (let ([new-ans (assoc v xs)])
                        (if new-ans
                            (begin (vector-set! cached y new-ans)
                                   (set! y (+ y 1))
                                   (print "Not Using Cached")
                                   (print cached)
                                   new-ans)
                            new-ans)))))])
    f))
                        
                                     
                        
