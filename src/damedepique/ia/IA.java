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

	/** Nombre de cartes qu'un paquet traditionnel contient. */
	private static final int NB_CARTES_PAQUET = 52;
	
	
	/** Stocke les cartes jou�es pendant les tours d'une manche. */
	private ArrayList<Carte> cartesJouees;
	
	
	/**
	 * Cr�ation d'une nouvelle IA avec les caract�ristiques d'un joueur.
	 */
	public IA() {
		super();
		this.cartesJouees = new ArrayList<>(NB_CARTES_PAQUET);
	}
	
	
	/**
	 * Choisie et joue une carte sans restriction, il faut juste que la carte 
	 * s�lectionn�e soit dans la main de cette (this) IA. Cette m�thode est 
	 * utilis�e lors du choix des cartes � �changer.
	 */
	public Carte jouerCarte() {
		// Cartes jouables dans la main de l'IA.
		ArrayList<Carte> cartesJouables = this.getMain();
		
		// TODO Faire un r�seau neuronal pour complexifier.
		
		return cartesJouables.get(0);
	}
	
	
	/**
	 * Choisie et joue une carte en v�rifiant qu'un coeur a �t� d�fauss� ou 
	 * non. Si un coeur n'a jamais �t� d�fauss� alors l'IA ne peut pas 
	 * commencer par une carte comportant du coeur.
	 */
	public Carte jouerCarte(boolean coeurDefausse) {
		// Cartes jouables dans la main de l'IA.
		ArrayList<Carte> cartesJouables = cartesPossibles(this, coeurDefausse);
		
		// TODO Faire un r�seau neuronal pour complexifier.

		return cartesJouables.get(0);
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
		
		// TODO Faire un r�seau neuronal pour complexifier.
		
		return cartesJouables.get(0);
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
	
	
	/**
	 * M�morise les cartes jou�es pr�sentes sur le plateau.
	 * @param plateau Le plateau de la partie.
	 */
	public void memoriserCartes(Plateau plateau) {
		// Parcours des cartes pr�sentes sur le plateau de jeu.
		for (Carte carte : plateau.getCartes()) {
			
			// Ajout de la carte courante dans la m�moire.
			this.cartesJouees.add(carte);
		}
	}
	
}
