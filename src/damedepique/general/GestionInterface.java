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
 *   Cette classe contient tous les outils n�cessaires � l'affichage de 
 *   l'application sur une console texte.
 * </p>
 * <ul>
 *   <li>
 *     
 *   </li>
 *   <li>
 *     La m�thode optionEstValide(String) v�rifie si une option 
 *     appartient ou non au tableau de caract�res OPTIONS_MENU.
 *   </li>
 *   <li>
 *     La m�thode demandeOptionMenuPrincipal(String) demande de rentrer une 
 *     option du menu principal. Si l'option entr�e par l'utilisateur n'est 
 *     pas valide alors la saisie est recommenc�e.
 *   </li>
 * </ul>
 * @author Julien B.
 * @version 1.0
 */
public class GestionInterface {
	
	/** Analyseur lexical de l'entr�e standard texte. */
	private static final Scanner sc = new Scanner(System.in);
	
	/** Texte de titre pour le menu. */
	private static final String TITRE_MENU = 
			"------------------------------------------------------------\n"
			+ "|                      MENU PRINCIPAL                      |\n"
			+ "------------------------------------------------------------\n";
	
	/** Liste de libell�s associ�s � chacune des options du menu. */
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
	 * V�rifie si une option donn�e appartient bien au tableau des options 
	 * valides OPTIONS_MENU.
	 * @param aVerifier L'option � v�rifier.
	 * @return Vrai si l'option entr�e est dans le tableau des options valides 
	 *         sinon faux.
	 */
	public static boolean optionEstValide(String aVerifier) {
		/*
		 * V�rifie si la r�f�rence de l'objet String pass�e en param�tre
		 * est �gale � null. Si l'objet n'est pas r�f�renc� alors la fonction
		 * renvoie faux pour �viter une exception.
		 * 
		 * Si la longueur de la cha�ne � v�rifier n'est pas exactement �gale 
		 * � 1 alors la fonction renvoie faux et cela �vite de rentrer dans 
		 * la boucle.
		 */
		if (Objects.isNull(aVerifier) || aVerifier.length() != 1) {
			return false;
		}
		
		/*
		 * Recherche d'une occurence entre la valeur aVerifier et un �lement
		 * du tableau des options.
		 */
		for (char option : OPTIONS_MENU) {
			if (aVerifier.toLowerCase().charAt(0) == option) {
				// A la premi�re occurence trouv�e, la fonction renvoie vrai.
				return true;
			}
		}
		
		/*
		 * Si aucune r�f�rence n'a �t� trouv�e dans le tableau des options
		 * alors la fonction renvoie faux.
		 */
		return false;
	}
	
	/**
	 * Demande au joueur d'entrer une option pour le menu.
	 * @param message Le message � afficher pour demander 
	 *                au joueur de rentrer une option.
	 * @return L'option valide entr�e par l'utilisateur.
	 */
	public static char demandeOptionMenu(String message) {
		String option;      // Option entr�e par le joueur.
		boolean correct;    // Indicateur de bonne saisie (ordre valide).
		
		/*
		 * Demande d'une option au joueur. Si celle-ci n'est pas valide
		 * alors la saisie est recommenc�e. 
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
				System.out.println("\nL'option que vous avez entr�e n'est" 
			                       + " pas valide. \nOptions possibles : " 
				                   + Arrays.toString(OPTIONS_MENU) + "\n");
			}
		} while (!correct);
		
		return option.charAt(0);
	}

}
