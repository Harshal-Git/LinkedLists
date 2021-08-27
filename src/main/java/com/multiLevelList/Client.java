/**
 * 
 */
package com.multiLevelList;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author Harshal-Git
 *
 *	Given a multi level linked list. Task is to convert this list into a single level linked list.
 *
 *	Input: 

		11 -> 12 -> 15 -> 17 -> 19 -> null    

		|                  |

		21             	  27 -> 23 -> null

						  |

						  34   -> 38 -> null


	Output: 11 -> 12 > 15 -> 17 -> 19 -> 21 -> 27 -> 23 -> 34 -> 38 -> null

	-> any efficient approach: ? (using 2 pointers ?)
 */
public class Client {

	public static void main(String args[]) {
		
		Node n1 = new Node(11);
		Node n2 = new Node(12);
		Node n3 = new Node(15);
		Node n4 = new Node(17);
		Node n5 = new Node(19);

		Node n6 = new Node(21);
		Node n7 = new Node(27);
		Node n8 = new Node(23);

		Node n9 = new Node(34);
		Node n10 = new Node(38);

		// 11 12 21
		n1.setNextNode(n2);
		n1.setNextLevelNode(n6);

		// 12 15
		n2.setNextNode(n3);

		// 15 27 17 
		n3.setNextNode(n4);
		n3.setNextLevelNode(n7);

		// 17 19
		n4.setNextNode(n5);

		// 27 23 34
		n7.setNextNode(n8);
		n7.setNextLevelNode(n9);

		// 34 38
		n9.setNextNode(n10);

		Node transformedListHead = getTransformedList(n1);
		printTransformedList(transformedListHead);
	}

	/**
	 * @param newHead
	 */
	private static void printTransformedList(Node newHead) {
		Node current = newHead;
		while(current != null) {
			System.out.print(current.getValue()+" -> ");
			current = current.getNextNode();
		}
		System.out.println("null");
	}

	/**
	 * 
	 * @param head
	 * @return
	 */
	public static Node getTransformedList(Node head) {

		Node singlyListHead = null;
		Node singlyListCurrent = null;

		Queue<Node> pq = new LinkedList<>();
		Node currentNode = head;

		while(currentNode != null || !pq.isEmpty()) {

			// if next level data is present
			if(currentNode.getNextLevelNode() != null) {
				pq.add(currentNode.getNextLevelNode());		
			}

			// move horizontal level 	
			if(singlyListHead == null) {
				//if it's first node
				singlyListHead = new Node(currentNode.getValue());	
				singlyListCurrent = singlyListHead;
			} else {
				// if nodes are present
				Node tempNewNode = new Node(currentNode.getValue());	
				singlyListCurrent.setNextNode(tempNewNode);
				singlyListCurrent = tempNewNode;
			}

			// if horizontal level node is present
			if(currentNode.getNextNode() != null) {
				currentNode = currentNode.getNextNode();
			} else {
				// if no horizontal node is there; get from queue
				currentNode = pq.poll();	
			}
		}
		return singlyListHead;
	}
}
