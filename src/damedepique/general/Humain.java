/*
 * Humain.java                                                       30/04/2019
 * Projet de la dame de pique | IUT de Rodez | 2018 - 2019
 */

package damedepique.general;

import static damedepique.general.OutilCarte.*;
import static damedepique.general.OutilSaisie.*;

import java.util.ArrayList;
import java.util.Objects;

/**
 * <p>
 *   
 * </p>
 * 
 * @author Julien B.
 * @version 1.0
 */
public class Humain extends Joueur {

	/**
	 * Création d'un nouveau humain avec les caractéristiques d'un joueur.
	 * @see damedepique.general.Joueur
	 */
	public Humain() {
		super();
	}
	
	// FIXME Factoriser le code des méthodes.
	/**
	 * ...
	 * @return La carte jouée par cet (this) Humain.
	 */
	public Carte jouerCarte() {
		boolean nok;        // Indicateur de mauvaise carte choisie.
		
		Carte carte;        // Carte choisie par le joueur.
		Symbole symbole;    // Symbole de la carte choisie par le joueur.
		Valeur valeur;      // Valeur de la carte choisie par le joueur.
		
		System.out.println(this + "\n");
		
		do {
			valeur = saisirValeur("Entrez la valeur d'une carte à jouer : ");
			symbole = saisirSymbole("Entrez le symbole d'une carte à jouer : ");
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
	 * ...
	 * @param symboleDemande
	 * @return La carte jouée par cet (this) Humain.
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
				           + "pouvez jouer :");
				           
		afficherCartes(cartesPossibles);
		
		do {
			valeur = saisirValeur("Entrez la valeur d'une carte à jouer : ");
			symbole = saisirSymbole("Entrez le symbole d'une carte à jouer : ");
			carte = recuperationCarte(this, symbole, valeur);
			
			nok = Objects.isNull(carte) 
			      || !estCartePossible(this, symboleDemande, carte);
			
			if (nok) {
				System.out.println("\nVous ne pouvez pas jouer cette carte.\n"
						           + "Voici les cartes que vous pouvez jouer "
						           + "pour ce tour.");
				
				afficherCartes(cartesPossibles);
			}
		} while (nok);
		
		return carte;
	}
	
}
