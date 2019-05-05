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
 * Cette classe sert à gérer l'inteligence artificielle qui servira 
 * d'adversaire au joueur humain.
 * </p>
 * <ul>
 *    <li>
 *         Pour cela cette classe va :
 *    </li>
 *    <li>
 *            - échanger 3 cartes (pour l'instant dans l'ordre et par la suite 
 *             de façon plus réfléchie)
 *    </li>
 *    <li>
 *            - jouer les cartes qu'elle a le droit de jouer (pour l'instant 
 *             dans l'ordre puis par la suite de maniÃ¨re à la faire gagner)
 *    </li>
 * </ul>
 * 
 * @author Loïc B. Julien B. Margaux B. Justine R.
 * @version 1.0
 */
public class IA extends Joueur {

	/**
	 * Création d'une nouvelle IA avec les caractéristiques d'un joueur.
	 * @see damedepique.general.Joueur
	 */
	public IA() {
		super();
	}
	
	
	/**
     * Choix des 3 cartes à échanger au début des manches
	 * Les 3 cartes sont par défaut les 3 premieres de la main
	 * @return aEchanger les cartes que l'IA choisit d'échanger
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
	
	
	 // TODO : améliorer cette classe
	/**
	 * Choix d'une carte à jouer
	 * La carte pré-sélectionnée est par défaut celle en première position 
	 * dans la main courante
	 *
	 * @return aJouer la carte jouée
	 */
	public Carte jouerCarte() {
		return this.getMain().get(0);
	}
	
	/* TODO : a supprimer et trouver une alternative, changer dans DameDePique */
	/**
	 * TODO : commenter le rôle de cette méthode
	 * @param symboleDemande
	 * @return .
	 */
	public Carte jouerCarte(Symbole symboleDemande) {

		// Récupère les cartes possibles dans la main de l'IA;
		return this.getCartesPossibles().get(0);
	}
	
	
	/**
	 * Joue la carte deux de trèfle.
	 * @return La carte deux de trèfle.
	 */
	public Carte jouerDeuxTrefle() {
		return recuperationCarte(this, Symbole.Trefle, Valeur.Deux);
	}
	
}
