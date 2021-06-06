There are certain tricky approaches in basic operations of circular linked list; which can be performed in constant time 0(1).

These operations can be performed only when current implementation allows to change the value of the node of a circular linked list. 
In my all remaining versions of linked list; it's not possible.

1. Insert at start : 

	a. insert new node immediately after head node.
	b. swap only the data (/value) between head & it's next node(/new node).
		 
2. Insert at end : 

	a. insert new node immediately after head node.
	b. swap only the data (/value) between head & it's next node(/new node).
	c. move current head pointer to next.
	
3. Delete from start :
	
	a. copy data (/value) and next pointer data from next of head node to head node.
	
-> All such operations are done in EfficientApproachOperations.java demo.