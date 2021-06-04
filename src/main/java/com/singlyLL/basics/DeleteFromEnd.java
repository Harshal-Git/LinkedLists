/**
 * 
 */
package com.singlyLL.basics;

import com.singlyLL.util.SinglyLLUtils;
import com.singlyLL.util.Node;

/**
 * @author Harshal-Git
 *
 *	-> delete from end of the linked list
 */
public class DeleteFromEnd {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		// case 1
		printMessage(SinglyLLUtils.prepareLL(new int[] {10, 20, 30, 40, 50}));

		// case 2
		printMessage(SinglyLLUtils.prepareLL(new int[] {10, 30, 60}));

		// case 3
		printMessage(SinglyLLUtils.prepareLL(new int[] {10, 5}));
		
		// case 4
		printMessage(SinglyLLUtils.prepareLL(new int[] {8}));
		
		// case 5
		printMessage(SinglyLLUtils.prepareLL(null));
	}

	/**
	 * delete first element from given linked list
	 * @param nodeInt
	 */
	private static void printMessage(Node head) {
		System.out.println("\nExisting linked list: "+SinglyLLUtils.printLL(head));
		head = SinglyLLUtils.deleteFromEnd(head);
		System.out.println("Updated linked list: "+SinglyLLUtils.printLL(head));
	}

}
