

fun increment_n_times_lame (n,x) =
	if n=0
	then x
	else 1 + increment_n_times_lame(n-1,x)

fun double_n_times_lame (n,x) =
	if n=0
	then x
	else 2 * double_n_times_lame(n-1,x)

fun nth_tail_lame (n,xs) =
	if n=0
	then xs
	else tl (nth_tail_lame(n-1,xs))

fun n_times (f,n,x) =
	if n=0
	then x
	else f (n_times(f, n-1, x))

fun increment x = x+1
fun double x = 2*x

val x1 = n_times(double,4,7)
val x2 = n_times(increment,4,7)
val x3 = n_times(tl,2,[2,3,4,5])

fun addition(n,x) = n_times(increment,n,x)
fun double_n_times(n,x) = n_times(double,n,x)
fun nth_tail(n,xs) = n_times(tl,n,xs)

(* high-order function without polymorphic *)
fun times_until_zero (f,x) =
	if x=0 then 0 else 1 + times_until_zero (f, f x)
(* (int -> int) * int -> int *)

(* first-order function with polymorphic *)
fun len xs = 
	case xs of 
		[] => 0
	  | _::xs' => 1 + len xs'

