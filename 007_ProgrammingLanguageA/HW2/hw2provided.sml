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

val test0 = all_except_option ("string", ["string"]) = SOME []

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

fun card_color (c : suit * rank) =
(* suit * rank -> color *)
	case c of 
		(Diamonds, _) => Red
	  | (Hearts,_) => Red
	  | (_,_) => Black

val test1 = card_color (Diamonds, Ace) = Red
val test11 = card_color(Clubs, Num 10) = Black


fun card_value (c : suit * rank) =
(* suit * rank -> int *)
	case c of
		(_,Ace) => 11
	  | (_,Num i) => i
	  | (_,_) => 10

val test2 = card_value (Diamonds, Ace) = 11
val test21 = card_value (Hearts, King) = 10
val test22 = card_value (Clubs, Num 5) = 5


fun remove_card (cs : card list, c : card, e : exn) =
(* card list * card * exception -> card list * exception *)
	case cs of
		[] => raise e
	  | x::cs' => if x=c then cs' else x::remove_card (cs',c,e)

exception CardNotInList

val test3 = remove_card([(Diamonds,Ace)],(Diamonds,Ace),CardNotInList)= []
val test31 = remove_card([(Hearts,Ace)],(Diamonds,Ace),CardNotInList) 
			 handle CardNotInList => [(Hearts,Ace)]
val test32 = remove_card([(Diamonds,Ace),(Diamonds,Ace)],(Diamonds,Ace),CardNotInList) = [(Diamonds,Ace)]


fun all_same_color (cs : card list) =
(* card list -> bool *)
	case cs of 
		[] => false
	  | c::[] => true
	  | c1::c2::cs' => if card_color(c1) = card_color(c2)
					   then all_same_color(c2::cs')
					   else false

val test4 = all_same_color [(Diamonds,Num 1), (Hearts,Num 2)] = true 
val test41 = all_same_color [(Diamonds, Ace), (Spades, King)] = false
val test42 = all_same_color [(Clubs, Ace), (Spades,Queen)] = true


fun sum_cards (cs : card list) =
(* card list -> int *)
	case cs of 
		[] => 0
	  | c::cs' => card_value c + sum_cards cs'

val test5 = sum_cards [(Diamonds,Ace)] = 11
val test51 = sum_cards [] = 0
val test52 = sum_cards [(Diamonds,Ace), (Hearts, Num 10)] = 21


fun score (cs : card list, goal : int) =
(* card list * int -> int *)
	let val result = sum_cards cs
	in if result > goal 
	   then if all_same_color(cs)
			then (3 * (result - goal)) div 2 else 3*(result-goal)
	   else if all_same_color(cs) 
	   then (goal - result) div 2 else (goal-result)
	end


val test6 = score([(Diamonds,Ace)],11) = 0
val test61 = score([(Diamonds,Ace)],10) = 1
val test62 = score([(Diamonds,Ace)],15) = 2


fun officiate (cs : card list, ms : move list, goal : int) =
(* card list * move list * int -> int *)
	let fun play (hld : card list, cs, ms) =
			case ms of
				[] => score(hld,goal)
			  | m::ms' => case m of
							  Discard c => play (remove_card(hld,c,IllegalMove),cs,ms')
							| Draw => case cs of
										  [] => score(hld,goal)
										| c::cs' => if sum_cards(c::hld) > goal
													then score(c::hld,goal)
													else play(c::hld,cs',ms')
	in play ([], cs, ms)
	end






