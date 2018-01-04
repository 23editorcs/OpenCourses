(* Coursera Programming Languages, Homework 3, Provided Code *)

exception NoAnswer

datatype pattern = Wildcard
		 | Variable of string
		 | UnitP
		 | ConstP of int
		 | TupleP of pattern list
		 | ConstructorP of string * pattern

datatype valu = Const of int
	      | Unit
	      | Tuple of valu list
	      | Constructor of string * valu

fun g f1 f2 p =
    let 
	val r = g f1 f2 
    in
	case p of
	    Wildcard          => f1 ()
	  | Variable x        => f2 x
	  | TupleP ps         => List.foldl (fn (p,i) => (r p) + i) 0 ps
	  | ConstructorP(_,p) => r p
	  | _                 => 0
    end

(**** for the challenge problem only ****)
datatype typ = Anything
	     | UnitT
	     | IntT
	     | TupleT of typ list
	     | Datatype of string

(**** you can put all your code here ****)
fun only_capitals xs =
	(* case xs of
		[] => []
	 | x::xs' => if (Char.isUpper (String.sub (x,0)))
				 then x :: only_capitals xs'
				 else only_capitals xs' *)
	List.filter (fn x => (Char.isUpper (String.sub (x,0)))) xs

fun longest_string1 xs =
(* string list -> string *)
	foldl (fn (x,max_string) => if String.size x > String.size max_string
								then x
								else max_string) 
		  "" 
		  xs

fun longest_string2 xs =
(* string list -> string *)
	foldl (fn (x,max_string) => if String.size x >= String.size max_string
								then x
								else max_string)
		  ""
		  xs


fun longest_string_helper f xs =
(* (int * int -> bool) -> string list -> string *)
	foldl (fn (x,max) => if f (String.size x, String.size max)
						 then x
						 else max)
		  ""
		  xs

val longest_string3 = longest_string_helper (fn (x,y) => x > y)  
					 
val longest_string4 = longest_string_helper (fn (x,y) => x >= y)
(* fun list_map f xs =
	case xs of 
		[] => []
	  | x::xs' => f x :: list_map f xs'
fun list_filter f xs =
	case xs of 
		[] => []
	  | x::xs' => if f x then x::list_filter f xs' else list_filter f xs'

*)

val longest_capitalized = (longest_string3 o only_capitals)
val longest_capitalized1 = (longest_string4 o only_capitals)


fun rev_string s = (String.implode o List.rev o String.explode) s

fun first_answer f xs =
(* ('a -> 'b option) -> 'a list -> 'b *)	
	case xs of
		[] => raise NoAnswer 
	  | x::xs' => case f x of 
					  NONE => first_answer f xs'
					| SOME v => v

fun all_answers f xs =
(* ('a -> 'b list option) -> 'a list -> 'b list *)
	let fun aux f xs acc = 
			case xs of 
				[] => SOME acc
			  | x::xs' => case f x of 
							  NONE => NONE
							| SOME v => aux f xs' (v@acc)
	in aux f xs []
	end 


