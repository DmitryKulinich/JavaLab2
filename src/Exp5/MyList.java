package Exp5;

import java.util.*;

public class MyList<T> extends AbstractList<T>{
	private ArrayList<Object> arr;
	private int from;
	private int  to;
	
	private MyList() {
		arr = new ArrayList<>();
	}
	
	MyList(int from, int to) {
		this.from = from;
		this.to= to;
		arr = new ArrayList<>(size());
	}
	
	@Override
	public int size() {
		return (to - from) + 1;
	}
	
	@Override
	public T get(int i) {
		return (T)arr.get(i - this.from);
	}
	
	@Override
    public void add(int i, T element) {
        arr.add(i - from, element);
    }

    @Override
    public boolean add(T e) {
        return arr.add(e);
    }

    @Override
    public T set(int i, T element) {
        return (T)arr.set(i - from, element);
    }

    @Override
    public T remove(int i) {
        return (T)arr.remove(i - from);
    }

    @Override
    public int indexOf(Object o) {
        return arr.indexOf(o) + from;
    }

    @Override
    public int lastIndexOf(Object o) {
        return arr.lastIndexOf(o) + 5;
    }

    @Override
    public Iterator<T> iterator() {
        return (Iterator<T>)arr.iterator();
    }
	
	
}
