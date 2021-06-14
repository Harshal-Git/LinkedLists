Naive solution:

1. First we complete a traversal of the list to find last node reference.

2. Now again we traverse the complete list (including last element) and if any ODD node is encountered; it will be deleted from 
	current position and will be moved at last position.
	
	This process will be repeated by maintaining the existing connection between even nodes.
	
	This approach will make 2 traversals of the given list. 