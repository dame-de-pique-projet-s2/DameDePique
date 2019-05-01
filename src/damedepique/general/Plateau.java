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
	
	
	// TODO Faire le comptage des points � chaque tour.
	// TODO Faire la determination du perdant, le joueur qui a jou� la plus grosse carte.
	
	
	@Override
	public String toString() {
		String listeCartes = "";
		
		for (Carte carte : this.cartes) {
			listeCartes += "\n    => " + carte.toString();
		}
		
		return listeCartes;
	}
	
}
