import java.util.Iterator;
import java.util.NoSuchElementException;

public class Range implements Iterable<Integer> {
	
	private final int begin;
	private final int end;
	
	public Range(int begin, int end) {
		this.begin = begin;
		this.end = end;
	}
	
	public Iterator<Integer> iterator() {
		return new RangeIterator(begin, end);
	}
}
	
class RangeIterator implements Iterator<Integer> {
	private int current;
	private final int end;
	
	public RangeIterator(int begin, int end) {
		this.current = begin;
		this.end = end;
	}
	
	public boolean hasNext() {
		return current < end;
	}
	
	public Integer next() {
		if (!hasNext()) {
			throw new NoSuchElementException();
		}
		final Integer res = Integer.valueOf(current);
		
		current += 1;
		
		return res;
	}
}
