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
		do {
			builder.append(head.getValue()+" -> "); 
			head = head.getNext();
		} while(head != root);
		// add an identifier to show it's a circular linked list
		builder.append("HEAD");
		// return the builder value
		return builder.toString();
	}
}
