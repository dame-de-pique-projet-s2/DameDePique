/*
 * OutilTest.java                                                    25/04/2019
 * Projet de la dame de pique | IUT de Rodez | 2018 - 2019
 */

package damedepique.ia.tests;

import java.util.Scanner;

/**
 * <p>
 *   Cette classe contient deux méthodes outils qui facilitent la mise en place 
 *   des tests unitaires ainsi qu'une constante.
 * </p>
 * <ul>
 *   <li>
 *     La constante NB_TESTS contient le nombre de tests à faire lors des tests 
 *     manuels où l'utilisateur doit saisir des données pour tester les 
 *     fonctionnalités de l'algorithme.  
 *   </li>
 *   <li>
 *     La méthode continuer() permet de marquer un temps d'arrêt entre deux 
 *     algorithmes de test.
 *   </li>
 *   <li>
 *     La méthode afficherResultat(int, int) permet d'afficher le nombre de 
 *     résultat(s) correct(s) par rapport au nombre de tests effectués.
 *   </li>
 * </ul>
 * 
 * @author Julien B.
 * @author Loïc B.
 * @author Margaux B.
 * @author Justine R.
 * 
 * @version 1.0
 */
public class OutilTest {

	/** Analyseur lexical de l'entrée standard texte. */
	private static Scanner sc = new Scanner(System.in);
	
	
	/** Nombre maximum de tests manuels à réaliser. */
	public static final int NB_TESTS = 3;
	
	
	/**
	 * Demande à l'utilisateur d'appuyer sur la touche entrée du clavier pour 
	 * continuer les tests.
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
	                       + "de " + nbTestTotal + " tests réalisés.\n    => " 
				           + ((nbTestCorrect == nbTestTotal) 
				               ? "Tous les tests sont corrects." 
				               : "Au moins un test a échoué.") + "\n");
	}
	
}
