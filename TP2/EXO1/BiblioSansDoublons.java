package TD2.EXO1;

public class BiblioSansDoublons extends Biblio {
	public void ajoutDocument (Document d) {
	if ( ! contains (d ) ) {
	super . ajoutDocument (d ) ;
}
}
	public void ajoutDocument ( Livre l ) {
	if ( ! contains ( l ) ) {
	super.ajoutDocument ( l ) ;
	}
}
}
