package oops.concepts;

public class CustomType<T> {
	
private T obj;
	
	public CustomType(T obj) {
		this.obj = obj;
	}
	
	public T getObj()
	{
		return obj;
	}
	
	public void show()
	{
		System.out.println("The type passed was " + obj.getClass().getName());
	}
	
	public static void main(String[] args) {
		CustomType<String> generic = new CustomType<>("Core Java");
		generic.show();
		System.out.println(generic.getObj());
		
		CustomType<Integer> generic2 = new CustomType<>(10);
		generic2.show();
		System.out.println(generic2.getObj());
	}
}
