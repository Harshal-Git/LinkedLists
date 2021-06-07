/**
 * 
 */
package com.z.reverseLL;

import com.singlyLL.util.Node;
import com.singlyLL.util.SinglyLLUtils;

/**
 * @author Harshal-Git
 *
 *	-> program to reverse the given singly linked list (recursive approach)
 *
 * -> Time complexity:	
 * -> Space complexity:	
 * -> Auxiliary space:  
 */
public class ReverseSinglyLLRecursive {

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
		Node head = SinglyLLUtils.prepareLL(elements);
		System.out.println("\nLinked list: "+SinglyLLUtils.printLL(head));
		head = reverseLL(head);
		System.out.println("Reversed linked list: "+SinglyLLUtils.printLL(head));
	}

	/**
	 * method to reverse the given linked list
	 * @param head - head of the linked list
	 * @return - updated head with reversed linked list 
	 */
	private static Node reverseLL(Node head) {
		return null;
	}
}
