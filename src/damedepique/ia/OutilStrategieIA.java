/*
 * OutilStrategieIA.java                                             24/05/2019
 * Projet de la dame de pique | IUT de Rodez | 2018 - 2019
 */

package damedepique.ia;

import java.util.ArrayList;
import java.util.Comparator;

import damedepique.general.Carte;
import damedepique.general.Joueur;
import damedepique.general.Plateau;
import damedepique.general.Symbole;
import damedepique.general.Valeur;

/**
 * <p>
 *   TODO A faire.
 * </p>
 * 
 * @author Julien B.
 * @author Loïc B.
 * @author Margaux B.
 * @author Justine R.
 * 
 * @version 1.0
 */
public class OutilStrategieIA {

	public static void remplissageMemoiresGlobales(Joueur[] joueurs, Plateau plateau) {
		for (int i = 1 ; i < joueurs.length ; i++) {
			((IA) joueurs[i]).setMemoireGlobale(plateau);
		}
	}
	
	
	public static void remplissageMemoiresPlateau(Joueur[] joueurs, Plateau plateau) {
		for (int i = 1 ; i < joueurs.length ; i++) {
			((IA) joueurs[i]).setMemoirePlateau(plateau);
		}
	}
	
	/* * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * *
	 * * * * * * * * * * * * * * PARTIE ECHANGE* * * * * * * * * * * * * * *
	 * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * */
	
	// TODO Vérifie si une IA possède 5 ou plus cartes comportant un même symbole.
	// Si c'est vrai alors on vérifie que la première carte à échanger .get(0)
	// n'a pas un symbole identique à celui trouvé pour la longue (on récupère que la première longue)
	// Si le symbole identique alors on saute d'un indice et on prend la carte suivante
	// (avec vérification que le symbole ne soit pas le même).
	public static void recuperationPlateau(Plateau plateau) {
		plateau.getCartes();
	}
	
	
	/**
	 * Création d'un comparateur pour trier les cartes dans un ordre optimisé 
	 * pour l'échange des cartes. Ce tri est réalisé par rapport à la position 
	 * des symboles et des valeurs dans les énumérations Symbole et Valeur.
	 * @see damedepique.general.Symbole
	 * @see damedepique.general.Valeur
	 */
	public static Comparator<Carte> ordreJeu = new Comparator<>() {

		/**
		 * Compare les deux arguments pour les ordonner.
		 * @param carte1 La carte à comparer avec la seconde carte.
		 * @param carte2 La carte à comparer avec la première carte.
		 * @return Renvoie un entier négatif (-1) ou positif (1) si le premier 
		 *         argument est inférieur ou supérieur au second. 
		 *         L'entier renvoyé ne peut pas être nul (0) car toutes 
		 *         les cartes ont une référence unique dans un même paquet.
		 */
		public int compare(Carte carte1, Carte carte2) {
			
			// Récupère le symbole de la première carte passée en paramètre.
			Symbole carte1Symbole = carte1.getSymbole();
						
			// Récupère le symbole de la seconde carte passée en paramètre.
			Symbole carte2Symbole = carte2.getSymbole();
						
			// Récupère la valeur de la première carte passée en paramètre.
			Valeur carte1Valeur = carte1.getValeur();
						
			// Récupère la valeur de la seconde carte passée en paramètre.
			Valeur carte2Valeur = carte2.getValeur();
			
			/*
			 * Compare cet objet (carte1Symbole) avec l'objet spécifié pour la 
			 * commande (carte2Symbole). Retourne un entier négatif, nul ou 
			 * positif si cet objet est inférieur, égal ou supérieur à l'objet 
			 * spécifié. 
			 */
			int symboleDiff = carte1Symbole.compareTo(carte2Symbole);
			
			/*
			 * Compare cet objet (carte1Valeur) avec l'objet spécifié pour la 
			 * commande (carte2Valeur). Retourne un entier négatif, nul ou 
			 * positif si cet objet est inférieur, égal ou supérieur à l'objet 
			 * spécifié.
			 */
			int valeurDiff = carte1Valeur.compareTo(carte2Valeur);
			
			/*
			 * Si le résultat de la valeur trouvée (valeurDiff) est strictement 
			 * supérieur à 0 cela signifie que la valeur de la première carte 
			 * passée en argument est supérieure à celle de la seconde par 
			 * conséquent la valeur retournée est 1 (positive) pour que le 
			 * déplacement soit effectué.
			 * 
			 * Si le résultat de la valeur trouvée (valeurDiff) est strictement 
			 * égal à 0 et qu'en même temps le symbole trouvé (symboleDiff) est 
			 * strictement inférieur à 0 alors cela signifie que les cartes 
			 * passées en arguments sont de même valeur, on a donc 
			 * carte1Valeur.equals(carte2Valeur) mais le symbole de la première 
			 * carte est strictement supérieur à celui de la seconde par 
			 * conséquent la valeur retournée est 1 (positive) pour que le 
			 * déplacement soit effectué.
			 * 
			 * Si aucune condition n'est vérifiée alors la méthode de 
			 * comparaison retourne -1 (négatif) et cela signifie que les 
			 * cartes comparées sont déjà rangées dans l'ordre alors aucun 
			 * déplacement n'est à effectuer.
			 */
			return valeurDiff < 0 
				   || (valeurDiff == 0 && symboleDiff < 0) ? 1 : -1;
			
		}
		
	};
	
	
	/* * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * *
	 * * * * * * * * * * * * * * * PARTIE JEU* * * * * * * * * * * * * * * *
	 * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * */
	
	/**
	 * Méthode qui compte le nombre de cartes d'un symbole donné dans une liste 
	 * de cartes donnée.
	 * @param symboleDonne Le symbole dont on cherche des occurrences.
	 * @param aTester La liste de cartes dans laquelle on cherche les 
	 *                occurrences avec le symbole donné.
	 * @return Un entier correspondant au nombre de cartes du symbole donné 
	 *         comptabilisées dans la liste spécifiée.
	 */
	public static int cartesRestantes(Symbole symboleDonne, 
			                          ArrayList<Carte> aTester) {
		int nbCartes;
		
		nbCartes = 0;
		for (int i = 0 ; i < aTester.size() ; i++) {
			if (aTester.get(i).getSymbole().equals(symboleDonne)) {
				nbCartes++;
			}
		}
		
		return nbCartes;
	}
	
	
	/**
	 * Méthode qui vérifie qu'une IA possède ou non la totalité des cartes qui 
	 * n'ont pas encore été jouées dans un symbole donné. Renvoie vrai si l'IA 
	 * possède bien toutes les cartes restantes de ce symbole.
	 * @param ia L'IA qui est concernée par la vérification.
	 * @param symboleDonne Le symbole dont on cherche des occurrences.
	 * @return Un booléen égal à vrai si l'IA spécifiée possède toutes les 
	 *         cartes non jouées du symbole sinon faux.
	 */
	public static boolean dernieresCartes(IA ia, Symbole symboleDonne) {
		int cartesRestantes = cartesRestantes(symboleDonne, ia.getMemoireGlobale());
		int cartesRestantesMain = cartesRestantes(symboleDonne, ia.getMain());
		
		if (cartesRestantes + cartesRestantesMain == 13) {
			return true;
		}
		
		return false;
	}
	
}
