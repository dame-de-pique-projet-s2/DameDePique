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
			// TODO Mettre trois IA.
			joueurs[i] = new Humain();    // Création de trois joueurs IA.
		}
		
		// L'indice correspond à la place du joueur.
		int[] pointsManche = new int[NB_JOUEURS];
		 
		int numeroManche = 0;
		int numeroTour = 0;
		
		while (!finPartie(joueurs)) {
			paquet.melanger();
			paquet.distribuer(joueurs);
			
			if (numeroManche == 0) {
				trierMains(joueurs);
			}
			
			while (!finManche(joueurs[0])) {
				if (numeroTour == 0) {
					// TODO Échange des trois cartes.
					trierMains(joueurs);
				}
				
				while (!finTour(plateau)) {
					
					// TODO Ne pas commencer par un coeur.
					Carte carteJouee;
					carteJouee = ((Humain) joueurs[0]).jouerCarte();
					joueurs[0].retirerCarte(carteJouee);
					plateau.ajouterCarte(carteJouee);
					
					System.out.println("\n\n\n\nVoici le plateau de jeu actuel : " + plateau + "\n\n\n\n");
					
					Symbole symboleDebut = plateau.getSymboleDebut();
					
					carteJouee = ((Humain) joueurs[1]).jouerCarte(symboleDebut);
					joueurs[1].retirerCarte(carteJouee);
					plateau.ajouterCarte(carteJouee);
					System.out.println("\n\n\n\nVoici le plateau de jeu actuel : " + plateau + "\n\n\n\n");
					carteJouee = ((Humain) joueurs[2]).jouerCarte(symboleDebut);
					joueurs[2].retirerCarte(carteJouee);
					plateau.ajouterCarte(carteJouee);
					System.out.println("\n\n\n\nVoici le plateau de jeu actuel : " + plateau + "\n\n\n\n");
					carteJouee = ((Humain) joueurs[3]).jouerCarte(symboleDebut);
					joueurs[3].retirerCarte(carteJouee);
					plateau.ajouterCarte(carteJouee);
					System.out.println("\n\n\n\nVoici le plateau de jeu actuel : " + plateau + "\n\n\n\n");
					
					System.out.println(plateau.getPerdant(symboleDebut, joueurs));
					
					System.out.println("\n\n\n\nVoici le plateau de jeu actuel : " + plateau + "\n\n\n\n");
					
					numeroTour++;
				}
				
				// TODO Message de fin de tour + nom du perdant.
				plateau.vider();
				
				/* 
				 * A la fin de chaque tour ajouter les points par joueur
				 * et incrémenter numeroManche.
				 */
				numeroManche++;
			}
			
			/* 
			 * Ajout des points de la dernière manche au points globaux 
			 * des joueurs.
			 * TODO Faire la gestion de la cloche de bois
			 */
			for (int j = 0 ; j < NB_JOUEURS ; j++) {
				joueurs[j].ajouterPoints(pointsManche[j]);
			}

		}

	}

}
