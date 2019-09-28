/*
	Vector(I): Its based on underlying data structure - resizable array or growable array. Being a list duplicates/nulls are allowed and 
	insertion order is preserved. As with all collections Vector can also store heterogeneous objects. Vector implements Serializable, Cloneable
    and RandomAccess. 
    
    Every method present in the vector is synchronized and hence Vector object is thread-safe.
    
    Constructors
    	Vector v = new Vector() // creates an empty vector object with default initial capacity 10. Once vector reaches its max capacity then
    	                        // a new vector object will be created with NewCapacity = CurrentCapacity * 2.
    	                         
    	Vector v = new Vector(int intitialCapacity)
    	Vector v = new Vector(int intitialCapacity, int incrementalCapacity) 	
    	Vector v = new Vector(Collection c)  // creates an equivalent vector object for the given collection. This constructor is meant for
    	                                     // inter-conversion between collection objects and vector.

    Methods
    	To add objects - addElement(Object o)
    	To remove obj  - removeElement(Object o), removeAllElements(),  removeElementAt(int index)
    	To get Objects - firstElement(), elementAt(int index), lastElement()
    	                 
    	                 int size(), int capacity()
    	                 Enumeration elements()
 */