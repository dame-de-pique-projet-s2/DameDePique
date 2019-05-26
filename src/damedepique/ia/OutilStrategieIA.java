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
 *   Cette classe contient toutes les méthodes concernant la stratégie d'une 
 *   IA comme par exemple un tri des cartes dans un bon ordre pour que 
 *   l'IA puisse mieux jouer.
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
	
	
	/**
	 * Récupère les cartes valides (avec le même symbole demandé) dans 
	 * la mémoire de l'IA spécifiée en paramètre.
	 * @param ia L'IA concernée par la vérification.
	 * @param symboleDemande Le symbole demandé au début d'un tour.
	 * @return Le nombre de suppressions effectuées dans la mémoire.
	 */
	public static int recuperationCartesValides(IA ia, 
			                                    Symbole symboleDemande) {
		
		// Stocke la taille de la mémoire de l'IA spécifiée.
		int tailleMemoire = ia.getMemoire().size();
		
		// Nombre de cartes supprimées dans la mémoire de l'IA.
		int nbSupp = 0;
		
		// Parcours des cartes dans la mémoire de l'IA spécifiée.
		for (int i = 0 ; i < tailleMemoire ; i++) {
			
			// Vérifie que la carte courante possède le symbole demandé.
			if (!ia.getMemoire().get(i - nbSupp).getSymbole()
					                            .equals(symboleDemande)) {
				
				/*
				 * Retire de la mémoire si la carte courante ne possède pas 
				 * le symbole demandé au début d'un tour.
				 * Attention, cette instruction modifie l'état de la mémoire.
				 */
				ia.getMemoire().remove(i - nbSupp);
				nbSupp++;    // Incrémente le nombre de suppressions.
			}
		}
		
		/* 
		 * Ordonne les cartes de la mémoire dans un ordre stratégique.
		 * Cet ordre a pour but de mettre les plus "grosses" cartes au début.
		 * Attention, cette instruction modifie l'état de la mémoire.
		 */
		ia.getMemoire().sort(ordreJeu);
		
		return nbSupp;    // Retourne le nombre de suppressions effectuées.
	}
	
	
	/**
	 * Vérifie si une IA possède ou non un symbole spécifique.
	 * @param ia L'IA concernée par la vérification.
	 * @param symboleDemande Le symbole demandé au début d'un tour.
	 * @return Un booléen égal à vrai si l'IA mentionnée possède au moins un 
	 *         carte possédant le symbole demandé sinon faux.
	 */
	public static boolean possedeSymboleDemande(IA ia, 
			                                    Symbole symboleDemande) {
		
		// Parcours des cartes dans la main de l'IA spécifiée.
		for (Carte carte : ia.getMain()) {
			
			// Vérifie si la carte courante possède le symbole demandé.
			if (carte.getSymbole().equals(symboleDemande)) {
				
				// Retourne vrai à la première occurrence trouvée.
				return true;
			}
		}
		
		return false;    // Retourne faux si aucune occurrence n'a été trouvée.
	}
	
}
