import java.util.*;

class C {
	
}

public class AutoBox {
	boolean b = false;
	short s = 32;
	int val = 374246234;

	String str = "ISEL";
	
	C obj = new C();
	
	public static void main(String[] args) {
		List<String> items = new ArrayList<>();
		items.add("ISEL");
		items.add("POO");
		items.add("LEIC");
		
		for (String item : items) {
			System.out.println(item);
		}

		List<Integer> items2 = new ArrayList<>();
		items2.add(Integer.valueOf(12123));
		items2.add(546456);
		items2.add(654);
		
		for (Integer item2 : items2) {
			int i = item2;
			System.out.println(i);
		}
	}
}