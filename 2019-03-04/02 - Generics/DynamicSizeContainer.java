public class DynamicSizeContainer<T> implements Container<T> {
	
	private T[] storage;
	private int numElems;
	
	public DynamicSizeContainer(int initialSize) {
		storage = (T[])new Object[initialSize];
		numElems = 0;
	}
	
	public void add(T s) {
		if (storageIsFull()) {
			duplicateStorage();
		}
		storage[numElems] = s;
		numElems += 1;
	}
	
	public int size() {
		return numElems;
	}
	
	public T elementAt(int idx) {
		return storage[idx];
	}
	
	private boolean storageIsFull() {
		return numElems == storage.length;
	}
	
	private void duplicateStorage() {
		T[] newStorage = (T[])new Object[storage.length * 2];
		System.arraycopy(storage, 0, newStorage, 0, storage.length);
		storage = newStorage;
	}
}
