/*
 * TestOutilSaisie.java                                              18/04/2019
 * Projet de la dame de pique | IUT de Rodez | 2018 - 2019
 */

package damedepique.general.tests;

import damedepique.general.Joueur;
import damedepique.general.OutilSaisie;

/**
 * TODO Faire la description de la classe de test TestOutilSaisie.
 * @author Julien B.
 * @version 1.0
 */
public class TestOutilSaisie {
	
	/**
	 * Test de la m�thode OutilSaisie.changePseudo(Joueur, String)
	 */
	public static void testChangePseudo() {
		Joueur[] joueurs = new Joueur[OutilTest.NB_TESTS];
		
		for (int i = 0 ; i < OutilTest.NB_TESTS ; i++) {
			joueurs[i] = new Joueur();
			System.out.println("Avant : " + joueurs[i]);
			OutilSaisie.changePseudo(joueurs[i], "Entrez un nouveau pseudo [" 
												+ (i + 1) + "/" 
					 							+ OutilTest.NB_TESTS + "] : ");
			
			System.out.println("Apr�s : " + joueurs[i] + "\n");
		}
		
		OutilTest.continuer();
	}
	
	/**
	 * Test de la m�thode OutilSaisie.demandeSymbole(String)
	 */
	public static void testDemandeSymbole() {
		String symbole;
		
		for (int i = 0 ; i < OutilTest.NB_TESTS ; i++) {
			symbole = OutilSaisie.demandeSymbole("Entrez le symbole d'une "
											+ "carte [" + (i + 1) + "/" 
											+ OutilTest.NB_TESTS + "] : ");
			
			System.out.println("Le symbole entr� est : " + symbole + "\n");
		}
		
		OutilTest.continuer();
	}
	
	/**
	 * Test de la m�thode OutilSaisie.demandeOrdre(String)
	 */
	public static void testDemandeOrdre() {
		String ordre;
		
		for (int i = 0 ; i < OutilTest.NB_TESTS ; i++) {
			ordre = OutilSaisie.demandeOrdre("Entrez l'ordre d'une "
										  	+ "carte [" + (i + 1) + "/" 
										  	+ OutilTest.NB_TESTS + "] : ");
			
			System.out.println("L'ordre entr� est : " + ordre + "\n");
		}
		
		OutilTest.continuer();
	}
	
	/**
	 * Test de la m�thode OutilSaisie.symboleEstValide(String)
	 */
	public static void testSymboleEstValide() {
		// TODO A faire
		OutilTest.afficherResultat(0, 0);
		OutilTest.continuer();
	}
	
	/**
	 * Test de la m�thode OutilSaisie.ordreEstValide(String)
	 */
	public static void testOrdreEstValide() {
		// TODO A faire
		OutilTest.afficherResultat(0, 0);
		OutilTest.continuer();
	}
	
	/**
	 * Lancement des m�thodes de test de la classe OutilSaisie.
	 * @param args Non utilis�
	 */
	public static void main(String[] args) {
		
		testChangePseudo();
		// testDemandeSymbole();
		// testDemandeOrdre();
		// testSymboleEstValide();
		// testOrdreEstValide();

	}

}
