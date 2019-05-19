/*
 * Symbole.java                                                      11/05/2019
 * Projet de la dame de pique | IUT de Rodez | 2018 - 2019
 */

package damedepique.general;

/**
 * <p>
 *   Cette énumération regroupe les quatre symboles (ou enseignes) d'un jeu de 
 *   52 cartes français. Parmi les cartes à jouer occidentales, il s'agit du 
 *   système d'enseignes le plus répandu.
 * </p>
 * <p>
 *   Les quatre symboles sont les suivantes : 
 *   le trèfle (♣), le carreau (♦), le pique (♠) et le coeur (♥).
 * </p>
 * 
 * @author Julien B.
 * @author Loïc B.
 * @author Margaux B.
 * @author Justine R.
 * 
 * @version 1.0
 */
public enum Symbole {

	Trefle("trefle"), Carreau("carreau"), Pique("pique"), Coeur("coeur");
	
	
	/** Le symbole d'une carte sous la forme d'une chaîne de caractères. */
	private String symbole;
	
	
	/**
	 * Création d'un nouveau symbole pour la présentation à l'écran.
	 * @param symbole Le symbole sous forme de chaîne de caractères.
	 */
	private Symbole(String symbole) {
		this.symbole = symbole;
	}
	
	
	/**
	 * Retourne le symbole d'une carte sous la forme d'une chaîne de caractères 
	 * pour que les symboles soient plus lisibles pour le joueur humain.
	 * @return Le symbole avec la bonne présentation.
	 */
	public String getSymbole() {
		return this.symbole;
	}
	
}
