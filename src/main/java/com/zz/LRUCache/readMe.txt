LRU cache (Least Recently Used cache)

##Base line: Implement an LRU cache considering the usage as:

1. Defined cache size in advance. And provided sequence of entries to be validated against the cache.

2. When it's a cache miss (entry not found present in cache); the entry will be added in the cache at front. 
	And remaining element (if exist) will be shifted towards end.   

3. When it's a cache hit (entry found in the cache); it will come in front in the cache; and elements are rearranged.

4. When cache is full; and new entry miss the cache, the last element; which has not been used recently (least recently used) 
	will be removed from cache.

5. Purpose is to perform all above operations in the most efficient manner.

--> One approach is to use an array; which will make search / shifting / insertion expensive operations (O(n))

--> Second approach is to use hybrid DS (Hashtable + Doubly linked list). Hashtable will help to store presence of the entry (to decide
cache hit / miss) and later doubly linked list will manage the entries in expected sequence. 

The hashtable will store the entry value and reference of the node; which keeps getting updated as hit / miss is performed.