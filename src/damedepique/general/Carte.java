/*
 * Carte.java                                                        22/04/2019
 * Projet de la dame de pique | IUT de Rodez | 2018 - 2019
 */

package damedepique.general;

/**
 * <p>
 *   Cette classe contient tous les éléments qui caractérisent une carte 
 *   pour jouer au jeu de la dame de pique.
 * </p>
 * <ul>
 *   <li>
 *     Deux constantes SYMBOLES et ORDRES qui contiennent respectivement 
 *     les symboles et les ordres possibles pour une carte de jeu.
 *   </li>
 *   <li>
 *     Deux variables symbole et ordre qui comportent respectivement le symbole 
 *     et l'ordre de la carte à créer.
 *   </li>
 *   <li>
 *     Un constructeur Carte(String, String) permettant de construire une 
 *     carte de jeu en donnant un symbole et un ordre précis.
 *   </li>
 *   <li>
 *     Deux accesseurs (getters) getSymbole() et getOrdre() permettant 
 *     d'accéder aux champs privés de la classe pour éviter les failles 
 *     de sécurité.
 *   </li>
 *   <li>
 *     Une méthode toString() permettant d'afficher de manière compréhensible 
 *     une carte de jeu avec son ordre et son symbole.
 *   </li>
 * </ul>
 *     
 * @author Julien B.
 * @version 1.0
 */
public class Carte {
	
	/** Tableau contenant tous les symboles possibles. */
	public static final String[] SYMBOLES = { "Carreau", "Coeur", 
			                                  "Pique", "Trefle" };
	
	/** Tableau contenant tous les ordres possibles. */
	public static final String[] ORDRES = { "2", "3", "4", "5", "6", 
			                                "7", "8", "9", "10", 
			                                "Valet", "Dame", "Roi", "As" };
	
	/** Symbole de cette (this) Carte. */
	private String symbole;
	
	/** Ordre de cette (this) Carte. */
	private String ordre;
	
	/**
	 * Création d'une nouvelle carte comportant un symbole et un ordre.
	 * @param symbole Symbole pour la carte à créer.
	 * @param ordre Ordre pour la carte à créer.
	 */
	public Carte(String symbole, String ordre) {
		if (OutilSaisie.symboleEstValide(symbole) 
			&& OutilSaisie.ordreEstValide(ordre)) {
			
			this.symbole = symbole;
			this.ordre = ordre;
		}
	}

	/** 
	 * Récupère le symbole de la carte. 
	 * @return Le symbole de la carte.
	 */
	public String getSymbole() {
		return symbole;
	}

	/** 
	 * Récupère l'ordre de la carte. 
	 * @return L'ordre de la carte.
	 */
	public String getOrdre() {
		return ordre;
	}

	@Override
	public String toString() {
		return "[" + ordre + " de " + symbole.toLowerCase() + "]";
	}
	
}
