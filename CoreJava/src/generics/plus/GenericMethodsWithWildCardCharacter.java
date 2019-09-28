/*
1. public void m1(ArrayList<String> list)      { } - Can be called with an ArrayList of String only & you hence you can only add only strings or null!
2. public void m1(ArrayList<?> list)           { } - Can be called with an ArrayList of Anything but you can only add nulls to it as type is not known. Hence suitable for just read only!
3. public void m1(ArrayList<? extends X> list) { } - If X is class then we can call this method with ArrayList of either X type or its child classes.
												     If X is interface then we can call this method with ArrayList of either X type or its implementation classes.
												     But for both cases we can only add nulls as type is not known.
4. public void m1(ArrayList<? super X> list)   { } - If X is class then we can call this method with ArrayList of either X type or its super classes.	
										     		 If X is interface then we can call this method with ArrayList of either X type or super class of implementation of X.
5. Cant use ? on right side of declarations. Allowed on left side.
		AL<?> l = new AL<String>();
		AL<?> l = new AL<Integer>();
		AL<? extends Number> l = new AL<Integer>();
		AL<? super String> l = new AL<Object>();

You can mix generic and non-generic code. If you send generic ArrayList<String> to a non generic are then the list will start behaving in a non generic 
way i.e. you will be able to add integers etc. Similarly if you send a non-generic ArrayList<String> to a generic it start behaving in a generic
way i.e. you can only add strings to it. Hence the area in which your generic object is present decides its behaviour
*/
