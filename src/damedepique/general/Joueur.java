/*
 * Joueur.java                                                       25/04/2019
 * Projet de la dame de pique | IUT de Rodez | 2018 - 2019
 */

package damedepique.general;

import java.util.ArrayList;

/**
 * <p>
 *   Cette classe contient tous les �l�ments qui caract�risent un joueur 
 *   jouant au jeu de la dame de pique. Un joueur est caract�ris� par un pseudo 
 *   non modifiable qui lui est assign� par d�faut, un nombre de points totaux 
 *   qui �volue au cours de la partie et d'une main dans laquelle le joueur 
 *   poss�de les cartes qu'il peut jouer.
 * </p>
 * 
 * @author Lo�c B. | Julien B. | Margaux B. | Justine R.
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
	 * Cr�ation d'un nouveau joueur auquel est associ� un pseudonyme g�n�r� 
	 * al�atoirement parmi une liste de pseudonymes pr�d�finis, un nombre de 
	 * point nul et d'un ensemble de cartes constituant sa main.
	 */
	public Joueur() {
		this.affectationPseudo();    // Affecte un pseudo par d�faut.
		this.pointsTot = 0;
		this.pointsManche = 0;
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
	 * G�n�re et affecte un pseudonyme al�atoire pour ce (this) Joueur.
	 * Les pseudonymes g�n�r�s al�atoirement sont pr�d�finis. Il n'est pas 
	 * possible pour le joueur de changer son pseudonyme.
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
	
	/**
	 * R�cup�re les points totaux de ce (this) Joueur.
	 * @return Le(s) point(s) totaux du joueur.
	 */
	public int getPointsTot() {
		return this.pointsTot;
	}
	
	
	/**
	 * Ajoute des points aux points totaux � ce (this) Joueur.
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
	 * Met � jour le nombre de points de ce (this) Joueur pendant une manche.
	 * Cette m�thode est utile lors de la d�tection de la cloche de bois.
	 * @param aRemplacer La nouvelle valeur des points de la manche.
	 */
	public void setPointsManche(int aRemplacer) {
		this.pointsManche = aRemplacer;
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
