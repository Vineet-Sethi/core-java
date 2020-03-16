package generics.plus;

/*
Generic Class
-------------
In MyOwnGeneric<T>, T is unbounded and we can pass anything to it. However we can restrict the range of T using extends as
	MyOwnGeneric<T extends X>  -If X is Number then T here can be either Number type or its child classes. So
	
1. <T extends Number>   - If X is class then T here can be either that class type or its child classes
2. <T extends Runnable> - If X is interface then T here can be either that interface type or its implementing classes. However we still have to use extends keyword only.
3. <T extends Runnable & Comparable>          - We can immplement more than one interface with & i.e <T extends Runnable & Comparable>
4. <T extends Number & Runnable & Comparable> - We can extend exactly one class but any no of interfaces as <T extends Number & Runnable & Comparable> - class first followed by interfaces
5. Finally we see that we can only use extends keyword and not implements or super.

*/
public class MyOwnGeneric<T>
{	
	private T obj;
	
	MyOwnGeneric(T obj)
	{
		this.obj = obj;
	}
	
	public void showType()
	{
		System.out.println("The substituted type is " + obj.getClass().getName());
	}
	
	public static void main(String[] args) {
		MyOwnGeneric<String> gen1 = new MyOwnGeneric<>("Durga");
		gen1.showType();
		
		MyOwnGeneric<Integer> gen2 = new MyOwnGeneric<>(10);
		gen2.showType();
		
		MyOwnGeneric<Float> gen3 = new MyOwnGeneric<>(10.0f);
		gen3.showType();
	}
	
    /*
	    public <T> void m1(T ob)     //Generic Method
		{
		  //1. Use T anywhere within the method based on our requirement
		  //2. All rules regarding bounded types for the parameter type are the same as that for generic class
		}
	*/
}
