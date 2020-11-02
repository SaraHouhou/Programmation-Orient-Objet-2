package Exercice4;

public class PochetteEnfant<T  extends DocumentJeunesse> extends Pochette<T> {
private int ageMin;
	public PochetteEnfant(String t, int age) {
		super(t);
		ageMin=age;
	}
	
	public String toString(){
		return super.toString()+ " à partir de "+ageMin+" ans";
	}

	public void ajout(T t) throws DocumentNonAutorise{
		if (t.aPartirDe()>ageMin) throw new DocumentNonAutorise();
		super.ajout(t);
	}
	
	
}