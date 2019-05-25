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
 * @author Lo�c B.
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
	
	// TODO V�rifie si une IA poss�de 5 ou plus cartes comportant un m�me symbole.
	// Si c'est vrai alors on v�rifie que la premi�re carte � �changer .get(0)
	// n'a pas un symbole identique � celui trouv� pour la longue (on r�cup�re que la premi�re longue)
	// Si le symbole identique alors on saute d'un indice et on prend la carte suivante
	// (avec v�rification que le symbole ne soit pas le m�me).
	public static void recuperationPlateau(Plateau plateau) {
		plateau.getCartes();
	}
	
	
	/**
	 * Cr�ation d'un comparateur pour trier les cartes dans un ordre optimis� 
	 * pour l'�change des cartes. Ce tri est r�alis� par rapport � la position 
	 * des symboles et des valeurs dans les �num�rations Symbole et Valeur.
	 * @see damedepique.general.Symbole
	 * @see damedepique.general.Valeur
	 */
	public static Comparator<Carte> ordreJeu = new Comparator<>() {

		/**
		 * Compare les deux arguments pour les ordonner.
		 * @param carte1 La carte � comparer avec la seconde carte.
		 * @param carte2 La carte � comparer avec la premi�re carte.
		 * @return Renvoie un entier n�gatif (-1) ou positif (1) si le premier 
		 *         argument est inf�rieur ou sup�rieur au second. 
		 *         L'entier renvoy� ne peut pas �tre nul (0) car toutes 
		 *         les cartes ont une r�f�rence unique dans un m�me paquet.
		 */
		public int compare(Carte carte1, Carte carte2) {
			
			// R�cup�re le symbole de la premi�re carte pass�e en param�tre.
			Symbole carte1Symbole = carte1.getSymbole();
						
			// R�cup�re le symbole de la seconde carte pass�e en param�tre.
			Symbole carte2Symbole = carte2.getSymbole();
						
			// R�cup�re la valeur de la premi�re carte pass�e en param�tre.
			Valeur carte1Valeur = carte1.getValeur();
						
			// R�cup�re la valeur de la seconde carte pass�e en param�tre.
			Valeur carte2Valeur = carte2.getValeur();
			
			/*
			 * Compare cet objet (carte1Symbole) avec l'objet sp�cifi� pour la 
			 * commande (carte2Symbole). Retourne un entier n�gatif, nul ou 
			 * positif si cet objet est inf�rieur, �gal ou sup�rieur � l'objet 
			 * sp�cifi�. 
			 */
			int symboleDiff = carte1Symbole.compareTo(carte2Symbole);
			
			/*
			 * Compare cet objet (carte1Valeur) avec l'objet sp�cifi� pour la 
			 * commande (carte2Valeur). Retourne un entier n�gatif, nul ou 
			 * positif si cet objet est inf�rieur, �gal ou sup�rieur � l'objet 
			 * sp�cifi�.
			 */
			int valeurDiff = carte1Valeur.compareTo(carte2Valeur);
			
			/*
			 * Si le r�sultat de la valeur trouv�e (valeurDiff) est strictement 
			 * sup�rieur � 0 cela signifie que la valeur de la premi�re carte 
			 * pass�e en argument est sup�rieure � celle de la seconde par 
			 * cons�quent la valeur retourn�e est 1 (positive) pour que le 
			 * d�placement soit effectu�.
			 * 
			 * Si le r�sultat de la valeur trouv�e (valeurDiff) est strictement 
			 * �gal � 0 et qu'en m�me temps le symbole trouv� (symboleDiff) est 
			 * strictement inf�rieur � 0 alors cela signifie que les cartes 
			 * pass�es en arguments sont de m�me valeur, on a donc 
			 * carte1Valeur.equals(carte2Valeur) mais le symbole de la premi�re 
			 * carte est strictement sup�rieur � celui de la seconde par 
			 * cons�quent la valeur retourn�e est 1 (positive) pour que le 
			 * d�placement soit effectu�.
			 * 
			 * Si aucune condition n'est v�rifi�e alors la m�thode de 
			 * comparaison retourne -1 (n�gatif) et cela signifie que les 
			 * cartes compar�es sont d�j� rang�es dans l'ordre alors aucun 
			 * d�placement n'est � effectuer.
			 */
			return valeurDiff < 0 
				   || (valeurDiff == 0 && symboleDiff < 0) ? 1 : -1;
			
		}
		
	};
	
	
	/* * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * *
	 * * * * * * * * * * * * * * * PARTIE JEU* * * * * * * * * * * * * * * *
	 * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * */
	
	/**
	 * M�thode qui compte le nombre de cartes d'un symbole donn� dans une liste 
	 * de cartes donn�e.
	 * @param symboleDonne Le symbole dont on cherche des occurrences.
	 * @param aTester La liste de cartes dans laquelle on cherche les 
	 *                occurrences avec le symbole donn�.
	 * @return Un entier correspondant au nombre de cartes du symbole donn� 
	 *         comptabilis�es dans la liste sp�cifi�e.
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
	 * M�thode qui v�rifie qu'une IA poss�de ou non la totalit� des cartes qui 
	 * n'ont pas encore �t� jou�es dans un symbole donn�. Renvoie vrai si l'IA 
	 * poss�de bien toutes les cartes restantes de ce symbole.
	 * @param ia L'IA qui est concern�e par la v�rification.
	 * @param symboleDonne Le symbole dont on cherche des occurrences.
	 * @return Un bool�en �gal � vrai si l'IA sp�cifi�e poss�de toutes les 
	 *         cartes non jou�es du symbole sinon faux.
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
