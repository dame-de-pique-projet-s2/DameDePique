/*
 * OutilCarte.java                                                   02/05/2019
 * Projet de la dame de pique | IUT de Rodez | 2018 - 2019
 */

package damedepique.general;

import java.util.ArrayList;

import damedepique.ia.IA;

/**
 * <p>
 *   TODO Faire la description de cette classe.
 * </p>
 * 
 * @author Lo�c B. | Julien B. | Margaux B. | Justine R.
 * @version 1.0
 */
public class OutilCarte {

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
		for (Carte carteCourante : mainJoueur) {
			
			/*
			 * Recherche d'une occurrence entre la carte courante de la main 
			 * du joueur et le symbole et la valeur pass�s en argument.
			 */
			if (estEgale(carteCourante, symbole, valeur)) {
				
				// Retourne la carte associ�e au symbole et � la valeur.
				return carteCourante;
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
	 *         valeur sp�cifi�s.
	 */
	public static int rechercherCarte(Joueur[] joueurs, Symbole symbole,
			                                            Valeur valeur) {
		
		// FIXME Probl�me � r�soudre, carte introuvable.
		// M�moire qui stocke les cartes dans la main du joueur courant.
		ArrayList<Carte> mainJoueurCourant;
		
		// Parcours des joueurs de la partie except� le premier joueur.
		for (int i = 1 ; i < joueurs.length ; i++) {
			
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
		
		/*
		 * Si aucun joueur n'a trouv� �t� trouv� en possession de la carte 
		 * indiqu�e alors le premier joueur est assur� de poss�der cette carte.
		 */
		return 0;    // FIXME Attention !
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
		for (Carte carteCourante : mainJoueur) {
			
			/*
			 * Recherche de toutes les cartes ayant un symbole �quivalent
			 * au symbole demand� en argument.
			 */
			if (carteCourante.getSymbole().equals(symboleDemande)) {
				cartesJouables.add(carteCourante);
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
	 * �change les trois cartes choisies par les joueurs entre eux.
	 * Dans cette m�thode, l'�change se fait vers la gauche.
	 * @param joueurs Les joueurs de la partie.
	 */
	public static void echangeGauche(Joueur[] joueurs) {
		// Demande et stocke les cartes � �changer du premier joueur.
		Carte[] cartesJ0 = ((Humain) joueurs[0]).choisirCartesAEchanger();
		
		// Demande et stocke les cartes � �changer du second joueur.
		Carte[] cartesJ1 = ((IA) joueurs[1]).choisirCartesAEchanger();
		
		// Demande et stocke les cartes � �changer du troisi�me joueur.
		Carte[] cartesJ2 = ((IA) joueurs[2]).choisirCartesAEchanger();

		// Demande et stocke les cartes � �changer du quatri�me joueur.
		Carte[] cartesJ3 = ((IA) joueurs[3]).choisirCartesAEchanger();
		
		// Parcours des tableaux de cartes � �changer.
		for (int i = 0 ; i < cartesJ0.length ; i++) {
			// joueurs[0] donne les cartes au joueurs[1].
			joueurs[1].ajouterCarte(cartesJ0[i]);
			// joueurs[1] donne les cartes au joueurs[2].
			joueurs[2].ajouterCarte(cartesJ1[i]);
			// joueurs[2] donne les cartes au joueurs[3].
			joueurs[3].ajouterCarte(cartesJ2[i]);
			// joueurs[3] donne les cartes au joueurs[0].
			joueurs[0].ajouterCarte(cartesJ3[i]);
		}
	}
	
	
	/**
	 * �change les trois cartes choisies par les joueurs entre eux.
	 * Dans cette m�thode, l'�change se fait vers la droite.
	 * @param joueurs Les joueurs de la partie.
	 */
	public static void echangeDroit(Joueur[] joueurs) {
		// Demande et stocke les cartes � �changer du premier joueur.
		Carte[] cartesJ0 = ((Humain) joueurs[0]).choisirCartesAEchanger();
		
		// Demande et stocke les cartes � �changer du second joueur.
		Carte[] cartesJ1 = ((IA) joueurs[1]).choisirCartesAEchanger();
		
		// Demande et stocke les cartes � �changer du troisi�me joueur.
		Carte[] cartesJ2 = ((IA) joueurs[2]).choisirCartesAEchanger();
		
		// Demande et stocke les cartes � �changer du quatri�me joueur.
		Carte[] cartesJ3 = ((IA) joueurs[3]).choisirCartesAEchanger();
		
		// Parcours des tableaux de cartes � �changer.
		for (int i = 0 ; i < cartesJ0.length ; i++) {
			// joueurs[0] donne les cartes au joueurs[3].
			joueurs[3].ajouterCarte(cartesJ0[i]);
			// joueurs[3] donne les cartes au joueurs[2].
			joueurs[2].ajouterCarte(cartesJ3[i]);
			// joueurs[2] donne les cartes au joueurs[1].
			joueurs[1].ajouterCarte(cartesJ2[i]);
			// joueurs[1] donne les cartes au joueurs[0].
			joueurs[0].ajouterCarte(cartesJ1[i]);
		}
	}
	
	
	/**
	 * �change les trois cartes choisies par les joueurs entre eux.
	 * Dans cette m�thode, l'�change se fait en face.
	 * @param joueurs Les joueurs de la partie.
	 */
	public static void echangeFace(Joueur[] joueurs) {
		// Demande et stocke les cartes � �changer du premier joueur.
		Carte[] cartesJ0 = ((Humain) joueurs[0]).choisirCartesAEchanger();
		
		// Demande et stocke les cartes � �changer du second joueur.
		Carte[] cartesJ1 = ((IA) joueurs[1]).choisirCartesAEchanger();
		
		// Demande et stocke les cartes � �changer du troisi�me joueur.
		Carte[] cartesJ2 = ((IA) joueurs[2]).choisirCartesAEchanger();
		
		// Demande et stocke les cartes � �changer du quatri�me joueur.
		Carte[] cartesJ3 = ((IA) joueurs[3]).choisirCartesAEchanger();
		
		// Parcours des tableaux de cartes � �changer.
		for (int i = 0 ; i < cartesJ0.length ; i++) {
			// joueurs[0] donne les cartes au joueurs[2].
			joueurs[2].ajouterCarte(cartesJ0[i]);
			// joueurs[2] donne les cartes au joueurs[0].
			joueurs[0].ajouterCarte(cartesJ2[i]);
			// joueurs[3] donne les cartes au joueurs[1].
			joueurs[1].ajouterCarte(cartesJ3[i]);
			// joueurs[1] donne les cartes au joueurs[3].
			joueurs[3].ajouterCarte(cartesJ1[i]);
		}
	}
	
	
	/**
	 * �change les cartes suivant le num�ro de la manche courante.
	 * Le sens des �changes sont d�finis par rapport au num�ro de la manche.
	 * @param joueurs Les joueurs de la partie.
	 * @param noManche Le num�ro de la manche de la partie.
	 */
	public static void echangerCartes(Joueur[] joueurs, int noManche) {
		System.out.println("D�but de l'�change des cartes !\n"
				           + "********************************");
		
		if (noManche % 4 == 0) {
			// �change des cartes vers le joueur positionn� � gauche. 
			echangeGauche(joueurs);
			System.out.println("L'�change des cartes est termin� !");
			
			// Tri la main du joueur apr�s l'�change des cartes.
			trierMains(joueurs);
		} else if (noManche % 4 == 1) {
			// �change des cartes vers le joueur positionn� � droite.
			echangeDroit(joueurs);
			System.out.println("L'�change des cartes est termin� !");
			
			// Tri la main du joueur apr�s l'�change des cartes.
			trierMains(joueurs);
		} else if (noManche % 4 == 2) {
			// �change des cartes vers le joueur positionn� en face.
			echangeFace(joueurs);
			System.out.println("L'�change des cartes est termin� !");
			
			// Tri la main du joueur apr�s l'�change des cartes.
			trierMains(joueurs);
		} else {
			System.out.println("Il n'y a pas d'�change de cartes ce tour !");
		}
	}
	
	
	/**
	 * Tri les cartes dans la main des joueurs pass�s en argument.
	 * @param joueurs Les joueurs de la partie.
	 */
	public static void trierMains(Joueur[] joueurs) {
		// Parcours des joueurs de la partie.
		for (Joueur joueurCourant : joueurs) {
			
			// Tri de la main du joueur courant.
			joueurCourant.trierMain();
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
