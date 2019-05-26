/*
 * IA.java                                                           13/05/2019
 * Projet de la dame de pique | IUT de Rodez | 2018 - 2019
 */

package damedepique.ia;

import static damedepique.general.OutilCarte.*;
import static damedepique.ia.OutilStrategieIA.*;

import damedepique.general.Carte;
import damedepique.general.Joueur;
import damedepique.general.Plateau;
import damedepique.general.Symbole;
import damedepique.general.Valeur;

import java.util.ArrayList;

/**
 * <p>
 *   Cette classe contient toutes les actions qu'une intelligence artificielle 
 *   peut effectuer en autonomie. Ces actions sont principalement bas�es sur 
 *   le jeu d'une carte en faisant le meilleur choix possible.
 * </p>
 * 
 * @author Julien B.
 * @author Lo�c B.
 * @author Margaux B.
 * @author Justine R.
 * 
 * @version 1.0
 */
public class IA extends Joueur {

	/** Nombre de cartes qu'un plateau peut contenir au maximum. */
	private static final int NB_CARTES_PLATEAU = 4;
	
	
	/** Stocke les cartes jou�es sur le plateau pendant un tour. */
	private ArrayList<Carte> memoire;
	
	
	/**
	 * Cr�ation d'une nouvelle IA avec les caract�ristiques d'un joueur.
	 * @param pseudo Le pseudo de cette (this) IA.
	 */
	public IA(String pseudo) {
		super(pseudo);
		this.memoire = new ArrayList<>(NB_CARTES_PLATEAU);
	}
	
	
	/* * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * *
	 * * * * * * * * * * * * * PARTIE MEMOIRE TOUR * * * * * * * * * * * * *
	 * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * */
	
	/**
	 * R�cup�re la liste de cartes pr�sente dans la m�moire de cette (this) IA.
	 * @return La liste de cartes en m�moire.
	 */
	public ArrayList<Carte> getMemoire() {
		return this.memoire;
	}
	
	
	/**
	 * Met � jour les cartes dans la m�moire de cette (this) IA.
	 * @param plateau Le plateau de la partie.
	 */
	public void setMemoire(Plateau plateau) {
		this.memoire.addAll(plateau.getCartes());
	}
	
	
	/**
	 * Vide la m�moire de cette (this) IA.
	 */
	public void viderMemoire() {
		this.memoire.clear();
	}
	
	
	/* * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * *
	 * * * * * * * * * * * * * * PARTIE ACTION * * * * * * * * * * * * * * *
	 * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * */
	
