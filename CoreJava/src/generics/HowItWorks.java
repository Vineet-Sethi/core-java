/*
A generic implementation of ArrayList might look like

public class ArrayList<T>
{
	public void add(T ob) {}
	
	public T get(int index) {}
}

On declaring ArrayList<String> nameList = new ArrayList<String>(); the substituted class becomes as

public class ArrayList<String>
{
	public void add(String ob) {}
	
	public String get(int index) {}
}

Hence in the new class add method only accepts strings while the get method only returns strings(No type-casting needed :))

<A>, <XYZ>, <A, B>, <K, V> - You can use any valid java identifier in place of <T> but it is a convention to use T. Also you can have any number of type
parameters seperated by commas.
*/