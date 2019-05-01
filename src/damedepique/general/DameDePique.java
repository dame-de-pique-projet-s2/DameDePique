/*
 * DameDePique.java                                                  28/04/2019
 * Projet de la dame de pique | IUT de Rodez | 2018 - 2019
 */

package damedepique.general;

import static damedepique.general.OutilPartie.*;
import damedepique.ia.IA;

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
		
		Paquet paquet = new Paquet();
		paquet.creer();
		
		Plateau plateau = new Plateau();
		
		Joueur[] joueurs = new Joueur[NB_JOUEURS];
		joueurs[0] = new Humain();    // Cr�ation d'un joueur humain.
		for (int i = 1 ; i < NB_JOUEURS ; i++) {
			joueurs[i] = new IA();    // Cr�ation de trois joueurs IA.
		}
		
		// L'indice correspond � la place du joueur.
		int[] pointsManche = new int[NB_JOUEURS];
		
		// A chaque nouvelle 
		int numeroManche = 0;
		
		while (!finPartie(joueurs)) {
			paquet.melanger();
			paquet.distribuer(joueurs);
			
			// TODO Faire le tri qu'une fois. Condition if numManche == 0
			for (int k = 0 ; k < NB_JOUEURS ; k++) {
				joueurs[k].trierMain();
			}
			
			while (!finManche(joueurs[0])) {
				if (numeroManche != 0) {
					
					// Faire un syst�me de r�cup�ration du tour pr�c�dent.
					
				} else {
					
					// Cherche le joueur ayant le deux de tr�fle.
					
				}
				
				// TODO �change des trois cartes.
				
				// TODO Faire un autre tri qu'une fois. Condition if numTour == 0
				
				while (!finTour(plateau)) {
					// TODO Ne pas commencer par un coeur.
					System.out.println(joueurs[0]);
					joueurs[0].jouerCarte(Symbole.Trefle);
					// TODO Faire attention avec la valeur quatre ne marche pas.
					// System.out.println(plateau);
					// System.out.println(joueurs[0]);
					// Carte carte = joueurs[0].jouerCarte();
					// plateau.ajouterCarte(carte);
					// joueurs[0].retirerCarte(carte);
					// System.out.println(joueurs[0]);
					// System.out.println(plateau);
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
