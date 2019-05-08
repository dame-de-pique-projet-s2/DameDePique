/*
 * Plateau.java                                                      28/04/2019
 * Projet de la dame de pique | IUT de Rodez | 2018 - 2019
 */

package damedepique.general;

import static damedepique.general.OutilCarte.*;

import java.util.ArrayList;

/**
 * <p>
 *   TODO Faire la description de cette classe.
 *   TODO Finir de commenter les m�thodes.
 * </p>
 * 
 * @author Lo�c B. | Julien B. | Margaux B. | Justine R.
 * @version 1.0
 */
public class Plateau {

	/** Nombre de cartes maximum sur un plateau de cartes. */
	private final int NB_CARTES_PLATEAU_MAX = 4;
	
	
	/** Cartes qui composent ce (this) Plateau. */
	private ArrayList<Carte> cartes;
	
	
	/** Cr�ation d'un nouveau plateau de jeu. */
	public Plateau() {
		this.cartes = new ArrayList<>(NB_CARTES_PLATEAU_MAX);
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
	 * R�cup�re l'indice du joueur perdant d'un tour. Le joueur perdant est 
	 * le joueur ayant pos� la plus grosse carte sur le plateau de jeu.
	 * @param joueurs Les joueurs de la partie.
	 * @return L'indice du joueur ayant perdu le tour.
	 */
	public int getPerdant(Joueur[] joueurs) {
		// Copie du plateau courant pour ne pas changer son �tat.
		ArrayList<Carte> plateauCourant = new ArrayList<>();
		for (Carte carte : this.cartes) {
			plateauCourant.add(carte);
		}
		
		// Taille du plateau courant.
		int taillePlateauCourant = plateauCourant.size();
		
		// Stocke le symbole demand� au d�but du tour.
		Symbole symboleDemande = this.getSymboleDebut();
		
		// Stocke la valeur de la carte la plus grande.
		Valeur valeur;
		
		/* 
		 * Nombre de cartes supprim�es sur le plateau courant � cause d'un 
		 * symbole diff�rent de celui demand�.
		 */
		int nbSupp = 0;
		
		/* 
		 * Parcours des cartes du plateau pour v�rifier quelles ont bien toutes 
		 * le m�me symbole. Si une ou plusieurs n'ont pas le m�me symbole alors 
		 * elles sont supprim�es de la copie du plateau.
		 */
		for (int i = 0 ; i < taillePlateauCourant ; i++) {
			
			/* 
			 * V�rifie si le symbole de la carte courante est �quivalent � 
			 * celui demand� au d�but du tour.
			 */
			if (!plateauCourant.get(i - nbSupp).getSymbole()
					                           .equals(symboleDemande)) {
				
				// Retire s'ils ne sont pas �quivalent.
				plateauCourant.remove(plateauCourant.get(i - nbSupp));
				nbSupp++;    // Incr�mente le nombre de suppressions.
			}
		}
		
		// Tri les cartes restantes sur le plateau dans l'ordre croissant.
		plateauCourant.sort(Carte.ordreCroissant);
		
		// R�cup�re la valeur de la derni�re carte du plateau (plus grande).
		valeur = plateauCourant.get(plateauCourant.size() - 1).getValeur();
		
		// Retourne l'indice du joueur ayant la carte la plus grande.
		return rechercherCarte(joueurs, symboleDemande, valeur);
	}
	
	
	/**
	 * 
	 * @param joueurs Les joueurs de la partie.
	 */
	public void retirerCartesJouees(Joueur[] joueurs) {
		
		for (Carte carteCourante : this.cartes) {
			int i = rechercherCarte(joueurs, carteCourante.getSymbole(), 
					                         carteCourante.getValeur());
				
			joueurs[i].retirerCarte(carteCourante);
		}
		
		this.vider();
	}
	
	
	/**
	 * Cette m�thode retourne un bool�en �gal � vrai si au moins une carte 
	 * coeur est pr�sente sur le plateau de jeu � la fin d'un tour.
	 * @return Un bool�en exprimant la pr�sence ou non d'au moins une carte 
	 *         ayant la valeur coeur.
	 */
	public boolean avecCoeur() {
		for (Carte carteCourante : this.cartes) {
			if (carteCourante.getSymbole().equals(Symbole.Coeur)) {
				return true;
			}
		}
		
		return false;
	}
	
	
	/**
	 * Cette m�thode retourne un bool�en �gal � vrai si la carte de la dame 
	 * de pique est pr�sente sur le plateau � la fin d'un tour.
	 * @return Un bool�en exprimant la pr�sence ou non de la dame de pique.
	 */
	public boolean avecDamePique() {
		for (Carte carteCourante : this.cartes) {
			if (carteCourante.getSymbole().equals(Symbole.Pique) 
				&& carteCourante.getValeur().equals(Valeur.Dame)) {
				
				return true;
			}
		}
		
		return false;
	}
	
	
	/**
	 * Cette m�thode calcule le nombre de points � ajouter au joueur qui perd 
	 * le tour. Elle teste tout d'abord la pr�sence de la dame de pique sur le 
	 * plateau avec la m�thode avecDamePique(), ensuite elle teste la pr�sence 
	 * de coeur sur le plateau avec la m�thode avecCoeur().
	 * 
	 * Si la dame de pique est sur le plateau, elle rajoute 13 points aux 
	 * points � ajouter. Si il y a des coeurs sur le plateau alors elle les 
	 * compte puis elle rajoute aux points � ajouter 1 point pour chaque coeur 
	 * pr�sent.
	 * @param joueurs Les joueurs de la partie.
	 */
	public void ajouterPointsTour(Joueur[] joueurs) {
		int aAjouter = 0;    // Le nombre de points a ajouter au perdant.
		
		/* 
		 * V�rifie si la dame de pique est sur le plateau. Si c'est le cas 
		 * alors 13 points sont automatiquement ajout�s aux points ajout�s.
		 */
		if(avecDamePique()) {
			aAjouter += 13;
		}
		
		// V�rifie la presence de coeurs sur le plateau.
		if(avecCoeur()) {
		
			int nbCoeurs = 0;    // Compteur du nombre de coeurs.
			
			// Parcours de toutes les cartes pr�sentes sur le plateau.
			for (Carte carteCourante : this.cartes) {
				
				// V�rifie si la carte courante poss�de le symbole coeur.
				if (carteCourante.getSymbole().equals(Symbole.Coeur)) {
					nbCoeurs++;
				}
			}
			
			aAjouter += nbCoeurs; 
		}
		
		// R�cup�re l'indice du perdant du tour courant.
		int indicePerdant = this.getPerdant(joueurs);
		
		// Ajoute les points � ajouter aux points de la manche courante.
		joueurs[indicePerdant].ajouterPointsManche(aAjouter);
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
