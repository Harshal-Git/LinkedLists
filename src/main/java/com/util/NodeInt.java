/**
 * 
 */
package com.util;

import java.util.Objects;

/**
 * @author Harshal-Git
 *
 *	-> Integer type of Node for a linked list 
 */
public class NodeInt {

	private int value;
	
	private NodeInt nextPtr;
	
	/**
	 * @param val - node value to  assign
	 * <br/><b>nextPtr</b> will be NULL by default
	 */
	public NodeInt(int val) {
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
	public NodeInt getNext() {
		return nextPtr;
	}

	/**
	 * @param nextPtr the nextPtr to set
	 */
	public void setNext(NodeInt nextPtr) {
		this.nextPtr = nextPtr;
	}

	@Override
	public int hashCode() {
		return Objects.hash(nextPtr, value);
	}

	/**
	 * compare node by it's value ONLY
	 */
	@Override
	public boolean equals(Object obj) {
		if(obj == null) {
			return false;
		}
		NodeInt node = ((NodeInt) obj);
		return (this.getValue() == node.getValue());
	}
}
