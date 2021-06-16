/**
 * 
 */
package com.zz.LRUCache;

import java.util.Hashtable;

import com.aa.utils.Node;

/**
 * @author Harshal-Git
 *
 *	-> processing of doubly linked list of cache
 */
public class CacheLL {

	// MAX allowed size : referred from cache
	private int MAX_SIZE;

	// varying list size
	private int listSize;

	// head of the list
	private Node head = null;

	// tail of the list
	private Node tail = null;

	/**
	 * parameterized constructor
	 */
	public CacheLL(int size) {
		this.MAX_SIZE = size;
	}

	/**
	 * @return - head of the cache list
	 */
	public Node getHead() {
		return this.head;
	}

	/**
	 * @return - tail of the cache list
	 */
	private Node getTail() {
		return this.tail;
	}

	/**
	 * @param head the head to set
	 */
	private void setHead(Node head) {
		this.head = head;
	}

	/**
	 * @param tail the tail to set
	 */
	private void setTail(Node tail) {
		this.tail = tail;
	}

	/**
	 * @return - max size of the cache list
	 */
	private int getMaxSize() {
		return this.MAX_SIZE;
	}

	/**
	 * @return the listSize
	 */
	private int getListSize() {
		return listSize;
	}

	/**
	 * increase the list size
	 */
	private void increaseListSize() {
		this.listSize++;
	}

	/**
	 * reduce the list size
	 */
	private void decreaseListSize() {
		this.listSize--;
	}

	/**
	 * process given entry if it's a MISS
	 * @param entry - entry to be processed
	 * @param hTable - hashtable data to be updated 
	 */
	public void processEntryMiss(int entry, Hashtable<Integer, Node> hTable) {
		Node entryRef = null;
		// for first entry
		if(getHead() == null) {
			entryRef = insertFirstEntry(entry);
		} else {
			// for a new entry; which is not first
			// if list has space
			if(getListSize() < getMaxSize()) {
				entryRef = insertEntryAtStart(entry);
			} else {
				// if list is full; first delete the last element 
				// & then make a new entry
				deleteEntry(hTable);
				entryRef = insertEntryAtStart(entry);
			}
		}
		// update existing hashtable
		hTable.put(entryRef.getValue(), entryRef);
	}

	/**
	 * delete entry from given list
	 * @param hTable - hashtable data to be updated
	 */
	private void deleteEntry(Hashtable<Integer, Node> hTable) {
		hTable.remove(getTail().getValue());
		Node tailPrev = getTail().getPrevious();
		tailPrev.setNext(null);
		setTail(tailPrev);
		decreaseListSize();
	}

	/**
	 * method to make entry at start of the list
	 * @param entry - entry value to be inserted at head
	 * @return - updated head
	 */
	private Node insertEntryAtStart(int entry) {
		Node tempNode = new Node(entry);
		getHead().setPrevious(tempNode);
		tempNode.setNext(getHead());
		setHead(tempNode);
		increaseListSize();
		return getHead();
	}

	/**
	 * method to make entry when list is empty
	 * @param entry - entry value to be inserted at head
	 * @return - updated head
	 */
	private Node insertFirstEntry(int entry) {
		Node tempNode = new Node(entry);
		setHead(tempNode);
		setTail(getHead());
		increaseListSize();
		return getHead();
	}

	/**
	 * process given entry if it's a HIT
	 * @param entry - entry to be processed
	 * @param hTable - hashtable data to be updated
	 */
	public void processEntryHit(Node node, Hashtable<Integer, Node> hTable) {
		Node entryRef = null;
		// if head is HIT: don't do anything
		if(getHead().getValue() == node.getValue()) {
			// nothing to do
		} else if(getTail().getValue() == node.getValue()) {
			// if tail is HIT: delete tail & then insert at start
			deleteEntry(hTable);
			// insert the node at start
			entryRef = insertEntryAtStart(node.getValue());
		} else {
			// if intermediate node is HIT : delete node & insert it at start
			Node prevNode = node.getPrevious();
			Node nextNode = node.getNext();
			prevNode.setNext(nextNode);
			nextNode.setPrevious(prevNode);
			// insert the node at start
			entryRef = insertEntryAtStart(node.getValue());
		}
		// update existing hashtable
		hTable.put(entryRef.getValue(), entryRef);
	}

	/**
	 * @return - string representation of current list
	 */
	public String stringFormatList() {
		Node head = getHead();
		if(head == null) {
			return "EMPTY";
		}
		StringBuilder builder = new StringBuilder();
		while(head != null) {
			builder.append(head.getValue()).append(" <=> ");
			head = head.getNext();
		}
		// check builder length
		if(builder.length() > 0) {
			builder.delete((builder.length()-5), builder.length());
		}
		// return builder string
		return builder.toString();
	}
}
