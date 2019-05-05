/*
 * IA.java                                                           01/05/2019
 * Projet de la dame de pique | IUT de Rodez | 2018 - 2019
 */

package damedepique.ia;

import damedepique.general.Carte;
import damedepique.general.Joueur;
import static damedepique.general.OutilCarte.*;
import damedepique.general.Symbole;
import damedepique.general.Valeur;

/**
 * <p>
 * Cette classe sert � g�rer l'inteligence artificielle qui servira 
 * d'adversaire au joueur humain.
 * </p>
 * <ul>
 *    <li>
 *         Pour cela cette classe va :
 *    </li>
 *    <li>
 *            - �changer 3 cartes (pour l'instant dans l'ordre et par la suite 
 *             de fa�on plus r�fl�chie)
 *    </li>
 *    <li>
 *            - jouer les cartes qu'elle a le droit de jouer (pour l'instant 
 *             dans l'ordre puis par la suite de manière � la faire gagner)
 *    </li>
 * </ul>
 * 
 * @author Lo�c B. Julien B. Margaux B. Justine R.
 * @version 1.0
 */
public class IA extends Joueur {

	/**
	 * Cr�ation d'une nouvelle IA avec les caract�ristiques d'un joueur.
	 * @see damedepique.general.Joueur
	 */
	public IA() {
		super();
	}
	
	
	/**
     * Choix des 3 cartes � �changer au d�but des manches
	 * Les 3 cartes sont par d�faut les 3 premieres de la main
	 * @return aEchanger les cartes que l'IA choisit d'�changer
	 * 
     */
	public Carte[] choisirCartesAEchanger() {
		Carte[] aEchanger = new Carte[3];

		for (int i = 0 ; i < 3 ; i++) {
			aEchanger[i] = this.jouerCarte();
			
			this.retirerCarte(aEchanger[i]);
		}
		
		return aEchanger;
    }
	
	
	 // TODO : am�liorer cette classe
	/**
	 * Choix d'une carte � jouer
	 * La carte pr�-s�lectionn�e est par d�faut celle en premi�re position 
	 * dans la main courante
	 *
	 * @return aJouer la carte jou�e
	 */
	public Carte jouerCarte() {
		return this.getMain().get(0);
	}
	
	/* TODO : a supprimer et trouver une alternative, changer dans DameDePique */
	/**
	 * TODO : commenter le r�le de cette m�thode
	 * @param symboleDemande
	 * @return .
	 */
	public Carte jouerCarte(Symbole symboleDemande) {

		// R�cup�re les cartes possibles dans la main de l'IA;
		return this.getCartesPossibles().get(0);
	}
	
	
	/**
	 * Joue la carte deux de tr�fle.
	 * @return La carte deux de tr�fle.
	 */
	public Carte jouerDeuxTrefle() {
		return recuperationCarte(this, Symbole.Trefle, Valeur.Deux);
	}
	
}
