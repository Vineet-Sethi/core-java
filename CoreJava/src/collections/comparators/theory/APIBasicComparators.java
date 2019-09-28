/*
	Comparable(I): It is present in java.lang package and it contains only 1 method compareTo(). If we are depending on default natural 
	               sorting order then while adding objects into the TreeSet JVM will call compareTo method
		
		public int compareTo(Object obj)           -ve if obj1 has to come before obj2
										  returns  +ve if obj1 has to come after obj2
												   0 if obj1 and obj2 are equal
	
		obj1.compareTo(obj2);  // obj1 - The object which is being inserted
		                       // obj2 - The object which is already inserted
		
		TreeSet t = new TreeSet()
		t.add("K");   //first element no comparison needed
		t.add("Z");   //"Z".compareTo("K")
		t.add("A");   //"A".compareTo("K")    					  //Always start comparing from root for every new element
		t.add("A");   //"A".compareTo("K") &  "A".compareTo("A")  //Always start comparing from root for every new element
		SOP(t);
		
		Note: If default natural sorting order is not available or if we are not satisfied with it then we can go for customized sorting by
		using Comparator.
		
      Comparator(I): It is present in java.util package and it defines 2 methods compare and equals.
         public int compare(Object obj1, Object obj2)
         	returns -ive if obj1 has to come before obj2
         	        +ive if obj1 has to come after obj2
         	        if obj1 and obj2 are equal
         	        
         public boolean equals(Object obj)
            
	     Whenever we are implementing comparator interface compulsory we should provide implementation only for compare method and we are not
	     required to provide implementation for equals method because it is already available to our class from object class through inheritance.
	     
	     Various possible implementations of compare method:
	     
	     	public int compare(Object obj1, Object obj2) 
	     	{
	     		Integer I1 = (Integer)obj1;
			    Integer I2 = (Integer)obj2;
			    
			    return I1.compareTo(I2);   //Default natural sorting order - Ascending [0, 5, 10, 15, 20]
			    return -I1.compareTo(I2);  //Descending order [20, 15, 10, 5, 0]
			    9
			    return I2.compareTo(I1);   //Descending order [20, 15, 10, 5, 0]
			    return -I2.compareTo(I1);  //Ascending order [0, 5, 10, 15, 20]
			    
			    return +1;  //Insertion order [10, 0, 15, 5, 20, 20]
			    return -1;  //Reverse of Insertion order [20, 20, 5, 15, 0, 10]
			    return 0;   //Only First element will be inserted and rest are considered duplicates [10]
	    	}
*/