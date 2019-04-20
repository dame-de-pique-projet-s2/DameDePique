/*
 * Paquet.java                                                       19/04/2019
 * Projet de la dame de pique | IUT de Rodez | 2018 - 2019
 */

package damedepique.general;

/**
 * TODO Faire la description de la classe Paquet.
 * @author Julien B.
 * @version 1.0
 */
public class Paquet {

	/** Nombre de cartes qu'un paquet complet contient. */
	private static final int NB_CARTES = 52;
	
	/**
	 * Création d'un paquet de 52 cartes.
	 */
	public Paquet() {
		int rang;    // Rang de la carte à insérer dans le paquet.
		Carte[] cartes = new Carte[NB_CARTES];    // Paquet de 52 cartes.
		
		rang = 0;
		for (int i = 0 ; i < Carte.SYMBOLES.length ; i++) {
			for (int j = 0 ; j < Carte.ORDRES.length ; j++) {
				cartes[rang] = new Carte(Carte.SYMBOLES[i], Carte.ORDRES[j]);
				rang++;
			}
		}
	}
	
}
