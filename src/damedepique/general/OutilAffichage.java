/*
 * OutilAffichage.java                                               12/05/2019
 * Projet de la dame de pique | IUT de Rodez | 2018 - 2019
 */

package damedepique.general;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * <p>
 *   TODO Faire la description de cette classe.
 *   TODO Finir de commenter les méthodes.
 * </p>
 * 
 * @author Julien B.
 * @author Loïc B.
 * @author Margaux B.
 * @author Justine R.
 * 
 * @version 1.0
 */
public class OutilAffichage {
	
	/** Analyseur lexical de l'entrée standard texte. */
	private static Scanner sc = new Scanner(System.in);
	
	
	/**
	 * 
	 */
	public static void continuer() {
		System.out.println("Appuyez sur entrée pour continuer la partie.");
		sc.nextLine();
		// TODO Nettoyage de la console.
	}
	
	
	// TODO Affichage du plateau avec le nom des joueurs.
	
	
	/**
	 * Affiche une liste de cartes sans les indices associés.
	 * @param cartes Une liste de cartes à afficher.
	 * @param message Le message à afficher avec la liste de cartes.
	 */
	public static void afficherCartes(ArrayList<Carte> cartes, 
			                          String message) {
		System.out.println(message);
		
		for (Carte carte : cartes) {
			System.out.println("=> " + carte);
		}
		
		System.out.println();
	}
	
	
	/**
	 * Affiche une liste de cartes avec les indices associés.
	 * @param cartes Une liste de cartes à afficher.
	 * @param message Le message à afficher avec la liste de cartes.
	 */
	public static void afficherCartesIndice(ArrayList<Carte> cartes, 
			                                String message) {
		System.out.println(message);
		
		for (Carte carte : cartes) {
			System.out.println("(" + cartes.indexOf(carte) + ") => " + carte);
		}
		
		System.out.println();
	}
	
	
	/**
	 * Affiche le pseudonyme des joueurs de la partie.
	 * @param joueurs Les joueurs de la partie.
	 */
	public static void afficherJoueurs(Joueur[] joueurs) {
		System.out.println("Les joueurs de la partie : ");
		for (Joueur joueur : joueurs) {
			if (joueur instanceof Humain) {
				System.out.println("    > " + joueur.getPseudo() + " (vous)");
			} else {
				System.out.println("    > " + joueur.getPseudo());
			}
		}
	}
	
	
	/**
	 * Affiche un récapitulatif des points d'une manche.
	 * @param joueurs Les joueurs de la partie.
	 * @param noTour Le numéro du tour dans la manche.
	 * @param premier L'indice du joueur qui débute le prochain tour (perdant).
	 */
	public static void afficherRecapManche(Joueur[] joueurs, int noTour, 
			                                                 int premier) {
		
		System.out.println(joueurs[premier].getPseudo() + " a perdu(e) le "
				           + "tour numéro " + (noTour + 1) + " sur 13.");
		
		System.out.println("Récapitulatif des points de cette manche : ");
		for (Joueur joueur : joueurs) {
			System.out.println("    > " + joueur.getPseudo() + " a " 
		                       + joueur.getPointsManche() + " point(s).");
		}
		
		System.out.println();
	}
	
	
	/**
	 * Affiche un récapitulatif des points totaux de chaque joueurs.
	 * @param joueurs Les joueurs de la partie.
	 * @param noManche Le numéro de la manche dans la partie.
	 */
	public static void afficherRecapPartie(Joueur[] joueurs, int noManche) {
		System.out.println("Récapitulatif des points de la partie : ");
		
		for (Joueur joueur : joueurs) {
			System.out.println("    > " + joueur.getPseudo() + " a " 
		                      + joueur.getPointsTot() + " point(s) au total.");
		}
		
		System.out.println();
	}
	
	
	/**
	 * Affiche le plateau dans un état intermédiaire, au cours d'un tour.
	 * @param plateau Le plateau de la partie.
	 */
	public static void afficherPlateauActuel(Plateau plateau) {
		afficherCartes(plateau.getCartes(), "Le plateau actuel : ");
	}
	
	
	/**
	 * Affiche le plateau dans son état final, à la fin d'un tour avec les 
	 * quatre cartes disposées sur le plateau.
	 * @param plateau Le plateau de la partie.
	 */
	public static void afficherPlateauFinal(Plateau plateau) {
		afficherCartes(plateau.getCartes(), "Le plateau final : ");
	}
	
	
	public static void afficherNumeroTour(int noTour) {
		System.out.println("\n/!\\ Début du tour numéro " + (noTour + 1) + ".\n");
	}
	
	
	public static void afficherNumeroManche(int noManche) {
		System.out.println("/!\\ Début de la manche numéro " + (noManche + 1) + ".");
	}
	
}
