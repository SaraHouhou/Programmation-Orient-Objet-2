package ex1;


import java.awt.Color;
import java.util.Iterator;

@SuppressWarnings("hiding")
public class iterateurTriColeur implements Iterator<Color>{

	int index; 
	feuxtricolores ft;
	public iterateurTriColeur(feuxtricolores ft) {
		index=-1;
		this.ft= ft;
	}
@Override
	public boolean hasNext() {
	index++;
		return index<ft.couleurList.size();
	}


	@Override
	public Color next() {
		
		return ft.couleurList.get(index);
	}



public void remove()  {
	try {
		throw new UnsupportedOperationException();
	} catch (UnsupportedOperationException e) {
System.out.print("remove operation Unsupported");	
	}
}
	

}
