/*
 * OutilPartie.java                                                  11/05/2019
 * Projet de la dame de pique | IUT de Rodez | 2018 - 2019
 */

package damedepique.general;

/**
 * <p>
 *   TODO Faire la description de cette classe.
 *   TODO Finir de commenter les méthodes.
 * </p>
 * 
 * @author Julien B.
 * @author Loïc B.
 * @author Margaux B.
 * @author Justine R.
 * 
 * @version 1.0
 */
public class OutilPartie {
	
	/**
	 * Détermine si une partie est finie ou non.
	 * @param joueurs Les joueurs de la partie.
	 * @return Vrai si la partie est finie (un joueur de la partie a dépassé 
	 *         les 100 points) sinon faux.
	 */
	public static boolean finPartie(Joueur[] joueurs) {
		// Parcours des quatre joueurs de la partie.
		for (int i = 0 ; i < joueurs.length ; i++) {
			
			// Vérifie si un joueur a dépassé 100 points ou non
			if (joueurs[i].getPointsTot() >= 100) {
				
				// Retourne vrai au premier joueur qui a dépassé 100 points.
				return true;
			}
		}
		
		// Retourne faux si aucun joueur n'a dépassé 100 points.
		return false;
	}
	
	
	/**
	 * Détermine si une manche est finie ou non.
	 * La vérification n'est effectuée que sur un seul joueur de la partie car 
	 * à chaque manche les joueurs ont toujours le même nombre de carte(s).
	 * @param joueur Un joueur de la partie.
	 * @return Vrai si la manche est finie (plus de cartes dans la main du 
	 *         joueur spécifié) sinon faux.
	 */
	public static boolean finManche(Joueur joueur) {
		// Vérifie si la main du joueur est vide ou non.
		if (joueur.getMain().isEmpty()) {
			return true;    // Retourne vrai si la main du joueur est vide.
		}
		
		return false;    // Retourne faux si la main du joueur n'est pas vide.
	}
	
	
	/**
	 * Affiche le pseudonyme du joueur ou des joueurs gagnant(s) avec le nombre 
	 * de points associé. Cette méthode est à utiliser lorsqu'un joueur à 
	 * dépassé la limite de points fixée à 100 points.
	 * @param joueurs Les joueurs de la partie.
	 */
	public static void getGagnant(Joueur[] joueurs) {
		// Recherche du nombre de points minimum entre les quatre joueurs.
		int minPointsTot = joueurs[0].getPointsTot();
		for (int i = 1 ; i < joueurs.length ; i++) {
			
			/* 
			 * Si le nombre minimal de points est strictement supérieur au 
			 * nombre de points que le joueur courant possède alors la valeur 
			 * minimale est mise à jour.
			 */
			if (minPointsTot > joueurs[i].getPointsTot()) {
				
				// Mise à jour du nombre minimal de points.
				minPointsTot = joueurs[i].getPointsTot();
			}
		}
		
		String listeGagnant = "Le(s) gagnant(s) de cette partie : ";
		
		// Parcours de tous les joueurs de la partie.
		for (Joueur joueur : joueurs) {
			
			/* 
			 * Vérifie si le joueur courant possède le même nombre de points 
			 * que le nombre minimal. Si cette condition est vérifiée alors le 
			 * joueur est ajouté à la liste des gagnants.
			 */
			if (joueur.getPointsTot() == minPointsTot) {
				listeGagnant += "\n    => " + joueur.getPseudo() + " avec " 
			                                + joueur.getPointsTot() 
			                                + " point(s)";
			}
		}
		
		// Affichage du gagnant ou de la liste des gagnants.
		System.out.println(listeGagnant);
	}
	
	
	/**
	 * Détermine si un joueur à réussi à déménager à la cloche de bois ou non.
	 * @param joueurs Les joueurs de la partie.
	 * @return Vrai si un joueur à réussi à accumuler 26 points durant une 
	 *         seule manche sinon faux.
	 */
	public static int clocheReussie(Joueur[] joueurs) {
		for (int i = 0 ; i < joueurs.length ; i++) {
			if (joueurs[i].getPointsManche() == 26) {
				return i;
			}
		}
		
		return -1;
	}
	
	
	/**
	 * 
	 * @param joueurs
	 */
	public static void ajouterPointsTot(Joueur[] joueurs) {		
		int cloche = clocheReussie(joueurs);
		
		if (cloche != -1) {
			for (int i = 0 ; i < joueurs.length ; i++) {
				if (cloche == i) {
					joueurs[cloche].viderPointsManche();
				} else {
					joueurs[i].setPointsManche(26);
				}
			}
		}
		
		for (int j = 0 ; j < joueurs.length ; j++) {
			int pointsManche = joueurs[j].getPointsManche();
			joueurs[j].ajouterPointsTot(pointsManche);
			joueurs[j].viderPointsManche();
		}
	}
	
}
