package Visite;

import java.util.Vector;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;


import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;


public class TestTroncon {
	Troncon tr1;
	Troncon tr2;
	Troncon tr3;
	Etape et1; 
	Etape et2; 
	Etape et3;
	Etape et4;
	Parcours parcour; 
	@BeforeEach
	public void setUp(){
		et1= new Etape("musee de la defence", "paris la defence", 30,NatureEtape.musee);
		et2= new Etape("tour eiffel","champs mars" ,30,NatureEtape.visiteMonument);
        et3= new Etape("jardin du luxembourg","rue de medicis",20,NatureEtape.visiteJardin);
		et4= new Etape("Opera","rue de lyon",60,NatureEtape.lieuInteretSansVisite);
	

		
		Vector<String> v1= new Vector<String>();
		v1.add(et1.getRue());
		v1.add(et2.getRue());
		
		Vector<String> v2= new Vector<String>();
		v2.add(et2.getRue());
		v2.add(et3.getRue());
		
		Vector<String> v3= new Vector<String>();
		v3.add(et3.getRue());
		v3.add(et4.getRue());

		 tr1= new Troncon(et1, et2, 20,v1 );	
		 tr2= new Troncon(et2, et3, 15, v2);
		 tr3= new Troncon(et3, et4, 10, v3);
		 
		 parcour= new Parcours();
		 parcour.ajoutTroncon(tr1);
         parcour.ajoutTroncon(tr2);
         parcour.ajoutTroncon(tr3);
         parcour.ajoutTroncon(tr1);
		}
	
	
	@Test
	
	void testcalculDuree() {
		
		assertEquals(190, parcour.calculDuree());
	}
	
	
	@Test
	void testexisteBoucle() {
		assertTrue(parcour.existeBoucle());
	}
	
	
	
	@Test
	void test() {
		int expected =20; 
		assertEquals(expected, tr1.getTempsTrajet() );
	}
	
	@Test
	void testDiffArguments() {
		assertNotEquals(tr1.getDepart(), tr1.getArrivee());

	}
	
	@Test
	void testDiffProposition() {
		assertNotEquals(tr1, tr2);

	}
	
	@Test
	void testVerify() {
		assertTrue(tr1.verif());
	}
	
	@Test
	void testList() {
		assertTrue(tr1.verifListeRues()); // il me donne une erreur corriger la method
	//  assertTrue(tr1.verifListeRuesCorriger());
	}
	
	@Test
	void testestCorrecte() {
		assertTrue(et4.estCorrecte());
	//	assertTrue(et4.estCorrecteCorriger());

	}
}
