/**
 * 
 */
package com.aa.utils;

/**
 * @author Harshal-Git
 */
public class CyclicLLUtil {

	/**
	 * get a cyclic loop (using singly linked list)
	 * @return 10 -> 20 -> 30 -> 40 -> 50 -> 60 -> (30)
	 */
	public static Node getCyclicLoopLL() {
		Node n1 = null, n2 = null, n3 = null, n4 = null, n5 = null;
		// head
		Node head = new Node(10);
		// node 1
		n1 = new Node(20); head.setNext(n1);
		// node 2
		n2 = new Node(30); n1.setNext(n2);
		// node 3
		n3 = new Node(40); n2.setNext(n3);
		// node 4
		n4 = new Node(50); n3.setNext(n4);
		// node 5
		n5 = new Node(60); n4.setNext(n5);
		// form a loop between 30 & 60
		n5.setNext(n2);
		return head;
	}
	
	/**
	 * @return - a sample cyclic loop 10 -> 20 -> 30 -> 40 -> 50 -> 60 -> (30)
	 */
	public static String getCyclicLLString() {
		return ("10 -> 20 -> 30 -> 40 -> 50 -> 60 -> (30)");
	}
	
}
