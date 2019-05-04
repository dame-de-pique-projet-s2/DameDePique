/*
 * Plateau.java                                                      28/04/2019
 * Projet de la dame de pique | IUT de Rodez | 2018 - 2019
 */

package damedepique.general;

import static damedepique.general.OutilCarte.*;

import java.util.ArrayList;

/**
 * Création d'un plateau de jeu virtuel pour jouer à la dame de pique.
 * @author Loïc B. Julien B. Margaux B. Justine R.
 * @version 1.0
 */
public class Plateau {

	/** Cartes qui composent ce (this) Plateau. */
	private ArrayList<Carte> cartes;
	
	
	/** Création d'un nouveau plateau de jeu. */
	public Plateau() {
		this.cartes = new ArrayList<>();
	}
	
	
	/**
	 * Récupère les cartes de ce (this) Plateau.
	 * @return Les cartes disposées sur le plateau.
	 */
	public ArrayList<Carte> getCartes() {
		return this.cartes;
	}
	
	
	/**
	 * Vide les cartes disposées sur le plateau.
	 */
	public void vider() {
		this.cartes.clear();
	}
	
	
	/**
	 * Ajoute une carte sur ce (this) Plateau.
	 * @param aAjouter La carte à ajouter.
	 */
	public void ajouterCarte(Carte aAjouter) {
		this.cartes.add(aAjouter);
	}
	
	
	/**
	 * Récupère le symbole de la première carte jouée sur le plateau.
	 * @return Le symbole de la première carte jouée.
	 */
	public Symbole getSymboleDebut() {
		return this.cartes.get(0).getSymbole();
	}
	
	
	/**
	 * Récupère l'indice du joueur perdant du tour. Le joueur perdant est 
	 * le joueur ayant posé la plus grosse carte sur le plateau de jeu.
	 * @param joueurs Les joueurs de la partie.
	 * @return L'indice du joueur ayant perdu le tour.
	 */
	public int getPerdant(Joueur[] joueurs) {
		// Copie du plateau courant pour ne pas changer son état.
		ArrayList<Carte> plateauCourant = this.cartes;
		
		// Stocke le symbole demandé au début du tour.
		Symbole symboleDemande = this.getSymboleDebut();
		
		// Stocke la valeur de la carte la plus grande.
		Valeur valeur;
		
		/* 
		 * Parcours des cartes du plateau pour vérifier quelles ont bien toutes 
		 * le même symbole. Si une ou plusieurs n'ont pas le même symbole alors 
		 * elles sont supprimées de la copie du plateau.
		 */
		for (int i = 0 ; i < joueurs.length ; i++) {
			
			/* 
			 * Vérifie si le symbole de la carte courante est équivalent à 
			 * celui demandé au début du tour.
			 */
			if (!plateauCourant.get(i).getSymbole().equals(symboleDemande)) {
				
				// Retire s'ils ne sont pas équivalent.
				plateauCourant.remove(plateauCourant.get(i));
			}
		}
		
		// Tri les cartes restantes sur le plateau dans l'ordre croissant.
		plateauCourant.sort(Carte.ordreCroissant);
		
		// Récupère la valeur de la dernière carte du plateau (plus grande).
		valeur = plateauCourant.get(plateauCourant.size() - 1).getValeur();
		
		// Retourne l'indice du joueur ayant la carte la plus grande.
		return rechercherCarte(joueurs, symboleDemande, valeur);
	}
	
	
	/* 
	 * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * *
	 * * * * * * * * * * Méthodes de Comptage des points * * * * * * * * * * * *  
	 * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * *
	 */
	
	// TODO : à améliorer
	
	/**
	 * Cette méthode retourne un boolean égal a vrai si des cartes coeurs sont 
	 * presents sur le plateau à la fin d'un tour.
	 * @return avecCoeur un booléen exprimant la presence de carte coeurs sur le 
	 *                   plateau
	 */
	public boolean avecCoeur() {
		/* On récupère les cartes sur le plateau dans une liste plateauCourant */
		ArrayList<Carte> plateauCourant = this.cartes;
		
		/* On initialise à faux le booléen indiquant la presence de coeur sur le plateau */ 
		boolean avecCoeur = false;
		
		/*
		 *  On teste chaque carte du plateau, si on trouve un coeur 
		 *  alors le booleen passe a vrai et la boucle s'arrête
		 */
		for (int i = 0 ; i < this.cartes.size() || avecCoeur == false ; i++) {
			if (plateauCourant.get(i).getSymbole().equals(Symbole.Coeur)) {
				avecCoeur = true;
			}
		}

		return avecCoeur;
	}

