/**
 * 
 */
package com.circularLL.basics;

import com.circularLL.util.CircularLLUtils;
import com.circularLL.util.Node;

/**
 * @author Harshal-Git
 *
 *	-> insert new element at start of the circular linked list
 *
 *	-> Naive approach :  In this approach; we will find the last element of the linked list and update the last node to refer the
 *						new node & mean while head is assigned to new node.
 *
 *	-> Efficient Approach : In this approach, we are provided the tail of the circular linked list also in the input. This will 
 *							make the work easy and we just make the tail to refer the new node & reset the root as new node. This 
 *							approach will make insertion at the head possible in O(1) time.
 */
public class InsertAtStartNaive {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		// case 1
		printMessage(new int[] {30, 20, 10}, 5);

		// case 2
		printMessage(new int[] {10}, 25);

		// case 3
		printMessage(null, 8);
	}

	/**
	 * @param existingValues 
	 * @param newVal
	 */
	private static void printMessage(int[] existingValues, int newVal) {
		int currentSize = -1;
		if(existingValues == null) {
			currentSize = 0; 
		} else {
			currentSize = existingValues.length;
		}
		// prepare linked list
		Node head = null;
		for(int index = 0; index < currentSize; index++) {
			head = CircularLLUtils.insertAtStart(head, existingValues[index]);
		}
		System.out.println("\nExisting Linked list: "+CircularLLUtils.printCLL(head));
		System.out.println("New value insertion at start : "+newVal);
		head = CircularLLUtils.insertAtStart(head, newVal);
		System.out.println("New Linked list: "+CircularLLUtils.printCLL(head));		
	}
}
