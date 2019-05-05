/*
 * Joueur.java                                                       25/04/2019
 * Projet de la dame de pique | IUT de Rodez | 2018 - 2019
 */

package damedepique.general;

import java.util.ArrayList;

/**
 * <p>
 *   Cette classe contient tous les �l�ments qui caract�risent un joueur 
 *   jouant au jeu de la dame de pique. 
 *   Un joueur est caract�ris� par un pseudo non modifiable qui lui est assign� 
 *   par d�faut, un nombre de points qui �volue au cours de la partie 
 *   et d'une main dans laquelle le joueur poss�de les cartes qu'il peut jouer.
 * </p>
 * 
 * @author Lo�c B. Julien B. Margaux B. Justine R.
 * @version 1.0
 */
public class Joueur {
	
	/** Pseudo de ce (this) Joueur. */
	private Pseudo pseudo;
	
	
	/** Nombre de points de ce (this) Joueur pour la manche en cours */
	private int pointsTour;
	
	
	/** Nombre de points de ce (this) Joueur pour les manches prec�dentes */
	private int pointsTotaux;	
	
	/** Carte(s) dans la main de ce (this) Joueur. */
	private ArrayList<Carte> main;
	
	/** Cartes que le joueur peux jouer a ce tour */
	private ArrayList<Carte> cartesPossibles;
	
	
	/**
	 * Cr�ation d'un nouveau joueur auquel est associ� un pseudonyme g�n�r� 
	 * al�atoirement parmi une liste de pseudonymes pr�d�finis, un nombre de 
	 * point nul et d'un ensemble de cartes constituant sa main.
	 */
	public Joueur() {
		this.affectationPseudo();    // Affecte un pseudo par d�faut.
		this.pointsTour = 0;
		/* TODO : Rajouter les points manches */
		this.main = new ArrayList<>();
	}
	
	
	/* * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * *
	 * * * * * * * * * * * * * * PARTIE PSEUDO * * * * * * * * * * * * * * *
	 * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * */
	
	/**
	 * R�cup�re le pseudonyme de ce (this) Joueur.
	 * @return Le pseudo du joueur.
	 */
	public Pseudo getPseudo() {
		return this.pseudo;
	}
	
	
	/**
	 * G�n�re et affecte un pseudonyme al�atoire � ce (this) Joueur.
	 * Les pseudonymes g�n�r�s al�atoirement sont pr�d�finis. Il n'est pas 
	 * possible pour le joueur de le changer.
	 * @see damedepique.general.Pseudo
	 */
	private void affectationPseudo() {
		
		// Stocke dans un tableau tous les pseudonymes pr�d�finis.
		Pseudo[] pseudos = Pseudo.values();
		
		// Indice g�n�r� al�atoirement pour la recherche d'un pseudonyme.
		int indiceAleatoire;
		
		// G�n�ration d'un indice correspondant � un pseudonyme.
		indiceAleatoire = (int) Math.floor(Math.random() * pseudos.length);
		
		// Attribution du pseudonyme par d�faut � ce (this) Joueur.
		this.pseudo = pseudos[indiceAleatoire];
	}
	
	
	/* * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * *
	 * * * * * * * * * * * * * * PARTIE POINTS * * * * * * * * * * * * * * *
	 * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * */
	
	/*---------------------------------------------------------------------
	 * ||||||||||||||||||| Points de la manche en cours |||||||||||||||||||
	 * --------------------------------------------------------------------
	 */
	/**
	 * R�cup�re les points de ce (this) Joueur sous la forme d'un entier.
	 * 
	 * @return Le(s) point(s) du joueur.
	 */
	public int getPoints() {
		return this.pointsTour;
	}
	
	/**
	 * R�initialise les points de ce joueur a la fin de la manche en cours
	 * pour reutiliser la valeur pour la manche suivante
	 * Avant de les reinitialiser les ajoute au total des manches precedentes
	 */
	public void resetPoints() {
		ajouterPointsManche(this.pointsTour); 
		this.pointsTour = 0;
	}
	
