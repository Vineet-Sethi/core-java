/*
	  Collection(I)(1.2) <--- Set(I)(1.2) <--- HashSet(1.2) <--- LinkedHashSet(1.4)
                                          <--- SortedSet(I)(1.2) <--- NavigableSet(I)(1.6) <--- TreeSet(1.2)
         	                                      
      Set(I): Set is the child interface of collection. If we want to represent a group of individual objects as a single entity where 
      duplicates are not allowed and insertion order not preserved then we should we go for Set.
      
      Set interface doesn't contain any new method and we have to use only collection interface methods.
      
      HashSet: The underlying data structure for HashSet is Hashtable. Its a set hence duplicates are not allowed and insertion order is not
      preserved(internally set uses hashing to store objects). It allows only 1 null as duplicates are forbidden. Heterogeneous objects can
      be stored and it implements Serializable and Cloneable interfaces. HashSet is the best choice if our frequent operation is searching.
      
      Note: In HashSet duplicates are not allowed and if we are trying to insert duplicate then add method will return false(and not any exception)
     
	      HashSet h = new HashSet();
	      h.add("A")  //true
	      h.add("A")  //false
	      
	  Constructors
	  	1. HashSet h = new HashSet();                                     // creates an empty HashSet object with default initial capacity 16 and default fillRatio 0.75
	  	2. HashSet h = new HashSet(int initialCapacity);                  // creates an empty HashSet object with specified initial capacity 16 and default fillRatio 0.75
	  	3. HashSet h = new HashSet(int initialCapacity, float fillRatio); // creates an empty HashSet object with specified initial capacity and fillRatio.
	  	4. HashSet h = new HashSet(Collection c);                         // creates an equivalent HashSet for the given collection.
    	                                                                  // This constructor is meant for inter-conversion between collection object and HashSet.
    	                                                                   
      Fill Ratio/Load Factor: Defines that after filling the specified ratio a new HashSet object will be created.
      For eg fillRatio 0.75 means that after the set is 75% is filled a new HashSet object will be created.  
      
      LinkedHashSet: It is a child class of HashSet. It is exactly same as HashSet including constructors and methods except for the fact that
      it also maintains insertion order although it is a set. As the name suggests it is LinkedList based and the underlying data structure is
      Hashtable + LinkedList. It was introduced in 1.4V.
      
      Note: In general we can use LinkedHashSet to develop cache based applications where duplicates are not allowed and insertion order is 
      preserved.
      
      SortedSet: It is a child interface of Set. If we want to represent a group of individual objects according to some sorting order w/o
      duplicates then we should go for SortedSet.
      
      Methods:
         SortedSet defines the following 6 specific methods.
         
         Object first() ------------------------------ Returns the first object of the SortedSet
         Object last() ------------------------------- Returns the last object of the SortedSet
         SortedSet headSet(Object obj) --------------- Returns SortedSet whose elements are < obj.
         SortedSet tailSet(Object obj) --------------- Returns SortedSet whose elements are >= than obj.
         SortedSet subSet(Object obj1, Object obj2) -- Returns SortedSet whose elements are >= than obj1 and < obj2.
         Comparator comparator() --------------------- returns Comparator object that describes underlying sorting technique. If we are using
                                                       default natural sorting order then we will get null.
                                                       
         Eg: Set = [100, 101, 104, 106, 110, 115, 120]
         first() - 100
         last() - 101
         headSet(106) - [100, 101, 104]
         tailSet(106) - [106, 110, 115, 120]
         subSet(101, 115) - [101, 106, 104, 110]
         Comparator() - null
         
      TreeSet: The underlying data structure is BalancedTree. Duplicate objects are not allowed. Insertion order is not preserved as objects 
      will be stored with respect to some sorting order(default/natural or custom). Heterogeneous objects are not allowed otherwise we will 
      get runtime exception saying ClassCastException. Null insertion possible only once as duplicates cant be there. TreeSet implements 
      Serializable and Cloneable but not RandomAccess.
      
      Constructors
         1. TreeSet t = new TreeSet() // creates an empty TreeSet object where the elements will be inserted according to default or natural sorting order.
         2. TreeSet t = new TreeSet(Comparator c) // creates an empty TreeSet object where the elements will be inserted according to specified customized sorting order.
         3. TreeSet t = new TreeSet(Collection c) // default or natural sorting order is considered
         4. TreeSet t = new TreeSet(SortedSet s)  // sorting implemented in SortedSet is considered.
         
      Null Acceptance: In code
      
      Comparison between Set implementation classes  - See table on page 451
*/