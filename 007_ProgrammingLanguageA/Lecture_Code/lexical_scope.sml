(* Lexical Scope *)

val x = 1
(* x maps to 1 *)
fun f y = x + y
(* f maps to a function adds 1 to its argument *)
val x = 2
(* x maps to 2 *)
val y = 3
(* y maps to 3 *)
val z = f (x + y)
(* f maps to adds 1 to its arguent, x maps to 2, y maps to 3 -> 6 *)

val x = 1

fun f y =
	let 
		val x = y+1
	in
		fn z => x + y + z (* take z and return 2y + 1 + z*)
	end

val x = 3 (* irrelevant *)

val g = f 4 (* returns a function that adds 9 to its argument *)

val y = 5

val z = g 6 (* get 15 *)


fun f g =
	let
		val x = 3 (* irrelevant *)
	in 
		g 2
	end

val x = 4

fun h y = x + y (* add 4 to its argument *)

val z = f h
