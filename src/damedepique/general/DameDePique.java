/*
 * DameDePique.java                                                  12/05/2019
 * Projet de la dame de pique | IUT de Rodez | 2018 - 2019
 */

package damedepique.general;

import static damedepique.general.OutilAffichage.*;
import static damedepique.general.OutilCarte.*;
import static damedepique.general.OutilPartie.*;

import damedepique.ia.IA;

/**
 * <p>
 *   Cette classe permet de lancer l'application <i>DameDePique</i> pour jouer 
 *   une partie.
 * </p>
 * 
 * @author Julien B.
 * @author Loïc B.
 * @author Margaux B.
 * @author Justine R.
 * 
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
		
		cls();    // Nettoyage de la console texte.
		
		// Instantiation d'un paquet de cartes à jouer.
		Paquet paquet = new Paquet();
		
		// Création du paquet de 52 cartes pour jouer.
		paquet.creer();
		
		/* 
		 * Création d'un plateau pour poser les cartes jouées par les
		 * joueurs durant les tours, les joueurs peuvent voir les cartes posées 
		 * sur ce plateau de jeu par exemple pour voir le symbole demandé.
		 */
		Plateau plateau = new Plateau();
		
		// Création d'un groupe de quatre joueurs.
		Joueur[] joueurs = new Joueur[NB_JOUEURS];
		
		// Création d'un joueur humain.
		joueurs[0] = new Humain("Humain_0");
		
		// Création de trois joueurs intelligences artificielles indépendantes.
		for (int i = 1 ; i < NB_JOUEURS ; i++) {
			joueurs[i] = new IA("IA_" + i);
		}
		
		/* 
		 * Demande au joueur humain si il veut modifier son pseudo et le 
		 * pseudo des IA.
		 */
		changerPseudos(joueurs);
		
		cls();    // Nettoyage de la console texte.
		
		// Affichage des joueurs de la partie autour d'un plateau.
		afficherJoueurs(joueurs);
		
		/* 
		 * Demande au joueur humain d'appuyer sur entrée pour 
		 * continuer la partie en cours.
		 */
		continuer();
		
		/* 
		 * Le numéro de la manche pour se repérer dans la partie. Cet 
		 * indicateur sert surtout pour la détermination du sens d'échange des 
		 * cartes entre les quatre joueurs.
		 */
		int noManche = 0;
		
		/*
		 * Le numéro du tour durant une manche, celui-ci sert à déterminer si 
		 * les joueurs ont le droit de jouer certaines cartes (par exemple 
		 * l'interdiction de jouer la dame de pique et du coeur au premier).
		 */
		int noTour;
		
		// Mémorise si un coeur a été défaussé ou non pendant un tour.
		boolean coeurDefausse;
		
		/*
		 * L'indice du premier joueur à jouer pendant un tour. Lors du premier 
		 * tour celui-ci est le possesseur du deux de trèfle puis lors des 
		 * autres tours, c'est le perdant du tour précédant.
		 */
		int premier = 0;
		
		// La carte choisie par un joueur de la partie lors d'un tour.
		Carte aJouer;
		
		// Mémorise le symbole de la première carte posée sur le plateau.
		Symbole symboleDebut;
		
		while (!finPartie(joueurs)) {
			noTour = 0;    // Remise à zéro du compteur de tour.
			
			// Remise à zéro l'indicateur de coeur défaussé.
			coeurDefausse = false;
			
			// Mélange du paquet de cartes pour qu'il n'y ait pas de triche.
			paquet.melanger();
			
			// Distribution du paquet de cartes mélangé au préalable.
			paquet.distribuer(joueurs);
			
			// Tri des mains des joueurs.
			trierMains(joueurs);

			/* 
			 * Échange des trois cartes entre les joueurs de la partie selon 
			 * le numéro du tour courant.
			 */
			echangerCartes(joueurs, noManche);
			
			/* 
			 * Demande au joueur humain d'appuyer sur entrée pour 
			 * continuer la partie en cours.
			 */
			continuer();
			
			// Affiche le numéro de la manche pour en informer le joueur.
			afficherNumeroManche(noManche);
			
			while (!finManche(joueurs[0])) {
				// Affiche le numéro du tour pour en informer le joueur.
				afficherNumeroTour(noTour);

				if (noTour == 0) {
					// Recherche de l'indice du joueur ayant le deux de trèfle.
					premier = rechercherCarte(joueurs, Symbole.Trefle, 
							                           Valeur.Deux);
					
					// Demande au joueur ayant le deux de trèfle de jouer.
					aJouer = joueurs[premier].jouerDeuxTrefle();
				} else {
					// Demande au joueur perdant de commencer le tour.
					aJouer = joueurs[premier].jouerCarte(coeurDefausse);
				}
				
				// Pose la carte jouée sur le plateau.
				plateau.ajouterCarte(aJouer);
				
				// Récupération du symbole de la première carte posée.
				symboleDebut = plateau.getSymboleDebut();
				
				// Jeu dans le sens des aiguilles d'une montre.
				for (int i = premier + 1 ; i != premier ; i++) {
					
					/* 
					 * Remise de l'indice à zéro pour faire une boucle.
					 * Ceci permet de faire jouer les joueurs dans le sens des 
					 * aiguilles d'une montre (ex: 2 - 3 - 0 - 1).
					 */
					if (i == NB_JOUEURS) { i = 0; }
					
					// Vérifie si le joueur courant est un humain.
					if (joueurs[i] instanceof Humain) {
						
						// Affichage du plateau de cartes pour aider l'humain.
						afficherPlateau(plateau, joueurs);
					}
					
					/* 
					 * Demande au joueur courant de jouer une carte selon un 
					 * symbole demandé au début du tour et le numéro du tour.
					 */
					aJouer = joueurs[i].jouerCarte(symboleDebut, noTour);
					
					// Pose la carte jouée sur le plateau.
					plateau.ajouterCarte(aJouer);
					
					/*
					 * Si le premier joueur à commencer un tour est le joueur 
					 * humain et que l'indice courant est égal à 3 alors on met 
					 * à jour l'indice à -1 pour que la condition d'arrêt de 
					 * la boucle soit fausse. Cela évite d'avoir une boucle 
					 * infinie.
					 */
					if (premier == 0 && i == 3) { i = -1; };
				}
				
				cls();    // Nettoyage de la console texte.
				
				// Affichage du plateau final au joueur humain.
				afficherPlateau(plateau, joueurs);
				
				// Vérifie si un coeur a été défaussé durant ce tour.
				coeurDefausse = plateau.avecCoeur();
				
				// Récupération de l'indice du joueur perdant.
				premier = plateau.getPerdant(joueurs);
				
				// Ajout des points aux points de la manche pour chaque joueur.
				plateau.ajouterPointsTour(joueurs);
				
				// Retire les cartes jouées. Vidage du plateau.
				plateau.retirerCartesJouees(joueurs);
				
				// Affichage d'un récapitulatif de la manche en cours.
				afficherRecapManche(joueurs, noTour, premier);
				
				noTour++;    // Incrémente le numéro du tour.
				
				/* 
				 * Demande au joueur humain d'appuyer sur entrée pour 
				 * continuer la partie en cours.
				 */
				continuer();
			}
			
			/* 
			 * Ajout des points de la manche précédente aux points totaux de 
			 * chaque joueurs de la partie.
			 */
			ajouterPointsTot(joueurs);
			
			// Affichage d'un récapitulatif de la partie en cours.
			afficherRecapPartie(joueurs);
			
			noManche++;    // Incrémente le numéro de la manche.

			/* 
			 * Demande au joueur humain d'appuyer sur entrée pour 
			 * continuer la partie en cours.
			 */
			continuer();
		}
		
		/* 
		 * Recherche le gagnant et affichage d'un message de félicitation pour 
		 * annoncer le(s) gagnant(s) de la partie avec le nombre de points.
		 */
		getGagnant(joueurs);

	}

}
