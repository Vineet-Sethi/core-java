/*
	Need of concurrent collections
		1. Traditional collections like AL, LL, HM etc are not thread safe meaning they dont provide synchronized methods. Hence if multiple threads
		   are trying to access it there might be a chance of data inconsistency problem.
		2. There are few thread safe collections like Vector Hashtable etc however only one thread can access them at a time(even for reading) hence
		   this is performance issue as threads get access one by one and they need to wait.
		3. In traditional collections while one thread iterating if another thread is trying to update the collection at the same time we get a
		   ConcurrentModificationException immediately.
		   
    Hence traditional collections are not suitable for scalable multithreaded applications and so we need Concurrent Collections.
    
    The 3 main concurrent collections are
    	1. ConcurrentHashMap
    	2. CopyOnWriteArrayList
    	3. CopyOnWriteArraySet
    	
    	ConcurrentHashMap: It is based on the underlying data structure Hashtable. It allows any number of concurrent read & fixed number of write/ 
    	update operations. To perform reads it does not require any lock but for write/update opertions lock is required. However unlike in the case
    	of HashMap where locking the entire collection is needed a CHM needs lock on only a particular segment(bucket level lock). The segment size
    	is determined by concurrency level. With default values 
    			initial capacity = 16 and concurrency level = 16    we get 1 lock per bucket
    		for	initial capacity = 16 and concurrency level = 8     we get 1 lock per 2 buckets
    		for	initial capacity = 16 and concurrency level = 32    we get 2 locks per 2 bucket and contents inside bucket will be segmented.
    		
    	Lastly null is not allowed for both keys and values and being a concurrent collection no CME is thrown which is obvious. 
    	
    	Note: Although CHM allows simultaneous updation while being iterated however there is no guarantee that whether the newly added entry will
    	be available to the iterator or not. The iterator is a uni-directional cursor so if it has already crossed the cell in which the new entry 
    	was added then it wont be available to the ietrator and vice versa.
    	    	
    	Constructors:
    		ConcurrentHashMap m = new ConcurrentHashMap();
    		ConcurrentHashMap m = new ConcurrentHashMap(int initial capacity);
    		ConcurrentHashMap m = new ConcurrentHashMap(int initial capacity, float fillRatio);
    		ConcurrentHashMap m = new ConcurrentHashMap(int initial capacity, float fillRatio, int concurrencyLevel);
    		ConcurrentHashMap m = new ConcurrentHashMap(Map m);
    	
    	Map(I)  <------- ConcurrentMap(I) <------- ConcurrentHashMap
    	
    	Methods: The methods are present in ConcurrentMap interface
    	
    		1. Object putIfAbsent(Object key, Object value)  //put the pair if this key is not available in the map otherwise do nothing
    		2. boolean remove(Object key, Object value)      //remove if both key and value is matched not like in case of map.remove(key) only key matched
    		3. boolean replace(Object key, Object oldValue, Object newValue)   //replace old value at key with new value only if pair is matched
    		
    		Vids 6 & 7 Memorize differences.    		
*/