/*
 * DameDePique.java                                                  28/04/2019
 * Projet de la dame de pique | IUT de Rodez | 2018 - 2019
 */

package damedepique.general;

/**
 * 
 * @author Julien B.
 * @version 1.0
 */
public class DameDePique {

	/**
	 * 
	 * @param args Non utilis�.
	 */
	public static void main(String[] args) {
		
		// Sc�nario du jeu de la dame de pique.
		
		// Cr�ation d'un paquet de cartes (52 cartes)
		Paquet paquet = new Paquet();
		paquet.creer();
		
		// Cr�ation d'un plateau de jeu o� les joueurs mettent les cartes.
		Plateau plateau = new Plateau();
		
		
		

	}

}
