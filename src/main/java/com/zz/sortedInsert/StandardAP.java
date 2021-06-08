/**
 * 
 */
package com.zz.sortedInsert;

import com.aa.utils.Node;
import com.aa.utils.SinglyLLUtil;

/**
 * @author Harshal-Git
 *
 *	-> Given a sorted linked list; insert the given new element in sorted manner.
 *
 *	ex:
 *		i/p: 10 -> 20 -> 30 -> 40 	& 	p = 25	=> o/p: 10 -> 20 -> 25 -> 30 -> 40
 *
 *		i/p: 10 -> 25 	& 	p = 5	=> o/p: 5 -> 10 -> 25
 *
 *		i/p: 10 -> 20 	& 	p = 30	=> o/p: 10 -> 20 -> 30 
 *
 * -> Time complexity: 0(n) - 'n' position value (worst case - after the last node)
 * 						0(1) - best case 	
 * -> Space complexity:	O(n)
 * -> Auxiliary space:  O(n)
 */
public class StandardAP {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		Node head = null;

		// case 1
		head = SinglyLLUtil.prepareLL(new int[] {10, 20, 30, 40});
		printMessage(head, 25);

		// case 2
		head = SinglyLLUtil.prepareLL(new int[] {10, 25});
		printMessage(head, 5);

		// case 3
		head = SinglyLLUtil.prepareLL(new int[] {10, 20});
		printMessage(head, 30);

		// case 4
		head = SinglyLLUtil.prepareLL(null);
		printMessage(head, 10);

		// case 5
		head = SinglyLLUtil.prepareLL(new int[] {10, 20, 30, 40, 50});
		printMessage(head, 45);
	}

	/**
	 * @param head
	 * @param newVal
	 */
	private static void printMessage(Node head, int newVal) {
		System.out.println("\nLinked list: "+SinglyLLUtil.printLL(head));
		System.out.println("New element insertion: "+newVal);
		head = insertSorted(head, newVal);
		System.out.println("Updated linked list: "+SinglyLLUtil.printLL(head));
	}

	/**
	 * @param head - head of the linked list
	 * @param newVal - new value to be inserted in sorted manner
	 * @return - updated linked list with new data
	 */
	private static Node insertSorted(Node head, int newVal) {
		// prepare new node
		Node newNode = new Node(newVal);
		// if linked list is empty - return the new node as head
		if(head == null) {
			return newNode;
		}
		// if new value is smaller than first node, 
		// then make new node as first node 
		if(newVal < head.getValue()) {
			newNode.setNext(head);
			head = newNode;
			return head;
		}
		// iterate over complete loop to find correct position 
		// of the new node to be inserted
		Node current = head;
		while((current.getNext() != null) && 
				(current.getNext().getValue() < newVal)) {
			current = current.getNext();
		}
		// insert new element after current node
		newNode.setNext(current.getNext());
		current.setNext(newNode);
		// return updated head
		return head;
	}
}
