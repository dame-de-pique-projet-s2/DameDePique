/*
 * Humain.java                                                       30/04/2019
 * Projet de la dame de pique | IUT de Rodez | 2018 - 2019
 */

package damedepique.general;

import static damedepique.general.OutilCarte.*;
import static damedepique.general.OutilSaisie.*;

import java.util.Objects;

/**
 * Cette classe contient toutes les m�thodes qui caract�risent un joueur humain
 * ainsi que ses moyens d'int�ractions sur le jeu
 * @author Lo�c B. Julien B. Margaux B. Justine R.
 * @version 1.0
 */
public class Humain extends Joueur {

	/**
	 * Cr�ation d'un humain avec les caract�ristiques d'un joueur.
	 * @see damedepique.general.Joueur
	 */
	public Humain() {
		super();
	}
	
	
	/**
	 * Demande � cet (this) Humain d'entrer trois cartes � �changer lors de 
	 * l'�change des trois cartes en d�but de manche entre les quatre joueurs.
	 * @return Un tableau contenant les trois cartes � �changer.
	 */
	public Carte[] choisirCartesAEchanger() {	
		
		Carte[] aEchanger = new Carte[3];
		
		/* Demande trois fois de choisir une carte au joueur. */
		for (int i = 0 ; i < aEchanger.length ; i++) {
			
			// Demande une carte et la stocke dans la case courante.
			aEchanger[i] = this.jouerCarte();
			
			// Retire la carte s�lectionn�e de la main du joueur.
			this.retirerCarte(aEchanger[i]);
		}
		
		return aEchanger;  
	}
	
	
	/**
	 * Demande � cet (this) Humain d'entrer une carte afin de la jouer.
	 * Il n'a aucune restriction mis � part d'entrer une carte pr�sente 
	 * dans sa main.
	 * @return La carte jou�e par cet (this) Humain.
	 */
	public Carte jouerCarte() {
		
		boolean nok; // Indicateur de non pr�sence de la carte choisie dans la main
		
		Carte carte;        // Carte choisie par le joueur.
		Symbole symbole;    // Symbole de la carte choisie par le joueur.
		Valeur valeur;      // Valeur de la carte choisie par le joueur.
		
		// Affichage les cartes pr�sentes dans la main du joueur.
		afficherCartes(this.getMain());
		
		// TOFIX : am�liorer l'algorithme de demande de carte
		do {
			// Demande � cet (this) Humain d'entrer la valeur d'une carte.
			valeur = saisirValeur("Entrez la valeur d'une carte : ");
			
			// Demande � cet (this) Humain d'entrer le symbole d'une carte.
			symbole = saisirSymbole("Entrez le symbole d'une carte : ");
			
			/*
			 * R�cup�re la carte jou�e dans la main du joueur � partir du 
			 * symbole et de la valeur donn�s.
			 */
			carte = recuperationCarte(this, symbole, valeur);
			
			/*
			 * Si la carte correspondant au symbole et � la valeur jou�s 
			 * pr�c�demment n'est pas pr�sente dans la main du joueur alors la 
			 * valeur renvoy�e par l'instruction ant�rieure est null. 
			 * L'indicateur de mauvaise carte choisie passe donc � vrai pour 
			 * que la demande soit renouvel�e.
			 */
			nok = Objects.isNull(carte);
			
			// Affichage d'un message d'indication au joueur.
			if (nok) {
				System.out.println("\nCette carte n'est pas dans votre main.\n"
						           + "Veuillez choisir une carte disponible "
						           + "dans votre main de jeu.\n"); 
				
				// Affichage les cartes pr�sentes dans la main du joueur.
				afficherCartes(this.getMain());
			}
		} while (nok);
		
		return carte;    // Retourne la carte jou�e par le joueur.
	}
	
	
	/**
	 * Demande � cet (this) Humain d'entrer une carte afin de la jouer.
	 * Le joueur doit jouer une carte poss�dant le m�me symbole mentionn� en 
	 * argument sinon la demande est renouvel�. Si le joueur ne poss�de pas de 
	 * carte ayant le m�me symbole que celui mentionn� alors, le joueur peut 
	 * jouer n'importe quelle carte.
	 * @param symboleDemande Le symbole demand�.
	 * @return La carte jou�e par cet (this) Humain.
	 */
	public Carte jouerCarte(Symbole symboleDemande, int premierJoueur) {
		boolean nok;        // Indicateur de mauvaise carte choisie.
		
		Carte carte;        // Carte choisie par le joueur.
		Symbole symbole;    // Symbole de la carte choisie par le joueur.
		Valeur valeur;      // Valeur de la carte choisie par le joueur.
		
		// Affichage les cartes pr�sentes dans la main du joueur.
		afficherCartes(this.getMain());
		
		// Affichage les cartes possibles pour jouer dans la main du jouer.
		System.out.println("\nCarte(s) que vous pouvez jouer : ");		           
		afficherCartes(this.getCartesPossibles());
		
		do {
			// Demande � cet (this) Humain d'entrer la valeur d'une carte.
			valeur = saisirValeur("Entrez la valeur d'une carte : ");
						
			// Demande � cet (this) Humain d'entrer le symbole d'une carte.
			symbole = saisirSymbole("Entrez le symbole d'une carte : ");
			
			/*
			 * R�cup�re la carte jou�e dans la main du joueur � partir du 
			 * symbole et de la valeur donn�s.
			 */
			carte = recuperationCarte(this, symbole, valeur);
			
			/*
			 * Si la carte correspondante au symbole et � la valeur jou�e 
			 * pr�c�demment n'est pas pr�sente dans la main du joueur ou n'est 
			 * pas dans la liste des cartes possibles alors l'indicateur de 
			 * carte non pr�sente passe � vrai pour que la demande soit 
			 * renouvel�e.
			 */
			nok = Objects.isNull(carte) 
			      || !estCartePossible(this, carte, premierJoueur);
			
			// Affichage d'un message d'indication au joueur.
			if (nok) {
				System.out.println("\nVous ne pouvez pas jouer cette carte.\n"
						           + "Voici les cartes que vous pouvez jouer "
						           + "pour ce tour.\n");
				
				// Affichage les cartes possibles pour jouer.
				afficherCartes(this.getCartesPossibles());
			}
		} while (nok);
		
		return carte;    // Retourne la carte jou�e par le joueur.
	}
	
	/**
	 * A supprimer plus tard
	 * @return aJouer
	 */
	/* TODO : Faire quelque chose de mieux et arranger le code dans DameDePique */
	public Carte jouerDeuxTrefle() {
		boolean nok;
		
		Carte aJouer;
		Symbole symbole;
		Valeur valeur;
		
		do {
			valeur = saisirValeur("Entrez la valeur d'une carte � jouer : ");
			symbole = saisirSymbole("Entrez le symbole d'une carte � jouer : ");
			
			aJouer = recuperationCarte(this, Symbole.Trefle, Valeur.Deux);
			nok = !estEgale(aJouer, symbole, valeur);
			
			// TODO Faire un message plus explicite.
			if (nok) {
				System.out.println("\nIl faut jouer le " 
			                       + aJouer.toString().toLowerCase() + "\n");
			}
		} while (nok);
		
		return aJouer;
	}
	
}
