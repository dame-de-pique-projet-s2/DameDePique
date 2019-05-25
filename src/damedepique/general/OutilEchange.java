/*
 * OutilEchange.java                                                 24/05/2019
 * Projet de la dame de pique | IUT de Rodez | 2018 - 2019
 */

package damedepique.general;

import static damedepique.general.OutilAffichage.*;
import static damedepique.general.OutilCarte.*;

/**
 * <p>
 *   Cette classe contient des méthodes aidant l'échange des cartes entre les 
 *   joueurs de la partie lors du début des manche.
 * </p>
 * 
 * @author Julien B.
 * @author Loïc B.
 * @author Margaux B.
 * @author Justine R.
 * 
 * @version 1.0
 */
public class OutilEchange {

	/**
	 * Échange les cartes suivant le numéro de la manche courante.
	 * Le sens des échanges sont définis par rapport au numéro de la manche.
	 * @param joueurs Les joueurs de la partie.
	 * @param noManche Le numéro de la manche de la partie.
	 */
	public static void echangerCartes(Joueur[] joueurs, int noManche) {
		if (noManche % 4 == 0) {
			// Affichage d'un message montrant que l'échange commence.
			System.out.println(DEBUT_ECHANGE);
			
			// Échange des cartes vers le joueur positionné à gauche. 
			echangeGauche(joueurs);
			
			// Annonce que l'échange est terminé.
			finEchange(joueurs);
		} else if (noManche % 4 == 1) {
			// Affichage d'un message montrant que l'échange commence.
			System.out.println(DEBUT_ECHANGE);
			
			// Échange des cartes vers le joueur positionné à droite.
			echangeDroit(joueurs);
			
			// Annonce que l'échange est terminé.
			finEchange(joueurs);
		} else if (noManche % 4 == 2) {
			// Affichage d'un message montrant que l'échange commence.
			System.out.println(DEBUT_ECHANGE);
			
			// Échange des cartes vers le joueur positionné en face.
			echangeFace(joueurs);
			
			// Annonce que l'échange est terminé.
			finEchange(joueurs);
		} else {
			
			/* 
			 * Affichage d'un message signalant qu'il n'y a d'échange à ce 
			 * tour. Ce phénomène se produit tous les quatre tour.
			 */
			System.out.println(PAS_ECHANGE);
		}
	}
	
	
	/**
	 * Échange les trois cartes choisies par les joueurs entre eux.
	 * Dans cette méthode, l'échange se fait vers la gauche.
	 * @param joueurs Les joueurs de la partie.
	 */
	public static void echangeGauche(Joueur[] joueurs) {
		// Demande et stocke les cartes à échanger du premier joueur.
		Carte[] cartesJ0 = joueurs[0].choisirCartesAEchanger();
		
		// Demande et stocke les cartes à échanger du second joueur.
		Carte[] cartesJ1 = joueurs[1].choisirCartesAEchanger();
		
		// Demande et stocke les cartes à échanger du troisième joueur.
		Carte[] cartesJ2 = joueurs[2].choisirCartesAEchanger();

		// Demande et stocke les cartes à échanger du quatrième joueur.
		Carte[] cartesJ3 = joueurs[3].choisirCartesAEchanger();
		
		// Parcours des tableaux de cartes à échanger.
		for (int i = 0 ; i < cartesJ0.length ; i++) {
			// joueurs[0] donne les cartes au joueurs[1].
			joueurs[1].ajouterCarte(cartesJ0[i]);
			
			// joueurs[1] donne les cartes au joueurs[2].
			joueurs[2].ajouterCarte(cartesJ1[i]);
			
			// joueurs[2] donne les cartes au joueurs[3].
			joueurs[3].ajouterCarte(cartesJ2[i]);
			
			// joueurs[3] donne les cartes au joueurs[0].
			joueurs[0].ajouterCarte(cartesJ3[i]);
		}
		
		// Affiche un message pour voir qui échange les cartes à qui.
		afficherEchanges(joueurs, 0);
	}
	
	
	/**
	 * Échange les trois cartes choisies par les joueurs entre eux.
	 * Dans cette méthode, l'échange se fait vers la droite.
	 * @param joueurs Les joueurs de la partie.
	 */
	public static void echangeDroit(Joueur[] joueurs) {
		// Demande et stocke les cartes à échanger du premier joueur.
		Carte[] cartesJ0 = joueurs[0].choisirCartesAEchanger();
		
		// Demande et stocke les cartes à échanger du second joueur.
		Carte[] cartesJ1 = joueurs[1].choisirCartesAEchanger();
		
		// Demande et stocke les cartes à échanger du troisième joueur.
		Carte[] cartesJ2 = joueurs[2].choisirCartesAEchanger();
		
		// Demande et stocke les cartes à échanger du quatrième joueur.
		Carte[] cartesJ3 = joueurs[3].choisirCartesAEchanger();
		
		// Parcours des tableaux de cartes à échanger.
		for (int i = 0 ; i < cartesJ0.length ; i++) {
			// joueurs[0] donne les cartes au joueurs[3].
			joueurs[3].ajouterCarte(cartesJ0[i]);
			
			// joueurs[3] donne les cartes au joueurs[2].
			joueurs[2].ajouterCarte(cartesJ3[i]);
			
			// joueurs[2] donne les cartes au joueurs[1].
			joueurs[1].ajouterCarte(cartesJ2[i]);
			
			// joueurs[1] donne les cartes au joueurs[0].
			joueurs[0].ajouterCarte(cartesJ1[i]);
		}
		
		// Affiche un message pour voir qui échange les cartes à qui.
		afficherEchanges(joueurs, 1);
	}
	
	
	/**
	 * Échange les trois cartes choisies par les joueurs entre eux.
	 * Dans cette méthode, l'échange se fait en face.
	 * @param joueurs Les joueurs de la partie.
	 */
	public static void echangeFace(Joueur[] joueurs) {
		// Demande et stocke les cartes à échanger du premier joueur.
		Carte[] cartesJ0 = joueurs[0].choisirCartesAEchanger();
		
		// Demande et stocke les cartes à échanger du second joueur.
		Carte[] cartesJ1 = joueurs[1].choisirCartesAEchanger();
		
		// Demande et stocke les cartes à échanger du troisième joueur.
		Carte[] cartesJ2 = joueurs[2].choisirCartesAEchanger();
		
		// Demande et stocke les cartes à échanger du quatrième joueur.
		Carte[] cartesJ3 = joueurs[3].choisirCartesAEchanger();
		
		// Parcours des tableaux de cartes à échanger.
		for (int i = 0 ; i < cartesJ0.length ; i++) {
			// joueurs[0] donne les cartes au joueurs[2].
			joueurs[2].ajouterCarte(cartesJ0[i]);
			
			// joueurs[2] donne les cartes au joueurs[0].
			joueurs[0].ajouterCarte(cartesJ2[i]);
			
			// joueurs[3] donne les cartes au joueurs[1].
			joueurs[1].ajouterCarte(cartesJ3[i]);
			
			// joueurs[1] donne les cartes au joueurs[3].
			joueurs[3].ajouterCarte(cartesJ1[i]);
		}
		
		// Affiche un message pour voir qui échange les cartes à qui.
		afficherEchanges(joueurs, 2);
	}
	
	
	/**
	 * Annonce la fin d'un échange de cartes. Après cet échange, un algorithme 
	 * tri les cartes dans la main de tous les joueurs, puis montre les cartes 
	 * dans la main du joueur humain et affiche un message précisant que 
	 * l'échange est bel et bien fini.
	 * @param joueurs Les joueurs de la partie.
	 */
	public static void finEchange(Joueur[] joueurs) {
		// Tri la main du joueur après l'échange des cartes.
		trierMains(joueurs);
		 
		// Affichage des nouvelles cartes présentes dans la main.
		afficherCartes(joueurs[0].getMain(), 
					   "### Votre nouvelle main après l'échange : ");
		
		// Affichage d'un message signalant la fin de l'échange des cartes.
		System.out.println(FIN_ECHANGE);
	}
	
}
