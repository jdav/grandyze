package com.malleamus.grandyze;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Random;


public class CircularList<E> extends ArrayList<E> {

	private final Random random = new Random();

	@Override
	public Iterator<E> iterator() {
		return new CircularIterator<E>(this);
	}

	public void randomize() {
		int numberSwaps = random.nextInt(this.size() * 2);
		do {
			int randomSelection = random.nextInt(this.size());
			E o = this.get(randomSelection);
			this.remove(randomSelection);
			this.add(o);
		} while (--numberSwaps > 0);
	}
}
