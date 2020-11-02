package Exercice4;


public class PochetteDocJeunesse<E extends DocumentJeunesse> extends Pochette<E> {
	private int Agemin;

	public PochetteDocJeunesse() {
		super(theme);
	}

	public PochetteDocJeunesse(String t, int age) {
		super(t);
		Agemin=age;
	}
	

	public void add(E e) throws DocumentNonAutorise {
		if(e.aPartirDe()>Agemin)
			throw new DocumentNonAutorise();
		else
			super.ajout(e);;
	}
	
	public String toString(){
		return super.toString()+ " à partir de "+Agemin+" ans";
	}
}