/*
 * TestOutilSaisie.java                                              18/04/2019
 * Projet de la dame de pique | IUT de Rodez | 2018 - 2019
 */

package damedepique.general.tests;

import damedepique.general.Joueur;
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
	public static void testDemandeSymbole() {
		System.out.println("OutilSaisie.demandeSymbole(String)\n"
				           + "----------------------------------\n");
		
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
	public static void testDemandeOrdre() {
		System.out.println("OutilSaisie.demandeOrdre(String)\n"
		                   + "--------------------------------\n");
		
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
	public static void testSymboleEstValide() {
		System.out.println("OutilSaisie.symboleEstValide(String)\n"
		                   + "------------------------------------\n");
		
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
	public static void testOrdreEstValide() {
		System.out.println("OutilSaisie.ordreEstValide(String)\n"
		                   + "----------------------------------\n");
		
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
	public static void testGenerationPseudo() {
		System.out.println("OutilSaisie.generationPseudo(String)\n"
		                   + "------------------------------------\n");
		
		int[] resultats = new int[Joueur.PSEUDOS.length];
		int rang;
		
		for (int i = 0 ; i < 1000 ; i++) {
			resultats[OutilSaisie.generationPseudo()]++;
		}
		
		rang = 0;
		for (String pseudo : Joueur.PSEUDOS) {
			System.out.println(pseudo + " = " + resultats[rang++] / 10 + "%");
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
		
		// testDemandeSymbole();
		// testDemandeOrdre();
		// testSymboleEstValide();
		// testOrdreEstValide();
		// testGenerationPseudo();

	}

}
