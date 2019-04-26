/*
 * TestCarte.java                                                    25/04/2019
 * Projet de la dame de pique | IUT de Rodez | 2018 - 2019
 */

package damedepique.general.tests;

import damedepique.general.Carte;
import damedepique.general.Ordre;
import damedepique.general.Symbole;

/**
 * TODO Faire la description de la classe de test TestCarte.
 * @author Julien B.
 * @version 1.0
 */
public class TestCarte {
	
	/**
	 * Test de la m�thode (getter) Carte.getSymbole()
	 */
	public static void testGetSymbole() {
		// Instantiation d'une nouvelle carte de jeu.
		Carte carte = new Carte(Symbole.Coeur, Ordre.Roi);
		
		// Affichage du symbole de la carte cr��e auparavant.
		System.out.println("Symbole = " + carte.getSymbole());
	}
	
	
	/**
	 * Test de la m�thode (getter) Carte.getOrdre()
	 */
	public static void testGetOrdre() {
		// Instantiation d'une nouvelle carte de jeu.
		Carte carte = new Carte(Symbole.Pique, Ordre.Dame);
		
		// Affichage de l'ordre de la carte cr��e auparavant.
		System.out.println("Ordre = " + carte.getOrdre());
	}
	
	
	/**
	 * Lancement des m�thodes de test de la classe Carte.
	 * @param args Non utilis�.
	 */
	public static void main(String[] args) {
		
		// testGetSymbole();
		// testGetOrdre();

	}

}
