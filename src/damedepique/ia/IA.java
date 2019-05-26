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
 *   peut effectuer en autonomie. Ces actions sont principalement basées sur 
 *   le jeu d'une carte en faisant le meilleur choix possible.
 * </p>
 * 
 * @author Julien B.
 * @author Loïc B.
 * @author Margaux B.
 * @author Justine R.
 * 
 * @version 1.0
 */
public class IA extends Joueur {

	/** Nombre de cartes qu'un plateau peut contenir au maximum. */
	private static final int NB_CARTES_PLATEAU = 4;
	
	
	/** Stocke les cartes jouées sur le plateau pendant un tour. */
	private ArrayList<Carte> memoire;
	
	
	/**
	 * Création d'une nouvelle IA avec les caractéristiques d'un joueur.
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
	 * Récupère la liste de cartes présente dans la mémoire de cette (this) IA.
	 * @return La liste de cartes en mémoire.
	 */
	public ArrayList<Carte> getMemoire() {
		return this.memoire;
	}
	
	
	/**
	 * Met à jour les cartes dans la mémoire de cette (this) IA.
	 * @param plateau Le plateau de la partie.
	 */
	public void setMemoire(Plateau plateau) {
		this.memoire.addAll(plateau.getCartes());
	}
	
	
	/**
	 * Vide la mémoire de cette (this) IA.
	 */
	public void viderMemoire() {
		this.memoire.clear();
	}
	
	
	/* * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * *
	 * * * * * * * * * * * * * * PARTIE ACTION * * * * * * * * * * * * * * *
	 * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * */
	
