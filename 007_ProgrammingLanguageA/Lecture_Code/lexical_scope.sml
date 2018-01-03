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

