/**
 * 
 */
package com.multiLevelList;

/**
 * @author Harshal-Git
 *
 */
public class Node {

	private int value;
	
	private Node nextNode;
	
	private Node nextLevelNode;
	
	/**
	 * 
	 */
	public Node(int val) {
		setValue(val);
		setNextNode(null);
		setNextLevelNode(null);
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
	 * @return the nextNode
	 * -> gets right side node
	 */
	public Node getNextNode() {
		return nextNode;
	}

	/**
	 * @param nextNode the nextNode to set
	 */
	public void setNextNode(Node nextNode) {
		this.nextNode = nextNode;
	}

	/**
	 * @return the nextLevelNode
	 * -> gets below level node (if available) 
	 */
	public Node getNextLevelNode() {
		return nextLevelNode;
	}

	/**
	 * @param nextLevelNode the nextLevelNode to set
	 */
	public void setNextLevelNode(Node nextLevelNode) {
		this.nextLevelNode = nextLevelNode;
	}
	
	@Override
	public String toString() {
		return String.valueOf(getValue());
	}
}
