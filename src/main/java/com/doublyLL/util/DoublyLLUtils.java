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
}
