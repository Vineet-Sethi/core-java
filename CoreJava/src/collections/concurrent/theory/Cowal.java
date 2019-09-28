/*
	CopyOnWriteArrayList: It is a thread safe version of ArrayList. Any number of threads can perform read operations on COWAL. However for every
	write operation as the name indicates a seperate cloned copy is created and update is performed on it. At certain point in time both these 
	versions will be merged internally by the JVM.
	
	Note: As COWAL creates a seperate cloned copy for every update operation hence if 1000 simultaneous write operations need to happen 1000 clones will
	be created. Thus COWAL is the worst choice if you to perform have multiple simultaneous operations.
	
	Also if you try to add object after taking an iterator on COWAL the iterator will only have objects prior to the update. This is because the
	update is happening on a clone rather than the original list. Also note that this is a regular scenario not a multi-threaded one.
	
	Being a List, COWAL has all properties similar to AL except in multithreading scenarios. Thus in COWAL insertion order is preserved, duplicate,
	heterogeneous and null objects are allowed. It implements Serializable, Cloneable and RandomAccess interfaces. But being a concurrent collection
	we wont get any CME when one thread is iterating over the COWAL while another tries to modify it as updates are performed on clones. Hence
	iterators of AL is fail fast while that of COWAL is fail safe. Also in AL the iterator has the capability to remove objects while iterating but
	thats not the case with COWAL and it will throw UnsupportedOperationException.
	
	Constructors: 
		CopyOnWriteArrayList l = new CopyOnWriteArrayList();
		CopyOnWriteArrayList l = new CopyOnWriteArrayList(Collection c);
		CopyOnWriteArrayList l = new CopyOnWriteArrayList(Object[] a);
		
	Vids 15 & 16 Memorize differences.
	
	CopyOnWriteArraySet: It is based on CopyOnWriteArrayList and is a threadsafe version of Set. As it is based on CopyOnWriteArrayList all its 
	properties are applicable on this Set too except that duplicates are not allowed as it is a Set still. Rest all are exactly same even insertion
	order.
	
		Constructors: It has only 2 constructors as compared to 3 of COWAL.
		CopyOnWriteArraySet s = new CopyOnWriteArraySet();
		CopyOnWriteArraySet s = new CopyOnWriteArraySet(Collection c);
*/