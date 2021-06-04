/**
 * 
 */
package com.singlyLL.basics;

import com.singlyLL.util.SinglyLLUtils;
import com.singlyLL.util.Node;

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
		printMessage(SinglyLLUtils.prepareLL(new int[] {10, 20, 30}));

		// case 2
		printMessage(SinglyLLUtils.prepareLL(new int[] {10, 30}));

		// case 3
		printMessage(SinglyLLUtils.prepareLL(new int[] {10}));
		
		// case 4
		printMessage(SinglyLLUtils.prepareLL(null));
	}

	/**
	 * delete first element from given linked list
	 * @param nodeInt
	 */
	private static void printMessage(Node head) {
		System.out.println("\nExisting linked list: "+SinglyLLUtils.printLL(head));
		head = SinglyLLUtils.deleteFromStart(head);
		System.out.println("Updated linked list: "+SinglyLLUtils.printLL(head));
	}

}
