public class DynamicSizeContainer<T> extends FixedSizeContainer<T> {
	
	public DynamicSizeContainer(int initialSize) {
		super(initialSize);
	}

	@Override
	public void add(T s) {
		if (storageIsFull()) {
			duplicateStorage();
		}
		super.add(s);
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
