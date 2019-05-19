/*
 * OutilAffichage.java                                               12/05/2019
 * Projet de la dame de pique | IUT de Rodez | 2018 - 2019
 */

package damedepique.general;

import static damedepique.general.OutilCarte.*;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * <p>
 *   Cette classe contient des m�thodes utilitaires pour l'affichage sur un 
 *   console texte. Elle poss�de des outils de nettoyage pour que le joueur 
 *   humain puisse mieux apercevoir les �l�ments sur l'interface, ...
 * </p>
 * 
 * @author Julien B.
 * @author Lo�c B.
 * @author Margaux B.
 * @author Justine R.
 * 
 * @version 1.0
 */
public class OutilAffichage {
	
	/** Analyseur lexical de l'entr�e standard texte. */
	private static Scanner sc = new Scanner(System.in);
	
	
	/** Message indiquant que l'�change de cartes d�bute. */
	public static final String DEBUT_ECHANGE = 
			                   "* * * * * * * * * * * * * * * * * * *\n"
                               + "* * D�but de l'�change des cartes * *\n"
                               + "* * * * * * * * * * * * * * * * * * *\n";
	
	
	/** Message indiquant que l'�change de cartes est fini. */
	public static final String FIN_ECHANGE = 
			                   "* * * * * * * * * * * * * * * * * *\n"
                               + "* * Fin de l'�change des cartes * *\n"
                               + "* * * * * * * * * * * * * * * * * *\n";
	
	
	/** Message indiquant qu'il n'y a pas d'�change au d�but d'une manche. */
	public static final String PAS_ECHANGE = 
			                   "* * * * * * * * * * * * * * * * * *\n"
                               + "* * * Pas d'�change de cartes * * *\n"
                               + "* * * * * * * * * * * * * * * * * *";
	
	
	/**
	 * Affiche une liste de cartes sans les indices associ�s. Cette m�thode est 
	 * utile quand le joueur humain doit visionner ses cartes sans devoir en 
	 * jouer une (affichage de la main apr�s un �change).
	 * @param cartes Une liste de cartes � afficher.
	 * @param message Le message � afficher avec la liste de cartes.
	 */
	public static void afficherCartes(ArrayList<Carte> cartes, 
			                          String message) {
		
		// Affichage d'un message pr�cisant le r�le de la liste de cartes.
		System.out.println(message);
		
		// Parcours des cartes dans la liste sp�cifi�e en argument.
		for (Carte carte : cartes) {
			
			// Affichage de la carte courante.
			System.out.println("=> " + carte);
		}
		
		// Saut d'une ligne pour a�rer l'affichage de la liste de cartes.
		System.out.println();
	}
	
	
	/**
	 * Affiche une liste de cartes avec les indices associ�s. Cette m�thode est 
	 * utile quand une joueur doit donner un indice de carte pour la jouer.
	 * @param cartes Une liste de cartes � afficher.
	 * @param message Le message � afficher avec la liste de cartes.
	 */
	public static void afficherCartesIndice(ArrayList<Carte> cartes, 
			                                String message) {
		
		// Affichage d'un message pr�cisant le r�le de la liste de cartes.
		System.out.println(message);
		
		// Parcours des cartes dans la liste sp�cifi�e en argument.
		for (Carte carte : cartes) {
			
			// Affichage de la carte courante avec son indice associ�.
			System.out.println("(" + cartes.indexOf(carte) + ") => " + carte);
		}
		
		// Saut d'une ligne pour a�rer l'affichage de la liste de cartes.
		System.out.println();
	}
	
	
	/**
	 * Affiche des messages indiquant au joueur humain le sens des �changes.
	 * <ul>  
	 *   <li>
	 *     Quand le num�ro est �gal � 0 alors les messages d'�change vers le 
	 *     joueur � gauche sont affich�s.
	 *   </li>
	 *   <li>
	 *     Quand le num�ro est �gal � 1 alors les messages d'�change vers le 
	 *     joueur � droite sont affich�s.
	 *   </li>
	 *   <li>
	 *     Quand le num�ro est diff�rent des valeurs pr�c�demment cit�es 
	 *     alors les messages d'�change vers le joueur positionn� en face sont 
	 *     affich�s.
	 *   </li>
	 * </ul>
	 * 
	 * @param joueurs Les joueurs de la partie.
	 * @param numero Le num�ro � indiquer pour conna�tre le message � afficher.
	 */
	public static void afficherEchanges(Joueur[] joueurs, int numero) {		
		if (numero == 0) {
			System.out.println("(-) Vous donnez vos cartes � " 
		                       + joueurs[1].getPseudo() + " ...");
			System.out.println("(+) Vous recevez les cartes de " 
		                       + joueurs[3].getPseudo() + " ...");
			System.out.println("(/) " + joueurs[2].getPseudo() 
					           + " donne ces cartes � " 
					           + joueurs[3].getPseudo() + " ...");
			System.out.println("(/) " + joueurs[1].getPseudo() 
					           + " donne ces cartes � " 
					           + joueurs[2].getPseudo() + " ...\n");
		} else if (numero == 1) {
			System.out.println("(-) Vous donnez vos cartes � " 
		                       + joueurs[3].getPseudo() + " ...");
			System.out.println("(+) Vous recevez les cartes de " 
		                       + joueurs[1].getPseudo() + " ...");
			System.out.println("(/) " + joueurs[3].getPseudo() 
					           + " donne ces cartes � " 
					           + joueurs[2].getPseudo() + " ...");
			System.out.println("(/) " + joueurs[2].getPseudo() 
					           + " donne ces cartes � " 
					           + joueurs[1].getPseudo() + " ...\n");
		} else {
			System.out.println("(-) Vous donnez vos cartes � " 
		                       + joueurs[2].getPseudo() + " ...");
			System.out.println("(+) Vous recevez les cartes de " 
			                   + joueurs[2].getPseudo() + " ...");
			System.out.println("(/) " + joueurs[1].getPseudo() + " et " 
			                   + joueurs[3].getPseudo() 
			                   + " �changent leurs cartes entre eux ...\n");
		}
	}
	
	
	/**
	 * Affiche les quatre joueurs de la partie en cercle pour mat�rialiser 
	 * une table de jeu.
	 * @param joueurs Les joueurs de la partie.
	 */
	public static void afficherJoueurs(Joueur[] joueurs) {
		System.out.println("Les joueurs de la partie : \n");
		
		System.out.println("\n\t\t" + joueurs[2].getPseudo() + "\n\n");
		System.out.println(joueurs[1].getPseudo() + "\t\t\t\t" 
		                   + joueurs[3].getPseudo() + "\n\n");
		System.out.println("\t\t" + joueurs[0].getPseudo());
	}
	
	
	/**
	 * Affiche un r�capitulatif des points d'une manche.
	 * @param joueurs Les joueurs de la partie.
	 * @param noTour Le num�ro du tour dans la manche.
	 * @param premier L'indice du joueur qui d�bute le prochain tour (perdant).
	 */
	public static void afficherRecapManche(Joueur[] joueurs, int noTour, 
			                                                 int premier) {
		
		System.out.println(joueurs[premier].getPseudo() + " a perdu(e) le "
				           + "tour num�ro " + (noTour + 1) + " sur 13.\n");
		
		System.out.println("\t\t" + joueurs[2].getPseudo() + " (" 
		                   + joueurs[2].getPointsManche() + " points)\n\n");
		System.out.println(joueurs[1].getPseudo() + " (" 
		                   + joueurs[1].getPointsManche() 
		                   + " points)\t\t\t" + joueurs[3].getPseudo() 
		                   + " (" + joueurs[3].getPointsManche() 
		                   + " points)\n\n");
		System.out.println("\t\t" + joueurs[0].getPseudo() + " (" 
		                   + joueurs[0].getPointsManche() + " points)");
		
		// Saut d'une ligne pour a�rer l'affichage.
		System.out.println();
	}
	
	
	/**
	 * Affiche un r�capitulatif des points totaux de chaque joueurs.
	 * @param joueurs Les joueurs de la partie.
	 */
	public static void afficherRecapPartie(Joueur[] joueurs) {
		System.out.println("R�capitulatif des points de la partie : \n");
		
		System.out.println("\t\t" + joueurs[2].getPseudo() 
				           + " (" + joueurs[2].getPointsTot() 
				           + " points)\n\n");
		System.out.println(joueurs[1].getPseudo() + " (" 
				           + joueurs[1].getPointsTot() + " points)\t\t\t" 
				           + joueurs[3].getPseudo() + " (" 
				           + joueurs[3].getPointsTot() + " points)\n\n");
		System.out.println("\t\t" + joueurs[0].getPseudo() 
				           + " (" + joueurs[0].getPointsTot() + " points)");
		
		// Saut d'une ligne pour a�rer l'affichage.
		System.out.println();
	}
	
	
	/**
	 * Affiche le plateau dans son �tat final, � la fin d'un tour avec les 
	 * quatre cartes dispos�es sur le plateau.
	 * @param plateau Le plateau de la partie.
	 * @param joueurs Les joueurs de la partie.
	 */
	public static void afficherPlateau(Plateau plateau, Joueur[] joueurs) {
		/* 
		 * Affichage d'un message pour indiquer que le plateau au cours d'un 
		 * tour est affich�. Ce plateau est dans un �tat interm�diaire, il n'y 
		 * a pas les quatre cartes dispos�es sur celui-ci.
		 */
		if (plateau.getCartes().size() != 4) {
			// Message indiquant que le plateau actuel est affich�.
			System.out.println("Le plateau actuel : ");
		
		/*
		 * Sinon si le plateau a une taille strictement �gale � quatre 
		 * (le nombre de cartes maximum qu'un m�me plateau peut accueillir) 
		 * alors la m�thode affiche le plateau final.
		 */
		} else {
			// Message indiquant que le plateau final est affich�.
			System.out.println("Le plateau final : ");
		}
		
		// Parcours de toutes les cartes dispos�es sur le plateau.
		for (Carte carte : plateau.getCartes()) {
			
			// Pour chaque carte, on cherche le joueur ayant jou� cette carte.
			int indiceJoueur = rechercherCarte(joueurs, carte.getSymbole(), 
					                                    carte.getValeur());
			
			/* 
			 * Affichage de la carte avec le pseudonyme du joueur ayant 
			 * jou� cette carte (pour aider l'humain dans sa strat�gie).
			 */
			System.out.println("=> " + carte + " (" 
			                   + joueurs[indiceJoueur].getPseudo() + ")");
		}
		
		// Saut d'une ligne pour a�rer l'affichage de la liste de cartes.
		System.out.println();
	}
	
	
	/** 
	 * Affiche le num�ro du tour en cours. 
	 * @param noTour Le num�ro du tour en cours pendant une manche.
	 */
	public static void afficherNumeroTour(int noTour) {
		System.out.println("/!\\ D�but du tour num�ro " 
	                       + (noTour + 1) + ".\n");
	}
	
	
	/** 
	 * Affiche le num�ro de la manche en cours. 
	 * @param noManche Le num�ro de la manche en cours durant une partie.
	 */
	public static void afficherNumeroManche(int noManche) {
		System.out.println("/!\\ D�but de la manche num�ro " 
	                       + (noManche + 1) + ".\n");
	}
	
	
	/* * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * *
	 * * * * * * * * * * * PARTIE CHANGEMENT PSEUDOS * * * * * * * * * * * *
	 * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * */
	
