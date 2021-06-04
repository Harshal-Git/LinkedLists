/**
 * 
 */
package com.singlyLL.basics;

import com.singlyLL.util.SinglyLLUtils;
import com.singlyLL.util.Node;

/**
 * @author Harshal-Git
 *
 *	-> search for given key in the linked list
 *
 * -> Time complexity: O(n)	[linear search - worst case scenario] 
 * 						0(1) [best case scenario]
 * -> Space complexity: 0(n)	
 * -> Auxiliary space: 0(1)
 */
public class SearchInLLIt {

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
		Node head = SinglyLLUtils.prepareLL(elements);
		System.out.println("\nLinked list: "+SinglyLLUtils.printLL(head));
		int pos = findKeyPositionIT(head, searchKey);
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
	private static int findKeyPositionIT(Node head, int searchKey) {
		Node current = head;
		int position = 0;
		// iterate over all elements until the key is found 
		while((current != null) && (current.getValue() != searchKey)) {
			current = current.getNext();
			position++;
		}
		// if key is found & current is not NULL
		if(current != null) {
			return (position+1);
		} else {
			// otherwise no key found
			return -1;
		}
	}
}
