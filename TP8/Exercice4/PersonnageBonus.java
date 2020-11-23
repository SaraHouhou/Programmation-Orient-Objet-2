package Exercice4;

public class PersonnageBonus extends Personnage{
	private int seuil=10;
	@Todo(
			kind=Todo.TaskKind.WRITE, 
			version="5",
			duration= 4
			)
	public void setNbPoints(int nbPoints) {
		super.setNbPoints(nbPoints);
		if (getNbPoints()>seuil) {
			setNbVies(getNbVies()+1);
			seuil+=10;// nouveau seuil, un seuil ne donne qu'une fois droit à une vie supplémentaire
		}
	}
}
