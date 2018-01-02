(* Dan Grossman, Coursera PL, HW2 Provided Code *)

(* if you use this function to compare two strings (returns true if the same
   string), then you avoid several of the functions in problem 1 having
   polymorphic types that may be confusing *)
fun same_string(s1 : string, s2 : string) =
    s1 = s2

(* put your solutions for problem 1 here *)
fun all_except_option (s : string, xs : string list) =
(* string * string list -> option *)
	let fun check(s,xs) =
			case xs of 
				[] => []
			  | x::xs' => if same_string (x,s)
						  then xs'
						  else x::check(s,xs')
	in
		let val result = check (s,xs)
		in if result = xs then NONE else SOME result
		end
	end

fun get_substitution1 (xs : string list list, s : string) =
(* string list list * string -> string list *)
	case xs of 
		[] => []
	  | ys::xs' => let val lst = all_except_option(s,ys)
				   in 
					   case lst of
						   NONE => get_substitution1(xs',s)
						 | SOME zs => zs @ get_substitution1(xs',s)
				   end

val test2 = get_substitution1([["Fred", "Fredrick"], ["Elizabeth", "Betty"], ["Freddie", "Fred", "F"]], "Fred")
val test21 = get_substitution1([["Fred", "Fredrick"],["Jeff","Jeffrey"],["Geoff","Jeff","Jeffrey"]],"Jeff")

fun get_substitution2 (xs : string list list, s : string) =
	let fun aux(xs, acc) =
			case xs of 
				[] => acc
			  | ys::xs' => let val lst = all_except_option(s,ys)
						   in case lst of
								  NONE => aux(xs', acc)
								| SOME zs => aux(xs', zs @ acc)
						   end
	in aux(xs,[])
	end
val test3 = get_substitution2([["Fred", "Fredrick"], ["Elizabeth", "Betty"], ["Freddie", "Fred", "F"]], "Fred")
val test31 = get_substitution2([["Fred", "Fredrick"],["Jeff","Jeffrey"],["Geoff","Jeff","Jeffrey"]],"Jeff")

fun similar_names (xs : string list list, f : {first:string,middle:string,last:string}) =
(* string list list * {first:string, middle:string, last:string} -> {first:string,middle:string,last:string} list *)
	let fun add_first (ys : string list, m : string, l : string) =
			case ys of
				[] => []
			  | y::ys' => {first=y,middle=m,last=l} :: add_first(ys',m,l)
	in case f of
		   {first=a,middle=b,last=c} => {first=a,middle=b,last=c}::add_first(get_substitution2(xs,a),b,c)
	end

val test4 = similar_names([["Fred", "Fredrick"], ["Elizabeth", "Betty"], ["Freddie", "Fred", "F"]], {first="Fred",middle="a",last="b"})

(* you may assume that Num is always used with values 2, 3, ..., 10
   though it will not really come up *)
datatype suit = Clubs | Diamonds | Hearts | Spades
datatype rank = Jack | Queen | King | Ace | Num of int 
type card = suit * rank

datatype color = Red | Black
datatype move = Discard of card | Draw 

exception IllegalMove

(* put your solutions for problem 2 here *)
