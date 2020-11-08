package ex7;

import java.util.Iterator;

public class IterateurSuiteConstantePairs implements Iterator<Double> {

	private SuiteConstanteRang s;
	private int indiceCourant=0;
	
	public IterateurSuiteConstantePairs(SuiteConstanteRang s)
	{
		this.s=s;
	}
	
	@Override
	public boolean hasNext() {
		return indiceCourant < Integer.MAX_VALUE - 2;
	}

	@Override
	public Double next() {

		Double r = s.valeur(indiceCourant);
		System.out.print("indiceCourant:"+indiceCourant+"-----");
		indiceCourant+=2;

		return r;
	}

	@Override
	public void remove() {
		if (indiceCourant < s.getRang())
			{s.getValeurs().remove(indiceCourant);}
		else System.out.println("retrait sans effet car superieur au rang");
	}


}
