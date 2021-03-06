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
(* ('a -> 'b list option) -> 'a list -> 'b list option *)
	let fun aux f xs acc = 
			case xs of 
				[] => SOME acc
			  | x::xs' => case f x of 
							  NONE => NONE
							| SOME v => aux f xs' (v@acc)
	in aux f xs []
	end 



fun count_wildcards p = g (fn () => 1) (fn x => 0) p

fun count_wild_and_variable_lengths p  = g (fn () => 1) (fn x => String.size x) p

fun count_some_var (s, p) = g (fn () => 0) (fn x => if x=s then 1 else 0) p

fun check_pat p = 
	let
		fun val_list p =
			case p of 
				Wildcard => []
			  | Variable x => [x]
			  | TupleP ps => List.foldl (fn (p,acc) => (val_list p) @ acc) [] ps
			  | ConstructorP (_,p) => val_list p
			  | _ => []

		fun check_repeat xs =
			case xs of
				[] => true
			  | x::xs' => (not (List.exists (fn s => s=x) xs')) andalso (check_repeat xs')
	in  check_repeat (val_list p)
	end


fun match (v,p) =
(* valu*pattern -> (string*valu) list option *)	
	case p of 
		Wildcard => SOME []
	  | Variable s => SOME [(s,v)]
	  | UnitP => if v = Unit then SOME [] else NONE
	  | ConstP i => let val x = v
					in case x of
						   Const j => SOME []
						 | _ => NONE
					end
	  | TupleP ps => let val x = v
					 in case x of 
							Tuple vs => if (List.length ps = List.length vs)
										then all_answers match (ListPair.zip (vs,ps))
										else NONE
						  | _ => NONE
					 end
	  | ConstructorP (s1,p) => let val x = v
							   in case x of 
									  Constructor (s2,v) => if s1=s2
															then match (v,p)
															else NONE
							   end

fun first_match v ps =
(* valu * pattern list -> (string * valu) list option *)
	SOME (first_answer (fn x => match (v,x)) ps)
	handle NoAnswer => NONE




