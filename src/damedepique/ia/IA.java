/*
 * IA.java                                                           13/05/2019
 * Projet de la dame de pique | IUT de Rodez | 2018 - 2019
 */

package damedepique.ia;

import static damedepique.general.OutilCarte.*;

import damedepique.general.Carte;
import damedepique.general.Joueur;
import damedepique.general.Plateau;
import damedepique.general.Symbole;

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

	/** Nombre de cartes qu'un paquet traditionnel contient. */
	private static final int NB_CARTES_PAQUET = 52;
	
	
	/** Nombre de cartes qu'un plateau peut contenir au maximum. */
	private static final int NB_CARTES_PLATEAU = 4;
	
	
	/** Stocke les cartes jouées pendant les tours d'une manche. */
	private ArrayList<Carte> memoireGlobale;
	
	
	/** Stocke les cartes jouées sur le plateau pendant un tour. */
	private ArrayList<Carte> memoirePlateau;
	
	
	/**
	 * Création d'une nouvelle IA avec les caractéristiques d'un joueur.
	 * @param pseudo Le pseudo de cette (this) IA.
	 */
	public IA(String pseudo) {
		super(pseudo);
		this.memoireGlobale = new ArrayList<>(NB_CARTES_PAQUET);
		this.memoirePlateau = new ArrayList<>(NB_CARTES_PLATEAU);
	}
	
	
	/* * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * *
	 * * * * * * * * * * * * PARTIE MEMOIRE GLOBALE* * * * * * * * * * * * *
	 * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * */
	
	/**
	 * Récupère la mémoire globale de cette (this) IA.
	 * @return La liste de cartes présente dans la mémoire de cette (this) IA.
	 */
	public ArrayList<Carte> getMemoireGlobale() {
		return this.memoireGlobale;
	}
	
	
	/**
	 * Mémorise les cartes jouées présentes sur le plateau pendant un tour.
	 * @param plateau Le plateau de la partie.
	 */
	public void setMemoireGlobale(Plateau plateau) {
		// Ajout des cartes posées sur le plateau dans la mémoire globale.
		this.memoireGlobale.addAll(plateau.getCartes());
	}
	
	
	/**
	 * Vide la mémoire de cette (this) IA. Cette méthode est utile lors de la 
	 * fin d'une manche, pour repartir d'une liste de cartes jouées vide.
	 */
	public void viderMemoireGlobale() {
		// Vidage complet de la mémoire globale de cette (this) IA.
		this.memoireGlobale.clear();
	}
	
	
	/* * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * *
	 * * * * * * * * * * * * PARTIE MEMOIRE PLATEAU* * * * * * * * * * * * *
	 * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * */
	
	public ArrayList<Carte> getMemoirePlateau() {
		return this.memoirePlateau;
	}
	
	
	public void setMemoirePlateau(Plateau plateau) {
		this.memoirePlateau.addAll(plateau.getCartes());
	}
	
	
	public void viderMemoirePlateau() {
		this.memoirePlateau.clear();
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
		cartesJouables.sort(OutilStrategieIA.ordreJeu);
		
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
		cartesJouables.sort(OutilStrategieIA.ordreJeu);
		
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
		
		// Vérifie si le numéro du tour est égal à 0 (premier tour).
		if (noTour == 0) {
			
			/*
			 * Si c'est le premier tour alors on se débarrasse de la carte 
			 * la plus grande que l'on a avec le symbole demandé (plus grande 
			 * carte trèfle sauf en cas d'exception). Si on n'a pas de trèfle 
			 * dans les cartes jouables alors on défausse la plus grande carte 
			 * d'un autre symbole.
			 */
			return cartesJouables.get(cartesJouables.size() - 1);
		}
		
		// TODO Faire le jouer carte 3.
		
		return cartesJouables.get(0);
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
