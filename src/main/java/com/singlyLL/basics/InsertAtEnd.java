/**
 * 
 */
package com.singlyLL.basics;

import com.singlyLL.util.SinglyLLUtils;
import com.singlyLL.util.Node;

/**
 * @author Harshal-Git
 *
 *	-> insert new element at end of the linked list
 */
public class InsertAtEnd {

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
			head = SinglyLLUtils.insertAtEnd(head, existingValues[index]);
		}
		System.out.println("\nExisting Linked list: "+SinglyLLUtils.printLL(head));
		System.out.println("New value insertion at end : "+newVal);
		head = SinglyLLUtils.insertAtEnd(head, newVal);
		System.out.println("New Linked list: "+SinglyLLUtils.printLL(head));		
	}
}