package Exercice4;


import java.util.Timer;
import java.util.TimerTask;

/*
 * Ecrivez 3 classes représentant des personnages d’un jeu fictif : une classe abstraite personnage
introduisant entre autres un nom, un nombre de points et un nombre de vies ; une sous-classe personnageInvisible
(les personnages invisibles peuvent se rendre invisible un certain temps, puis ils redeviennent visibles pendant
un temps minimum) introduisant un booléen spécifiant s’ils sont visibles ou pas, le temps pendant lequel
ils peuvent rester invisibles et le temps d’attente avant de pouvoir redevenir invisible ainsi qu’une méthode
permettant de se rendre invisible ; et les personnages bonus (ces personnages gagnent des vies supplémentaires
quand ils franchissent certains seuils de points) qui introduisent tous les combien de points le nombre de vies
est augmenté (avec redéfinition de l’accesseur en écriture sur les points qui met à jour le cas échéant le nombre
de vies). On introduira les accesseurs et les constructeurs paramétrés et par défaut.
 */
public class PersonnageInvisible extends Personnage {

	private boolean isInvisible;
	private static int nbSecInvisible=10;
	Timer timer=new Timer();
	TimerTask current=null;

	public PersonnageInvisible() {
		super();
		this.isInvisible=false;
	}
	public PersonnageInvisible(String nom, int nbPoints, int nbVies, boolean isInvisible) {
		super(nom, nbPoints, nbVies);
		this.isInvisible = isInvisible;
	}
	public boolean isInvisible() {
		return isInvisible;
	}
	@Todo(
			kind=Todo.TaskKind.REFACTOR, 
			version="3",
			duration= 4
			)
	public void makeInvisible() {
		if (!this.isInvisible) {
			this.isInvisible = true;
			timer.schedule(new SetVisibleTimerTask(this), 1000*nbSecInvisible);
			System.out.println(getNom()+ " est invisible !");
		}
	}

	@Todo(
			kind=Todo.TaskKind.ENHANCE, 
			version="2",
			duration= 4
			)
	public void makeVisible() {
		if (this.isInvisible) {
			this.isInvisible = false;
			System.out.println(getNom()+ " n'est plus invisible !");
		}
	}
}
class SetVisibleTimerTask extends TimerTask{
	PersonnageInvisible perso;
	public SetVisibleTimerTask(PersonnageInvisible p) {
		this.perso=p;
	}
	@Override
	public void run() {
		// quand le temps échoit, le personnage redevient visible
		perso.makeVisible();
	}
}