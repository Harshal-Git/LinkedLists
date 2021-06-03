/**
 * 
 */
package com.basics;

import com.util.IntLLUtils;
import com.util.NodeInt;

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
		printMessage(IntLLUtils.prepareLL(new int[] {10, 20, 30, 40, 50}));

		// case 2
		printMessage(IntLLUtils.prepareLL(new int[] {10, 30, 60}));

		// case 3
		printMessage(IntLLUtils.prepareLL(new int[] {10, 5}));
		
		// case 4
		printMessage(IntLLUtils.prepareLL(new int[] {8}));
		
		// case 5
		printMessage(IntLLUtils.prepareLL(null));
	}

	/**
	 * delete first element from given linked list
	 * @param nodeInt
	 */
	private static void printMessage(NodeInt head) {
		System.out.println("\nExisting linked list: "+IntLLUtils.printLL(head));
		head = IntLLUtils.deleteFromEnd(head);
		System.out.println("Updated linked list: "+IntLLUtils.printLL(head));
	}

}
