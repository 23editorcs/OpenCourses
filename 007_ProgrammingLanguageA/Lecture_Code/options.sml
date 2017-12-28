
fun max1(xs : int list) =
	if null xs
	then NONE
	else 
		let val tl_max = max1(tl xs)
		in if isSome tl_max andalso valOf tl_max > hd xs 
		   then tl_max
		   else SOME (hd xs)
		end

fun max2 (xs : int list) =
	if null xs
	then NONE
	else
		let
			fun max_nonempty(none : int list) =
				if null (tl none)
				then hd none
				else let val tl_max = max_nonempty(tl none)
					 in if tl_max > hd none
						then tl_max
						else hd none
					 end
		in SOME (max_nonempty xs)
		end 
