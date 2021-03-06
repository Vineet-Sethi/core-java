package generics;

import java.util.ArrayList;

/*
 * The idea is that just like in arrays we must have a mechanism in collections too that puts a check on what is being put into the not type-safe collection objects.
 * So as ArrayList itself is a raw type we parameterize it by ArrayList<T>
 */
public class GenericsSolution {
	
	@SuppressWarnings("unused")
	public void solution() {
		
		ArrayList<String> nameList = new ArrayList<String>();
		
		nameList.add("Durga");
		nameList.add("Ravi");
		//nameList.add(new Integer(10));  //is now Type-safe!
		nameList.add("Shiva");
		
		String name1 = nameList.get(0);  //Type casting not needed
		String name2 = nameList.get(1); 
		String name3 = nameList.get(2); 
	}
}
/*
 * 1. Paramater types must be references(Objects) and not primitives
 * 		ArrayListList<int> nameList = new ArrayList<int>();       //not fine
 * 
 * 2. Polymorphism applicable only for base and not parameter type
 * 		List<String> nameList = new ArrayList<String>();          //fine
 *      List<Object> nameList = new ArrayList<String>();          //not fine
 
    AL list = new AL<String>();
	AL list = new AL<Integer>();
	AL list = new AL<Double>();
	
	ArrayList list1 = new ArrayList<String>();
    list1.add(10);
    list1.add("abc");
    list1.add(5.5);
	
	And below declarations are also equal but you can only add strings to the list.
	
	AL<String> l = new AL<String>();
	AL<String> l = new AL();
	
	So basically the left side of the declaration decides the type of the generic object.
*/
