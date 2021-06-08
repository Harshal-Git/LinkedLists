/**
 * 
 */
package com.circularLL.basics;

import com.aa.utils.CircularLLUtil;
import com.aa.utils.Node;

/**
 * @author Harshal-Git
 *
 *	-> insert new element at end of the linked list
 *
 *	-> Naive approach :  In this approach; we will find the last element of the linked list and update the last node to refer the 
 *						new node & new node will refer to head.
 *
 *	-> Efficient Approach : In this approach, we are provided the tail of the circular linked list also in the input. This will 
 *							make the work easy and we just make the current tail to refer the new node new node will refer head. 
 *							This approach will make insertion at the head possible in O(1) time.
 */
public class InsertAtEndNaive {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		// case 1
		printMessage(new int[] {10, 20, 30}, 40);

		// case 2
		printMessage(new int[] {10}, 100);

		// case 3
		printMessage(null, 5);
	}

	/**
	 * @param head
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
			head = CircularLLUtil.insertAtEnd(head, existingValues[index]);
		}
		System.out.println("\nExisting Linked list: "+CircularLLUtil.printLL(head));
		System.out.println("New value insertion at end : "+newVal);
		head = CircularLLUtil.insertAtEnd(head, newVal);
		System.out.println("New Linked list: "+CircularLLUtil.printLL(head));		
	}
}
