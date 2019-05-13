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
 *   TODO Finir de commenter les m�thodes.
 * </p>
 * 
 * @author Julien B.
 * @author Lo�c B.
 * @author Margaux B.
 * @author Justine R.
 * 
 * @version 1.0
 */
public class OutilAffichage {
	
	/** Analyseur lexical de l'entr�e standard texte. */
	private static Scanner sc = new Scanner(System.in);
	
	
	/**
	 * 
	 */
	public static void continuer() {
		System.out.println("Appuyez sur entr�e pour continuer la partie.");
		sc.nextLine();
		// TODO Nettoyage de la console.
	}
	
	
	// TODO Affichage du plateau avec le nom des joueurs.
	
	
	/**
	 * Affiche une liste de cartes sans les indices associ�s.
	 * @param cartes Une liste de cartes � afficher.
	 * @param message Le message � afficher avec la liste de cartes.
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
	 * Affiche une liste de cartes avec les indices associ�s.
	 * @param cartes Une liste de cartes � afficher.
	 * @param message Le message � afficher avec la liste de cartes.
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
	 * Affiche un r�capitulatif des points d'une manche.
	 * @param joueurs Les joueurs de la partie.
	 * @param noTour Le num�ro du tour dans la manche.
	 * @param premier L'indice du joueur qui d�bute le prochain tour (perdant).
	 */
	public static void afficherRecapManche(Joueur[] joueurs, int noTour, 
			                                                 int premier) {
		
		System.out.println(joueurs[premier].getPseudo() + " a perdu(e) le "
				           + "tour num�ro " + (noTour + 1) + " sur 13.");
		
		System.out.println("R�capitulatif des points de cette manche : ");
		for (Joueur joueur : joueurs) {
			System.out.println("    > " + joueur.getPseudo() + " a " 
		                       + joueur.getPointsManche() + " point(s).");
		}
		
		System.out.println();
	}
	
	
	/**
	 * Affiche un r�capitulatif des points totaux de chaque joueurs.
	 * @param joueurs Les joueurs de la partie.
	 * @param noManche Le num�ro de la manche dans la partie.
	 */
	public static void afficherRecapPartie(Joueur[] joueurs, int noManche) {
		System.out.println("R�capitulatif des points de la partie : ");
		
		for (Joueur joueur : joueurs) {
			System.out.println("    > " + joueur.getPseudo() + " a " 
		                      + joueur.getPointsTot() + " point(s) au total.");
		}
		
		System.out.println();
	}
	
	
	/**
	 * Affiche le plateau dans un �tat interm�diaire, au cours d'un tour.
	 * @param plateau Le plateau de la partie.
	 */
	public static void afficherPlateauActuel(Plateau plateau) {
		afficherCartes(plateau.getCartes(), "Le plateau actuel : ");
	}
	
	
	/**
	 * Affiche le plateau dans son �tat final, � la fin d'un tour avec les 
	 * quatre cartes dispos�es sur le plateau.
	 * @param plateau Le plateau de la partie.
	 */
	public static void afficherPlateauFinal(Plateau plateau) {
		afficherCartes(plateau.getCartes(), "Le plateau final : ");
	}
	
	
	public static void afficherNumeroTour(int noTour) {
		System.out.println("\n/!\\ D�but du tour num�ro " + (noTour + 1) + ".\n");
	}
	
	
	public static void afficherNumeroManche(int noManche) {
		System.out.println("/!\\ D�but de la manche num�ro " + (noManche + 1) + ".");
	}
	
}
