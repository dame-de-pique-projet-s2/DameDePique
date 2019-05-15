/*
 * Joueur.java                                                       11/05/2019
 * Projet de la dame de pique | IUT de Rodez | 2018 - 2019
 */

package damedepique.general;

import java.util.ArrayList;

/**
 * <p>
 *   Cette classe contient tous les �l�ments qui caract�risent un joueur 
 *   jouant au jeu de la dame de pique. Un joueur est caract�ris� par un pseudo 
 *   modifiable, un nombre de points totaux qui �volue au cours de la partie et 
 *   d'une main dans laquelle le joueur poss�de les cartes qu'il peut jouer 
 *   durant une manche.
 * </p>
 * 
 * @author Julien B.
 * @author Lo�c B.
 * @author Margaux B.
 * @author Justine R.
 * 
 * @version 1.0
 */
public abstract class Joueur {
	
	/** Nombre de cartes maximum dans la main d'un joueur. */
	private static final int NB_CARTES_MAIN_MAX = 13;
	
	
	/** Pseudo de ce (this) Joueur. */
	private String pseudo;
	
	
	/** Nombre de points totaux de ce (this) Joueur. */
	private int pointsTot;
	
	
	/** Nombre de points par tour de ce (this) Joueur. */
	private int pointsManche;
	
	
	/** Carte(s) dans la main de ce (this) Joueur. */
	private ArrayList<Carte> main;
	
	
	/**
	 * Cr�ation d'un nouveau joueur auquel est associ� un pseudonyme sp�cifi� 
	 * en argument, un nombre de point nul (points totaux et points de manche) 
	 * et d'un ensemble de cartes constituant sa main.
	 * @param pseudo Le pseudo de ce (this) Joueur.
	 */
	public Joueur(String pseudo) {
		this.pseudo = pseudo;
		this.pointsTot = 0;
		this.pointsManche = 0;
		this.main = new ArrayList<>(NB_CARTES_MAIN_MAX);
	}
	
	
	/* * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * *
	 * * * * * * * * * * * * * * PARTIE PSEUDO * * * * * * * * * * * * * * *
	 * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * */
	
	/**
	 * R�cup�re le pseudonyme de ce (this) Joueur.
	 * @return Le pseudonyme du joueur.
	 */
	public String getPseudo() {
		return this.pseudo;
	}
	
	
	/**
	 * Met � jour le pseudonyme de ce (this) Joueur.
	 * @param pseudo Le nouveau pseudonyme du joueur.
	 */
	public void setPseudo(String pseudo) {
		this.pseudo = pseudo;
	}
	
	
	/* * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * *
	 * * * * * * * * * * * * * * PARTIE POINTS * * * * * * * * * * * * * * *
	 * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * */
	
	/**
	 * R�cup�re les points totaux de ce (this) Joueur.
	 * @return Le(s) point(s) totaux du joueur.
	 */
	public int getPointsTot() {
		return this.pointsTot;
	}
	
	
	/**
	 * Ajoute des points aux points totaux de ce (this) Joueur.
	 * @param aAjouter Le nombre de points � ajouter.
	 */
	public void ajouterPointsTot(int aAjouter) {
		this.pointsTot += aAjouter;
	}
	
	
	/**
	 * R�cup�re les points de la manche de ce (this) Joueur.
	 * @return Le(s) point(s) de la manche du joueur.
	 */
	public int getPointsManche() {
		return this.pointsManche;
	}
	
	
	/**
	 * Ajoute des points aux points d'une manche � ce (this) Joueur.
	 * @param aAjouter Le nombre de points � ajouter.
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
	 * R�cup�re la main de ce (this) Joueur.
	 * @return La liste des cartes dans la main du joueur.
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
	public void trierMain() {
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
	
	
	/* * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * *
	 * * * * * * * * * * * * * * PARTIE ACTION * * * * * * * * * * * * * * *
	 * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * */
	
	/**
	 * Joue une carte sans aucune restriction.
	 * @return La carte � jouer par ce (this) Joueur.
	 */
	public abstract Carte jouerCarte();
	
	
	/**
	 * Joue une carte en v�rifiant qu'un coeur a �t� d�fauss� ou non. Si un 
	 * coeur n'a jamais �t� d�fauss� alors le joueur ne peut pas commencer par 
	 * une carte comportant du coeur.
	 * @param coeurDefausse Vrai si une carte poss�dant le symbole coeur a d�j� 
	 *                      �t� d�fauss� au cours d'une manche sinon faux.
	 * @return La carte � jouer par ce (this) Joueur.
	 */
	public abstract Carte jouerCarte(boolean coeurDefausse);
	
	
	/**
	 * Joue une carte en v�rifiant que le symbole jou� corresponde bien au 
	 * symbole demand� au d�but du tour. Si cette m�thode est appel�e au 
	 * premier tour d'une manche alors toutes les cartes poss�dant du coeur 
	 * et la dame de pique ne sont pas jouables.
	 * @param symboleDemande Le symbole demand� au d�but d'un tour.
	 * @param noTour Le num�ro du tour de la manche.
	 * @return La carte � jouer par ce (this) Joueur.
	 */
	public abstract Carte jouerCarte(Symbole symboleDemande, int noTour);
	
	
	/**
	 * Joue le deux de tr�fle. Cette m�thode n'est utile que pour le premier 
	 * tour d'une manche.
	 * @return Le carte poss�dant le symbole tr�fle et la valeur deux.
	 */
	public abstract Carte jouerDeuxTrefle();
	
	
	/**
	 * �change trois cartes soumises � aucune restriction.
	 * @return Un tableau contenant les trois cartes � �changer.
	 */
	public abstract Carte[] choisirCartesAEchanger();
	
}
