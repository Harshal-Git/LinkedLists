/**
 * 
 */
package com.aa.utils;

/**
 * @author Harshal-Git
 *
 * -> Singly linked list utility methods
 */
public final class SinglyLLUtil {

	/**
	 * method to prepare a linked list with given values
	 * @param values - values to be inserted into linked list (null allowed)
	 * @return - returns a linked list with given values in the same order as elements
	 */
	public static Node prepareLL(int [] values) {
		if(values == null) {
			return null;
		}
		// first element
		Node newNode = new Node(values[0]);
		Node headNode = newNode;
		Node currentNode = newNode;
		// keep inserting remaining elements
		for(int index = 1; index < values.length; index++) {
			newNode = new Node(values[index]);
			currentNode.setNext(newNode);
			currentNode = newNode;
		}
		return headNode;
	}

	/**
	 * method to print linked lists of 'int' type
	 * @param startNode - root node for the linked list
	 * @return - string representation of linked list data
	 * <br/>It will not alter original linked list data.
	 */
	public static String printLL(Node startNode) {
		// validation
		if(startNode == null) {
			return "EMPTY";
		}
		// printing
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
	public static Node insertAtStart(Node root, int newElement) {
		// prepare new node
		Node newNode = new Node(newElement);
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
	public static Node insertAtEnd(Node root, int newElement) {
		// prepare new node
		Node newNode = new Node(newElement);
		// if root is null; new node if first element
		if(root == null) {
			return newNode;
		}
		// otherwise start iterating linked list till last element is found
		Node currentNode = root;
		while(currentNode.getNext() != null) {
			currentNode = currentNode.getNext();
		}
		// set new element at last
		currentNode.setNext(newNode);
		// return root element
		return root;
	}

	/**
	 * method to insert given new element at given position
	 * @param root - root of the linked list
	 * @param newElement - new element to be inserted
	 * @param position - position at which element insertion is expected (Starts from 1)
	 * @return - updated linked list with given element inserted at given position
	 * <br/>-> Time complexity: O(n)	
	 * <br/>-> Space complexity: 0(n)	
	 * <br/>-> Auxiliary space: 0(1)
	 */
	public static Node insertAtPosition(Node root, int newElement, int position) {
		Node newNode = new Node(newElement);
		// if position is invalid
		if(position < 1) {
			throw new IllegalArgumentException("Invalid position input.");
		}
		// if root is null - don't process anything 
		if(root == null) {
			return root;
		}
		// if position is 1 - insert at first
		if(position == 1) {
			return insertAtStart(root, newElement);
		}
		// find appropriate position for the new element
		int nodeCount = 1;
		Node nextPtr = root;
		Node prevPtr = null;
		while(nextPtr != null) {
			if(nodeCount == position) {
				break;
			}
			prevPtr = nextPtr;
			nextPtr = nextPtr.getNext();
			nodeCount++;
		}
		// insert new element if position is correct
		if((position-1) <= (nodeCount-1)) {
			prevPtr.setNext(newNode);
			newNode.setNext(nextPtr);
		}
		// otherwise no insertions will happen
		return root;
	}

	/**
	 * method to delete linked list element from start
	 * @param root - root of existing linked list
	 * @return - updated linked list after deleting first element
	 * <br/>-> Time complexity: 0(1)	
	 * <br/>-> Space complexity: 0(1)	
	 * <br/>-> Auxiliary space: 0(1) 
	 */
	public static Node deleteFromStart(Node root) {
		// validation
		if(root == null) {
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
			// return updated root element
			return root.getNext();			
		}
	}

	/**
	 * method to delete linked list element from end
	 * @param root - root of existing linked list
	 * @return - updated linked list after deleting last element
	 * <br/>-> Time complexity: 0(n)	
	 * <br/>-> Space complexity: 0(n)	
	 * <br/>-> Auxiliary space: 0(1) 
	 */
	public static Node deleteFromEnd(Node root) {
		// border case : if list contains 0 or 1 element 
		if(root == null || root.getNext() == null) {
			return null;
		}
		// find second last node and set it's next reference as NULL
		Node current = root;
		Node previous = null;
		while(current.getNext() != null) {
			previous = current;
			current = current.getNext();
		}
		// reset the new last element next reference
		previous.setNext(null);
		return root;
	}
}
