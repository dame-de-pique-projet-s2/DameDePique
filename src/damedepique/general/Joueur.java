/*
 * Joueur.java                                                       25/04/2019
 * Projet de la dame de pique | IUT de Rodez | 2018 - 2019
 */

package damedepique.general;

import java.util.ArrayList;

/**
 * <p>
 *   Cette classe contient tous les éléments qui caractérisent un joueur 
 *   jouant au jeu de la dame de pique.
 * </p>
 * <ul>
 *   <li>
 *     
 *   </li>
 *   <li>
 *     
 *   </li>
 * </ul>
 * @author Julien B.
 * @version 1.0
 */
public class Joueur {

	/** Pseudo de ce (this) Joueur. */
	private Pseudo pseudo;
	
	
	/** Nombre de points de ce (this) Joueur. */
	private int points;
	
	
	/** Carte(s) dans la main de ce (this) Joueur. */
	private ArrayList<Carte> main;
	
	
	/**
	 * Création d'un nouveau joueur auquel est associé un pseudonyme généré 
	 * aléatoirement parmi une liste de pseudonymes prédéfinis, un nombre de 
	 * point nul et d'un ensemble de cartes constituant sa main.
	 */
	public Joueur() {
		this.affectationPseudo();    // Affecte un pseudo par défaut.
		this.main = new ArrayList<>();
		this.points = 0;
	}
	
	
	/* * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * *
	 * * * * * * * * * * * * * * PARTIE PSEUDO * * * * * * * * * * * * * * *
	 * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * */
	
	/**
	 * Génère et affecte un pseudonyme aléatoire pour ce (this) Joueur.
	 * Les pseudonymes générés aléatoirement sont prédéfinis. Il n'est pas 
	 * possible pour le joueur de changer son pseudonyme.
	 * @see damedepique.general.Pseudo
	 */
	private void affectationPseudo() {
		// Stocke dans un tableau tous les pseudonymes prédéfinis.
		Pseudo[] pseudos = Pseudo.values();
		
		// Indice généré aléatoirement pour la recherche d'un pseudonyme.
		int indiceAleatoire;
		
		// Génération d'un indice correspondant à un pseudonyme.
		indiceAleatoire = (int) Math.floor(Math.random() * pseudos.length);
		
		// Attribution du pseudonyme par défaut à ce (this) Joueur.
		this.pseudo = pseudos[indiceAleatoire];
	}
	
	
	/* * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * *
	 * * * * * * * * * * * * * * PARTIE POINTS * * * * * * * * * * * * * * *
	 * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * */
	
	/**
	 * Récupère les points de ce (this) Joueur sous la forme d'un entier.
	 * @return Le(s) point(s) du joueur.
	 */
	public int getPoints() {
		return this.points;
	}
	
	
	/* * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * *
	 * * * * * * * * * * * * * * PARTIE MAIN * * * * * * * * * * * * * * * *
	 * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * */
	
	/**
	 * Récupère la main de ce (this) Joueur.
	 * @return La main du joueur.
	 */
	public ArrayList<Carte> getMain() {
		return this.main;
	}
	
	
	/**
	 * Ajoute une carte dans la main de ce (this) Joueur.
	 * @param aAjouter La carte à ajouter.
	 */
	public void ajouterCarte(Carte aAjouter) {
		this.main.add(aAjouter);
	}
	
	
	/**
	 * Retire une carte de la main de ce (this) Joueur.
	 * @param aRetirer La carte à retirer.
	 */
	public void retirerCarte(Carte aRetirer) {
		this.main.remove(aRetirer);
	}
	
	
	/**
	 * Trie les cartes dans la main de ce (this) Joueur.
	 * Cette méthode aide les joueurs dans sa partie pour ne pas perdre de 
	 * temps à jouer une carte.
	 */
	public void trierCartes() {
		
	}
	
	
	@Override
	public String toString() {
		return this.pseudo.toString() + "\n" + this.main.toString();
	}
	
}