	/**
	 * Demande au joueur humain d'entrer une option.
	 * @param message Le message � afficher pour inviter le joueur � entrer 
	 *                une option.
	 * @return L'option valide choisie par le joueur.
	 */
	public static char lireOption(String message) {
		boolean nok;       // Indicateur de mauvaise option choisie.
		String reponse;    // R�ponse saisie par le joueur humain.
		char option;       // Option qui est d�duite de l'option saisie.
		
		/*
		 * Demande au joueur d'entrer une option. Cette option est 
		 * syst�matiquement (O = oui) ou (N = non). Si l'option saisie n'est 
		 * pas l'une des options pr�c�demment dites alors la saisie d'une 
		 * nouvelle option est recommenc�e. 
		 */
		do {
			// Affichage d'un message demandant d'entrer une option.
			System.out.print(message);
			
			// Demande et stockage de la r�ponse du joueur humain � la requ�te.
			reponse = sc.next() + sc.nextLine();
			
			// D�termination de l'option saisie par le joueur.
			option = reponse.toUpperCase().charAt(0);
			
			// V�rification de la validit� de l'option entr�e.
			nok = (reponse.length() != 1 || (option != 'O' && option != 'N'));
			
			/* 
			 * Si une mauvaise option a �t� saisie alors un message 
			 * d'avertissement est affich� au joueur pour lui indiquer les 
			 * options possibles et la saisie est recommenc�e.
			 */
			if (nok) {
				System.out.println("\nVous devez entrer une option correcte.\n"
						           + "Vous avez le choix entre (O = oui) et "
						           + "(N = non).\n");
			}
		} while (nok);
		
		return option;    // Retourne l'option valide saisie par le joueur.
	}
	
	
	/**
	 * Change le pseudo des joueurs de la partie. Cette d�cision peut seulement 
	 * �tre prise par le joueur humain.
	 * @param joueurs Les joueurs de la partie.
	 */
	public static void changerPseudos(Joueur[] joueurs) {
		String pseudo;         // Stocke un pseudo entr� par le joueur humain.
		char optionChoisie;    // L'option valide saisie par le joueur humain.
		
		/*
		 * Demande une option au joueur pour savoir si il veut changer son 
		 * propre pseudonyme ou non.
		 */
		optionChoisie = lireOption("Votre pseudo actuel est (" 
		                           + joueurs[0].getPseudo() 
		                           + "). Voulez-vous le changer ? (O/N) : ");
		
		/* 
		 * Si le joueur r�pond a r�pondu positivement � la requ�te pr�c�demment 
		 * faite alors on lui demande d'entrer un nouveau pseudo qu'il va 
		 * devoir garder durant tout le d�roulement de la partie.
		 */
		if (optionChoisie == 'O') {
			System.out.print("Entrez votre nouveau pseudo : ");
			
			// Demande et stocke le pseudo choisi par le joueur.
			pseudo = sc.next() + sc.nextLine();
			
			// Met � jour le pseudonyme du joueur humain.
			joueurs[0].setPseudo(pseudo);
			
			// Affichage d'un message de confirmation.
			System.out.println("\nVotre pseudo a bien �t� chang�.\n");
		}
		
		/* 
		 * Demande d'une option au joueur pour savoir si il veut changer le 
		 * pseudonyme des trois IA ou non.
		 */
		optionChoisie = lireOption("Voulez-vous changer le pseudo des IA ? "
				                   + "(O/N) : ");
		/* 
		 * Si le joueur r�pond a r�pondu positivement � la requ�te pr�c�demment 
		 * faite alors on lui demande d'entrer un nouveau pseudo pour chaque 
		 * intelligence artificielle (IA).
		 */
		if (optionChoisie == 'O') {
			
			// Parcours des trois IA de la partie.
			for (int i = 1 ; i < joueurs.length ; i++) {
				System.out.print("Le pseudo actuel de l'IA num�ro " + i 
						         + " est (" + joueurs[i].getPseudo() 
						         + ").\nEntrez un nouveau pseudo : ");
				
				// Demande et stocke le pseudo choisi par le joueur.
				pseudo = sc.next() + sc.nextLine();
				
				// Met � jour le pseudonyme du joueur courant.
				joueurs[i].setPseudo(pseudo);
				
				// Affichage d'un message de confirmation.
				System.out.println("\nLe pseudo a bien �t� chang�.\n");
			}
		}
	}
	
	
	/* * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * *
	 * * * * * * * * * * * * * * PARTIE VIDAGE * * * * * * * * * * * * * * *
	 * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * */
	
