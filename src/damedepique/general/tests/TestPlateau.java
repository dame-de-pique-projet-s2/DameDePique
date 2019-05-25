/*
 * TestPlateau.java                                                  24/05/2019
 * Projet de la dame de pique | IUT de Rodez | 2018 - 2019
 */

package damedepique.general.tests;

import damedepique.general.Carte;
import damedepique.general.Humain;
import damedepique.general.Joueur;
import damedepique.general.OutilCarte;
import damedepique.general.Paquet;
import damedepique.general.Plateau;
import damedepique.general.Symbole;
import damedepique.ia.IA;

/**
 * <p>
 *   Cette classe contient toutes les m�thodes de test de la classe Plateau.
 * </p>
 *   
 * @author Julien B.
 * @author Lo�c B.
 * @author Margaux B.
 * @author Justine R.
 * 
 * @version 1.0
 */
public class TestPlateau {

	/**
	 * Test de la m�thode Plateau.getPerdant(Joueur[])
	 */
	public static void testGetPerdant() {
		System.out.println("Plateau.getPerdant(Joueur[])\n"
                           + "----------------------------");
		
		Paquet paquet = new Paquet();
		paquet.creer();
		
		Joueur[] joueurs = new Joueur[4];
		joueurs[0] = new Humain("Humain_0");
		for (int i = 1 ; i < joueurs.length ; i++) {
			joueurs[i] = new IA("IA_" + i);
		}
		
		paquet.melanger();
		paquet.distribuer(joueurs);
		
		OutilCarte.trierMains(joueurs);
		
		Plateau plateau = new Plateau();
		
		Carte carteJouee;
		Symbole debut;
		
		carteJouee = ((Humain) joueurs[0]).jouerCarte();
		plateau.ajouterCarte(carteJouee);
		debut = plateau.getSymboleDebut();
		for (int j = 1 ; j < joueurs.length ; j++) {
			carteJouee = ((IA) joueurs[j]).jouerCarte(debut, 0);
			plateau.ajouterCarte(carteJouee);
		}
		
		System.out.println("Plateau :" + plateau + "\n");
		System.out.println(joueurs[plateau.getPerdant(joueurs)]);
		
		plateau.vider();
		
		OutilTest.continuer();
	}
	
	
	/**
	 * Lancement des m�thodes de test de la classe Plateau.
	 * @param args Non utilis�.
	 */
	public static void main(String[] args) {
		System.out.println("-------------------------------------\n"
                           + "|     TEST DE LA CLASSE PLATEAU     |\n"
                           + "-------------------------------------\n");
		
		testGetPerdant();

	}

}
