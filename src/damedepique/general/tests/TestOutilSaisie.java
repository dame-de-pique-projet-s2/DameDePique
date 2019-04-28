/*
 * TestOutilSaisie.java                                              26/04/2019
 * Projet de la dame de pique | IUT de Rodez | 2018 - 2019
 */

package damedepique.general.tests;

import damedepique.general.Valeur;
import damedepique.general.OutilSaisie;
import damedepique.general.Couleur;

/**
 * Cette classe contient toutes les méthodes de test de la classe OutilSaisie.
 * @author Julien B.
 * @version 1.0
 */
public class TestOutilSaisie {

	/**
	 * Test de la méthode OutilSaisie.couleurEstValide(String)
	 */
	public static void testCouleurEstValide() {
		System.out.println("OutilSaisie.couleurEstValide(String)\n"
				           + "------------------------------------");
		
		// Jeu d'essai avec des valeurs correctes et incorrectes.
		final String[] JEU_TEST = { "treFLE", "As", null, "36!.-", "Coeur", 
				                    "CarreaUE", "pique", "CARREAU", " ", 
				                    "" + null, "Roi de carreau", "Dame" };
		
		// Valeurs de retour attendues lors de l'exécution de la méthode.
		final boolean[] ATTENDU = { true, false, false, false, true, false, 
				                    true, true, false, false, false, false };
		
		int nbTests = ATTENDU.length;    // Nombre de tests à effectuer.
		
		int nbEchecs = 0;
		for (int i = 0 ; i < nbTests ; i++) {
			if (OutilSaisie.couleurEstValide(JEU_TEST[i]) != ATTENDU[i]) {
				nbEchecs++;
			}
		}
		
		OutilTest.afficherResultat(nbTests, nbTests - nbEchecs);
		
		OutilTest.continuer();
	}
	
	
	/**
	 * Test de la méthode OutilSaisie.valeurEstValide(String)
	 */
	public static void testValeurEstValide() {
		System.out.println("OutilSaisie.valeurEstValide(String)\n"
		                   + "-----------------------------------");
		
		// Jeu d'essai avec des valeurs correctes et incorrectes.
		final String[] JEU_TEST = { "deux ", "As", "ROI", null, " " + null, "", 
				                    "Dame", "VaLeT", "36!.-", "quatres", 
				                    "neuf", "12", "2", "cinq", "UN", "rey" };
		
		// Valeurs de retour attendues lors de l'exécution de la méthode.
		final boolean[] ATTENDU = { false, true, true, false, false, false, 
				                    true, true, false, false, true, false, 
				                    false, true, false, false };
		
		int nbTests = ATTENDU.length;    // Nombre de tests à effectuer.
		
		int nbEchecs = 0;
		for (int i = 0 ; i < nbTests ; i++) {
			if (OutilSaisie.valeurEstValide(JEU_TEST[i]) != ATTENDU[i]) {
				nbEchecs++;
			}
		}
		
		OutilTest.afficherResultat(nbTests, nbTests - nbEchecs);
		
		OutilTest.continuer();
	}
	
	
	/**
	 * Test de la méthode OutilSaisie.saisirCouleur(String)
	 */
	public static void testSaisirCouleur() {
		System.out.println("OutilSaisie.saisirCouleur(String)\n"
                           + "---------------------------------");
		
		Couleur couleur;
		
		for (int i = 0 ; i < OutilTest.NB_TESTS ; i++) {
			couleur = OutilSaisie.saisirCouleur("Entrez une couleur : ");
			System.out.println("    => " + couleur.toString() + "\n");
		}
		
		OutilTest.continuer();
	}
	
	
	/**
	 * Test de la méthode OutilSaisie.saisirValeur(String)
	 */
	public static void testSaisirValeur() {
		System.out.println("OutilSaisie.saisirValeur(String)\n"
                           + "--------------------------------");
		
		Valeur valeur;
		
		for (int i = 0 ; i < OutilTest.NB_TESTS ; i++) {
			valeur = OutilSaisie.saisirValeur("Entrez une valeur : ");
			System.out.println("    => " + valeur.toString() + "\n");
		}
		
		OutilTest.continuer();
	}
	
	
	/**
	 * Lancement des méthodes de test de la classe OutilSaisie.
	 * @param args Non utilisé.
	 */
	public static void main(String[] args) {
		System.out.println("-----------------------------------------\n"
                           + "|     TEST DE LA CLASSE OUTILSAISIE     |\n"
                           + "-----------------------------------------\n");
		
		// testCouleurEstValide();
		// testValeurEstValide();
		// testSaisirCouleur();
		// testSaisirValeur();

	}

}
