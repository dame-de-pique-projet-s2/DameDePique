/*
 * TestOutilSaisie.java                                              18/04/2019
 * Projet de la dame de pique | IUT de Rodez | 2018 - 2019
 */

package damedepique.general.tests;

import damedepique.general.OutilSaisie;

/**
 * Cette classe contient toutes les méthodes de test de la 
 * classe utilitaire OutilSaisie.
 * @author Julien B.
 * @version 1.0
 */
public class TestOutilSaisie {
	
	/**
	 * Test de la méthode OutilSaisie.demandeSymbole(String)
	 */
	private static void testDemandeSymbole() {
		String symbole;
		
		for (int i = 0 ; i < OutilTest.NB_TESTS ; i++) {
			symbole = OutilSaisie.demandeSymbole("Entrez le symbole d'une "
                                            + "carte [" + (i + 1) + "/" 
                                            + OutilTest.NB_TESTS + "] : ");
			
			System.out.println("Le symbole entré est : " + symbole + "\n");
		}
		
		OutilTest.continuer();
	}
	
	/**
	 * Test de la méthode OutilSaisie.demandeOrdre(String)
	 */
	private static void testDemandeOrdre() {
		String ordre;
		
		for (int i = 0 ; i < OutilTest.NB_TESTS ; i++) {
			ordre = OutilSaisie.demandeOrdre("Entrez l'ordre d'une " 
                                             + "carte [" + (i + 1) + "/" 
                                             + OutilTest.NB_TESTS + "] : ");
			
			System.out.println("L'ordre entré est : " + ordre + "\n");
		}
		
		OutilTest.continuer();
	}
	
	/**
	 * Test de la méthode OutilSaisie.symboleEstValide(String)
	 */
	private static void testSymboleEstValide() {
		final String[] JEU_TEST = { "TreflE", "As", null, "36.:--!", "Coeur",
                                    "carreauE", "pique", "CARREAU", "*1", "" };
		
		final boolean[] RESULTATS_ATTENDUS = { true, false, false, false, 
                                               true, false, true, true, 
                                               false, false };
		
		int nbEchecs = 0;
		for (int i = 0 ; i < JEU_TEST.length ; i++) {
			if (OutilSaisie.symboleEstValide(JEU_TEST[i]) 
                != RESULTATS_ATTENDUS[i]) {
				
				nbEchecs++;
			}
		}
		
		OutilTest.afficherResultat(JEU_TEST.length, 
                                   JEU_TEST.length - nbEchecs);
		
		OutilTest.continuer();
	}
	
	/**
	 * Test de la méthode OutilSaisie.ordreEstValide(String)
	 */
	private static void testOrdreEstValide() {
		final String[] JEU_TEST = { "2  ", "As", "ROI", null, " ", "", "Dame",
                                    "VaLeT", ".-**/'", "10", "9", "12", "2", 
                                    "5", "roi" };
		
		final boolean[] RESULTATS_ATTENDUS = { false, true, true, false, false, 
                                               false, true, true, false, true, 
                                               true, false, true, true, true };
		
		int nbEchecs = 0;
		for (int i = 0 ; i < JEU_TEST.length ; i++) {
			if (OutilSaisie.ordreEstValide(JEU_TEST[i])
                != RESULTATS_ATTENDUS[i]) {
				
				nbEchecs++;
			}
		}
		
		OutilTest.afficherResultat(JEU_TEST.length, 
                                   JEU_TEST.length - nbEchecs);
		
		OutilTest.continuer();
	}
	
	/**
	 * Test de la méthode OutilSaisie.generationPseudo()
	 */
	private static void testGenerationPseudo() {
		// TODO Faire la méthode de test.
	}
	
	/**
	 * Lancement des méthodes de test de la classe OutilSaisie.
	 * @param args Non utilisé.
	 */
	public static void main(String[] args) {
		
		testDemandeSymbole();
		testDemandeOrdre();
		testSymboleEstValide();
		testOrdreEstValide();
		testGenerationPseudo();

	}

}
