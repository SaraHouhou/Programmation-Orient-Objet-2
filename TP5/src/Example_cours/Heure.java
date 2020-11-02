package Example_cours;


public class Heure {
 private int heures , minutes ;
 private static int granulariteMinutes=5;
 private static int heureMax=22;
 private static int heureMin=7;

 private boolean heuresCorrectes() {
 return heures>=heureMin && heures<=heureMax;
}
 private boolean minutesCorrectes() {
boolean result=minutes%granulariteMinutes==0;
 if ( heures==heureMax&&minutes !=0) result=false ;
 return result ;
 }
public Heure ( int heures , int minutes ) throws HoraireIncorrectException {
 this.heures=heures ;
 this . minutes=minutes ;
 if ( !heuresCorrectes ( ) || !minutesCorrectes() ) {
 throw new HoraireIncorrectException( " heure s p e c i f i e e i n c o r r e c t e " ) ;
 }
}
 public String toString ( ) {
String h=Integer.toString ( heures ) ;
String mn=Integer.toString(minutes ) ;
// a j out des 0 non s i g n i f i c a t i f s
if (heures <10)h="0"+h ;
if (minutes <10)mn="0"+mn;
return h+" : "+mn;
 }
 
 public boolean estStrictementAvant(Heure autreHeure) {
		return heures<autreHeure.heures || (heures==autreHeure.heures&&minutes<autreHeure.minutes);
	}

	public boolean estAvant(Heure autreHeure) {
		return heures<autreHeure.heures || (heures==autreHeure.heures&&minutes<=autreHeure.minutes);
	}
 }
