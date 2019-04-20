/*
 * Joueur.java                                                       18/04/2019
 * Projet de la dame de pique | IUT de Rodez | 2018 - 2019
 */

package damedepique.general;

/**
 * TODO Faire la description de la classe Joueur.
 * @author Julien B.
 * @version 1.0
 */
public class Joueur {

	/** Pseudo d'un joueur.*/
	private String pseudo;
	
	/** Nombre de point(s) d'un joueur. */
	private int points;
	
	/**
	 * Création d'un joueur associé à un pseudo et un nombre de point nul.
	 * @param pseudo Pseudo du joueur à créer.
	 */
	public Joueur(String pseudo) {
		this.pseudo = pseudo;
		// TODO Remplacer la valeur numérique 0 par une constante.
		this.points = 0;
	}
	
	/**
	 * Création d'un joueur avec un pseudo par défaut.
	 * et un nombre de point nul.
	 */
	public Joueur() {
		// TODO Faire un générateur de pseudo aléatoire.
		// TODO Créer la classe OutilFichier.
		this.pseudo = "Défaut";
		// TODO Remplacer la valeur numérique 0 par une constante.
		this.points = 0;
	}

	/**
	 * Récupère le pseudo d'un joueur.
	 * @return Le pseudo d'un joueur.
	 */
	public String getPseudo() {
		return this.pseudo;
	}

	/**
	 * Récupère les points d'un joueur.
	 * @return Les points d'un joueur.
	 */
	public int getPoints() {
		return this.points;
	}
	
	/**
	 * Redéfini un nouveau pseudo pour un joueur.
	 * @param pseudo Le nouveau pseudo d'un joueur.
	 */
	public void setPseudo(String pseudo) {
		this.pseudo = pseudo;
	}

	/**
	 * Met à jour le nombre de points d'un joueur.
	 * @param points Le nouveau nombre de points.
	 */
	public void setPoints(int points) {
		this.points = points;
	}

	// TODO Mettre en forme le toString()
	@Override
	public String toString() {
		return this.pseudo + " [" + this.points + " points]";
	}
	
}
