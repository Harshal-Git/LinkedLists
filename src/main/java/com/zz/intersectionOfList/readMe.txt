-> Given 2 heads of 2 linked lists. Both list has some common elements and they intersect at one element. Find the intersecting 
	element.
	
 -> ex:
 		5 -> 8 -> 7 -> 10 -> 12 -> 15
 			           /\
 				        |
 			            9				
 		
 		l1 = 5 -> 8 -> 7 -> 10 -> 12 -> 15
 		
 		l2 = 9 -> 10 -> 12 -> 15
 
 	=> o/p : 10

####

Solution 1:

Using a hash-set; we will iterate first list completely storing node's references.

Then iterating the second list; if we find any reference of elements from second list present in hash-set; that's intersection point.

If first list has 'm' elements & second has 'n' elements & they both intersect; then 

	-> total time complexity : O(m) [first list iteration] + O(n) [second list iteration]
	
	-> auxiliary space : O(m) [first list reference storage]
	
	-> Total traversal : 2 (finding length of first / checking existence of node for second list in hashset)
	
####

Solution 2:

-> Find number of elements from both list first and find an absolute difference of total nodes.

	L1 => N1
	L2 => N2	(Assume: N2 < N1)

-> Whichever list has higher number of nodes (N1), move those many nodes from that list ahead. L1.next().next()...

-> Now from lower size list (N2) and the updated bigger list L1_Updated; start 2 pointers and traverse those pointers till the end
	with same speed. The point where they both become same; that's the intersection point.  
	
	-> total time complexity : O(m) [first list iteration] + O(n) [second list iteration]
	
	-> auxiliary space : 0(1) 
 
 	-> Total traversal : 3 (finding length of both / advancing pointer from bigger list / traverse pointers for both at same speed)
 	
 	