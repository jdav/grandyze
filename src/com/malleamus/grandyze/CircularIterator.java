package com.malleamus.grandyze;

import java.util.Iterator;


public class CircularIterator<E> implements Iterator<E> {

	private CircularList<E> list = null;
	private int current = 0;

	public CircularIterator(CircularList<E> list) {
		this.list = list;
		this.current = list.size() - 1;
	}

	@Override
	public boolean hasNext() {
		return true;
	}

	@Override
	public E next() {
		if (current >= list.size() - 1) {
			current = 0;
		} else {
			current++;
		}
		return list.get(current);
	}

	@Override
	public void remove() {
	}

}
