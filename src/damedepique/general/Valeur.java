/*
 * Valeur.java                                                       27/04/2019
 * Projet de la dame de pique | IUT de Rodez | 2018 - 2019
 */

package damedepique.general;

/**
 * <p>
 *   Cette énumération regroupe les treize valeurs d'un jeu de 52 cartes 
 *   français. Ces treize valeurs peuvent être séparées en deux sous groupes 
 *   distincts :
 * </p>
 * <ul>
 *   <li>
 *     Les points ou autrement dit les petites cartes qui se composent des 
 *     valeurs 10, 9, 8, 7, 6, 5, 4, 3 et 2.
 *   </li>
 *   <li>
 *     Les honneurs ou autrement dit les habillés qui se composent 
 *     essentiellement des figures (valet, dame et roi) ainsi que de l'as. 
 *   </li>
 * </ul>
 * 
 * @author Loïc B. | Julien B. | Margaux B. | Justine R.
 * @version 1.0
 */
public enum Valeur {
	
	Deux, Trois, Quatre, Cinq, Six, Sept, Huit, Neuf, Dix,
	Valet, Dame, Roi, As
	
}
