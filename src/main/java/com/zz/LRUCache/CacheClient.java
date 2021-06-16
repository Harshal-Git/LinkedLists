/**
 * 
 */
package com.zz.LRUCache;

/**
 * @author Harshal-Git
 *
 *	-> Implement LRU cache.
 *	
 *	-> Cache size = 4
 *
 *	-> Entries: 10, 20, 10, 30, 40, 50, 30, 40, 60, 30
 *
 *	-> Expected output : (at each stage the cache & hashtable value changes)
 * 
 *		10 - MISS
 *		20 - MISS
 *		10 - HIT
 *		30 - MISS
 *		40 - MISS
 *		50 - MISS 
 *		30 - HIT
 *		40 - HIT
 *		60 - MISS
 *		30 - HIT
 */
public class CacheClient {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		int cacheSize = 4;
		
		int [] entries = new int[] {10, 20, 10, 30, 40, 50, 30, 40, 60, 30};
		
		LRUCache cache = new LRUCache(cacheSize);
		String status = null;
		
		for(int index = 0; index < entries.length; index++) {
			status = cache.processEntry(entries[index]);
			System.out.println("\nEntry: "+entries[index]+" -> "+status);
			System.out.println("Current cache: "+cache.getListStatus());
			//System.out.println("Current map: "+cache.getMapStatus());
		}
	}
}
