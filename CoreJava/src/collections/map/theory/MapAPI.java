/*
	Map: Map is NOT a child interface of collection. If we want to represent a group of objects as key-value pairs then we should go for Map. Both
	keys and values are objects only. Duplicates keys are not allowed but values can be duplicated. Each key-value pair is called as an Entry hence
	Map is considered as a collection of Entry objects.
	
	Map interface methods
		Object put(Object key, Object value) - To add one key value pair to the Map.
			If the key is already present then replace the old value will be replaced with new value and the old value will be returned.
			In case its a new key it returns null.
			
			m.put(101, "Durga")     //returns null                   101 - Ravi  //Durga replaced
			m.put(102, "Shiva")     //returns null                   102 - Shiva
			m.put(101, "Ravi")      //places Ravi & returns Durga
	 
	    void map.putAll(Map m)
	    
	    Object get(Object key)  - returns the value associated with specified key.
	    Object remove(Object key) - removes the Entry associated with specified key.
	    
	    boolean containsKey(Object key)
	    boolean containsValue(Object Value)
	    
	    boolean isEmpty()
	    int size()
	    void clear()
	    
	    Methods - Collection views of Map
	    	Set keySet()
	    	Collection values()
	    	Set EntrySet()
	   
	   Methods - Entry Interface: A map is a group of key value pairs and each key value pair is called an Entry. Hence Map is considered as
	   a collection of Entry objects. Without existing Map object there is no chance of existing Entry object hence Entry interface is defined as
	   an inner interface inside Map interface.
	   
	   	interface Map
	   	{
	   		interface Entry
	   		{
	   			Object getKey()                //Entry specific methods - can be applied only on Entry object
	   			Object getValue()
	   			Object setValue(Object newObj)
	   		}
	   	}
	   	
	 HashMap
	 	1. The underlying data structure is Hashtable
	 	2. Insertion order is not preserved and it is based on hashcode of keys.
	 	3. Duplicate keys are not allowed but values can be duplicated.
	 	4. Null is allowed for key(only once as no duplicates for key are allowed). However any no of null values are allowed
	 	5. Heterogeneous objects are allowed for both keys and values.
	 	6. HashMap implements Serializable & Cloneable interfaces but not Random access.
	 	7. HashMap is the best choice if our frequent operation is searching.
	 	
	 	Constructors:
	 		1. HashMap m = new HashMap()                    //empty HashMap with default initial capacity 16 and default fillRatio 0.75
	 		2. HashMap m = new HashMap(int initialCapacity) //empty HashMap with specified initial capacity and default fillRatio 0.75 
	 		3. HashMap m = new HashMap(int initialCapacity, float fillRatio)
	 		4. HashMap m = new HashMap(Map m)
	 		
	    Differences between HashMap(1.2V) and Hashtable(1.0 legacy)
	    1. Hashtable is a synchronized collection as ALL its methods are synchronized hence it is a thread-safe collection. Thus only 1 thread can
	       operate at at time on hashtable making it relatively slower. On the other hand HashMap is not thread-safe and multiple threads can operate
	       simultaneously and so its performance is relatively better.
	    2. HashMap can have 1 null key and any number of null values however Hashtable doesn'y accept anything thats null, otherwise we will get NPE.
	    
	    To get synchronized Map use 
	    	public static Map Collections.synchronizedMap(Map m)
*/