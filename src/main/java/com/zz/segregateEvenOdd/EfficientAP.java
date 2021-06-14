/**
 * 
 */
package com.zz.segregateEvenOdd;

import com.aa.utils.Node;
import com.aa.utils.SinglyLLUtil;

/**
 * @author Harshal-Git
 *
 *	-> For given linked list; segregate EVEN & ODD nodes from the list.
 *	
 *	-> Approach : This is 2 sub list approach of ODD & EVEN type and at last once all the nodes are traversed; we will merge
 *		both independent lists into one list.
 *
 *		We need to maintain the order of elements after segregation also.
 *
 *  	ex:
 *  		i/p: 17 -> 15 -> 8 -> 12 -> 10 -> 5 -> 4	=> o/p: 8 -> 12 -> 10 -> 4 -> 17 -> 15 -> 5
 *  
 *  		i/p: 8 -> 12 -> 10 	=> o/p: 8 -> 12 -> 10
 *  
 *  		i/p: 17 -> 15 -> 5 => o/p: 17 -> 15 -> 5
 *  
 *  -> This is similar to the way partition is done. 
 *  
 * -> Time complexity: 0(n)	
 * -> Space complexity: 0(n)	
 * -> Auxiliary space: 0(a) + 0(b) [a - number of EVEN element / b - number of ODD elements] ~ 0(n)
 * 
 */
public class EfficientAP {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		Node head = null;

		// case 1
		head = SinglyLLUtil.prepareLL(new int[] {17, 15, 8, 12, 10, 5, 4});
		printMessage(head);
		
		// case 2
		head = SinglyLLUtil.prepareLL(new int[] {8, 12, 10});
		printMessage(head);
		
		// case 3
		head = SinglyLLUtil.prepareLL(new int[] {17, 15, 5});
		printMessage(head);
		
		// case 4
		head = SinglyLLUtil.prepareLL(new int[] {1, 2, 3, 4, 5});
		printMessage(head);
	}

	/**
	 * @param head
	 */
	private static void printMessage(Node head) {
		System.out.println("\nLinked list: "+SinglyLLUtil.printLL(head));
		head = segregateLL(head);
		System.out.println("Updated list: "+SinglyLLUtil.printLL(head));
	}

	/**
	 * method to segregate given linked list with EVEN -> ODD formation
	 * @param head - head of the linked list
	 * @return - updated linked list in EVEN -> ODD manner
	 */
	private static Node segregateLL(Node head) {
		// head validation for null list OR single element list
		if(head == null || head.getNext() == null) {
			return head;
		}
		// iterate through the list with 2 list formation
		Node evenNodes = null, oddNodes = null;
		Node evenHead = null, oddHead = null, tempNode = null;
		Node currentNode = head;
		while(currentNode != null) {
			tempNode = new Node(currentNode.getValue());
			// check for EVEN
			if(isEven(tempNode.getValue())) {
				// if EVEN list is empty
				if(evenHead == null) {
					evenHead = tempNode;
				} else {
					// otherwise add new element in existing list
					evenNodes.setNext(tempNode);
				}
				// move pointer ahead
				evenNodes = tempNode;
			} else {
				// check for ODD
				if(oddHead == null) {
					// if ODD list is empty
					oddHead = tempNode;
				} else {
					// otherwise add new element to existing list
					oddNodes.setNext(tempNode);
				}
				// move pointer ahead
				oddNodes = tempNode;
			}
			// process next node
			currentNode = currentNode.getNext();
		}
		// at the end; combine both lists
		if(evenHead == null) {
			return oddHead;
		} else {
			evenNodes.setNext(oddHead);
			return evenHead;
		}
	}

	/**
	 * @param value
	 * @return
	 */
	private static boolean isEven(int value) {
		return (((value % 2) == 0) ? (Boolean.TRUE) : (Boolean.FALSE));
	}

}
