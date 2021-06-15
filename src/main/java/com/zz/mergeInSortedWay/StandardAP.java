/**
 * 
 */
package com.zz.mergeInSortedWay;

import com.aa.utils.Node;
import com.aa.utils.SinglyLLUtil;

/**
 * @author Harshal-Git
 *
 *	-> Given 2 linked list; we need to merge both the lists in sorted manner; without using additional space / storage.
 *
 * -> Time complexity: O(m+n) [m - list 1 elements, n - list 2 elements]
 * -> Space complexity:	O(m+n)
 * -> Auxiliary space: 0(1)
 */
public class StandardAP {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		Node h1 = null, h2 = null;
		
		// case 1
		h1 = SinglyLLUtil.prepareLL(new int[] {10, 20, 30});
		h2 = SinglyLLUtil.prepareLL(new int[] {5, 25});
		printMessage(h1, h2);
		
		// case 2
		h1 = SinglyLLUtil.prepareLL(new int[] {1, 3, 5, 7, 9});
		h2 = SinglyLLUtil.prepareLL(new int[] {2, 4, 6, 8, 10});
		printMessage(h1, h2);

		// case 3
		h1 = SinglyLLUtil.prepareLL(new int[] {10, 20});
		h2 = SinglyLLUtil.prepareLL(null);
		printMessage(h1, h2);
		
		// case 4
		h1 = SinglyLLUtil.prepareLL(new int[] {10});
		h2 = SinglyLLUtil.prepareLL(new int[] {40, 50});
		printMessage(h1, h2);
		
		// case 5
		h1 = SinglyLLUtil.prepareLL(new int[] {10, 20, 30, 40});
		h2 = SinglyLLUtil.prepareLL(new int[] {5, 15, 17, 18, 35});
		printMessage(h1, h2);
	}

	/**
	 * @param h1
	 * @param h2
	 */
	private static void printMessage(Node h1, Node h2) {
		System.out.println("\nLinked list 1: "+SinglyLLUtil.printLL(h1));
		System.out.println("Linked list 2: "+SinglyLLUtil.printLL(h2));
		Node mHead = mergeList(h1, h2);
		System.out.println("Merged list: "+SinglyLLUtil.printLL(mHead));
	}

	/**
	 * method to merge 2 given lists in sorted manner 
	 * @param h1 - head of the list 1
	 * @param h2 - head of the list 2
	 * @return - combined list merged in sorted manner
	 */
	private static Node mergeList(Node h1, Node h2) {
		// input list validations
		if(h1 == null) {
			return h2;
		} 
		if(h2 == null) {
			return h1;
		}
		// first prepare head [smallest first element from both list]
		Node head = null;
		if(h1.getValue() < h2.getValue()) {
			head = h1;
			h1 = h1.getNext();
		} else {
			head = h2;
			h2 = h2.getNext();
		}
		// initialize tail same as head 
		Node tail = head;
		Node temp = null;
		// iterate over both lists & keep moving tail 
		// ahead for every smaller element value from both lists
		while(h1 != null && h2 != null) {
			// list 1 has smaller element
			if(h1.getValue() < h2.getValue()) {
				temp = h1;
				h1 = h1.getNext();
			} else {
				// list 2 has smaller element
				temp = h2;
				h2 = h2.getNext();	
			}
			// move tail ahead
			tail.setNext(temp);
			tail = temp;
		}
		// if any of the list is exhausted; add
		// remaining nodes without any sorting
		if(h1 != null) {
			tail.setNext(h1);
		}
		if(h2 != null) {
			tail.setNext(h2);
		}
		// return head;
		return head;
	}
}
