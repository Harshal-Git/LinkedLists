/**
 * 
 */
package com.circularLL.basics;

import java.util.Arrays;
import java.util.Objects;

/**
 * @author Harshal-Git
 *
 *	-> insert new element at start & end of the circular linked list
 *
 *	-> Efficient Approaches (refer readMe.txt) 
 */
public class EfficientApproachOperations {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		// case 1
		printMessage(new int[] {30, 20, 10}, 5);

		// case 2
		printMessage(new int[] {10}, 25);

		// case 3
		printMessage(null, 8);
		
		// case 4
		printMessage(new int[] {1, 2, 3, 4, 5}, 6);
	}

	/**
	 * @param existingValues 
	 * @param newVal
	 */
	private static void printMessage(int[] existingValues, int newVal) {
		int currentSize = -1;
		if(existingValues == null) {
			currentSize = 0; 
		} else {
			currentSize = existingValues.length;
		}
		// prepare linked list
		NodeTmp head = null;
		System.out.println("\nValues insertion at start : "+Arrays.toString(existingValues));
		for(int index = 0; index < currentSize; index++) {
			head = insertAtStart(head, existingValues[index]);
		}
		System.out.println("Existing Linked list: "+printCLL(head));
		System.out.println("New value insertion at end : "+newVal);
		head = insertAtEnd(head, newVal);
		System.out.println("New Linked list: "+printCLL(head));
		head = deleteFromStart(head);
		System.out.println("Linked list after delete from start: "+printCLL(head));
	}

	/**
	 * method to insert new value at start of the linked list
	 * @param head - head of current linked list
	 * @param newVal - new value to be inserted at start
	 * @return - updated linked list with new value inserted at start of the list 
	 * <br/>-> Time complexity: 0(1)	
	 * <br/>-> Space complexity: 0(1)	
	 * <br/>-> Auxiliary space: 0(1)
	 */
	private static NodeTmp insertAtStart(NodeTmp head, int newVal) {
		// prepare new node
		NodeTmp newNode = new NodeTmp(newVal);
		// if root is null; return new node as root
		if(head == null) {
			newNode.setNext(newNode);
			return newNode;
		}
		// insert new node after current head
		NodeTmp nextNode = head.getNext();
		newNode.setNext(nextNode);
		head.setNext(newNode);
		// swap values of both head & it's next node
		int tempVal = newNode.getValue();
		newNode.setValue(head.getValue());
		head.setValue(tempVal);
		// return head
		return head;
	}

	/**
	 * method to insert new value at end of the linked list
	 * @param head - head of current linked list
	 * @param newVal - new value to be inserted at end
	 * @return - updated linked list with new value inserted at end of the list 
	 * <br/>-> Time complexity: 0(1)	
	 * <br/>-> Space complexity: 0(1)	
	 * <br/>-> Auxiliary space: 0(1)
	 */
	private static NodeTmp insertAtEnd(NodeTmp head, int newVal) {
		// prepare new node
		NodeTmp newNode = new NodeTmp(newVal);
		// if root is null; return new node as root
		if(head == null) {
			newNode.setNext(newNode);
			return newNode;
		}
		// insert new node after current head
		NodeTmp nextNode = head.getNext();
		newNode.setNext(nextNode);
		head.setNext(newNode);
		// swap values of both head & it's next node
		int tempVal = newNode.getValue();
		newNode.setValue(head.getValue());
		head.setValue(tempVal);
		// update head to next node
		head = head.getNext();
		// return head
		return head;
	}
	
	/**
	 * method to delete from start of the linked list
	 * @param head - head of current linked list
	 * @return - updated linked list with removed start data
	 * <br/>-> Time complexity: 0(1)	
	 * <br/>-> Space complexity: 0(1)	
	 * <br/>-> Auxiliary space: 0(1)
	 */
	public static NodeTmp deleteFromStart(NodeTmp head) {
		// if head is null OR only one element is present
		if(head == null || head.getNext() == head) {
			return null;
		}
		// copy head.next to head
		NodeTmp nextNode = head.getNext();
		head.setValue(nextNode.getValue());
		head.setNext(nextNode.getNext());
		// return the head
		return head;
	}
	
	/**
	 * print string representation of current linked list
	 * @param head - head of the linked list
	 * @return - string representation of list
	 */
	private static String printCLL(NodeTmp head) {
		if(head == null) {
			return "EMPTY";
		}
		StringBuilder builder = new StringBuilder();
		NodeTmp root = head;
		do {
			builder.append(head.getValue()+" -> "); 
			head = head.getNext();
		} while(head != root);
		builder.append("HEAD");
		return builder.toString();
	}
}


/**
 * @author Harshal-Git
 * 
 *	-> Node for circular linked list (temporary implementation) 
 */
class NodeTmp {

	private int value;

	private NodeTmp nextPtr;

	/**
	 * @param val - node value to  assign
	 * <br/><b>nextPtr</b> will be NULL by default
	 */
	public NodeTmp(int val) {
		setValue(val);
		setNext(null);
	}

	/**
	 * @return the value
	 */
	public int getValue() {
		return value;
	}

	/**
	 * @param value the value to set
	 */
	public void setValue(int value) {
		this.value = value;
	}

	/**
	 * @return the nextPtr
	 */
	public NodeTmp getNext() {
		return nextPtr;
	}

	/**
	 * @param nextPtr the nextPtr to set
	 */
	public void setNext(NodeTmp nextPtr) {
		this.nextPtr = nextPtr;
	}

	@Override
	public int hashCode() {
		return Objects.hash(value);
	}

	/**
	 * compare node by it's value ONLY
	 */
	@Override
	public boolean equals(Object obj) {
		if(obj == null) {
			return false;
		}
		NodeTmp node = ((NodeTmp) obj);
		return (this.getValue() == node.getValue());
	}

	@Override
	public String toString() {
		return String.valueOf(this.getValue());
	}
}
