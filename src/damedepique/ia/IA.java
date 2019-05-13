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
	
	
	/** Stocke les cartes jouées pendant les tours d'une manche. */
	private ArrayList<Carte> cartesJouees;
	
	
	/**
	 * Création d'une nouvelle IA avec les caractéristiques d'un joueur.
	 */
	public IA() {
		super();
		this.cartesJouees = new ArrayList<>(NB_CARTES_PAQUET);
	}
	
	
	/**
	 * Choisie et joue une carte sans restriction, il faut juste que la carte 
	 * sélectionnée soit dans la main de cette (this) IA. Cette méthode est 
	 * utilisée lors du choix des cartes à échanger.
	 */
	public Carte jouerCarte() {
		// Cartes jouables dans la main de l'IA.
		ArrayList<Carte> cartesJouables = this.getMain();
		
		// TODO Faire un réseau neuronal pour complexifier.
		
		return cartesJouables.get(0);
	}
	
	
	/**
	 * Choisie et joue une carte en vérifiant qu'un coeur a été défaussé ou 
	 * non. Si un coeur n'a jamais été défaussé alors l'IA ne peut pas 
	 * commencer par une carte comportant du coeur.
	 */
	public Carte jouerCarte(boolean coeurDefausse) {
		// Cartes jouables dans la main de l'IA.
		ArrayList<Carte> cartesJouables = cartesPossibles(this, coeurDefausse);
		
		// TODO Faire un réseau neuronal pour complexifier.

		return cartesJouables.get(0);
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
		
		// TODO Faire un réseau neuronal pour complexifier.
		
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
	
	
	/**
	 * Mémorise les cartes jouées présentes sur le plateau.
	 * @param plateau Le plateau de la partie.
	 */
	public void memoriserCartes(Plateau plateau) {
		// Parcours des cartes présentes sur le plateau de jeu.
		for (Carte carte : plateau.getCartes()) {
			
			// Ajout de la carte courante dans la mémoire.
			this.cartesJouees.add(carte);
		}
	}
	
}
