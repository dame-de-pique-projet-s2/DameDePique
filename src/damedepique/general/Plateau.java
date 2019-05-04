/*
 * Plateau.java                                                      28/04/2019
 * Projet de la dame de pique | IUT de Rodez | 2018 - 2019
 */

package damedepique.general;

import static damedepique.general.OutilCarte.*;

import java.util.ArrayList;

/**
 * Cr�ation d'un plateau de jeu virtuel pour jouer � la dame de pique.
 * @author Lo�c B. Julien B. Margaux B. Justine R.
 * @version 1.0
 */
public class Plateau {

	/** Cartes qui composent ce (this) Plateau. */
	private ArrayList<Carte> cartes;
	
	
	/** Cr�ation d'un nouveau plateau de jeu. */
	public Plateau() {
		this.cartes = new ArrayList<>();
	}
	
	
	/**
	 * R�cup�re les cartes de ce (this) Plateau.
	 * @return Les cartes dispos�es sur le plateau.
	 */
	public ArrayList<Carte> getCartes() {
		return this.cartes;
	}
	
	
	/**
	 * Vide les cartes dispos�es sur le plateau.
	 */
	public void vider() {
		this.cartes.clear();
	}
	
	
	/**
	 * Ajoute une carte sur ce (this) Plateau.
	 * @param aAjouter La carte � ajouter.
	 */
	public void ajouterCarte(Carte aAjouter) {
		this.cartes.add(aAjouter);
	}
	
	
	/**
	 * R�cup�re le symbole de la premi�re carte jou�e sur le plateau.
	 * @return Le symbole de la premi�re carte jou�e.
	 */
	public Symbole getSymboleDebut() {
		return this.cartes.get(0).getSymbole();
	}
	
	
	/**
	 * R�cup�re l'indice du joueur perdant du tour. Le joueur perdant est 
	 * le joueur ayant pos� la plus grosse carte sur le plateau de jeu.
	 * @param joueurs Les joueurs de la partie.
	 * @return L'indice du joueur ayant perdu le tour.
	 */
	public int getPerdant(Joueur[] joueurs) {
		// Copie du plateau courant pour ne pas changer son �tat.
		ArrayList<Carte> plateauCourant = this.cartes;
		
		// Stocke le symbole demand� au d�but du tour.
		Symbole symboleDemande = this.getSymboleDebut();
		
		// Stocke la valeur de la carte la plus grande.
		Valeur valeur;
		
		/* 
		 * Parcours des cartes du plateau pour v�rifier quelles ont bien toutes 
		 * le m�me symbole. Si une ou plusieurs n'ont pas le m�me symbole alors 
		 * elles sont supprim�es de la copie du plateau.
		 */
		for (int i = 0 ; i < joueurs.length ; i++) {
			
			/* 
			 * V�rifie si le symbole de la carte courante est �quivalent � 
			 * celui demand� au d�but du tour.
			 */
			if (!plateauCourant.get(i).getSymbole().equals(symboleDemande)) {
				
				// Retire s'ils ne sont pas �quivalent.
				plateauCourant.remove(plateauCourant.get(i));
			}
		}
		
		// Tri les cartes restantes sur le plateau dans l'ordre croissant.
		plateauCourant.sort(Carte.ordreCroissant);
		
		// R�cup�re la valeur de la derni�re carte du plateau (plus grande).
		valeur = plateauCourant.get(plateauCourant.size() - 1).getValeur();
		
		// Retourne l'indice du joueur ayant la carte la plus grande.
		return rechercherCarte(joueurs, symboleDemande, valeur);
	}
	
	
	/* 
	 * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * *
	 * * * * * * * * * * M�thodes de Comptage des points * * * * * * * * * * * *  
	 * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * *
	 */
	
	// TODO : � am�liorer
	
