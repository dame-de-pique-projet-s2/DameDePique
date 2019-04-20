/*
 * Carte.java                                                        18/04/2019
 * Projet de la dame de pique | IUT de Rodez | 2018 - 2019
 */

package damedepique.general;

/**
 * TODO Faire la description de la classe Carte.
 * @author Julien B.
 * @version 1.0
 */
public class Carte {
	
	/** Tableau contenant les symboles possibles. */
	public static final String[] SYMBOLES = { "Carreau", "Coeur", 
			                                  "Pique", "Trefle" };
	
	/** Tableau contenant les ordres possibles. */
	public static final String[] ORDRES = { "2", "3", "4", "5", "6", 
			                                "7", "8", "9", "10", 
			                                "Valet", "Dame", "Roi", "As" };
	
	/** Symbole pour une carte. */
	private String symbole;
	
	/** Ordre pour une carte. */
	private String ordre;
	
	/**
	 * Création d'une carte comportant un symbole et un ordre.
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
	 * Récupère le symbole d'une carte. 
	 * @return Le symbole d'une carte.
	 */
	public String getSymbole() {
		return this.symbole;
	}

	/** 
	 * Récupère l'ordre d'une carte. 
	 * @return L'ordre d'une carte.
	 */
	public String getOrdre() {
		return this.ordre;
	}

	// TODO Mettre en forme le toString()
	@Override
	public String toString() {
		return this.ordre + ' ' + this.symbole;
	}
	
}
