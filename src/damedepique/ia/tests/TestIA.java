/*
 * TestIA.java                                                       01/05/2019
 * Projet de la dame de pique | IUT de Rodez | 2018 - 2019
 */

package damedepique.ia.tests;

import damedepique.general.Carte;
import damedepique.general.Joueur;
import damedepique.general.Paquet;
import damedepique.ia.IA;

/**
 * Cette classe contient toutes les méthodes de test de la classe IA.
 * @author Loïc B. Julien B. Margaux B. Justine R.
 * @version 1.0
 */
public class TestIA {
	
	/**
	 * Test de la méthode carteEchange
	 */
	public static void testcarteEchange() {
		System.out.println("IA.carteEchange()\n"
	                + "------------------");

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
	
	    // Tri de la main pour le joueur I.A du test.
	    joueurs[0].trierMain();
	
	    // Affichage de la main du joueur
        System.out.println("\n" + joueurs[0]);
		
	    // Création du tableau de carte qui contiendra les choix de l'I.A pour l'échange.
        Carte[] echange = new Carte[3];
        
    	// echange = ((IA) joueurs[0]).carteEchange();
    	
    	// Affichage du résultat donné par la méthode
	    System.out.println("Cartes à échanger : ");
    	for (Carte carte : echange) {
		    System.out.println(carte.toString());
    	}
		
	}
	
	/**
	 * Lancement des méthodes de test de la classe IA.
	 * @param args Non utilisé.
	 */
	public static void main(String[] args) {
		
		testcarteEchange();

	}

}
