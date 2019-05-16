package pt.isel.poo;

import pt.isel.poo.package1.ClassA;

public class EntryClass
{
	public static void main(String[] args) throws Exception
	{
		Class classAobj1 = ClassA.class;
		
		/*
		Class classAobj2 = Class.forName("pt.isel.poo.package1.ClassA");
		
		if (classAobj1 == classAobj2) {
			System.out.println("Same obj for ClassA");
		} else {
			System.out.println("Different objs for ClassA");
		}
		*/
		
		System.out.println("" + ClassA.val);
		
		// ClassA objA = new ClassA();
		
		/*
		Class classAobj3 = objA.getClass();
		
		if (classAobj1 == classAobj3) {
			System.out.println("Same obj for ClassA");
		} else {
			System.out.println("Different objs for ClassA");
		}
		*/
	}
}
