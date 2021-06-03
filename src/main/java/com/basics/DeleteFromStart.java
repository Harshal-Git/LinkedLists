/**
 * 
 */
package com.basics;

import com.util.IntLLUtils;
import com.util.NodeInt;

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
		printMessage(IntLLUtils.prepareLL(new int[] {10, 20, 30}));

		// case 2
		printMessage(IntLLUtils.prepareLL(new int[] {10, 30}));

		// case 3
		printMessage(IntLLUtils.prepareLL(new int[] {10}));
		
		// case 4
		printMessage(IntLLUtils.prepareLL(null));
	}

	/**
	 * delete first element from given linked list
	 * @param nodeInt
	 */
	private static void printMessage(NodeInt head) {
		System.out.println("\nExisting linked list: "+IntLLUtils.printLL(head));
		head = IntLLUtils.deleteFromStart(head);
		System.out.println("Updated linked list: "+IntLLUtils.printLL(head));
	}

}
