/*
	 The 3 cursors of java
	 
	 If we want to get objects one by one from the collection then we should go for cursor. There are 3 types of cursors available in java
	   1. Enumeration
	   2. Iterator
	   3. ListIterator
	   
	  Enumeration
		  We can use enumeration to get objects one by one from legacy collection objects. We can create Enumeration object by using
		  elements method of vector class.
		  		Enumeration e = v.elements();
		  		
		  Methods
		     public boolean hasMoreElements() 
		     public Object nextElement()
		     
		  Enumeration Limitations
		  	1. We can apply enumeration concept only for legacy classes as it is not a universal cursor.
		  	2. By using enumeration we can get only read access and we cant perform remove operation.
		  	
		  	To overcome both these limitations we can go for Iterator
       
       Iterator
           We can use Iterator for any collection object, hence it is a universal cursor. By using iterator we can perforn both read and remove
           operations. We can create Iterator object by using iterator method of the collection interface
           
           			public Iterator iterator()
           			Iterator itr = c.iterator();   //c is any collection object
           			
           	Methods
           		public boolean hasNext()
           		public Object next()
           		public void remove()
           		
           	Iterator Limitations
           	  1. By using Enumeration and Iterator we can always move only in forward direction and not backward. Hence these are 
           	     uni-directional cursors.
           	  2. By using iterator we can perform only read and remove operations but we cant perform addition or replacement of objects.
           	  
           	  To overcome these limitations we can go for ListIterator
           	  
        ListIterator
           By using ListIterator we can move in either forward or backward direction hence it is a bi-directional cursor. Secondly with the 
           ListIterator we can perform addition and replacement of new objects in addition to read and remove operations. We can create a
           ListIterator object by using listIterator() method of the List interface.
           
           			public ListIterator listIterator()
           			ListIterator ltr = l.listIterator();   //l is any List object
           
           ListIterator is the child interface of Iterator and hence all 3 methods present in Iterator are available to the ListIterator. And		
           ListIterator defines the following methods
           	
           Methods
           		For forward movement ---- public boolean hasNext()
           								  public Object next()
           								  public int nextIndex()
           								  
                For backward movement --- public boolean hasPrevious()
           								  public Object previous()
           								  public int previousIndex()
           								  
           		Extra operations -------- public void remove()
           		                          public void add(Object o)
           		                          public void set(Object o)
           		                          
           ListIterator Limitations
           	 Although ListIterator is the most powerful but its limitation is that it is applicable only for list objects. Hence it is not a
           	 universal cursor.
           	 
          Pg 436: Refer Comparison table
          
          Internal Implementation of Cursors
*/