/*
 * OutilPartie.java                                                  30/04/2019
 * Projet de la dame de pique | IUT de Rodez | 2018 - 2019
 */

package damedepique.general;

import damedepique.general.Plateau;
import damedepique.general.Joueur;

/**
 * <p>
 *   Classe utilitaire comportant les m�thodes associ�es au d�roulement de la
 *   partie de cartes.
 * </p>
 * 
 * @author Lo�c B. Julien B. Margaux B. Justine R.
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
		boolean finPartie = false;
		// Parcours des quatre joueurs de la partie.
		for (int i = 0 ; i < joueurs.length ; i++) {
			
			// V�rifie si un joueur a d�pass� 100 points ou non
			if (joueurs[i].getPoints() >= 100) {
				
				// Retourne vrai au premier joueur qui a d�pass� 100 points.
				finPartie = true;
			}
		}
		
		// Retourne faux si aucun joueur n'a d�pass� 100 points.
		return finPartie;
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
		boolean finManche = false;
		// V�rifie si la main du joueur est vide ou non.
		if (joueur.getMain().isEmpty()) {
			finManche = true;    // Retourne vrai si la main du joueur est vide.
		}
		
		return finManche;    // Retourne faux si la main du joueur n'est pas vide.
	}
	
	
	/**
	 * D�termine si un tour est termin� ou non.
	 * @param plateau Le plateau de la partie.
	 * @return Vrai si le tour est fini (exactement quatre cartes dispos�es sur 
	 *         le plateau de jeu) sinon faux.
	 */
	public static boolean finTour(Plateau plateau) {
		boolean finTour = false;
		// V�rifie si le plateau contient exactement quatre cartes.
		if (plateau.getCartes().size() == 4) {
			// Retourne vrai si le plateau dispose d'exactement quatre cartes.
			finTour = true;
		}
		
		return finTour;    // Retourne faux si le plateau n'a pas quatre cartes.
	}	
	
}
