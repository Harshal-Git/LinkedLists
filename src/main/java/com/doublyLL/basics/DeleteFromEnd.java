/**
 * 
 */
package com.doublyLL.basics;

import com.aa.utils.DoublyLLUtil;
import com.aa.utils.Node;

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
		printMessage(DoublyLLUtil.prepareLL(new int[] {10, 20, 30, 40, 50}));

		// case 2
		printMessage(DoublyLLUtil.prepareLL(new int[] {10, 30, 60}));

		// case 3
		printMessage(DoublyLLUtil.prepareLL(new int[] {10, 5}));
		
		// case 4
		printMessage(DoublyLLUtil.prepareLL(new int[] {8}));
		
		// case 5
		printMessage(DoublyLLUtil.prepareLL(null));
	}

	/**
	 * delete first element from given linked list
	 * @param nodeInt
	 */
	private static void printMessage(Node head) {
		System.out.println("\nExisting linked list: "+DoublyLLUtil.printLL(head));
		head = DoublyLLUtil.deleteFromEnd(head);
		System.out.println("Updated linked list: "+DoublyLLUtil.printLL(head));
	}

}
