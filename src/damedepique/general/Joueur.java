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
 *   Un joueur est caractérisé par un pseudo non modifiable qui lui est assigné 
 *   par défaut, un nombre de points qui évolue au cours de la partie 
 *   et d'une main dans laquelle le joueur possède les cartes qu'il peut jouer.
 * </p>
 * 
 * @author Loïc B. Julien B. Margaux B. Justine R.
 * @version 1.0
 */
public class Joueur {
	
	/** Pseudo de ce (this) Joueur. */
	private Pseudo pseudo;
	
	
	/** Nombre de points de ce (this) Joueur pour la manche en cours */
	private int pointsTour;
	
	
	/** Nombre de points de ce (this) Joueur pour les manches precédentes */
	private int pointsTotaux;	
	
	/** Carte(s) dans la main de ce (this) Joueur. */
	private ArrayList<Carte> main;
	
	/** Cartes que le joueur peux jouer a ce tour */
	private ArrayList<Carte> cartesPossibles;
	
	
	/**
	 * Création d'un nouveau joueur auquel est associé un pseudonyme généré 
	 * aléatoirement parmi une liste de pseudonymes prédéfinis, un nombre de 
	 * point nul et d'un ensemble de cartes constituant sa main.
	 */
	public Joueur() {
		this.affectationPseudo();    // Affecte un pseudo par défaut.
		this.pointsTour = 0;
		/* TODO : Rajouter les points manches */
		this.main = new ArrayList<>();
	}
	
	
	/* * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * *
	 * * * * * * * * * * * * * * PARTIE PSEUDO * * * * * * * * * * * * * * *
	 * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * */
	
	/**
	 * Récupère le pseudonyme de ce (this) Joueur.
	 * @return Le pseudo du joueur.
	 */
	public Pseudo getPseudo() {
		return this.pseudo;
	}
	
	
	/**
	 * Génère et affecte un pseudonyme aléatoire à ce (this) Joueur.
	 * Les pseudonymes générés aléatoirement sont prédéfinis. Il n'est pas 
	 * possible pour le joueur de le changer.
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
	
	/*---------------------------------------------------------------------
	 * ||||||||||||||||||| Points de la manche en cours |||||||||||||||||||
	 * --------------------------------------------------------------------
	 */
	/**
	 * Récupère les points de ce (this) Joueur sous la forme d'un entier.
	 * 
	 * @return Le(s) point(s) du joueur.
	 */
	public int getPoints() {
		return this.pointsTour;
	}
	
	/**
	 * Réinitialise les points de ce joueur a la fin de la manche en cours
	 * pour reutiliser la valeur pour la manche suivante
	 * Avant de les reinitialiser les ajoute au total des manches precedentes
	 */
	public void resetPoints() {
		ajouterPointsManche(this.pointsTour); 
		this.pointsTour = 0;
	}
	
	/**
	 * Ajoute des points du tour à ce (this) Joueur.
	 * 
	 * @param aAjouter Le nombre de points à ajouter.
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
	 * Récupère les points de ce (this) Joueur sous la forme d'un entier.
	 * 
	 * @return Le(s) point(s) du joueur.
	 */
	public int getPointsTotaux() {
		return this.pointsTotaux;
	}
	
	/**
	 * Ajoute des points de la manche à ce (this) Joueur.
	 * 
	 * @param aAjouter Le nombre de points à ajouter.
	 */
	public void ajouterPointsManche(int aAjouter) {
		this.pointsTotaux += aAjouter;
	}
	
	
	
	/* * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * *
	 * * * * * * * * * * * * * * PARTIE MAIN * * * * * * * * * * * * * * * *
	 * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * */
	
	/**
	 * Récupère la main de ce (this) Joueur.
	 * @return Les cartes dans la main du joueur.
	 */
	public ArrayList<Carte> getMain() {
		return this.main;
	}
	
	
	/**
	 * Trie les cartes dans la main de ce (this) Joueur.
	 * Cette méthode aide le joueur dans sa partie pour ne pas perdre de 
	 * temps à jouer une carte. Attention, cette méthode change l'état de la 
	 * main du joueur concerné.
	 */
	public void triMainCroissant() {
		// Tri les cartes dans la main du joueur suivant un ordre croissant.
		this.main.sort(Carte.ordreCroissant);
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
	
	/*----------------------------------------------------
	 * |||||||||||| Partie cartes Possibles|||||||||||||||
	 * ---------------------------------------------------
	 */
	/**
	 * Récupère les cartes possibles de ce (this) Joueur.
	 * @return Les cartes possibles dans la main du joueur.
	 */
	public ArrayList<Carte> getCartesPossibles() {
		return this.cartesPossibles;
	}
	
	/**
	 * Ajoute des cartes dans les cartesPossibles de ce (this) Joueur.
	 * @param aAjouter La carte à ajouter.
	 */
	public void ajouterCartesPossibles(ArrayList<Carte> aRajouter) {
		this.cartesPossibles.addAll(aRajouter);
	}
	
	/**
	 * Supprime la totalité des cartes possibles de la main du joueur
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
