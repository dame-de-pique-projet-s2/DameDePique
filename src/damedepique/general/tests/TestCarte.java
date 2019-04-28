/*
 * TestCarte.java                                                    25/04/2019
 * Projet de la dame de pique | IUT de Rodez | 2018 - 2019
 */

package damedepique.general.tests;

import damedepique.general.Carte;
import damedepique.general.Valeur;
import damedepique.general.Couleur;

/**
 * Cette classe contient toutes les méthodes de test de la classe Carte.
 * @author Julien B.
 * @version 1.0
 */
public class TestCarte {
	
	/**
	 * Test de la méthode (getter) Carte.getCouleur()
	 */
	public static void testGetCouleur() {
		System.out.println("Carte.getCouleur()\n"
                           + "------------------");
		
		// Instantiation d'une nouvelle carte de jeu.
		Carte carte = new Carte(Couleur.Coeur, Valeur.Roi);
		
		// Affichage de la couleur de la carte créée auparavant.
		System.out.println("Couleur = " + carte.getCouleur());
		
		OutilTest.continuer();
	}
	
	
	/**
	 * Test de la méthode (getter) Carte.getValeur()
	 */
	public static void testGetValeur() {
		System.out.println("Carte.getValeur()\n"
                           + "-----------------");
		
		// Instantiation d'une nouvelle carte de jeu.
		Carte carte = new Carte(Couleur.Pique, Valeur.Dame);
		
		// Affichage de la valeur de la carte créée auparavant.
		System.out.println("Valeur = " + carte.getValeur());
		
		OutilTest.continuer();
	}
	
	
	/**
	 * Lancement des méthodes de test de la classe Carte.
	 * @param args Non utilisé.
	 */
	public static void main(String[] args) {
		System.out.println("-----------------------------------\n"
                           + "|     TEST DE LA CLASSE CARTE     |\n"
                           + "-----------------------------------\n");
		
		testGetCouleur();
		testGetValeur();

	}

}
