/*
 * OutilTest.java                                                    19/04/2019
 * Projet de la dame de pique | IUT de Rodez | 2018 - 2019
 */

package damedepique.general.tests;

import java.util.Scanner;

/**
 * Cette classe contient deux m�thodes qui facilitent la mise en place 
 * des tests unitaires ainsi qu'un analyseur lexical de l'entr�e standard 
 * texte (clavier) pour les eventuelles saisies durant les tests.
 * Les m�thodes sont OutilTest.continuer() et OutilTest.afficherResultat().
 * 
 * @author Julien B.
 * @version 1.0
 */
public class OutilTest {
	
	/** Analyseur lexical de l'entr�e standard texte. */
	private static Scanner sc = new Scanner(System.in);
	
	/** Nombre maximum de tests manuels � faire */
	public static final int NB_TESTS = 3;
	
	/**
	 * Demande � l'utilisateur d'appuyer sur entr�e pour continuer les tests.
	 */
	public static void continuer() {
		System.out.println("\n\n\nAppuyez sur entr�e pour continuer.");
		sc.nextLine();
		System.out.println("\n\n\n");
	}
	
	/**
	 * Affiche le nombre de tests r�ussis et le nombre de tests total.
	 * @param nbTestTotal Le nombre de tests r�alis�s.
	 * @param nbTestCorrect Le nombre de tests r�ussis.
	 */
	public static void afficherResultat(int nbTestTotal, int nbTestCorrect) {
		System.out.println(nbTestCorrect + " test(s) ont r�ussi sur un total "
	                       + "de " + nbTestTotal + " tests r�alis�s.\n    "
				           + "=> " + ((nbTestCorrect == nbTestTotal) 
				        		       ? "Tous les tests sont corrects." 
				        		       : "Au moins un test a �chou�.") + "\n");
	}
	
}
