package cercleSportif;

import java.util.GregorianCalendar;

public class Adherent {
private String nom;
private static int nbAdherents=0;
private boolean cotisationPayee=true;
private int derniereAnneeCotisation;

private final int  numero;

public Adherent(String nom){
	nbAdherents++;
	this.nom=nom;
	this.numero=nbAdherents;
	derniereAnneeCotisation=new GregorianCalendar().get(GregorianCalendar.YEAR);
}

public String toString(){
	return nom+" "+numero+" derniereAnneeCotisation="+derniereAnneeCotisation;
}

public void finAnnee(){
	cotisationPayee=false;
	if (new GregorianCalendar().get(GregorianCalendar.YEAR)-derniereAnneeCotisation>5){
		System.out.println("il faudrait radier l'abonné");
	}
}

public void reAdhesion(){
	cotisationPayee=true;
	derniereAnneeCotisation=new GregorianCalendar().get(GregorianCalendar.YEAR);
}
}
