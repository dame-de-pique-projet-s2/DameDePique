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
 *   TODO Faire la description de cette classe.
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
		joueurs[0] = new Humain();
		
		// Création de trois joueurs intelligences artificielles indépendantes.
		for (int i = 1 ; i < NB_JOUEURS ; i++) {
			joueurs[i] = new IA();
		}
		
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
		
		// Affiche la liste des pseudonymes des joueurs de la partie.
		afficherJoueurs(joueurs);
		
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
			
			afficherNumeroManche(noManche);
			
			while (!finManche(joueurs[0])) {
				afficherNumeroTour(noTour);

				if (noTour == 0) {
					premier = rechercherCarte(joueurs, Symbole.Trefle, 
							                           Valeur.Deux);
					aJouer = joueurs[premier].jouerDeuxTrefle();
				} else {
					aJouer = joueurs[premier].jouerCarte(coeurDefausse);
				}
				
				// Pose la carte jouée sur le plateau.
				plateau.ajouterCarte(aJouer);
				
				// Récupération du symbole de la première carte posée.
				symboleDebut = plateau.getSymboleDebut();
				
				// Jeu dans le sens des aiguilles d'une montre.
				for (int i = premier + 1 ; i != premier ; i++) {
					if (i == NB_JOUEURS) { i = 0; }
						
					if (joueurs[i] instanceof Humain) {
						afficherPlateauActuel(plateau);
					}
					
					aJouer = joueurs[i].jouerCarte(symboleDebut, noTour);
					
					// Pose la carte jouée sur le plateau.
					plateau.ajouterCarte(aJouer);
					
					// TODO A améliorer.
					if (premier == 0 && i == 3) { i = -1; };
				}
				
				afficherPlateauFinal(plateau);
				
				coeurDefausse = plateau.avecCoeur();
				
				premier = plateau.getPerdant(joueurs);
				
				plateau.ajouterPointsTour(joueurs);
				
				plateau.retirerCartesJouees(joueurs);
				
				afficherRecapManche(joueurs, noTour, premier);
				
				noTour++;    // Incrémente le numéro du tour.
			}
			
			ajouterPointsTot(joueurs);
			
			afficherRecapPartie(joueurs, noManche);
			
			noManche++;    // Incrémente le numéro de la manche.

		}
		
		getGagnant(joueurs);

	}

}
