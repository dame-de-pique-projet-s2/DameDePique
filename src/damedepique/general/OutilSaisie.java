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
 *   Cette classe contient des m�thodes outils pour effectuer des saisies.
 * </p>
 * 
 * @author Julien B.
 * @version 1.0
 */
public class OutilSaisie {

	/** Analyseur lexical de l'entr�e standard texte. */
	private static Scanner sc = new Scanner(System.in);
	
	
	/**
	 * V�rifie si un symbole donn� est valide ou non.
	 * @param aVerifier Le symbole � v�rifier.
	 * @return Vrai si le symbole est dans la liste des symboles sinon faux.
	 * @see damedepique.general.Symbole
	 */
	public static boolean symboleEstValide(String aVerifier) {
		/*
		 * V�rifie si la r�f�rence de l'objet String pass�e en param�tre est 
		 * �gale � null. Si l'objet n'est pas r�f�renc� alors la m�thode 
		 * renvoie faux pour �viter une exception.
		 * 
		 * Si la longueur de la cha�ne � v�rifier n'est pas comprise entre 
		 * 5 et 7 alors la m�thode renvoie faux et cela �vite de rentrer dans 
		 * la boucle pour ne trouver aucune occurrence.
		 */
		if (Objects.isNull(aVerifier) 
			|| 5 > aVerifier.length() || aVerifier.length() > 7) {
			
			return false;
		}
		
		/*
		 * Recherche d'une occurrence entre la valeur aVerifier pass�e en 
		 * param�tre et une valeur de la liste des symboles. Pour cette 
		 * recherche la casse est ignor�e ce qui laisse de la libert� � 
		 * l'utilisateur lors de la saisie.
		 */
		for (Symbole symbole : Symbole.values()) {
			if (symbole.toString().equalsIgnoreCase(aVerifier)) {
				// A la premi�re occurrence trouv�e, la m�thode renvoie vrai.
				return true;
			}
		}
		
		/*
		 * Si aucune r�f�rence n'a �t� trouv�e dans la liste des symboles 
		 * alors le symbole entr� par l'utilisateur n'est pas valide donc la 
		 * m�thode renvoie faux.
		 */
		return false;
	}
	
	
	/**
	 * V�rifie si une valeur donn�e est valide ou non.
	 * @param aVerifier La valeur � v�rifier.
	 * @return Vrai si la valeur est dans la liste des valeurs sinon faux.
	 * @see damedepique.general.Valeur
	 */
	public static boolean valeurEstValide(String aVerifier) {
		/*
		 * V�rifie si la r�f�rence de l'objet String pass�e en param�tre est 
		 * �gale � null. Si l'objet n'est pas r�f�renc� alors la m�thode 
		 * renvoie faux pour �viter une exception.
		 * 
		 * Si la longueur de la cha�ne � v�rifier n'est pas comprise entre 
		 * 1 et 5 alors la m�thode renvoie faux et cela �vite de rentrer dans 
		 * la boucle pour ne trouver aucune occurrence.
		 */
		if (Objects.isNull(aVerifier)
			|| 1 > aVerifier.length() || aVerifier.length() > 5) {
			
			return false;
		}
		
		/*
		 * Recherche d'une occurrence entre la valeur aVerifier pass�e en 
		 * param�tre et une valeur de la liste des valeurs. Pour cette 
		 * recherche la casse est ignor�e ce qui laisse de la libert� � 
		 * l'utilisateur lors de la saisie.
		 */
		for (Valeur valeur : Valeur.values()) {
			if (valeur.toString().equalsIgnoreCase(aVerifier)) {
				// A la premi�re occurrence trouv�e, la m�thode renvoie vrai.
				return true;
			}
		}
		
		/*
		 * Si aucune r�f�rence n'a �t� trouv�e dans la liste des valeurs 
		 * alors la valeur entr�e par l'utilisateur n'est pas valide donc la 
		 * m�thode renvoie faux.
		 */
		return false;
	}
	
	
	/**
	 * Demande � un joueur d'entrer un symbole.
	 * @param message Le message � afficher pour demander de saisir un symbole.
	 * @return Le symbole valide d'une carte.
	 */
	public static Symbole saisirSymbole(String message) {
		String symbole;     // Symbole entr�e par le joueur.
		boolean correct;    // Indicateur de bonne saisie (symbole valide).
		
		/*
		 * Demande d'un symbole au joueur. Si celui-ci n'est pas valide alors 
		 * la saisie est recommenc�e.
		 */
		do {
			// Affichage d'un message pour demander d'entrer un symbole.
			System.out.print(message);
			symbole = sc.next() + sc.nextLine();
			correct = symboleEstValide(symbole);
			
			// Affichage d'un message d'erreur en cas de symbole invalide.
			if (!correct) {
				System.out.println("Le symbole que vous avez entr� n'est pas "
						           + "valide.\nVous trouverez ci-dessous la "
						           + "liste des symboles possibles.\n" 
						           + Arrays.toString(Symbole.values()) + "\n");
			}
		} while (!correct);
		
		// Mise en forme du symbole entr� par l'utilisateur.
		symbole = symbole.substring(0, 1).toUpperCase() 
				  + symbole.substring(1).toLowerCase();
		
		return Symbole.valueOf(symbole);
	}
	
	
	/**
	 * Demande � un joueur d'entrer une valeur.
	 * @param message Le message � afficher pour demander de saisir une valeur.
	 * @return La valeur valide d'une carte.
	 */
	public static Valeur saisirValeur(String message) {
		String valeur;      // Valeur entr�e par le joueur.
		boolean correct;    // Indicateur de bonne saisie (valeur valide).
		
		/*
		 * Demande d'une valeur au joueur. Si celle-ci n'est pas valide alors
		 * la saisie est recommenc�e.
		 */
		do {
			// Affichage d'un message pour demander d'entrer une valeur.
			System.out.print(message);
			valeur = sc.next() + sc.nextLine();
			correct = valeurEstValide(valeur);
			
			// Affichage d'un message d'erreur en cas de valeur invalide.
			if (!correct) {
				System.out.println("La valeur que vous avez entr�e n'est pas "
						           + "valide.\nVous trouverez ci-dessous la "
						           + "liste des valeurs possibles.\n" 
						           + Arrays.toString(Valeur.values()) + "\n");
			}
		} while (!correct);
		
		// Mise en forme de la valeur entr�e par l'utilisateur.
		valeur = valeur.substring(0, 1).toUpperCase() 
				+ valeur.substring(1).toLowerCase();
		
		return Valeur.valueOf(valeur);
	}
	
}
