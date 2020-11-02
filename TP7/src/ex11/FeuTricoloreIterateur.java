package ex11;


import java.awt.Color;
import java.util.Iterator;

public class FeuTricoloreIterateur implements Iterator<Color> {

	private int curseur = 0;
	private Color[] couleurs;
	
	public FeuTricoloreIterateur(Color[] couleurs)
	{this.couleurs = couleurs;}
	
	

	public boolean hasNext() {
		return true;
	}

	@Override
	public Color next() {
		Color couleurCourante = this.couleurs[curseur]; 
		curseur +=1; if (curseur == 3) curseur =0;
		return couleurCourante;
	}

	@Override
	public void remove() {
		throw new UnsupportedOperationException();
	}

}
