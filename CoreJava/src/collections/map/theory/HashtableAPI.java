/*
	Hashtable: The underlying DS is hashtable. Insertion order is not preserved and it is based on hashcode of keys. Duplicate keys are not 
	allowed and values can be duplicated. Heterogeneous objects are allowed for both keys and values. Null is not allowed for both key and value
	otherwise we will get runtime exception saying null pointer exception. It implements Serializable and cloneable interfaces but not RandomAccess
	Every method present in hashtable is synchronized and hence it is a thread safe. It is the best choice if our frequent operation is searching
	
	Constructors - Create an empty hashtable object with
		Hashtable h = new Hashtable();                      // default initial capacity 11 & default fillRatio 0.75.
		Hashtable h = new Hashtable(int initialCapacity);   // specified initial capacity & default fillRatio 0.75.
		Hashtable h = new Hashtable(int initialCapacity, float fillRatio); // specified initial capacity & fillRatio.
		Hashtable h = new Hashtable(Map m);     // interconversion between map objects
		
    Properties:
    
    In our program if anything which changes frequently like username password mailId mobileNo etc. are not recommended to hard-code
    in java program because if there is any change to reflect that change recompilation , rebuilding the application(create ear, war, jar) and 
    re-deploying it is required. Even sometimes server restart may also be required which causes a big business impact to the client.
    
    We can overcome this problem by using properties file. Such type of variable things we have to configure in the properties file. From that 
    properties file we have read into java program and we can use those properties. The main advantage of this approach is if there is a change 
    in properties file to reflect that change just re-deployment is enough which wont cause any business impact to the client.
    
    We can use java properties object to hold properties which are coming from properties file. In normal Map(like HashMap, Hashtable, TreeMap)
    key value can be any type but in the case of properties key and value should be String type.
    
    Constructor - Properties p = new Properties();
    
    Methods
    	String setProperty(String pname, String pvalue) // to set a new property. If a specific property already exists in the property then old
    	                                                // value will be replaced with new Value and returns old value - Analogous to put of #Map
    	String getProperty(String pname)                // to get value associated with specified property, returns null if property not found
    	Enumeration propertyNames()                     // returns all property names present in properties object
    	
    	void load(InputStream is)                       // to load properties from .properties file into java properties object
    	void store(OutputStream os, String comment)     // to store properties from java properties object into properties file
      
	
*/