	/**
	 * Efface la console texte pour pour que le jeu soit plus compr�hensible 
	 * par le joueur humain.
	 */
	public static void cls() {
		try {
			/* 
			 * R�cup�re le nom du syst�me d'exploitation sur lequel 
			 * l'application est lanc�e.
			 */
			final String OS = System.getProperty("os.name");
			
			/* 
			 * Si le joueur a lanc� l'application sur Windows alors une 
			 * commande 'cls' est effectu�e pour nettoyer la console texte.
			 */
			if (OS.contains("Windows")) {
				new ProcessBuilder("cmd", "/c", "cls").inheritIO().start()
			                                                      .waitFor();
				
			/*
			 * Si le joueur a lanc� l'application sur un Linux ou un Mac alors 
			 * une commande 'clear' est effectu�e pour nettoyer la console 
			 * texte.
			 */
			} else {
				new ProcessBuilder("cmd", "/c", "clear").inheritIO().start()
				                                                    .waitFor();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	
	/**
	 * Demande au joueur d'appuyer sur la touche entr�e du clavier pour 
	 * continuer la partie en cours.
	 */
	public static void continuer() {
		// Affichage d'un message pour informer le joueur.
		System.out.println("\n\nAppuyez sur entr�e pour continuer "
				           + "la partie ...");
		
		// Attend que le joueur appui sur la touche entr�e.
		sc.nextLine();
		
		// Nettoyage de la console texte.
		cls();
	}
	
}
