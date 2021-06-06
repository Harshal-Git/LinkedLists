/**
 * 
 */
package com.circularLL.util;

import java.util.Objects;

/**
 * @author Harshal-Git
 *
 *	-> Node for circular linked list 
 */
public class Node {

	private int value;
	
	private Node nextPtr;
	
	/**
	 * @param val - node value to  assign
	 * <br/><b>nextPtr</b> will be NULL by default
	 */
	public Node(int val) {
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
	private void setValue(int value) {
		this.value = value;
	}

	/**
	 * @return the nextPtr
	 */
	public Node getNext() {
		return nextPtr;
	}

	/**
	 * @param nextPtr the nextPtr to set
	 */
	public void setNext(Node nextPtr) {
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
		Node node = ((Node) obj);
		return (this.getValue() == node.getValue());
	}
	
	@Override
	public String toString() {
		return String.valueOf(this.getValue());
	}
}
