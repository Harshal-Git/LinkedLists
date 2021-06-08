/**
 * 
 */
package com.aa.utils;

import java.util.Objects;

/**
 * @author Harshal-Git
 *
 *	-> Standard Node for linked list (can be converted into Singly / Doubly / Circular)
 */
public class Node {

	private int value;

	private Node previousPtr;

	private Node nextPtr;

	/**
	 * @param value - value of the node
	 */
	public Node(int value) {
		setValue(value);
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
	private void setValue(int value) {
		this.value = value;
	}

	/**
	 * @return the previous
	 */
	public Node getPrevious() {
		return previousPtr;
	}

	/**
	 * @param previous the previous to set
	 */
	public void setPrevious(Node previous) {
		this.previousPtr = previous;
	}

	/**
	 * @return the next
	 */
	public Node getNext() {
		return nextPtr;
	}

	/**
	 * @param next the next to set
	 */
	public void setNext(Node next) {
		this.nextPtr = next;
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
		Node node = ((Node) obj);
		return (this.getValue() == node.getValue());
	}

	@Override
	public String toString() {
		return String.valueOf(this.getValue());
	}
}
