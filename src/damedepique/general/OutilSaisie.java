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
 *   Cette classe contient des m�thodes outils pour effectuer des saisies.
 * </p>
 * <ul>
 *   <li>
 *     La m�thode symboleEstValide(String) v�rifie si un symbole appartient 
 *     ou non au tableau des valeurs possibles Carte.SYMBOLES.
 *   </li>
 *   <li>
 *     La m�thode ordreEstValide(String) v�rifie si un ordre appartient
 *     ou non au tableau des valeurs possibles Carte.ORDRES.
 *   </li>
 *   <li>
 *     La m�thode demandeSymbole(String) demande � un joueur de rentrer un 
 *     symbole. Si le symbole donn� par l'utilisateur n'est pas valide alors 
 *     la saisie est recommenc�e.
 *   </li>
 *   <li>
 *     La m�thode demandeOrdre(String) demande � un joueur de rentrer un ordre.
 *     Si l'ordre donn� par l'utilisateur n'est pas valide alors 
 *     la saisie est recommenc�e.
 *   </li>
 *   <li>
 *     La m�thode generationPseudo() permet de g�n�rer un indice de pseudo 
 *     al�atoire parmi une liste de pseudonymes pr�d�finis.
 *   </li>
 * </ul>
 * 
 * @author Julien B.
 * @version 1.0
 */
public class OutilSaisie {

	/** Analyseur lexical de l'entr�e standard texte. */
	private static final Scanner sc = new Scanner(System.in);
	
	/**
	 * V�rifie si un symbole donn� est valide ou non.
	 * @param aVerifier Le symbole � v�rifier.
	 * @return Vrai si le symbole est dans le tableau Carte.SYMBOLES 
	 *         sinon faux.
	 * @see damedepique.general.Carte
	 */
	public static boolean symboleEstValide(String aVerifier) {
		/*
		 * V�rifie si la r�f�rence de l'objet String pass�e en param�tre
		 * est �gale � null. Si l'objet n'est pas r�f�renc� alors la fonction
		 * renvoie faux pour �viter une exception.
		 * 
		 * Si la longueur de la cha�ne � v�rifier n'est pas comprise entre 
		 * 5 et 7 alors la fonction renvoie faux et cela �vite de rentrer 
		 * dans la boucle.
		 */
		if (Objects.isNull(aVerifier) 
			|| 5 > aVerifier.length() || aVerifier.length() > 7 ) {
			
			return false;
		}
		
		/*
		 * Recherche d'une occurence entre la valeur aVerifier et un �lement
		 * du tableau des symboles.
		 */
		for (String symbole : Carte.SYMBOLES) {
			if (aVerifier.equalsIgnoreCase(symbole)) {
				// A la premi�re occurence trouv�e, la fonction renvoie vrai.
				return true;
			}
		}
		
		/*
		 * Si aucune r�f�rence n'a �t� trouv�e dans le tableau des symboles
		 * alors la fonction renvoie faux.
		 */
		return false;
	}
	
	/**
	 * V�rifie si un ordre donn� est valide ou non.
	 * @param aVerifier L'ordre � v�rifier.
	 * @return Vrai si l'ordre est dans le tableau Carte.ORDRES sinon faux.
	 * @see damedepique.general.Carte
	 */
	public static boolean ordreEstValide(String aVerifier) {
		/*
		 * V�rifie si la r�f�rence de l'objet String pass�e en param�tre
		 * est �gale � null. Si l'objet n'est pas r�f�renc� alors la fonction
		 * renvoie faux pour �viter une exception.
		 * 
		 * Si la longueur de la cha�ne � v�rifier n'est pas comprise entre 
		 * 1 et 5 alors la fonction renvoie faux et cela �vite de rentrer 
		 * dans la boucle.
		 */
		if (Objects.isNull(aVerifier) 
			|| 1 > aVerifier.length() || aVerifier.length() > 5) {
			
			return false;
		}
		
		/*
		 * Recherche d'une occurence entre la valeur aVerifier et un �lement
		 * du tableau des ordres.
		 */
		for (String ordre : Carte.ORDRES) {
			if (aVerifier.equalsIgnoreCase(ordre)) {
				// A la premi�re occurence trouv�e, la fonction renvoie vrai.
				return true;
			}
		}
		
		/*
		 * Si aucune r�f�rence n'a �t� trouv�e dans le tableau des ordres
		 * alors la fonction renvoie faux.
		 */
		return false;
	}
	
	/**
	 * Demande au joueur d'entrer un symbole.
	 * @param message Le message � afficher pour demander 
	 *                au joueur de rentrer un symbole.
	 * @return Le symbole valide d'une carte.
	 */
	public static String demandeSymbole(String message) {
		String symbole;     // Symbole entr� par le joueur.
		boolean correct;    // Indicateur de bonne saisie (symbole valide).
		
		/* 
		 * Demande d'un symbole au joueur. Si celui-ci n'est pas valide 
		 * alors la saisie est recommenc�e. 
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
				System.out.println("\nLe symbole que vous avez entr� n'est "
			                       + "pas valide. \nSymboles possibles : "
						           + Arrays.toString(Carte.SYMBOLES) + "\n");
			}
		} while (!correct);
		
		return symbole;
	}
	
	/**
	 * Demande au joueur d'entrer un ordre.
	 * @param message Le message � afficher pour demander 
	 *                au joueur de rentrer un ordre.
	 * @return L'ordre valide d'une carte.
	 */
	public static String demandeOrdre(String message) {
		String ordre;       // Ordre entr� par le joueur.
		boolean correct;    // Indicateur de bonne saisie (ordre valide).
		
		/*
		 * Demande d'un ordre au joueur. Si celui-ci n'est pas valide
		 * alors la saisie est recommenc�e. 
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
				System.out.println("\nL'ordre que vous avez entr� n'est" 
			                       + "pas valide. \nOrdres possibles : " 
						           + Arrays.toString(Carte.ORDRES) + "\n");
			}
		} while (!correct);
		
		return ordre;
	}
	
	/**
	 * G�n�re un indice de pseudo al�atoire permis une liste pr��tablie.
	 * @return Un indice de pseudonyme g�n�r� al�atoirement.
	 * @see damedepique.general.Joueur
	 */
	public static int generationPseudo() {
		int indice;    // Indice du tableau g�n�r�e al�atoirement.
		
		// G�n�ration d'un indice al�atoire.
		indice = (int) Math.floor(Math.random() * Joueur.PSEUDOS.length);
		
		return indice;
	}
	
}
