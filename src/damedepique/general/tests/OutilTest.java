/*
 * OutilTest.java                                                    19/04/2019
 * Projet de la dame de pique | IUT de Rodez | 2018 - 2019
 */

package damedepique.general.tests;

import java.util.Scanner;

/**
 * Cette classe contient deux méthodes qui facilitent la mise en place 
 * des tests unitaires ainsi qu'un analyseur lexical de l'entrée standard 
 * texte (clavier) pour les eventuelles saisies durant les tests.
 * Les méthodes sont OutilTest.continuer() et OutilTest.afficherResultat().
 * 
 * @author Julien B.
 * @version 1.0
 */
public class OutilTest {
	
	/** Analyseur lexical de l'entrée standard texte. */
	private static Scanner sc = new Scanner(System.in);
	
	/** Nombre maximum de tests manuels à faire */
	public static final int NB_TESTS = 3;
	
	/**
	 * Demande à l'utilisateur d'appuyer sur entrée pour continuer les tests.
	 */
	public static void continuer() {
		System.out.println("\n\n\nAppuyez sur entrée pour continuer.");
		sc.nextLine();
		System.out.println("\n\n\n");
	}
	
	/**
	 * Affiche le nombre de tests réussis et le nombre de tests total.
	 * @param nbTestTotal Le nombre de tests réalisés.
	 * @param nbTestCorrect Le nombre de tests réussis.
	 */
	public static void afficherResultat(int nbTestTotal, int nbTestCorrect) {
		System.out.println(nbTestCorrect + " test(s) ont réussi sur un total "
	                       + "de " + nbTestTotal + " tests réalisés.\n    "
				           + "=> " + ((nbTestCorrect == nbTestTotal) 
				        		       ? "Tous les tests sont corrects." 
				        		       : "Au moins un test a échoué.") + "\n");
	}
	
}
