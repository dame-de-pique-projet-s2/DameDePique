/*
 * OutilPartie.java                                                  11/05/2019
 * Projet de la dame de pique | IUT de Rodez | 2018 - 2019
 */

package damedepique.general;

/**
 * <p>
 *   TODO Faire la description de cette classe.
 *   TODO Finir de commenter les m�thodes.
 * </p>
 * 
 * @author Julien B.
 * @author Lo�c B.
 * @author Margaux B.
 * @author Justine R.
 * 
 * @version 1.0
 */
public class OutilPartie {
	
	/**
	 * D�termine si une partie est finie ou non.
	 * @param joueurs Les joueurs de la partie.
	 * @return Vrai si la partie est finie (un joueur de la partie a d�pass� 
	 *         les 100 points) sinon faux.
	 */
	public static boolean finPartie(Joueur[] joueurs) {
		// Parcours des quatre joueurs de la partie.
		for (int i = 0 ; i < joueurs.length ; i++) {
			
			// V�rifie si un joueur a d�pass� 100 points ou non
			if (joueurs[i].getPointsTot() >= 100) {
				
				// Retourne vrai au premier joueur qui a d�pass� 100 points.
				return true;
			}
		}
		
		// Retourne faux si aucun joueur n'a d�pass� 100 points.
		return false;
	}
	
	
	/**
	 * D�termine si une manche est finie ou non.
	 * La v�rification n'est effectu�e que sur un seul joueur de la partie car 
	 * � chaque manche les joueurs ont toujours le m�me nombre de carte(s).
	 * @param joueur Un joueur de la partie.
	 * @return Vrai si la manche est finie (plus de cartes dans la main du 
	 *         joueur sp�cifi�) sinon faux.
	 */
	public static boolean finManche(Joueur joueur) {
		// V�rifie si la main du joueur est vide ou non.
		if (joueur.getMain().isEmpty()) {
			return true;    // Retourne vrai si la main du joueur est vide.
		}
		
		return false;    // Retourne faux si la main du joueur n'est pas vide.
	}
	
	
	/**
	 * Affiche le pseudonyme du joueur ou des joueurs gagnant(s) avec le nombre 
	 * de points associ�. Cette m�thode est � utiliser lorsqu'un joueur � 
	 * d�pass� la limite de points fix�e � 100 points.
	 * @param joueurs Les joueurs de la partie.
	 */
	public static void getGagnant(Joueur[] joueurs) {
		// Recherche du nombre de points minimum entre les quatre joueurs.
		int minPointsTot = joueurs[0].getPointsTot();
		for (int i = 1 ; i < joueurs.length ; i++) {
			
			/* 
			 * Si le nombre minimal de points est strictement sup�rieur au 
			 * nombre de points que le joueur courant poss�de alors la valeur 
			 * minimale est mise � jour.
			 */
			if (minPointsTot > joueurs[i].getPointsTot()) {
				
				// Mise � jour du nombre minimal de points.
				minPointsTot = joueurs[i].getPointsTot();
			}
		}
		
		String listeGagnant = "Le(s) gagnant(s) de cette partie : ";
		
		// Parcours de tous les joueurs de la partie.
		for (Joueur joueur : joueurs) {
			
			/* 
			 * V�rifie si le joueur courant poss�de le m�me nombre de points 
			 * que le nombre minimal. Si cette condition est v�rifi�e alors le 
			 * joueur est ajout� � la liste des gagnants.
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
	 * D�termine si un joueur � r�ussi � d�m�nager � la cloche de bois ou non.
	 * @param joueurs Les joueurs de la partie.
	 * @return Vrai si un joueur � r�ussi � accumuler 26 points durant une 
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
