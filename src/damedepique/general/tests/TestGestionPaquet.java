/*
 * TestGestionPaquet.java                                            22/04/2019
 * Projet de la dame de pique | IUT de Rodez | 2018 - 2019
 */

package damedepique.general.tests;

import damedepique.general.Carte;
import damedepique.general.GestionPaquet;
import damedepique.general.Joueur;

/**
 * Cette classe contient toutes les méthodes de test de la 
 * classe GestionPaquet.
 * @author Julien B.
 * @version 1.0
 */
public class TestGestionPaquet {

	/**
	 * Test de la méthode GestionPaquet.creation()
	 */
	public static void testCreation() {
		System.out.println("GestionPaquet.creation()\n"
		                   + "------------------------\n");
		
		Carte[] paquet;
		paquet = GestionPaquet.creation();
		
		for (Carte carte : paquet) {
			System.out.println(carte);
		}
		
		OutilTest.continuer();
	}
	
	/**
	 * Test de la méthode GestionPaquet.melange(Carte[])
	 */
	public static void testMelange() {
		System.out.println("GestionPaquet.melange(Carte[])\n"
                           + "------------------------------\n");
		
		Carte[] paquet;
		paquet = GestionPaquet.creation();
		
		System.out.println("Paquet avant le mélange : ");
		for (Carte carte : paquet) {
			System.out.println(carte);
		}
		
		GestionPaquet.melange(paquet);
		
		System.out.println("\nPaquet après le mélange : ");
		for (Carte carte : paquet) {
			System.out.println(carte);
		}
		
		OutilTest.continuer();
	}
	
	/**
	 * Test de la méthode GestionPaquet.distribution(Carte[], Joueur[])
	 */
	public static void testDistribution() {
		System.out.println("GestionPaquet.distribution(Carte[], Joueur[])\n"
                           + "---------------------------------------------\n");
		
		Joueur[] joueurs = new Joueur[4];
		for (int i = 0 ; i < joueurs.length ; i++) {
			joueurs[i] = new Joueur();
		}
		
		Carte[] paquet;
		paquet = GestionPaquet.creation();
		
		GestionPaquet.melange(paquet);
		
		GestionPaquet.distribution(paquet, joueurs);
		
		for (int j = 0 ; j < joueurs.length ; j++) {
			System.out.println(joueurs[j].getPseudo() + " [" + (j + 1) + "/" 
		                       + joueurs.length + "] : " + joueurs[j].getMain());
		}
		
		OutilTest.continuer();
	}
	
	/**
	 * Lancement des méthodes de test de la classe GestionPaquet.
	 * @param args Non utilisé.
	 */
	public static void main(String[] args) {
		
		System.out.println("-------------------------------------------\n"
                           + "|     TEST DE LA CLASSE GESTIONPAQUET     |\n"
		                   + "-------------------------------------------\n");
		
		// testCreation();
		// testMelange();
		// testDistribution();

	}

}
