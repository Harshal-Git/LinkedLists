/**
 * 
 */
package com.singlyLL.basics;

import com.aa.utils.Node;
import com.aa.utils.SinglyLLUtil;

/**
 * @author Harshal-Git
 *
 */
public class InsertAtPosition {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		// case 1
		printMessage(new int[] {10, 30, 50, 70}, 20, 2);

		// case 2
		printMessage(new int[] {5, 15, 25, 35}, 10, 5);
		
		// case 3
		printMessage(new int[] {5}, 4, 6);
		
		// case 4
		printMessage(null, 4, 6);
		
		// case 5
		printMessage(new int[] {5, 15, 25, 35}, 10, 4);
		
		// case 6
		printMessage(new int[] {10, 20}, 5, 4);
	}

	/**
	 * 
	 * @param llElements - prepare linked list with these elements
	 * @param newValue - new element to be inserted in the above elements
	 * @param position - position at which new element needs to be inserted
	 */
	private static void printMessage(int[] llElements, int newValue, int position) {
		// prepare linked list
		Node head = SinglyLLUtil.prepareLL(llElements);
		System.out.println("\nCurrent linked list: "+SinglyLLUtil.printLL(head));
		System.out.println("New element = "+newValue+" to be inserted at position: "+position);
		// insert element
		head = SinglyLLUtil.insertAtPosition(head, newValue, position);
		// print updated list
		System.out.println("Updated linked list: "+SinglyLLUtil.printLL(head));
	}

}
