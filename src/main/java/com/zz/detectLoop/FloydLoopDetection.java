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
 *	-> Identify whether a loop exist in the given linked list.
 *
 * -> Time complexity:	O(m + n) [m  - elements which are not part of the loop / n - elements part of the loop]
 * -> Space complexity:	O(n)
 * -> Auxiliary space: 0(1)
 */
public class FloydLoopDetection {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		// case 1 - singular linked list
		Node head1 = SinglyLLUtil.prepareLL(new int[] {1, 2, 3, 4, 5});
		System.out.println("\nLinked list: "+SinglyLLUtil.printLL(head1)+" : has any loop? "+findLoop(head1));

		// case 2 - circular linked list
		Node head2 = CircularLLUtil.prepareLL(new int[] {1, 2, 3, 4, 5});
		System.out.println("\nLinked list: "+CircularLLUtil.printLL(head2)+" : has any loop? "+findLoop(head2));
		
		// case 3 - custom cyclic linked list
		Node head3 = CyclicLLUtil.getCyclicLoopLL();
		System.out.println("\nLinked list: "+CyclicLLUtil.getCyclicLLString()+" : has any loop? "+findLoop(head3));
	}

	/**
	 * method to check whether given list has loop OR not
	 * @param head - head of the linked list
	 * @return - Yes - if loop exist; No otherwise
	 */
	private static String findLoop(Node head) {
		// head validation
		if(head == null || head.getNext() == null) {
			return "No";
		}
		// single node circular linked list
		if(head.getNext() == head) {
			return "Yes";
		}
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
				return "Yes";
			}
		}
		// default return
		return "No";
	}

}
