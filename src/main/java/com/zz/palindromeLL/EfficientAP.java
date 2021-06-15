/**
 * 
 */
package com.zz.palindromeLL;

/**
 * @author Harshal-Git
 *
 *	-> Check whether given linked list of characters is palindrome OR not.
 *
 *	-> Efficient approach: find middle element first and then from middle; reverse the remaining list on right side.
 *							then compare both half lists simultaneously & if any element is not matched; return false. 
 *							Otherwise return true. 
 *
 * -> Time complexity:	O(n/2) [finding mid] + O(n/2) [reversing] + O(n/2) [final comparison] ~ O(n) [thrice iteration]
 * -> Space complexity:	0(n)
 * -> Auxiliary space:  0(1)
 * 
 * -> Base line : for EVEN elements in the list; half pointer will always be on exact (n/2)th position and for ODD elements; 
 * 					it will be at (n/2)+1 position. 
 * 				  So when the remaining list is reversed & compared; in the ODD list; the mid element is always skipped.
 */
public class EfficientAP {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		Node head = null;

		// case 1
		head = SinglyLLCharUtil.prepareLL(new char[] {'R', 'A', 'D', 'A','R'});
		printMessage(head);

		// case 2
		head = SinglyLLCharUtil.prepareLL(new char[] {'G', 'F', 'G'});
		printMessage(head);

		// case 3
		head = SinglyLLCharUtil.prepareLL(new char[] {'H', 'E', 'L', 'L','O'});
		printMessage(head);

		// case 4
		head = SinglyLLCharUtil.prepareLL(new char[] {'G', 'E', 'E', 'K'});
		printMessage(head);

		// case 5
		head = SinglyLLCharUtil.prepareLL(new char[] {'G', 'E', 'E', 'G'});
		printMessage(head);
	}

	/**
	 * @param head
	 */
	private static void printMessage(Node head) {
		System.out.println("\nIs list: "+SinglyLLCharUtil.printLL(head)
		+" palindrome? "+isPalindrome(head));
	}

	/**
	 * method to check whether given linked list is palindrome OR not
	 * @param head - head of the list
	 * @return - YES; if list is palindrome; NO otherwise
	 */
	private static String isPalindrome(Node head) {
		// head validation
		if(head == null || head.getNext() == null) {
			return "No";
		}
		// find middle
		Node slowPtr = head;
		Node fastPtr = head;
		while(fastPtr.getNext() != null && 
				fastPtr.getNext().getNext() != null) {
			slowPtr = slowPtr.getNext();
			fastPtr = fastPtr.getNext().getNext();
		}
		// reverse remaining list after mid element
		Node reversePtr = reverseList(slowPtr.getNext());

		// now compare both head & reverse pointer for matching element
		Node current = head;
		while(reversePtr != null) {
			// if at any point values doesn't match; exit the comparison
			if(current.getValue() != reversePtr.getValue()) {
				return "No";
			}
			current = current.getNext();
			reversePtr = reversePtr.getNext();
		}
		// all matches then return true
		return "Yes";
	}

	/**
	 * method to reverse the list from given node
	 * @param node - node from a list
	 * @return - first node of the reversed list
	 */
	private static Node reverseList(Node node) {
		Node current = node;
		Node prev = null, temp = null;
		// move till the last node
		while(current != null) {
			// next node of current pointer
			temp = current.getNext();
			// set reference of previous to current
			current.setNext(prev);
			// set previous as current 
			prev = current;
			// move to temp reference to go ahead
			current = temp;
		}
		// return the updated pointer
		return prev;
	}
}