	/**
	 * Cette méthode retourne un booléen égal à vrai si la dame de pique est
	 * présente sur le plateau a la fin du tour.
	 * 
	 * @return avecDame un booléen exprimant la presence de la dame de pique sur 
	 *                  sur le plateau
	 */
	public boolean avecDame() {
		/* On récupère les cartes sur le plateau dans une liste plateauCourant */
		ArrayList<Carte> plateauCourant = this.cartes;
		
		/* On initialise à faux le booleen indiquant la presence de la dame de pique sur le plateau */ 
		boolean avecDame = false;
		
		/* 
		 * On teste chaque carte du plateau, si on trouve la dame de pique 
		 *  alors le booleen passe a vrai et la boucle s'arrête.
		 */
		for (int i = 0 ; i < this.cartes.size() ; i++) {
			if ((plateauCourant.get(i).getSymbole().equals(Symbole.Pique) &&
					plateauCourant.get(i).getValeur().equals(Valeur.Dame)) || 
					avecDame == false) {
				avecDame = true;
			}
		}
		
		return avecDame;
	}
	
	/**
	 * Cette méthode calcule le nombre de points à ajouter au joueur qui perds 
	 * le tour. 
	 * Elle teste tout d'abbord la presence de la dame de pique sur le plateau
	 * avec la méthode avecDame, ensuite elle teste la presence de coeur sur
	 * le plateau.
	 * Si la dame de pique est sur le plateau, elle rajoute 13 points à la valeur
	 * renvoyée.
	 * Si il y a des coeur sur le plateau alors elle les compte puis elle rajoute à
	 * la valeur retournée 1 point pour chaque coeur present.
	 *  
	 * @return aAjouter, un entier représentant le nombre de point a ajouter 
	 *                   au perdant du tour
	 */
	public int pointsAAjouter() {
		// On récupère les cartes sur le plateau dans une liste plateauCourant
		ArrayList<Carte> plateauCourant = this.cartes;
		int aAjouter = 0;            // Le nombre de points a ajouter au perdant
		boolean aDame = avecDame();  // Booléen indiquant si le plateau 
		                             // contient la dame de pique
		boolean aCoeur = avecCoeur();// Booléen indiquant si le plateau contient
		                             // un ou des coeur(s)
		
		/* Vérifie si la dame de pique est sur le plateau */ 
		if(aDame == true ) {
			aAjouter = aAjouter + 13;
		}
		
		/* La méthode vérifie la presence de coeurs sur le plateau */
		if(aCoeur == true) {
		
			int nbCoeurs = 0;
			
			/*
			 *  Puis elle regarde chaque carte du plateau et incrémente la 
			 *  variable de 1 pour chaque coeur trouvé 
			 */  
			for (int i = 0 ; i < this.cartes.size() ; i++) {
				if (plateauCourant.get(i).getSymbole().equals(Symbole.Coeur)) {
					
					nbCoeurs ++;
				}
			}
			
			aAjouter = aAjouter + nbCoeurs; 
		}
		
		return aAjouter;		
	}
	
	/**
	 * Cette méthode ajoute les points du tour au joueur perdant, ensuite 
	 * Elle retire les cartes sur le plateau des mains des joueurs 
	 * 
	 * @param joueurs Les joueurs de la partie 
	 */
	public void ajouterPointsTour(Joueur[] joueurs) {
		
		int aAjouter = pointsAAjouter();          // Contient les points à ajouter au perdant  
		int perdant = getPerdant(joueurs);        // Contient l'indice du joueur perdant
		joueurs[perdant].ajouterPoints(aAjouter); // Ajoute au joueur perdant les points du tour
		
		/* On récupère toutes cartes du plateau courant */
		ArrayList<Carte> plateauCourant = this.cartes;
		
		/*
		 * On retire la carte que chaque joueur a joué sur le plateau de 
		 * leur main respective.
		 */
		for(int i = 0; i < plateauCourant.size(); i++ ) {
			
			// On récupère la carte d'indice i dans une variable 
			Carte aTester = plateauCourant.get(i);
			
			// On crée un indice permettant de récupérer l'indice
			// du joueur possédant la carte
			int indice = rechercherCarte(joueurs, aTester.getSymbole(),
					                     aTester.getValeur());
			
			joueurs[indice].retirerCarte(aTester);
		}		
	}
	
	@Override
	public String toString() {
		String listeCartes = "";
		
		for (Carte carte : this.cartes) {
			listeCartes += "\n    => " + carte.toString();
		}
		
		return listeCartes;
	}
	
}
