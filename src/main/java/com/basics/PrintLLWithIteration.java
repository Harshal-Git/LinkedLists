/**
 * 
 */
package com.basics;

import com.util.IntLLUtils;
import com.util.NodeInt;

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
		NodeInt head = new NodeInt(10);
		NodeInt n1 = new NodeInt(20);
		NodeInt n2 = new NodeInt(30);
		NodeInt n3 = new NodeInt(40);
		
		// pointer assignment
		head.setNext(n1);
		n1.setNext(n2);
		n2.setNext(n3);
		
		// print the linked list
		System.out.println("Linked list data: "+IntLLUtils.printLL(head));
	}
}
