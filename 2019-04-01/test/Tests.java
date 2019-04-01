package test;

import test.model.ModelTests;

public class Tests {
	public static void main(String[] args) {
		try {
			ModelTests.runAllTests();
		} catch (IllegalArgumentException ex) {
			System.out.println("Exception caught in main\n" + ex);
		}
	}
	
	public static void check(boolean result, String testName, String errorMessage) {
		if (result == false) {
			fail(testName, errorMessage);
		}
	}
	
	public static void fail(String testName, String errorMessage) {
		System.err.println("FAIL in " + testName + " : " + errorMessage);
	}
}
