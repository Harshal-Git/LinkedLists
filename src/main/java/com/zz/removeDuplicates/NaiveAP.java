/**
 * 
 */
package com.zz.removeDuplicates;

import com.aa.utils.Node;
import com.aa.utils.SinglyLLUtil;

/**
 * @author Harshal-Git
 *
 *	-> Given a linked list with sorted & duplicate elements. Need to remove such duplicates from the list.
 *
 *	ex:
 *
 *		i/p : 10 -> 20 -> 20 -> 30 -> 30 -> 30 	=> 	o/p: 10 -> 20 -> 30
 *
 *		i/p : 5 -> 10 -> 15 -> 20 	=> 	o/p: 5 -> 10 -> 15 -> 20
 *
 *		i/p : null 	=> 	o/p: null
 *
 * -> Time complexity:  0(n)	
 * -> Space complexity: 0(n)	
 * -> Auxiliary space:  0(1)
 */
public class NaiveAP {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		// case 1
		printMessage(new int[] {10, 20, 20, 30, 30, 30});

		// case 2
		printMessage(new int[] {5, 5, 15, 15, 25, 25, 35});

		// case 3
		printMessage(new int[] {2, 4, 6, 8, 10});

		// case 4
		printMessage(null);

		// case 5
		printMessage(new int[] {5, 5});

		// case 6
		printMessage(new int[] {5, 8});
	}

	/**
	 * @param elements
	 */
	private static void printMessage(int[] elements) {
		Node head = null;
		head = SinglyLLUtil.prepareLL(elements);
		System.out.println("\nLinked list: "+SinglyLLUtil.printLL(head));
		removeDuplicates(head);
		System.out.println("Updated linked list: "+SinglyLLUtil.printLL(head));
	}

	/**
	 * method to remove duplicates from the given linked list
	 * @param head - head of the linked list
	 */
	private static void removeDuplicates(Node head) {
		// if list is NULL OR a single element exist: do nothing
		if(head == null || head.getNext() == null) {
			return;
		}
		// iterate over all nodes and remember the last unique node
		int lastReadVal = head.getValue();
		Node current = head.getNext();	// second node
		Node previous = head;			// first node
		while(current != null) {
			// if current node is not same as last read node; read further
			if(current.getValue() != lastReadVal) {
				previous = current;
				lastReadVal = current.getValue();
			} else {
				// if current node is same as last read node; delete current node
				previous.setNext(current.getNext());
			}
			// move to next node
			current = current.getNext();
		}
	}

}
