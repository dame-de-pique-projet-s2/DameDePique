/*
 * Joueur.java                                                       25/04/2019
 * Projet de la dame de pique | IUT de Rodez | 2018 - 2019
 */

package damedepique.general;

import java.util.ArrayList;

/**
 * <p>
 *   Cette classe contient tous les éléments qui caractérisent un joueur 
 *   jouant au jeu de la dame de pique. Un joueur est caractérisé par un pseudo 
 *   non modifiable qui lui est assigné par défaut, un nombre de points totaux 
 *   qui évolue au cours de la partie et d'une main dans laquelle le joueur 
 *   possède les cartes qu'il peut jouer.
 * </p>
 * 
 * @author Loïc B. | Julien B. | Margaux B. | Justine R.
 * @version 1.0
 */
public class Joueur {
	
	/** Pseudo de ce (this) Joueur. */
	private Pseudo pseudo;
	
	
	/** Nombre de points totaux de ce (this) Joueur. */
	private int pointsTot;
	
	
	/** Nombre de points par tour de ce (this) Joueur. */
	private int pointsManche;
	
	
	/** Carte(s) dans la main de ce (this) Joueur. */
	private ArrayList<Carte> main;
	
	
	/**
	 * Création d'un nouveau joueur auquel est associé un pseudonyme généré 
	 * aléatoirement parmi une liste de pseudonymes prédéfinis, un nombre de 
	 * point nul et d'un ensemble de cartes constituant sa main.
	 */
	public Joueur() {
		this.affectationPseudo();    // Affecte un pseudo par défaut.
		this.pointsTot = 0;
		this.pointsManche = 0;
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
	 * Récupère les points totaux de ce (this) Joueur.
	 * @return Le(s) point(s) totaux du joueur.
	 */
	public int getPointsTot() {
		return this.pointsTot;
	}
	
	
	/**
	 * Ajoute des points aux points totaux à ce (this) Joueur.
	 * @param aAjouter Le nombre de points à ajouter.
	 */
	public void ajouterPointsTot(int aAjouter) {
		this.pointsTot += aAjouter;
	}
	
	
	/**
	 * Récupère les points de la manche de ce (this) Joueur.
	 * @return Le(s) point(s) de la manche du joueur.
	 */
	public int getPointsManche() {
		return this.pointsManche;
	}
	
	
	/**
	 * Met à jour le nombre de points de ce (this) Joueur pendant une manche.
	 * Cette méthode est utile lors de la détection de la cloche de bois.
	 * @param aRemplacer La nouvelle valeur des points de la manche.
	 */
	public void setPointsManche(int aRemplacer) {
		this.pointsManche = aRemplacer;
	}
	
	
	/**
	 * Ajoute des points aux points d'une manche à ce (this) Joueur.
	 * @param aAjouter Le nombre de points à ajouter.
	 */
	public void ajouterPointsManche(int aAjouter) {
		this.pointsManche += aAjouter;
	}
	
	
	/**
	 * Vide les points d'une manche de ce (this) Joueur.
	 */
	public void viderPointsManche() {
		this.pointsManche = 0;
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
	public void trierMain() {
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
	
	
	@Override
	public String toString() {
		String listeCartes = "";
		
		for (Carte carte : this.main) {
			listeCartes += "\n    => " + carte.toString();
		}
		
		return this.pseudo.toString() + " (" + this.pointsTot + " points au "
				                      + "total)" + listeCartes;
	}
	
}
