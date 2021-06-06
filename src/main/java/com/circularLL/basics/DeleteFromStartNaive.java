/**
 * 
 */
package com.circularLL.basics;

import com.circularLL.util.CircularLLUtils;
import com.circularLL.util.Node;

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
		printMessage(CircularLLUtils.prepareCLL(new int[] {10, 20, 30}));

		// case 2
		printMessage(CircularLLUtils.prepareCLL(new int[] {10, 30}));

		// case 3
		printMessage(CircularLLUtils.prepareCLL(new int[] {10}));

		// case 4
		printMessage(CircularLLUtils.prepareCLL(null));
		
		// case 5
		printMessage(CircularLLUtils.prepareCLL(new int[] {5, 4, 3, 2, 1}));
	}

	/**
	 * @param head
	 */
	private static void printMessage(Node head) {
		System.out.println("\nExisting linked list: "+CircularLLUtils.printCLL(head));
		head = CircularLLUtils.deleteFromStart(head);
		System.out.println("Updated linked list: "+CircularLLUtils.printCLL(head));
	}

}
