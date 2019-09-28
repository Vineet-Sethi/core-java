/*
	LinkedList(I): Its based on underlying data structure - doubly linked list. Being a list duplicates/nulls are allowed and insertion 
      order is preserved. As with collections LinkedList can also store heterogeneous objects. LL implements Serializable and Cloneable
      interfaces but not RandomAccess. LL is the best choice if frequent operation is insertion or deletion in the middle. And LL is a poor
      at random access as we have to traverse through the list.
      
      Constructors: Initial capacity concept not applicable for LL. Hence it has just 2 constructors compared to 3 of AL.
      
      LinkedList l = new LinkedList()  // creates an empty LL object
      LinkedList l = new LinkedList(Collection c)   // creates an equivalent LL object for the given collection
      
      Methods
      Usually we can use LL to develop stacks and Queues. To provide support for this requirement LL class defines the following specific
      methods
      	void addFirst(Object o), addLast(Object o)
      	Object getFirst(), Object getLast()
      	Object removeFirst(), Object removeLast()
      
*/