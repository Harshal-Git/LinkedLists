/**
 * 
 */
package com.zz.deleteNodeWithoutHead;

import com.aa.utils.Node;
import com.aa.utils.SinglyLLUtil;

/**
 * @author Harshal-Git
 *
 *	-> Delete given node from given singly linked list without it's head given. The node needs to be deleted; 
 *		will be given in the input.
 *
 *	-> Base line : node to be deleted will never be the last node. Condition : we must be allowed to change the value of given node.
 *		As we don't have previous node data; with this approach; last node deletion will not work.
 *
 * -> Time complexity: 0(1)	
 * -> Space complexity: 0(1)	
 * -> Auxiliary space: 0(1)
 *
 */
public class StandardAP {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		Node head = null;

		// case 1 (delete 99)
		head = SinglyLLUtil.prepareLL(new int[] {1, 2, 3, 4, 99, 5});
		printMessage(head, head.getNext().getNext().getNext().getNext());

		// case 2 (delete 30)
		head = SinglyLLUtil.prepareLL(new int[] {10, 20, 30, 40, 25});
		printMessage(head, head.getNext().getNext());
		
		// case 3 (delete 10)
		head = SinglyLLUtil.prepareLL(new int[] {10, 100, 200, 300, 400});
		printMessage(head, head);
	}

	/**
	 * @param head
	 * @param deleteNode 
	 */
	private static void printMessage(Node head, Node deleteNode) {
		System.out.println("\nLinked list: "+SinglyLLUtil.printLL(head));
		System.out.println("Delete node: "+deleteNode.getValue());
		deleteNode(deleteNode);
		System.out.println("Updated linked list: "+SinglyLLUtil.printLL(head));
	}

	/**
	 * method to delete given node (head is not given)
	 * @param deleteNode - node needs to be deleted
	 */
	private static void deleteNode(Node deleteNode) {
		// node validation
		if(deleteNode == null) {
			return;
		}
		// copy data of next node to current node
		// 
		deleteNode.setValue(deleteNode.getNext().getValue());
		deleteNode.setNext(deleteNode.getNext().getNext());
	}
}
