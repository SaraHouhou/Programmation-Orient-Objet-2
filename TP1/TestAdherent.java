package cercleSportif;

import static org.junit.Assert.*;

import org.junit.Test;

public class TestAdherent {

	@Test
	public void test() {
		Adherent a=new Adherent("toto");
		Adherent a2=new Adherent("titi");
		System.out.println(a);
		a.finAnnee();
		a.finAnnee();
		a.finAnnee();
		a.reAdhesion();
		a.finAnnee();
		a.finAnnee();
		a.finAnnee();
		a.finAnnee();
		a.finAnnee();
		a.finAnnee(); // on remarque que ce n'est pas facile de tester. Il faudrait des mocks.
	}

}
