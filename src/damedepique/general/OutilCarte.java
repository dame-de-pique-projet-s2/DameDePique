/*
 * OutilCarte.java                                                   02/05/2019
 * Projet de la dame de pique | IUT de Rodez | 2018 - 2019
 */

package damedepique.general;

import java.util.ArrayList;

import damedepique.ia.IA;

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
	 * R�cup�re une carte dans la main d'un joueur en fonction de son symbole 
	 * et de sa valeur.
	 * @param joueur Le joueur vis� par la recherche.
	 * @param symbole Le symbole � chercher dans la main du joueur.
	 * @param valeur La valeur � chercher dans la main du joueur.
	 * @return Une carte si le symbole et la valeur correspondent � une carte 
	 *         dans la main du joueur sinon la m�thode renvoie la valeur null 
	 *         qui signifie que le joueur ne poss�de pas la carte associ�e au 
	 *         symbole et � la valeur sp�cifi�s dans sa main de jeu.
	 */
	public static Carte recuperationCarte(Joueur joueur, Symbole symbole, 
			                                             Valeur valeur) {
		
		// Stocke les cartes dans la main du joueur sp�cifi�.
		ArrayList<Carte> mainJoueur = joueur.getMain();
		
		// Parcours des cartes dans la main du joueur pass� en argument.
		for (int i = 0 ; i < mainJoueur.size() ; i++) {
			
			/*
			 * Recherche d'une occurrence entre la carte courante de la main 
			 * du joueur et le symbole et la valeur pass�s en argument.
			 */
			if (estEgale(mainJoueur.get(i), symbole, valeur)) {
				
				// Retourne la carte associ�e au symbole et � la valeur.
				return mainJoueur.get(i);
			}
		}
		
		return null;    // Retourne null si aucune occurrence n'a �t� trouv�.
	}
	
	
	/**
	 * Recherche l'indice d'un joueur ayant une carte sp�cifique.
	 * @param joueurs Les joueurs de la partie.
	 * @param symbole Le symbole de la carte recherch�e.
	 * @param valeur La valeur de la carte recherch�e.
	 * @return L'indice du joueur ayant la carte associ�e au symbole et � la 
	 *         valeur sp�cifi�s sinon la m�thode renvoie la valeur null qui 
	 *         signifie qu'aucun joueur de la partie ne poss�de cette carte 
	 *         (par exemple si la carte ayant ce symbole et cette valeur a d�j� 
	 *         �t� jou�e).
	 */
	public static int rechercherCarte(Joueur[] joueurs, Symbole symbole,
			                                            Valeur valeur) {
		
		// M�moire qui stocke les cartes dans la main du joueur courant.
		ArrayList<Carte> mainJoueurCourant;
		
		// Parcours des joueurs de la partie.
		for (int i = 0 ; i < joueurs.length ; i++) {
			
			// Stocke les cartes du joueur courant.
			mainJoueurCourant = joueurs[i].getMain();
			
			// Parcours des cartes dans la main du joueur courant.
			for (int j = 0 ; j < mainJoueurCourant.size() ; j++) {
				
				/*
				 * Recherche d'une occurrence entre la carte courante de la 
				 * main du joueur courant et le symbole et la valeur pass�s 
				 * en argument.
				 */
				if (estEgale(mainJoueurCourant.get(j), symbole, valeur)) {
					
					/* 
					 * Retourne l'indice du joueur poss�dant la carte 
					 * comportant le m�me symbole et la m�me valeur sp�cifi�s 
					 * en argument.
					 */
					return i;
				}
			}
		}
		
		return -1;    // Retourne -1 si aucune occurrence n'a �t� trouv�.
	}
	
	
	/**
	 * V�rifie si une carte sp�cifi�e poss�de � la fois le symbole et la 
	 * valeur pass�s en argument.
	 * @param aVerifier La carte � v�rifier.
	 * @param symbole Le symbole � chercher.
	 * @param valeur La valeur � chercher.
	 * @return Vrai si le symbole et la valeur correspondent � la carte 
	 *         sp�cifi�e sinon faux.
	 */
	public static boolean estEgale(Carte aVerifier, Symbole symbole, 
			                                        Valeur valeur) {
		
		/*
		 * Regarde si le symbole est �gal au symbole de la carte aVerifier et 
		 * si la valeur est �gale � la valeur de la carte aVerifier.
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
	 * R�cup�re les cartes jouables par un joueur selon sa main par rapport � 
	 * un symbole demand�.
	 * @param joueur Le joueur � v�rifier.
	 * @param symboleDemande Le symbole demand� au d�but du tour.
	 * @return La liste des cartes pouvant �tre jou�es par le joueur.
	 */
	public static ArrayList<Carte> cartesPossibles(Joueur joueur,
			                                       Symbole symboleDemande) {
		
		// Stocke la main du joueur pass� en argument.
		ArrayList<Carte> mainJoueur = joueur.getMain();
		
		// Stocke les cartes jouables que poss�de le joueur.
		ArrayList<Carte> cartesJouables = new ArrayList<>();
		
		// Parcours des cartes dans la main du joueur pass� en argument.
		for (int i = 0 ; i < mainJoueur.size() ; i++) {
			
			/*
			 * Recherche de toutes les cartes ayant un symbole �quivalent
			 * au symbole demand� en argument.
			 */
			if (mainJoueur.get(i).getSymbole().equals(symboleDemande)) {
				cartesJouables.add(mainJoueur.get(i));
			}
		}
		
		/*
		 * Si le joueur ne poss�de aucune carte ayant un symbole �quivalent au 
		 * symbole demand� alors il peut jouer toutes les cartes pr�sentes dans 
		 * sa main. 
		 */
		if (cartesJouables.isEmpty()) {
			return mainJoueur;
		}
		
		/* 
		 * Retourne la liste des cartes jouables par le joueur selon le 
		 * symbole demand�.
		 */
		return cartesJouables;
	}
	
	
	/**
	 * V�rifie si une carte est jouable ou non par rapport � un symbole 
	 * demand� au d�but d'un tour.
	 * @param joueur Le joueur � v�rifier.
	 * @param symboleDemande Le symbole demand� au d�but d'un tour.
	 * @param carteJouee La carte jou�e par le joueur sp�cifi�.
	 * @return Vrai si la carte jou�e est pr�sente dans la liste des cartes 
	 *         jouables (m�me symbole que celui demand�) sinon faux.
	 */
	public static boolean estCartePossible(Joueur joueur, 
			                               Symbole symboleDemande, 
			                               Carte carteJouee) {
		
		// Liste des cartes jouables par le joueur pass� en argument.
		ArrayList<Carte> cartesJouables = cartesPossibles(joueur, 
				                                          symboleDemande);
		
		// V�rifie si la carte jou�e est contenue dans la liste des cartes.
		if (cartesJouables.contains(carteJouee)) {
			return true;    // Vrai si une occurrence a �t� trouv�e.
		}
		
		return false;    // Faux si aucune occurrence n'a �t� trouv�e.
	}
	
	
	/**
	 * �change des cartes choisies par les joueurs entre eux.
	 * Dans ce m�thode, l'�change se fait vers la gauche.
	 * @param joueurs Les joueurs de la partie.
	 */
	public static void echangeGauche(Joueur[] joueurs) {
		Carte[] cartesJ0 = ((Humain) joueurs[0]).choisirCartesAEchanger();
		Carte[] cartesJ1 = ((IA) joueurs[1]).choisirCartesAEchanger();
		Carte[] cartesJ2 = ((IA) joueurs[2]).choisirCartesAEchanger();
		Carte[] cartesJ3 = ((IA) joueurs[3]).choisirCartesAEchanger();
		
		for (int i = 0 ; i < cartesJ0.length ; i++) {
			joueurs[1].ajouterCarte(cartesJ0[i]);
			joueurs[2].ajouterCarte(cartesJ1[i]);
			joueurs[3].ajouterCarte(cartesJ2[i]);
			joueurs[0].ajouterCarte(cartesJ3[i]);
		}
	}
	
	
	/**
	 * @param joueurs 
	 * 
	 */
	public static void echangeDroit(Joueur[] joueurs) {
		Carte[] cartesJ0 = ((Humain) joueurs[0]).choisirCartesAEchanger();
		Carte[] cartesJ1 = ((IA) joueurs[1]).choisirCartesAEchanger();
		Carte[] cartesJ2 = ((IA) joueurs[2]).choisirCartesAEchanger();
		Carte[] cartesJ3 = ((IA) joueurs[3]).choisirCartesAEchanger();
		
		for (int i = 0 ; i < cartesJ0.length ; i++) {
			joueurs[3].ajouterCarte(cartesJ0[i]);
			joueurs[2].ajouterCarte(cartesJ3[i]);
			joueurs[1].ajouterCarte(cartesJ2[i]);
			joueurs[0].ajouterCarte(cartesJ1[i]);
		}
	}
	
	
	/**
	 * @param joueurs 
	 * 
	 */
	public static void echangeFace(Joueur[] joueurs) {
		Carte[] cartesJ0 = ((Humain) joueurs[0]).choisirCartesAEchanger();
		Carte[] cartesJ1 = ((IA) joueurs[1]).choisirCartesAEchanger();
		Carte[] cartesJ2 = ((IA) joueurs[2]).choisirCartesAEchanger();
		Carte[] cartesJ3 = ((IA) joueurs[3]).choisirCartesAEchanger();
		
		for (int i = 0 ; i < cartesJ0.length ; i++) {
			joueurs[2].ajouterCarte(cartesJ0[i]);
			joueurs[0].ajouterCarte(cartesJ2[i]);
			joueurs[1].ajouterCarte(cartesJ3[i]);
			joueurs[3].ajouterCarte(cartesJ1[i]);
		}
	}
	
	
	/**
	 * 
	 * @param joueurs 
	 * @param noManche 
	 */
	public static void echangerCartes(Joueur[] joueurs, int noManche) {
		System.out.println("D�but de l'�change des cartes !");
		
		if (noManche == 0) {
			echangeGauche(joueurs);
			System.out.println("L'�change des cartes est termin� !");
			trierMains(joueurs);
		} else if (noManche == 1) {
			echangeDroit(joueurs);
			System.out.println("L'�change des cartes est termin� !");
			trierMains(joueurs);
		} else if (noManche == 2) {
			echangeFace(joueurs);
			System.out.println("L'�change des cartes est termin� !");
			trierMains(joueurs);
		} else {
			System.out.println("Il n'y a pas d'�change de cartes ce tour !");
		}
	}
	
	
	/**
	 * Tri les cartes dans la main des joueurs pass�s en argument.
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
	 * @param cartes La liste des cartes � afficher.
	 */
	public static void afficherCartes(ArrayList<Carte> cartes) {
		String listeCartes = "";
		
		for (Carte carte : cartes) {
			listeCartes += "    => " + carte.toString() + "\n";
		}
		
		System.out.println(listeCartes);
	}
	
}
