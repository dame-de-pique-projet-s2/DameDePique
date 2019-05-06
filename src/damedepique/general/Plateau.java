/*
 * Plateau.java                                                      28/04/2019
 * Projet de la dame de pique | IUT de Rodez | 2018 - 2019
 */

package damedepique.general;

import static damedepique.general.OutilCarte.*;

import java.util.ArrayList;

/**
 * TODO Faire la description de la classe Plateau.
 * @author Julien B.
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
		
		// Stocke le symbole demand� au d�but du tour.
		Symbole symboleDemande = this.getSymboleDebut();
		
		// Stocke la valeur de la carte la plus grande.
		Valeur valeur;
		
		/* 
		 * Parcours des cartes du plateau pour v�rifier quelles ont bien toutes 
		 * le m�me symbole. Si une ou plusieurs n'ont pas le m�me symbole alors 
		 * elles sont supprim�es de la copie du plateau.
		 */
		for (int i = 0 ; i < plateauCourant.size() ; i++) {
			
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
	
	
	/**
	 * 
	 * @param joueurs Les joueurs de la partie.
	 */
	public void retirerCartesJouees(Joueur[] joueurs) {
		for (int i = 0 ; i < this.cartes.size() ; i++) {
			Carte carteJouee = this.cartes.get(i);
			int indice = rechercherCarte(joueurs, carteJouee.getSymbole(), 
					                              carteJouee.getValeur());
			
			joueurs[indice].retirerCarte(carteJouee);
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
		ArrayList<Carte> plateauCourant = this.cartes;
		
		for (int i = 0 ; i < plateauCourant.size() ; i++) {
			if (plateauCourant.get(i).getSymbole().equals(Symbole.Coeur)) {
				return true;
			}
		}
		
		return false;
	}
	
	
	/**
	 * 
	 * @return .
	 */
	public boolean avecDamePique() {
		ArrayList<Carte> plateauCourant = this.cartes;
		
		for (int i = 0 ; i < plateauCourant.size() ; i++) {
			if (plateauCourant.get(i).getSymbole().equals(Symbole.Pique) 
				&& plateauCourant.get(i).getValeur().equals(Valeur.Dame)) {
				
				return true;
			}
		}
		
		return false;
	}
	
	
	/**
	 * Cette m�thode calcule le nombre de points � ajouter au joueur qui perds 
	 * le tour. Elle teste tout d'abbord la presence de la dame de pique sur le 
	 * plateau avec la m�thode avecDamePique(), ensuite elle teste la presence 
	 * de coeur sur le plateau avec la m�thode avecCoeur().
	 * Si la dame de pique est sur le plateau, elle rajoute 13 points � la 
	 * valeur renvoy�e. Si il y a des coeurs sur le plateau alors elle les 
	 * compte puis elle rajoute � la valeur retourn�e 1 point pour chaque coeur 
	 * pr�sent.
	 *  
	 * @return Un entier repr�sentant le nombre de points � ajouter au perdant 
	 *         du tour.
	 */
	public int pointsAAjouter() {
		// On stocke les cartes pr�sentes sur le plateau courant. 
		ArrayList<Carte> plateauCourant = this.cartes;
		
		int aAjouter = 0;    // Le nombre de points a ajouter au perdant.
		
		// Bool�en indiquant si le plateau contient la dame de pique.
		boolean aDame = avecDamePique();

		// Bool�en indiquant si un plateau contient un ou des coeur(s).
		boolean aCoeur = avecCoeur();
		
		/* V�rifie si la dame de pique est sur le plateau */ 
		if(aDame) {
			aAjouter += 13;
		}
		
		/* La m�thode v�rifie la presence de coeurs sur le plateau */
		if(aCoeur) {
		
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
			
			aAjouter += nbCoeurs; 
		}
		
		return aAjouter;		
	}
	
	
	/**
	 * 
	 * @param joueurs
	 * @param indicePerdant 
	 */
	public void ajouterPointsTour(Joueur[] joueurs) {
		int aAjouter = this.pointsAAjouter();
		int indicePerdant = this.getPerdant(joueurs);
		joueurs[indicePerdant].ajouterPointsManche(aAjouter);
	}
	
	
	/**
	 * M�thode permettant de savoir si un joueur � r�ussi � d�m�nager � la 
	 * cloche de bois ou non.
	 * @param joueurs Les joueurs de la partie.
	 * @return Vrai si un joueur � r�ussi � accumuler 26 points durant une 
	 *         seule manche sinon faux.
	 */
	// TODO A mettre en static -> classe utilitaire.
	public boolean clocheReussie(Joueur[] joueurs) {
		for (int i = 0 ; i < joueurs.length ; i++) {
			if (joueurs[i].getPointsManche() == 26) {
				return true;
			}
		}
		
		return false;
	}
	
	
	/**
	 * M�thode qui donne 26 points � tous les joueurs sauf celui qui a r�alis�
	 * la cloche de bois
	 * 
	 * @param indiceJoueur Le joueur ayant r�alis� la cloche de bois
	 * @param joueurs Les joueurs de la partie 
	 */
	public void clocheBois(Joueur[] joueurs){
		int indice =-1;
		// On recherche le joueur qui a r�alis� la cloche
		for (int i=0;i<joueurs.length;i ++) {
			if (joueurs[i].getPointsManche() == 26 ) {
				indice = i; 
			}
		}
		
		// On �change les points. 
		for( int i = 0; i<joueurs.length; i++) {
			if(i != indice) {
				joueurs[i].modifPointsManche(26);
			} else {
				joueurs[i].modifPointsManche(0);
			}
		}
	}
	
	
	/**
	 * 
	 * @param joueurs
	 */
	public void ajouterPointsTot(Joueur[] joueurs) {		
		if (this.clocheReussie(joueurs)) {
			clocheBois(joueurs);
		} else {
			for (int j = 0 ; j < joueurs.length ; j++) {
				int pointsManche = joueurs[j].getPointsManche();
				joueurs[j].ajouterPointsTot(pointsManche);
				joueurs[j].viderPointsManche();
			}
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
