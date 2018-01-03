

val sorted3 = fn x => fn y => fn z => z >= y andalso y >= x

val t2 = sorted3 7 9 11

fun sorted3_nicer x y z = z >= y andalso y >= x

val t3 = sorted3_nicer 7 9 11

fun fold f acc xs = (* fun fold f = fn acc => fn xs => *)
	case xs of 
		[] => acc
	  | x::xs' => fold f f(acc,x) xs'
					   
fun sum xs = fold (fn (x,y) => x+y) 0 xs
