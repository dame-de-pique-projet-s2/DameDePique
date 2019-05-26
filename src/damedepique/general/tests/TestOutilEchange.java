/*
 * TestOutilEchange.java                                             25/05/2019
 * Projet de la dame de pique | IUT de Rodez | 2018 - 2019
 */

package damedepique.general.tests;

import damedepique.general.Humain;
import damedepique.general.Joueur;
import damedepique.general.OutilAffichage;
import damedepique.general.OutilCarte;
import damedepique.general.OutilEchange;
import damedepique.general.Paquet;
import damedepique.ia.IA;

/**
 * <p>
 *   Cette classe contient les méthodes de test de la classe OutilEchange.
 * </p>
 * 
 * @author Julien B.
 * @author Loïc B.
 * @author Margaux B.
 * @author Justine R.
 * 
 * @version 1.0
 */
public class TestOutilEchange {

	/**
	 * Test de la méthode OutilEchange.echangerCartes(Joueur[], int)
	 */
	public static void testEchangerCartes() {
		System.out.println("OutilEchange.echangerCartes(Joueur[], int)\n"
                           + "------------------------------------------");
		
		int numeroManche;    // Compteur de manche pour simuler une partie.
		
		numeroManche = 0;    // Mise à zéro du compteur de manche.
		while (numeroManche < OutilTest.NB_TESTS) {
			
			// Instantiation d'un paquet de cartes à jouer.
			Paquet paquet = new Paquet();
			
			// Création du paquet de 52 cartes pour jouer.
			paquet.creer();
			
			// Création d'un groupe de quatre joueurs.
			Joueur[] joueurs = new Joueur[4];
			
			// Création d'un joueur humain.
			joueurs[0] = new Humain("Humain_0");
			
			// Création de trois joueurs intelligences artificielles.
			joueurs[1] = new IA("IA_1");
			joueurs[2] = new IA("IA_2");
			joueurs[3] = new IA("IA_3");
			
			// Mélange du paquet de cartes.
			paquet.melanger();
			
			// Distribution du paquet entre les quatre joueurs de la partie.
			paquet.distribuer(joueurs);
			
			// Tri des mains des joueurs de la partie.
			OutilCarte.trierMains(joueurs);
			
			/* 
			 * Échange des cartes entre les quatre joueurs. Cet échange diffère 
			 * d'un tour à l'autre car le sens de l'échange est modifié à 
			 * chaque tour.
			 */
			OutilEchange.echangerCartes(joueurs, numeroManche);
			
			// Nettoyage de la console texte après chaque échange.
			OutilAffichage.cls();
			
			numeroManche++;    // Incrémente le numéro de la manche.
		}
		
		OutilTest.continuer();
	}
	
	
	/**
	 * Lancement des méthodes de test de la classe OutilEchange.
	 * @param args Non utilisé.
	 */
	public static void main(String[] args) {
		System.out.println("------------------------------------------\n"
                           + "|     TEST DE LA CLASSE OUTILECHANGE     |\n"
                           + "------------------------------------------\n");
		
		testEchangerCartes();
		
	}
	
}
