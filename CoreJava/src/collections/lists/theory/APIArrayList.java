/*
     List: We use list when we need to preserve insertion order. We can preserve insertion order via index and we can differentiate between
     duplicate objects by using index. Hence index will play a very important role in List. List interface defines the following specific
     methods 
     	void add(int index, Object o), boolean addAll(int index, Collection c)
      	Object remove(int index)
      	
      	Object get(int index), 
      	Object set(int index, Object new)      // Replaces object at the index specified with the new one and returns the old one.
     	
     	int indexOf(Object o), int lastIndexOf(Object o)
     	
     	ListIterator listIterator();
     	
     ArrayList: Its based on underlying data structure - resizable array or growable array. Being a list duplicates/nulls are allowed and 
     insertion order is preserved. As with collections ArrayList can also store heterogeneous objects.
     
     	Constructors:
     	  1. ArrayList l = new ArrayList()  - creates an empty ArrayList object with default initial capacity 10. Once ArrayList reaches its
     		 max capacity then a new ArrayList object will be created with 
     		 			New capacity = (Current Capacity *3/2) + 1
     		 			
     		 Note: After arraylist is full with 10 elements adding 11th element will cause resizing of the array. Hence the array grows as
     		 10 -> 16 -> 25 -> 38...  This growing process effects performance. Hence in case you need a large array upfront you can use
     		 the next constructor to avoid this issue.
     		
     	  2. ArrayList l = new ArrayList(int initialCapacity) creates an empty ArrayList with specified initial capacity.
     	  
     	  3. ArrayList l = new ArrayList(Collection c);  creates an equivalent ArrayList object for the given collection.
     	  
      Usually we use collections to hold objects. However we might need to transfer them from one location to another(container). In such a 
      scenario we might also want to clone the received object to have its backup. To provide support for this requirement every collection 
      class by default implements Serializable and Cloneable interfaces. In addition to this ArrayList and Vector classes also implement the
      RandomAccess interface so that any random element we can access with the same speed. Note that RandomAccess is present in java.util 
      package and it doesn't contain any methods. It is hence a Marker interface and the required ability will be provided automatically by 
      the JVM.
      
      ArrayList is the best choice if our frequent operation is retrieval of objects as AL implements RandomAccess interface. But AL is the 
      worst choice if our frequent operation is insertion or deletion in the middle as the entire collection has to be re aligned. 
      
      ArrayList(1.2) vs Vector(1.0 Legacy)
      1. AL methods are non synchronized and hence it is not thread safe while most Vector methods synchronized and hence its a threadsafe 
         collection.
      2. As AL is non synchronized multiple threads can operate on it simultaneously and hence performance is relatively high as compared to
         Vector.
      
      Tip: To make AL object synchronized we can use Collections class' following static method
            public static List synchronizedList(List l);
            
      Similarly
            public static Set synchronizedSet(Set s);  
            public static Map synchronizedMap(Map m); 
              
*/