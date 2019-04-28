/*
 * Carte.java                                                        28/04/2019
 * Projet de la dame de pique | IUT de Rodez | 2018 - 2019
 */

package damedepique.general;

import java.util.Comparator;

/**
 * <p>
 *   Cette classe contient tous les éléments qui caractérisent une carte pour 
 *   jouer au jeu de la dame de pique.
 * </p>
 * <ul>
 *   <li>
 *     
 *   </li>
 *   <li>
 *     
 *   </li>
 * </ul>
 * 
 * @author Julien B.
 * @version 1.0
 */
public class Carte {

	/** Couleur de cette (this) Carte. */
	private Couleur couleur;
	
	
	/** Valeur de cette (this) Carte. */
	private Valeur valeur;
	
	
	/**
	 * Création d'une nouvelle carte comportant une couleur valide 
	 * et une valeur valide.
	 * @param couleur Couleur pour la carte à créer.
	 * @param valeur Valeur pour la carte à créer.
	 */
	public Carte(Couleur couleur, Valeur valeur) {
		this.couleur = couleur;
		this.valeur = valeur;
	}
	
	
	/**
	 * Récupère la couleur de cette (this) Carte.
	 * @return La couleur de la carte.
	 */
	public Couleur getCouleur() {
		return this.couleur;
	}
	
	
	/**
	 * Récupère la valeur de cette (this) Carte.
	 * @return La valeur de la carte.
	 */
	public Valeur getValeur() {
		return this.valeur;
	}
	
	
	@Override
	public String toString() {
		return this.valeur.toString() + " de " 
                                      + this.couleur.toString().toLowerCase();
	}
	
	
	/**
	 * Création d'un comparateur pour trier les cartes dans un ordre croissant 
	 * suivant la position des objets des énumérations Couleur et Valeur.
	 * @see damedepique.general.Couleur
	 * @see damedepique.general.Valeur
	 */
	public static Comparator<Carte> ordreCroissant = new Comparator<>() {
		
		/**
		 * Compare les deux arguments pour les ordonner.
		 * @param carte1 La carte à comparer avec la seconde carte.
		 * @param carte2 La carte à comparer avec la première carte.
		 * @return Renvoie un entier négatif (-1) ou positif (1) si le premier 
		 *         argument est inférieur ou supérieur au second. 
		 *         L'entier renvoyé ne peut pas être nul (0) car toutes 
		 *         les cartes ont une référence unique dans un même paquet.
		 */
		public int compare(Carte carte1, Carte carte2) {
			
			// Récupère la couleur de la première carte passée en paramètre.
			Couleur carte1Couleur = carte1.getCouleur();
			
			// Récupère la couleur de la seconde carte passée en paramètre.
			Couleur carte2Couleur = carte2.getCouleur();
			
			// Récupère la valeur de la première carte passée en paramètre.
			Valeur carte1Valeur = carte1.getValeur();
			
			// Récupère la valeur de la seconde carte passée en paramètre.
			Valeur carte2Valeur = carte2.getValeur();
			
			/*
			 * Compare cet objet (carte1Couleur) avec l'objet spécifié pour la 
			 * commande (carte2Couleur). Retourne un entier négatif, nul ou 
			 * positif si cet objet est inférieur, égal ou supérieur à l'objet 
			 * spécifié. 
			 */
			int couleurDiff = carte1Couleur.compareTo(carte2Couleur);
			
			/*
			 * Compare cet objet (carte1Valeur) avec l'objet spécifié pour la 
			 * commande (carte2Valeur). Retourne un entier négatif, nul ou 
			 * positif si cet objet est inférieur, égal ou supérieur à l'objet 
			 * spécifié.
			 */
			int valeurDiff = carte1Valeur.compareTo(carte2Valeur);
			
			/*
			 * Si la valeur de la couleur trouvée (couleurDiff) est strictement 
			 * supérieure à 0 cela signifie que la couleur de la première carte 
			 * passée en argument est supérieure à celle de la seconde par 
			 * conséquent la valeur retournée est 1 (positive) pour que le 
			 * déplacement soit effectué.
			 * 
			 * Si la valeur de la couleur trouvée (couleurDiff) est strictement 
			 * égale à 0 et qu'en même temps la valeur trouvée (valeurDiff) est 
			 * strictement supérieure à 0 alors cela signifie que les cartes 
			 * passées en arguments sont de même couleur, on a donc 
			 * carte1Couleur.equals(carte2Couleur) mais la valeur 
			 * de la première carte est strictement supérieure à celle de la 
			 * seconde par conséquent la valeur retournée est 1 (positive) 
			 * pour que le déplacement soit effectué.
			 * 
			 * Si aucune condition n'est vérifiée alors la méthode de 
			 * comparaison retourne -1 (négatif) et cela signifie que les 
			 * cartes comparées sont déjà rangées dans l'ordre alors aucun 
			 * déplacement n'est à effectuer.
			 */
			return couleurDiff > 0 
				   || (couleurDiff == 0 && valeurDiff > 0) ? 1 : -1;
			
		}
		
	};
	
}