	/**
	 * Cette m�thode retourne un boolean �gal a vrai si des cartes coeurs sont 
	 * presents sur le plateau � la fin d'un tour.
	 * @return avecCoeur un bool�en exprimant la presence de carte coeurs sur le 
	 *                   plateau
	 */
	public boolean avecCoeur() {
		/* On r�cup�re les cartes sur le plateau dans une liste plateauCourant */
		ArrayList<Carte> plateauCourant = this.cartes;
		
		/* On initialise � faux le bool�en indiquant la presence de coeur sur le plateau */ 
		boolean avecCoeur = false;
		
		/*
		 *  On teste chaque carte du plateau, si on trouve un coeur 
		 *  alors le booleen passe a vrai et la boucle s'arr�te
		 */
		for (int i = 0 ; i < this.cartes.size() || avecCoeur == false ; i++) {
			if (plateauCourant.get(i).getSymbole().equals(Symbole.Coeur)) {
				avecCoeur = true;
			}
		}

		return avecCoeur;
	}

	/**
	 * Cette m�thode retourne un bool�en �gal � vrai si la dame de pique est
	 * pr�sente sur le plateau a la fin du tour.
	 * 
	 * @return avecDame un bool�en exprimant la presence de la dame de pique sur 
	 *                  sur le plateau
	 */
	public boolean avecDame() {
		/* On r�cup�re les cartes sur le plateau dans une liste plateauCourant */
		ArrayList<Carte> plateauCourant = this.cartes;
		
		/* On initialise � faux le booleen indiquant la presence de la dame de pique sur le plateau */ 
		boolean avecDame = false;
		
		/* 
		 * On teste chaque carte du plateau, si on trouve la dame de pique 
		 *  alors le booleen passe a vrai et la boucle s'arr�te.
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
	 * Cette m�thode calcule le nombre de points � ajouter au joueur qui perds 
	 * le tour. 
	 * Elle teste tout d'abbord la presence de la dame de pique sur le plateau
	 * avec la m�thode avecDame, ensuite elle teste la presence de coeur sur
	 * le plateau.
	 * Si la dame de pique est sur le plateau, elle rajoute 13 points � la valeur
	 * renvoy�e.
	 * Si il y a des coeur sur le plateau alors elle les compte puis elle rajoute �
	 * la valeur retourn�e 1 point pour chaque coeur present.
	 *  
	 * @return aAjouter, un entier repr�sentant le nombre de point a ajouter 
	 *                   au perdant du tour
	 */
	public int pointsAAjouter() {
		// On r�cup�re les cartes sur le plateau dans une liste plateauCourant
		ArrayList<Carte> plateauCourant = this.cartes;
		int aAjouter = 0;            // Le nombre de points a ajouter au perdant
		boolean aDame = avecDame();  // Bool�en indiquant si le plateau 
		                             // contient la dame de pique
		boolean aCoeur = avecCoeur();// Bool�en indiquant si le plateau contient
		                             // un ou des coeur(s)
		
		/* V�rifie si la dame de pique est sur le plateau */ 
		if(aDame == true ) {
			aAjouter = aAjouter + 13;
		}
		
		/* La m�thode v�rifie la presence de coeurs sur le plateau */
		if(aCoeur == true) {
		
			int nbCoeurs = 0;
			
			/*
			 *  Puis elle regarde chaque carte du plateau et incr�mente la 
			 *  variable de 1 pour chaque coeur trouv� 
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
	 * Cette m�thode ajoute les points du tour au joueur perdant, ensuite 
	 * Elle retire les cartes sur le plateau des mains des joueurs 
	 * 
	 * @param joueurs Les joueurs de la partie 
	 */
	public void ajouterPointsTour(Joueur[] joueurs) {
		
		int aAjouter = pointsAAjouter();          // Contient les points � ajouter au perdant  
		int perdant = getPerdant(joueurs);        // Contient l'indice du joueur perdant
		joueurs[perdant].ajouterPoints(aAjouter); // Ajoute au joueur perdant les points du tour
		
		/* On r�cup�re toutes cartes du plateau courant */
		ArrayList<Carte> plateauCourant = this.cartes;
		
		/*
		 * On retire la carte que chaque joueur a jou� sur le plateau de 
		 * leur main respective.
		 */
		for(int i = 0; i < plateauCourant.size(); i++ ) {
			
			// On r�cup�re la carte d'indice i dans une variable 
			Carte aTester = plateauCourant.get(i);
			
			// On cr�e un indice permettant de r�cup�rer l'indice
			// du joueur poss�dant la carte
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
