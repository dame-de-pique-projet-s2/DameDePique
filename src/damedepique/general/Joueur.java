/*
 * Joueur.java                                                       18/04/2019
 * Projet de la dame de pique | IUT de Rodez | 2018 - 2019
 */

package damedepique.general;

import java.util.ArrayList;
import java.util.List;

/**
 * <p>
 *   Cette classe contient tous les éléments qui caractérisent un joueur 
 *   jouant au jeu de la dame de pique.
 * </p>
 * <ul>
 *   <li>
 *     Une constante PSEUDOS qui contient les pseudos prédéfinis à attribuer 
 *     aléatoirement aux joueurs.
 *   </li>
 *   <li>
 *     Trois variables pseudo, points et main qui comportent respectivement
 *     le pseudo du joueur, les points de ce dernier ainsi que sa main avec un 
 *     maximum de 13 cartes simultanément au début d'une manche.
 *   </li>
 *   <li>
 *     Un constructeur Joueur() permettant de créer un nouveau joueur avec 
 *     un pseudo généré aléatoirement (pas de possibilité de le changer) 
 *     et un nombre de point nul.
 *   </li>
 *   <li>
 *     Trois accesseurs (getters) getPseudo(), getPoints() et getMain() 
 *     permettant d'accéder aux champs privés de la classe pour éviter les 
 *     failles de sécurité.
 *   </li>
 *   <li>
 *     Un mutateur (setter) setPoints(int) permettant de modifier l'attribut 
 *     privé dans la classe tout en préservant l'intégrité et la cohérence 
 *     des données.
 *   </li>
 *   <li>
 *     Deux méthodes ajouterCarte(Carte) et retirerCarte(Carte) qui servent à
 *     manipuler la main du joueur, soit à la distribution des cartes ou au 
 *     moment de jouer une carte.
 *   </li>
 *   <li>
 *     Une méthode toString() permettant d'afficher de manière compréhensible 
 *     un joueur avec son pseudonyme et son nombre de point(s).
 *   </li>
 * </ul>
 * 
 * @author Julien B.
 * @version 1.0
 */
public class Joueur {
	
	/** Pseudos prédéfinis pour les joueurs. */
	public final static String[] PSEUDOS = { "Pierre", "Paul", "Jacques",
			                                 "Camille", "Emilie", "Jade", "Ed",
			                                 "Georges", "Thomas", "Aurore" };
	
	/** Pseudo de ce (this) Joueur.*/
	private String pseudo;
	
	/** Nombre de point(s) de ce (this) Joueur. */
	private int points;
	
	/** Carte(s) dans la main de ce (this) Joueur. */
	private List<Carte> main;
	
	/**
	 * Création d'un nouveau joueur avec un pseudo généré aléatoirement
	 * (non modifiable) et un nombre de points nul.
	 */
	public Joueur() {
		this.pseudo = PSEUDOS[OutilSaisie.generationPseudo()];
		this.points = 0;
		this.main = new ArrayList<>();
	}

	/**
	 * Récupère le pseudo du joueur.
	 * @return Le pseudo du joueur.
	 */
	public String getPseudo() {
		return pseudo;
	}

	/**
	 * Récupère les points du joueur.
	 * @return Les points du joueur.
	 */
	public int getPoints() {
		return points;
	}
	
	/**
	 * Récupère la main du joueur.
	 * @return Les cartes dans la main du joueur.
	 */
	public List<Carte> getMain() {
		return main;
	}

	/**
	 * Met à jour le nombre de points du joueur.
	 * @param points Le nouveau nombre de points du joueur.
	 */
	public void setPoints(int points) {
		this.points = points;
	}

	/**
	 * Ajoute une carte dans la main du joueur.
	 * @param carte La carte à ajouter.
	 */
	public void ajouterCarte(Carte carte) {
		main.add(carte);
	}
	
	/**
	 * Retire une carte de la main du joueur.
	 * @param carte La carte à enlever.
	 */
	public void retirerCarte(Carte carte) {
		main.remove(carte);
	}

	@Override
	public String toString() {
		return pseudo + " (" + points + " points)";
	}
	
}
