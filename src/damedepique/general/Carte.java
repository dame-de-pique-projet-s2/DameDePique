/*
 * Carte.java                                                        22/04/2019
 * Projet de la dame de pique | IUT de Rodez | 2018 - 2019
 */

package damedepique.general;

/**
 * <p>
 *   Cette classe contient tous les �l�ments qui caract�risent une carte 
 *   pour jouer au jeu de la dame de pique.
 * </p>
 * <ul>
 *   <li>
 *     Deux constantes SYMBOLES et ORDRES qui contiennent respectivement 
 *     les symboles et les ordres possibles pour une carte de jeu.
 *   </li>
 *   <li>
 *     Deux variables symbole et ordre qui comportent respectivement le symbole 
 *     et l'ordre de la carte � cr�er.
 *   </li>
 *   <li>
 *     Un constructeur Carte(String, String) permettant de construire une 
 *     carte de jeu en donnant un symbole et un ordre pr�cis.
 *   </li>
 *   <li>
 *     Deux accesseurs (getters) getSymbole() et getOrdre() permettant 
 *     d'acc�der aux champs priv�s de la classe pour �viter les failles 
 *     de s�curit�.
 *   </li>
 *   <li>
 *     Une m�thode toString() permettant d'afficher de mani�re compr�hensible 
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
	 * Cr�ation d'une nouvelle carte comportant un symbole et un ordre.
	 * @param symbole Symbole pour la carte � cr�er.
	 * @param ordre Ordre pour la carte � cr�er.
	 */
	public Carte(String symbole, String ordre) {
		if (OutilSaisie.symboleEstValide(symbole) 
			&& OutilSaisie.ordreEstValide(ordre)) {
			
			this.symbole = symbole;
			this.ordre = ordre;
		}
	}

	/** 
	 * R�cup�re le symbole de la carte. 
	 * @return Le symbole de la carte.
	 */
	public String getSymbole() {
		return symbole;
	}

	/** 
	 * R�cup�re l'ordre de la carte. 
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
