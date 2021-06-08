/**
 * 
 */
package com.singlyLL.basics;

import com.aa.utils.Node;
import com.aa.utils.SinglyLLUtil;

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
		printMessage(SinglyLLUtil.prepareLL(new int[] {10, 20, 30, 40, 50}));

		// case 2
		printMessage(SinglyLLUtil.prepareLL(new int[] {10, 30, 60}));

		// case 3
		printMessage(SinglyLLUtil.prepareLL(new int[] {10, 5}));
		
		// case 4
		printMessage(SinglyLLUtil.prepareLL(new int[] {8}));
		
		// case 5
		printMessage(SinglyLLUtil.prepareLL(null));
	}

	/**
	 * delete first element from given linked list
	 * @param nodeInt
	 */
	private static void printMessage(Node head) {
		System.out.println("\nExisting linked list: "+SinglyLLUtil.printLL(head));
		head = SinglyLLUtil.deleteFromEnd(head);
		System.out.println("Updated linked list: "+SinglyLLUtil.printLL(head));
	}

}
