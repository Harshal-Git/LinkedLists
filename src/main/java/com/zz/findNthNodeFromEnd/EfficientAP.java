/**
 * 
 */
package com.zz.findNthNodeFromEnd;

import com.aa.utils.Node;
import com.aa.utils.SinglyLLUtil;

/**
 * @author Harshal-Git
 *
 *	-> Find Nth node (N - given input) from the end of the given linked list.
 *
 *	-> base line : 'N' <= linked list size
 *	
 *	-> efficient approach : 
 *		Initially create a pointer PTR1 which is Nth position from start. 
 *		Now create another pointer PTR2 pointing to head and move both PTR1 & PTR2 one position at a time.
 *		Once PTR2 is done iterating, PTR1 will give the exact position.
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
 * -> Time complexity: 	O(n) [single iteration]
 * -> Space complexity:	O(n)
 * -> Auxiliary space: 0(1)
 */
public class EfficientAP {

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
	private static void printMessage(int[] elements, int position) {
		Node head = null;
		head = SinglyLLUtil.prepareLL(elements);
		System.out.println("\nLinked list: "+SinglyLLUtil.printLL(head));
		System.out.println("("+position+") element from the end of the list = "+findNthElementFromList(head, position));
	}

	/**
	 * find 'n'th element from last node from the given list
	 * @param head - head of the list
	 * @param n - position
	 * @return - returns 'n'th element from the last node of the list 
	 */
	private static String findNthElementFromList(Node head, int position) {

		// move (N-1) point from head ahead
		Node forwardPtr = head;
		int count = 1;
		while(forwardPtr!= null && count < position) {
			forwardPtr = forwardPtr.getNext();
			count++;
		}

		// check whether count has crossed the link?
		if(count == position && forwardPtr == null) {
			return "-1";
		}

		// start a new pointer from initial position
		Node followerPtr = head;

		// move both pointers ahead
		while(forwardPtr != null && forwardPtr.getNext() != null) {
			forwardPtr = forwardPtr.getNext();
			followerPtr = followerPtr.getNext();
		}
		// return value
		return String.valueOf(followerPtr.getValue());
	}

}
