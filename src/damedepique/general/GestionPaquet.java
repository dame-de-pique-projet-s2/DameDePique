/*
 * GestionPaquet.java                                                23/04/2019
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
	private static final int NB_CARTES = 52;
	
	/**
	 * Cr�ation d'un paquet de 52 cartes.
	 * @return Le paquet de 52 cartes.
	 */
	public static Carte[] creation() {
		int rang;          // Rang auquel il faut ins�rer la nouvelle carte.
		Carte[] paquet;    // D�claration du paquet de carte � cr�er.
		
		paquet = new Carte[NB_CARTES];    // Initialisation du paquet.
		
		rang = 0;
		for (int i = 0 ; i < Carte.SYMBOLES.length ; i++) {
			for (int j = 0 ; j < Carte.ORDRES.length ; j++) {
				// Attribution d'un symbole et d'un ordre � chaque carte.
				paquet[rang] = new Carte(Carte.SYMBOLES[i], Carte.ORDRES[j]);
				rang++;
			}
		}
		
		return paquet;
	}
	
	/**
	 * M�lange un paquet de cartes de mani�re al�atoire. 
	 * Attention, cette m�thode change l'�tat du paquet � m�langer.
	 * @param paquet Le paquet � m�langer.
	 * @return Le paquet pass� en param�tre m�lang�.
	 */
	public static Carte[] melange(Carte[] paquet) {
		Carte temp;    // M�moire temporaire pour la permutation de 2 cartes.
		
		for (int i = 0 ; i < paquet.length ; i++) {
			// G�n�ration d'un indice al�atoire dans l'intervalle [0, 52[.
			int indice = (int) Math.floor(Math.random() * paquet.length);
			
			// Permutation de 2 cartes dans le paquet (m�lange).
			temp = paquet[i];
			paquet[i] = paquet[indice];
			paquet[indice] = temp;
		}
		
		return paquet;
	}
	
	/**
	 * Distribue les cartes entre les quatre joueurs (13 cartes par joueur).
	 * @param paquet Le paquet de cartes � distribuer.
	 * @param joueurs Les joueurs qui re�oivent une partie des cartes du jeu.
	 */
	public static void distribution(Carte[] paquet, Joueur[] joueurs) {
		// Parcours du paquet de 52 cartes.
		for (int i = 0, rang = 0 ; rang < NB_CARTES ; rang++) {
			// Ajoute les cartes dans la main du joueur courant.
			joueurs[i].ajouterCarte(paquet[rang]);
			
			/*
			 * V�rifie si le rang a atteint un palier (12, 25 ou 38) pour 
			 * passer � la distribution des cartes pour le joueur suivant.
			 */
			if (rang == (NB_CARTES / 4) * (i + 1) - 1) {
				i++;
			}
		}
	}
	
}
