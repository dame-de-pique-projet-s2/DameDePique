/*
 * TestIA.java                                                       01/05/2019
 * Projet de la dame de pique | IUT de Rodez | 2018 - 2019
 */

package damedepique.ia.tests;

import static damedepique.general.OutilAffichage.*;
import static damedepique.general.OutilCarte.*;

import damedepique.general.Carte;
import damedepique.general.Paquet;
import damedepique.general.tests.OutilTest;
import damedepique.ia.IA;

/**
 * <p>
 *   Cette classe contient toutes les méthodes de test de la classe IA.
 * </p>
 *   
 * @author Julien B.
 * @author Loïc B.
 * @author Margaux B.
 * @author Justine R.
 * 
 * @version 1.0
 */
public class TestIA {
	
	/**
	 * Test de la méthode IA.jouerCarte()
	 */
	public static void testJouerCarte() {
		System.out.println("IA.jouerCarte()\n"
                           + "---------------");
		
		Paquet paquet = new Paquet();
		paquet.creer();
		
		IA[] joueurs = new IA[4];
		
		for (int i = 0 ; i < joueurs.length ; i++) {
			joueurs[i] = new IA("IA_" + i);
		}
		
		joueurs[0].trierMain();
		
		for (int i = 0 ; i < joueurs.length ; i++) {
			afficherCartes(joueurs[i].getMain(), "Main de l'IA numéro " + i);
		}
		
		paquet.melanger();
		paquet.distribuer(joueurs);
		
		trierMains(joueurs);
		
		for (int i = 0 ; i < joueurs.length ; i++) {
			Carte[] aEchanger = joueurs[i].choisirCartesAEchanger();
			System.out.println("\nJoueur numéro " + i);
			for (int j = 0 ; j < aEchanger.length ; j++) {
				System.out.println(aEchanger[j]);
			}
		}
		
		OutilTest.continuer();
	}
	
	
	/**
	 * Test de la méthode IA.jouerCarte(boolean)
	 */
	public static void testJouerCarteDefausse() {
		System.out.println("IA.jouerCarte(boolean)\n"
                           + "----------------------");
		
		// TODO A compléter.
		
		OutilTest.continuer();
	}
	
	
	/**
	 * Test de la méthode IA.jouerCarte(Symbole, int)
	 */
	public static void testJouerCarteSymbole() {
		System.out.println("IA.jouerCarte(Symbole, int)\n"
                           + "---------------------------");
		
		// TODO A compléter.
		
		OutilTest.continuer();
	}
	
	
	/**
	 * Test de la méthode IA.jouerDeuxTrefle()
	 */
	public static void testJouerDeuxTrefle() {
		System.out.println("IA.jouerDeuxTrefle()\n"
                           + "--------------------");
		
		// TODO A compléter.
		
		OutilTest.continuer();
	}
	
	
	/**
	 * Test de la méthode IA.choisirCartesAEchanger()
	 */
	public static void testChoisirCartesAEchanger() {
		System.out.println("IA.choisirCartesAEchanger()\n"
                           + "---------------------------");
		
		// TODO A compléter.
		
		OutilTest.continuer();
	}
	
	
	/**
	 * Lancement des méthodes de test de la classe IA.
	 * @param args Non utilisé.
	 */
	public static void main(String[] args) {
		System.out.println("--------------------------------\n"
                           + "|     TEST DE LA CLASSE IA     |\n"
                           + "--------------------------------\n");
		
		testJouerCarte();
		// testJouerCarteDefausse();
		// testJouerCarteSymbole();
		// testJouerDeuxTrefle();
		// testChoisirCartesAEchanger();

	}

}
