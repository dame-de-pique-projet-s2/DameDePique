/*
 * Plateau.java                                                      28/04/2019
 * Projet de la dame de pique | IUT de Rodez | 2018 - 2019
 */

package damedepique.general;

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
	 * @param symboleDemande 
	 * @param joueurs 
	 * @return L'indice du joueur ayant perdu le tour.
	 */
	public int getPerdant(Symbole symboleDemande, Joueur[] joueurs) {
		
		ArrayList<Carte> plateauCourant = this.cartes;
		
		/* 
		 * Si le symbole jou� durant le tour ne correspond pas au symbole 
		 * annonc� au d�but du tour alors le joueur ne peut pas perdre le tour.
		 */
		for (int i = 0 ; i < this.cartes.size() ; i++) {
			if (!plateauCourant.get(i).getSymbole().equals(symboleDemande)) {
				plateauCourant.remove(plateauCourant.get(i));
			} else {
				// 2 - 3 - 6 - roi     / Oui - Oui - Oui
				//if (this.cartes.get(i).getValeur().compareTo(this.cartes.get(i + 1).getValeur()) < 0) {
					//System.out.println("Oui !");
				//} else {
					//System.out.println("Non !");
				//}
			}
		}
		
		return 0;
	}
	
	
	// TODO Faire le comptage des points � chaque tour.
	
	
	@Override
	public String toString() {
		String listeCartes = "";
		
		for (Carte carte : this.cartes) {
			listeCartes += "\n    => " + carte.toString();
		}
		
		return listeCartes;
	}
	
}
