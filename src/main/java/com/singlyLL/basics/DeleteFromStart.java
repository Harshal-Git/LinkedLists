/**
 * 
 */
package com.singlyLL.basics;

import com.aa.utils.Node;
import com.aa.utils.SinglyLLUtil;

/**
 * @author Harshal-Git
 *
 *	-> delete from start of the linked list
 */
public class DeleteFromStart {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		// case 1
		printMessage(SinglyLLUtil.prepareLL(new int[] {10, 20, 30}));

		// case 2
		printMessage(SinglyLLUtil.prepareLL(new int[] {10, 30}));

		// case 3
		printMessage(SinglyLLUtil.prepareLL(new int[] {10}));
		
		// case 4
		printMessage(SinglyLLUtil.prepareLL(null));
	}

	/**
	 * delete first element from given linked list
	 * @param nodeInt
	 */
	private static void printMessage(Node head) {
		System.out.println("\nExisting linked list: "+SinglyLLUtil.printLL(head));
		head = SinglyLLUtil.deleteFromStart(head);
		System.out.println("Updated linked list: "+SinglyLLUtil.printLL(head));
	}

}
