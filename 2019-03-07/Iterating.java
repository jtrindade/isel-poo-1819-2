import java.util.Iterator;

public class Iterating {
	public static void main(String[] args) {
		final ListContainer<String> container = new ListContainer<String>();
		
		container.add("alpha");
		container.add("beta");
		container.add("gamma");
		container.add("delta");
		
		final Iterator<String> it1 = container.iterator();
		while (it1.hasNext()) {
			System.out.println(it1.next());
		}
		
		final Iterator<String> it2 = container.iterator();
		while (it2.hasNext()) {
			System.out.println(it2.next());
		}
		
		for (String str : container) {
			System.out.println(str);
		}

		for (Integer i : new Range(5, 15)) {
			System.out.println(i);
		}
	}
}
