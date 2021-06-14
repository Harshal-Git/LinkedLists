There are multiple approaches to check whether given linked list has a loop OR not.


1. Naive solution : Iterate over linked list and for each node 'p'; we reiterate the complete loop again and check whether 
					any node we are getting same as 'p.next'? If yes then loop exist. [ O(n^2) ]
					
2. Visited Flag : This approach would require a structural change in the 'Node' of the list with a new boolean flag 'visited'; 
				initially set as FALSE. Once we iterate through the list; we mark each node as 'visited=TRUE' and for any node
				if we encounter it's next as 'visited=TRUE'; then loop exist.   [ O(n) ]
				
3. Dummy node : In this approach, a dummy node is created before iteration starts. After that; we iterate through the list and 
				for each node, we will change it's next reference to point to a dummy node IF it's not already pointing to the 
				dummy node. If it is already pointing to the dummy node; the list has a loop.   [ O(n) ]
				
4. Hashing : Using a Hash-set to store the visited references and checking whether any node refers to any existing visited node?
				 [ O(n) ]

5. Floyd cycle detection :  Iterating the given linked list with 2 pointers (fast & slow). Slow moves by 1 & fast moves at double speed.
							At any moment; if they meet at some point; there exist a loop.
							

--> Variations of loop detection / loop removal algo

1. Find the length of the loop.	
	solution : after detecting the loop with Floyd algo; keep one pointer steady and increment other pointer by 1 & record that count.
				that count will return the length of the loop.  

2. Find the first node of the loop.
	solution : after detecting the loop with Floyd algo; once we return slow pointer to the start of the loop; increment both by 1 & the 
				point they meet is first node of the loop.