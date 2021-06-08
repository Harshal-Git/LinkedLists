/**
 * 
 */
package com.zz.detectLoop;

import java.util.HashSet;
import java.util.Set;

import com.aa.utils.CircularLLUtil;
import com.aa.utils.Node;
import com.aa.utils.SinglyLLUtil;

/**
 * @author Harshal-Git
 *
 *	-> Given a linked list; find whether it has a loop OR not.
 *
 *	-> This is hashing approach
 *
 * -> Time complexity: O(n)	
 * -> Space complexity: O(n)	
 * -> Auxiliary space: O(n)
 */
public class HashingMethod {

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
	}

	/**
	 * method to check whether given list has loop OR not
	 * @param head - head of the linked list
	 * @return - TRUE - if loop exist; FALSE otherwise
	 */
	private static String findLoop(Node head) {
		// loop flag
		boolean hasLoop = false;
		// maintain a hash set of Nodes
		Set<Node> visitedNodes = new HashSet<Node>();
		// iterate over list
		Node current = head;
		while(current != null) {
			// if current node already exist in visited nodes; there is a loop
			if(visitedNodes.contains(current)) {
				hasLoop=true;
				break;
			} else {
				// otherwise add reference of current node in the set and move ahead
				visitedNodes.add(current);
			}
			current = current.getNext();
		}
		// return flag
		return ((hasLoop)? "Yes" : "No");
	}
}
