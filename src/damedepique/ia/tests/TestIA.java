/*
 * TestIA.java                                                       01/05/2019
 * Projet de la dame de pique | IUT de Rodez | 2018 - 2019
 */

package damedepique.ia.tests;

import damedepique.general.Carte;
import damedepique.general.Humain;
import damedepique.general.Joueur;
import damedepique.general.OutilAffichage;
import damedepique.general.OutilCarte;
import damedepique.general.Paquet;
import damedepique.general.tests.OutilTest;
import damedepique.ia.IA;

/**
 * <p>
 *   Cette classe contient toutes les m�thodes de test de la classe IA.
 * </p>
 *   
 * @author Julien B.
 * @author Lo�c B.
 * @author Margaux B.
 * @author Justine R.
 * 
 * @version 1.0
 */
public class TestIA {
	
	/** Paquet de cartes permettant de jouer au jeu. */
	private static Paquet paquet;
	
	
	/** Joueurs de la partie cr��e pour les tests. */
	private static Joueur[] joueurs;
	
	
	/**
	 * M�thode permettant d'initialiser une partie de jeu afin de pouvoir 
	 * lancer les tests et ne pas a avoir � recr�er une partie � chaque fois 
	 * (factorisation).
	 */
	private static void initialisation() {
		// Instantiation d'un paquet de cartes � jouer.
		paquet = new Paquet();
								
		// Cr�ation du paquet de 52 cartes pour jouer.
		paquet.creer();
								
		// Cr�ation d'un groupe de quatre joueurs.
		joueurs = new Joueur[4];
								
		// Cr�ation d'un joueur humain.
		joueurs[0] = new Humain("Humain_0");
								
		// Cr�ation de trois joueurs intelligences artificielles.
		joueurs[1] = new IA("IA_1");
		joueurs[2] = new IA("IA_2");
		joueurs[3] = new IA("IA_3");
					
		// M�lange du paquet de cartes.
		paquet.melanger();
					
		// Distribution du paquet entre les quatre joueurs de la partie.
		paquet.distribuer(joueurs);
		
		// Tri des mains des joueurs de la partie.
		OutilCarte.trierMains(joueurs);
	}
	
	
	/**
	 * Test de la m�thode IA.jouerCarte()
	 */
	public static void testJouerCarte() {
		System.out.println("IA.jouerCarte()\n"
                           + "---------------");
		
		int numeroTest;    // Compteur de tests.
		
		numeroTest = 0;    // Mise � z�ro du compteur de tests.
		while (numeroTest < OutilTest.NB_TESTS) {
			
			// Initialisation d'une partie de dame de pique.
			initialisation();
			
			// Affichage de la main de l'IA concern�e par les tests.
			OutilAffichage.afficherCartes(joueurs[1].getMain(), 
					                      "Main de l'" + joueurs[1].getPseudo() 
					                      + " : ");
			
			// Demande et stocke une carte � jouer.
			Carte carteJouee = joueurs[1].jouerCarte();
						
			// Affichage de la carte pr�c�demment jou�e.
			System.out.println("La carte que l'IA a jou�e : " + carteJouee);
						
			// Nettoyage de la console texte apr�s chaque �change.
			OutilAffichage.cls();
			
			numeroTest++;    // Incr�mente le num�ro du test.
			
			OutilTest.continuer();
		}
	}
	
	
	/**
	 * Test de la m�thode IA.jouerCarte(boolean)
	 */
	public static void testJouerCarteDefausse() {
		System.out.println("IA.jouerCarte(boolean)\n"
                           + "----------------------");
		
		int numeroTest;    // Compteur de tests.
		
		numeroTest = 0;    // Mise � z�ro du compteur de tests.
		while (numeroTest < OutilTest.NB_TESTS) {
			
			// Initialisation d'une partie de dame de pique.
			initialisation();
			
			// Affichage de la main de l'IA concern�e par les tests.
			OutilAffichage.afficherCartes(joueurs[1].getMain(), 
					                      "Main de l'" + joueurs[1].getPseudo() 
					                      + " : ");
			
			// Demande et stocke une carte � jouer.
			Carte carteJouee = joueurs[1].jouerCarte(false);
			
			// Affichage de la carte pr�c�demment jou�e.
			System.out.println("La carte que l'IA a jou�e : " + carteJouee);
						
			// Nettoyage de la console texte apr�s chaque �change.
			OutilAffichage.cls();
			
			numeroTest++;    // Incr�mente le num�ro du test.
			
			OutilTest.continuer();
		}
	}
	
	
	/**
	 * Test de la m�thode IA.choisirCartesAEchanger()
	 */
	public static void testChoisirCartesAEchanger() {
		System.out.println("IA.choisirCartesAEchanger()\n"
                           + "---------------------------");
		
		int numeroTest;    // Compteur de tests.
		
		numeroTest = 0;    // Mise � z�ro du compteur de tests.
		while (numeroTest < OutilTest.NB_TESTS) {
			
			// Initialisation d'une partie de dame de pique.
			initialisation();
			
			// Affichage de la main de l'IA concern�e par les tests.
			OutilAffichage.afficherCartes(joueurs[1].getMain(), 
					                      "Main de l'" + joueurs[1].getPseudo() 
					                      + " : ");
			
			// Demande et stocke les cartes pour �changer.
			Carte[] aEchanger = joueurs[1].choisirCartesAEchanger();
						
			// Affiche les cartes choisies pour �changer.
			System.out.println("Les cartes � �changer : ");
			for (Carte carte : aEchanger) {
				System.out.println("=> " + carte);
			}
						
			// Nettoyage de la console texte apr�s chaque �change.
			OutilAffichage.cls();
			
			numeroTest++;    // Incr�mente le num�ro du test.
			
			OutilTest.continuer();
		}
	}
	
	
	/**
	 * Lancement des m�thodes de test de la classe IA.
	 * @param args Non utilis�.
	 */
	public static void main(String[] args) {
		System.out.println("--------------------------------\n"
                           + "|     TEST DE LA CLASSE IA     |\n"
                           + "--------------------------------\n");
		
		testJouerCarte();
		testJouerCarteDefausse();
		testChoisirCartesAEchanger();

	}

}