	/**
	 * Ajoute des points du tour � ce (this) Joueur.
	 * 
	 * @param aAjouter Le nombre de points � ajouter.
	 */
	public void ajouterPoints(int aAjouter) {
		this.pointsTour += aAjouter;
	}
	
	/**
	 * TODO : dire ce que la methode fait
	 * @param pourRemplacer valeur a mettre a la place de 
	 *                      la valeur presente dans les points
	 */
	public void modifPoints(int pourRemplacer) {
		this.pointsTour = pourRemplacer;
	}
	
	
	
	/*
	 * --------------------------------------------------------------------
	 *|||||||||||||||||| Total des manches precedentes ||||||||||||||||||||
	 * --------------------------------------------------------------------
	 */
	/**
	 * R�cup�re les points de ce (this) Joueur sous la forme d'un entier.
	 * 
	 * @return Le(s) point(s) du joueur.
	 */
	public int getPointsTotaux() {
		return this.pointsTotaux;
	}
	
	/**
	 * Ajoute des points de la manche � ce (this) Joueur.
	 * 
	 * @param aAjouter Le nombre de points � ajouter.
	 */
	public void ajouterPointsManche(int aAjouter) {
		this.pointsTotaux += aAjouter;
	}
	
	
	
	/* * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * *
	 * * * * * * * * * * * * * * PARTIE MAIN * * * * * * * * * * * * * * * *
	 * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * */
	
	/**
	 * R�cup�re la main de ce (this) Joueur.
	 * @return Les cartes dans la main du joueur.
	 */
	public ArrayList<Carte> getMain() {
		return this.main;
	}
	
	
	/**
	 * Trie les cartes dans la main de ce (this) Joueur.
	 * Cette m�thode aide le joueur dans sa partie pour ne pas perdre de 
	 * temps � jouer une carte. Attention, cette m�thode change l'�tat de la 
	 * main du joueur concern�.
	 */
	public void triMainCroissant() {
		// Tri les cartes dans la main du joueur suivant un ordre croissant.
		this.main.sort(Carte.ordreCroissant);
	}
	
	
	/**
	 * Ajoute une carte dans la main de ce (this) Joueur.
	 * @param aAjouter La carte � ajouter.
	 */
	public void ajouterCarte(Carte aAjouter) {
		this.main.add(aAjouter);
	}
	
	
	/**
	 * Retire une carte de la main de ce (this) Joueur.
	 * @param aRetirer La carte � retirer.
	 */
	public void retirerCarte(Carte aRetirer) {
		this.main.remove(aRetirer);
	}
	
	/*----------------------------------------------------
	 * |||||||||||| Partie cartes Possibles|||||||||||||||
	 * ---------------------------------------------------
	 */
	/**
	 * R�cup�re les cartes possibles de ce (this) Joueur.
	 * @return Les cartes possibles dans la main du joueur.
	 */
	public ArrayList<Carte> getCartesPossibles() {
		return this.cartesPossibles;
	}
	
	/**
	 * Ajoute des cartes dans les cartesPossibles de ce (this) Joueur.
	 * @param aAjouter La carte � ajouter.
	 */
	public void ajouterCartesPossibles(ArrayList<Carte> aRajouter) {
		this.cartesPossibles.addAll(aRajouter);
	}
	
	/**
	 * Supprime la totalit� des cartes possibles de la main du joueur
	 * afin de pouvoir en creer une nouvelle pour le tour suivant 
	 */
	public void resetCartesPossibles() {
		this.cartesPossibles.clear();
	}
	
	
	@Override
	public String toString() {
		String listeCartes = "";
		
		for (Carte carte : this.main) {
			listeCartes += "\n    => " + carte.toString();
		}
		
		return this.pseudo.toString() + " (" + this.pointsTour + " points)" 
		                              + listeCartes;
	}
	
}
