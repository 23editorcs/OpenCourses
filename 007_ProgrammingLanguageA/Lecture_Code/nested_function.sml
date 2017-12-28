(*
fun count (from : int, to : int) =
	if from = to
	then to::[]
	else from :: count(from+1, to)
*)
fun countup_from1(x : int) =
	let
		fun count (from : int) =
			if from = x
			then x :: []
			else from :: count(from+1)
	in
		count(1)
	end

fun countdown(x : int) =
	if x = 0
	then []
	else x :: countdown(x-1)

fun countdown1(from : int, to : int) =
	if from = to
	then to :: []
	else from :: countdown1(from-1, to)

fun countup1(from : int, to : int) =
	if from = to 
	then to :: []
	else from :: countup1(from+1, to)

fun bad_max(a : int list) =
	if null a
	then 0
	else 
		let 
			val tl_max = bad_max(tl a)
		in
			if hd a > tl_max
			then hd a
			else tl_max
		end
