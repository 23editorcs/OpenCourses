
fun is_older (d1 : int*int*int, d2 : int*int*int) =
	if (#1 d1) = (#2 d2)
	then if (#2 d1) = (#2 d2)
		 then (#3 d1) < (#3 d2)
		 else (#2 d1) < (#2 d2)
	else (#1 d1) < (#1 d2)

fun number_in_month (d : (int*int*int) list, m : int) =
	if null d
	then 0
	else 
		if (#2 (hd d)) = m
		then 1 + number_in_month(tl d, m)
		else number_in_month(tl d, m)

fun number_in_months (d : (int*int*int) list, m : int list) =
	if null m
	then 0
	else number_in_month(d, hd m) + number_in_months(d, tl m)

fun dates_in_month (d : (int*int*int) list, m : int) =
	if null d
	then []
	else 
		if (#2 (hd d)) = m
		then hd d :: dates_in_month (tl d, m)
		else dates_in_month (tl d, m)

fun dates_in_months (d : (int*int*int) list, m : int list) =
	if null m
	then []
	else dates_in_month(d, hd m) @ dates_in_months(d, tl m)

fun get_nth (xs : string list, n : int) =
	if null xs
	then ""
	else
		if n = 1
		then hd xs
		else get_nth (tl xs, n-1)

val months = ["January", "Febuary", "March", "April", "May", "June", "July", "August", "September", "October", "November", "December"]

fun date_to_string (d : int*int*int) =
	get_nth (months, #2 d)^ " " ^ Int.toString(#3 d) ^ ", " ^ Int.toString(#1 d)
																				
fun number_before_reaching_sum (sum : int, xs : int list) =
	if sum <= hd xs
	then 0 
	else 1 + number_before_reaching_sum (sum - (hd xs), tl xs)									

val month_days = [31,28,31,30,31,30,31,31,30,31,30,31]

fun what_month (d : int) =
	1 + number_before_reaching_sum (d, month_days)

fun month_range (d1 : int, d2 : int) =
	if d1 > d2
	then []
	else what_month (d1) :: month_range(d1+1, d2)

fun oldest (d : (int*int*int) list) =
	if null d
	then NONE
	else let val tl_oldest = oldest (tl d)
		 in if (isSome tl_oldest) andalso is_older (valOf tl_oldest, hd d)
			then tl_oldest
			else SOME (hd d)
		 end
