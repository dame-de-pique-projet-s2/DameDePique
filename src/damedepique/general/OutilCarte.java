/*
 * OutilCarte.java                                                   11/05/2019
 * Projet de la dame de pique | IUT de Rodez | 2018 - 2019
 */

package damedepique.general;

import static damedepique.general.OutilAffichage.*;

import java.util.ArrayList;

/**
 * <p>
 *   Cette classe contient des outils concernant la manipulation de cartes.
 * </p>
 * 
 * @author Julien B.
 * @author Loïc B.
 * @author Margaux B.
 * @author Justine R.
 * 
 * @version 1.0
 */
public class OutilCarte {
	
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
				if (mainJoueurCourant.get(j).getSymbole().equals(symbole) 
					&& mainJoueurCourant.get(j).getValeur().equals(valeur)) {
					
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
		return 0;
	}
	
	
	/**
	 * Récupère les cartes jouables par un joueur en prenant en compte si un 
	 * coeur a déjà été défaussé ou non.
	 * @param joueur Le joueur à vérifier.
	 * @param coeurDefausse Vrai si un coeur a déjà été défaussé sinon faux.
	 * @return La liste des cartes pouvant être jouées par le joueur.
	 */
	public static ArrayList<Carte> cartesPossibles(Joueur joueur,
			                                       boolean coeurDefausse) {
		
		// Copie de la main du joueur spécifié en argument.
		ArrayList<Carte> cartesJouables = new ArrayList<>();
		for (Carte carte : joueur.getMain()) {
			cartesJouables.add(carte);
		}
		
		// Nombre de cartes supprimées dans la copie de la main du joueur.
		int nbSupp = 0;
		
		// Taille fixe de la main du joueur au début de la recherche.
		int tailleMain = cartesJouables.size();
		
		// Vérifie si un coeur a déjà été défaussé ou non.
		if (!coeurDefausse) {
			
			/*
			 * Si aucune carte possédant le symbole coeur n'a été défaussé 
			 * alors on parcours toute la main du joueur spécifié afin de 
			 * retirer les cartes disposant d'un symbole coeur.
			 */
			for (int i = 0 ; i < tailleMain ; i++) {
				
				// Vérifie si la carte courante possède un coeur en symbole.
				if (cartesJouables.get(i - nbSupp).getSymbole()
						                          .equals(Symbole.Coeur)) {
					
					// Retire la carte des cartes possibles si c'est un coeur.
					cartesJouables.remove(i - nbSupp);
					nbSupp++;    // Incrémente le nombre de suppressions.
				}
			}
		}
		
		/*
		 * Si le joueur ne possède aucun autre symbole que du coeur, ou 
		 * autrement dit si il ne possède que du coeur et qu'aucune carte ayant 
		 * le symbole coeur n'a été défaussé alors le joueur peut jouer du 
		 * coeur. Attention, ceci est un cas particulier, très rare. 
		 */
		if (cartesJouables.isEmpty()) {
			return joueur.getMain();
		}
 		
		// Retourne la liste des cartes jouables par le joueur.
		return cartesJouables;
	}
	
	
	/**
	 * Récupère les cartes jouables par un joueur selon sa main par rapport à 
	 * un symbole demandé au début d'un tour.
	 * @param joueur Le joueur à vérifier.
	 * @param symboleDemande Le symbole demandé au début d'un tour.
	 * @param noTour Le numéro du tour de la partie.
	 * @return La liste des cartes pouvant être jouées par le joueur.
	 */
	public static ArrayList<Carte> cartesPossibles(Joueur joueur,
			                                       Symbole symboleDemande,
			                                       int noTour) {
		
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
		
		// Vérifie si le numéro du tour passé en argument est égal à 0.
		if (noTour == 0) {
			
			/*
			 * Si le numéro du tour spécifié est 0, ou autrement dit si c'est 
			 * le premier tour d'une manche, alors le joueur spécifié a 
			 * interdiction de poser une carte comportant un symbole coeur ou 
			 * la dame de pique. On fait donc le parcours de sa main pour 
			 * trouver une ou plusieurs occurrences.
			 */
			for (Carte carteJouable : cartesJouables) {
				
				/*
				 * On vérifie que la carte courante vérifié est une carte 
				 * interdite au premier tour d'une manche.
				 */
				if (carteJouable.getSymbole().equals(Symbole.Coeur) 
					|| (carteJouable.getSymbole().equals(Symbole.Pique) 
						&& carteJouable.getValeur().equals(Valeur.Dame))) {
					
					// On retire la carte courante si elle est interdite.
					cartesJouables.remove(carteJouable);
				}
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
		 * symbole demandé et le numéro tour.
		 */
		return cartesJouables;
	}
	
	
	/**
	 * Échange les trois cartes choisies par les joueurs entre eux.
	 * Dans cette méthode, l'échange se fait vers la gauche.
	 * @param joueurs Les joueurs de la partie.
	 */
	public static void echangeGauche(Joueur[] joueurs) {
		// Demande et stocke les cartes à échanger du premier joueur.
		Carte[] cartesJ0 = joueurs[0].choisirCartesAEchanger();
		
		// Demande et stocke les cartes à échanger du second joueur.
		Carte[] cartesJ1 = joueurs[1].choisirCartesAEchanger();
		
		// Demande et stocke les cartes à échanger du troisième joueur.
		Carte[] cartesJ2 = joueurs[2].choisirCartesAEchanger();

		// Demande et stocke les cartes à échanger du quatrième joueur.
		Carte[] cartesJ3 = joueurs[3].choisirCartesAEchanger();
		
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
		
		// Affiche un message pour voir qui échange les cartes à qui.
		afficherEchanges(joueurs, 0);
	}
	
	
	/**
	 * Échange les trois cartes choisies par les joueurs entre eux.
	 * Dans cette méthode, l'échange se fait vers la droite.
	 * @param joueurs Les joueurs de la partie.
	 */
	public static void echangeDroit(Joueur[] joueurs) {
		// Demande et stocke les cartes à échanger du premier joueur.
		Carte[] cartesJ0 = joueurs[0].choisirCartesAEchanger();
		
		// Demande et stocke les cartes à échanger du second joueur.
		Carte[] cartesJ1 = joueurs[1].choisirCartesAEchanger();
		
		// Demande et stocke les cartes à échanger du troisième joueur.
		Carte[] cartesJ2 = joueurs[2].choisirCartesAEchanger();
		
		// Demande et stocke les cartes à échanger du quatrième joueur.
		Carte[] cartesJ3 = joueurs[3].choisirCartesAEchanger();
		
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
		
		// Affiche un message pour voir qui échange les cartes à qui.
		afficherEchanges(joueurs, 1);
	}
	
	
	/**
	 * Échange les trois cartes choisies par les joueurs entre eux.
	 * Dans cette méthode, l'échange se fait en face.
	 * @param joueurs Les joueurs de la partie.
	 */
	public static void echangeFace(Joueur[] joueurs) {
		// Demande et stocke les cartes à échanger du premier joueur.
		Carte[] cartesJ0 = joueurs[0].choisirCartesAEchanger();
		
		// Demande et stocke les cartes à échanger du second joueur.
		Carte[] cartesJ1 = joueurs[1].choisirCartesAEchanger();
		
		// Demande et stocke les cartes à échanger du troisième joueur.
		Carte[] cartesJ2 = joueurs[2].choisirCartesAEchanger();
		
		// Demande et stocke les cartes à échanger du quatrième joueur.
		Carte[] cartesJ3 = joueurs[3].choisirCartesAEchanger();
		
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
		
		// Affiche un message pour voir qui échange les cartes à qui.
		afficherEchanges(joueurs, 2);
	}
	
	
	/**
	 * Échange les cartes suivant le numéro de la manche courante.
	 * Le sens des échanges sont définis par rapport au numéro de la manche.
	 * @param joueurs Les joueurs de la partie.
	 * @param noManche Le numéro de la manche de la partie.
	 */
	public static void echangerCartes(Joueur[] joueurs, int noManche) {
		if (noManche % 4 == 0) {
			// Affichage d'un message montrant que l'échange commence.
			System.out.println(DEBUT_ECHANGE);
			
			// Échange des cartes vers le joueur positionné à gauche. 
			echangeGauche(joueurs);
			
			// Annonce que l'échange est terminé.
			finEchange(joueurs);
		} else if (noManche % 4 == 1) {
			// Affichage d'un message montrant que l'échange commence.
			System.out.println(DEBUT_ECHANGE);
			
			// Échange des cartes vers le joueur positionné à droite.
			echangeDroit(joueurs);
			
			// Annonce que l'échange est terminé.
			finEchange(joueurs);
		} else if (noManche % 4 == 2) {
			// Affichage d'un message montrant que l'échange commence.
			System.out.println(DEBUT_ECHANGE);
			
			// Échange des cartes vers le joueur positionné en face.
			echangeFace(joueurs);
			
			// Annonce que l'échange est terminé.
			finEchange(joueurs);
		} else {
			
			/* 
			 * Affichage d'un message signalant qu'il n'y a d'échange à ce 
			 * tour. Ce phénomène se produit tous les quatre tour.
			 */
			System.out.println(PAS_ECHANGE);
		}
	}
	
	
	/**
	 * Annonce la fin d'un échange de cartes. Après cet échange, un algorithme 
	 * tri les cartes dans la main de tous les joueurs, puis montre les cartes 
	 * dans la main du joueur humain et affiche un message précisant que 
	 * l'échange est bel et bien fini.
	 * @param joueurs Les joueurs de la partie.
	 */
	private static void finEchange(Joueur[] joueurs) {
		// Tri la main du joueur après l'échange des cartes.
		trierMains(joueurs);
		 
		// Affichage des nouvelles cartes présentes dans la main.
		afficherCartes(joueurs[0].getMain(), 
					   "### Votre nouvelle main après l'échange : ");
		
		// Affichage d'un message signalant la fin de l'échange des cartes.
		System.out.println(FIN_ECHANGE);
	}
	
	
	/**
	 * Recherche l'indice du deux de trèfle dans la main d'un joueur.
	 * @param joueur Le joueur supposé avoir le deux de trèfle.
	 * @return Un entier correspondant à l'indice du deux de trèfle.
	 *         Si le joueur spécifié ne possède pas le deux de trèfle dans sa 
	 *         main alors l'entier -1 est renvoyé (indice invalide).
	 */
	public static int indiceDeuxTrefle(Joueur joueur) {		
		// Parcours de la main du joueur spécifié en argument.
		for (Carte carte : joueur.getMain()) {
			
			/* 
			 * Vérifie si la carte courante possède le symbole trèfle et 
			 * la valeur deux.
			 */
			if (carte.getSymbole().equals(Symbole.Trefle) 
				&& carte.getValeur().equals(Valeur.Deux)) {
				
				// Retourne l'indice de la carte cherchée (deux de trèfle).
				return joueur.getMain().indexOf(carte);
			}
		}
		
		return -1;    // Retourne la valeur -1 en cas d'absence d'occurrence.
	}
	
	
	/**
	 * Tri les cartes dans la main des joueurs passés en argument.
	 * @param joueurs Les joueurs de la partie.
	 */
	public static void trierMains(Joueur[] joueurs) {
		// Parcours de tous les joueurs de la partie.
		for (Joueur joueurCourant : joueurs) {
			
			// Tri de la main du joueur courant.
			joueurCourant.trierMain();
		}
	}
	
}
