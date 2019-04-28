/*
 * Paquet.java                                                       27/04/2019
 * Projet de la dame de pique | IUT de Rodez | 2018 - 2019
 */

package damedepique.general;

import java.util.ArrayList;

/**
 * <p>
 *   Cette classe contient toutes les m�thodes qui concernent la manipulation
 *   d'un paquet de cartes.
 * </p>
 * <ul>
 *   <li>
 *     La m�thode creer() permet comme son nom l'indique de cr�er et 
 *     d'initialiser une paquet de 52 cartes pour jouer au jeu de la dame de 
 *     pique. Chaque couleur est associ�e � exactement une valeur sinon le jeu 
 *     de cartes n'est pas valide (doublons).
 *   </li>
 *   <li>
 *     La m�thode melanger() permet de m�langer un paquet de cartes cr�� au 
 *     pr�alable. Attention, l'utilisation de cette m�thode modifie l'�tat de 
 *     la liste de cartes.
 *   </li>
 *   <li>
 *     La m�thode distribuer() permet de r�partir les 52 cartes entre les 
 *     quatre joueurs de la partie. Chaque joueur re�oit 13 cartes dans sa main 
 *     et aucun joueur n'est avantag� lors de cette distribution.
 *   </li>
 * </ul>
 * 
 * @author Julien B.
 * @version 1.0
 */
public class Paquet {

	/** Cartes qui composent ce (this) Paquet. */
	private ArrayList<Carte> cartes;
	
	
	/** Cr�ation d'un nouveau paquet de cartes. */
	public Paquet() {
		this.cartes = new ArrayList<>();
	}
	
	
	/**
	 * Cr�ation d'un paquet de 52 cartes, une couleur est associ�e � exactement 
	 * une valeur sinon le jeu de cartes risque d'�tre truqu� (doublons).
	 * @see damedepique.general.Couleur
	 * @see damedepique.general.Valeur
	 */
	public void creer() {
		// Balayage de la liste des couleurs.
		for (Couleur couleur : Couleur.values()) {
			
			// Balayage de la liste des valeurs.
			for (Valeur valeur : Valeur.values()) {
				
				// Association d'une couleur � exactement une valeur.
				this.cartes.add(new Carte(couleur, valeur));
			}
		}
	}
	
	
	/**
	 * M�lange un paquet de cartes de mani�re al�atoire. Attention, cette 
	 * m�thode change l'�tat du paquet.
	 */
	public void melanger() {
		Carte temp;    // M�moire temporaire pour la permutation des cartes.
		
		// Taille du paquet � m�langer.
		int taillePaquet = this.cartes.size();
		
		// Indice g�n�r� al�atoirement pour la permutation de deux cartes.
		int indiceAleatoire;    
		
		// Balayage de toutes les cartes du paquet.
		for (int i = 0 ; i < taillePaquet ; i++) {
			// G�n�ration d'un indice al�atoire dans le paquet de cartes.
			indiceAleatoire = (int) Math.floor(Math.random() * taillePaquet);
			
			// Permutation de deux cartes dans le paquet.
			temp = this.cartes.get(i);
			this.cartes.set(i, this.cartes.get(indiceAleatoire));
			this.cartes.set(indiceAleatoire, temp);
		}
	}
	
	
	/**
	 * Distribution des cartes entre les quatre joueurs de la partie.
	 * Chaque joueur re�oit 13 cartes de mani�re al�atoire.
	 * @param joueurs Les joueurs qui re�oivent les cartes.
	 */
	public void distribuer(Joueur[] joueurs) {
		// Taille du paquet � distribuer entre les joueurs.
		int taillePaquet = this.cartes.size();
		
		// Balayage de toutes les cartes du paquet.
		for (int i = 0, rang = 0 ; rang < taillePaquet ; rang++) {
			
			// Ajout des cartes du paquet dans la main du joueur courant.
			joueurs[i].ajouterCarte(this.cartes.get(rang));

			/* 
			 * V�rifie si le nombre de cartes dans la main du joueur courant 
			 * est strictement �gal � 13. Si cette condition est v�rifi�e 
			 * alors la distribution passe au joueur suivant.
			 */
			if (joueurs[i].getMain().size() == 13) { 
				i++;
			}
		}
	}
	
	
	@Override
	public String toString() {
		String listeCartes = "";
		
		for (Carte carte : this.cartes) {
			listeCartes += "\n    => " + carte.toString();
		}
		
		return listeCartes;
	}
	
}
