/**
 * 
 */
package com.zz.swapInPairs;

import com.aa.utils.Node;
import com.aa.utils.SinglyLLUtil;

/**
 * @author Harshal-Git
 *
 *	-> Given a linked list; we need to swap node pairs of the list.
 *
 * 	-> Base line : if we are allowed to change value of the nodes. So not a great solution if list node value is of a custom type.
 *
 * 	-> ex:
 * 
 * 		i/p: 1 -> 2 -> 3 -> 4		=> o/p: 2 -> 1 -> 4 -> 3
 * 
 * 		i/p: 1 -> 2 -> 3 -> 4 -> 5	=> o/p: 2 -> 1 -> 4 -> 3 -> 5
 * 
 * -> Time complexity: O(n/2) [for alternate node processing] ~ O(n)	
 * -> Space complexity: 0(n)	
 * -> Auxiliary space: 0(1)
 * 
 * [PENDING - EFFICIENT APPROACH - WHEN CHANGING VALUE IS NOT ALLOWED]
 */
public class NaiveAP {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		Node head = null;

		// case 1
		head = SinglyLLUtil.prepareLL(new int[] {1, 2, 3, 4});
		printMessage(head);

		// case 2
		head = SinglyLLUtil.prepareLL(new int[] {1, 2, 3, 4, 5});
		printMessage(head);
	}

	/**
	 * @param head
	 */
	private static void printMessage(Node head) {
		System.out.println("\nLinked list: "+SinglyLLUtil.printLL(head));
		swapPairs(head);
		System.out.println("Updated list: "+SinglyLLUtil.printLL(head));
	}

	/**
	 * @param head
	 * @return
	 */
	private static void swapPairs(Node head) {
		// head validation
		if(head == null || head.getNext() == null) {
			return;
		} 
		// iterate over all nodes
		Node currentNode = head;
		while(currentNode != null && currentNode.getNext() != null) {
			// swap consecutive node values
			swapNodeValues(currentNode, currentNode.getNext());
			// move 2 nodes ahead
			currentNode = currentNode.getNext().getNext();
		}
	}

	/**
	 * method to swap values of given nodes
	 * @param node1 
	 * @param node2
	 */
	private static void swapNodeValues(Node node1, Node node2) {
		int tempNodeVal = node2.getValue();
		node2.setValue(node1.getValue());
		node1.setValue(tempNodeVal);
	}
}
