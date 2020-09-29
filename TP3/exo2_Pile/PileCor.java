package Pileexo2;

public class PileCor {
		private static final int TAILLE_MAX = 2;// taille maximum de la pile 
		private int t[]; // tableau stockant les elements de la pile 
		private int nb; // nombre d'elements dans la pile 
		public PileCor() { 
			t = new int[TAILLE_MAX]; 
			nb = 0; 
		} 
		public boolean estVide() {
			return nb == 0;
		} 
		public void empiler(int i) throws PilePleineException {
			if (nb == TAILLE_MAX) throw new PilePleineException(); 
			t[nb] = i; 
			nb++; 
			System.out.println("sortie de empiler"); 
		} 
		public int sommet() throws PileVideException { 
			if (nb == 0) throw new PileVideException(); 
			System.out.println("sortie de sommet"); 
			return t[nb-1]; 
		} 
		public void depiler() throws PileVideException { 
			if (nb == 0) throw new PileVideException(); 
			nb--; 
			System.out.println("sortie de dépiler"); 
		} 
		public void depilerTout() throws PileVideException { 
			if(estVide()) throw new PileVideException();		
			while(!estVide()) { 
				System.out.println(sommet()); 
				depiler(); 
			}
	        System.out.println("sortie du dépilerTout"); 
		} 
		
		
		public static void main(String[] args) { 
			Pile p = new Pile(); 
			try { 
				p.empiler(2); 
				p.empiler(4); 
				p.depilerTout(); 
				System.out.println(p.sommet()); 
			} 
			catch (PileVideException e) {
				System.out.println("Le main pense que la pile est vide");
			} 
			catch (PilePleineException e) {
				System.out.println("Le main pense que la pile est pleine");
			} 
			catch (Exception e) {
				System.out.println("Le main est passé parlé");
			} 
			System.out.println("sortie du main"); 
		} 
	} 
