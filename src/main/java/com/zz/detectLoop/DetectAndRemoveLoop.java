/**
 * 
 */
package com.zz.detectLoop;

import com.aa.utils.CircularLLUtil;
import com.aa.utils.CyclicLLUtil;
import com.aa.utils.Node;
import com.aa.utils.SinglyLLUtil;

/**
 * @author Harshal-Git
 *
 *	-> Identify whether the given linked list has any loop OR not and if it has; remove the loop.
 *
 *	-> After loop removal; every loop will behave as singly linked list. Hence printing with that utility 
 *		method will be possible. If any incompatible list is provided to that method; it will cause stack overflow error. 
 *
 * -> Time complexity:	O(m + n) [m  - elements which are not part of the loop / n - elements part of the loop]
 * -> Space complexity:	O(n)
 * -> Auxiliary space: 0(1)
 */
public class DetectAndRemoveLoop {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		// case 1 - singular linked list
		Node head1 = SinglyLLUtil.prepareLL(new int[] {1, 2, 3, 4, 5});
		System.out.println("\nLinked list: "+SinglyLLUtil.printLL(head1));
		head1 = findAndRemoveLoop(head1);
		System.out.println("Updated linked list: "+SinglyLLUtil.printLL(head1));

		// case 2 - custom cyclic linked list
		Node head2 = CyclicLLUtil.getCyclicLoopLL();
		System.out.println("\nLinked list: "+CyclicLLUtil.getCyclicLLString());
		head2 = findAndRemoveLoop(head2);
		System.out.println("Updated linked list: "+SinglyLLUtil.printLL(head2));
		
		// case 3 - circular single node linked list
		Node head3 = CircularLLUtil.prepareLL(new int[] {10});
		System.out.println("\nLinked list: "+CircularLLUtil.printLL(head3));
		head3 = findAndRemoveLoop(head3);
		System.out.println("Updated linked list: "+SinglyLLUtil.printLL(head3));
	}

	/**
	 * method to detect a loop in given linked list & remove the loop
	 * @param head - head of the linked list
	 * @return - linked list with removed loop
	 */
	private static Node findAndRemoveLoop(Node head) {
		// head validation
		if(head == null) {
			return head;
		}
		// find whether list has loop OR not
		// prepare 2 pointers
		Node fastPtr = head;
		Node slowPtr = head;
		// iterate through all nodes
		while(fastPtr != null && fastPtr.getNext() != null) {
			// slow pointer by 1 position
			slowPtr = slowPtr.getNext();
			// fast pointer by 2 positions
			fastPtr = fastPtr.getNext().getNext();
			// if at any moment; they meet; means there is a loop
			if(slowPtr == fastPtr) {
				System.out.println("Loop exist.");
				break;
			}
		}
		// if slow & fast pointers didn't match: there is no loop
		if(slowPtr != fastPtr) {
			System.out.println("No loop exist.");
			return head;
		}
		// reset now slow pointer to the head of the list
		slowPtr = head;
		// move both pointers one position; until they match the same next node
		while(slowPtr.getNext() != fastPtr.getNext()) {
			slowPtr = slowPtr.getNext();
			fastPtr = fastPtr.getNext();
		}
		// update the fast pointer next reference to null
		fastPtr.setNext(null);
		// return updated head
		return head;
	}

}
