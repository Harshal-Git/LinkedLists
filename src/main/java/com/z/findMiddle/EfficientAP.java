/**
 * 
 */
package com.z.findMiddle;

import com.singlyLL.util.Node;
import com.singlyLL.util.SinglyLLUtils;

/**
 * @author Harshal-Git
 *
 *	-> For the given linked list; find middle of it.
 *
 *	-> base line : in case of 2 middle nodes, print data for the right most node.
 *
 *	-> Efficient approach : prepare 'slow' & 'fast' pointer and iterate until 'fast' is exhausted. Result will be at 'slow'.  
 *
 * -> Time complexity: 0(n) 	
 * -> Space complexity:	0(n)
 * -> Auxiliary space:  0(1)
 */
public class EfficientAP {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		// case 1
		printMessage(new int[] {10, 5, 20, 15, 25});

		// case 2
		printMessage(new int[] {10, 5, 20, 15, 25, 30});
		
		// case 3
		printMessage(new int[] {10});
		
		// case 4
		printMessage(null);
		
		// case 5
		printMessage(new int[] {10, 20});
		
		// case 6
		printMessage(new int[] {10, 20, 30, 40, 50});
		
		// case 7
		printMessage(new int[] {10, 20, 30, 40, 50, 60});
	}

	/**
	 * @param elements
	 */
	private static void printMessage(int[] elements) {
		Node head = null;
		head = SinglyLLUtils.prepareLL(elements);
		System.out.println("\nLinked list: "+SinglyLLUtils.printLL(head));
		System.out.println("Middle of the list: "+findMiddleOfList(head));
	}

	/**
	 * find middle element of the linked list
	 * @param head - head of the linked list
	 * @return - middle element of the list
	 * <br/> nothing if the list is empty
	 */
	private static String findMiddleOfList(Node head) {
		// check for null head
		if(head == null) {
			return "";
		}
		// prepare slow & fast pointers
		Node fastPtr = head;
		Node slowPtr = head;
		/*
		 * Moving at double speed; for ODD numbers, fast pointer 
		 * will reach at last node & for EVEN numbers, fast pointer 
		 * will go beyond the last node. Both cases are handled.
		 */
		while((fastPtr != null) && (fastPtr.getNext() != null)) {
			slowPtr = slowPtr.getNext();
			fastPtr = fastPtr.getNext().getNext();
		}
		// return the value of slow pointer node
		return String.valueOf(slowPtr.getValue());
	}
}
