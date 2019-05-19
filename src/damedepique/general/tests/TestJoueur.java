/*
 * TestJoueur.java                                                   25/04/2019
 * Projet de la dame de pique | IUT de Rodez | 2018 - 2019
 */

package damedepique.general.tests;

import damedepique.general.Joueur;
import damedepique.general.Paquet;
import damedepique.ia.IA;

/**
 * <p>
 *   Cette classe contient toutes les méthodes de ordreEchange de la classe Joueur.
 * </p>
 *   
 * @author Loïc B. | Julien B. | Margaux B. | Justine R.
 * @version 1.0
 */
public class TestJoueur {
	
	/**
	 * Test de la méthode Joueur.trierMain()
	 */
	public static void testTrierMain() {
		System.out.println("Joueur.trierMain()\n"
                           + "------------------");
		
		// Instantiation d'un nouveau paquet de cartes.
		Paquet paquet = new Paquet();
				
		// Instantiation et initialisation de quatre joueurs.
		Joueur[] joueurs = new Joueur[4];
		for (int i = 0 ; i < joueurs.length ; i++) {
		    joueurs[i] = new IA("IA_" + i);
		}
				
		// Création du nouveau paquet de cartes.
		paquet.creer();
				
		// Mélange du paquet précédemment crée. 
		paquet.melanger();
				
		// Distribution du paquet de cartes entre les quatre joueurs.
		paquet.distribuer(joueurs);
			
		System.out.println(joueurs[0]);
		
		joueurs[0].trierMain();
		
		System.out.println("\n" + joueurs[0]);
				
		OutilTest.continuer();
	}
	
	
	/**
	 * Lancement des méthodes de ordreEchange de la classe Joueur.
	 * @param args Non utilisé.
	 */
	public static void main(String[] args) {
		System.out.println("------------------------------------\n"
                           + "|     TEST DE LA CLASSE JOUEUR     |\n"
                           + "------------------------------------\n");
		
		// testTrierMain();

	}
	
}
