/*
 * OutilCarte.java                                                   11/05/2019
 * Projet de la dame de pique | IUT de Rodez | 2018 - 2019
 */

package damedepique.general;

import java.util.ArrayList;

/**
 * <p>
 *   Cette classe contient des outils concernant la manipulation de cartes.
 * </p>
 * 
 * @author Julien B.
 * @author Lo�c B.
 * @author Margaux B.
 * @author Justine R.
 * 
 * @version 1.0
 */
public class OutilCarte {
	
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
				if (mainJoueurCourant.get(j).getSymbole().equals(symbole) 
					&& mainJoueurCourant.get(j).getValeur().equals(valeur)) {
					
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
		return 0;
	}
	
	
	/**
	 * R�cup�re les cartes jouables par un joueur en prenant en compte si un 
	 * coeur a d�j� �t� d�fauss� ou non.
	 * @param joueur Le joueur � v�rifier.
	 * @param coeurDefausse Vrai si un coeur a d�j� �t� d�fauss� sinon faux.
	 * @return La liste des cartes pouvant �tre jou�es par le joueur.
	 */
	public static ArrayList<Carte> cartesPossibles(Joueur joueur,
			                                       boolean coeurDefausse) {
		
		// Copie de la main du joueur sp�cifi� en argument.
		ArrayList<Carte> cartesJouables = new ArrayList<>();
		for (Carte carte : joueur.getMain()) {
			cartesJouables.add(carte);
		}
		
		// Nombre de cartes supprim�es dans la copie de la main du joueur.
		int nbSupp = 0;
		
		// Taille fixe de la main du joueur.
		int tailleMain = cartesJouables.size();
		
		// V�rifie si un coeur a d�j� �t� d�fauss� ou non.
		if (!coeurDefausse) {
			
			/*
			 * Si aucune carte poss�dant le symbole coeur n'a �t� d�fauss� 
			 * alors on parcours toute la main du joueur sp�cifi� afin de 
			 * retirer les cartes disposant d'un symbole coeur.
			 */
			for (int i = 0 ; i < tailleMain ; i++) {
				
				// V�rifie si la carte courante poss�de un coeur en symbole.
				if (cartesJouables.get(i - nbSupp).getSymbole()
						                          .equals(Symbole.Coeur)) {
					
					// Retire la carte des cartes possibles si c'est un coeur.
					cartesJouables.remove(i - nbSupp);
					nbSupp++;    // Incr�mente le nombre de suppressions.
				}
			}
		}
		
		/*
		 * Si le joueur ne poss�de aucun autre symbole que du coeur, ou 
		 * autrement dit si il poss�de que du coeur et qu'aucune carte ayant 
		 * le symbole coeur n'a �t� d�fauss� alors le joueur peut jouer du 
		 * coeur. Attention, ceci est un cas particulier. 
		 */
		if (cartesJouables.isEmpty()) {
			return joueur.getMain();
		}
 		
		// Retourne la liste des cartes jouables par le joueur.
		return cartesJouables;
	}
	
	
	/**
	 * R�cup�re les cartes jouables par un joueur selon sa main par rapport � 
	 * un symbole demand�.
	 * @param joueur Le joueur � v�rifier.
	 * @param symboleDemande Le symbole demand� au d�but du tour.
	 * @param noTour Le num�ro du tour de la partie.
	 * @return La liste des cartes pouvant �tre jou�es par le joueur.
	 */
	public static ArrayList<Carte> cartesPossibles(Joueur joueur,
			                                       Symbole symboleDemande,
			                                       int noTour) {
		
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
		
		if (noTour == 0) {
			for (Carte carteJouable : cartesJouables) {
				if (carteJouable.getSymbole().equals(Symbole.Coeur) 
					|| (carteJouable.getSymbole().equals(Symbole.Pique) 
						&& carteJouable.getValeur().equals(Valeur.Dame))) {
					
					cartesJouables.remove(carteJouable);
				}
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
	 * �change les trois cartes choisies par les joueurs entre eux.
	 * Dans cette m�thode, l'�change se fait vers la gauche.
	 * @param joueurs Les joueurs de la partie.
	 */
	public static void echangeGauche(Joueur[] joueurs) {
		// Demande et stocke les cartes � �changer du premier joueur.
		Carte[] cartesJ0 = joueurs[0].choisirCartesAEchanger();
		
		// Demande et stocke les cartes � �changer du second joueur.
		Carte[] cartesJ1 = joueurs[1].choisirCartesAEchanger();
		
		// Demande et stocke les cartes � �changer du troisi�me joueur.
		Carte[] cartesJ2 = joueurs[2].choisirCartesAEchanger();

		// Demande et stocke les cartes � �changer du quatri�me joueur.
		Carte[] cartesJ3 = joueurs[3].choisirCartesAEchanger();
		
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
		Carte[] cartesJ0 = joueurs[0].choisirCartesAEchanger();
		
		// Demande et stocke les cartes � �changer du second joueur.
		Carte[] cartesJ1 = joueurs[1].choisirCartesAEchanger();
		
		// Demande et stocke les cartes � �changer du troisi�me joueur.
		Carte[] cartesJ2 = joueurs[2].choisirCartesAEchanger();
		
		// Demande et stocke les cartes � �changer du quatri�me joueur.
		Carte[] cartesJ3 = joueurs[3].choisirCartesAEchanger();
		
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
		Carte[] cartesJ0 = joueurs[0].choisirCartesAEchanger();
		
		// Demande et stocke les cartes � �changer du second joueur.
		Carte[] cartesJ1 = joueurs[1].choisirCartesAEchanger();
		
		// Demande et stocke les cartes � �changer du troisi�me joueur.
		Carte[] cartesJ2 = joueurs[2].choisirCartesAEchanger();
		
		// Demande et stocke les cartes � �changer du quatri�me joueur.
		Carte[] cartesJ3 = joueurs[3].choisirCartesAEchanger();
		
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
		
		System.out.println("Voici votre nouvelle main : ");
		afficherCartes(joueurs[0].getMain());
	}
	
	
	/**
	 * Recherche l'indice du deux de tr�fle dans la main d'un joueur.
	 * @param joueur Le joueur suppos� avoir le deux de tr�fle.
	 * @return Un entier correspondant � l'indice du deux de tr�fle.
	 *         Si le joueur sp�cifi� ne poss�de pas le deux de tr�fle dans sa 
	 *         main alors l'entier -1 est renvoy�.
	 */
	public static int indiceDeuxTrefle(Joueur joueur) {		
		// Parcours de la main du joueur sp�cifi� en argument.
		for (Carte carte : joueur.getMain()) {
			
			/* 
			 * V�rifie si la carte courante poss�de le symbole tr�fle et 
			 * la valeur deux.
			 */
			if (carte.getSymbole().equals(Symbole.Trefle) 
				&& carte.getValeur().equals(Valeur.Deux)) {
				
				// Retourne l'indice de la carte cherch�e.
				return joueur.getMain().indexOf(carte);
			}
		}
		
		return -1;    // Retourne la valeur -1 en cas d'absence d'occurrence.
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
			listeCartes += "=> " + carte.toString() + "\n";
		}
		
		System.out.println(listeCartes);
	}
	
	
	/**
	 * 
	 * @param cartes
	 */
	public static void afficherCartesIndice(ArrayList<Carte> cartes) {
		String listeCartes = "";
		
		for (int i = 0 ; i < cartes.size() ; i++) {
			listeCartes += "(" + i + ") => " + cartes.get(i).toString() + "\n";
		}
		
		System.out.println(listeCartes);
	}
	
}
