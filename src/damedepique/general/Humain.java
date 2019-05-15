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
 *   Ces actions sont principalement basées sur le jeu d'un carte avec des 
 *   vérifications visant à confirmer la validité de la carte jouée.
 * </p>
 * 
 * @author Julien B.
 * @author Loïc B.
 * @author Margaux B.
 * @author Justine R.
 * 
 * @version 1.0
 * 
 * @see damedepique.general.Joueur
 */
public class Humain extends Joueur {

	/** Analyseur lexical de l'entrée standard texte. */
	private static Scanner sc = new Scanner(System.in);
	
	
	/** Valeur impossible lors des saisies d'indice de carte. */
	private static final int IMPOSSIBLE = -1;
	
	
	/**
	 * Création d'un nouveau humain avec les caractéristiques d'un joueur.
	 * @param pseudo Le pseudo de cet (this) Humain.
	 */
	public Humain(String pseudo) {
		super(pseudo);
	}
	
	
	/**
	 * Demande à cet (this) Humain d'entrer l'indice (la position) d'une carte 
	 * afin de la jouer. Il n'y a aucune restriction mis à part d'entrer un 
	 * indice d'une carte présente dans sa main.
	 */
	public Carte jouerCarte() {
		// Cartes jouables dans la main de cet (this) Humain.
		ArrayList<Carte> cartesJouables = this.getMain();
		
		boolean nok;        // Indicateur de mauvaise carte choisie.
		int indiceCarte;    // Indice de la carte choisie.
		
		// Affichage des cartes jouables dans la main de cet (this) Humain.
		afficherCartesIndice(cartesJouables, 
				             "\n### Les cartes que vous pouvez échanger : ");
		
		do {
			// Affichage d'un message demandant l'indice de la carte à jouer.
			System.out.print("~ Entrez la position d'une carte à échanger : ");
			
			/*
			 * Demande et stockage de l'indice de la carte à jouer. Si la 
			 * valeur entrée par le joueur n'est pas un entier alors la valeur 
			 * affectée à la variable est -1 (valeur impossible) pour que la 
			 * saisie soit recommencée.
			 */
			indiceCarte = sc.hasNextInt() ? sc.nextInt() : IMPOSSIBLE;
			
			/* 
			 * Vérifie si l'indice donné est bien compris dans l'intervalle 
			 * des cartes jouables.
			 */
			nok = (indiceCarte < 0 || cartesJouables.size() <= indiceCarte);
			
			// Affichage d'un message d'indication au joueur.
			if (nok) {
				System.out.println("\nLa position que vous avez donné ne "
						           + "correspond à aucune carte dans votre "
						           + "main.\nMerci d'entrer une position de "
						           + "carte comprise entre 0 et " 
						           + (cartesJouables.size() - 1) + ".\n");
			}
			
			sc.nextLine();    // Vidage du tampon.
		} while (nok);
		
		// Retourne la carte jouée par le joueur.
		return cartesJouables.get(indiceCarte);
	}
	
	
	/**
	 * Demande à cet (this) Humain d'entrer l'indice (la position) d'une carte 
	 * afin de la jouer. La carte jouée ne doit pas être un coeur si aucune 
	 * carte possédant un coeur n'a été encore défaussé dans la manche.
	 */
	public Carte jouerCarte(boolean coeurDefausse) {
		System.out.println("### C'est à vous de commencer ce tour car vous "
				           + "avez perdu le tour précedent.\n");
		
		// Cartes jouables dans la main de ce (this) Humain.
		ArrayList<Carte> cartesJouables = cartesPossibles(this, coeurDefausse);
		
		boolean nok;        // Indicateur de mauvaise carte choisie.
		int indiceCarte;    // Indice de la carte choisie.
		
		// Affichage les cartes présentes dans la main du joueur.
		afficherCartes(this.getMain(), "### Votre main actuelle : ");
	    
		// Affichage des cartes jouables dans la main de cet (this) Humain.
		afficherCartesIndice(cartesJouables, 
				             "### Les cartes que vous pouvez jouer : ");
		
		do {
			// Affichage d'un message demandant l'indice de la carte à jouer.
			System.out.print("~ Entrez la position d'une carte à jouer : ");
			
			/*
			 * Demande et stockage de l'indice de la carte à jouer. Si la 
			 * valeur entrée par le joueur n'est pas un entier alors la valeur 
			 * affectée à la variable est -1 (valeur impossible) pour que la 
			 * saisie soit recommencée.
			 */
			indiceCarte = sc.hasNextInt() ? sc.nextInt() : IMPOSSIBLE;
			
			/* 
			 * Vérifie si l'indice donné est bien compris dans l'intervalle 
			 * des cartes jouables.
			 */
			nok = (indiceCarte < 0 || cartesJouables.size() <= indiceCarte);
			
			// Affichage d'un message d'indication au joueur.
			if (nok) {
				System.out.println("\nLa position que vous avez donné ne "
				                    + "correspond à aucune carte dans les "
				                    + "cartes que vous pouvez jouer.\nMerci "
				                    + "d'entrer une position de carte comprise"
				                    + " entre 0 et " 
				                    + (cartesJouables.size() - 1) + ".\n");
			}
			
			sc.nextLine();    // Vidage du tampon.
		} while (nok);
		
		// Retourne la carte jouée par le joueur.
		return cartesJouables.get(indiceCarte);
	}
	
	
	/**
	 * Demande à cet (this) Humain d'entrer l'indice (la position) d'une carte 
	 * afin de la jouer. La carte choisie doit possédé le même symbole que le 
	 * symbole demandé au début d'un tour. Si cette méthode est appelée au 
	 * premier tour d'une manche alors toutes les cartes possédant du coeur 
	 * et la dame de pique ne sont pas jouables.
	 */
	public Carte jouerCarte(Symbole symboleDemande, int noTour) {
		// Cartes jouables dans la main de ce (this) Humain.
		ArrayList<Carte> cartesJouables = cartesPossibles(this, symboleDemande, 
				                                                noTour);
		
		boolean nok;        // Indicateur de mauvaise carte choisie.
		int indiceCarte;    // Indice de la carte choisie.
		
		// Affichage les cartes présentes dans la main du joueur.
		afficherCartes(this.getMain(), "### Votre main actuelle : ");
		
		// Affichage les cartes possibles pour jouer dans la main du jouer.
		afficherCartesIndice(cartesJouables, 
				             "### Les cartes que vous pouvez jouer : ");
		
		do {
			// Affichage d'un message demandant l'indice de la carte à jouer.
			System.out.print("~ Entrez la position d'une carte à jouer : ");
			
			/*
			 * Demande et stockage de l'indice de la carte à jouer. Si la 
			 * valeur entrée par le joueur n'est pas un entier alors la valeur 
			 * affectée à la variable est -1 (valeur impossible) pour que la 
			 * saisie soit recommencée.
			 */
			indiceCarte = sc.hasNextInt() ? sc.nextInt() : IMPOSSIBLE;
			
			/* 
			 * Vérifie si l'indice donné est bien compris dans l'intervalle 
			 * des cartes jouables.
			 */
			nok = (indiceCarte < 0 || cartesJouables.size() <= indiceCarte);
			
			// Affichage d'un message d'indication au joueur.
			if (nok) {
				System.out.println("\nLa position que vous avez donné ne "
	                               + "correspond à aucune carte dans les "
	                               + "cartes que vous pouvez jouer.\nMerci "
	                               + "d'entrer une position de carte comprise"
	                               + " entre 0 et " 
	                               + (cartesJouables.size() - 1) + ".\n");
			}
			
			sc.nextLine();
		} while (nok);
		
		// Retourne la carte jouée par le joueur.
		return cartesJouables.get(indiceCarte);
	}
	
	
	/**
	 * Demande à cet (this) Humain d'entrer l'indice de la carte comportant le 
	 * deux de trèfle situé dans sa main.
	 */
	public Carte jouerDeuxTrefle() {
		System.out.println("### C'est à vous de commencer cette manche, vous "
				           + "avez le deux de trèfle.\n");
		
		// Récupère les cartes dans la main de ce (this) Humain.
		ArrayList<Carte> mainJoueur = this.getMain();
		
		boolean nok;        // Indicateur de mauvaise carte choisie.
		int indiceCarte;    // Indice de la carte choisie.
		
		// Stockage de l'indice du deux de trèfle.
		int indiceDeuxTrefle = indiceDeuxTrefle(this);
		
		// Affichage des cartes dans la main de cet (this) Humain.
		afficherCartesIndice(mainJoueur, 
				             "### Les cartes que vous pouvez jouer : ");
		
		/*
		 * Si le joueur entre un indice différent de celui du deux 
		 * de trèfle alors la saisie est recommencée.
		 */
		do {
			// Affichage d'un message demandant l'indice du deux de trèfle.
			System.out.print("~ Entrez la position du deux de trèfle : ");
						
			/*
			 * Demande et stockage de l'indice de la carte à jouer. Si la 
			 * valeur entrée par le joueur n'est pas un entier alors la valeur 
			 * affectée à la variable est -1 (valeur impossible) pour que la 
			 * saisie soit recommencée.
			 */
			indiceCarte = sc.hasNextInt() ? sc.nextInt() : IMPOSSIBLE;
			
			// Vérifie si l'indice donné est égal à celui du deux de trèfle.
			nok = (indiceDeuxTrefle != indiceCarte);
			
			// Affichage d'un message d'indication au joueur.
			if (nok) {
				System.out.println("\nVous possédez le deux de trèfle dans "
						           + "votre main.\nVous êtes obligé de le "
						           + "jouer pour commencer cette manche.\nLe "
						           + "deux de trèfle est à la position numéro " 
						           + indiceDeuxTrefle + " dans votre main.\n");
			}
			
			sc.nextLine();    // Vidage du tampon.
		} while (nok);
		
		// Retourne le deux de trèfle joué par le joueur.
		return mainJoueur.get(indiceCarte);
	}
	
	
	/**
	 * Demande à cet (this) Humain d'entrer trois cartes à échanger lors de 
	 * l'échange des trois cartes entre les quatre joueurs en début de manche.
	 */
	public Carte[] choisirCartesAEchanger() {	
		// Initialise un tableau de trois éléments de type Carte.
		Carte[] aEchanger = new Carte[3];
		
		// Demande trois fois de choisir une carte au joueur.
		for (int i = 0 ; i < aEchanger.length ; i++) {
			System.out.println("### Échange numéro " + (i + 1) + " sur 3.");
			
			// Demande une carte et la stocke dans la case courante.
			aEchanger[i] = this.jouerCarte();
			
			// Retire la carte sélectionnée de la main du joueur.
			this.retirerCarte(aEchanger[i]);
			
			cls();
		}
		
		// Renvoie le tableau contenant les trois cartes à échanger.
		return aEchanger;
	}
	
}
