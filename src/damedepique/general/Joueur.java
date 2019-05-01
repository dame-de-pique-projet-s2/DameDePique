/*
 * Joueur.java                                                       25/04/2019
 * Projet de la dame de pique | IUT de Rodez | 2018 - 2019
 */

package damedepique.general;

import static damedepique.general.OutilSaisie.*;
import static damedepique.general.OutilPartie.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Objects;

/**
 * <p>
 *   Cette classe contient tous les éléments qui caractérisent un joueur 
 *   jouant au jeu de la dame de pique. Un joueur est caractérisé par un pseudo 
 *   non modifiable qui lui est assigné par défaut, un nombre de points qui 
 *   évolue au cours de la partie et d'une main dans laquelle le joueur possède 
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
	 * Création d'un nouveau joueur auquel est associé un pseudonyme généré 
	 * aléatoirement parmi une liste de pseudonymes prédéfinis, un nombre de 
	 * point nul et d'un ensemble de cartes constituant sa main.
	 */
	public Joueur() {
		this.affectationPseudo();    // Affecte un pseudo par défaut.
		this.main = new ArrayList<>();
		this.points = 0;
	}
	
	
	/* * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * *
	 * * * * * * * * * * * * * * PARTIE PSEUDO * * * * * * * * * * * * * * *
	 * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * */
	
	/**
	 * Récupère le pseudonyme de ce (this) Joueur.
	 * @return Le pseudo du joueur.
	 */
	public Pseudo getPseudo() {
		return this.pseudo;
	}
	
	
	/**
	 * Génère et affecte un pseudonyme aléatoire pour ce (this) Joueur.
	 * Les pseudonymes générés aléatoirement sont prédéfinis. Il n'est pas 
	 * possible pour le joueur de changer son pseudonyme.
	 * @see damedepique.general.Pseudo
	 */
	private void affectationPseudo() {
		// Stocke dans un tableau tous les pseudonymes prédéfinis.
		Pseudo[] pseudos = Pseudo.values();
		
		// Indice généré aléatoirement pour la recherche d'un pseudonyme.
		int indiceAleatoire;
		
		// Génération d'un indice correspondant à un pseudonyme.
		indiceAleatoire = (int) Math.floor(Math.random() * pseudos.length);
		
		// Attribution du pseudonyme par défaut à ce (this) Joueur.
		this.pseudo = pseudos[indiceAleatoire];
	}
	
	
	/* * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * *
	 * * * * * * * * * * * * * * PARTIE POINTS * * * * * * * * * * * * * * *
	 * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * */
	
	/**
	 * Récupère les points de ce (this) Joueur sous la forme d'un entier.
	 * @return Le(s) point(s) du joueur.
	 */
	public int getPoints() {
		return this.points;
	}
	
	
	/**
	 * Ajoute des points à ce (this) Joueur.
	 * @param aAjouter Le nombre de points à ajouter.
	 */
	public void ajouterPoints(int aAjouter) {
		this.points += aAjouter;
	}
	
	
	/* * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * *
	 * * * * * * * * * * * * * * PARTIE MAIN * * * * * * * * * * * * * * * *
	 * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * */
	
	/**
	 * Récupère la main de ce (this) Joueur.
	 * @return Les cartes dans la main du joueur.
	 */
	public ArrayList<Carte> getMain() {
		return this.main;
	}
	
	
	/**
	 * Trie les cartes dans la main de ce (this) Joueur.
	 * Cette méthode aide le joueur dans sa partie pour ne pas perdre de 
	 * temps à jouer une carte. Attention, cette méthode change l'état de la 
	 * main du joueur concerné.
	 */
	public void trierMain() {
		// Tri les cartes dans la main du joueur suivant un ordre croissant.
		this.main.sort(Carte.ordreCroissant);
	}
	
	
	/**
	 * Ajoute une carte dans la main de ce (this) Joueur.
	 * @param aAjouter La carte à ajouter.
	 */
	public void ajouterCarte(Carte aAjouter) {
		this.main.add(aAjouter);
	}
	
	
	/**
	 * Retire une carte de la main de ce (this) Joueur.
	 * @param aRetirer La carte à retirer.
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
	 * @return La carte jouée par cet (this) Humain.
	 */
	public Carte jouerCarte() {
		// FIXME Améliorer l'algorithme.
		boolean ok;
		
		Symbole symbole;    // Symbole entré par le joueur de la carte à jouer.
		Valeur valeur;      // Valeur entrée par le joueur de la carte à jouer.
		Carte carte;
		
		do {
			valeur = saisirValeur("Entrez la valeur d'une carte : ");
			symbole = saisirSymbole("Entrez le symbole d'une carte : ");
			carte = recuperationCarte(this, symbole, valeur);
			ok = !Objects.isNull(carte);
			
			if (!ok) {
				System.out.println("Cette carte n'est pas dans votre main.\n"
						           + "Veuillez choisir une carte disponible "
						           + "dans votre main de jeu.\n" + this);
			}
		} while (!ok);
		
		return carte;
	}
	
	
	/**
	 * 
	 * @param symboleDemande
	 * @return La carte jouée par cet (this) Humain.
	 */
	public Carte jouerCarte(Symbole symboleDemande) {
		// FIXME Améliorer l'algorithme.
		boolean ok;
		
		Symbole symbole;
		Valeur valeur;
		Carte carte;
		
		do {
			valeur = saisirValeur("Entrez la valeur d'une carte : ");
			symbole = saisirSymbole("Entrez le symbole d'une carte : ");
			carte = recuperationCarte(this, symbole, valeur);
			
			if (Objects.isNull(carte)) {
				System.out.println("Cette carte n'est pas dans votre main.\n"
		                           + "Veuillez choisir une carte disponible "
		                           + "dans votre main de jeu.\n" + this);
			} else if (!estCartePossible(this, symboleDemande, carte)) {
				System.out.println("Vous ne pouvez pas jouer cette carte !\n"
						           + "Vous trouvez ci-dessous la liste des "
						           + "cartes possibles : \n" + Arrays.toString(cartesPossibles(this, symboleDemande).toArray()));
			}
		} while (Objects.isNull(carte) || estCartePossible(this, symboleDemande, carte));
		
		return carte;
	}
	
	
	/**
	 * 
	 */
	
}
