(* Homework1 Simple Test *)
(* These are basic test cases. Passing these tests does not guarantee that your code will pass the actual homework grader *)
(* To run the test, add a new line to the top of this file: use "homeworkname.sml"; *)
(* All the tests should evaluate to true. For example, the REPL should say: val test1 = true : bool *)

use "hw1.sml";

val test1 = is_older ((1,2,3),(2,3,4)) = true
val test11 = is_older((1990, 3, 23), (1990, 4, 30)) = true
val test12 = is_older((1990,3,23), (1990,3,24)) = true
val test13 = is_older((1990,3,23), (1988,3,23)) = false
val test14 = is_older((1990,3,23), (1990, 2, 30)) = false
val test15 = is_older((1990,3,23), (1990,3,22)) = false
val test16 = is_older((1990,3,23), (1990,3,23)) = false
														  

val test2 = number_in_month ([(2012,2,28),(2013,12,1)],2) = 1
val test21 = number_in_month ([], 2) = 0
val test22 = number_in_month ([(2017,3,28), (2017,3,30), (2017,1,1)],3) = 2


val test3 = number_in_months ([(2012,2,28),(2013,12,1),(2011,3,31),(2011,4,28)],[2,3,4]) = 3
val test31 = number_in_months ([], []) = 0
val test32 = number_in_months ([], [2]) = 0
val test33 = number_in_months ([(2017,2,23)], []) = 0


val test4 = dates_in_month ([(2012,2,28),(2013,12,1)],2) = [(2012,2,28)]
val test41 = dates_in_month ([], 2) = []
val test42 = dates_in_month ([(2017,12,28), (2017,12,1), (2017,1,12)], 12) = [(2017,12,28), (2017,12,1)]

																				 
val test5 = dates_in_months ([(2012,2,28),(2013,12,1),(2011,3,31),(2011,4,28)],[2,3,4]) = [(2012,2,28),(2011,3,31),(2011,4,28)]
val test51 = dates_in_months ([], []) = []
val test52 = dates_in_months ([], [2]) = []
val test53 = dates_in_months ([(2017,12,2)], []) = []
																			

val test6 = get_nth (["hi", "there", "how", "are", "you"], 2) = "there"
val test61 = get_nth (["a"], 1) = "a"
val test62 = get_nth ([], 1) = "" 

val test7 = date_to_string (2013, 6, 1) = "June 1, 2013"

val test8 = number_before_reaching_sum (10, [1,2,3,4,5]) = 3
val test81 = number_before_reaching_sum (5, [5,23,4]) = 0
val test82 = number_before_reaching_sum (10, [1,1,1,1,1,1,1,5]) = 7
															   
val test9 = what_month 70 = 3
val test91 = what_month 1 = 1
val test92 = what_month 365 = 12

val test10 = month_range (31, 34) = [1,2,2,2]
val test101 = month_range (1,2) = [1,1]
val test102 = month_range (364,365) = [12,12]
val test103 = month_range (2,1) = []
val test104 = month_range (5,5) = [1]


val test11 = oldest([(2012,2,28),(2011,3,31),(2011,4,28)]) = SOME (2011,3,31)
val test110 = oldest([]) = NONE
val test111 = oldest([(2017,1,1)]) = SOME (2017,1,1)

