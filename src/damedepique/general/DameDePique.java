/*
 * DameDePique.java                                                  28/04/2019
 * Projet de la dame de pique | IUT de Rodez | 2018 - 2019
 */

package damedepique.general;

import static damedepique.general.OutilCarte.*;
import static damedepique.general.OutilPartie.*;

/**
 * 
 * @author Julien B.
 * @version 1.0
 */
public class DameDePique {

	private static final int NB_JOUEURS = 4;
	
	/**
	 * 
	 * @param args Non utilis�.
	 */
	public static void main(String[] args) {
		
		// Cr�ation d'un paquet de 52 cartes � jouer.
		Paquet paquet = new Paquet();
		paquet.creer();    // Initialisation du paquet de cartes pour jouer.
		
		/* 
		 * Cr�ation d'un plateau pour poser les cartes jou�es par les 
		 * joueurs durant les tours.
		 */
		Plateau plateau = new Plateau();
		
		// Cr�ation d'un groupe de quatre joueurs.
		Joueur[] joueurs = new Joueur[NB_JOUEURS];
		joueurs[0] = new Humain();    // Cr�ation d'un joueur humain.
		for (int i = 1 ; i < NB_JOUEURS ; i++) {
			// TODO Mettre trois IA.
			joueurs[i] = new Humain();    // Cr�ation de trois joueurs IA.
		}
		
		// L'indice correspond � la place du joueur.
		int[] pointsManche = new int[NB_JOUEURS];
		 
		int numeroManche = 0;
		int numeroTour = 0;
		
		Carte carteJouee;
		int premier;
		
		while (!finPartie(joueurs)) {
			paquet.melanger();
			paquet.distribuer(joueurs);
			
			trierMains(joueurs);
			
			if (numeroManche == 4) {
				numeroManche = 0;
			}
			
			if (numeroManche < 3) {
				System.out.println("D�but de l'�change des cartes !");
				
				((Humain) joueurs[0]).choisirCartesAEchanger();
				((Humain) joueurs[1]).choisirCartesAEchanger();
				((Humain) joueurs[2]).choisirCartesAEchanger();
				((Humain) joueurs[3]).choisirCartesAEchanger();
				echangerCartes(joueurs, numeroManche);
				
				System.out.println("L'�change des cartes est termin� !");
				
				trierMains(joueurs);
			} else {
				System.out.println("Pas d'�change ce tour l� !");
			}
			
			while (!finManche(joueurs[0])) {
				if (numeroTour == 0) {
					premier = rechercherCarte(joueurs, Symbole.Trefle, Valeur.Deux);
					System.out.println(joueurs[premier]);
					carteJouee = ((Humain) joueurs[premier]).jouerDeuxTrefle();
					joueurs[premier].retirerCarte(carteJouee);
					plateau.ajouterCarte(carteJouee);
				} else {
					// Recherche du perdant durant le tour pr�c�dant.
				}
				
				while (!finTour(plateau)) {
					
					// TODO Ne pas commencer par un coeur.
					
					Symbole symboleDebut = plateau.getSymboleDebut();
					
					for (int i = 0 ; i < joueurs.length - 1 ; i++) {
						carteJouee = ((Humain) joueurs[i]).jouerCarte(symboleDebut);
						joueurs[i].retirerCarte(carteJouee);
						plateau.ajouterCarte(carteJouee);
						System.out.println("\n\n\n\nVoici le plateau de jeu actuel : " + plateau + "\n\n\n\n");
					}
					
					premier = plateau.getPerdant(symboleDebut, joueurs);
					
					System.out.println(joueurs[premier] + " a perdu(e) le tour " + (numeroTour + 1) + "/13.");
					
					numeroTour++;
				}
				
				// TODO Message de fin de tour + nom du perdant.
				plateau.vider();
				
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
