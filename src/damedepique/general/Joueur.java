/*
 * Joueur.java                                                       25/04/2019
 * Projet de la dame de pique | IUT de Rodez | 2018 - 2019
 */

package damedepique.general;

import static damedepique.general.OutilSaisie.*;
import static damedepique.general.OutilPartie.*;

import java.util.ArrayList;
import java.util.Objects;

/**
 * <p>
 *   Cette classe contient tous les �l�ments qui caract�risent un joueur 
 *   jouant au jeu de la dame de pique. Un joueur est caract�ris� par un pseudo 
 *   non modifiable qui lui est assign� par d�faut, un nombre de points qui 
 *   �volue au cours de la partie et d'une main dans laquelle le joueur poss�de 
 *   les cartes qu'il peut jouer.
 * </p>
 * 
 * @author Julien B.
 * @version 1.0
 */
public class Joueur {

	/** Pseudo de ce (this) Joueur. */
	private Pseudo pseudo;
	
	
	/** Nombre de points de ce (this) Joueur. */
	private int points;
	
	
	/** Carte(s) dans la main de ce (this) Joueur. */
	private ArrayList<Carte> main;
	
	
	/**
	 * Cr�ation d'un nouveau joueur auquel est associ� un pseudonyme g�n�r� 
	 * al�atoirement parmi une liste de pseudonymes pr�d�finis, un nombre de 
	 * point nul et d'un ensemble de cartes constituant sa main.
	 */
	public Joueur() {
		this.affectationPseudo();    // Affecte un pseudo par d�faut.
		this.main = new ArrayList<>();
		this.points = 0;
	}
	
	
	/* * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * *
	 * * * * * * * * * * * * * * PARTIE PSEUDO * * * * * * * * * * * * * * *
	 * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * */
	
	/**
	 * R�cup�re le pseudonyme de ce (this) Joueur.
	 * @return Le pseudo du joueur.
	 */
	public Pseudo getPseudo() {
		return this.pseudo;
	}
	
	
	/**
	 * G�n�re et affecte un pseudonyme al�atoire pour ce (this) Joueur.
	 * Les pseudonymes g�n�r�s al�atoirement sont pr�d�finis. Il n'est pas 
	 * possible pour le joueur de changer son pseudonyme.
	 * @see damedepique.general.Pseudo
	 */
	private void affectationPseudo() {
		// Stocke dans un tableau tous les pseudonymes pr�d�finis.
		Pseudo[] pseudos = Pseudo.values();
		
		// Indice g�n�r� al�atoirement pour la recherche d'un pseudonyme.
		int indiceAleatoire;
		
		// G�n�ration d'un indice correspondant � un pseudonyme.
		indiceAleatoire = (int) Math.floor(Math.random() * pseudos.length);
		
		// Attribution du pseudonyme par d�faut � ce (this) Joueur.
		this.pseudo = pseudos[indiceAleatoire];
	}
	
	
	/* * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * *
	 * * * * * * * * * * * * * * PARTIE POINTS * * * * * * * * * * * * * * *
	 * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * */
	
	/**
	 * R�cup�re les points de ce (this) Joueur sous la forme d'un entier.
	 * @return Le(s) point(s) du joueur.
	 */
	public int getPoints() {
		return this.points;
	}
	
	
	/**
	 * Ajoute des points � ce (this) Joueur.
	 * @param aAjouter Le nombre de points � ajouter.
	 */
	public void ajouterPoints(int aAjouter) {
		this.points += aAjouter;
	}
	
	
	/* * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * *
	 * * * * * * * * * * * * * * PARTIE MAIN * * * * * * * * * * * * * * * *
	 * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * */
	
	/**
	 * R�cup�re la main de ce (this) Joueur.
	 * @return Les cartes dans la main du joueur.
	 */
	public ArrayList<Carte> getMain() {
		return this.main;
	}
	
	
	/**
	 * Trie les cartes dans la main de ce (this) Joueur.
	 * Cette m�thode aide le joueur dans sa partie pour ne pas perdre de 
	 * temps � jouer une carte. Attention, cette m�thode change l'�tat de la 
	 * main du joueur concern�.
	 */
	public void trierMain() {
		// Tri les cartes dans la main du joueur suivant un ordre croissant.
		this.main.sort(Carte.ordreCroissant);
	}
	
	
	/**
	 * Ajoute une carte dans la main de ce (this) Joueur.
	 * @param aAjouter La carte � ajouter.
	 */
	public void ajouterCarte(Carte aAjouter) {
		this.main.add(aAjouter);
	}
	
	
	/**
	 * Retire une carte de la main de ce (this) Joueur.
	 * @param aRetirer La carte � retirer.
	 */
	public void retirerCarte(Carte aRetirer) {
		this.main.remove(aRetirer);
	}
	
	
	@Override
	public String toString() {
		String listeCartes = "";
		
		for (Carte carte : this.main) {
			listeCartes += "\n    => " + carte.toString();
		}
		
		return this.pseudo.toString() + " (" + this.points + " points)" 
		                              + listeCartes;
	}
	
	
	/**
	 * ...
	 * @return La carte jou�e par cet (this) Humain.
	 */
	public Carte jouerCarte() {
		boolean nok;        // Indicateur de mauvaise carte choisie.
		
		Carte carte;        // Carte choisie par le joueur.
		Symbole symbole;    // Symbole de la carte choisie par le joueur.
		Valeur valeur;      // Valeur de la carte choisie par le joueur.
		
		System.out.println(this + "\n");
		
		do {
			valeur = saisirValeur("Entrez la valeur d'une carte � jouer : ");
			symbole = saisirSymbole("Entrez le symbole d'une carte � jouer : ");
			carte = recuperationCarte(this, symbole, valeur);
			
			nok = Objects.isNull(carte);
			
			if (nok) {
				System.out.println("\nCette carte n'est pas dans votre main.\n"
						           + "Veuillez choisir une carte disponible "
						           + "dans votre main de jeu.\n" + this + "\n");
			}
		} while (nok);
		
		return carte;
	}
	
	
	/**
	 * 
	 * @param symboleDemande
	 * @return La carte jou�e par cet (this) Humain.
	 */
	public Carte jouerCarte(Symbole symboleDemande) {
		boolean nok;        // Indicateur de mauvaise carte choisie.
		
		Carte carte;        // Carte choisie par le joueur.
		Symbole symbole;    // Symbole de la carte choisie par le joueur.
		Valeur valeur;      // Valeur de la carte choisie par le joueur.
		
		System.out.println(this);
		
		ArrayList<Carte> cartesPossibles;
		cartesPossibles = cartesPossibles(this, symboleDemande);
		System.out.println("\nCarte(s) que vous (" +  this.getPseudo() +") "
				           + "pouvez jouer :"
				           + afficherCartesPossibles(cartesPossibles) + "\n");
		
		do {
			valeur = saisirValeur("Entrez la valeur d'une carte � jouer : ");
			symbole = saisirSymbole("Entrez le symbole d'une carte � jouer : ");
			carte = recuperationCarte(this, symbole, valeur);
			
			nok = Objects.isNull(carte) 
			      || !estCartePossible(this, symboleDemande, carte);
			
			if (nok) {
				System.out.println("\nVous ne pouvez pas jouer cette carte.\n"
						           + "Voici les cartes que vous pouvez jouer "
						           + "pour ce tour."
						           + afficherCartesPossibles(cartesPossibles) 
						           + "\n");
			}
		} while (nok);
		
		return carte;
	}
	
}
