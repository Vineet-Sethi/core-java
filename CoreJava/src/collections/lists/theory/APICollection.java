/*
      collections - an english word to represent a group of things
      Collections(C): It is a utility class present in java.util package to define several utility methods for collection objects like 
      sorting, searching etc.
      
      Collection: If we want to represent a group of individual objects as a single entity then we should go for collections.
      Collection Framework: It contains several classes and interfaces which can be used to represent a group of individual objects as a single
      entity.      
      
      The 9 key interfaces of collection framework
        Collection List Queue
        Set SortedSet NavigableSet
        Map SortedMap NavigableMap
        
      1. Collection(I): If we want to represent a group of individual objects as a single entity then we should go for collection. Collection
         interface defines the most common methods which are applicable for any collection object. In general collection interface is considered
         as root interface of collection framework.
         
         These methods are-
	     	boolean add(Object o), addAll(Collection c), remove, removeAll, contains, containsAll, isEmpty.
	     	void clear()
	     	int size()
	     	Object[] toArray()
	     	Iterator iterator()  //Iterator is a universal cursor. Works on all collections
      
         Note: There is no concrete class which implements collection interface directly.
      
      2. List(I): It is a child interface of collection. If we want to represent a group of individual objects as a single entity where 
         duplicates are allowed and insertion must be preserved then we should go for List
         
         Pg 420 Fig 1: ArrayList(1.2), LinkedList(1.2) and Vector(1.0) are concrete implementations of the List Interface. While Stack(1.0)
         extends Vector.
         
      3. Set(I): It is a child interface of collection. If we want to represent a group of individual objects as a single entity where 
         duplicates are not allowed and insertion order is not preserved then we should go for Set interface.
         
         	  Collection(I)(1.2) <--- Set(I)(1.2) <--- HashSet(1.2) <--- LinkedHashSet(1.4)
         	                                      <--- SortedSet(I)(1.2) <--- NavigableSet(I)(1.6) <--- TreeSet(1.2) 
         	                                      
            SortedSet: It is a child interface of Set. If we want to represent a group of individual objects as a single entity where 
            duplicates are not allowed and all objects should be inserted according to some sorting order then we should go for SortedSet
            
            NavigableSet: It is a child interface of SortedSet. It contains several methods for navigation purposes.
      
      4. Queue(I): It is a child interface of collection. If we want to represent a group of individual objects as a single entity prior to
         processing then we should go for Queue. Usually Queue follows First-In First-Out FIFO order but based on our requirement we can 
         implement our own priority order also eg before sending mails all mail ids we have to store in some data structure. In which order
         we added mail ids in the same order only mail should be delivered. For this requirement Queue is best choice.
         
                                                  <--- DeQueue... etc
            Collection(I)(1.2) <--- Queue(I)(1.5) <--- PriorityQueue
            									  <--- BlockingQueue <--- LinkedBlockingQueue 
                                                                     <--- PriorityBlockingQueue  
            Note: All Queues and its subclasses came in 1.5 Version.
            
      5. Map(I): All the above interfaces are meant for representing a group of individual objects as a single entity. However if we want to 
         represent a group of objects as key-value pairs then we should go for Map. Both key and value are objects only. Duplicate keys are not
         allowed but values can be duplicate.
		      
		                <--- IdentityHashMap(1.4)
		      		    <--- WeakHashMap(1.2)
		       (1.2)Map <--- HashMap(1.2) <--- LinkedHashMap(1.4)
		      		    <--- SortedMap(1.2) <--- NavigableMap(1.6) <--- TreeMap(1.2)
		 (1.0)Dictionary<--- Hashtable(1.0) <--- Properties(1.0)

           SortedMap: It is a child interface of Map. If we want to represent a group of key-value pairs according to some SORTING ORDER OF
           KEYS then we should go for SortedMap. In sorted map the sorting should be based on keys but not based on values.
           
           NavigableMap: It is a child interface of SortedMap. If defines several methods for navigation purposes.
           
      Page 423 Fig: Overall hierarchy of collections.
      Note: 
      	1. The following are legacy characters present in collection framework
       		Vector, Stack
       		Dictionary, Hashtable, Properties
           	Enumeration
        2. Sorting Purpose: Comparable and Comparator
        3. Utility classes: Collections and Arrays
        4. Cursors: Enumeration, Iterator, ListIterator
*/