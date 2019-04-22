/*
 * Joueur.java                                                       18/04/2019
 * Projet de la dame de pique | IUT de Rodez | 2018 - 2019
 */

package damedepique.general;

/**
 * <p>
 *   Cette classe contient tous les �l�ments qui caract�risent un joueur 
 *   jouant au jeu de la dame de pique.
 * </p>
 * <ul>
 *   <li>
 *     Trois variables pseudo, points et main qui comportent respectivement
 *     le pseudo du joueur, les points de ce dernier ainsi que sa main avec un 
 *     maximum de 13 cartes simultan�ment au d�but d'une manche.
 *   </li>
 *   <li>
 *     Un constructeur Joueur() permettant de cr�er un nouveau joueur avec 
 *     un pseudo g�n�r� al�atoirement (pas de possibilit� de le changer) 
 *     et un nombre de point nul.
 *   </li>
 *   <li>
 *     Trois accesseurs (getters) getPseudo(), getPoints() et getMain() 
 *     permettant d'acc�der aux champs priv�s de la classe pour �viter les 
 *     failles de s�curit�.
 *   </li>
 *   <li>
 *     Deux mutateurs (setters) setPoints(int) et setMain(Carte[]) permettant
 *     de modifier les attributs priv�s dans la classe tout en pr�servant 
 *     l'int�grit� et la coh�rence des donn�es.
 *   </li>
 *   <li>
 *     Une m�thode toString() permettant d'afficher de mani�re compr�hensible 
 *     un joueur avec son pseudonyme et son nombre de point(s).
 *   </li>
 * </ul>
 * 
 * @author Julien B.
 * @version 1.0
 */
public class Joueur {

	/** Pseudo de ce (this) Joueur.*/
	private String pseudo;
	
	/** Nombre de point(s) de ce (this) Joueur. */
	private int points;
	
	/** Carte(s) dans la main de ce (this) Joueur. */
	private Carte[] main;
	
	/**
	 * Cr�ation d'un nouveau joueur avec un pseudo g�n�r� al�atoirement
	 * (non modifiable) et un nombre de points nul.
	 */
	public Joueur() {
		this.pseudo = OutilSaisie.generationPseudo();
		this.points = 0;
	}

	/**
	 * R�cup�re le pseudo du joueur.
	 * @return Le pseudo du joueur.
	 */
	public String getPseudo() {
		return pseudo;
	}

	/**
	 * R�cup�re les points du joueur.
	 * @return Les points du joueur.
	 */
	public int getPoints() {
		return points;
	}
	
	/**
	 * R�cup�re la main du joueur.
	 * @return Les cartes dans la main du joueur.
	 */
	public Carte[] getMain() {
		return main;
	}

	/**
	 * Met � jour le nombre de points du joueur.
	 * @param points Le nouveau nombre de points du joueur.
	 */
	public void setPoints(int points) {
		this.points = points;
	}

	/**
	 * Met � jour la main du joueur.
	 * @param main Les nouvelles cartes dans la main du joueur.
	 */
	public void setMain(Carte[] main) {
		this.main = main;
	}

	@Override
	public String toString() {
		return pseudo + " (" + points + " points)";
	}
	
}
