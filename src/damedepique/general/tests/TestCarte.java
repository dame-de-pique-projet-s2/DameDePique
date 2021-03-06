/*
 * TestCarte.java                                                    24/05/2019
 * Projet de la dame de pique | IUT de Rodez | 2018 - 2019
 */

package damedepique.general.tests;

import damedepique.general.Carte;
import damedepique.general.Valeur;
import damedepique.general.Symbole;

/**
 * <p>
 *   Cette classe contient toutes les m�thodes de test de la classe Carte.
 * </p>
 * 
 * @author Julien B.
 * @author Lo�c B.
 * @author Margaux B.
 * @author Justine R.
 * 
 * @version 1.0
 */
public class TestCarte {
	
	/**
	 * Test de la m�thode (getter) Carte.getSymbole()
	 */
	public static void testGetSymbole() {
		System.out.println("Carte.getSymbole()\n"
                           + "------------------");
		
		// Instantiation d'une nouvelle carte de jeu.
		Carte carte = new Carte(Symbole.Coeur, Valeur.Roi);
		
		// Affichage de la carte de jeu pr�c�demment cr��e.
		System.out.println(carte);
		
		// Affichage du symbole de la carte cr��e auparavant.
		System.out.println("Symbole = " + carte.getSymbole());
		
		OutilTest.continuer();
	}
	
	
	/**
	 * Test de la m�thode (getter) Carte.getValeur()
	 */
	public static void testGetValeur() {
		System.out.println("Carte.getValeur()\n"
                           + "-----------------");
		
		// Instantiation d'une nouvelle carte de jeu.
		Carte carte = new Carte(Symbole.Pique, Valeur.Dame);
		
		// Affichage de la carte de jeu pr�c�demment cr��e.
		System.out.println(carte);
		
		// Affichage de la valeur de la carte cr��e auparavant.
		System.out.println("Valeur = " + carte.getValeur());
		
		OutilTest.continuer();
	}
	
	
	/**
	 * Lancement des m�thodes de test de la classe Carte.
	 * @param args Non utilis�.
	 */
	public static void main(String[] args) {
		System.out.println("-----------------------------------\n"
                           + "|     TEST DE LA CLASSE CARTE     |\n"
                           + "-----------------------------------\n");
		
		testGetSymbole();
		testGetValeur();

	}

}
