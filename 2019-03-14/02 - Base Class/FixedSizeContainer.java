public class FixedSizeContainer<T> implements Container<T> {
	
	protected T[] storage;
	protected int numElems;
	
	public FixedSizeContainer(int size) {
		storage = (T[])new Object[size];
		numElems = 0;
	}
	
	public void add(T s) {
		storage[numElems] = s;
		numElems += 1;
	}

	public int size() {
		return numElems;
	}
	
	public T elementAt(int idx) {
		return storage[idx];
	}
}
