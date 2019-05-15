/*
 * Humain.java                                                       11/05/2019
 * Projet de la dame de pique | IUT de Rodez | 2018 - 2019
 */

package damedepique.general;

import static damedepique.general.OutilCarte.*;
import static damedepique.general.OutilAffichage.*;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * <p>
 *   Cette classe contient toutes les actions qu'un joueur humain peut faire.
 *   Ces actions sont principalement bas�es sur le jeu d'un carte avec des 
 *   v�rifications visant � confirmer la validit� de la carte jou�e.
 * </p>
 * 
 * @author Julien B.
 * @author Lo�c B.
 * @author Margaux B.
 * @author Justine R.
 * 
 * @version 1.0
 * 
 * @see damedepique.general.Joueur
 */
public class Humain extends Joueur {

	/** Analyseur lexical de l'entr�e standard texte. */
	private static Scanner sc = new Scanner(System.in);
	
	
	/** Valeur impossible lors des saisies d'indice de carte. */
	private static final int IMPOSSIBLE = -1;
	
	
	/**
	 * Cr�ation d'un nouveau humain avec les caract�ristiques d'un joueur.
	 * @param pseudo Le pseudo de cet (this) Humain.
	 */
	public Humain(String pseudo) {
		super(pseudo);
	}
	
	
	/**
	 * Demande � cet (this) Humain d'entrer l'indice (la position) d'une carte 
	 * afin de la jouer. Il n'y a aucune restriction mis � part d'entrer un 
	 * indice d'une carte pr�sente dans sa main.
	 */
	public Carte jouerCarte() {
		// Cartes jouables dans la main de cet (this) Humain.
		ArrayList<Carte> cartesJouables = this.getMain();
		
		boolean nok;        // Indicateur de mauvaise carte choisie.
		int indiceCarte;    // Indice de la carte choisie.
		
		// Affichage des cartes jouables dans la main de cet (this) Humain.
		afficherCartesIndice(cartesJouables, 
				             "\n### Les cartes que vous pouvez �changer : ");
		
		do {
			// Affichage d'un message demandant l'indice de la carte � jouer.
			System.out.print("~ Entrez la position d'une carte � �changer : ");
			
			/*
			 * Demande et stockage de l'indice de la carte � jouer. Si la 
			 * valeur entr�e par le joueur n'est pas un entier alors la valeur 
			 * affect�e � la variable est -1 (valeur impossible) pour que la 
			 * saisie soit recommenc�e.
			 */
			indiceCarte = sc.hasNextInt() ? sc.nextInt() : IMPOSSIBLE;
			
			/* 
			 * V�rifie si l'indice donn� est bien compris dans l'intervalle 
			 * des cartes jouables.
			 */
			nok = (indiceCarte < 0 || cartesJouables.size() <= indiceCarte);
			
			// Affichage d'un message d'indication au joueur.
			if (nok) {
				System.out.println("\nLa position que vous avez donn� ne "
						           + "correspond � aucune carte dans votre "
						           + "main.\nMerci d'entrer une position de "
						           + "carte comprise entre 0 et " 
						           + (cartesJouables.size() - 1) + ".\n");
			}
			
			sc.nextLine();    // Vidage du tampon.
		} while (nok);
		
		// Retourne la carte jou�e par le joueur.
		return cartesJouables.get(indiceCarte);
	}
	
	
	/**
	 * Demande � cet (this) Humain d'entrer l'indice (la position) d'une carte 
	 * afin de la jouer. La carte jou�e ne doit pas �tre un coeur si aucune 
	 * carte poss�dant un coeur n'a �t� encore d�fauss� dans la manche.
	 */
	public Carte jouerCarte(boolean coeurDefausse) {
		System.out.println("### C'est � vous de commencer ce tour car vous "
				           + "avez perdu le tour pr�cedent.\n");
		
		// Cartes jouables dans la main de ce (this) Humain.
		ArrayList<Carte> cartesJouables = cartesPossibles(this, coeurDefausse);
		
		boolean nok;        // Indicateur de mauvaise carte choisie.
		int indiceCarte;    // Indice de la carte choisie.
		
		// Affichage les cartes pr�sentes dans la main du joueur.
		afficherCartes(this.getMain(), "### Votre main actuelle : ");
	    
		// Affichage des cartes jouables dans la main de cet (this) Humain.
		afficherCartesIndice(cartesJouables, 
				             "### Les cartes que vous pouvez jouer : ");
		
		do {
			// Affichage d'un message demandant l'indice de la carte � jouer.
			System.out.print("~ Entrez la position d'une carte � jouer : ");
			
			/*
			 * Demande et stockage de l'indice de la carte � jouer. Si la 
			 * valeur entr�e par le joueur n'est pas un entier alors la valeur 
			 * affect�e � la variable est -1 (valeur impossible) pour que la 
			 * saisie soit recommenc�e.
			 */
			indiceCarte = sc.hasNextInt() ? sc.nextInt() : IMPOSSIBLE;
			
			/* 
			 * V�rifie si l'indice donn� est bien compris dans l'intervalle 
			 * des cartes jouables.
			 */
			nok = (indiceCarte < 0 || cartesJouables.size() <= indiceCarte);
			
			// Affichage d'un message d'indication au joueur.
			if (nok) {
				System.out.println("\nLa position que vous avez donn� ne "
				                    + "correspond � aucune carte dans les "
				                    + "cartes que vous pouvez jouer.\nMerci "
				                    + "d'entrer une position de carte comprise"
				                    + " entre 0 et " 
				                    + (cartesJouables.size() - 1) + ".\n");
			}
			
			sc.nextLine();    // Vidage du tampon.
		} while (nok);
		
		// Retourne la carte jou�e par le joueur.
		return cartesJouables.get(indiceCarte);
	}
	
	
	/**
	 * Demande � cet (this) Humain d'entrer l'indice (la position) d'une carte 
	 * afin de la jouer. La carte choisie doit poss�d� le m�me symbole que le 
	 * symbole demand� au d�but d'un tour. Si cette m�thode est appel�e au 
	 * premier tour d'une manche alors toutes les cartes poss�dant du coeur 
	 * et la dame de pique ne sont pas jouables.
	 */
	public Carte jouerCarte(Symbole symboleDemande, int noTour) {
		// Cartes jouables dans la main de ce (this) Humain.
		ArrayList<Carte> cartesJouables = cartesPossibles(this, symboleDemande, 
				                                                noTour);
		
		boolean nok;        // Indicateur de mauvaise carte choisie.
		int indiceCarte;    // Indice de la carte choisie.
		
		// Affichage les cartes pr�sentes dans la main du joueur.
		afficherCartes(this.getMain(), "### Votre main actuelle : ");
		
		// Affichage les cartes possibles pour jouer dans la main du jouer.
		afficherCartesIndice(cartesJouables, 
				             "### Les cartes que vous pouvez jouer : ");
		
		do {
			// Affichage d'un message demandant l'indice de la carte � jouer.
			System.out.print("~ Entrez la position d'une carte � jouer : ");
			
			/*
			 * Demande et stockage de l'indice de la carte � jouer. Si la 
			 * valeur entr�e par le joueur n'est pas un entier alors la valeur 
			 * affect�e � la variable est -1 (valeur impossible) pour que la 
			 * saisie soit recommenc�e.
			 */
			indiceCarte = sc.hasNextInt() ? sc.nextInt() : IMPOSSIBLE;
			
			/* 
			 * V�rifie si l'indice donn� est bien compris dans l'intervalle 
			 * des cartes jouables.
			 */
			nok = (indiceCarte < 0 || cartesJouables.size() <= indiceCarte);
			
			// Affichage d'un message d'indication au joueur.
			if (nok) {
				System.out.println("\nLa position que vous avez donn� ne "
	                               + "correspond � aucune carte dans les "
	                               + "cartes que vous pouvez jouer.\nMerci "
	                               + "d'entrer une position de carte comprise"
	                               + " entre 0 et " 
	                               + (cartesJouables.size() - 1) + ".\n");
			}
			
			sc.nextLine();
		} while (nok);
		
		// Retourne la carte jou�e par le joueur.
		return cartesJouables.get(indiceCarte);
	}
	
	
	/**
	 * Demande � cet (this) Humain d'entrer l'indice de la carte comportant le 
	 * deux de tr�fle situ� dans sa main.
	 */
	public Carte jouerDeuxTrefle() {
		System.out.println("### C'est � vous de commencer cette manche, vous "
				           + "avez le deux de tr�fle.\n");
		
		// R�cup�re les cartes dans la main de ce (this) Humain.
		ArrayList<Carte> mainJoueur = this.getMain();
		
		boolean nok;        // Indicateur de mauvaise carte choisie.
		int indiceCarte;    // Indice de la carte choisie.
		
		// Stockage de l'indice du deux de tr�fle.
		int indiceDeuxTrefle = indiceDeuxTrefle(this);
		
		// Affichage des cartes dans la main de cet (this) Humain.
		afficherCartesIndice(mainJoueur, 
				             "### Les cartes que vous pouvez jouer : ");
		
		/*
		 * Si le joueur entre un indice diff�rent de celui du deux 
		 * de tr�fle alors la saisie est recommenc�e.
		 */
		do {
			// Affichage d'un message demandant l'indice du deux de tr�fle.
			System.out.print("~ Entrez la position du deux de tr�fle : ");
						
			/*
			 * Demande et stockage de l'indice de la carte � jouer. Si la 
			 * valeur entr�e par le joueur n'est pas un entier alors la valeur 
			 * affect�e � la variable est -1 (valeur impossible) pour que la 
			 * saisie soit recommenc�e.
			 */
			indiceCarte = sc.hasNextInt() ? sc.nextInt() : IMPOSSIBLE;
			
			// V�rifie si l'indice donn� est �gal � celui du deux de tr�fle.
			nok = (indiceDeuxTrefle != indiceCarte);
			
			// Affichage d'un message d'indication au joueur.
			if (nok) {
				System.out.println("\nVous poss�dez le deux de tr�fle dans "
						           + "votre main.\nVous �tes oblig� de le "
						           + "jouer pour commencer cette manche.\nLe "
						           + "deux de tr�fle est � la position num�ro " 
						           + indiceDeuxTrefle + " dans votre main.\n");
			}
			
			sc.nextLine();    // Vidage du tampon.
		} while (nok);
		
		// Retourne le deux de tr�fle jou� par le joueur.
		return mainJoueur.get(indiceCarte);
	}
	
	
	/**
	 * Demande � cet (this) Humain d'entrer trois cartes � �changer lors de 
	 * l'�change des trois cartes entre les quatre joueurs en d�but de manche.
	 */
	public Carte[] choisirCartesAEchanger() {	
		// Initialise un tableau de trois �l�ments de type Carte.
		Carte[] aEchanger = new Carte[3];
		
		// Demande trois fois de choisir une carte au joueur.
		for (int i = 0 ; i < aEchanger.length ; i++) {
			System.out.println("### �change num�ro " + (i + 1) + " sur 3.");
			
			// Demande une carte et la stocke dans la case courante.
			aEchanger[i] = this.jouerCarte();
			
			// Retire la carte s�lectionn�e de la main du joueur.
			this.retirerCarte(aEchanger[i]);
			
			cls();
		}
		
		// Renvoie le tableau contenant les trois cartes � �changer.
		return aEchanger;
	}
	
}
