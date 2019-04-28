/*
 * Carte.java                                                        28/04/2019
 * Projet de la dame de pique | IUT de Rodez | 2018 - 2019
 */

package damedepique.general;

import java.util.Comparator;

/**
 * <p>
 *   Cette classe contient tous les �l�ments qui caract�risent une carte pour 
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
	 * Cr�ation d'une nouvelle carte comportant une couleur valide 
	 * et une valeur valide.
	 * @param couleur Couleur pour la carte � cr�er.
	 * @param valeur Valeur pour la carte � cr�er.
	 */
	public Carte(Couleur couleur, Valeur valeur) {
		this.couleur = couleur;
		this.valeur = valeur;
	}
	
	
	/**
	 * R�cup�re la couleur de cette (this) Carte.
	 * @return La couleur de la carte.
	 */
	public Couleur getCouleur() {
		return this.couleur;
	}
	
	
	/**
	 * R�cup�re la valeur de cette (this) Carte.
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
	 * Cr�ation d'un comparateur pour trier les cartes dans un ordre croissant 
	 * suivant la position des objets des �num�rations Couleur et Valeur.
	 * @see damedepique.general.Couleur
	 * @see damedepique.general.Valeur
	 */
	public static Comparator<Carte> ordreCroissant = new Comparator<>() {
		
		/**
		 * Compare les deux arguments pour les ordonner.
		 * @param carte1 La carte � comparer avec la seconde carte.
		 * @param carte2 La carte � comparer avec la premi�re carte.
		 * @return Renvoie un entier n�gatif (-1) ou positif (1) si le premier 
		 *         argument est inf�rieur ou sup�rieur au second. 
		 *         L'entier renvoy� ne peut pas �tre nul (0) car toutes 
		 *         les cartes ont une r�f�rence unique dans un m�me paquet.
		 */
		public int compare(Carte carte1, Carte carte2) {
			
			// R�cup�re la couleur de la premi�re carte pass�e en param�tre.
			Couleur carte1Couleur = carte1.getCouleur();
			
			// R�cup�re la couleur de la seconde carte pass�e en param�tre.
			Couleur carte2Couleur = carte2.getCouleur();
			
			// R�cup�re la valeur de la premi�re carte pass�e en param�tre.
			Valeur carte1Valeur = carte1.getValeur();
			
			// R�cup�re la valeur de la seconde carte pass�e en param�tre.
			Valeur carte2Valeur = carte2.getValeur();
			
			/*
			 * Compare cet objet (carte1Couleur) avec l'objet sp�cifi� pour la 
			 * commande (carte2Couleur). Retourne un entier n�gatif, nul ou 
			 * positif si cet objet est inf�rieur, �gal ou sup�rieur � l'objet 
			 * sp�cifi�. 
			 */
			int couleurDiff = carte1Couleur.compareTo(carte2Couleur);
			
			/*
			 * Compare cet objet (carte1Valeur) avec l'objet sp�cifi� pour la 
			 * commande (carte2Valeur). Retourne un entier n�gatif, nul ou 
			 * positif si cet objet est inf�rieur, �gal ou sup�rieur � l'objet 
			 * sp�cifi�.
			 */
			int valeurDiff = carte1Valeur.compareTo(carte2Valeur);
			
			/*
			 * Si la valeur de la couleur trouv�e (couleurDiff) est strictement 
			 * sup�rieure � 0 cela signifie que la couleur de la premi�re carte 
			 * pass�e en argument est sup�rieure � celle de la seconde par 
			 * cons�quent la valeur retourn�e est 1 (positive) pour que le 
			 * d�placement soit effectu�.
			 * 
			 * Si la valeur de la couleur trouv�e (couleurDiff) est strictement 
			 * �gale � 0 et qu'en m�me temps la valeur trouv�e (valeurDiff) est 
			 * strictement sup�rieure � 0 alors cela signifie que les cartes 
			 * pass�es en arguments sont de m�me couleur, on a donc 
			 * carte1Couleur.equals(carte2Couleur) mais la valeur 
			 * de la premi�re carte est strictement sup�rieure � celle de la 
			 * seconde par cons�quent la valeur retourn�e est 1 (positive) 
			 * pour que le d�placement soit effectu�.
			 * 
			 * Si aucune condition n'est v�rifi�e alors la m�thode de 
			 * comparaison retourne -1 (n�gatif) et cela signifie que les 
			 * cartes compar�es sont d�j� rang�es dans l'ordre alors aucun 
			 * d�placement n'est � effectuer.
			 */
			return couleurDiff > 0 
				   || (couleurDiff == 0 && valeurDiff > 0) ? 1 : -1;
			
		}
		
	};
	
}
