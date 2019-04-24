/*
 * TestGestionInterface.java                                         23/04/2019
 * Projet de la dame de pique | IUT de Rodez | 2018 - 2019
 */

package damedepique.general.tests;

import damedepique.general.GestionInterface;

/**
 * Cette classe contient toutes les méthodes de test de la 
 * classe GestionInterface.
 * @author Julien B.
 * @version 1.0
 */
public class TestGestionInterface {

	/**
	 * Test de la méthode GestionInterface.afficherMenuPrincipal()
	 * Test visuel.
	 */
	public static void testAfficherMenuPrincipal() {
		GestionInterface.afficherMenuPrincipal();
		
		OutilTest.continuer();
	}
	
	/**
	 * Test de la méthode GestionInterface.optionEstValide(String)
	 * Test automatique.
	 */
	public static void testOptionEstValide() {
		System.out.println("GestionInterface.optionEstValide(String)\n"
                           + "-------------------------------------------\n");
		
		final String[] JEU_TEST = { "q", "", null, ".", "q?", "j", "?", "b", 
				                    "option", "q" + null, "   ", "Q" };
				
		final boolean[] RESULTATS_ATTENDUS = { true, false, false, false, 
				                               false, true, true, false, 
				                               false, false, false, true };
		
		int nbEchecs = 0;
		for (int i = 0 ; i < JEU_TEST.length ; i++) {
			if (GestionInterface.optionEstValide(JEU_TEST[i]) 
				!= RESULTATS_ATTENDUS[i]) {
				
				nbEchecs++;
			}
		}
		
		OutilTest.afficherResultat(JEU_TEST.length, 
                                   JEU_TEST.length - nbEchecs);
		
		OutilTest.continuer();
	}
	
	/**
	 * Test de la méthode GestionInterface.demandeOptionMenuPrincipal(String)
	 * Test visuel.
	 */
	public static void testDemandeOptionMenu() {
		System.out.println("GestionInterface.demandeOptionMenuPrincipal(String)\n"
                           + "---------------------------------------------------\n");
		
		char option;
		
		for (int i = 0 ; i < OutilTest.NB_TESTS ; i++) {
			option = GestionInterface.demandeOptionMenu("Entrez une option [" 
		                        + (i + 1) + "/" + OutilTest.NB_TESTS + "] : ");
					
			System.out.println("L'option entré est : " + option + "\n");
		}
		
		OutilTest.continuer();
	}
	
	/**
	 * Lancement des méthodes de test de la classe GestionInterface.
	 * @param args Non utilisé
	 */
	public static void main(String[] args) {
		
		System.out.println("----------------------------------------------\n"
                           + "|     TEST DE LA CLASSE GESTIONINTERFACE     |\n"
                           + "----------------------------------------------\n");
		
		testAfficherMenuPrincipal();
		testOptionEstValide();
		testDemandeOptionMenu();

	}

}
