/*
 * DameDePique.java                                                  28/04/2019
 * Projet de la dame de pique | IUT de Rodez | 2018 - 2019
 */

package damedepique.general;

import static damedepique.general.OutilCarte.*;
import static damedepique.general.OutilPartie.*;

import damedepique.ia.IA;

/**
 * <p>
 *   TODO Faire la description de cette classe.
 * </p>
 * 
 * @author Loïc B. | Julien B. | Margaux B. | Justine R.
 * @version 1.0
 */
public class DameDePique {

	/** Le nombre de joueurs que le jeu peut accueillir simultanément. */
	private static final int NB_JOUEURS = 4;
	
	
	/**
	 * Point d'entrée de l'application de la dame de pique.
	 * @param args Non utilisé.
	 */
	public static void main(String[] args) {
		
		// Création d'un paquet de 52 cartes à jouer.
		Paquet paquet = new Paquet();
		paquet.creer();    // Initialisation du paquet de cartes pour jouer.
		
		/* 
		 * Création d'un plateau pour poser les cartes jouées par les
		 * joueurs durant les tours.
		 */
		Plateau plateau = new Plateau();
		
		// Création d'un groupe de quatre joueurs.
		Joueur[] joueurs = new Joueur[NB_JOUEURS];
		joueurs[0] = new Humain();    // Création d'un joueur humain.
		for (int i = 1 ; i < NB_JOUEURS ; i++) {
			joueurs[i] = new IA();    // Création de trois joueurs IA.
		}
		 
		int numeroManche = 0;
		
		Carte carteJouee;
		int premier = 0;
		
		while (!finPartie(joueurs)) {
			for (int j = 0 ; j < NB_JOUEURS ; j++) {
				if (j == 0) {
					System.out.println(joueurs[0] + " (vous)");
				} else {
					System.out.println(joueurs[j]);
				}
			}
			
			int numeroTour = 0;
			
			paquet.melanger();
			paquet.distribuer(joueurs);
			
			trierMains(joueurs);

			echangerCartes(joueurs, numeroManche);
			
			while (!finManche(joueurs[0])) {
				if (numeroTour == 0) {
					premier = rechercherCarte(joueurs, Symbole.Trefle, Valeur.Deux);
					if (joueurs[premier] instanceof Humain) {
						carteJouee = ((Humain) joueurs[premier]).jouerDeuxTrefle();
					} else {
						carteJouee = ((IA) joueurs[premier]).jouerDeuxTrefle();
					}
					plateau.ajouterCarte(carteJouee);
				} else {
					if (joueurs[premier] instanceof Humain) {
						carteJouee = ((Humain) joueurs[premier]).jouerCarte();
					} else {
						carteJouee = ((IA) joueurs[premier]).jouerCarte();
					}
					plateau.ajouterCarte(carteJouee);
				}
					
				System.out.println("\n\nVoici le plateau de jeu "
					               + "actuel : " + plateau + "\n\n");
					
				Symbole symboleDebut = plateau.getSymboleDebut();
					
				for (int k = premier + 1 ; k != premier ; k++) {
					if (k == joueurs.length) { k = 0; }
						
					if (joueurs[k] instanceof Humain) {
						carteJouee = ((Humain) joueurs[k]).jouerCarte(symboleDebut);
					} else {
						carteJouee = ((IA) joueurs[k]).jouerCarte(symboleDebut);
					}
						
					plateau.ajouterCarte(carteJouee);
					System.out.println("\n\nVoici le plateau de jeu "
								       + "actuel : " + plateau + "\n\n");
					
					// TODO A améliorer.
					if (premier == 0 && k == 3) { k = -1; };
				}
				
				premier = plateau.getPerdant(joueurs);
				
				plateau.ajouterPointsTour(joueurs);
				
				plateau.retirerCartesJouees(joueurs);
					
				System.out.println(joueurs[premier].getPseudo() + " a "
						           + "perdu(e) le tour " + (numeroTour + 1) 
						           + "/13.\nRécapitulatif des points de cette "
						           + "manche : ");
				
				for (int m = 0 ; m < NB_JOUEURS ; m++) {
					System.out.println("\n    => " + joueurs[m].getPseudo() 
							           + " possède " 
							           + joueurs[m].getPointsManche() 
							           + " point(s).");
				}
				
				numeroTour++;
			}
			
			ajouterPointsTot(joueurs);
			
			numeroManche++;

		}
		
		getGagnant(joueurs);

	}

}
