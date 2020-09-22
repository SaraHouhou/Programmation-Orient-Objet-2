package cercleSportif;

public class Heure {
private int heures;
private int minutes;

private static int granulariteMinutes=5;
private static int heureMax=22;
private static int heureMin=7;

private boolean heuresCorrectes(){
	return heures>=heureMin && heures<=heureMax;

}

private boolean minutesCorrectes(){
	boolean result=minutes%granulariteMinutes==0;
	if (heures==heureMax&&minutes!=0)result=false;
	return result;
	
}

public Heure(int heures,int minutes){
	this.heures=heures;
	this.minutes=minutes;
	if (!heuresCorrectes()||!minutesCorrectes()){
		this.heures=-1;
		this.minutes=-1; // heures ou minutes incorrectes, on met -1, ce serait bien de lancer une exception
	}
}

public String toString(){
	String h=Integer.toString(heures);
	String mn=Integer.toString(minutes);
	// traitement des cas d'erreur
	if (heures==-1){return "ERREUR";}
	// ajout des 0 non significatifs
	if (heures<10)h="0"+h;
	if (minutes<10)mn="0"+mn;
	return h+":"+mn;
}

public boolean estStrictementAvant(Heure autreHeure) {
	return heures<autreHeure.heures || (heures==autreHeure.heures&&minutes<autreHeure.minutes);
}

public boolean estAvant(Heure autreHeure) {
	return heures<autreHeure.heures || (heures==autreHeure.heures&&minutes<=autreHeure.minutes);
}

}
