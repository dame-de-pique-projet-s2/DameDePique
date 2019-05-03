/*
 * OutilCarte.java                                                   02/05/2019
 * Projet de la dame de pique | IUT de Rodez | 2018 - 2019
 */

package damedepique.general;

import java.util.ArrayList;

/**
 * <p>
 *   
 * </p>
 * 
 * @author Julien B.
 * @version 1.0
 */
public class OutilCarte {

	/**
	 * Récupère une carte dans la main d'un joueur en fonction de son symbole 
	 * et de sa valeur.
	 * @param joueur Le joueur visé par la recherche.
	 * @param symbole Le symbole à chercher dans la main du joueur.
	 * @param valeur La valeur à chercher dans la main du joueur.
	 * @return Une carte si le symbole et la valeur correspondent à une carte 
	 *         dans la main du joueur sinon la méthode renvoie la valeur null 
	 *         qui signifie que le joueur ne possède pas la carte associée au 
	 *         symbole et à la valeur spécifiés dans sa main de jeu.
	 */
	public static Carte recuperationCarte(Joueur joueur, Symbole symbole, 
			                                             Valeur valeur) {
		
		// Stocke les cartes dans la main du joueur spécifié.
		ArrayList<Carte> mainJoueur = joueur.getMain();
		
		// Parcours des cartes dans la main du joueur passé en argument.
		for (int i = 0 ; i < mainJoueur.size() ; i++) {
			
			/*
			 * Recherche d'une occurrence entre la carte courante de la main 
			 * du joueur et le symbole et la valeur passés en argument.
			 */
			if (estEgale(mainJoueur.get(i), symbole, valeur)) {
				
				// Retourne la carte associée au symbole et à la valeur.
				return mainJoueur.get(i);
			}
		}
		
		return null;    // Retourne null si aucune occurrence n'a été trouvé.
	}
	
	
	/**
	 * Recherche l'indice d'un joueur ayant une carte spécifique.
	 * @param joueurs Les joueurs de la partie.
	 * @param symbole Le symbole de la carte recherchée.
	 * @param valeur La valeur de la carte recherchée.
	 * @return L'indice du joueur ayant la carte associée au symbole et à la 
	 *         valeur spécifiés sinon la méthode renvoie la valeur null qui 
	 *         signifie qu'aucun joueur de la partie ne possède cette carte 
	 *         (par exemple si la carte ayant ce symbole et cette valeur a déjà 
	 *         été jouée).
	 */
	public static int rechercherCarte(Joueur[] joueurs, Symbole symbole,
			                                            Valeur valeur) {
		
		// Mémoire qui stocke les cartes dans la main du joueur courant.
		ArrayList<Carte> mainJoueurCourant;
		
		// Parcours des joueurs de la partie.
		for (int i = 0 ; i < joueurs.length ; i++) {
			
			// Stocke les cartes du joueur courant.
			mainJoueurCourant = joueurs[i].getMain();
			
			// Parcours des cartes dans la main du joueur courant.
			for (int j = 0 ; j < mainJoueurCourant.size() ; j++) {
				
				/*
				 * Recherche d'une occurrence entre la carte courante de la 
				 * main du joueur courant et le symbole et la valeur passés 
				 * en argument.
				 */
				if (estEgale(mainJoueurCourant.get(j), symbole, valeur)) {
					
					/* 
					 * Retourne l'indice du joueur possédant la carte 
					 * comportant le même symbole et la même valeur spécifiés 
					 * en argument.
					 */
					return i;
				}
			}
		}
		
		return -1;    // Retourne -1 si aucune occurrence n'a été trouvé.
	}
	
	
	/**
	 * Vérifie si une carte spécifiée possède à la fois le symbole et la 
	 * valeur passés en argument.
	 * @param aVerifier La carte à vérifier.
	 * @param symbole Le symbole à chercher.
	 * @param valeur La valeur à chercher.
	 * @return Vrai si le symbole et la valeur correspondent à la carte 
	 *         spécifiée sinon faux.
	 */
	public static boolean estEgale(Carte aVerifier, Symbole symbole, 
			                                        Valeur valeur) {
		
		/*
		 * Regarde si le symbole est égal au symbole de la carte aVerifier et 
		 * si la valeur est égale à la valeur de la carte aVerifier.
		 */
		if (aVerifier.getSymbole().equals(symbole) 
			&& aVerifier.getValeur().equals(valeur)) {
			
			// Vrai si les symboles et les valeurs correspondent.
			return true;
		}
		
		// Faux si les symboles et les valeurs ne correspondent pas.
		return false;
	}
	
	
	/**
	 * Récupère les cartes jouables par un joueur selon sa main par rapport à 
	 * un symbole demandé.
	 * @param joueur Le joueur à vérifier.
	 * @param symboleDemande Le symbole demandé au début du tour.
	 * @return La liste des cartes pouvant être jouées par le joueur.
	 */
	public static ArrayList<Carte> cartesPossibles(Joueur joueur,
			                                       Symbole symboleDemande) {
		
		// Stocke la main du joueur passé en argument.
		ArrayList<Carte> mainJoueur = joueur.getMain();
		
		// Stocke les cartes jouables que possède le joueur.
		ArrayList<Carte> cartesJouables = new ArrayList<>();
		
		// Parcours des cartes dans la main du joueur passé en argument.
		for (int i = 0 ; i < mainJoueur.size() ; i++) {
			
			/*
			 * Recherche de toutes les cartes ayant un symbole équivalent
			 * au symbole demandé en argument.
			 */
			if (mainJoueur.get(i).getSymbole().equals(symboleDemande)) {
				cartesJouables.add(mainJoueur.get(i));
			}
		}
		
		/*
		 * Si le joueur ne possède aucune carte ayant un symbole équivalent au 
		 * symbole demandé alors il peut jouer toutes les cartes présentes dans 
		 * sa main. 
		 */
		if (cartesJouables.isEmpty()) {
			return mainJoueur;
		}
		
		/* 
		 * Retourne la liste des cartes jouables par le joueur selon le 
		 * symbole demandé.
		 */
		return cartesJouables;
	}
	
	
	/**
	 * Vérifie si une carte est jouable ou non par rapport à un symbole 
	 * demandé au début d'un tour.
	 * @param joueur Le joueur à vérifier.
	 * @param symboleDemande Le symbole demandé au début d'un tour.
	 * @param carteJouee La carte jouée par le joueur spécifié.
	 * @return Vrai si la carte jouée est présente dans la liste des cartes 
	 *         jouables (même symbole que celui demandé) sinon faux.
	 */
	public static boolean estCartePossible(Joueur joueur, 
			                               Symbole symboleDemande, 
			                               Carte carteJouee) {
		
		// Liste des cartes jouables par le joueur passé en argument.
		ArrayList<Carte> cartesJouables = cartesPossibles(joueur, 
				                                          symboleDemande);
		
		// Vérifie si la carte jouée est contenue dans la liste des cartes.
		if (cartesJouables.contains(carteJouee)) {
			return true;    // Vrai si une occurrence a été trouvée.
		}
		
		return false;    // Faux si aucune occurrence n'a été trouvée.
	}
	
	
	/**
	 * @param joueurs 
	 * 
	 */
	public static void echangeGauche(Joueur[] joueurs) {
		// joueurs[0] -> joueurs[1]
		joueurs[1].ajouterCartes(joueurs[0].getCartesAEchanger());
		// joueurs[1] -> joueurs[2]
		joueurs[2].ajouterCartes(joueurs[1].getCartesAEchanger());
		// joueurs[2] -> joueurs[3]
		joueurs[3].ajouterCartes(joueurs[2].getCartesAEchanger());
		// joueurs[3] -> joueurs[0]
		joueurs[0].ajouterCartes(joueurs[3].getCartesAEchanger());
	}
	
	
	/**
	 * @param joueurs 
	 * 
	 */
	public static void echangeDroit(Joueur[] joueurs) {
		// joueurs[0] -> joueurs[3]
		joueurs[3].ajouterCartes(joueurs[0].getCartesAEchanger());
		// joueurs[3] -> joueurs[2]
		joueurs[2].ajouterCartes(joueurs[3].getCartesAEchanger());
		// joueurs[2] -> joueurs[1]
		joueurs[1].ajouterCartes(joueurs[2].getCartesAEchanger());
		// joueurs[1] -> joueurs[0]
		joueurs[0].ajouterCartes(joueurs[1].getCartesAEchanger());
	}
	
	
	/**
	 * @param joueurs 
	 * 
	 */
	public static void echangeFace(Joueur[] joueurs) {
		// joueurs[0] -> joueurs[2]
		joueurs[2].ajouterCartes(joueurs[0].getCartesAEchanger());
		// joueurs[2] -> joueurs[0]
		joueurs[0].ajouterCartes(joueurs[2].getCartesAEchanger());
		// joueurs[1] -> joueurs[3]
		joueurs[3].ajouterCartes(joueurs[1].getCartesAEchanger());
		// joueurs[3] -> joueurs[1]
		joueurs[1].ajouterCartes(joueurs[3].getCartesAEchanger());
	}
	
	
	/**
	 * 
	 * @param joueurs 
	 * @param noManche 
	 */
	public static void echangerCartes(Joueur[] joueurs, int noManche) {
		if (noManche == 0) {
			echangeGauche(joueurs);
		} else if (noManche == 1) {
			echangeDroit(joueurs);
		} else if (noManche == 2) {
			echangeFace(joueurs);
		}
	}
	
	
	/**
	 * Tri les cartes dans la main des joueurs passés en argument.
	 * @param joueurs Les joueurs de la partie dont il faut trier les mains.
	 */
	public static void trierMains(Joueur[] joueurs) {
		// Parcours des joueurs de la partie.
		for (int i = 0 ; i < joueurs.length ; i++) {
			
			// Tri de la main du joueur courant.
			joueurs[i].trierMain();
		}
	}
	
	
	/**
	 * Affiche une liste de cartes.
	 * @param cartes La liste des cartes à afficher.
	 */
	public static void afficherCartes(ArrayList<Carte> cartes) {
		String listeCartes = "";
		
		for (Carte carte : cartes) {
			listeCartes += "    => " + carte.toString() + "\n";
		}
		
		System.out.println(listeCartes);
	}
	
}
