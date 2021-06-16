/**
 * 
 */
package com.zz.LRUCache;

import java.util.Hashtable;

import com.aa.utils.Node;

/**
 * @author Harshal-Git
 *
 *	-> Cache class
 */
public class LRUCache {

	// hashtable to check whether entry is made OR not
	private Hashtable<Integer, Node> hTable;

	// linked list associated to cache
	private CacheLL cacheList;

	/**
	 * parameterized constructor 
	 */
	public LRUCache(int size) {
		hTable = new Hashtable<Integer, Node>();
		cacheList = new CacheLL(size);
	}

	/**
	 * method to process each entry
	 * @param entry - entry to be processed
	 * @return - status of current entry HIT / MISS
	 */
	public String processEntry(int entry) {
		String status = null;
		// for first OR completely new entry : MISS
		if((cacheList.getHead() == null) || (!hTable.containsKey(entry))) {
			cacheList.processEntryMiss(entry, hTable);
			status = "MISS";
		} else {
			// if entry is already present : HIT
			cacheList.processEntryHit(hTable.get(entry), hTable);
			status = "HIT";
		}
		// return status of the entry
		return status;
	}

	/**
	 * @return - string representation of linked list
	 */
	public String getListStatus() {
		return cacheList.stringFormatList();
	}

	/**
	 * @return - string representation of hashtable mapping
	 */
	public String getMapStatus() {
		return hTable.toString();
	}
}
