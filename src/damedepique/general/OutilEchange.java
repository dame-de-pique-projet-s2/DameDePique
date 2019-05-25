/*
 * OutilEchange.java                                                 24/05/2019
 * Projet de la dame de pique | IUT de Rodez | 2018 - 2019
 */

package damedepique.general;

import static damedepique.general.OutilAffichage.*;
import static damedepique.general.OutilCarte.*;

/**
 * <p>
 *   Cette classe contient des m�thodes aidant l'�change des cartes entre les 
 *   joueurs de la partie lors du d�but des manche.
 * </p>
 * 
 * @author Julien B.
 * @author Lo�c B.
 * @author Margaux B.
 * @author Justine R.
 * 
 * @version 1.0
 */
public class OutilEchange {

	/**
	 * �change les cartes suivant le num�ro de la manche courante.
	 * Le sens des �changes sont d�finis par rapport au num�ro de la manche.
	 * @param joueurs Les joueurs de la partie.
	 * @param noManche Le num�ro de la manche de la partie.
	 */
	public static void echangerCartes(Joueur[] joueurs, int noManche) {
		if (noManche % 4 == 0) {
			// Affichage d'un message montrant que l'�change commence.
			System.out.println(DEBUT_ECHANGE);
			
			// �change des cartes vers le joueur positionn� � gauche. 
			echangeGauche(joueurs);
			
			// Annonce que l'�change est termin�.
			finEchange(joueurs);
		} else if (noManche % 4 == 1) {
			// Affichage d'un message montrant que l'�change commence.
			System.out.println(DEBUT_ECHANGE);
			
			// �change des cartes vers le joueur positionn� � droite.
			echangeDroit(joueurs);
			
			// Annonce que l'�change est termin�.
			finEchange(joueurs);
		} else if (noManche % 4 == 2) {
			// Affichage d'un message montrant que l'�change commence.
			System.out.println(DEBUT_ECHANGE);
			
			// �change des cartes vers le joueur positionn� en face.
			echangeFace(joueurs);
			
			// Annonce que l'�change est termin�.
			finEchange(joueurs);
		} else {
			
			/* 
			 * Affichage d'un message signalant qu'il n'y a d'�change � ce 
			 * tour. Ce ph�nom�ne se produit tous les quatre tour.
			 */
			System.out.println(PAS_ECHANGE);
		}
	}
	
	
	/**
	 * �change les trois cartes choisies par les joueurs entre eux.
	 * Dans cette m�thode, l'�change se fait vers la gauche.
	 * @param joueurs Les joueurs de la partie.
	 */
	public static void echangeGauche(Joueur[] joueurs) {
		// Demande et stocke les cartes � �changer du premier joueur.
		Carte[] cartesJ0 = joueurs[0].choisirCartesAEchanger();
		
		// Demande et stocke les cartes � �changer du second joueur.
		Carte[] cartesJ1 = joueurs[1].choisirCartesAEchanger();
		
		// Demande et stocke les cartes � �changer du troisi�me joueur.
		Carte[] cartesJ2 = joueurs[2].choisirCartesAEchanger();

		// Demande et stocke les cartes � �changer du quatri�me joueur.
		Carte[] cartesJ3 = joueurs[3].choisirCartesAEchanger();
		
		// Parcours des tableaux de cartes � �changer.
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
		
		// Affiche un message pour voir qui �change les cartes � qui.
		afficherEchanges(joueurs, 0);
	}
	
	
	/**
	 * �change les trois cartes choisies par les joueurs entre eux.
	 * Dans cette m�thode, l'�change se fait vers la droite.
	 * @param joueurs Les joueurs de la partie.
	 */
	public static void echangeDroit(Joueur[] joueurs) {
		// Demande et stocke les cartes � �changer du premier joueur.
		Carte[] cartesJ0 = joueurs[0].choisirCartesAEchanger();
		
		// Demande et stocke les cartes � �changer du second joueur.
		Carte[] cartesJ1 = joueurs[1].choisirCartesAEchanger();
		
		// Demande et stocke les cartes � �changer du troisi�me joueur.
		Carte[] cartesJ2 = joueurs[2].choisirCartesAEchanger();
		
		// Demande et stocke les cartes � �changer du quatri�me joueur.
		Carte[] cartesJ3 = joueurs[3].choisirCartesAEchanger();
		
		// Parcours des tableaux de cartes � �changer.
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
		
		// Affiche un message pour voir qui �change les cartes � qui.
		afficherEchanges(joueurs, 1);
	}
	
	
	/**
	 * �change les trois cartes choisies par les joueurs entre eux.
	 * Dans cette m�thode, l'�change se fait en face.
	 * @param joueurs Les joueurs de la partie.
	 */
	public static void echangeFace(Joueur[] joueurs) {
		// Demande et stocke les cartes � �changer du premier joueur.
		Carte[] cartesJ0 = joueurs[0].choisirCartesAEchanger();
		
		// Demande et stocke les cartes � �changer du second joueur.
		Carte[] cartesJ1 = joueurs[1].choisirCartesAEchanger();
		
		// Demande et stocke les cartes � �changer du troisi�me joueur.
		Carte[] cartesJ2 = joueurs[2].choisirCartesAEchanger();
		
		// Demande et stocke les cartes � �changer du quatri�me joueur.
		Carte[] cartesJ3 = joueurs[3].choisirCartesAEchanger();
		
		// Parcours des tableaux de cartes � �changer.
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
		
		// Affiche un message pour voir qui �change les cartes � qui.
		afficherEchanges(joueurs, 2);
	}
	
	
	/**
	 * Annonce la fin d'un �change de cartes. Apr�s cet �change, un algorithme 
	 * tri les cartes dans la main de tous les joueurs, puis montre les cartes 
	 * dans la main du joueur humain et affiche un message pr�cisant que 
	 * l'�change est bel et bien fini.
	 * @param joueurs Les joueurs de la partie.
	 */
	public static void finEchange(Joueur[] joueurs) {
		// Tri la main du joueur apr�s l'�change des cartes.
		trierMains(joueurs);
		 
		// Affichage des nouvelles cartes pr�sentes dans la main.
		afficherCartes(joueurs[0].getMain(), 
					   "### Votre nouvelle main apr�s l'�change : ");
		
		// Affichage d'un message signalant la fin de l'�change des cartes.
		System.out.println(FIN_ECHANGE);
	}
	
}
