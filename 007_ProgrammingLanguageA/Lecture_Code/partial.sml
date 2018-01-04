

fun sorted3 x y z = z >= y andalso y >= x

fun fold f acc xs = (* fun fold f = fn acc => fn xs => *)
	case xs of 
		[] => acc
	  | x::xs' => fold f f(acc,x) xs'
					   
(* define new function *)
val is_nonnegative = sorted3 0 0 (* fn z => z >= 0 *)
val sum = fold (fn (x,y) => x+y) 0 (* fn xs => sum xs *)

fun is_nonnegative1 x = sorted3 0 0 x
fun sum xs = fold (fn (x,y) => x+y) 0 xs (* unnecessary function wrapping *)

fun range i j = if i > j then [] else i::range (i+1) j

val countup = range 1
val t1 = countup 6 (* [1,2,3,4,5,6] *)

(* exists *)
fun exists predicate xs =
	case xs of 
		[] => false
	  | x::xs' => predicate x orelse exists predicate xs'

val no = exists (fn x => x=7) [3,4,6] (* false *)
val hasZero = exists (fn x => x=0) (* int list -> bool *)

val incrementalAll = List.map (fn x => x+1)
val removeZeros = List.filter (fn x => x <> 0)


(* curry with tupled *)
fun range (i,j) = if i > j then [] else i::range(i+1, j)

val countup = range 1 (* can't work with tupled function *)

fun curry f x y = f (x,y)

val countup1 = (curry range) 1 (* now it works *)

(* uncurry *)
fun uncurry f (x,y) = f x y

(* other curry *)
fun other_curry f x y = f y x
