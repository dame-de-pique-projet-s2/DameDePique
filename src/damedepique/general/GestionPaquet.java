/*
 * GestionPaquet.java                                                23/04/2019
 * Projet de la dame de pique | IUT de Rodez | 2018 - 2019
 */

package damedepique.general;

/**
 * <p>
 *   Cette classe contient toutes les méthodes qui concernent la manipulation 
 *   d'un paquet de cartes.
 * </p>
 * <ul>
 *   <li>
 *     La méthode creation() permet de créer et d'initialiser un paquet de 
 *     52 cartes pour jouer au jeu de la dame de pique. Chaque symbole est 
 *     associé à exactement un ordre.
 *   </li>
 *   <li>
 *     La méthode melange(Carte[]) permet de mélanger un paquet de carte créé 
 *     auparavant. Cette méthode change l'état du tableau de cartes passé 
 *     en paramètre.
 *   </li>
 *   <li>
 *     La méthode distribution(Carte[], Joueur[]) permet de faire la 
 *     distribution entre les quatre joueurs de la partie. Chaque joueur 
 *     reçoit 13 cartes dans sa main et aucun joueur n'est avantagé lors 
 *     de la distribution.
 *   </li>
 * </ul>
 * 
 * @author Julien B.
 * @version 1.0
 */
public class GestionPaquet {

	/** Nombre de cartes qu'un paquet complet contient. */
	private static final int NB_CARTES = 52;
	
	/**
	 * Création d'un paquet de 52 cartes.
	 * @return Le paquet de 52 cartes.
	 */
	public static Carte[] creation() {
		int rang;          // Rang auquel il faut insérer la nouvelle carte.
		Carte[] paquet;    // Déclaration du paquet de carte à créer.
		
		paquet = new Carte[NB_CARTES];    // Initialisation du paquet.
		
		rang = 0;
		for (int i = 0 ; i < Carte.SYMBOLES.length ; i++) {
			for (int j = 0 ; j < Carte.ORDRES.length ; j++) {
				// Attribution d'un symbole et d'un ordre à chaque carte.
				paquet[rang] = new Carte(Carte.SYMBOLES[i], Carte.ORDRES[j]);
				rang++;
			}
		}
		
		return paquet;
	}
	
	/**
	 * Mélange un paquet de cartes de manière aléatoire. 
	 * Attention, cette méthode change l'état du paquet à mélanger.
	 * @param paquet Le paquet à mélanger.
	 * @return Le paquet passé en paramètre mélangé.
	 */
	public static Carte[] melange(Carte[] paquet) {
		Carte temp;    // Mémoire temporaire pour la permutation de 2 cartes.
		
		for (int i = 0 ; i < paquet.length ; i++) {
			// Génération d'un indice aléatoire dans l'intervalle [0, 52[.
			int indice = (int) Math.floor(Math.random() * paquet.length);
			
			// Permutation de 2 cartes dans le paquet (mélange).
			temp = paquet[i];
			paquet[i] = paquet[indice];
			paquet[indice] = temp;
		}
		
		return paquet;
	}
	
	/**
	 * Distribue les cartes entre les quatre joueurs (13 cartes par joueur).
	 * @param paquet Le paquet de cartes à distribuer.
	 * @param joueurs Les joueurs qui reçoivent une partie des cartes du jeu.
	 */
	public static void distribution(Carte[] paquet, Joueur[] joueurs) {
		// Parcours du paquet de 52 cartes.
		for (int i = 0, rang = 0 ; rang < NB_CARTES ; rang++) {
			// Ajoute les cartes dans la main du joueur courant.
			joueurs[i].ajouterCarte(paquet[rang]);
			
			/*
			 * Vérifie si le rang a atteint un palier (12, 25 ou 38) pour 
			 * passer à la distribution des cartes pour le joueur suivant.
			 */
			if (rang == (NB_CARTES / 4) * (i + 1) - 1) {
				i++;
			}
		}
	}
	
}
