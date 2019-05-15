/*
 * OutilPartie.java                                                  12/05/2019
 * Projet de la dame de pique | IUT de Rodez | 2018 - 2019
 */

package damedepique.general;

/**
 * <p>
 *   Cette classe contient des méthodes utilitaires pour gérer une partie de 
 *   dame de pique. Elle comporte des outils pour détecter la fin d'une partie 
 *   et la fin d'une manche, la vérification de la cloche de bois.
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
				listeGagnant += "\n    > " + joueur.getPseudo() + " avec " 
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
		// Parcours les scores durant une manche des joueurs de la partie.
		for (int i = 0 ; i < joueurs.length ; i++) {
			
			/* 
			 * Vérifie si un joueur à effectué un "grand chelem" ou a "déménagé 
			 * à la cloche de bois", cela signifie qu'il a atteint le score 
			 * maximum qu'un joueur peut faire durant une manche, 26 points.
			 */
			if (joueurs[i].getPointsManche() == 26) {
				
				// A la première occurrence, on renvoie l'indice du joueur.
				return i;
			}
		}
		
		/* 
		 * Si aucun joueur n'a réussi à faire un "grand chelem" alors l'indice 
		 * -1 (indice impossible) est renvoyé.
		 */
		return -1;
	}
	
	
	/**
	 * Ajoute les points aux scores totaux des joueurs de la partie.
	 * @param joueurs Les joueurs de la partie.
	 */
	public static void ajouterPointsTot(Joueur[] joueurs) {		
		/* 
		 * Récupère l'indice du joueur ayant effectué un "grand chelem" 
		 * s'il existe (-1 si aucun joueur).
		 */
		int indiceCloche = clocheReussie(joueurs);
		
		// Vérifie si la cloche de bois a été réussie ou non.
		boolean clocheEchec = (indiceCloche == -1);
		
		// Mémorise les points de la manche à ajouter aux points totaux.
		int pointsManche;
		
		// Parcours des joueurs de la partie spécifiés en argument.
		for (int i = 0 ; i < joueurs.length ; i++) {
			
			// Vérifie si aucun joueur n'a effectué un "grand chelem".
			if (clocheEchec) {
				// Récupère les points de la manche du joueur courant.
				pointsManche = joueurs[i].getPointsManche();
				
				// Ajoute les points de la manche aux points totaux.
				joueurs[i].ajouterPointsTot(pointsManche);
			
			// Si un joueur a effectué un "grand chelem".
			} else {
				
				/*
				 * Si l'indice courant ne correspond pas à l'indice du joueur 
				 * ayant effectué un "grand chelem", alors il reçoit  
				 * automatiquement 26 points. Au contraire si cette condition 
				 * est fausse alors le joueur ayant effectué un "grand chelem" 
				 * ne se voit attribuer aucun point.
				 */
				if (indiceCloche != i) {
					joueurs[i].ajouterPointsTot(26);
				} else {
					joueurs[indiceCloche].ajouterPointsTot(0);
				}
			}
			
			// Vide le compteur de points pour la manche du joueur courant.
			joueurs[i].viderPointsManche();
		}
	}
	
}
