/**
 * 
 */
package com.circularLL.basics;

import com.aa.utils.CircularLLUtil;
import com.aa.utils.Node;

/**
 * @author Harshal-Git
 *
 *	-> delete from start of the linked list
 */
public class DeleteFromStartNaive {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		// case 1
		printMessage(CircularLLUtil.prepareLL(new int[] {10, 20, 30}));

		// case 2
		printMessage(CircularLLUtil.prepareLL(new int[] {10, 30}));

		// case 3
		printMessage(CircularLLUtil.prepareLL(new int[] {10}));

		// case 4
		printMessage(CircularLLUtil.prepareLL(null));
		
		// case 5
		printMessage(CircularLLUtil.prepareLL(new int[] {5, 4, 3, 2, 1}));
	}

	/**
	 * @param head
	 */
	private static void printMessage(Node head) {
		System.out.println("\nExisting linked list: "+CircularLLUtil.printLL(head));
		head = CircularLLUtil.deleteFromStart(head);
		System.out.println("Updated linked list: "+CircularLLUtil.printLL(head));
	}

}
