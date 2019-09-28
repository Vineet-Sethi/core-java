/*
	LinkedHashMap: It is a child class of HashMap. It is exactly same as HashMap(including methods and constructors) except one difference
		
		HashMap(1.2) vs LinkedHashMap(1.4)
		LinkedHashMap maintains insertion order as it is based on LL + Hashtable(hybrid data structure) compared to HashMap which is Hashtable 
		based.
		
	Note: LinkedHashSet and LinkedHashMap are commonly used for developing cache based applications.
	
	IdentityHashMap:	
		== vs equals(): In general == operator is meant for reference comparison or address comparison whereas equals() method is meant for 
		                content comparison. Eg
		
		Integer I1 = new Integer(10);
		Integer I2 = new Integer(10);
		SOP(I1 == I2);        //False
		SOP(I1.equals(I2));   //True
		
		It is exactly same as HashMap(including methods and constructors) except the following difference:
			In the case of normal HashMap JVM will use .equals method to identify duplicate keys which is meant for content comparison but in the 
			case of IdentityHashMap JVM will use == operator to identify duplicate keys which is meant for reference or address comparison. 
		
	WeakHashMap: It is exactly same as HashMap(including methods and constructors) except the following difference
	    In the case of normal HashMap eventhough object doesn't have any reference it is not eligible for GC if it is associated with HashMap ie
	    HashMap dominated GC. But in the case of WeakHashMap if object doesn't contain any references it is eligible for GC eventhough object is
	    associated with WeakHashMap ie GC dominates WeakHashMap.
*/