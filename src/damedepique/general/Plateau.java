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
	 * Récupère le joueur perdant d'un tour. Le joueur perdant est le joueur 
	 * ayant posé la plus grosse carte sur le plateau de jeu.
	 * @return Le joueur ayant perdu le tour.
	 */
	public Joueur getPerdant() {
		
		
		/* 
		 * Si le symbole joué durant le tour ne correspond pas au symbole 
		 * annoncé au début du tour alors le joueur ne peut pas perdre le tour.
		 */
		
		return null;
	}
	
	
	// TODO Faire le comptage des points à chaque tour.
	
	
	@Override
	public String toString() {
		String listeCartes = "";
		
		for (Carte carte : this.cartes) {
			listeCartes += "\n    => " + carte.toString();
		}
		
		return listeCartes;
	}
	
}
