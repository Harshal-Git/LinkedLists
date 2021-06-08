/**
 * 
 */
package com.singlyLL.basics;

import com.aa.utils.Node;
import com.aa.utils.SinglyLLUtil;

/**
 * @author Harshal-Git
 *
 * -> Time complexity: 0(n)	
 * -> Space complexity:	0(n)
 * -> Auxiliary space: 0(1)
 */
public class PrintLLWithIteration {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		// linked list node preparation
		Node head = new Node(10);
		Node n1 = new Node(20);
		Node n2 = new Node(30);
		Node n3 = new Node(40);

		// pointer assignment
		head.setNext(n1);
		n1.setNext(n2);
		n2.setNext(n3);

		// print linked list
		System.out.print("Linked list data 1: "+SinglyLLUtil.printLL(head));

		// print some intermediate node
		System.out.print("\nLinked list data 2: "+SinglyLLUtil.printLL(n2));

		// print 'null'
		System.out.print("\nLinked list data 3: "+SinglyLLUtil.printLL(null));
	}
}
