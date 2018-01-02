
fun sum xs = 
	let fun aux(xs, acc) =
			case xs of 
				[] => acc
			  | x::xs' => aux(xs', acc+x)
	in
		aux(xs,0)
	end

fun rev xs =
	case xs of 
		[] => []
	  | x::xs' => (rev xs') @ [x]

fun rev1 xs =
	let fun aux (xs, acc) =
			case xs of 
				[] => acc
			  | x::xs' => aux(xs',x::acc)
	in
		aux(xs, [])
	end
