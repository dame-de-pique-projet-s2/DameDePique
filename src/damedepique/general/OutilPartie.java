/*
 * OutilPartie.java                                                  30/04/2019
 * Projet de la dame de pique | IUT de Rodez | 2018 - 2019
 */

package damedepique.general;

import java.util.ArrayList;

/**
 * 
 * @author Julien B.
 * @version 1.0
 */
public class OutilPartie {

	/**
	 * D�termine si une partie est finie ou non.
	 * @param joueurs Les joueurs de la partie.
	 * @return Vrai si la partie est finie (un joueur de la partie a d�pass� 
	 *         les 100 points) sinon faux.
	 */
	public static boolean finPartie(Joueur[] joueurs) {
		// Parcours des quatre joueurs de la partie.
		for (int i = 0 ; i < joueurs.length ; i++) {
			
			// V�rifie si un joueur a d�pass� 100 points ou non
			if (joueurs[i].getPoints() >= 100) {
				
				// Retourne vrai au premier joueur qui a d�pass� 100 points.
				return true;
			}
		}
		
		// Retourne faux si aucun joueur n'a d�pass� 100 points.
		return false;
	}
	
	
	/**
	 * D�termine si une manche est finie ou non.
	 * La v�rification n'est effectu�e que sur un seul joueur de la partie car 
	 * � chaque manche les joueurs ont toujours le m�me nombre de carte(s).
	 * @param joueur Un joueur de la partie.
	 * @return Vrai si la manche est finie (plus de cartes dans la main du 
	 *         joueur sp�cifi�) sinon faux.
	 */
	public static boolean finManche(Joueur joueur) {
		// V�rifie si la main du joueur est vide ou non.
		if (joueur.getMain().isEmpty()) {
			return true;    // Retourne vrai si la main du joueur est vide.
		}
		
		return false;    // Retourne faux si la main du joueur n'est pas vide.
	}
	
	
	/**
	 * V�rifie si une carte donn�e est le deux de tr�fle ou non.
	 * @param aVerifier La carte � v�rifier.
	 * @return Vrai si la carte donn�e est le deux de tr�fle sinon faux.
	 */
	public static boolean estDeuxTrefle(Carte aVerifier) {
		// TODO Faire les commentaires.
		if (aVerifier.getValeur().equals(Valeur.Deux) 
			&& aVerifier.getCouleur().equals(Couleur.Trefle)) {
			
			return true;
		}
		
		return false;
	}
	
	
	/**
	 * Recherche le joueur poss�dant le deux de tr�fle.
	 * @param joueurs Les joueurs de la partie.
	 * @return Le joueur poss�dant le deux de tr�fle dans sa main de d�part.
	 */
	public static Joueur rechercherDeuxTrefle(Joueur[] joueurs) {
		// TODO Optimiser l'algorithme et commenter.
		Joueur joueur = joueurs[0];
		
		ArrayList<Carte> mainCourante;
		int tailleMain;
		
		for (int i = 1 ; i < joueurs.length ; i++) {
			mainCourante = joueurs[i].getMain();
			tailleMain = mainCourante.size();
			for (int j = 0 ; j < tailleMain ; j++) {
				if (estDeuxTrefle(mainCourante.get(j))) {
					return joueurs[j];
				}
			}
		}
		
		return joueur;
	}
	
}
