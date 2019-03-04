public class ListContainer<T> implements Container<T> {
	
	private final ListNode<T> head;
	private int numElems;
	
	public ListContainer() {
		head = new ListNode<T>(null, null);
		numElems = 0;
	}
	
	public void add(T s) {
		final ListNode<T> newNode = new ListNode<T>(s, null);
		final ListNode<T> lastNode = findLastNode();
		
		lastNode.setNext(newNode);
		numElems += 1;
	}
	
	public int size() {
		return numElems;
	}
	
	public T elementAt(int idx) {
		final ListNode<T> nthNode = findNthNode(idx);
		return nthNode.getValue();
	}
	
	private ListNode<T> findLastNode() {
		ListNode<T> curr = head;
		while (curr.getNext() != null) {
			curr = curr.getNext();
		}
		return curr;
	}
	
	private ListNode<T> findNthNode(int n) {
		ListNode<T> node = head.getNext();
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

class ListNode<T> {
	private ListNode<T> next;
	private final T value;
	
	public ListNode(T value, ListNode<T> next) {
		this.next = next;
		this.value = value;
	}
	
	public T getValue() {
		return value;
	}
	
	public ListNode<T> getNext() {
		return next;
	}
	
	public void setNext(ListNode<T> next) {
		this.next = next;
	}
}
