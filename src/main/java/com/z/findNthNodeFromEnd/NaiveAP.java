/**
 * 
 */
package com.z.findNthNodeFromEnd;

import com.singlyLL.util.Node;
import com.singlyLL.util.SinglyLLUtils;

/**
 * @author Harshal-Git
 *
 *	-> Find Nth node (N - given input) from the end of the given linked list.
 *
 *	-> base line : 'N' <= linked list size
 *
 *	ex:
 *
 *		i/p: 10 -> 20 -> 30 -> 40 -> 50   & N = 2	=> o/p: 40
 *
 *		i/p: 10 -> 20 -> 30   & N = 3	=> o/p: 10
 *
 *		i/p: 10 -> 20    & N = 3	=> o/p: 
 *
 *		i/p: 10 -> 20 -> 30    & N = 1	=> o/p: 30
 *
 * -> Time complexity: 0(n) + 0(n-p) ~ 0(n)	
 * -> Space complexity:	0(n)
 * -> Auxiliary space: 0(1)
 */
public class NaiveAP {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		// case 1
		printMessage(new int[] {10, 20, 30, 40, 50}, 2);
		
		// case 2
		printMessage(new int[] {10, 20, 30}, 3);
		
		// case 3
		printMessage(new int[] {10, 20}, 3);
		
		// case 4
		printMessage(new int[] {10, 20, 30}, 1);
		
		// case 5
		printMessage(new int[] {10, 20, 30, 40, 50, 60, 70}, 2);
	}

	/**
	 * @param elements
	 * @param n
	 */
	private static void printMessage(int[] elements, int n) {
		Node head = null;
		head = SinglyLLUtils.prepareLL(elements);
		System.out.println("\nLinked list: "+SinglyLLUtils.printLL(head));
		System.out.println(n+"th element from the end of the list = "+findNthElementFromList(head, n));
	}

	/**
	 * find 'n'th element from last node from the given list
	 * @param head - head of the list
	 * @param n - position
	 * @return - returns 'n'th element from the last node of the list 
	 */
	private static String findNthElementFromList(Node head, int n) {
		// if list is null
		if(head == null) {
			return "";
		}
		// calculate length of the list
		int length = 0;
		Node current = head;
		while(current != null) {
			current = current.getNext();
			length++;
		}
		// if 'n' goes beyond length; return EMPTY
		if(n > length) {
			return "";
		}
		// otherwise find (length - n) element from start
		int index = 0;
		current = head;
		while(index < (length - n)) {
			current = current.getNext();
			index++;
		}
		// return value of current node
		return String.valueOf(current.getValue());
	}

}
