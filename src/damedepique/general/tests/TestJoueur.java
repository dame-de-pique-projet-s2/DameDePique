/*
 * TestJoueur.java                                                   25/04/2019
 * Projet de la dame de pique | IUT de Rodez | 2018 - 2019
 */

package damedepique.general.tests;

import damedepique.general.Joueur;

/**
 * Cette classe contient toutes les méthodes de test de la classe Joueur.
 * @author Julien B.
 * @version 1.0
 */
public class TestJoueur {

	/**
	 * Test de la méthode Joueur.affectationPseudo()
	 */
	public static void testAffectationPseudo() {
		Joueur joueur = new Joueur();
		
		System.out.println(joueur);
	}
	
	
	/**
	 * Lancement des méthodes de test de la classe Joueur.
	 * @param args Non utilisé.
	 */
	public static void main(String[] args) {
		
		testAffectationPseudo();

	}
	
}
