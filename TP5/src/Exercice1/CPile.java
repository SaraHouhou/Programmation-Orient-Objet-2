package Exercice1;
import java.util.*;

public class CPile<A> implements IPile<A> {

	private LinkedList<A> list;
	
	//constructor
	public CPile() {
		list = new LinkedList<A>();
	}
	
	@Override
	public A depile() {
		return list.removeFirst();
	}

	@Override
	public void empile(A a) {
		list.addFirst(a);
	}

	@Override
	public boolean estVide() {
		return list.size() == 0;
	}
     
	@Override
	public int nbElements() {
		return list.size();
	}

	@Override
	public A sommet() {
		return list.peek();
	}
	
	public String toString() {
		String str = "";
		for(A a : list)
			str += a+"-";
		return str;
	}
}

