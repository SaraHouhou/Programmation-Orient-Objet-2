package cercleSportif;

import static org.junit.Assert.*;

import org.junit.Test;

public class TestHeures {

	Heure h1=new Heure(10,15);	
	Heure h2=new Heure(21,55);	
	Heure h3=new Heure(8,10);	
	Heure h4=new Heure(22,0);	
	Heure h5=new Heure(12,05);
	
	
	@Test
	public void testCreationHeureValide() {
		assertEquals("10:15", h1.toString());
		assertEquals("21:55",h2.toString());
		assertEquals("08:10",h3.toString());
		assertEquals("22:00", h4.toString());
		assertEquals("12:05",h5.toString());
	}

	@Test
	public void testCreationHeureInvalide() {
		assertEquals("ERREUR",new Heure(23,05).toString());
		assertEquals("ERREUR",new Heure(6,10).toString());
		assertEquals("ERREUR",new Heure(7,12).toString());
	}
	@Test
	public void testEstAVant(){
		assertFalse(h1.estStrictementAvant(h1));
		assert(h1.estAvant(h2));
		assert(h1.estAvant(h4));
		assert(h1.estAvant(h5));
		assert(h2.estAvant(h4));
		assert(h3.estAvant(new Heure(8,15)));
	}
}
