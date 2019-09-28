/*
	In collection API for Sets we have TreeSet where elements will be kept in some sorted order. For Queue we have PriorityQueue and even for Map we
	have TreeMap. However we dont have anything like this for List objects and in the List API we always walk about insertion order and never about 
	sorting. Collections class has few methods to fill this gap like Collections.sort(List l). In fact Collections class exists to fill gaps in the 
	collection API. For eg most of the traditional collections are not thread-safe except Vector/Stack and so Collections class provides methods like 
	Collections.synchronizedList(List l), Collections.synchronizedSet(Set s), Collections.synchronizedMap(Map m) for this. Hence
	
	-------> Collections is a utility class that defines several utility methods for collection objects like sorting searching reversing etc.
	
	Sorting elements of List: Collections class defines 2 sort methods
		1. public static void sort(List l)   //To sort based on DNSO.
			In this case the list elements should contain Homogeneous and Comparable objects otherwise we will get RE: CCE
			Also the list must not contain any nulls or else we will get NPE.
			
			These conditions are the same as when adding elements to a TreeSet and TreeMap where-in it made sense to compare only homogeneous objects.
			Secondly they must be comparable meaning the compareTo method is overridden which is always the basis of sorting no matter which collection
			it is. Lastly nulls are usually not allowed in such scenarios as again whats the point in comparing something to null and sorting it. Even 
			when null was allowed it had to be the one and only element in the sorted collection.
			
		2. public static void sort(List l, Comparator c)   //To sort based on Customized Sorting Order
						
	Collections class defines the following binary search methods.	
		1. public static int binarySearch(List l, Object target);   			 //If the list is sorted according to default natural sorting order.
		2. public static int binarySearch(List l, Object target, Comparator c);  //If the list is sorted according to customized sorting order.
			
		Conclusions:
			1. The above search methods internally will use binary search algorithms. 
			2. Successful search returns index while unsuccessful search returns insertion point. Insertion point is the location where we can place
			   target element in the sorted list.
			3. Before calling binary search method compulsory list should be sorted otherwise we will get unpredictable results.
			4. If the list is sorted according to comparator then at the time of search operation also we have to pass same comparator object else
			   we will get unpredictable results.
			   
		For the list of n elements in the case of binarySearch method successful search result range 0 to n-1, unsuccesfull range -(n+1) to -1 and
		total result range -(n + 1) to n-1.
		
	Reversing elements of list: Collections class defines the following method to reverse elements of list
		public static void reverse(List l)
		
	Arrays: It is a utility class to define several utility methods for arrays.
		Sorting elements of Array: Arrays class defines the following sort methods for primitive and object arrays
			1. public static void sort(primitive[] p)   			  //To sort according to DNSO
			2. public static void sort(Object[] o)      			  //To sort according to DNSO
			3. public static void sort(Object[] o, Comparator c)      //To sort according to customized sorting order
			
			Note: We can sort primitive arrays only based on DNSO whereas we can sort object arrays either based on DNSO or customized sorting 
			order.
			
	Searching elements of Arrays: The arrays class defines the following binary search methods.
			1. public static int binarySearch(primitive[] p, primitive target)
			2. public static int binarySearch(Object[] a, Object target)
			3. public static int binarySearch(Object[] a, Object target, Comparator c)
			
			Note: All rules of arrays class binary search methods are exactly same as collections class binary search methods.
			
			Convert ArrayToList
				 public static List asList(Object[] a)    //Strictly speaking this method wont create an independent List object, 
				 										  //for the existing array we are getting list view
			     1. Since both the array as well as the list reference are pointing to the same physical array any change made via the array 
			     	reference to the array will be reflected to the list and vice versa.
			     2. By using list reference we cant perform any operation which varies the size otherwise we will get runtime exception saying
			     	UnsupportedOperationException. Hence
			     	
			     	l.add("M"), l.remove(1)   // RE: UnsuppoertedOperationException
			     	l.set(1, "N")             // OK 
			     3. By using list reference we are not allowed to replace with heterogeneous objects otherwise we will get runtime exception 
			     	saying ArrayStoreException.
			     	l.set(1, new Integer(10)) // RE:ArrayStoreException
			     	
    Reverse vs ReverseOrder:
		We can use reverse method to reverse order of elements of list whereas we can use reverseOrder method to reverse the "comparator".
			Eg Comparator c1 = 	Collections.reverseOrder(Comparator c);  // If c talks about ascending order then c1 will talk about descending
			                                                             // order.
*/