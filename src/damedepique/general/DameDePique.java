/*
 * DameDePique.java                                                  28/04/2019
 * Projet de la dame de pique | IUT de Rodez | 2018 - 2019
 */

package damedepique.general;

import static damedepique.general.OutilCarte.*;
import static damedepique.general.OutilPartie.*;

import damedepique.ia.IA;

/**
 * 
 * @author Julien B.
 * @version 1.0
 */
public class DameDePique {

	/**
	 * 
	 */
	private static final int NB_JOUEURS = 4;
	
	/**
	 * 
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
			for (int z = 0 ; z < joueurs.length ; z++) {
				if (z == 0) {
					System.out.println(joueurs[0] + " (vous)");
				} else {
					System.out.println(joueurs[z]);
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
					
				for (int i = premier + 1 ; i != premier ; i++) {
					if (i == joueurs.length) { i = 0; }
						
					if (joueurs[i] instanceof Humain) {
						carteJouee = ((Humain) joueurs[i]).jouerCarte(symboleDebut);
					} else {
						carteJouee = ((IA) joueurs[i]).jouerCarte(symboleDebut);
					}
						
					plateau.ajouterCarte(carteJouee);
					System.out.println("\n\nVoici le plateau de jeu "
								       + "actuel : " + plateau + "\n\n");
						
					if (premier == 0 && i == 3) { i = -1; };
				}
				
				premier = plateau.getPerdant(joueurs);
				
				// Faire l'ajout des points avant de retirer les cartes du plateau.
				plateau.ajouterPointsTour(joueurs);
				
				plateau.retirerCartesJouees(joueurs);
					
				System.out.println(joueurs[premier].getPseudo() + " a perdu(e) le tour " + (numeroTour + 1)+ "/13.");
				
				numeroTour++;
			}

			plateau.ajouterPointsTot(joueurs);
			
			numeroManche++;

		}

	}

}
