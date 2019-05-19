/*
 * Valeur.java                                                       11/05/2019
 * Projet de la dame de pique | IUT de Rodez | 2018 - 2019
 */

package damedepique.general;

/**
 * <p>
 *   Cette �num�ration regroupe les treize valeurs d'un jeu de 52 cartes 
 *   fran�ais. Ces treize valeurs peuvent �tre s�par�es en deux sous groupes 
 *   distincts :
 * </p>
 * <ul>
 *   <li>
 *     Les points ou autrement dit les petites cartes qui se composent des 
 *     valeurs 10, 9, 8, 7, 6, 5, 4, 3 et 2.
 *   </li>
 *   <li>
 *     Les honneurs ou autrement dit les habill�s qui se composent 
 *     essentiellement des figures (valet, dame et roi) ainsi que de l'as. 
 *   </li>
 * </ul>
 * 
 * @author Julien B.
 * @author Lo�c B.
 * @author Margaux B.
 * @author Justine R.
 * 
 * @version 1.0
 */
public enum Valeur {
	
	Deux("2"), Trois("3"), Quatre("4"), Cinq("5"), Six("6"), Sept("7"), 
	Huit("8"), Neuf("9"), Dix("10"), Valet("Valet"), Dame("Dame"), 
	Roi("Roi"), As("As");
	
	
	/** La valeur d'une carte sous la forme d'une cha�ne de caract�res. */
	private String valeur;
	
	
	/**
	 * Cr�ation d'une nouvelle valeur pour la pr�sentation � l'�cran.
	 * @param valeur La valeur sous forme de cha�ne de caract�res.
	 */
	private Valeur(String valeur) {
		this.valeur = valeur;
	}
	
	
	/**
	 * Retourne la valeur d'une carte sous la forme d'une cha�ne de caract�res 
	 * pour que les valeurs soient plus lisibles pour le joueur humain.
	 * @return La valeur avec la bonne pr�sentation.
	 */
	public String getValeur() {
		return this.valeur;
	}
}
