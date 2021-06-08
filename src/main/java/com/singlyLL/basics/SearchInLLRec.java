/**
 * 
 */
package com.singlyLL.basics;

import com.aa.utils.Node;
import com.aa.utils.SinglyLLUtil;

/**
 * @author Harshal-Git
 *
 *	-> search for given key in the linked list
 *
 * -> Time complexity: O(n)	[recursive search - worst case scenario] 
 * 						0(1) [best case scenario]
 * -> Space complexity: 0(n)	
 * -> Auxiliary space: O(n) - stack trace of calls [recursive search - worst case scenario]
 * 					   O(1) - stack trace of calls [best case scenario]
 */
public class SearchInLLRec {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		// case 1
		printMessage(new int[] {10, 5, 20, 15}, 20);

		// case 2
		printMessage(new int[] {10, 5, 20, 15}, 30);

		// case 3
		printMessage(new int[] {10, 5, 20, 15}, 10);

		// case 4
		printMessage(new int[] {10, 5, 20, 15}, 5);

		// case 5
		printMessage(new int[] {10, 5, 20, 15}, 15);

		// case 6
		printMessage(new int[] {99}, 15);

		// case 7
		printMessage(null, 15);
	}

	/**
	 * @param elements
	 * @param searchKey
	 */
	private static void printMessage(int[] elements, int searchKey) {
		Node head = SinglyLLUtil.prepareLL(elements);
		System.out.println("\nLinked list: "+SinglyLLUtil.printLL(head));
		int pos = findKeyPositionREC(head, searchKey);
		if(pos > 0) {
			System.out.println("Search key: "+searchKey+" found at position "+pos+".");
		} else {
			System.out.println("Search key: "+searchKey+" not found.");
		}

	}

	/**
	 * search for given key from the linked list of given elements
	 * in iterative manner
	 * @param head - linked list root node
	 * @param searchKey - element to be searched
	 * @return - position of the given key
	 */
	private static int findKeyPositionREC(Node node, int searchKey) {
		// base case #1 : if node is null
		if(node == null) {
			return -1;
		} 
		// base case #2 : if key is found
		if(node.getValue() == searchKey) {
			return 1;
		} else {
			int res = findKeyPositionREC(node.getNext(), searchKey);
			if(res == -1) {
				return -1;
			} else {
				return (1+res);
			}
		}
	}
}
