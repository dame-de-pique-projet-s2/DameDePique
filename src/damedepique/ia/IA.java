/*
 * IA.java                                                           01/05/2019
 * Projet de la dame de pique | IUT de Rodez | 2018 - 2019
 */

package damedepique.ia;

import java.util.ArrayList;

import damedepique.general.Carte;
import damedepique.general.Joueur;
import damedepique.general.OutilCarte;
import damedepique.general.Symbole;
import damedepique.general.Valeur;

/**
 * <p>
 * Cette classe sert �  g�rer l'inteligence artificielle qui servira 
 * d'adversaire au joueur humain.
 * </p>
 * <ul>
 *    <li>
 *         Pour cela cette classe va :
 *    </li>
 *    <li>
 *            -echanger 3 cartes (pour l'instant dans l'ordre et par la suite 
 *             de fa�on plus r�fl�chie)
 *    </li>
 *    <li>
 *            -jouer les cartes qu'elle a le droit de jouer (pour l'instant 
 *             dans l'ordre puis par la suite de manière � la faire gagner)
 *    </li>
 * </ul>
 * 
 * @author Lo�c B. | Julien B. | Margaux B. | Justine R.
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
     * m�thode qui choisi 3 cartes � �changer au d�but des manches
	 * Les 3 cartes sont (pour le moment) les 3 premieres de la main
	 * @return .
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
	
	
	 // TODO � finir la deuxi�me m�thode
	/**
	 * m�thode qui joue une carte
	 * La carte est (pour le moment) la premiere possible de la main
	 *
	 * @return aJouer la carte qui vas �tre jou�e
	 */
	public Carte jouerCarte() {
		return this.getMain().get(0);
	}
	
	
	/**
	 * 
	 * @param symboleDemande 
	 * @return .
	 */
	public Carte jouerCarte(Symbole symboleDemande) {
		ArrayList<Carte> cartesPossibles;
		
		// R�cup�re les cartes possibles dans la main de l'IA
		cartesPossibles = OutilCarte.cartesPossibles(this, symboleDemande);
		
		return cartesPossibles.get(0);
	}
	
	
	/**
	 * Joue la carte deux de tr�fle.
	 * @return La carte deux de tr�fle.
	 */
	public Carte jouerDeuxTrefle() {
		return OutilCarte.recuperationCarte(this, Symbole.Trefle, Valeur.Deux);
	}
	
}
