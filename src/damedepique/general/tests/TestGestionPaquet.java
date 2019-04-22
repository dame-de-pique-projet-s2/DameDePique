/*
 * TestGestionPaquet.java                                            22/04/2019
 * Projet de la dame de pique | IUT de Rodez | 2018 - 2019
 */

package damedepique.general.tests;

import damedepique.general.Carte;
import damedepique.general.GestionPaquet;

/**
 * Cette classe contient toutes les méthodes de test de la 
 * classe GestionPaquet.
 * @author Julien B.
 * @version 1.0
 */
public class TestGestionPaquet {

	/**
	 * Test de la méthode GestionPaquet.creation()
	 */
	private static void testCreation() {
		Carte[] paquet;
		paquet = GestionPaquet.creation();
		
		for (int i = 0 ; i < GestionPaquet.NB_CARTES ; i++) {
			System.out.println(paquet[i]);
		}
		
		OutilTest.continuer();
	}
	
	/**
	 * Test de la méthode GestionPaquet.melange(Carte[])
	 */
	private static void testMelange() {
		
		
		OutilTest.continuer();
	}
	
	/**
	 * Test de la méthode GestionPaquet.distribution(Carte[], Joueur[])
	 */
	private static void testDistribution() {
		
		
		OutilTest.continuer();
	}
	
	/**
	 * Lancement des méthodes de test de la classe GestionPaquet.
	 * @param args Non utilisé.
	 */
	public static void main(String[] args) {
		
		testCreation();
		testMelange();
		testDistribution();

	}

}
