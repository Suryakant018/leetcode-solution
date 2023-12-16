
// Java Iterator interface reference:
// https://docs.oracle.com/javase/8/docs/api/java/util/Iterator.html

class PeekingIterator implements Iterator<Integer> {
    List<Integer> list=new ArrayList<>();
	public PeekingIterator(Iterator<Integer> iterator) {
	    while (iterator.hasNext())
            list.add(iterator.next());
    }
	
    // Returns the next element in the iteration without advancing the iterator.
	public Integer peek() {
       return list.get(0);
	}
	
	// hasNext() and next() should behave the same as in the Iterator interface.
	// Override them if needed.
	@Override
	public Integer next() {
	    return list.remove(0);
	}
	
	@Override
	public boolean hasNext() {
	    if(list.isEmpty())
            return false;
        return true;
	}
}