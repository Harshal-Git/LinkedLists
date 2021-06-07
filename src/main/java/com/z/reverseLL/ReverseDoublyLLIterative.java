/**
 * 
 */
package com.z.reverseLL;

import com.doublyLL.util.DoublyLLUtils;
import com.doublyLL.util.Node;

/**
 * @author Harshal-Git
 *
 *	-> program to reverse the given doubly linked list
 *
 * -> Time complexity:	0(n)
 * -> Space complexity:	0(n)
 * -> Auxiliary space:  0(1)
 */
public class ReverseDoublyLLIterative {

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
		Node head = DoublyLLUtils.prepareLL(elements);
		System.out.println("\nLinked list: "+DoublyLLUtils.printLL(head));
		head = reverseLL(head);
		System.out.println("Reversed linked list: "+DoublyLLUtils.printLL(head));
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
		Node previousNode = null;
		// iterate over all elements 
		// 2 pointers method (previous & head)
		while(head != null) {
			previousNode = head;
			head = head.getNext();
			// swap references of of previous node
			swapRefereces(previousNode);
		}
		// return the updated head
		return previousNode;
	}

	/**
	 * swap previous & next references of given node  
	 * @param node
	 */
	private static void swapRefereces(Node node) {
		Node prev = node.getPrevious();
		node.setPrevious(node.getNext());
		node.setNext(prev);		
	}
}
