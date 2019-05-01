/*
 * IA.java                                                           01/05/2019
 * Projet de la dame de pique | IUT de Rodez | 2018 - 2019
 */

package damedepique.ia;

import damedepique.general.Joueur;
import java.util.ArrayList;

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
 *            -echanger 3 cartes (pour l'instant dans l'ordre et par la suite 
 *             de fa�on plus r�fl�chie)
 *    </li>
 *    <li>
 *            -jouer les cartes qu'elle a le droit de jouer (pour l'instant 
 *             dans l'ordre puis par la suite de manière � la faire gagner)
 *    </li>
 * </ul>
 *
 *
 * @author Julien B.
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
     * méthode qui choisi 3 cartes à echanger au debut des manches
	 * Les 3 cartes sont (pour le moment) les 3 premieres de la main
	 * 
	 * @return echange[] un tableau de 3 elements contenants des cartes
     */
	 public Carte[] carteEchange() {
		// Cr�ation d'un tableau d'objets carte pour stocker les cartes 
		// choisies pour l'�change
        Carte[] echange = new  Carte[3];
  
        // On donne au tableau les trois premieres cartes de la main tri�e
        for (int i = 0; i<3; i++){
            echange[i]= getMain().get(i);
        }
        // On renvoie le tableau contenant les cartes que l'IA va echanger
        return echange;

    }
		
    
	
	 // TODO � finir la deuxieme methode
//	/**
//	 * méthode qui joue une carte
//	 * La carte est (pour le moment) la premiere possible de la main
//	 *
//	 * @return aJouer la carte qui vas être jouée
//	 */
//	public void jouerCarte() {
//		Carte aJouer = new Carte;
//		aJouer = cartesJouables.get(0);
//		return aJouer		
//	}
	
}

