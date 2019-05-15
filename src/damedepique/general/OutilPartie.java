/*
 * OutilPartie.java                                                  12/05/2019
 * Projet de la dame de pique | IUT de Rodez | 2018 - 2019
 */

package damedepique.general;

/**
 * <p>
 *   Cette classe contient des m�thodes utilitaires pour g�rer une partie de 
 *   dame de pique. Elle comporte des outils pour d�tecter la fin d'une partie 
 *   et la fin d'une manche, la v�rification de la cloche de bois.
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
				listeGagnant += "\n    > " + joueur.getPseudo() + " avec " 
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
		// Parcours les scores durant une manche des joueurs de la partie.
		for (int i = 0 ; i < joueurs.length ; i++) {
			
			/* 
			 * V�rifie si un joueur � effectu� un "grand chelem" ou a "d�m�nag� 
			 * � la cloche de bois", cela signifie qu'il a atteint le score 
			 * maximum qu'un joueur peut faire durant une manche, 26 points.
			 */
			if (joueurs[i].getPointsManche() == 26) {
				
				// A la premi�re occurrence, on renvoie l'indice du joueur.
				return i;
			}
		}
		
		/* 
		 * Si aucun joueur n'a r�ussi � faire un "grand chelem" alors l'indice 
		 * -1 (indice impossible) est renvoy�.
		 */
		return -1;
	}
	
	
	/**
	 * Ajoute les points aux scores totaux des joueurs de la partie.
	 * @param joueurs Les joueurs de la partie.
	 */
	public static void ajouterPointsTot(Joueur[] joueurs) {		
		/* 
		 * R�cup�re l'indice du joueur ayant effectu� un "grand chelem" 
		 * s'il existe (-1 si aucun joueur).
		 */
		int indiceCloche = clocheReussie(joueurs);
		
		// V�rifie si la cloche de bois a �t� r�ussie ou non.
		boolean clocheEchec = (indiceCloche == -1);
		
		// M�morise les points de la manche � ajouter aux points totaux.
		int pointsManche;
		
		// Parcours des joueurs de la partie sp�cifi�s en argument.
		for (int i = 0 ; i < joueurs.length ; i++) {
			
			// V�rifie si aucun joueur n'a effectu� un "grand chelem".
			if (clocheEchec) {
				// R�cup�re les points de la manche du joueur courant.
				pointsManche = joueurs[i].getPointsManche();
				
				// Ajoute les points de la manche aux points totaux.
				joueurs[i].ajouterPointsTot(pointsManche);
			
			// Si un joueur a effectu� un "grand chelem".
			} else {
				
				/*
				 * Si l'indice courant ne correspond pas � l'indice du joueur 
				 * ayant effectu� un "grand chelem", alors il re�oit  
				 * automatiquement 26 points. Au contraire si cette condition 
				 * est fausse alors le joueur ayant effectu� un "grand chelem" 
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
