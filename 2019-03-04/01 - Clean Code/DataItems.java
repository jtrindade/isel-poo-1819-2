public class DataItems {
	
	public static void main(String[] args) {
	
		char containerSelector = args.length > 0 ? args[0].charAt(0) : 'd';

		Container items = createContainer(containerSelector);
	
		fillAndShowContainer(items);
	}
	
	private static Container createContainer(char containerSelector) {
		switch (containerSelector) {
			case 'f':
				return new FixedSizeContainer();
			case 'l':
				return new ListContainer();
			case 'd':
			default:
				return new DynamicSizeContainer();
		}
	}
	
	private static void fillAndShowContainer(Container items) {
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

class ListNode {
	private ListNode next;
	private final String value;
	
	public ListNode(String value, ListNode next) {
		this.next = next;
		this.value = value;
	}
	
	public String getValue() {
		return value;
	}
	
	public ListNode getNext() {
		return next;
	}
	
	public void setNext(ListNode next) {
		this.next = next;
	}
}

class ListContainer implements Container {
	
	private final ListNode head;
	private int numElems;
	
	public ListContainer() {
		head = new ListNode(null, null);
		numElems = 0;
	}
	
	public void add(String s) {
		final ListNode newNode = new ListNode(s, null);
		final ListNode lastNode = findLastNode();
		
		lastNode.setNext(newNode);
		numElems += 1;
	}
	
	public int size() {
		return numElems;
	}
	
	public String elementAt(int idx) {
		final ListNode nthNode = findNthNode(idx);
		return nthNode.getValue();
	}
	
	private ListNode findLastNode() {
		ListNode curr = head;
		while (curr.getNext() != null) {
			curr = curr.getNext();
		}
		return curr;
	}
	
	private ListNode findNthNode(int n) {
		ListNode node = head.getNext();
		int nodeIdx = 0; 
		while (nodeIdx < n && node != null) {
			node = node.getNext();
			nodeIdx += 1;
		}
		if (node == null) {
			throw new ArrayIndexOutOfBoundsException();
		}
		return node;
	}
}
