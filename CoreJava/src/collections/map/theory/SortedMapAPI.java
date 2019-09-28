/*
	SortedMap(I): It is a child interface of Map. If we want to represent a group of key-value pairs according to some sorting order of keys then 
	we should go for SortedMap. The sorting is based on keys and not values.
	
		Methods: SortedMap defines the following specific methods
			Object firstKey()
			Object lastKey()
			SortedMap headMap(Object key)
			SortedMap tailMap(Object key)
			SortedMap subMap(Object key1, Object key2)
			Comparator comparator()
			
	    Eg: SortedMap = {101=A, 103=B, 104=C, 107=D, 125=E, 136=F}
	         firstKey() - 101
	         lastKey() - 136
	         headMap(107) - {101=A, 103=B, 104=C}
	         tailMap(107) - {107=D, 125=E, 136=F}
	         subMap(103, 125) - {103=B, 104=C, 107=D}
	         comparator() - null
	     
	 TreeMap:
	 	The underlying data structure is Red-Black Tree. Insertion order is not preserved and it is based on some sorting order of keys. Duplicate
	 	keys are not allowed but values can be duplicate. 
	 	
	 	If we are depending on DNSO then keys should be homogeneous and comparable otherwise we will get RE:CCE(ClassCastException). 
	 	If we are defining our own sorting by comparator then keys need not be homogeneous and comparable. We can take heterogeneous non comparable
	 	objects also. Whether we are depending on DNSO or customized sorting order there are no restrictions for values we can take heterogeneous 
	 	non comparable objects also.
	 	
	 	Null Acceptance:
	 		1. For non-empty TreeMap if we are trying to insert an Entry with null key then we will get RE:NPE.
	 		2. For empty TreeMap as the first Entry with null key is allowed but after inserting that Entry if we are trying to insert an Entry any
	 		   other Entry then we will get RE:NPE.
	 		Note: The above 2 null acceptance rules are applicable until 1.6 version only. From 1.7 version onwards null is not allowed for key.
	 		But we can have any number of null values without restrictions whether is 1.6 or 1.7 version.
	 		
	 	Constructors:
	 		1. TreeMap t = new TreeMap()             //Creates an empty TreeMap object where the elements will be inserted according to default or natural sorting order.
	        2. TreeMap t = new TreeMap(Comparator c) //Creates an empty TreeSet object where the elements will be inserted according to specified or customized sorting order.
	        3. TreeMap t = new TreeMap(SortedMap m)  //Sorting implemented in SortedMap is considered.
	        4. TreeMap t = new TreeMap(Map m)        //Default or natural sorting order is considered.
*/

