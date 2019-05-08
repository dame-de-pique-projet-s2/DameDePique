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
 *   TODO Finir de commenter les méthodes.
 * </p>
 * 
 * @author Loïc B. | Julien B. | Margaux B. | Justine R.
 * @version 1.0
 */
public class Plateau {

	/** Nombre de cartes maximum sur un plateau de cartes. */
	private final int NB_CARTES_PLATEAU_MAX = 4;
	
	
	/** Cartes qui composent ce (this) Plateau. */
	private ArrayList<Carte> cartes;
	
	
	/** Création d'un nouveau plateau de jeu. */
	public Plateau() {
		this.cartes = new ArrayList<>(NB_CARTES_PLATEAU_MAX);
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
	 * Récupère l'indice du joueur perdant d'un tour. Le joueur perdant est 
	 * le joueur ayant posé la plus grosse carte sur le plateau de jeu.
	 * @param joueurs Les joueurs de la partie.
	 * @return L'indice du joueur ayant perdu le tour.
	 */
	public int getPerdant(Joueur[] joueurs) {
		// Copie du plateau courant pour ne pas changer son état.
		ArrayList<Carte> plateauCourant = new ArrayList<>();
		for (Carte carte : this.cartes) {
			plateauCourant.add(carte);
		}
		
		// Taille du plateau courant.
		int taillePlateauCourant = plateauCourant.size();
		
		// Stocke le symbole demandé au début du tour.
		Symbole symboleDemande = this.getSymboleDebut();
		
		// Stocke la valeur de la carte la plus grande.
		Valeur valeur;
		
		/* 
		 * Nombre de cartes supprimées sur le plateau courant à cause d'un 
		 * symbole différent de celui demandé.
		 */
		int nbSupp = 0;
		
		/* 
		 * Parcours des cartes du plateau pour vérifier quelles ont bien toutes 
		 * le même symbole. Si une ou plusieurs n'ont pas le même symbole alors 
		 * elles sont supprimées de la copie du plateau.
		 */
		for (int i = 0 ; i < taillePlateauCourant ; i++) {
			
			/* 
			 * Vérifie si le symbole de la carte courante est équivalent à 
			 * celui demandé au début du tour.
			 */
			if (!plateauCourant.get(i - nbSupp).getSymbole()
					                           .equals(symboleDemande)) {
				
				// Retire s'ils ne sont pas équivalent.
				plateauCourant.remove(plateauCourant.get(i - nbSupp));
				nbSupp++;    // Incrémente le nombre de suppressions.
			}
		}
		
		// Tri les cartes restantes sur le plateau dans l'ordre croissant.
		plateauCourant.sort(Carte.ordreCroissant);
		
		// Récupère la valeur de la dernière carte du plateau (plus grande).
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
	 * Cette méthode retourne un booléen égal à vrai si au moins une carte 
	 * coeur est présente sur le plateau de jeu à la fin d'un tour.
	 * @return Un booléen exprimant la présence ou non d'au moins une carte 
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
	 * Cette méthode retourne un booléen égal à vrai si la carte de la dame 
	 * de pique est présente sur le plateau à la fin d'un tour.
	 * @return Un booléen exprimant la présence ou non de la dame de pique.
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
	 * Cette méthode calcule le nombre de points à ajouter au joueur qui perd 
	 * le tour. Elle teste tout d'abord la présence de la dame de pique sur le 
	 * plateau avec la méthode avecDamePique(), ensuite elle teste la présence 
	 * de coeur sur le plateau avec la méthode avecCoeur().
	 * 
	 * Si la dame de pique est sur le plateau, elle rajoute 13 points aux 
	 * points à ajouter. Si il y a des coeurs sur le plateau alors elle les 
	 * compte puis elle rajoute aux points à ajouter 1 point pour chaque coeur 
	 * présent.
	 * @param joueurs Les joueurs de la partie.
	 */
	public void ajouterPointsTour(Joueur[] joueurs) {
		int aAjouter = 0;    // Le nombre de points a ajouter au perdant.
		
		/* 
		 * Vérifie si la dame de pique est sur le plateau. Si c'est le cas 
		 * alors 13 points sont automatiquement ajoutés aux points ajoutés.
		 */
		if(avecDamePique()) {
			aAjouter += 13;
		}
		
		// Vérifie la presence de coeurs sur le plateau.
		if(avecCoeur()) {
		
			int nbCoeurs = 0;    // Compteur du nombre de coeurs.
			
			// Parcours de toutes les cartes présentes sur le plateau.
			for (Carte carteCourante : this.cartes) {
				
				// Vérifie si la carte courante possède le symbole coeur.
				if (carteCourante.getSymbole().equals(Symbole.Coeur)) {
					nbCoeurs++;
				}
			}
			
			aAjouter += nbCoeurs; 
		}
		
		// Récupère l'indice du perdant du tour courant.
		int indicePerdant = this.getPerdant(joueurs);
		
		// Ajoute les points à ajouter aux points de la manche courante.
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
