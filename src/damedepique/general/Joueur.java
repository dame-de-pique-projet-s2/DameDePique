/*
 * Joueur.java                                                       11/05/2019
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
 *   possède les cartes qu'il peut jouer durant une manche.
 * </p>
 * 
 * @author Julien B.
 * @author Loïc B.
 * @author Margaux B.
 * @author Justine R.
 * 
 * @version 1.0
 */
public abstract class Joueur {
	
	/** Nombre de cartes maximum dans la main d'un joueur. */
	private static final int NB_CARTES_MAIN_MAX = 13;
	
	
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
		this.main = new ArrayList<>(NB_CARTES_MAIN_MAX);
	}
	
	
	/* * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * *
	 * * * * * * * * * * * * * * PARTIE PSEUDO * * * * * * * * * * * * * * *
	 * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * */
	
	/**
	 * Récupère le pseudonyme de ce (this) Joueur.
	 * @return Le pseudonyme du joueur.
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
	 * Ajoute des points aux points totaux de ce (this) Joueur.
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
	 * @return La liste des cartes dans la main du joueur.
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
	
	
	/* * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * *
	 * * * * * * * * * * * * * * PARTIE ACTION * * * * * * * * * * * * * * *
	 * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * */
	
	/**
	 * Joue une carte sans aucune restriction.
	 * @return La carte à jouer par ce (this) Joueur.
	 */
	public abstract Carte jouerCarte();
	
	
	/**
	 * Joue une carte en vérifiant qu'un coeur a été défaussé ou non. Si un 
	 * coeur n'a jamais été défaussé alors le joueur ne peut pas commencer par 
	 * une carte comportant du coeur.
	 * @param coeurDefausse Vrai si une carte possédant le symbole coeur a déjà 
	 *                      été défaussé au cours d'une manche sinon faux.
	 * @return La carte à jouer par ce (this) Joueur.
	 */
	public abstract Carte jouerCarte(boolean coeurDefausse);
	
	
	/**
	 * Joue une carte en vérifiant que le symbole joué corresponde bien au 
	 * symbole demandé au début du tour. Si cette méthode est appelée au 
	 * premier tour d'une manche alors toutes les cartes possédant du coeur 
	 * et la dame de pique ne sont pas jouables.
	 * @param symboleDemande Le symbole demandé au début d'un tour.
	 * @param noTour Le numéro du tour de la manche.
	 * @return La carte à jouer par ce (this) Joueur.
	 */
	public abstract Carte jouerCarte(Symbole symboleDemande, int noTour);
	
	
	/**
	 * Joue le deux de trèfle. Cette méthode n'est utile que pour le premier 
	 * tour d'une manche.
	 * @return Le carte possédant le symbole trèfle et la valeur deux.
	 */
	public abstract Carte jouerDeuxTrefle();
	
	
	/**
	 * Échange trois cartes soumises à aucune restriction.
	 * @return Un tableau contenant les trois cartes à échanger.
	 */
	public abstract Carte[] choisirCartesAEchanger();
	
}
