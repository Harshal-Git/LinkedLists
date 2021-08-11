/**
 * 
 */
package com.zz.reverseLL;

import com.aa.utils.Node;
import com.aa.utils.SinglyLLUtil;

/**
 * @author Harshal-Git
 *
 *	-> program to reverse the given singly linked list
 *
 * -> Time complexity:	0(n)
 * -> Space complexity:	0(n)
 * -> Auxiliary space:  0(1)
 */
public class ReverseSLLIterative {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		// case 1
		printMessage(new int[] {10, 20, 30, 40});

		// case 2
		printMessage(new int[] {10});
		
		// case 3
		printMessage(null);
		
		// case 4
		printMessage(new int[] {1, 5, 3, 2});
		
		// case 5
		printMessage(new int[] {40, 30, 20, 10});
	}

	/**
	 * @param elements
	 */
	private static void printMessage(int[] elements) {
		Node head = SinglyLLUtil.prepareLL(elements);
		System.out.println("\nLinked list: "+SinglyLLUtil.printLL(head));
		head = reverseLL(head);
		System.out.println("Reversed linked list: "+SinglyLLUtil.printLL(head));
	}

	/**
	 * method to reverse the given linked list
	 * @param head - head of the linked list
	 * @return - updated head with reversed linked list 
	 */
	private static Node reverseLL(Node head) {
		if(head == null || head.getNext() == null) {
			return head;
		}
		//  initializations
		Node current = head;
		Node prev = null, next = null;
		// move till the last node
		while(current != null) {
			// next node of current pointer
			next = current.getNext();
			// set reference of previous to current
			current.setNext(prev);
			// set previous as current 
			prev = current;
			// move to temp reference to go ahead
			current = next;
		}
		// update the head as last node
		head = prev;
		// return updated head
		return head;
	}
}
