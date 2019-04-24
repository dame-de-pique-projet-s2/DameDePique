/*
 * OutilSaisie.java                                                  18/04/2019
 * Projet de la dame de pique | IUT de Rodez | 2018 - 2019
 */

package damedepique.general;

import java.util.Scanner;
import java.util.Arrays;
import java.util.Objects;

/**
 * <p>
 *   Cette classe contient des méthodes outils pour effectuer des saisies.
 * </p>
 * <ul>
 *   <li>
 *     La méthode symboleEstValide(String) vérifie si un symbole appartient 
 *     ou non au tableau des valeurs possibles Carte.SYMBOLES.
 *   </li>
 *   <li>
 *     La méthode ordreEstValide(String) vérifie si un ordre appartient
 *     ou non au tableau des valeurs possibles Carte.ORDRES.
 *   </li>
 *   <li>
 *     La méthode demandeSymbole(String) demande à un joueur de rentrer un 
 *     symbole. Si le symbole donné par l'utilisateur n'est pas valide alors 
 *     la saisie est recommencée.
 *   </li>
 *   <li>
 *     La méthode demandeOrdre(String) demande à un joueur de rentrer un ordre.
 *     Si l'ordre donné par l'utilisateur n'est pas valide alors 
 *     la saisie est recommencée.
 *   </li>
 *   <li>
 *     La méthode generationPseudo() permet de générer un indice de pseudo 
 *     aléatoire parmi une liste de pseudonymes prédéfinis.
 *   </li>
 * </ul>
 * 
 * @author Julien B.
 * @version 1.0
 */
public class OutilSaisie {

	/** Analyseur lexical de l'entrée standard texte. */
	private static final Scanner sc = new Scanner(System.in);
	
	/**
	 * Vérifie si un symbole donné est valide ou non.
	 * @param aVerifier Le symbole à vérifier.
	 * @return Vrai si le symbole est dans le tableau Carte.SYMBOLES 
	 *         sinon faux.
	 * @see damedepique.general.Carte
	 */
	public static boolean symboleEstValide(String aVerifier) {
		/*
		 * Vérifie si la référence de l'objet String passée en paramètre
		 * est égale à null. Si l'objet n'est pas référencé alors la fonction
		 * renvoie faux pour éviter une exception.
		 * 
		 * Si la longueur de la chaîne à vérifier n'est pas comprise entre 
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
		 * Si aucune référence n'a été trouvée dans le tableau des symboles
		 * alors la fonction renvoie faux.
		 */
		return false;
	}
	
	/**
	 * Vérifie si un ordre donné est valide ou non.
	 * @param aVerifier L'ordre à vérifier.
	 * @return Vrai si l'ordre est dans le tableau Carte.ORDRES sinon faux.
	 * @see damedepique.general.Carte
	 */
	public static boolean ordreEstValide(String aVerifier) {
		/*
		 * Vérifie si la référence de l'objet String passée en paramètre
		 * est égale à null. Si l'objet n'est pas référencé alors la fonction
		 * renvoie faux pour éviter une exception.
		 * 
		 * Si la longueur de la chaîne à vérifier n'est pas comprise entre 
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
		 * Si aucune référence n'a été trouvée dans le tableau des ordres
		 * alors la fonction renvoie faux.
		 */
		return false;
	}
	
	/**
	 * Demande au joueur d'entrer un symbole.
	 * @param message Le message à afficher pour demander 
	 *                au joueur de rentrer un symbole.
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
			// Affichage d'un message pour demander d'entrer un symbole.
			System.out.print(message);
			symbole = sc.next() + sc.nextLine();
			correct = symboleEstValide(symbole);
			
			/*
			 * Affichage d'un message d'erreur en rappelant 
			 * les choix possibles contenus dans le tableau Carte.SYMBOLES.
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
	 * Demande au joueur d'entrer un ordre.
	 * @param message Le message à afficher pour demander 
	 *                au joueur de rentrer un ordre.
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
			// Affichage d'un message pour demander d'entrer un ordre.
			System.out.print(message);
			ordre = sc.next() + sc.nextLine();
			correct = ordreEstValide(ordre);
			
			/*
			 * Affichage d'un message d'erreur en rappelant 
			 * les choix possibles contenus dans le tableau Carte.ORDRES.
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
	 * Génère un indice de pseudo aléatoire permis une liste préétablie.
	 * @return Un indice de pseudonyme généré aléatoirement.
	 * @see damedepique.general.Joueur
	 */
	public static int generationPseudo() {
		int indice;    // Indice du tableau générée aléatoirement.
		
		// Génération d'un indice aléatoire.
		indice = (int) Math.floor(Math.random() * Joueur.PSEUDOS.length);
		
		return indice;
	}
	
}
