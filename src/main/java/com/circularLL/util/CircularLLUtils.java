/**
 * 
 */
package com.circularLL.util;

/**
 * @author Harshal-Git
 *
 * -> Circular linked list utility methods
 */
public class CircularLLUtils {

	/**
	 * method to prepare a circular linked list
	 * @param elements - elements to be inserted into the list
	 * @return - returns a circular linked list with given elements
	 */
	public static Node prepareCLL(int [] elements) {
		// if no elements are passed
		if(elements == null || elements.length < 1) {
			return null;
		}
		Node head = null, newNode = null, currentNode = null;
		// first node
		newNode = new Node(elements[0]);
		head = newNode;
		currentNode = newNode;
		// otherwise iterate over all elements & prepare nodes
		for(int index = 1; index < elements.length; index++) {
			newNode = new Node(elements[index]);
			currentNode.setNext(newNode);
			currentNode = newNode;
		}
		// at the end, last node will receive head reference
		currentNode.setNext(head);
		// return head
		return head;
	}

	/**
	 * method to print data from a circular linked list
	 * @param head - head of the linked list
	 * @return - string representation of the given circular linked list
	 */
	public static String printCLL(Node head) {
		// if head is null
		if(head == null) {
			return "EMPTY";
		}
		// iterate through all elements and read all values
		StringBuilder builder = new StringBuilder();
		// root pointer  
		Node root = head;
		// iterate through all elements 
		// using do-while means at this time; at-least one element will be present
		do {
			builder.append(head.getValue()+" -> "); 
			head = head.getNext();
		} while(head != root);
		// add an identifier to show it's a circular linked list
		builder.append("HEAD");
		// return the builder value
		return builder.toString();
	}

	/**
	 * method to add element at the start of the circular linked list
	 * @param root - root element of the given list
	 * @param newElement - new element to be inserted at start of the list
	 * @return - updated list with added first element at the start 
	 * <br/>-> Time complexity: 0(n)	
	 * <br/>-> Space complexity: 0(n)	
	 * <br/>-> Auxiliary space: 0(1)
	 * <br/>This method follows the first approach of insertion at head.
	 */
	public static Node insertAtStart(Node root, int newElement) {
		Node newNode = new Node(newElement);
		// if root is null - return the new node as head with circular reference
		if(root == null) {
			newNode.setNext(newNode);
			return newNode;
		}
		// set new node's next as root
		newNode.setNext(root);
		
		// iterate over all elements & update the last 
		// node's next reference to the new node
		Node currentNode = root;
		while(currentNode.getNext() != root) {
			currentNode = currentNode.getNext();
		}
		// set tail node's next reference to new node
		currentNode.setNext(newNode);
		// reset the root as new node
		root = newNode;
		// return updated root
		return root;
	}

	/**
	 * method to insert a new node at the end of the linked list
	 * @param head - head of the linked list
	 * @param newElement - new value to be inserted at the end of the circular linked list
	 * @return - updated linked list with the given data inserted at the end of the list
	 * <br/>-> Time complexity: 0(n)	
	 * <br/>-> Space complexity: 0(n)	
	 * <br/>-> Auxiliary space: 0(1)
	 */
	public static Node insertAtEnd(Node head, int newElement) {
		// prepare new node
		Node newNode = new Node(newElement);
		// if head is null; return the new node as root node
		if(head == null) {
			newNode.setNext(newNode);
			return newNode;
		}
		// find the last node of the list and insert the new node at the end
		Node currentNode = head;
		while(currentNode.getNext() != head) {
			currentNode = currentNode.getNext();
		}
		// update the head reference in new node
		newNode.setNext(head);
		// update last node's reference to new node
		currentNode.setNext(newNode);
		// return head
		return head;
	}

	/**
	 * method to delete element from the head of a circular linked list
	 * @param head - head of the linked list 
	 * @return - updated linked list with head element removed
	 * <br/>-> Time complexity: 0(n)	
	 * <br/>-> Space complexity: 0(n)	
	 * <br/>-> Auxiliary space: 0(1)
	 */
	public static Node deleteFromStart(Node head) {
		// base case : if head is null OR only one element is present
		if(head == null || head.getNext() == head) {
			return null;
		}
		// reach at last node
		Node current = head;
		while(current.getNext() != head) {
			current = current.getNext();
		}
		// reset reference of head from last node 
		current.setNext(head.getNext());
		// update head
		head = head.getNext();
		// return updated head
		return head;
	}
}
