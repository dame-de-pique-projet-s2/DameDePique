/*
 * TestPaquet.java                                                   25/04/2019
 * Projet de la dame de pique | IUT de Rodez | 2018 - 2019
 */

package damedepique.general.tests;

import damedepique.general.Joueur;
import damedepique.general.Paquet;
import damedepique.ia.IA;

/**
 * <p>
 *   Cette classe contient toutes les méthodes de test de la classe Paquet.
 * </p>
 *   
 * @author Loïc B. | Julien B. | Margaux B. | Justine R.
 * @version 1.0
 */
public class TestPaquet {

	/**
	 * Test de la méthode Paquet.creer()
	 */
	public static void testCreer() {
		System.out.println("Paquet.creer()\n"
		                   + "--------------");
		
		// Instantiation d'un nouveau paquet de cartes.
		Paquet paquet = new Paquet();
		
		// Création du nouveau paquet de cartes.
		paquet.creer();
		
		// Affichage du nouveau paquet de cartes.
		System.out.println(paquet);
		
		OutilTest.continuer();
	}
	
	
	/**
	 * Test de la méthode Paquet.melanger()
	 */
	public static void testMelanger() {
		System.out.println("Paquet.melanger()\n"
                           + "-----------------");
		
		// Instantiation d'un nouveau paquet de cartes.
		Paquet paquet = new Paquet();
				
		// Création du nouveau paquet de cartes.
		paquet.creer();
		
		// Mélange du paquet précédemment crée. 
		paquet.melanger();
		
		// Affichage du nouveau paquet de cartes après le mélange.
		System.out.println(paquet);
		
		OutilTest.continuer();
	}
	
	
	/**
	 * Test de la méthode Paquet.distribuer()
	 */
	public static void testDistribuer() {
		System.out.println("Paquet.distribuer()\n"
                           + "-------------------");
		
		// Instantiation d'un nouveau paquet de cartes.
		Paquet paquet = new Paquet();
		
		// Instantiation et initialisation de quatre joueurs.
		Joueur[] joueurs = new Joueur[4];
		for (int i = 0 ; i < joueurs.length ; i++) {
			joueurs[i] = new IA();
		}
		
		// Création du nouveau paquet de cartes.
		paquet.creer();
		
		// Mélange du paquet précédemment crée. 
		paquet.melanger();
		
		// Distribution du paquet de cartes entre les quatre joueurs.
		paquet.distribuer(joueurs);
		
		// Affichage des mains de tous les joueurs de la partie.
		for (int j = 0 ; j < joueurs.length ; j++) {
			System.out.println(joueurs[j] + "\n");
		}
		
		OutilTest.continuer();
	}
	
	
	/**
	 * Lancement des méthodes de test de la classe Paquet.
	 * @param args Non utilisé.
	 */
	public static void main(String[] args) {
		System.out.println("------------------------------------\n"
                           + "|     TEST DE LA CLASSE PAQUET     |\n"
                           + "------------------------------------\n");
		
		// testCreer();
		// testMelanger();
		// testDistribuer();

	}

}
