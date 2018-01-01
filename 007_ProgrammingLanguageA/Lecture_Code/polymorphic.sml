

fun sum_list xs = 
	case xs of 
		[] => 0
	  | x::xs' => x + sum_list xs'

fun append (xs, ys) =
	case xs of 
		[] => ys
	  | x::xs' => x::append(xs',ys)

datatype 'a mylist = Empty | Cons of 'a * 'a mylist

datatype ('a, 'b) tree = Node of 'a * ('a, 'b) tree * ('a, 'b) tree
					   | Leaf of 'b

fun sum_tree tr = 
	case tr of
		Leaf i => i
	  | Node (i, lft, rgt) => i + sum_tree lft + sum_tree rgt

fun sum_leave tr =
	case tr of 
		Leaf i => i
	  | Node (i, lft, rgt) => sum_leave lft + sum_leave rgt





