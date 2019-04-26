/*
 * OutilSaisie.java                                                  26/04/2019
 * Projet de la dame de pique | IUT de Rodez | 2018 - 2019
 */

package damedepique.general;

import java.util.Arrays;
import java.util.Objects;
import java.util.Scanner;

/**
 * <p>
 *   Cette classe contient des méthodes outils pour effectuer des saisies.
 * </p>
 * <ul>
 *   <li>
 *     
 *   </li>
 * </ul>
 * 
 * @author Julien B.
 * @version 1.0
 */
public class OutilSaisie {

	/** Analyseur lexical de l'entrée standard texte. */
	private static Scanner sc = new Scanner(System.in);
	
	
	/**
	 * Vérifie si un symbole donné est valide ou non.
	 * @param aVerifier Le symbole à vérifier.
	 * @return Vrai si le symbole est dans la liste des symboles sinon faux.
	 * @see damedepique.general.Symbole
	 */
	public static boolean symboleEstValide(String aVerifier) {
		/*
		 * Vérifie si la référence de l'objet String passée en paramètre est 
		 * égale à null. Si l'objet n'est pas référencé alors la méthode 
		 * renvoie faux pour éviter une exception.
		 * 
		 * Si la longueur de la chaîne à vérifier n'est pas comprise entre 
		 * 5 et 7 alors la méthode renvoie faux et cela évite de rentrer dans 
		 * la boucle pour ne trouver aucune occurrence.
		 */
		if (Objects.isNull(aVerifier) 
			|| 5 > aVerifier.length() || aVerifier.length() > 7) {
			
			return false;
		}
		
		/*
		 * Recherche d'une occurrence entre la valeur aVerifier passée en 
		 * paramètre et une valeur de la liste des symboles. Pour cette 
		 * recherche la casse est ignorée ce qui laisse de la liberté à 
		 * l'utilisateur lors de la saisie.
		 */
		for (Symbole symbole : Symbole.values()) {
			if (symbole.toString().equalsIgnoreCase(aVerifier)) {
				// A la première occurrence trouvée, la méthode renvoie vrai.
				return true;
			}
		}
		
		/*
		 * Si aucune référence n'a été trouvée dans la liste des symboles 
		 * alors le symbole entré par l'utilisateur n'est valide donc la 
		 * méthode renvoie faux.
		 */
		return false;
	}
	
	
	/**
	 * Vérifie si un ordre donné est valide ou non.
	 * @param aVerifier L'ordre à vérifier.
	 * @return Vrai si l'ordre est dans la liste des ordres sinon faux.
	 * @see damedepique.general.Ordre
	 */
	public static boolean ordreEstValide(String aVerifier) {
		/*
		 * Vérifie si la référence de l'objet String passée en paramètre est 
		 * égale à null. Si l'objet n'est pas référencé alors la méthode 
		 * renvoie faux pour éviter une exception.
		 * 
		 * Si la longueur de la chaîne à vérifier n'est pas comprise entre 
		 * 1 et 5 alors la méthode renvoie faux et cela évite de rentrer dans 
		 * la boucle pour ne trouver aucune occurrence.
		 */
		if (Objects.isNull(aVerifier)
			|| 1 > aVerifier.length() || aVerifier.length() > 5) {
			
			return false;
		}
		
		/*
		 * Recherche d'une occurrence entre la valeur aVerifier passée en 
		 * paramètre et une valeur de la liste des ordres. Pour cette 
		 * recherche la casse est ignorée ce qui laisse de la liberté à 
		 * l'utilisateur lors de la saisie.
		 */
		for (Ordre ordre : Ordre.values()) {
			if (ordre.toString().equalsIgnoreCase(aVerifier)) {
				// A la première occurrence trouvée, la méthode renvoie vrai.
				return true;
			}
		}
		
		/*
		 * Si aucune référence n'a été trouvée dans la liste des ordres 
		 * alors l'ordre entré par l'utilisateur n'est valide donc la 
		 * méthode renvoie faux.
		 */
		return false;
	}
	
	
	/**
	 * Demande à un joueur d'entrer un symbole.
	 * @param message Le message à afficher pour demander de saisir un symbole.
	 * @return Le symbole valide d'une carte.
	 */
	public static Symbole saisirSymbole(String message) {
		String symbole;     // Symbole entré par le joueur.
		boolean correct;    // Indicateur de bonne saisie (symbole valide).
		
		/*
		 * Demande d'un symbole au joueur. Si celui-ci n'est pas valide alors 
		 * la saisie est recommencée.
		 */
		do {
			// Affichage d'un message pour demander d'entrer un symbole.
			System.out.print(message);
			symbole = sc.next() + sc.nextLine();
			correct = symboleEstValide(symbole);
			
			// Affichage d'un message d'erreur en cas de symbole invalide.
			if (!correct) {
				System.out.println("Le symbole que vous avez entré n'est pas "
						           + "valide.\nVous trouverez ci-dessous la "
						           + "liste des symboles possibles.\n" 
						           + Arrays.toString(Symbole.values()) + "\n");
			}
		} while (!correct);
		
		// Mise en forme du symbole entré par l'utilisateur.
		symbole = symbole.substring(0, 1).toUpperCase() 
				  + symbole.substring(1).toLowerCase();
		
		return Symbole.valueOf(symbole);
	}
	
	
	/**
	 * Demande à un joueur d'entrer un ordre.
	 * @param message Le message à afficher pour demander de saisir un ordre.
	 * @return L'ordre valide d'une carte.
	 */
	public static Ordre saisirOrdre(String message) {
		String ordre;       // Ordre entré par le joueur.
		boolean correct;    // Indicateur de bonne saisie (ordre valide).
		
		/*
		 * Demande d'un ordre au joueur. Si celui-ci n'est pas valide alors
		 * la saisie est recommencée.
		 */
		do {
			// Affichage d'un message pour demander d'entrer un ordre.
			System.out.print(message);
			ordre = sc.next() + sc.nextLine();
			correct = ordreEstValide(ordre);
			
			// Affichage d'un message d'erreur en cas d'ordre invalide.
			if (!correct) {
				System.out.println("L'ordre que vous avez entré n'est pas "
						           + "valide.\nVous trouverez ci-dessous la "
						           + "liste des ordres possibles.\n" 
						           + Arrays.toString(Ordre.values()) + "\n");
			}
		} while (!correct);
		
		// Mise en forme de l'ordre entré par l'utilisateur.
		ordre = ordre.substring(0, 1).toUpperCase() 
				+ ordre.substring(1).toLowerCase();
		
		return Ordre.valueOf(ordre);
	}
	
}