	/**
	 * Choisie et joue une carte sans restriction, il faut juste que la carte 
	 * sélectionnée soit dans la main de cette (this) IA. Cette méthode est 
	 * utilisée lors du choix des cartes à échanger.
	 */
	public Carte jouerCarte() {
		// Cartes jouables dans la main de l'IA.
		ArrayList<Carte> cartesJouables = this.getMain();
		
		/* 
		 * Tri les cartes jouables lors de l'échange dans le sens le plus 
		 * préférable pour le joueur afin d'avoir les "grosses" cartes au début 
		 * de cette liste de cartes, donc à échanger en priorité.
		 */
		cartesJouables.sort(ordreJeu);
		
		/*
		 * Vérifie si la première la carte des cartes jouables du joueur est un 
		 * trèfle. Si c'est le cas alors on saute d'un indice pour ne pas jouer 
		 * la plus grosse carte de trèfle et la garder pour jouer le premier 
		 * tour d'une manche. Lors d'un premier tour d'une manche on sait qu'on 
		 * ne peut quasiment jamais gagner des points (sauf exception).
		 */
		if (cartesJouables.get(0).getSymbole().equals(Symbole.Trefle)) {
			
			// On retourne la carte après l'occurrence de trèfle.
			return cartesJouables.get(1);
		}
		
		return cartesJouables.get(0);
	}
	
	
	/**
	 * Choisie et joue une carte en vérifiant qu'un coeur a été défaussé ou 
	 * non. Si un coeur n'a jamais été défaussé alors l'IA ne peut pas 
	 * commencer par une carte comportant du coeur. Cette méthode est utile 
	 * pour le joueur commençant un tour (excepté le premier).
	 */
	public Carte jouerCarte(boolean coeurDefausse) {
		// Cartes jouables dans la main de l'IA.
		ArrayList<Carte> cartesJouables = cartesPossibles(this, coeurDefausse);

		/* 
		 * Tri les cartes jouables dans un ordre décroissant pour les valeurs.
		 * Cela permet de retrouver les "petites" cartes à la fin de la liste 
		 * ce qui permet de jouer les plus "petites" cartes lorqu'on commence 
		 * un tour, pour avoir le moins de chance possible de le perdre.
		 */
		cartesJouables.sort(ordreJeu);
		
		/* 
		 * Lorsqu'un tour commence, alors l'IA joue la plus petite car possible 
		 * présente dans sa main pour voir une probabilité de gagner le tour 
		 * courant plus faible que si elle aurait joué une "grosse" carte.
		 */
		return cartesJouables.get(cartesJouables.size() - 1);
	}
	
	
	/**
	 * Choisie et joue une carte en vérifiant que le symbole joué corresponde 
	 * bien au symbole demandé au début du tour. Si cette méthode est appelée 
	 * au premier tour d'une manche alors toutes les cartes possédant du coeur 
	 * et la dame de pique ne sont pas jouables.
	 */
	public Carte jouerCarte(Symbole symboleDemande, int noTour) {
		// Cartes jouables dans la main de l'IA.
		ArrayList<Carte> cartesJouables = cartesPossibles(this, symboleDemande, 
				                                                noTour);
		
		cartesJouables.sort(ordreJeu);
		
		// Vérifie si le numéro du tour est égal à 0 (premier tour).
		if (noTour == 0) {
			
			/*
			 * Si c'est le premier tour alors on se débarrasse de la carte 
			 * la plus grande que l'on a avec le symbole demandé (plus grande 
			 * carte trèfle sauf en cas d'exception). Si on n'a pas de trèfle 
			 * dans les cartes jouables alors on défausse la plus grande carte 
			 * d'un autre symbole.
			 */
			return cartesJouables.get(0);
		}
		
		/*
		 * Récupération des cartes valides, c'est-à-dire des cartes possédant 
		 * le même symbole demandé car les coupes n'ont aucun impact direct 
		 * sur la détermination du perdant du tour. On récupère aussi le nombre 
		 * de suppressions effectuées pour savoir combien il y a de cartes 
		 * non valides dans la mémoire de cette (this) IA.
		 */
		int nbSupp = recuperationCartesValides(this, symboleDemande);
		
		// Récupération de la plus grosse carte jouable par cette (this) IA.
		Carte carteMaxJouable = cartesJouables.get(0);
		
		// Récupération de la plus petite carte jouable par cette (this) IA.
		Carte carteMinJouable = cartesJouables.get(cartesJouables.size() - 1);
		
		/* 
		 * Récupère la valeur maximale de la mémoire courante de cette (this) 
		 * IA pour pouvoir la comparer avec la valeur minimale des cartes 
		 * jouables de cette (this) IA.
		 */
		Valeur valeurMaxMemoire = getMemoire().get(0).getValeur();
		
		// Récupère la valeur minimale des cartes jouables par cette (this) IA.
		Valeur valeurMinJouable = carteMinJouable.getValeur();
		
		/*
		 * Vérifie que la carte la plus haute dans la mémoire de cette (this) 
		 * IA est strictement supérieure à la valeur minimale jouable par 
		 * cette (this) IA.
		 */
		if (valeurMaxMemoire.compareTo(valeurMinJouable) > 0) {
			
			/*
			 * Si cette (this) IA ne possède aucune cartes de même symbole que 
			 * celui demandé alors il peut jouer une "grosse" carte pour 
			 * pouvoir s'en débarrasser et ne pas l'avoir à jouer dans la 
			 * suite de la manche.
			 */
			if (!possedeSymboleDemande(this, symboleDemande)) {
				
				/*
				 * Retourne une "grosse" carte car cette (this) IA est assurée 
				 * de ne pas remporter le tour.
				 */
				return carteMaxJouable;
			}
			
			/*
			 * Au contraire, si cette (this) IA possède au moins une carte du 
			 * même symbole demandé alors elle joue sa plus petite carte de ses 
			 * cartes jouables et s'assure de ne pas perdre le tour.
			 */
			return carteMinJouable;
		
		/*
		 * Sinon la carte la plus haute dans la mémoire de cette (this) IA est 
		 * strictement inférieure à la valeur minimale jouable par l'IA.
		 */
		} else {
			
			/*
			 * Vérifie si cette (this) IA est la dernière à jouer durant un 
			 * tour (en regardant si il y a trois cartes sur le plateau). Si 
			 * c'est le cas alors elle joue sa plus "grosse" carte car elle ne 
			 * pourra pas gagner le tour quoi qu'il arrive puisque toutes ses 
			 * cartes jouables sont supérieures à la valeur maximale de la 
			 * mémoire. Elle se débarrasse donc d'une grosse carte en sachant 
			 * qu'elle a perdue le tour.
			 */
			if (getMemoire().size() + nbSupp == 3) {
				
				// Retourne la plus grosse carte jouable par cette (this) IA.
				return carteMaxJouable;
			}
			
			/*
			 * Si ce n'est pas le dernier joueur du tour et si la plus grosse 
			 * carte jouable a une valeur supérieure à celle maximale de la 
			 * mémoire alors elle joue sa plus petite carte en espérant que les 
			 * joueurs suivants vont jouer une valeur plus grande.
			 */
			return carteMinJouable;
		}
	}
	
	
	/**
	 * Joue la carte possédant le symbole trèfle et la valeur deux.
	 */
	public Carte jouerDeuxTrefle() {
		// Stockage de l'indice du deux de trèfle.
		int indiceDeuxTrefle = indiceDeuxTrefle(this);
		
		// Retourne la carte possédant le deux de trèfle.
		return this.getMain().get(indiceDeuxTrefle);
	}
	
	
	/**
     * Choisie trois cartes à échanger au début des manches (sauf exception).
     */
	public Carte[] choisirCartesAEchanger() {
		// Initialise un tableau de trois éléments de type Carte.
		Carte[] aEchanger = new Carte[3];

		// Choix de trois cartes à échanger.
		for (int i = 0 ; i < 3 ; i++) {
			// Choix d'une carte et la stocke dans la case courante.
			aEchanger[i] = this.jouerCarte();
			
			// Retire la carte sélectionnée de la main du joueur.
			this.retirerCarte(aEchanger[i]);
		}
		
		// Renvoie le tableau contenant les trois cartes à échanger.
		return aEchanger;
    }
	
}
