package TD2.EXO1;

public class Main {
	
	public static void main (String [] args) {
		
		Livre l1=new Livre (" l 1 " , 3 ) ;
		Document l2=new Livre (" l 2 " , 4 ) ;
		Document d=new Document ("d " ) ;
		Biblio b =new Biblio ( ) ;
		BiblioSansDoublons bsd=new BiblioSansDoublons ( ) ;
		Biblio bsd2=new BiblioSansDoublons ( ) ;
		// ajout dans b : Bi b l i o
		b . ajoutDocument ( l1 ) ;
		b . ajoutDocument ( l1 ) ;
		b . ajoutDocument ( l2 ) ;
		b . ajoutDocument (d ) ;
		System.out.println(b.toString( ) ) ;
		
		
		System.out.println("partie 2") ;

		// ajout dans bsd : Bibl ioSansDoublons
		bsd . ajoutDocument ( l1 ) ;
		bsd . ajoutDocument ( l1 ) ;
		bsd . ajoutDocument ( l2 ) ;
		bsd . ajoutDocument (d ) ;
		System.out.println( bsd.toString( )  ) ;
		
		System.out.println("partie 3") ;

		// ajout dans bsd2 : Bibl ioSansDoublons
		bsd2 . ajoutDocument ( l1 ) ;
		bsd2 . ajoutDocument ( l1 ) ;
		bsd2 . ajoutDocument ( l2 ) ;
		bsd2 . ajoutDocument (d ) ;
		System.out.println( bsd2.toString( )  ) ;
		
	}

}
