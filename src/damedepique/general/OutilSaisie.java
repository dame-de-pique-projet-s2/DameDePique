/*
 * OutilSaisie.java                                                  18/04/2019
 * Projet de la dame de pique | IUT de Rodez | 2018 - 2019
 */

package damedepique.general;

import java.util.Scanner;
import java.util.Arrays;
import java.util.Objects;

/**
 * TODO Faire la description de la classe utilitaire OutilSaisie.
 * @author Julien B.
 * @version 1.0
 */
public class OutilSaisie {

	/** Analyseur lexical de l'entrée standard texte. */
	private static Scanner sc = new Scanner(System.in);
	
	/**
	 * Change le pseudo d'un joueur.
	 * @param joueur Le joueur pour lequel il faut changer le pseudo.
	 * @param message Le message à afficher pour demander le 
	 *                nouveau pseudo au joueur.
	 */
	public static void changePseudo(Joueur joueur, String message) {
		String pseudo;      // Nouveau pseudo entré par le joueur.
		boolean correct;    // Indicateur de bonne saisie (pseudo valide).
		
		/* 
		 * Demande d'un nouveau pseudo au joueur. 
		 * Si celui-ci n'est pas valide alors la saisie est recommencée. 
		 */
		do {
			System.out.print(message);
			pseudo = sc.next() + sc.nextLine();
			
			/* 
			 * Vérifie si le nouveau pseudo donné n'est pas vide 
			 * ou que celui-ci ne contient pas que des espaces. 
			 */
			correct = !pseudo.isBlank();
			
			/*
			 * Affichage d'un message d'erreur si le pseudo 
			 * donné n'est pas valide. 
			 */
			if (!correct) {
				// TODO Faire un message d'erreur.
			}
		} while (!correct);
		
		joueur.setPseudo(pseudo);    // Mise à jour du pseudo.
	}
	
	/**
	 * Demande au joueur de rentrer un symbole.
	 * @param message Le message à afficher pour demander 
	 *        au joueur de rentrer un symbole.
	 * @return Le symbole valide d'une carte.
	 */
	public static String demandeSymbole(String message) {
		String symbole;     // Symbole entré par le joueur.
		boolean correct;    // Indicateur de bonne saisie (symbole valide).
		
		/* 
		 * Demande d'un symbole au joueur. Si celui-ci n'est pas valide 
		 * alors la saisie est recommencée. 
		 */
		do {
			System.out.print(message);
			symbole = sc.next() + sc.nextLine();
			correct = symboleEstValide(symbole);
			
			/*
			 * Affichage d'un message d'erreur en rappelant 
			 * les choix possibles contenus dans le tableau SYMBOLES.
			 */
			if (!correct) {
				System.out.println("\nLe symbole que vous avez entré n'est "
			                       + "pas valide. \nSymboles possibles : "
						           + Arrays.toString(Carte.SYMBOLES) + "\n");
			}
		} while (!correct);
		
		return symbole;
	}
	
	/**
	 * Demande au joueur de rentrer un ordre.
	 * @param message Le message à afficher pour demander 
	 *        au joueur de rentrer un ordre.
	 * @return L'ordre valide d'une carte.
	 */
	public static String demandeOrdre(String message) {
		String ordre;       // Ordre entré par le joueur.
		boolean correct;    // Indicateur de bonne saisie (ordre valide).
		
		/*
		 * Demande d'un ordre au joueur. Si celui-ci n'est pas valide
		 * alors la saisie est recommencée. 
		 */
		do {
			System.out.print(message);
			ordre = sc.next() + sc.nextLine();
			correct = ordreEstValide(ordre);
			
			/*
			 * Affichage d'un message d'erreur en rappelant 
			 * les choix possibles contenus dans le tableau ORDRES.
			 */
			if (!correct) {
				System.out.println("\nL'ordre que vous avez entré n'est" 
			                       + "pas valide. \nOrdres possibles : " 
						           + Arrays.toString(Carte.ORDRES) + "\n");
			}
		} while (!correct);
		
		return ordre;
	}
	
	/**
	 * Vérifie si un symbole donné est valide ou non.
	 * @param aVerifier Le symbole à vérifier.
	 * @return Vrai si le symbole est dans [ Carreau - Coeur - Pique - Trefle ]
	 *         sinon la fonction retourne faux.
	 */
	public static boolean symboleEstValide(String aVerifier) {
		/*
		 * Vérifie si la référence de l'objet String passée en paramètre
		 * est égale à null. Si l'objet n'est pas référencé alors la fonction
		 * renvoie faux pour éviter une exception.
		 * 
		 * Si la longueur de la chaîne à vérifier n'est pas compris entre 
		 * 5 et 7 alors la fonction renvoie faux et cela évite de rentrer 
		 * dans la boucle.
		 */
		if (Objects.isNull(aVerifier) 
			|| 5 > aVerifier.length() || aVerifier.length() > 7 ) {
			
			return false;
		}
		
		/*
		 * Recherche d'une occurence entre la valeur aVerifier et un élement
		 * du tableau des symboles.
		 */
		for (String symbole : Carte.SYMBOLES) {
			if (aVerifier.equalsIgnoreCase(symbole)) {
				// A la première occurence trouvée, la fonction renvoie vrai.
				return true;
			}
		}
		
		/*
		 * Si aucune référence a été trouvée dans le tableau des symboles
		 * alors la fonction renvoie faux.
		 */
		return false;
	}
	
	/**
	 * Vérifie si un ordre donné est valide ou non.
	 * @param aVerifier L'ordre à vérifier.
	 * @return Vrai si l'ordre est dans l'intervalle des valeurs
	 *         [ 2 - 3 - .. - 10 - Valet - Dame - Roi - As ]
	 *         sinon la fonction retourne faux.
	 */
	public static boolean ordreEstValide(String aVerifier) {
		/*
		 * Vérifie si la référence de l'objet String passée en paramètre
		 * est égale à null. Si l'objet n'est pas référencé alors la fonction
		 * renvoie faux pour éviter une exception.
		 * 
		 * Si la longueur de la chaîne à vérifier n'est pas compris entre 
		 * 1 et 5 alors la fonction renvoie faux et cela évite de rentrer 
		 * dans la boucle.
		 */
		if (Objects.isNull(aVerifier) 
			|| 1 > aVerifier.length() || aVerifier.length() > 5) {
			
			return false;
		}
		
		/*
		 * Recherche d'une occurence entre la valeur aVerifier et un élement
		 * du tableau des ordres.
		 */
		for (String ordre : Carte.ORDRES) {
			if (aVerifier.equalsIgnoreCase(ordre)) {
				// A la première occurence trouvée, la fonction renvoie vrai.
				return true;
			}
		}
		
		/*
		 * Si aucune référence a été trouvée dans le tableau des ordres
		 * alors la fonction renvoie faux.
		 */
		return false;
	}
	
}
