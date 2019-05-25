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
 * @author Loïc B.
 * @author Margaux B.
 * @author Justine R.
 * 
 * @version 1.0
 */
public class OutilCarte {
	
	/**
	 * Recherche l'indice d'un joueur ayant une carte spécifique. Cette méthode 
	 * est utile pour par exemple la recherche de l'indice du joueur possédant 
	 * le deux de trèfle pour qu'il joue en premier lors du premier tour.
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
		
		/* 
		 * Parcours des joueurs de la partie excepté le premier joueur car si 
		 * aucune occurrence de la carte cherchée n'est trouvée lors du 
		 * parcours de la main des joueurs alors le premier joueur sera assuré 
		 * de posséder la carte spécifiée.
		 */
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
	 * coeur a déjà été défaussé ou non. Cette méthode est utile pour aider le 
	 * premier joueur d'un tour car il élimine toutes les cartes possédant le 
	 * symbole coeur de ses cartes jouables tant qu'un coeur n'a pas été 
	 * défaussé pendant une manche.
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
		
		/*
		 * Si le joueur ne possède aucune carte ayant un symbole équivalent au 
		 * symbole demandé alors il peut jouer toutes les cartes présentes dans 
		 * sa main à l'exception du premier tour où les cartes comportant du 
		 * coeur et la dame de pique sont exclu des cartes jouables (sauf 
		 * cas spéciaux).
		 */
		if (cartesJouables.isEmpty()) {
			
			/* 
			 * On vérifie que le numéro du tour est égal à 0 (premier tour) 
			 * pour savoir si des cartes doivent être supprimées des cartes 
			 * jouables du joueur spécifié.
			 */
			if (noTour == 0) {
				
				/*
				 * Si le numéro du tour spécifié est 0, ou autrement dit si 
				 * c'est le premier tour d'une manche, alors le joueur spécifié 
				 * a interdiction de poser une carte comportant un symbole 
				 * coeur ou la dame de pique. On fait donc le parcours de sa 
				 * main pour trouver une ou plusieurs occurrences afin de les 
				 * supprimer.
				 */
				for (Carte carteCourante : joueur.getMain()) {
					
					/*
					 * On vérifie que la carte courante vérifiée n'est pas une 
					 * carte interdite au premier tour d'une manche.
					 */
					if (!carteCourante.getSymbole().equals(Symbole.Coeur) 
						&& !(carteCourante.getSymbole().equals(Symbole.Pique) 
						&& carteCourante.getValeur().equals(Valeur.Dame))) {
						
						/* 
						 * Si la carte courante n'est pas une carte interdite 
						 * au premier tour d'un manche alors elle est ajoutée 
						 * aux cartes jouables par le joueur spécifié.
						 */
						cartesJouables.add(carteCourante);
					}
				}
				
				/*
				 * Après la vérification précédente il ce peut dans des cas 
				 * très particuliers que le joueur spécifié ne possède que des 
				 * cartes contenant un symbole coeur avec la dame de pique par 
				 * exemple. Dans un de ces cas, on vérifie si la liste des 
				 * cartes jouables pour ce joueur est toujours vide alors le 
				 * joueur a la possibilité de jouer n'importe quelle carte dans 
				 * sa main car sinon il aurait été bloqué.
				 */
				if (cartesJouables.isEmpty()) {
					
					// Retourne la liste des cartes dans la main du joueur.
					return mainJoueur;
				}
			
			/*
			 * Sinon si le joueur ne possède aucune carte ayant un symbole 
			 * équivalent au symbole demandé et que ce n'est pas le premier 
			 * tour d'une manche alors il peut jouer toutes les cartes 
			 * présentes dans sa main.
			 */
			} else {
				
				// Retourne la liste des cartes dans la main du joueur.
				return mainJoueur;
			}
		}
		
		/* 
		 * Retourne la liste des cartes jouables par le joueur selon le 
		 * symbole demandé et le numéro tour.
		 */
		return cartesJouables;
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
