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
	 * Recherche l'indice d'un joueur ayant une carte sp�cifique. Cette m�thode 
	 * est utile pour par exemple la recherche de l'indice du joueur poss�dant 
	 * le deux de tr�fle pour qu'il joue en premier lors du premier tour.
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
		
		/* 
		 * Parcours des joueurs de la partie except� le premier joueur car si 
		 * aucune occurrence de la carte cherch�e n'est trouv�e lors du 
		 * parcours de la main des joueurs alors le premier joueur sera assur� 
		 * de poss�der la carte sp�cifi�e.
		 */
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
	 * coeur a d�j� �t� d�fauss� ou non. Cette m�thode est utile pour aider le 
	 * premier joueur d'un tour car il �limine toutes les cartes poss�dant le 
	 * symbole coeur de ses cartes jouables tant qu'un coeur n'a pas �t� 
	 * d�fauss� pendant une manche.
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
		
		// Taille fixe de la main du joueur au d�but de la recherche.
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
		 * autrement dit si il ne poss�de que du coeur et qu'aucune carte ayant 
		 * le symbole coeur n'a �t� d�fauss� alors le joueur peut jouer du 
		 * coeur. Attention, ceci est un cas particulier, tr�s rare. 
		 */
		if (cartesJouables.isEmpty()) {
			return joueur.getMain();
		}
 		
		// Retourne la liste des cartes jouables par le joueur.
		return cartesJouables;
	}
	
	
	/**
	 * R�cup�re les cartes jouables par un joueur selon sa main par rapport � 
	 * un symbole demand� au d�but d'un tour.
	 * @param joueur Le joueur � v�rifier.
	 * @param symboleDemande Le symbole demand� au d�but d'un tour.
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
		
		/*
		 * Si le joueur ne poss�de aucune carte ayant un symbole �quivalent au 
		 * symbole demand� alors il peut jouer toutes les cartes pr�sentes dans 
		 * sa main � l'exception du premier tour o� les cartes comportant du 
		 * coeur et la dame de pique sont exclu des cartes jouables (sauf 
		 * cas sp�ciaux).
		 */
		if (cartesJouables.isEmpty()) {
			
			/* 
			 * On v�rifie que le num�ro du tour est �gal � 0 (premier tour) 
			 * pour savoir si des cartes doivent �tre supprim�es des cartes 
			 * jouables du joueur sp�cifi�.
			 */
			if (noTour == 0) {
				
				/*
				 * Si le num�ro du tour sp�cifi� est 0, ou autrement dit si 
				 * c'est le premier tour d'une manche, alors le joueur sp�cifi� 
				 * a interdiction de poser une carte comportant un symbole 
				 * coeur ou la dame de pique. On fait donc le parcours de sa 
				 * main pour trouver une ou plusieurs occurrences afin de les 
				 * supprimer.
				 */
				for (Carte carteCourante : joueur.getMain()) {
					
					/*
					 * On v�rifie que la carte courante v�rifi�e n'est pas une 
					 * carte interdite au premier tour d'une manche.
					 */
					if (!carteCourante.getSymbole().equals(Symbole.Coeur) 
						&& !(carteCourante.getSymbole().equals(Symbole.Pique) 
						&& carteCourante.getValeur().equals(Valeur.Dame))) {
						
						/* 
						 * Si la carte courante n'est pas une carte interdite 
						 * au premier tour d'un manche alors elle est ajout�e 
						 * aux cartes jouables par le joueur sp�cifi�.
						 */
						cartesJouables.add(carteCourante);
					}
				}
				
				/*
				 * Apr�s la v�rification pr�c�dente il ce peut dans des cas 
				 * tr�s particuliers que le joueur sp�cifi� ne poss�de que des 
				 * cartes contenant un symbole coeur avec la dame de pique par 
				 * exemple. Dans un de ces cas, on v�rifie si la liste des 
				 * cartes jouables pour ce joueur est toujours vide alors le 
				 * joueur a la possibilit� de jouer n'importe quelle carte dans 
				 * sa main car sinon il aurait �t� bloqu�.
				 */
				if (cartesJouables.isEmpty()) {
					
					// Retourne la liste des cartes dans la main du joueur.
					return mainJoueur;
				}
			
			/*
			 * Sinon si le joueur ne poss�de aucune carte ayant un symbole 
			 * �quivalent au symbole demand� et que ce n'est pas le premier 
			 * tour d'une manche alors il peut jouer toutes les cartes 
			 * pr�sentes dans sa main.
			 */
			} else {
				
				// Retourne la liste des cartes dans la main du joueur.
				return mainJoueur;
			}
		}
		
		/* 
		 * Retourne la liste des cartes jouables par le joueur selon le 
		 * symbole demand� et le num�ro tour.
		 */
		return cartesJouables;
	}
	
	
	/**
	 * Recherche l'indice du deux de tr�fle dans la main d'un joueur.
	 * @param joueur Le joueur suppos� avoir le deux de tr�fle.
	 * @return Un entier correspondant � l'indice du deux de tr�fle.
	 *         Si le joueur sp�cifi� ne poss�de pas le deux de tr�fle dans sa 
	 *         main alors l'entier -1 est renvoy� (indice invalide).
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
				
				// Retourne l'indice de la carte cherch�e (deux de tr�fle).
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
		// Parcours de tous les joueurs de la partie.
		for (Joueur joueurCourant : joueurs) {
			
			// Tri de la main du joueur courant.
			joueurCourant.trierMain();
		}
	}
	
}
