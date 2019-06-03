class A {
	private final int a = prepareA();
	
	public A() {
		System.out.println("A::ctor (name: " + getMyName() + ")");		
	}
	public A(int x) {
		System.out.println("A::ctor(int)");
	}
	
	private static int prepareA() {
		System.out.println("A::prepareA");	
		return 8;
	}
	
	public final void printMyName() {
		System.out.println("My name is: " + this.getMyName());
	}
	
	public String getMyName() {
		System.out.println("A::getMyName (a: " + a + ")");
		return "A";
	}
}

class B extends A {
	private final int b = prepareB();
	private final int b2 = prepareB2();
	
	public B() {
		System.out.println("B::ctor (b: " + b + ", b2: " + b2 + ")");
	}
	public B(int x) {
		System.out.println("B::ctor (int: " + x + ", b: " + b + ", b2: " + b2 + ")");
	}
	
	private int prepareB() {
		System.out.println("B::prepareB (b2: " +  b2 + ")");	
		return 8;
	}
	
	private int prepareB2() {
		System.out.println("B::prepareB2 (b:" +  b + ")");	
		return 9;
	}
	
	@Override
	public String getMyName() {
		System.out.println("B::getMyName (b: " + b + ", b2: " + b2 + ")");
		return "B";
	}
}

class C extends B {
	private final int c = prepareC();

	public C() {
		super(0);
		System.out.println("C::ctor");
	}
	
	private static int prepareC() {
		System.out.println("C::prepareC");	
		return 8;
	}

	@Override
	public String getMyName() {
		System.out.println("C::getMyName (c: " + c + ")");
		return "C";
	}
}

public class Init {
	public static void main(String[] args) {
		C obj = new C();
		obj.printMyName();
	}
}