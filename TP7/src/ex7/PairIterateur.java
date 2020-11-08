package ex7;

import java.util.Iterator;

public class PairIterateur implements Iterator<Integer> {

	private int valeurCourante = 0;
	
	@Override
	public boolean hasNext() {
		return valeurCourante < Integer.MAX_VALUE - 2;
	}

	@Override
	public Integer next() {
		valeurCourante+=2;
		return valeurCourante;
	}

	@Override
	public void remove() {
		System.out.println("pas de retrait");
	}

	public static void main(String[] argv)
	{
		PairIterateur i = new PairIterateur();
		for (int ii=0; ii < 12; ii++)
			System.out.println(i.next());	
	}
}