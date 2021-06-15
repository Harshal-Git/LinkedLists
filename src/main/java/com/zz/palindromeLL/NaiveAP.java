/**
 * 
 */
package com.zz.palindromeLL;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * @author Harshal-Git
 *
 *	-> Check whether given linked list of characters is palindrome OR not.
 *	-> Naive approach - using stack (Deque implementation)
 *
 * -> Time complexity:	0(n) + 0(n) ~ 0(n) [twice iteration]
 * -> Space complexity:	0(n)
 * -> Auxiliary space:  0(n)
 */
public class NaiveAP {

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
		System.out.println("\nIs list: "+SinglyLLCharUtil.printLL(head)+" palindrome? "+isPalindrome(head));
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
		// iterate over list & insert data into stack
		Deque<Character> chars = new ArrayDeque<Character>();
		Node current = head;
		while(current != null) {
			chars.push(current.getValue());
			current = current.getNext();
		}
		// once inserted data into stack; read the stack 
		// elements & compare it with list for a match
		current = head;
		while(current != null) {
			if(current.getValue() != chars.pop().charValue()) {
				return "No";
			}
			current = current.getNext();
		}
		// by default return true
		return "Yes";
	}

}
