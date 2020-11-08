package ex3;

import java.util.Comparator;

public class MonComparator implements Comparator<FeuilleSalaire>   {

	@Override
	public int compare(FeuilleSalaire o1, FeuilleSalaire o2) {
		// TODO Auto-generated method stub
		return Double.compare(o1.getNombreHeures(), o2.getNombreHeures());
	}

	public MonComparator() {
		
	}
}
