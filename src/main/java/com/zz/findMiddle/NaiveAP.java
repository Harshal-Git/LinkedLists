/**
 * 
 */
package com.zz.findMiddle;

import com.aa.utils.Node;
import com.aa.utils.SinglyLLUtil;

/**
 * @author Harshal-Git
 *
 *	-> For the given linked list; find middle of it.
 *
 *	-> base line : in case of 2 middle nodes, print data for the right most node.
 *
 *	-> Naive approach : find length of the linked list (len) & then print the element at (len/2) position.  
 *
 *	ex:
 *		i/p: 10 -> 5 -> 20 -> 15 -> 25 		=> o/p: 20
 *
 *		i/p: 10 -> 5 -> 20 -> 15 -> 25 -> 30	=> o/p: 15
 *
 *		i/p: 10 	=> o/p: 10
 *
 *		i/p: null 		=> o/p: BLANK
 *
 *		i/p: 10 -> 20 		=> o/p: 20
 *
 * -> Time complexity: 0(n) + 0(n/2) ~ 0(n)	
 * -> Space complexity:	0(n)
 * -> Auxiliary space:  0(1)
 */
public class NaiveAP {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		// case 1
		printMessage(new int[] {10, 5, 20, 15, 25});

		// case 2
		printMessage(new int[] {10, 5, 20, 15, 25, 30});
		
		// case 3
		printMessage(new int[] {10});
		
		// case 4
		printMessage(null);
		
		// case 5
		printMessage(new int[] {10, 20});
		
		// case 6
		printMessage(new int[] {10, 20, 30, 40, 50});
		
		// case 7
		printMessage(new int[] {10, 20, 30, 40, 50, 60});
	}

	/**
	 * @param elements
	 */
	private static void printMessage(int[] elements) {
		Node head = null;
		head = SinglyLLUtil.prepareLL(elements);
		System.out.println("\nLinked list: "+SinglyLLUtil.printLL(head));
		System.out.println("Middle of the list: "+findMiddleOfList(head));
	}

	/**
	 * find middle element of the linked list
	 * @param head - head of the linked list
	 * @return - middle element of the list
	 * <br/> nothing if the list is empty
	 */
	private static String findMiddleOfList(Node head) {
		// check for null head
		if(head == null) {
			return "";
		}
		// find length of the list
		int length = 0;
		Node current = head;
		while(current != null) {
			length++;
			current = current.getNext();
		}
		// once length is obtained; find middle node
		current = head;
		int index = 0;
		while(index < (length/2)) {
			current = current.getNext();
			index++;
		}
		// return the value of current node
		return String.valueOf(current.getValue());
	}

}
