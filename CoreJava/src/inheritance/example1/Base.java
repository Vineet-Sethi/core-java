package inheritance.example1;

public class Base {
	
    private void func(){
		System.out.println("In base func method");
	}
	
	public void func2() {
		System.out.println("func2");
		func();
	}
}
