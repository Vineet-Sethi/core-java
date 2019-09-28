/*
   1.5V Enhancements
      Queue(I): It is a child interface of collection. If we want to represent a group of individual objects prior to processing then we should
      go for queue. For eg before sending mass SMS messages all mobile numbers we  have to store in some data structure. The order in which we added
      mobile numbers in the same order only messages need to be send. For this FIFO requirement Queue is the best choice.
      
      Usually Queue follows FIFO but based on our requirement we can implement our own priority order also - PriorityQueue. From 1.5V onwards LL
      class also implements the Queue interface. The LinkedList based implementation of queue always follows FIFO.
      
      Methods:
         boolean offer(Object o): to add an object into the queue.
         
         Object peek(): to return head element of the queue without removal. If queue is empty then this method returns null.
         Object poll(): to remove and return head element of the queue. If queue is empty then this method returns null.
         
         Object element(): to return head element of the queue without removal. If queue is empty then this method raises: NoSuchElementException.
         Object remove(): to remove and return head element of the queue. If queue is empty then this method raises: NoSuchElementException.
         
      PriorityQueue: If we want to represent a group of individual objects prior to processing according to some priority then we should go for
      PriorityQueue. The priority can be either DNSO or customized sorting order defined by comparator. Insertion order is not preserved as it is
      based on some priority. Duplicate objects are not allowed. If we are depending on DNSO then the object must be Homogeneous and Comparable
      otherwise we will get RE: ClassCastException. If we are defining our own sorting by comparator then objects need not be homogeneous and
      comparable. Null is not allowed even as the first element also. 
      
      Constructors:
      	PriorityQueue q = new PriorityQueue();  //creates an empty PriorityQueue with default initial capacity 11 and all objects will be inserted 
      	                                        //according to default natural sorting order DNSO.
      	PriorityQueue q = new PriorityQueue(int initialCapacity);
      	PriorityQueue q = new PriorityQueue(int initialCapacity, Comparator c);
      	PriorityQueue q = new PriorityQueue(Sorted s);
      	PriorityQueue q = new PriorityQueue(Collection c);
      	
      1.6V Enhancements:As a part of 1.6V NavigableSet and NavigableMap were introduced to the collection framework
      	 1. NavigableSet: It is a child interface of SortedSet and it defines several methods for navigation purposes. 
      	 		
      	 		floor(e): returns highest element which is <=e
      	 		lower(e): returns highest element which is <e
				
				ceiling(e): returns lowest element which is >=e
				higher(e): returns lowest element which is >e
				
				pollFirst(): remove and return first element
				pollLast(): remove and return last element
				
				descendingSet(): returns NavigableSet in reverse order
				
		2. NavigableMap: It is a child interface of SortedMap and it defines several methods for navigation purposes.
			    
			    floorKey(e): returns highest element which is <=e
      	 		lowerKey(e): returns highest element which is <e
				
				ceilingKey(e): returns lowest element which is >=e
				higherKey(e): returns lowest element which is >e
				
				pollFirstEntry(): remove and return first element
				pollLastEntry(): remove and return last element
				
				descendingMap(): returns NavigableSet in reverse order
				
				
*/