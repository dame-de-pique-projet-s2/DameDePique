/*
 * GestionPaquet.java                                                22/04/2019
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
	public static final int NB_CARTES = 52;
	
	/**
	 * Création d'un paquet de 52 cartes.
	 * @return Le paquet de 52 cartes.
	 */
	public static Carte[] creation() {
		int rang;
		Carte[] paquet;
		
		paquet = new Carte[NB_CARTES];    // Paquet de 52 cartes.
		
		rang = 0;
		/* Attribution d'un symbole et d'un ordre à chaque carte. */
		for (int i = 0 ; i < Carte.SYMBOLES.length ; i++) {
			for (int j = 0 ; j < Carte.ORDRES.length ; j++) {
				paquet[rang] = new Carte(Carte.SYMBOLES[i], Carte.ORDRES[j]);
				rang++;
			}
		}
		
		return paquet;
	}
	
	/**
	 * Mélange un paquet de cartes. 
	 * Attention, cette méthode change l'état du paquet à mélanger.
	 * @param paquet Le paquet à mélanger.
	 * @return Le paquet passé en paramètre mélangé.
	 */
	public static Carte[] melange(Carte[] paquet) {
		Carte temp;
		
		for (int i = 1 ; i < paquet.length ; i++) {
			int graine = (int) Math.round(Math.random() * (paquet.length - 1));
			
			temp = paquet[i];
			paquet[i] = paquet[graine];
			paquet[graine] = temp;
		}
		
		return paquet;
	}
	
	/**
	 * 
	 * @param paquet
	 * @param joueurs
	 */
	public static void distribution(Carte[] paquet, Joueur[] joueurs) {
		
	}
	
}
