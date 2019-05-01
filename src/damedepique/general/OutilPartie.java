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

	/* * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * *
	 * * * * * * * * * * OUTILS PARTIE / MANCHE / TOUR * * * * * * * * * * *
	 * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * */
	
	/**
	 * Détermine si une partie est finie ou non.
	 * @param joueurs Les joueurs de la partie.
	 * @return Vrai si la partie est finie (un joueur de la partie a dépassé 
	 *         les 100 points) sinon faux.
	 */
	public static boolean finPartie(Joueur[] joueurs) {
		// Parcours des quatre joueurs de la partie.
		for (int i = 0 ; i < joueurs.length ; i++) {
			
			// Vérifie si un joueur a dépassé 100 points ou non
			if (joueurs[i].getPoints() >= 100) {
				
				// Retourne vrai au premier joueur qui a dépassé 100 points.
				return true;
			}
		}
		
		// Retourne faux si aucun joueur n'a dépassé 100 points.
		return false;
	}
	
	
	/**
	 * Détermine si une manche est finie ou non.
	 * La vérification n'est effectuée que sur un seul joueur de la partie car 
	 * à chaque manche les joueurs ont toujours le même nombre de carte(s).
	 * @param joueur Un joueur de la partie.
	 * @return Vrai si la manche est finie (plus de cartes dans la main du 
	 *         joueur spécifié) sinon faux.
	 */
	public static boolean finManche(Joueur joueur) {
		// Vérifie si la main du joueur est vide ou non.
		if (joueur.getMain().isEmpty()) {
			return true;    // Retourne vrai si la main du joueur est vide.
		}
		
		return false;    // Retourne faux si la main du joueur n'est pas vide.
	}
	
	
	/**
	 * Détermine si un tour est terminé ou non.
	 * @param plateau Le plateau de la partie.
	 * @return Vrai si le tour est fini (exactement quatre cartes disposées sur 
	 *         le plateau de jeu) sinon faux.
	 */
	public static boolean finTour(Plateau plateau) {
		// Vérifie si le plateau contient exactement quatre cartes.
		if (plateau.getCartes().size() == 4) {
			
			// Retourne vrai si le plateau dispose d'exactement quatre cartes.
			return true;
		}
		
		return false;    // Retourne faux si le plateau n'a pas quatre cartes.
	}
	
	
	/* * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * *
	 * * * * * * * * * * * * * * OUTILS CARTES * * * * * * * * * * * * * * *
	 * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * */
	
	/**
	 * 
	 * @param joueur
	 * @param symbole
	 * @param valeur
	 * @return null si la carte n'est pas dans la main du joueur.
	 */
	public static Carte recuperationCarte(Joueur joueur, Symbole symbole, 
			                                             Valeur valeur) {
		
		ArrayList<Carte> mainJoueur = joueur.getMain();
		
		for (int i = 0 ; i < mainJoueur.size() ; i++) {
			if (carteEgale(mainJoueur.get(i), symbole, valeur)) {
				return mainJoueur.get(i);
			}
		}
		
		return null;
	}
	
	
	/**
	 * 
	 * @param joueurs
	 * @param symbole 
	 * @param valeur 
	 * @return null si il n'y a aucun joueur qui ne possède la carte 
	 */
	public static Joueur rechercherCarte(Joueur[] joueurs, Symbole symbole,
			                                               Valeur valeur) {
		
		Joueur joueur = joueurs[0];
		
		ArrayList<Carte> mainJoueurCourant;
		
		for (int i = 1 ; i < joueurs.length ; i++) {
			mainJoueurCourant = joueurs[i].getMain();
			for (int j = 0 ; j < mainJoueurCourant.size() ; j++) {
				if (carteEgale(mainJoueurCourant.get(j), symbole, valeur)) {
					return joueurs[i];
				}
			}
		}
		
		return joueur;
	}
	
	
	/**
	 * 
	 * @param joueur 
	 * @param symbole 
	 * @return  
	 */
	public static boolean rechercherSymbole(Joueur joueur, Symbole symbole) {
		ArrayList<Carte> mainJoueur = joueur.getMain();
		
		for (int i = 0 ; i < mainJoueur.size() ; i++) {
			if (mainJoueur.get(i).getSymbole().equals(symbole)) {
				return true;
			}
		}
		
		return false;
	}
	
	
	/**
	 * 
	 * @param aVerifier 
	 * @param symbole 
	 * @param valeur 
	 * @return 
	 */
	public static boolean carteEgale(Carte aVerifier, Symbole symbole, 
			                                          Valeur valeur) {
		
		if (aVerifier.getSymbole().equals(symbole) 
			&& aVerifier.getValeur().equals(valeur)) {
			
			return true;
		}
		
		return false;
	}
	
	
	/* * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * *
	 * * * * * * * * * * * * * GESTION CLOCHE BOIS * * * * * * * * * * * * *
	 * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * */
	
	
	
}
