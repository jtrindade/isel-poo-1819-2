public class POO
{
	/* PART 1
	public static void main(String[] args)
	{
		int[] data = new int[] { 3, 7, 11, 0, 0, 0, 0, 0 };
		
		TestInsert.testInsert();
		
		show(data, 3);
		
		insert(data, 3, 5);
		
		show(data, 4);
	}
	*/	

	public static void main(String[] args)
	{
		int[] data = new int[] { 2, 6, 1, -23, 0, 15, 3, 7, 6, -1 };
		
		TestInsert.testInsert();
		
		show(data, data.length);
		
		sort(data);
		
		show(data, data.length);
	}
	
	static void sort(int[] data)
	{
		for (int i = 0; i < data.length; ++i) {
			insert(data, i, data[i]);
		}
	}
	
	static void insert(int[] items, int numElems, int newVal)
	{
		int i = numElems;
		for ( ; i > 0 && items[i - 1] > newVal; --i) {
			items[i] = items[i - 1];
		}
		items[i] = newVal;
	}
	
	static void show(int[] items, int numElems)
	{
		for (int i = 0; i < numElems; ++i) {
			System.out.print(" " + items[i]);
		}
		System.out.println();
	}
}

class TestInsert
{
	static void testInsert() {
		if (!testInsertIntoEmptyArray()) {
			System.err.println("FAILED: testInsertIntoEmptyArray");
		}
		if (!testInsertValueInMiddle()) {
			System.err.println("FAILED: testInsertValueInMiddle");
		}
		if (!testInsertAtEnd()) {
			System.err.println("FAILED: testInsertAtEnd");
		}
	}
	
	static boolean testInsertIntoEmptyArray() {
		int[] data = new int[3];
		int[] expectedData = new int[] { 5, 0, 0 };
		
		POO.insert(data, 0, 5);
		
		return compare(data, expectedData);
	}
	
	static boolean testInsertValueInMiddle() {
		int[] data         = new int[] { 3, 7, 11, 0, 0, 0, 0, 0 };
		int[] expectedData = new int[] { 3, 5, 7, 11, 0, 0, 0, 0 };
		
		POO.insert(data, 3, 5);
		
		return compare(data, expectedData);
	}
	
	static boolean testInsertAtEnd() {
		int[] data         = new int[] { 3, 7, 11,  0, 0, 0, 0, 0 };
		int[] expectedData = new int[] { 3, 7, 11, 21, 0, 0, 0, 0 };
		
		POO.insert(data, 3, 21);
		
		return compare(data, expectedData);
	}
	
	static boolean compare(int[] actual, int[] expected) {
		if (actual.length != expected.length) {
			return false;
		}
		for (int i = 0; i < actual.length; ++i) {
			if (actual[i] != expected[i]) {
				return false;
			}
		}
		return true;
	}
}
