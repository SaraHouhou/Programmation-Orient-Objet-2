package ex2;

import java.util.Iterator;



public class IterateurFeuilleSalaire implements Iterator<Object> {

	private FeuilleSalaire f;
	private int curseur=0;
	
	IterateurFeuilleSalaire(FeuilleSalaire f){this.f=f;}
	
	@Override
	public boolean hasNext() {
		return curseur < 4; // f.getClass().getFields().length;
	}

	@Override
	public Object next() {
		switch (curseur) {
        case 0: 
          curseur = 1;
          return f.getEmployeur();
        case 1: 
          curseur = 2;
          return f.getSalarie();
        case 2:
          curseur = 3;
          return f.getNombreHeures();
        case 3:
            curseur = 4;
            return f.getMontantNet();       	
        default:
          throw new RuntimeException("pas de champ pour cet indice");
        }
	}

	@Override
	public void remove() {
		throw new UnsupportedOperationException();
	}

}
