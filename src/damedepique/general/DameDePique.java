/*
 * DameDePique.java                                                  28/04/2019
 * Projet de la dame de pique | IUT de Rodez | 2018 - 2019
 */

package damedepique.general;

import damedepique.ia.IA;

/**
 * 
 * @author Julien B.
 * @version 1.0
 */
public class DameDePique {

	/**
	 * 
	 * @param args Non utilisé.
	 */
	public static void main(String[] args) {
		
		Paquet paquet = new Paquet();
		paquet.creer();
		
		// Plateau plateau = new Plateau();
		
		Joueur[] joueurs = new Joueur[4];
		joueurs[0] = new Humain();    // Création d'un joueur humain.
		for (int i = 1 ; i < joueurs.length ; i++) {
			joueurs[i] = new IA();    // Création de trois joueurs IA.
		}
		
		// TODO Faire un import static de OutilPartie. 
		while (!OutilPartie.finPartie(joueurs)) {
			for (int j = 0 ; j < joueurs.length ; j++) {
				if (joueurs[j] instanceof Humain) {
					// Actions pour l'humain.
				} else {
					// Actions pour les IA.
				}
			}
			
			
		}

	}

}
