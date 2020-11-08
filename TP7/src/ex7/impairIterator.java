package ex7;

import java.util.Iterator;

public class impairIterator implements Iterator<Integer> {
private int valeurCourante = 0;
	
	@Override
	public boolean hasNext() {
		return valeurCourante < Integer.MAX_VALUE - 1;
	}

	@Override
	public Integer next() {
		valeurCourante+=1;
		if(valeurCourante%2==0) {valeurCourante+=1; }		
		return valeurCourante;
	}

	@Override
	public void remove() {
		System.out.println("pas de retrait");
	}

	
}