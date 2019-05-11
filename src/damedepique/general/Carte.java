/*
 * Carte.java                                                        11/05/2019
 * Projet de la dame de pique | IUT de Rodez | 2018 - 2019
 */

package damedepique.general;

import java.util.Comparator;

/**
 * <p>
 *   Cette classe contient toutes les caract�ristiques d'une carte de jeu. Une 
 *   carte de jeu est principalement caract�ris�e � l'aide d'un symbole et 
 *   d'une valeur.
 * </p>
 * 
 * @author Julien B.
 * @author Lo�c B.
 * @author Margaux B.
 * @author Justine R.
 * 
 * @version 1.0
 * 
 * @see damedepique.general.Symbole
 * @see damedepique.general.Valeur
 */
public class Carte {

	/** Symbole de cette (this) Carte. */
	private Symbole symbole;
	
	
	/** Valeur de cette (this) Carte. */
	private Valeur valeur;
	
	
	/**
	 * Cr�ation d'une nouvelle carte comportant un symbole valide 
	 * et une valeur valide. Ces symboles et valeurs sont situ�s respectivement 
	 * dans les �num�rations Symbole et Valeur.
	 * @param symbole Symbole pour la carte � cr�er.
	 * @param valeur Valeur pour la carte � cr�er.
	 */
	public Carte(Symbole symbole, Valeur valeur) {
		this.symbole = symbole;
		this.valeur = valeur;
	}
	
	
	/**
	 * R�cup�re le symbole de cette (this) Carte.
	 * @return Le symbole de la carte.
	 */
	public Symbole getSymbole() {
		return this.symbole;    // Retourne une valeur de type Symbole.
	}
	
	
	/**
	 * R�cup�re la valeur de cette (this) Carte.
	 * @return La valeur de la carte.
	 */
	public Valeur getValeur() {
		return this.valeur;    // Retourne une valeur de type Valeur.
	}
	
	
	@Override
	public String toString() {
		return this.valeur.toString() + " de " 
                                      + this.symbole.toString().toLowerCase();
	}
	
	
	/**
	 * Cr�ation d'un comparateur pour trier les cartes dans un ordre croissant 
	 * suivant la position des symboles et des valeurs dans les �num�rations 
	 * Symbole et Valeur.
	 * @see damedepique.general.Symbole
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
			
			// R�cup�re le symbole de la premi�re carte pass�e en param�tre.
			Symbole carte1Symbole = carte1.getSymbole();
			
			// R�cup�re le symbole de la seconde carte pass�e en param�tre.
			Symbole carte2Symbole = carte2.getSymbole();
			
			// R�cup�re la valeur de la premi�re carte pass�e en param�tre.
			Valeur carte1Valeur = carte1.getValeur();
			
			// R�cup�re la valeur de la seconde carte pass�e en param�tre.
			Valeur carte2Valeur = carte2.getValeur();
			
			/*
			 * Compare cet objet (carte1Symbole) avec l'objet sp�cifi� pour la 
			 * commande (carte2Symbole). Retourne un entier n�gatif, nul ou 
			 * positif si cet objet est inf�rieur, �gal ou sup�rieur � l'objet 
			 * sp�cifi�. 
			 */
			int symboleDiff = carte1Symbole.compareTo(carte2Symbole);
			
			/*
			 * Compare cet objet (carte1Valeur) avec l'objet sp�cifi� pour la 
			 * commande (carte2Valeur). Retourne un entier n�gatif, nul ou 
			 * positif si cet objet est inf�rieur, �gal ou sup�rieur � l'objet 
			 * sp�cifi�.
			 */
			int valeurDiff = carte1Valeur.compareTo(carte2Valeur);
			
			/*
			 * Si la valeur du symbole trouv� (symboleDiff) est strictement 
			 * sup�rieure � 0 cela signifie que le symbole de la premi�re carte 
			 * pass�e en argument est sup�rieur � celui de la seconde par 
			 * cons�quent la valeur retourn�e est 1 (positive) pour que le 
			 * d�placement soit effectu�.
			 * 
			 * Si la valeur du symbole trouv� (symboleDiff) est strictement 
			 * �gale � 0 et qu'en m�me temps la valeur trouv�e (valeurDiff) est 
			 * strictement sup�rieure � 0 alors cela signifie que les cartes 
			 * pass�es en arguments sont de m�me symbole, on a donc 
			 * carte1Symbole.equals(carte2Symbole) mais la valeur 
			 * de la premi�re carte est strictement sup�rieure � celle de la 
			 * seconde par cons�quent la valeur retourn�e est 1 (positive) 
			 * pour que le d�placement soit effectu�.
			 * 
			 * Si aucune condition n'est v�rifi�e alors la m�thode de 
			 * comparaison retourne -1 (n�gatif) et cela signifie que les 
			 * cartes compar�es sont d�j� rang�es dans l'ordre alors aucun 
			 * d�placement n'est � effectuer.
			 */
			return symboleDiff > 0 
				   || (symboleDiff == 0 && valeurDiff > 0) ? 1 : -1;
			
		}
		
	};
	
}
