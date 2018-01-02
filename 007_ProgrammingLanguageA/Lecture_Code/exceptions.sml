
fun hd xs = 
	case xs of 
		[] => raise List.Empty
	  | x::_ => x

exception MyUndesirableCondition
exception MyOtherCondition of int*int

fun maxlist (xs, ex) = (* int list * exn -> int *)
	case xs of
		[] => raise ex
	  | x::[] => x
	  | x::xs' => Int.max(x, maxlist(xs', ex))

val w = maxlist([3,4,5], MyUndesirableCondition)

val x = maxlist([], MyUndesirableCondition)
		handle MyUndesirableCondition => 42
