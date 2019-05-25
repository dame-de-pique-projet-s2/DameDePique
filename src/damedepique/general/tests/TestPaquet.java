/*
 * TestPaquet.java                                                   24/05/2019
 * Projet de la dame de pique | IUT de Rodez | 2018 - 2019
 */

package damedepique.general.tests;

import damedepique.general.Humain;
import damedepique.general.Joueur;
import damedepique.general.OutilAffichage;
import damedepique.general.OutilCarte;
import damedepique.general.Paquet;
import damedepique.ia.IA;

/**
 * <p>
 *   Cette classe contient toutes les m�thodes de test de la classe Paquet.
 * </p>
 *   
 * @author Julien B.
 * @author Lo�c B.
 * @author Margaux B.
 * @author Justine R.
 * 
 * @version 1.0
 */
public class TestPaquet {
	
	/**
	 * Test de la m�thode Paquet.distribuer()
	 */
	public static void testDistribuer() {
		System.out.println("Paquet.distribuer()\n"
                           + "-------------------");
		
		// Instantiation d'un nouveau paquet de cartes.
		Paquet paquet = new Paquet();
		
		// Cr�ation du paquet de 52 cartes pour jouer.
		paquet.creer();
		
		// Cr�ation d'un groupe de quatre joueurs.
		Joueur[] joueurs = new Joueur[4];
					
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
		
		// Affichage des mains de tous les joueurs de la partie.
		for (Joueur joueur : joueurs) {
			OutilAffichage.afficherCartes(joueur.getMain(), 
					                      "La main de " + joueur.getPseudo());
		}
		
		OutilTest.continuer();
	}
	
	
	/**
	 * Lancement des m�thodes de test de la classe Paquet.
	 * @param args Non utilis�.
	 */
	public static void main(String[] args) {
		System.out.println("------------------------------------\n"
                           + "|     TEST DE LA CLASSE PAQUET     |\n"
                           + "------------------------------------\n");
		
		// testDistribuer();

	}

}
