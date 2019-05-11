/*
 * Carte.java                                                        11/05/2019
 * Projet de la dame de pique | IUT de Rodez | 2018 - 2019
 */

package damedepique.general;

import java.util.Comparator;

/**
 * <p>
 *   Cette classe contient toutes les caractéristiques d'une carte de jeu. Une 
 *   carte de jeu est principalement caractérisée à l'aide d'un symbole et 
 *   d'une valeur.
 * </p>
 * 
 * @author Julien B.
 * @author Loïc B.
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
	 * Création d'une nouvelle carte comportant un symbole valide 
	 * et une valeur valide. Ces symboles et valeurs sont situés respectivement 
	 * dans les énumérations Symbole et Valeur.
	 * @param symbole Symbole pour la carte à créer.
	 * @param valeur Valeur pour la carte à créer.
	 */
	public Carte(Symbole symbole, Valeur valeur) {
		this.symbole = symbole;
		this.valeur = valeur;
	}
	
	
	/**
	 * Récupère le symbole de cette (this) Carte.
	 * @return Le symbole de la carte.
	 */
	public Symbole getSymbole() {
		return this.symbole;    // Retourne une valeur de type Symbole.
	}
	
	
	/**
	 * Récupère la valeur de cette (this) Carte.
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
	 * Création d'un comparateur pour trier les cartes dans un ordre croissant 
	 * suivant la position des symboles et des valeurs dans les énumérations 
	 * Symbole et Valeur.
	 * @see damedepique.general.Symbole
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
			
			// Récupère le symbole de la première carte passée en paramètre.
			Symbole carte1Symbole = carte1.getSymbole();
			
			// Récupère le symbole de la seconde carte passée en paramètre.
			Symbole carte2Symbole = carte2.getSymbole();
			
			// Récupère la valeur de la première carte passée en paramètre.
			Valeur carte1Valeur = carte1.getValeur();
			
			// Récupère la valeur de la seconde carte passée en paramètre.
			Valeur carte2Valeur = carte2.getValeur();
			
			/*
			 * Compare cet objet (carte1Symbole) avec l'objet spécifié pour la 
			 * commande (carte2Symbole). Retourne un entier négatif, nul ou 
			 * positif si cet objet est inférieur, égal ou supérieur à l'objet 
			 * spécifié. 
			 */
			int symboleDiff = carte1Symbole.compareTo(carte2Symbole);
			
			/*
			 * Compare cet objet (carte1Valeur) avec l'objet spécifié pour la 
			 * commande (carte2Valeur). Retourne un entier négatif, nul ou 
			 * positif si cet objet est inférieur, égal ou supérieur à l'objet 
			 * spécifié.
			 */
			int valeurDiff = carte1Valeur.compareTo(carte2Valeur);
			
			/*
			 * Si la valeur du symbole trouvé (symboleDiff) est strictement 
			 * supérieure à 0 cela signifie que le symbole de la première carte 
			 * passée en argument est supérieur à celui de la seconde par 
			 * conséquent la valeur retournée est 1 (positive) pour que le 
			 * déplacement soit effectué.
			 * 
			 * Si la valeur du symbole trouvé (symboleDiff) est strictement 
			 * égale à 0 et qu'en même temps la valeur trouvée (valeurDiff) est 
			 * strictement supérieure à 0 alors cela signifie que les cartes 
			 * passées en arguments sont de même symbole, on a donc 
			 * carte1Symbole.equals(carte2Symbole) mais la valeur 
			 * de la première carte est strictement supérieure à celle de la 
			 * seconde par conséquent la valeur retournée est 1 (positive) 
			 * pour que le déplacement soit effectué.
			 * 
			 * Si aucune condition n'est vérifiée alors la méthode de 
			 * comparaison retourne -1 (négatif) et cela signifie que les 
			 * cartes comparées sont déjà rangées dans l'ordre alors aucun 
			 * déplacement n'est à effectuer.
			 */
			return symboleDiff > 0 
				   || (symboleDiff == 0 && valeurDiff > 0) ? 1 : -1;
			
		}
		
	};
	
}
