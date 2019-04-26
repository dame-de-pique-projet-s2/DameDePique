/*
 * TestPaquet.java                                                   25/04/2019
 * Projet de la dame de pique | IUT de Rodez | 2018 - 2019
 */

package damedepique.general.tests;

import damedepique.general.Joueur;
import damedepique.general.Paquet;

/**
 * TODO Faire la description de la classe de test TestPaquet.
 * @author Julien
 * @version 1.0
 */
public class TestPaquet {

	/**
	 * Test de la m�thode Paquet.creer()
	 */
	public static void testCreer() {
		// Instantiation d'un nouveau paquet de cartes.
		Paquet paquet = new Paquet();
		
		// Cr�ation du nouveau paquet de cartes.
		paquet.creer();
		
		// Affichage du nouveau paquet de cartes.
		System.out.println(paquet);
	}
	
	
	/**
	 * Test de la m�thode Paquet.melanger()
	 */
	public static void testMelanger() {
		// Instantiation d'un nouveau paquet de cartes.
		Paquet paquet = new Paquet();
				
		// Cr�ation du nouveau paquet de cartes.
		paquet.creer();
		
		// Affichage du nouveau paquet de cartes avant le m�lange.
		System.out.println("Avant le m�lange = \n" + paquet);
		
		paquet.melanger();
		
		// Affichage du nouveau paquet de cartes apr�s le m�lange.
		System.out.println("Apr�s le m�lange = \n" + paquet);
	}
	
	
	/**
	 * Test de la m�thode Paquet.distribuer()
	 */
	public static void testDistribuer() {
		Paquet paquet = new Paquet();
		
		Joueur[] joueurs = new Joueur[4];
		for (int i = 0 ; i < joueurs.length ; i++) {
			joueurs[i] = new Joueur();
		}
		
		paquet.creer();
		paquet.melanger();
		
		paquet.distribuer(joueurs);
		
		System.out.println("1er = \n" + joueurs[0].getMain());
		System.out.println("\n2eme = \n" + joueurs[1].getMain());
		System.out.println("\n3eme = \n" + joueurs[2].getMain());
		System.out.println("\n4eme = \n" + joueurs[3].getMain());
	}
	
	
	/**
	 * Lancement des m�thodes de test de la classe Paquet.
	 * @param args Non utilis�.
	 */
	public static void main(String[] args) {
		
		testCreer();
		testMelanger();
		testDistribuer();

	}

}
