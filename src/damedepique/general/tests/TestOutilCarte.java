/*
 * TestOutilCarte.java                                               24/05/2019
 * Projet de la dame de pique | IUT de Rodez | 2018 - 2019
 */

package damedepique.general.tests;

/**
 * <p>
 *   Cette classe contient les méthodes de test de la classe OutilCarte.
 * </p>
 * 
 * @author Julien B.
 * @author Loïc B.
 * @author Margaux B.
 * @author Justine R.
 * 
 * @version 1.0
 */
public class TestOutilCarte {

	/**
	 * Test de la méthode OutilCarte.rechercherCarte(Joueur[], Symbole, Valeur)
	 */
	public static void testRechercherCarte() {
		System.out.println("OutilCarte.rechercherCarte(Joueur[], Symbole, Valeur)\n"
                           + "-----------------------------------------------------");

		// TODO A compléter.

		OutilTest.continuer();
	}
	
	
	/**
	 * Test de la méthode OutilCarte.cartesPossibles(Joueur, boolean)
	 */
	public static void testCartesPossiblesDefausse() {
		System.out.println("OutilCarte.cartesPossibles(Joueur, boolean)\n"
                           + "-------------------------------------------");

		// TODO A compléter.

		OutilTest.continuer();
	}
	
	
	/**
	 * Test de la méthode OutilCarte.cartesPossibles(Joueur, Symbole, int)
	 */
	public static void testCartesPossiblesSymbole() {
		System.out.println("OutilCarte.cartesPossibles(Joueur, Symbole, int)\n"
                           + "------------------------------------------------");

		// TODO A compléter.

		OutilTest.continuer();
	}
	
	
	/**
	 * Test de la méthode OutilCarte.indiceDeuxTrefle(Joueur)
	 */
	public static void testIndiceDeuxTrefle() {
		System.out.println("OutilCarte.indiceDeuxTrefle(Joueur)\n"
                           + "-----------------------------------");

		// TODO A compléter.

		OutilTest.continuer();
	}
	
	
	/**
	 * Test de la méthode OutilCarte.trierMains(Joueur[])
	 */
	public static void testTrierMains() {
		System.out.println("OutilCarte.trierMains(Joueur[])\n"
                           + "-------------------------------");

		// TODO A compléter.

		OutilTest.continuer();
	}
	
	
	/**
	 * Lancement des méthodes de test de la classe OutilCarte.
	 * @param args Non utilisé.
	 */
	public static void main(String[] args) {
		System.out.println("----------------------------------------\n"
                           + "|     TEST DE LA CLASSE OUTILCARTE     |\n"
                           + "----------------------------------------\n");
		
		testRechercherCarte();
		// testCartesPossiblesDefausse();
		// testCartesPossiblesSymbole();
		// testIndiceDeuxTrefle();
		// testTrierMains();

	}

}
