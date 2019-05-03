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
	
	
	/**
	 * Demande au joueur humain d'entrer trois cartes à échanger lors de 
	 * l'échange des trois cartes entre les quatre joueurs en début de manche.
	 */
	public void choisirCartesAEchanger() {
		// Vide les cartes à échanger de la manche précédente.
		this.viderCartesAEchanger();
		
		Carte aEchanger;    // Une carte à échanger avec un autre joueur.
		
		// Demande trois fois de choisir une carte au joueur.
		for (int i = 0 ; i < NB_CARTES_A_ECHANGER ; i++) {
			aEchanger = this.jouerCarte();
			
			// Retire la carte à échanger de la main du joueur.
			this.retirerCarte(aEchanger);
			
			// Ajoute la carte à échanger dans la liste des cartes à échanger.
			this.ajouterCarteAEchanger(aEchanger);
		}
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
	
	
	/**
	 * 
	 * @return .
	 */
	public Carte jouerDeuxTrefle() {
		boolean nok;
		
		Carte aJouer;
		Symbole symbole;
		Valeur valeur;
		
		do {
			valeur = saisirValeur("Entrez la valeur d'une carte à jouer : ");
			symbole = saisirSymbole("Entrez le symbole d'une carte à jouer : ");
			
			aJouer = recuperationCarte(this, Symbole.Trefle, Valeur.Deux);
			nok = !estEgale(aJouer, symbole, valeur);
			
			if (nok) {
				System.out.println("\nIl faut jouer le " 
			                       + aJouer.toString().toLowerCase() + "\n");
			}
		} while (nok);
		
		return aJouer;
	}
	
}
