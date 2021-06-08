/**
 * 
 */
package com.doublyLL.basics;

import com.aa.utils.DoublyLLUtil;
import com.aa.utils.Node;

/**
 * @author Harshal-Git
 *
 *	-> insert new element at start of the linked list
 */
public class InsertAtStart {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		int newVal = 5;

		// case 1
		printMessage(new int[] {10, 20, 30}, newVal);

		// case 2
		printMessage(new int[] {10}, newVal);

		// case 3
		printMessage(null, newVal);
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
			head = DoublyLLUtil.insertAtStart(head, existingValues[index]);
		}
		System.out.println("\nExisting Linked list: "+DoublyLLUtil.printLL(head));
		System.out.println("New value insertion at start : "+newVal);
		head = DoublyLLUtil.insertAtStart(head, newVal);
		System.out.println("New Linked list: "+DoublyLLUtil.printLL(head));		
	}
}
