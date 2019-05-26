/*
 * OutilStrategieIA.java                                             24/05/2019
 * Projet de la dame de pique | IUT de Rodez | 2018 - 2019
 */

package damedepique.ia;

import java.util.Comparator;

import damedepique.general.Carte;
import damedepique.general.Symbole;
import damedepique.general.Valeur;

/**
 * <p>
 *   Cette classe contient toutes les m�thodes concernant la strat�gie d'une 
 *   IA comme par exemple un tri des cartes dans un bon ordre pour que 
 *   l'IA puisse mieux jouer.
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
	
	
	/**
	 * R�cup�re les cartes valides (avec le m�me symbole demand�) dans 
	 * la m�moire de l'IA sp�cifi�e en param�tre.
	 * @param ia L'IA concern�e par la v�rification.
	 * @param symboleDemande Le symbole demand� au d�but d'un tour.
	 * @return Le nombre de suppressions effectu�es dans la m�moire.
	 */
	public static int recuperationCartesValides(IA ia, 
			                                    Symbole symboleDemande) {
		
		// Stocke la taille de la m�moire de l'IA sp�cifi�e.
		int tailleMemoire = ia.getMemoire().size();
		
		// Nombre de cartes supprim�es dans la m�moire de l'IA.
		int nbSupp = 0;
		
		// Parcours des cartes dans la m�moire de l'IA sp�cifi�e.
		for (int i = 0 ; i < tailleMemoire ; i++) {
			
			// V�rifie que la carte courante poss�de le symbole demand�.
			if (!ia.getMemoire().get(i - nbSupp).getSymbole()
					                            .equals(symboleDemande)) {
				
				/*
				 * Retire de la m�moire si la carte courante ne poss�de pas 
				 * le symbole demand� au d�but d'un tour.
				 * Attention, cette instruction modifie l'�tat de la m�moire.
				 */
				ia.getMemoire().remove(i - nbSupp);
				nbSupp++;    // Incr�mente le nombre de suppressions.
			}
		}
		
		/* 
		 * Ordonne les cartes de la m�moire dans un ordre strat�gique.
		 * Cet ordre a pour but de mettre les plus "grosses" cartes au d�but.
		 * Attention, cette instruction modifie l'�tat de la m�moire.
		 */
		ia.getMemoire().sort(ordreJeu);
		
		return nbSupp;    // Retourne le nombre de suppressions effectu�es.
	}
	
	
	/**
	 * V�rifie si une IA poss�de ou non un symbole sp�cifique.
	 * @param ia L'IA concern�e par la v�rification.
	 * @param symboleDemande Le symbole demand� au d�but d'un tour.
	 * @return Un bool�en �gal � vrai si l'IA mentionn�e poss�de au moins un 
	 *         carte poss�dant le symbole demand� sinon faux.
	 */
	public static boolean possedeSymboleDemande(IA ia, 
			                                    Symbole symboleDemande) {
		
		// Parcours des cartes dans la main de l'IA sp�cifi�e.
		for (Carte carte : ia.getMain()) {
			
			// V�rifie si la carte courante poss�de le symbole demand�.
			if (carte.getSymbole().equals(symboleDemande)) {
				
				// Retourne vrai � la premi�re occurrence trouv�e.
				return true;
			}
		}
		
		return false;    // Retourne faux si aucune occurrence n'a �t� trouv�e.
	}
	
}
