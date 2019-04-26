/*
 * Carte.java                                                        25/04/2019
 * Projet de la dame de pique | IUT de Rodez | 2018 - 2019
 */

package damedepique.general;

/**
 * <p>
 *   Cette classe contient tous les éléments qui caractérisent une carte pour 
 *   jouer au jeu de la dame de pique.
 * </p>
 * <ul>
 *   <li>
 *     
 *   </li>
 *   <li>
 *     
 *   </li>
 * </ul>
 * 
 * @author Julien B.
 * @version 1.0
 */
public class Carte {

	/** Symbole de cette (this) Carte. */
	private Symbole symbole;
	
	
	/** Ordre de cette (this) Carte. */
	private Ordre ordre;
	
	
	/**
	 * Création d'une nouvelle carte comportant un symbole valide 
	 * et un ordre valide.
	 * @param symbole Symbole pour la carte à créer.
	 * @param ordre Ordre pour la carte à créer.
	 */
	public Carte(Symbole symbole, Ordre ordre) {
		this.symbole = symbole;
		this.ordre = ordre;
	}
	
	
	/**
	 * Récupère le symbole de cette (this) Carte.
	 * @return Le symbole de la carte.
	 */
	public Symbole getSymbole() {
		return this.symbole;
	}
	
	
	/**
	 * Récupère l'ordre de cette (this) Carte.
	 * @return L'ordre de la carte.
	 */
	public Ordre getOrdre() {
		return this.ordre;
	}
	
	
	@Override
	public String toString() {
		return this.ordre.toString() + " de " 
                                     + this.symbole.toString().toLowerCase();
	}
	
}
