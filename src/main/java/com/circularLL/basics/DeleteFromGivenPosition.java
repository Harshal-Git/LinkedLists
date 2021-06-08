/**
 * 
 */
package com.circularLL.basics;

import com.aa.utils.CircularLLUtil;
import com.aa.utils.Node;

/**
 * @author Harshal-Git
 *
 */
public class DeleteFromGivenPosition {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		// case 1
		printMessage(CircularLLUtil.prepareLL(new int[] {10, 20, 30}), 2);

		// case 2
		printMessage(CircularLLUtil.prepareLL(new int[] {10, 30}), 2);

		// case 3
		printMessage(CircularLLUtil.prepareLL(new int[] {10}), 1);

		// case 4
		printMessage(CircularLLUtil.prepareLL(null), 5);
		
		// case 5
		printMessage(CircularLLUtil.prepareLL(new int[] {5, 4, 3, 2, 1}), 5);

		// case 6
		printMessage(CircularLLUtil.prepareLL(new int[] {10, 20, 30, 40}), 1);
	}

	/**
	 * 
	 * @param head
	 * @param k
	 */
	private static void printMessage(Node head, int k) {
		System.out.println("\nExisting linked list: "+CircularLLUtil.printLL(head));
		System.out.println("Delete node from position: "+k);
		head = CircularLLUtil.deleteFromPosition(head, k);
		System.out.println("Updated linked list: "+CircularLLUtil.printLL(head));
	}
}
