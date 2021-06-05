/**
 * 
 */
package com.doublyLL.util;

/**
 * @author Harshal-Git
 *
 */
public class DoublyLLUtils {

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
			newNode.setPrevious(currentNode);
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
			builder.append(startNode.getValue()+" <=> ");
			startNode = startNode.getNext();
		}
		// check builder length
		if(builder.length() > 0) {
			builder.delete((builder.length()-5), builder.length());
		}
		// return builder string
		return builder.toString();
	}

	/**
	 * method to insert a new node at start of the doubly linked list
	 * @param root - root of current linked list
	 * @param newVal - new value to be inserted at the start
	 * @return - linked list root with updated data
	 * <br/>-> Time complexity: 0(1)	
	 * <br/>-> Space complexity: 0(1)	
	 * <br/>-> Auxiliary space: 0(1)
	 */
	public static Node insertAtStart(Node root, int newVal) {
		// prepare new node
		Node newNode = new Node(newVal);
		// if linked list is empty - return the new node as first node
		if(root == null) {
			return newNode;
		}
		// otherwise add new node at start
		newNode.setNext(root);
		root.setPrevious(newNode);
		root = newNode;
		return root;
	}

	/**
	 * method to insert a new node at end of the doubly linked list
	 * @param root - root of current linked list
	 * @param newVal - new value to be inserted at the end
	 * @return - linked list root with updated data
	 * <br/>-> Time complexity: 0(n)	
	 * <br/>-> Space complexity: O(n)	
	 * <br/>-> Auxiliary space: 0(1)
	 */
	public static Node insertAtEnd(Node root, int newVal) {
		// prepare new node
		Node newNode = new Node(newVal);
		// if linked list is empty; return new node 
		if(root == null) {
			return newNode;
		}
		// otherwise traverse through complete list and insert at the end
		Node current = root;
		while(current.getNext() != null) {
			current = current.getNext();
		}
		// reset the last node with new node data
		current.setNext(newNode);
		newNode.setPrevious(current);
		return root;
	}

	/**
	 * method to delete first node from a doubly linked list
	 * @param root - root of the linked list
	 * @return - updated linked list with first element deleted
	 * <br/>-> Time complexity: 0(1)	
	 * <br/>-> Space complexity: 0(1)	
	 * <br/>-> Auxiliary space: 0(1)
	 */
	public static Node deleteFromStart(Node root) {
		// corner cases - if list is empty OR only one element is present in the list
		if(root == null || root.getNext() == null) {
			return null;
		}
		// otherwise delete first node
		root = root.getNext();
		root.setPrevious(null);
		return root;
	}

	/**
	 * method to delete last node from a doubly linked list
	 * @param root - root of the linked list
	 * @return - updated linked list with last element deleted
	 * <br/>-> Time complexity: 0(n)	
	 * <br/>-> Space complexity: 0(n)	
	 * <br/>-> Auxiliary space: 0(1)
	 */
	public static Node deleteFromEnd(Node root) {
		// if list is empty OR only one element is present in the list
		if(root == null || root.getNext() == null) {
			return null;
		}
		// otherwise iterate through all elements and delete the last node
		Node currentNode = root;
		Node previousNode = null;
		while(currentNode.getNext() != null) {
			previousNode = currentNode;
			currentNode = currentNode.getNext();
		}
		// set second last node reference to next pointer as NULL
		previousNode.setNext(null);
		// return the updated root
		return root;
	}
}
