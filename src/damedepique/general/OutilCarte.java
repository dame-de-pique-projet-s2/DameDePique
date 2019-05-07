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
 * @author Loïc B. | Julien B. | Margaux B. | Justine R.
 * @version 1.0
 */
public class OutilCarte {

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
		for (Carte carteCourante : mainJoueur) {
			
			/*
			 * Recherche d'une occurrence entre la carte courante de la main 
			 * du joueur et le symbole et la valeur passés en argument.
			 */
			if (estEgale(carteCourante, symbole, valeur)) {
				
				// Retourne la carte associée au symbole et à la valeur.
				return carteCourante;
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
	 *         valeur spécifiés.
	 */
	public static int rechercherCarte(Joueur[] joueurs, Symbole symbole,
			                                            Valeur valeur) {
		
		// FIXME Problème à résoudre, carte introuvable.
		// Mémoire qui stocke les cartes dans la main du joueur courant.
		ArrayList<Carte> mainJoueurCourant;
		
		// Parcours des joueurs de la partie excepté le premier joueur.
		for (int i = 1 ; i < joueurs.length ; i++) {
			
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
		
		/*
		 * Si aucun joueur n'a trouvé été trouvé en possession de la carte 
		 * indiquée alors le premier joueur est assuré de posséder cette carte.
		 */
		return 0;    // FIXME Attention !
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
		for (Carte carteCourante : mainJoueur) {
			
			/*
			 * Recherche de toutes les cartes ayant un symbole équivalent
			 * au symbole demandé en argument.
			 */
			if (carteCourante.getSymbole().equals(symboleDemande)) {
				cartesJouables.add(carteCourante);
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
	 * Échange les trois cartes choisies par les joueurs entre eux.
	 * Dans cette méthode, l'échange se fait vers la gauche.
	 * @param joueurs Les joueurs de la partie.
	 */
	public static void echangeGauche(Joueur[] joueurs) {
		// Demande et stocke les cartes à échanger du premier joueur.
		Carte[] cartesJ0 = ((Humain) joueurs[0]).choisirCartesAEchanger();
		
		// Demande et stocke les cartes à échanger du second joueur.
		Carte[] cartesJ1 = ((IA) joueurs[1]).choisirCartesAEchanger();
		
		// Demande et stocke les cartes à échanger du troisième joueur.
		Carte[] cartesJ2 = ((IA) joueurs[2]).choisirCartesAEchanger();

		// Demande et stocke les cartes à échanger du quatrième joueur.
		Carte[] cartesJ3 = ((IA) joueurs[3]).choisirCartesAEchanger();
		
		// Parcours des tableaux de cartes à échanger.
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
	 * Échange les trois cartes choisies par les joueurs entre eux.
	 * Dans cette méthode, l'échange se fait vers la droite.
	 * @param joueurs Les joueurs de la partie.
	 */
	public static void echangeDroit(Joueur[] joueurs) {
		// Demande et stocke les cartes à échanger du premier joueur.
		Carte[] cartesJ0 = ((Humain) joueurs[0]).choisirCartesAEchanger();
		
		// Demande et stocke les cartes à échanger du second joueur.
		Carte[] cartesJ1 = ((IA) joueurs[1]).choisirCartesAEchanger();
		
		// Demande et stocke les cartes à échanger du troisième joueur.
		Carte[] cartesJ2 = ((IA) joueurs[2]).choisirCartesAEchanger();
		
		// Demande et stocke les cartes à échanger du quatrième joueur.
		Carte[] cartesJ3 = ((IA) joueurs[3]).choisirCartesAEchanger();
		
		// Parcours des tableaux de cartes à échanger.
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
	 * Échange les trois cartes choisies par les joueurs entre eux.
	 * Dans cette méthode, l'échange se fait en face.
	 * @param joueurs Les joueurs de la partie.
	 */
	public static void echangeFace(Joueur[] joueurs) {
		// Demande et stocke les cartes à échanger du premier joueur.
		Carte[] cartesJ0 = ((Humain) joueurs[0]).choisirCartesAEchanger();
		
		// Demande et stocke les cartes à échanger du second joueur.
		Carte[] cartesJ1 = ((IA) joueurs[1]).choisirCartesAEchanger();
		
		// Demande et stocke les cartes à échanger du troisième joueur.
		Carte[] cartesJ2 = ((IA) joueurs[2]).choisirCartesAEchanger();
		
		// Demande et stocke les cartes à échanger du quatrième joueur.
		Carte[] cartesJ3 = ((IA) joueurs[3]).choisirCartesAEchanger();
		
		// Parcours des tableaux de cartes à échanger.
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
	 * Échange les cartes suivant le numéro de la manche courante.
	 * Le sens des échanges sont définis par rapport au numéro de la manche.
	 * @param joueurs Les joueurs de la partie.
	 * @param noManche Le numéro de la manche de la partie.
	 */
	public static void echangerCartes(Joueur[] joueurs, int noManche) {
		System.out.println("Début de l'échange des cartes !\n"
				           + "********************************");
		
		if (noManche % 4 == 0) {
			// Échange des cartes vers le joueur positionné à gauche. 
			echangeGauche(joueurs);
			System.out.println("L'échange des cartes est terminé !");
			
			// Tri la main du joueur après l'échange des cartes.
			trierMains(joueurs);
		} else if (noManche % 4 == 1) {
			// Échange des cartes vers le joueur positionné à droite.
			echangeDroit(joueurs);
			System.out.println("L'échange des cartes est terminé !");
			
			// Tri la main du joueur après l'échange des cartes.
			trierMains(joueurs);
		} else if (noManche % 4 == 2) {
			// Échange des cartes vers le joueur positionné en face.
			echangeFace(joueurs);
			System.out.println("L'échange des cartes est terminé !");
			
			// Tri la main du joueur après l'échange des cartes.
			trierMains(joueurs);
		} else {
			System.out.println("Il n'y a pas d'échange de cartes ce tour !");
		}
	}
	
	
	/**
	 * Tri les cartes dans la main des joueurs passés en argument.
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
