package cercleSportif;

public class CreneauAvecHeureDedans {

	private JourSemaine jour;
	private HeureI debut;
	private HeureI fin;

	public  CreneauAvecHeureDedans(JourSemaine jour,HeureI debut, HeureI fin) {
		this.jour = jour;
		// si fin est avant debut on inverse fin et debut ... c'est bof, le mieux serait de lancer une exception
		// on ne fait rien pour les créneaux "vides"
		if (fin.estAvant(debut)){
			this.debut = fin;
			this.fin = debut;
		}else{
			this.debut = debut;
			this.fin = fin;
		}
	}
	
	public CreneauAvecHeureDedans(JourSemaine jour, int hdebut, int mdebut, int hfin, int mfin) {
		this.jour = jour;
		debut=new HeureI(hdebut, mdebut);
		fin=new HeureI(hfin, mfin);
		// si fin est avant debut on inverse fin et debut ... c'est bof, le mieux serait de lancer une exception
		// on ne fait rien pour les créneaux "vides"
		if (fin.estAvant(debut)){
			this.debut = fin;
			this.fin = debut;
		}
	}

	public String toString(){
		return jour.toString() +" "+debut+" - "+fin;
	}


	public boolean chevauche(CreneauAvecHeureDedans c) {
		return jour==c.jour&&(!(c.fin.estStrictementAvant(debut)||fin.estStrictementAvant(c.debut)));
	}

	public boolean estInclusDans(CreneauAvecHeureDedans c){
		return jour==c.jour && c.debut.estAvant(debut) && fin.estAvant(c.fin);
	}
	
	private static class HeureI {
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

		public HeureI(int heures,int minutes){
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

		public boolean estStrictementAvant(HeureI autreHeure) {
			return heures<autreHeure.heures || (heures==autreHeure.heures&&minutes<autreHeure.minutes);
		}

		public boolean estAvant(HeureI autreHeure) {
			return heures<autreHeure.heures || (heures==autreHeure.heures&&minutes<=autreHeure.minutes);
		}
	}
}


