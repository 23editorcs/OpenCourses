
exception ListLengthMismatch

fun zip3 list_triple =
	case list_triple of
		([], [], []) => []
	   |(hd1::tl1, hd2::tl2, hd3::tl3) => (hd1,hd2,hd3)::zip3(tl1, tl2, tl3)
	   | _ => raise ListLengthMismatch

fun unzip3 list =
	case list of
		[] => ([], [], [])
	  | (a,b,c)::tl => let val (l1, l2, l3) = unzip3 tl
					   in 
						   (a::l1, b::l2, c::l3)
					   end

fun nondecreasing xs = (* int list -> bool *)
	case xs of
		[] => true
	  | _::[] => true
	  | head::(neck::rest) => head <= neck
							  andalso nondecreasing (neck::rest)
	  

datatype sgn = P | N | Z

fun mulsign (x1,x2) = (* int * int -> sgn *)
	let fun sign x = if x=0 then Z else if x>0 then P else N
	in
		case (sign x1, sign x2) of
			(Z,_) => Z
		  | (_,Z) => Z
		  | (P,P) => P
		  | (N,N) => P
		  | (N,P) => N
		  | (P,N) => N
	end

fun length (xs) = (* int list -> int *)
	case xs of
		[] => 0
	  | _::xs' => 1 + length xs'
