/**
 * 
 */
package com.util;

/**
 * @author Harshal-Git
 *
 *	Linked list utility methods 
 */
public final class IntLLUtils {

	/**
	 * method to prepare a linked list with given values
	 * @param values - values to be inserted into linked list (null allowed)
	 * @return - returns a linked list with given values in the same order as elements
	 */
	public static NodeInt prepareLL(int [] values) {
		if(values == null) {
			return null;
		}
		// first element
		NodeInt newNode = new NodeInt(values[0]);
		NodeInt headNode = newNode;
		NodeInt currentNode = newNode;
		// keep inserting remaining elements
		for(int index = 1; index < values.length; index++) {
			newNode = new NodeInt(values[index]);
			currentNode.setNext(newNode);
			currentNode = newNode;
		}
		return headNode;
	}

	/**
	 * method to print linked lists of 'int' type
	 * @param root - root node for the linked list
	 * @return - string representation of linked list data
	 * <br/>It will not alter original linked list data.
	 */
	public static String printLL(NodeInt root) {
		// validation
		if(root == null) {
			return "EMPTY";
		}
		// printing
		NodeInt startNode = root;	// not to change the original linked list data
		StringBuilder builder = new StringBuilder();
		// print the linked list data till current node becomes NULL
		while(startNode != null) {
			builder.append(startNode.getValue()+" -> ");
			startNode = startNode.getNext();
		}
		// check builder length
		if(builder.length() > 0) {
			builder.delete((builder.length()-4), builder.length());
		}
		// return builder string
		return builder.toString();
	}

	/**
	 * method to insert element at start of the linked list
	 * @param root - existing linked list root element
	 * @param newElement - value of new element to be inserted
	 * @return - returns the updated linked list with new element 
	 * inserted at start of the list 
	 * <br/>-> Time complexity: 0(1)	
	 * <br/>-> Space complexity: 0(1)	
	 * <br/>-> Auxiliary space: 0(1)
	 */
	public static NodeInt insertAtStart(NodeInt root, int newElement) {
		// prepare new node
		NodeInt newNode = new NodeInt(newElement);
		// assign root to reference of new node
		newNode.setNext(root);
		// return first element
		return newNode;
	}

	/**
	 * method to insert element at end of the linked list
	 * @param root - existing linked list root element
	 * @param newElement - value of new element to be inserted
	 * @return - returns the updated linked list with new element 
	 * inserted at end of the list 
	 * <br/>-> Time complexity: 0(n)	
	 * <br/>-> Space complexity: 0(n)	
	 * <br/>-> Auxiliary space: 0(1)
	 */
	public static NodeInt insertAtEnd(NodeInt root, int newElement) {
		// prepare new node
		NodeInt newNode = new NodeInt(newElement);
		// if root is null; new node if first element
		if(root == null) {
			return newNode;
		}
		// otherwise start iterating linked list till last element is found
		NodeInt currentNode = root;
		while(currentNode.getNext() != null) {
			currentNode = currentNode.getNext();
		}
		// set new element at last
		currentNode.setNext(newNode);
		// return root element
		return root;
	}

	/**
	 * method to delete linked list element from start
	 * @param head - root of existing linked list
	 * @return - updated linked list after deleting first element
	 * <br/>-> Time complexity: 0(1)	
	 * <br/>-> Space complexity: 0(1)	
	 * <br/>-> Auxiliary space: 0(1) 
	 */
	public static NodeInt deleteFromStart(NodeInt head) {
		// validation
		if(head == null) {
			return null;
		} else {
			/*
			 * in languages where memory deallocation is not possible automatically; 
			 * actions as below would be needed:
			 * 
			 * 1. assign head to temp
			 * 2. assign head to head.next()
			 * 3. deallocate temp
			 * 4. return head 
			 */
			// return updated head element
			return head.getNext();			
		}
	}

	/**
	 * method to delete linked list element from end
	 * @param head - root of existing linked list
	 * @return - updated linked list after deleting last element
	 * <br/>-> Time complexity: 0(n)	
	 * <br/>-> Space complexity: 0(n)	
	 * <br/>-> Auxiliary space: 0(1) 
	 */
	public static NodeInt deleteFromEnd(NodeInt head) {
		// border case : if list contains 0 or 1 element 
		if(head == null || head.getNext() == null) {
			return null;
		}
		// find second last node and set it's next reference as NULL
		NodeInt current = head;
		NodeInt previous = null;
		while(current.getNext() != null) {
			previous = current;
			current = current.getNext();
		}
		// reset the new last element next reference
		previous.setNext(null);
		return head;
	}
}
