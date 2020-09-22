package cercleSportif;

import static org.junit.Assert.*;

import org.junit.Test;

public class TestCreneau {
	Heure h1=new Heure(10,15);
	Heure h2=new Heure(21,55);
	Heure h3=new Heure(8,10);
	Heure h4=new Heure(22,0);
	Heure h5=new Heure(12,05);

	Creneau c1=new Creneau(JourSemaine.LUNDI, h1, h2);
	Creneau c2=new Creneau(JourSemaine.LUNDI, h2, h1);
	Creneau c3=new Creneau(JourSemaine.LUNDI, h3, h2);
	Creneau c4=new Creneau(JourSemaine.LUNDI, h5, h2);
	Creneau c5=new Creneau(JourSemaine.LUNDI, h3, h5);
	Creneau c6=new Creneau(JourSemaine.LUNDI, h2, h4);
	Creneau c7=new Creneau(JourSemaine.MARDI, h3, h5);
	Creneau c8=new Creneau(JourSemaine.LUNDI, h1, h5);
	
	
	@Test
	public void testCreationetToString() {
		
		assertEquals("LUNDI 10:15 - 21:55", c1.toString());
		
		assertEquals("LUNDI 10:15 - 21:55", c2.toString());
	}
	@Test
	public void testChevauche(){
	
assertTrue(c1.chevauche(c2));
assertTrue(c1.chevauche(c4));
assertFalse(c5.chevauche(c6));
assertFalse(c6.chevauche(c7));
	}
	
	@Test
	public void testEstInclusDans(){
		assertTrue(c8.estInclusDans(c3));
		assertFalse(c3.estInclusDans(c8));
		assertTrue(c8.estInclusDans(c8));
		assertFalse(c3.estInclusDans(c1));
	}
}
