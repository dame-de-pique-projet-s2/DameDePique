/*
 * GestionInterface.java                                             23/04/2019
 * Projet de la dame de pique | IUT de Rodez | 2018 - 2019
 */

package damedepique.general;

import java.util.Arrays;
import java.util.Objects;
import java.util.Scanner;

/**
 * <p>
 *   Cette classe contient tous les outils nécessaires à l'affichage de 
 *   l'application sur une console texte.
 * </p>
 * <ul>
 *   <li>
 *     
 *   </li>
 *   <li>
 *     La méthode optionEstValide(String) vérifie si une option 
 *     appartient ou non au tableau de caractères OPTIONS_MENU.
 *   </li>
 *   <li>
 *     La méthode demandeOptionMenuPrincipal(String) demande de rentrer une 
 *     option du menu principal. Si l'option entrée par l'utilisateur n'est 
 *     pas valide alors la saisie est recommencée.
 *   </li>
 * </ul>
 * @author Julien B.
 * @version 1.0
 */
public class GestionInterface {
	
	/** Analyseur lexical de l'entrée standard texte. */
	private static final Scanner sc = new Scanner(System.in);
	
	/** Texte de titre pour le menu. */
	private static final String TITRE_MENU = 
			"------------------------------------------------------------\n"
			+ "|                      MENU PRINCIPAL                      |\n"
			+ "------------------------------------------------------------\n";
	
	/** Liste de libellés associés à chacune des options du menu. */
	private static final String[] LIBELLE_MENU = {
			"Jouer une partie de dame de pique",
			"Afficher l'aide du jeu",
			"Quitter le jeu" };
	
	/** Tableau contenant les options possibles pour le menu. */
	public static final char[] OPTIONS_MENU = { 'j', '?', 'q' };
	
	/** Affiche le menu principal de l'application. */
	public static void afficherMenuPrincipal() {
		System.out.println(TITRE_MENU);
		
		// On affiche toutes les options du menu principal.
		for (int i = 0 ; i < OPTIONS_MENU.length ; i++) {
			System.out.println("    => " + OPTIONS_MENU[i] + " - "
					           + LIBELLE_MENU[i]);
		}
		
		System.out.println("\n        => ");
	}
	
	/**
	 * Vérifie si une option donnée appartient bien au tableau des options 
	 * valides OPTIONS_MENU.
	 * @param aVerifier L'option à vérifier.
	 * @return Vrai si l'option entrée est dans le tableau des options valides 
	 *         sinon faux.
	 */
	public static boolean optionEstValide(String aVerifier) {
		/*
		 * Vérifie si la référence de l'objet String passée en paramètre
		 * est égale à null. Si l'objet n'est pas référencé alors la fonction
		 * renvoie faux pour éviter une exception.
		 * 
		 * Si la longueur de la chaîne à vérifier n'est pas exactement égale 
		 * à 1 alors la fonction renvoie faux et cela évite de rentrer dans 
		 * la boucle.
		 */
		if (Objects.isNull(aVerifier) || aVerifier.length() != 1) {
			return false;
		}
		
		/*
		 * Recherche d'une occurence entre la valeur aVerifier et un élement
		 * du tableau des options.
		 */
		for (char option : OPTIONS_MENU) {
			if (aVerifier.toLowerCase().charAt(0) == option) {
				// A la première occurence trouvée, la fonction renvoie vrai.
				return true;
			}
		}
		
		/*
		 * Si aucune référence n'a été trouvée dans le tableau des options
		 * alors la fonction renvoie faux.
		 */
		return false;
	}
	
	/**
	 * Demande au joueur d'entrer une option pour le menu.
	 * @param message Le message à afficher pour demander 
	 *                au joueur de rentrer une option.
	 * @return L'option valide entrée par l'utilisateur.
	 */
	public static char demandeOptionMenu(String message) {
		String option;      // Option entrée par le joueur.
		boolean correct;    // Indicateur de bonne saisie (ordre valide).
		
		/*
		 * Demande d'une option au joueur. Si celle-ci n'est pas valide
		 * alors la saisie est recommencée. 
		 */
		do {
			// Affichage d'un message pour demander d'entrer une option.
			System.out.print(message);
			option = sc.next() + sc.nextLine();
			correct = optionEstValide(option);
			
			/*
			 * Affichage d'un message d'erreur en rappelant les choix possibles 
			 * contenus dans le tableau OPTIONS_MENU.
			 */
			if (!correct) {
				System.out.println("\nL'option que vous avez entrée n'est" 
			                       + " pas valide. \nOptions possibles : " 
				                   + Arrays.toString(OPTIONS_MENU) + "\n");
			}
		} while (!correct);
		
		return option.charAt(0);
	}

}
