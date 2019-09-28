package generics;

import java.util.ArrayList;

public class TypeSafety {

	@SuppressWarnings({ "rawtypes", "unchecked", "unused" })
	public static void main(String[] args) {
		
		//Arrays are type safe. Collections are not!
		String[] names = new String[10];
		names[0] = "Durga";
		names[1] = "Ravi";
		//names[2] = new Integer(10);
		names[2] = "Shiva";
		
		ArrayList nameList = new ArrayList();
		nameList.add("Durga");
		nameList.add("Ravi");
		nameList.add(new Integer(10));  //Not type safe!
		
		//Retrieval has no problem with arrays but with collections you need to type cast
		String name = names[0];
		String name1 = (String) nameList.get(0);  //Type casting is mandatory
		String name2 = (String) nameList.get(1);  //Type casting is mandatory
		
		//String name3 = (String) nameList.get(2);  //Type-casting fails as list was not type safe resulting in ClassCastException
	}
}

