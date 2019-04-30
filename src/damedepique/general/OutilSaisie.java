/*
 * OutilSaisie.java                                                  27/04/2019
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
		 * alors le symbole entré par l'utilisateur n'est pas valide donc la 
		 * méthode renvoie faux.
		 */
		return false;
	}
	
	
	/**
	 * Vérifie si une valeur donnée est valide ou non.
	 * @param aVerifier La valeur à vérifier.
	 * @return Vrai si la valeur est dans la liste des valeurs sinon faux.
	 * @see damedepique.general.Valeur
	 */
	public static boolean valeurEstValide(String aVerifier) {
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
		 * paramètre et une valeur de la liste des valeurs. Pour cette 
		 * recherche la casse est ignorée ce qui laisse de la liberté à 
		 * l'utilisateur lors de la saisie.
		 */
		for (Valeur valeur : Valeur.values()) {
			if (valeur.toString().equalsIgnoreCase(aVerifier)) {
				// A la première occurrence trouvée, la méthode renvoie vrai.
				return true;
			}
		}
		
		/*
		 * Si aucune référence n'a été trouvée dans la liste des valeurs 
		 * alors la valeur entrée par l'utilisateur n'est pas valide donc la 
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
		String symbole;     // Symbole entrée par le joueur.
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
	 * Demande à un joueur d'entrer une valeur.
	 * @param message Le message à afficher pour demander de saisir une valeur.
	 * @return La valeur valide d'une carte.
	 */
	public static Valeur saisirValeur(String message) {
		String valeur;      // Valeur entrée par le joueur.
		boolean correct;    // Indicateur de bonne saisie (valeur valide).
		
		/*
		 * Demande d'une valeur au joueur. Si celle-ci n'est pas valide alors
		 * la saisie est recommencée.
		 */
		do {
			// Affichage d'un message pour demander d'entrer une valeur.
			System.out.print(message);
			valeur = sc.next() + sc.nextLine();
			correct = valeurEstValide(valeur);
			
			// Affichage d'un message d'erreur en cas de valeur invalide.
			if (!correct) {
				System.out.println("La valeur que vous avez entrée n'est pas "
						           + "valide.\nVous trouverez ci-dessous la "
						           + "liste des valeurs possibles.\n" 
						           + Arrays.toString(Valeur.values()) + "\n");
			}
		} while (!correct);
		
		// Mise en forme de la valeur entrée par l'utilisateur.
		valeur = valeur.substring(0, 1).toUpperCase() 
				+ valeur.substring(1).toLowerCase();
		
		return Valeur.valueOf(valeur);
	}
	
}
