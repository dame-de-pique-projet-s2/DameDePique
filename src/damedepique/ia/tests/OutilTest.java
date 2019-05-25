/*
 * OutilTest.java                                                    25/04/2019
 * Projet de la dame de pique | IUT de Rodez | 2018 - 2019
 */

package damedepique.ia.tests;

import java.util.Scanner;

/**
 * <p>
 *   Cette classe contient deux m�thodes outils qui facilitent la mise en place 
 *   des tests unitaires ainsi qu'une constante.
 * </p>
 * <ul>
 *   <li>
 *     La constante NB_TESTS contient le nombre de tests � faire lors des tests 
 *     manuels o� l'utilisateur doit saisir des donn�es pour tester les 
 *     fonctionnalit�s de l'algorithme.  
 *   </li>
 *   <li>
 *     La m�thode continuer() permet de marquer un temps d'arr�t entre deux 
 *     algorithmes de test.
 *   </li>
 *   <li>
 *     La m�thode afficherResultat(int, int) permet d'afficher le nombre de 
 *     r�sultat(s) correct(s) par rapport au nombre de tests effectu�s.
 *   </li>
 * </ul>
 * 
 * @author Julien B.
 * @author Lo�c B.
 * @author Margaux B.
 * @author Justine R.
 * 
 * @version 1.0
 */
public class OutilTest {

	/** Analyseur lexical de l'entr�e standard texte. */
	private static Scanner sc = new Scanner(System.in);
	
	
	/** Nombre maximum de tests manuels � r�aliser. */
	public static final int NB_TESTS = 3;
	
	
	/**
	 * Demande � l'utilisateur d'appuyer sur la touche entr�e du clavier pour 
	 * continuer les tests.
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
	                       + "de " + nbTestTotal + " tests r�alis�s.\n    => " 
				           + ((nbTestCorrect == nbTestTotal) 
				               ? "Tous les tests sont corrects." 
				               : "Au moins un test a �chou�.") + "\n");
	}
	
}
