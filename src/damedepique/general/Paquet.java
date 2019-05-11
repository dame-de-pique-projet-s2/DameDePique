/*
 * Paquet.java                                                       11/05/2019
 * Projet de la dame de pique | IUT de Rodez | 2018 - 2019
 */

package damedepique.general;

import java.util.ArrayList;

/**
 * <p>
 *   Cette classe contient toutes les caractéristiques d'un paquet de cartes.
 * </p>
 * <ul>
 *   <li>
 *     La méthode <i>creer()</i> permet comme son nom l'indique de créer et 
 *     d'initialiser une paquet de 52 cartes pour jouer au jeu de la dame de 
 *     pique. Chaque symbole est associé à exactement une valeur sinon le jeu 
 *     de cartes n'est pas valide (doublons).
 *   </li>
 *   <li>
 *     La méthode <i>melanger()</i> permet de mélanger un paquet de cartes créé 
 *     au préalable. Attention, l'utilisation de cette méthode modifie l'état 
 *     de la liste de cartes.
 *   </li>
 *   <li>
 *     La méthode <i>distribuer()</i> permet de répartir les 52 cartes entre 
 *     les quatre joueurs de la partie. Chaque joueur reçoit 13 cartes dans sa 
 *     main et aucun joueur n'est avantagé lors de cette distribution.
 *   </li>
 * </ul>
 * 
 * @author Julien B.
 * @author Loïc B.
 * @author Margaux B.
 * @author Justine R.
 * 
 * @version 1.0
 * 
 * @see damedepique.general.Carte
 */
public class Paquet {

	/** Nombre de cartes qu'un paquet traditionnel contient. */
	private static final int NB_CARTES_PAQUET = 52;
	
	
	/** Cartes qui composent ce (this) Paquet. */
	private ArrayList<Carte> cartes;
	
	
	/** Création d'un nouveau paquet de cartes. */
	public Paquet() {
		this.cartes = new ArrayList<>(NB_CARTES_PAQUET);
	}
	
	
	/**
	 * Création d'un paquet de 52 cartes, un symbole est associé à exactement 
	 * une valeur sinon le jeu de cartes risque d'être truqué (doublons).
	 * @see damedepique.general.Symbole
	 * @see damedepique.general.Valeur
	 */
	public void creer() {
		// Balayage de la liste des symboles.
		for (Symbole symbole : Symbole.values()) {
			
			// Balayage de la liste des valeurs.
			for (Valeur valeur : Valeur.values()) {
				
				// Association d'un symbole à exactement une valeur.
				this.cartes.add(new Carte(symbole, valeur));
			}
		}
	}
	
	
	/**
	 * Mélange un paquet de cartes de manière aléatoire. Attention, cette 
	 * méthode change l'état du paquet.
	 */
	public void melanger() {
		Carte temp;    // Mémoire temporaire pour la permutation des cartes.
		
		// Taille du paquet à mélanger.
		int taillePaquet = this.cartes.size();
		
		// Indice généré aléatoirement pour la permutation de deux cartes.
		int indiceAleatoire;    
		
		// Balayage de toutes les cartes du paquet.
		for (int i = 0 ; i < taillePaquet ; i++) {
			// Génération d'un indice aléatoire dans le paquet de cartes.
			indiceAleatoire = (int) Math.floor(Math.random() * taillePaquet);
			
			// Permutation de deux cartes dans le paquet.
			temp = this.cartes.get(i);
			this.cartes.set(i, this.cartes.get(indiceAleatoire));
			this.cartes.set(indiceAleatoire, temp);
		}
	}
	
	
	/**
	 * Distribution des cartes entre les quatre joueurs de la partie.
	 * Chaque joueur reçoit 13 cartes de manière aléatoire.
	 * @param joueurs Les joueurs qui reçoivent les cartes.
	 */
	public void distribuer(Joueur[] joueurs) {
		// Taille du paquet à distribuer entre les joueurs.
		int taillePaquet = this.cartes.size();
		
		// Balayage de toutes les cartes du paquet.
		for (int i = 0, rang = 0 ; rang < taillePaquet ; rang++) {
			
			// Ajout des cartes du paquet dans la main du joueur courant.
			joueurs[i].ajouterCarte(this.cartes.get(rang));

			/* 
			 * Vérifie si le nombre de cartes dans la main du joueur courant 
			 * est strictement égal à 13. Si cette condition est vérifiée 
			 * alors la distribution passe au joueur suivant.
			 */
			if (joueurs[i].getMain().size() == 13) { 
				i++;
			}
		}
	}
	
	
	/* * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * *
	 * * * * * * * * * * * * * PARTIE PRESENTATION * * * * * * * * * * * * *
	 * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * */
	// TODO A modifier pour l'affichage.
	@Override
	public String toString() {
		String listeCartes = "";
		
		for (Carte carte : this.cartes) {
			listeCartes += "\n    => " + carte.toString();
		}
		
		return listeCartes;
	}
	
}
