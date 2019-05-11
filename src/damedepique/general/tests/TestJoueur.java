/*
 * TestJoueur.java                                                   25/04/2019
 * Projet de la dame de pique | IUT de Rodez | 2018 - 2019
 */

package damedepique.general.tests;

import damedepique.general.Joueur;
import damedepique.general.Paquet;
import damedepique.general.Pseudo;
import damedepique.ia.IA;

/**
 * <p>
 *   Cette classe contient toutes les m�thodes de test de la classe Joueur.
 * </p>
 *   
 * @author Lo�c B. | Julien B. | Margaux B. | Justine R.
 * @version 1.0
 */
public class TestJoueur {

	/**
	 * Test de la m�thode Joueur.affectationPseudo()
	 */
	public static void testAffectationPseudo() {
		System.out.println("Joueur.affectationPseudo()\n"
                           + "--------------------------");
		
		// Stocke le nombre d'apparitions trouv�es par pseudonymes.
		int[] compteur = new int[Pseudo.values().length];
		
		/*
		 * Instantiation et initialisation de 100 joueurs pour prouver que le 
		 * g�n�rateur de pseudonymes propose des r�sultats �quiprobables.
		 */
		Joueur[] joueurs = new Joueur[100];
		for (int i = 0 ; i < joueurs.length ; i++) {
			joueurs[i] = new IA();
			
			switch (joueurs[i].getPseudo()) {
			case Aurore:
				compteur[0]++;
				break;
			case Brigitte:
				compteur[1]++;
				break;
			case Camille:
				compteur[2]++;
				break;
			case Emilie:
				compteur[3]++;
				break;
			case Georges:
				compteur[4]++;
				break;
			case Jacques:
				compteur[5]++;
				break;
			case Jade:
				compteur[6]++;
				break;
			case Paul:
				compteur[7]++;
				break;
			case Pierre:
				compteur[8]++;
				break;
			case Thomas:
				compteur[9]++;
				break;
			}
		}
		
		/*
		 * Affichage des r�sultats trouv�s. Chaque pseudonyme pr�d�finis est 
		 * associ� � un pourcentage d'apparition. Ce pourcentage tourne autour 
		 * de 10% (nombre de pseudonymes / nombre de joueurs).
		 */
		for (int j = 0 ; j < compteur.length ; j++) {
			System.out.println(Pseudo.values()[j] + " = " + compteur[j] + "%");
		}
		
		OutilTest.continuer();
	}
	
	
	/**
	 * Test de la m�thode Joueur.trierMain()
	 */
	public static void testTrierMain() {
		System.out.println("Joueur.trierMain()\n"
                           + "------------------");
		
		// Instantiation d'un nouveau paquet de cartes.
		Paquet paquet = new Paquet();
				
		// Instantiation et initialisation de quatre joueurs.
		Joueur[] joueurs = new Joueur[4];
		for (int i = 0 ; i < joueurs.length ; i++) {
		    joueurs[i] = new IA();
		}
				
		// Cr�ation du nouveau paquet de cartes.
		paquet.creer();
				
		// M�lange du paquet pr�c�demment cr�e. 
		paquet.melanger();
				
		// Distribution du paquet de cartes entre les quatre joueurs.
		paquet.distribuer(joueurs);
			
		System.out.println(joueurs[0]);
		
		joueurs[0].trierMain();
		
		System.out.println("\n" + joueurs[0]);
				
		OutilTest.continuer();
	}
	
	
	/**
	 * Lancement des m�thodes de test de la classe Joueur.
	 * @param args Non utilis�.
	 */
	public static void main(String[] args) {
		System.out.println("------------------------------------\n"
                           + "|     TEST DE LA CLASSE JOUEUR     |\n"
                           + "------------------------------------\n");
		
		// testAffectationPseudo();
		// testTrierMain();

	}
	
}
