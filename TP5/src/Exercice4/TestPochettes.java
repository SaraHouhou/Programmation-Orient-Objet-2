package Exercice4;


import static org.junit.Assert.*;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.Before;
import org.junit.Test;


public class TestPochettes {
	Pochette<LivreDocumentaire> pochetteLivresDocu=new Pochette<LivreDocumentaire>("chats");
	Pochette<Document> pochetteDoc=new Pochette<Document>("chats");
	Pochette<GuideVoyage> pochetteguide=new Pochette<GuideVoyage>("guideVoyage");


	PochetteDocJeunesse<DocumentJeunesse> pochetteDocJeunesse=new PochetteDocJeunesse<DocumentJeunesse>("chats", 8);
			//Pochette<Livre> p2=new PochetteEnfant<LivreJeunesse>("non !", 6);
	LivreJeunesse lj9=new LivreJeunesse(9);
	
	Livre l=new Livre();
	GuideVoyage GV= new GuideVoyage();
	
	LivreDocumentaire ld=new LivreDocumentaire();
	
	//Q14
	
	Pochette<Livre> pochettelivre=new Pochette<Livre>("pochette livre");
	Pochette<LivreJeunesse> pochetLivreJeuness=new Pochette<LivreJeunesse>("livreJeuness");
	
	
	// question11
	@Test
	public void testAjoutMauvaisType() throws DocumentNonAutorise{
		// pochetteguide.ajout(lj9);  -> EREUR DE COMILATION
	//	pochetDocJeuness.ajout(GV);
		pochetteDoc.ajout(ld); // nous povons ajouter livre doccument
		pochetteDoc.ajout(l); // nous povons ajouter livre doccument
		pochetteDoc.ajout(lj9); // nous povons ajouter livre doccument
		assertEquals(3, pochetteDoc.taille());
		

//		pochetteLivresEnfants.ajout(l);
		
	}
	
	// q12
	@Test(expected=DocumentNonAutorise.class)
	public void testAjoutLivreJeunesseMauvaisAge() throws DocumentNonAutorise {
		pochetteDocJeunesse.ajout(lj9);
	}

	
	//q13
	@Test
	public void testTranfere() throws DocumentNonAutorise{
		pochetteLivresDocu.ajout(ld); // ajout livre doccumentaire
		pochetteLivresDocu.transfereVers(pochetteDoc);
		assertEquals(2, pochetteDoc.taille());
		pochetteDocJeunesse.transfereVers(pochetteDoc);
		// pochetteLivres.transfereVers(pochetteLivresDocu); pas le bon type
	}
	
	//q14
	@Test
	public void testLivreJetLivre() throws DocumentNonAutorise{
	//pochettelivre.transfereVers(pochetLivreJeuness); // non
	pochetLivreJeuness.transfereVers(pochettelivre); // oui
	}
//	@Before
//	public void init() throws DocumentNonAutorise{
//	LivreJeunesse lj7=new LivreJeunesse(7)
	//pochetteLivres.ajout(lj7);
	//pochetteDocJeunesse.ajout(lj7);
	//}
	
}
