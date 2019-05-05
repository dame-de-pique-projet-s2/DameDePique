/*
 * DameDePique.java                                                  28/04/2019
 * Projet de la dame de pique | IUT de Rodez | 2018 - 2019
 */

package damedepique.general;

import static damedepique.general.OutilCarte.*;
import static damedepique.general.OutilPartie.*;

import damedepique.ia.IA;

/**
 * Cette classe contient le programme n�cessaire au d�roulement d'une partie
 * @author Lo�c B. Julien B. Margaux B. Justine R.
 * @version 1.0
 */
public class DameDePique {

	private static final int NB_JOUEURS = 4;
	
	public static Paquet paquet;
	
	public static Plateau plateau;
	
	public static Joueur[] joueurs;
	
	public static int premierJoueur;
	
	/**
	 * Programme regroupant les algorithmes n�cessaires au d�roulement 
	 * d'une partie du jeu de la dame de pique
	 * @param args inutilis�.
	 */
	
	public static void main(String[] args) {
			
		paquet = new Paquet(); // Cr�ation d'un paquet de 52 cartes.
		paquet.creer();        // Initialisation du paquet de cartes.
		
		/* Cr�ation d'un plateau de jeu */
		plateau = new Plateau();
		
		/* Cr�ation d'un groupe de quatre joueurs */
		joueurs = new Joueur[NB_JOUEURS];
		
		joueurs[0] = new Humain();    // Cr�ation d'un joueur humain.
		
		for (int i = 1 ; i < NB_JOUEURS ; i++) {
			
			joueurs[i] = new IA();    // Cr�ation de trois joueurs IA.	
		}
		
		int[] pointsManche = new int[NB_JOUEURS]; // L'indice correspond � la place du joueur.
		 
		int numeroManche = 0;
		int numeroTour = 0;
		
		Carte carteJouee;
		premierJoueur = 0;    // Bouchon
		
		while (!finPartie(joueurs)) {
			paquet.melanger();
			paquet.distribuer(joueurs);
			
			trierMains(joueurs);
			
			if (numeroManche == 4) {
				numeroManche = 0;
			}

			echangerCartes(joueurs, numeroManche);
			
			while (!finManche(joueurs[0])) {
				if (numeroTour == 0) {
					premierJoueur = rechercherCarte(joueurs, Symbole.Trefle, Valeur.Deux);
					if (joueurs[premierJoueur] instanceof Humain) {
						carteJouee = ((Humain) joueurs[premierJoueur]).jouerDeuxTrefle();
					} else {
						carteJouee = ((IA) joueurs[premierJoueur]).jouerDeuxTrefle();
					}
					plateau.ajouterCarte(carteJouee);
				}
				
				while (!finTour(plateau)) {
					Symbole symboleDebut = plateau.getSymboleDebut();
					
					// TODO Faire le jeu dans le sens des aiguilles d'une montre.
					for (int i = 0 ; i < joueurs.length ; i++) {
						if (i != premierJoueur) {
							System.out.println("\n\n\n\nVoici le plateau de jeu actuel : " + plateau + "\n\n\n\n");
							if (joueurs[i] instanceof Humain) {
								// Il faut rajouter l'indice du premierJoueur joueur du tour en argument
								carteJouee = ((Humain) joueurs[i]).jouerCarte(symboleDebut, premierJoueur);
							} else {
								carteJouee = ((IA) joueurs[i]).jouerCarte(symboleDebut);
							}
							plateau.ajouterCarte(carteJouee);
						}
					}
					
					// FIXME Erreur par rapport � la longueur du plateau.
					premierJoueur = plateau.getPerdant(joueurs);
					
					System.out.println(joueurs[premierJoueur].getPseudo() + " a perdu(e) le tour " + (numeroTour + 1) + "/13.");
					
					// TODO Attention enlever les cartes jou�es par les joueurs des mains.
					
					plateau.vider();
					
					numeroTour++;
				}
				
				/* 
				 * A la fin de chaque tour ajouter les points par joueur
				 * et incr�menter numeroManche.
				 */
				numeroManche++;
			}
			
			/* 
			 * Ajout des points de la derni�re manche au points globaux 
			 * des joueurs.
			 * TODO Faire la gestion de la cloche de bois
			 */
			for (int j = 0 ; j < NB_JOUEURS ; j++) {
				joueurs[j].ajouterPoints(pointsManche[j]);
			}

		}

	}

}
