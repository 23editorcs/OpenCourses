
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