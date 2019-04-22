/*
 * GestionPaquet.java                                                22/04/2019
 * Projet de la dame de pique | IUT de Rodez | 2018 - 2019
 */

package damedepique.general;

/**
 * <p>
 *   Cette classe contient toutes les m�thodes qui concernent la manipulation 
 *   d'un paquet de cartes.
 * </p>
 * <ul>
 *   <li>
 *     La m�thode creation() permet de cr�er et d'initialiser un paquet de 
 *     52 cartes pour jouer au jeu de la dame de pique. Chaque symbole est 
 *     associ� � exactement un ordre.
 *   </li>
 *   <li>
 *     La m�thode melange(Carte[]) permet de m�langer un paquet de carte cr�� 
 *     auparavant. Cette m�thode change l'�tat du tableau de cartes pass� 
 *     en param�tre.
 *   </li>
 *   <li>
 *     La m�thode distribution(Carte[], Joueur[]) permet de faire la 
 *     distribution entre les quatre joueurs de la partie. Chaque joueur 
 *     re�oit 13 cartes dans sa main et aucun joueur n'est avantag� lors 
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
	 * Cr�ation d'un paquet de 52 cartes.
	 * @return Le paquet de 52 cartes.
	 */
	public static Carte[] creation() {
		int rang;
		Carte[] paquet;
		
		paquet = new Carte[NB_CARTES];    // Paquet de 52 cartes.
		
		rang = 0;
		/* Attribution d'un symbole et d'un ordre � chaque carte. */
		for (int i = 0 ; i < Carte.SYMBOLES.length ; i++) {
			for (int j = 0 ; j < Carte.ORDRES.length ; j++) {
				paquet[rang] = new Carte(Carte.SYMBOLES[i], Carte.ORDRES[j]);
				rang++;
			}
		}
		
		return paquet;
	}
	
	/**
	 * M�lange un paquet de cartes. 
	 * Attention, cette m�thode change l'�tat du paquet � m�langer.
	 * @param paquet Le paquet � m�langer.
	 * @return Le paquet pass� en param�tre m�lang�.
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
