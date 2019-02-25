public class DataItems {
	
	public static void main(String[] args) {
		
		Container items;
		
		if (args.length > 0 && args[0].charAt(0) == 'f') {
			items = new FixedSizeContainer();
		} else {
			items = new DynamicSizeContainer();
		}
		
		items.add("Alpha");
		items.add("Beta");
		items.add("Gamma");
		items.add("Delta");
		
		for (int i = items.size() - 1; i >= 0; --i) {
			System.out.println( items.elementAt(i) );
		}
		
	}
}

interface Container {
	
	void add(String s);
	
	int size();
	
	String elementAt(int idx);
}

class FixedSizeContainer implements Container {
	
	private String[] storage;
	private int numElems;
	
	public FixedSizeContainer() {
		storage = new String[1];
		numElems = 0;
	}
	
	public void add(String s) {
		storage[numElems] = s;
		numElems += 1;
	}
	
	public int size() {
		return numElems;
	}
	
	public String elementAt(int idx) {
		return storage[idx];
	}
}

class DynamicSizeContainer implements Container {
	
	private String[] storage;
	private int numElems;
	
	public DynamicSizeContainer() {
		storage = new String[1];
		numElems = 0;
	}
	
	public void add(String s) {
		if (storageIsFull()) {
			duplicateStorage();
		}
		storage[numElems] = s;
		numElems += 1;
	}
	
	public int size() {
		return numElems;
	}
	
	public String elementAt(int idx) {
		return storage[idx];
	}
	
	private boolean storageIsFull() {
		return numElems == storage.length;
	}
	
	private void duplicateStorage() {
		String[] newStorage = new String[storage.length * 2];
		System.arraycopy(storage, 0, newStorage, 0, storage.length);
		storage = newStorage;
	}
}
