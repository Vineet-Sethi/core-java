package generics.plus;

import java.util.ArrayList;

/*
1.Type erasure happens as Type-Safety and Type-Casting are compile time concepts. Hence during compilation generic syntax is removed and for the
  JVM generic syntax is not available. So following 3 declarations are equal without any type info and you can add anything(Object) to the lists
	
	
	
2. Both methods resolve to the same signature after type erasure. Hence compiler complains. This proves that generic syntax is indeed getting removed

*/
public class TypeErasure {
	public void m1(ArrayList<String> list)
	{

	}
	
	/*public void m1(ArrayList<Integer> list)
	{
		
	}*/
}