	/**
	 * Choisie et joue une carte sans restriction, il faut juste que la carte 
	 * s�lectionn�e soit dans la main de cette (this) IA. Cette m�thode est 
	 * utilis�e lors du choix des cartes � �changer.
	 */
	public Carte jouerCarte() {
		// Cartes jouables dans la main de l'IA.
		ArrayList<Carte> cartesJouables = this.getMain();
		
		/* 
		 * Tri les cartes jouables lors de l'�change dans le sens le plus 
		 * pr�f�rable pour le joueur afin d'avoir les "grosses" cartes au d�but 
		 * de cette liste de cartes, donc � �changer en priorit�.
		 */
		cartesJouables.sort(ordreJeu);
		
		/*
		 * V�rifie si la premi�re la carte des cartes jouables du joueur est un 
		 * tr�fle. Si c'est le cas alors on saute d'un indice pour ne pas jouer 
		 * la plus grosse carte de tr�fle et la garder pour jouer le premier 
		 * tour d'une manche. Lors d'un premier tour d'une manche on sait qu'on 
		 * ne peut quasiment jamais gagner des points (sauf exception).
		 */
		if (cartesJouables.get(0).getSymbole().equals(Symbole.Trefle)) {
			
			// On retourne la carte apr�s l'occurrence de tr�fle.
			return cartesJouables.get(1);
		}
		
		return cartesJouables.get(0);
	}
	
	
	/**
	 * Choisie et joue une carte en v�rifiant qu'un coeur a �t� d�fauss� ou 
	 * non. Si un coeur n'a jamais �t� d�fauss� alors l'IA ne peut pas 
	 * commencer par une carte comportant du coeur. Cette m�thode est utile 
	 * pour le joueur commen�ant un tour (except� le premier).
	 */
	public Carte jouerCarte(boolean coeurDefausse) {
		// Cartes jouables dans la main de l'IA.
		ArrayList<Carte> cartesJouables = cartesPossibles(this, coeurDefausse);

		/* 
		 * Tri les cartes jouables dans un ordre d�croissant pour les valeurs.
		 * Cela permet de retrouver les "petites" cartes � la fin de la liste 
		 * ce qui permet de jouer les plus "petites" cartes lorqu'on commence 
		 * un tour, pour avoir le moins de chance possible de le perdre.
		 */
		cartesJouables.sort(ordreJeu);
		
		/* 
		 * Lorsqu'un tour commence, alors l'IA joue la plus petite car possible 
		 * pr�sente dans sa main pour voir une probabilit� de gagner le tour 
		 * courant plus faible que si elle aurait jou� une "grosse" carte.
		 */
		return cartesJouables.get(cartesJouables.size() - 1);
	}
	
	
	/**
	 * Choisie et joue une carte en v�rifiant que le symbole jou� corresponde 
	 * bien au symbole demand� au d�but du tour. Si cette m�thode est appel�e 
	 * au premier tour d'une manche alors toutes les cartes poss�dant du coeur 
	 * et la dame de pique ne sont pas jouables.
	 */
	public Carte jouerCarte(Symbole symboleDemande, int noTour) {
		// Cartes jouables dans la main de l'IA.
		ArrayList<Carte> cartesJouables = cartesPossibles(this, symboleDemande, 
				                                                noTour);
		
		cartesJouables.sort(ordreJeu);
		
		// V�rifie si le num�ro du tour est �gal � 0 (premier tour).
		if (noTour == 0) {
			
			/*
			 * Si c'est le premier tour alors on se d�barrasse de la carte 
			 * la plus grande que l'on a avec le symbole demand� (plus grande 
			 * carte tr�fle sauf en cas d'exception). Si on n'a pas de tr�fle 
			 * dans les cartes jouables alors on d�fausse la plus grande carte 
			 * d'un autre symbole.
			 */
			return cartesJouables.get(0);
		}
		
		/*
		 * R�cup�ration des cartes valides, c'est-�-dire des cartes poss�dant 
		 * le m�me symbole demand� car les coupes n'ont aucun impact direct 
		 * sur la d�termination du perdant du tour. On r�cup�re aussi le nombre 
		 * de suppressions effectu�es pour savoir combien il y a de cartes 
		 * non valides dans la m�moire de cette (this) IA.
		 */
		int nbSupp = recuperationCartesValides(this, symboleDemande);
		
		// R�cup�ration de la plus grosse carte jouable par cette (this) IA.
		Carte carteMaxJouable = cartesJouables.get(0);
		
		// R�cup�ration de la plus petite carte jouable par cette (this) IA.
		Carte carteMinJouable = cartesJouables.get(cartesJouables.size() - 1);
		
		/* 
		 * R�cup�re la valeur maximale de la m�moire courante de cette (this) 
		 * IA pour pouvoir la comparer avec la valeur minimale des cartes 
		 * jouables de cette (this) IA.
		 */
		Valeur valeurMaxMemoire = getMemoire().get(0).getValeur();
		
		// R�cup�re la valeur minimale des cartes jouables par cette (this) IA.
		Valeur valeurMinJouable = carteMinJouable.getValeur();
		
		/*
		 * V�rifie que la carte la plus haute dans la m�moire de cette (this) 
		 * IA est strictement sup�rieure � la valeur minimale jouable par 
		 * cette (this) IA.
		 */
		if (valeurMaxMemoire.compareTo(valeurMinJouable) > 0) {
			
			/*
			 * Si cette (this) IA ne poss�de aucune cartes de m�me symbole que 
			 * celui demand� alors il peut jouer une "grosse" carte pour 
			 * pouvoir s'en d�barrasser et ne pas l'avoir � jouer dans la 
			 * suite de la manche.
			 */
			if (!possedeSymboleDemande(this, symboleDemande)) {
				
				/*
				 * Retourne une "grosse" carte car cette (this) IA est assur�e 
				 * de ne pas remporter le tour.
				 */
				return carteMaxJouable;
			}
			
			/*
			 * Au contraire, si cette (this) IA poss�de au moins une carte du 
			 * m�me symbole demand� alors elle joue sa plus petite carte de ses 
			 * cartes jouables et s'assure de ne pas perdre le tour.
			 */
			return carteMinJouable;
		
		/*
		 * Sinon la carte la plus haute dans la m�moire de cette (this) IA est 
		 * strictement inf�rieure � la valeur minimale jouable par l'IA.
		 */
		} else {
			
			/*
			 * V�rifie si cette (this) IA est la derni�re � jouer durant un 
			 * tour (en regardant si il y a trois cartes sur le plateau). Si 
			 * c'est le cas alors elle joue sa plus "grosse" carte car elle ne 
			 * pourra pas gagner le tour quoi qu'il arrive puisque toutes ses 
			 * cartes jouables sont sup�rieures � la valeur maximale de la 
			 * m�moire. Elle se d�barrasse donc d'une grosse carte en sachant 
			 * qu'elle a perdue le tour.
			 */
			if (getMemoire().size() + nbSupp == 3) {
				
				// Retourne la plus grosse carte jouable par cette (this) IA.
				return carteMaxJouable;
			}
			
			/*
			 * Si ce n'est pas le dernier joueur du tour et si la plus grosse 
			 * carte jouable a une valeur sup�rieure � celle maximale de la 
			 * m�moire alors elle joue sa plus petite carte en esp�rant que les 
			 * joueurs suivants vont jouer une valeur plus grande.
			 */
			return carteMinJouable;
		}
	}
	
	
	/**
	 * Joue la carte poss�dant le symbole tr�fle et la valeur deux.
	 */
	public Carte jouerDeuxTrefle() {
		// Stockage de l'indice du deux de tr�fle.
		int indiceDeuxTrefle = indiceDeuxTrefle(this);
		
		// Retourne la carte poss�dant le deux de tr�fle.
		return this.getMain().get(indiceDeuxTrefle);
	}
	
	
	/**
     * Choisie trois cartes � �changer au d�but des manches (sauf exception).
     */
	public Carte[] choisirCartesAEchanger() {
		// Initialise un tableau de trois �l�ments de type Carte.
		Carte[] aEchanger = new Carte[3];

		// Choix de trois cartes � �changer.
		for (int i = 0 ; i < 3 ; i++) {
			// Choix d'une carte et la stocke dans la case courante.
			aEchanger[i] = this.jouerCarte();
			
			// Retire la carte s�lectionn�e de la main du joueur.
			this.retirerCarte(aEchanger[i]);
		}
		
		// Renvoie le tableau contenant les trois cartes � �changer.
		return aEchanger;
    }
	
}
