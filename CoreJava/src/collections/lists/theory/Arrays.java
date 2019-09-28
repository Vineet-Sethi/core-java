package collections.lists.theory;

public class Arrays {

	public static void main(String[] args) {
		
		//Declaring individual int variables is fine but what if we require 10000 variables. Declaring this way would reduce readability.
		int i = 10;
		int j = 20;
		int k = 30;  // and so on.
		
		//Arrays solve the issue as we can represent multiple values by using a single variable. Hence improved readability
		Student[] s = new Student[10000];
		s[0] = new Student();
		s[1] = new Student();
		
		/*
		  However Arrays have fixed size and you need to know the size in advance before you can use them. Also you can hold only homogeneous
		  values in an array. 
		  
		  Student[] s = new Student[10000];    //fixed size
		  s[0] = new Student();
		  s[1] = new Customer();               //CE: found Customer: required Student 
		    
		  You can solve this issue by using Object array Object[] to an extent.
		  Object[] a = new Object[10000];    //fixed size
		  a[0] = new Student();
		  a[1] = new Customer(); 
		  
		  Lastly Arrays are a language level or memory level concept. Arrays concept is not implemented based on some standard data structure
		  and so readymade method support is not available. Hence for every requirement(eg sorting or check if certain element is present in
		  the array or not) we should write explicit logic which increases complexity of the code. To overcome these limitations we should
		  go for collections. 
		    
		*/
	}
}

/*
 	Collection advantages as compared to Arrays
	    1. Collections are growable in nature ie Based on our requirement we can increase or decrease the size.
	    2. Collections can hold both homogeneous and heterogeneous elements
	    3. Every collection class is implemented based on some standard underlying data structure. Hence for every requirement readymade method 
	       support is available. Being a programmer we are responsible to use those methods and not responsible to implement them.
	       
	       Note: Apart from TreesSet and TreeMap classes all collections can store heterogeneous objects. This is because these collection 
	       classes store elements in sorted order where sorting is done by comparing the elements. And comparison makes sense only for similar
	       type of objects not heterogeneous.
       
    This might suggest that collections are the obvious choice however there are certain constraints:
    
      1. Collections are growable hence memory-wise they are better as compared to arrays as the memory gets allocated on demand when more 
         elements are added to the collection beyond its default/initial capacity. In arrays the size is declared in advance and it might be 
         possible sometimes that many locations remain unused in the end. 
         
         However this growable nature comes with a performance cost. When an element is added beyond the initial capacity a new bigger 
         collection is first instantiated, then all elements from the older collection are added to this newer collection. Then the element
         is added and finally the reference of the older collection is assigned to the newer one making the older one eligible for garbage
         collection. Hence whenever an element is added beyond the collections capacity an internal growing process is executed.
         
      2. Arrays can hold both primitives as well as objects eg int[] or Integer[]. However collections can only hold objects.
 */
