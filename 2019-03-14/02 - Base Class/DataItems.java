public class DataItems {
	
	public static void main(String[] args) {
	
		char containerSelector = args.length > 0 ? args[0].charAt(0) : 'd';

		Container<String> strings = createContainer(containerSelector);
		fillContainerWithStrings(strings);
		showContainer(strings);

		Container<Student> students = createContainer(containerSelector);
		fillContainerWithStudents(students);
		showContainer(students);
		
		Container<Long> longs = createContainer(containerSelector);
		fillContainerWithLongs(longs);
		showContainer(longs);
	}
	
	private static <T> Container<T> createContainer(char containerSelector) {
		switch (containerSelector) {
			case 'f':
				return new FixedSizeContainer<T>(4);
			case 'l':
				return new ListContainer<T>();
			case 'd':
			default:
				return new DynamicSizeContainer<T>(4);
		}
	}
	
	private static void fillContainerWithStrings(Container<String> items) {
		items.add("Alpha");
		items.add("Beta");
		items.add("Gamma");
		items.add("Delta");
	}
	
	private static void fillContainerWithStudents(Container<Student> items) {
		items.add(new Student(19723, "Joao Trindade"));
		items.add(new Student(1143, "Afonso Henriques"));
		items.add(new Student(1889, "Fernando Pessoa"));
	}
	
	private static void fillContainerWithLongs(Container<Long> items) {
		items.add(1L);
		items.add(2L);
		items.add(3L);
		items.add(4L);
	}
	
	private static <T> void showContainer(Container<T> items) {
		for (int i = items.size() - 1; i >= 0; --i) {
			System.out.println( items.elementAt(i) );
		}		
	}
}

class Student {
	private final int number;
	private final String name;
	
	public Student(int number, String name) {
		this.number = number;
		this.name = name;
	}
	
	public String toString() {
		return "{ " + number + ", " + name + " }";
	}
}
