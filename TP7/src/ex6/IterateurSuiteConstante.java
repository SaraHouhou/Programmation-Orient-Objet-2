package ex6;

import java.util.Iterator;


public class IterateurSuiteConstante implements Iterator<Double> {

	private SuiteConstanteRang s;
	private int indiceCourant;
	
	public IterateurSuiteConstante(SuiteConstanteRang s)
	{
		this.s=s;
	}
	
	@Override
	public boolean hasNext() {
		return true;
	}

	@Override
	public Double next() {
		Double r = s.valeur(indiceCourant);
		indiceCourant+=1;
		return r;
	}

	@Override
	public void remove() {
		if (indiceCourant < s.getRang())
			{s.getsuitEntier().remove(indiceCourant);}
		else System.out.println("retrait sans effet car superieur au rang");
	}

}

