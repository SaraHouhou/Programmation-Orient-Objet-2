package ex7;

import java.util.Iterator;

public class IterateurSuiteConstanteImpairs implements Iterator<Double> {

	private SuiteConstanteRang s;
	private int indiceCourant=0;
	
	public IterateurSuiteConstanteImpairs(SuiteConstanteRang s)
	{
		this.s=s;
	}
	
	@Override
	public boolean hasNext() {
		return indiceCourant < Integer.MAX_VALUE - 1;
	}

	@Override
	public Double next() {
		
		indiceCourant+=1;
		if(indiceCourant%2==0) {indiceCourant+=1; }	
		Double r = s.valeur(indiceCourant);
		System.out.print("indiceCourant:"+indiceCourant+"------");

		return r;
	}

	@Override
	public void remove() {
		if (indiceCourant < s.getRang())
			{s.getValeurs().remove(indiceCourant);}
		else System.out.println("retrait sans effet car superieur au rang");
	}

}
