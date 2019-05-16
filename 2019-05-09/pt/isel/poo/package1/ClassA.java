package pt.isel.poo.package1;

public class ClassA
{
	public static int val = 2;
	
	private static final String DEFAULT_NAME = "X"; 

	public static int anotherVal = getAnotherVal();
	
	static {
		System.out.println("-- initializing ClassA --");
	}
	
	public ClassA() 
	{
		System.out.println("-- new instance of ClassA --");
	}
	
	public static int getAnotherVal()
	{
		System.out.println("-- running ClassA.getAnotherVal --");
		return 5;
	}
}