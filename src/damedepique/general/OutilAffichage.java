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
 *   Cette classe contient des méthodes utilitaires pour l'affichage sur un 
 *   console texte. Elle possède des outils de nettoyage pour que le joueur 
 *   humain puisse mieux apercevoir les éléments sur l'interface, ...
 * </p>
 * 
 * @author Julien B.
 * @author Loïc B.
 * @author Margaux B.
 * @author Justine R.
 * 
 * @version 1.0
 */
public class OutilAffichage {
	
	/** Analyseur lexical de l'entrée standard texte. */
	private static Scanner sc = new Scanner(System.in);
	
	
	/** Message indiquant que l'échange de cartes débute. */
	public static final String DEBUT_ECHANGE = 
			                   "* * * * * * * * * * * * * * * * * * *\n"
                               + "* * Début de l'échange des cartes * *\n"
                               + "* * * * * * * * * * * * * * * * * * *\n";
	
	
	/** Message indiquant que l'échange de cartes est fini. */
	public static final String FIN_ECHANGE = 
			                   "* * * * * * * * * * * * * * * * * *\n"
                               + "* * Fin de l'échange des cartes * *\n"
                               + "* * * * * * * * * * * * * * * * * *\n";
	
	
	/** Message indiquant qu'il n'y a pas d'échange au début d'une manche. */
	public static final String PAS_ECHANGE = 
			                   "* * * * * * * * * * * * * * * * * *\n"
                               + "* * * Pas d'échange de cartes * * *\n"
                               + "* * * * * * * * * * * * * * * * * *";
	
	
	/**
	 * Affiche une liste de cartes sans les indices associés. Cette méthode est 
	 * utile quand le joueur humain doit visionner ses cartes sans devoir en 
	 * jouer une (affichage de la main après un échange).
	 * @param cartes Une liste de cartes à afficher.
	 * @param message Le message à afficher avec la liste de cartes.
	 */
	public static void afficherCartes(ArrayList<Carte> cartes, 
			                          String message) {
		
		// Affichage d'un message précisant le rôle de la liste de cartes.
		System.out.println(message);
		
		// Parcours des cartes dans la liste spécifiée en argument.
		for (Carte carte : cartes) {
			
			// Affichage de la carte courante.
			System.out.println("=> " + carte);
		}
		
		// Saut d'une ligne pour aérer l'affichage de la liste de cartes.
		System.out.println();
	}
	
	
	/**
	 * Affiche une liste de cartes avec les indices associés. Cette méthode est 
	 * utile quand une joueur doit donner un indice de carte pour la jouer.
	 * @param cartes Une liste de cartes à afficher.
	 * @param message Le message à afficher avec la liste de cartes.
	 */
	public static void afficherCartesIndice(ArrayList<Carte> cartes, 
			                                String message) {
		
		// Affichage d'un message précisant le rôle de la liste de cartes.
		System.out.println(message);
		
		// Parcours des cartes dans la liste spécifiée en argument.
		for (Carte carte : cartes) {
			
			// Affichage de la carte courante avec son indice associé.
			System.out.println("(" + cartes.indexOf(carte) + ") => " + carte);
		}
		
		// Saut d'une ligne pour aérer l'affichage de la liste de cartes.
		System.out.println();
	}
	
	
	/**
	 * Affiche des messages indiquant au joueur humain le sens des échanges.
	 * <ul>  
	 *   <li>
	 *     Quand le numéro est égal à 0 alors les messages d'échange vers le 
	 *     joueur à gauche sont affichés.
	 *   </li>
	 *   <li>
	 *     Quand le numéro est égal à 1 alors les messages d'échange vers le 
	 *     joueur à droite sont affichés.
	 *   </li>
	 *   <li>
	 *     Quand le numéro est différent des valeurs précédemment citées 
	 *     alors les messages d'échange vers le joueur positionné en face sont 
	 *     affichés.
	 *   </li>
	 * </ul>
	 * 
	 * @param joueurs Les joueurs de la partie.
	 * @param numero Le numéro à indiquer pour connaître le message à afficher.
	 */
	public static void afficherEchanges(Joueur[] joueurs, int numero) {		
		if (numero == 0) {
			System.out.println("(-) Vous donnez vos cartes à " 
		                       + joueurs[1].getPseudo() + " ...");
			System.out.println("(+) Vous recevez les cartes de " 
		                       + joueurs[3].getPseudo() + " ...");
			System.out.println("(/) " + joueurs[2].getPseudo() 
					           + " donne ces cartes à " 
					           + joueurs[3].getPseudo() + " ...");
			System.out.println("(/) " + joueurs[1].getPseudo() 
					           + " donne ces cartes à " 
					           + joueurs[2].getPseudo() + " ...\n");
		} else if (numero == 1) {
			System.out.println("(-) Vous donnez vos cartes à " 
		                       + joueurs[3].getPseudo() + " ...");
			System.out.println("(+) Vous recevez les cartes de " 
		                       + joueurs[1].getPseudo() + " ...");
			System.out.println("(/) " + joueurs[3].getPseudo() 
					           + " donne ces cartes à " 
					           + joueurs[2].getPseudo() + " ...");
			System.out.println("(/) " + joueurs[2].getPseudo() 
					           + " donne ces cartes à " 
					           + joueurs[1].getPseudo() + " ...\n");
		} else {
			System.out.println("(-) Vous donnez vos cartes à " 
		                       + joueurs[2].getPseudo() + " ...");
			System.out.println("(+) Vous recevez les cartes de " 
			                   + joueurs[2].getPseudo() + " ...");
			System.out.println("(/) " + joueurs[1].getPseudo() + " et " 
			                   + joueurs[3].getPseudo() 
			                   + " échangent leurs cartes entre eux ...\n");
		}
	}
	
	
	/**
	 * Affiche les quatre joueurs de la partie en cercle pour matérialiser 
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
	 * Affiche un récapitulatif des points d'une manche.
	 * @param joueurs Les joueurs de la partie.
	 * @param noTour Le numéro du tour dans la manche.
	 * @param premier L'indice du joueur qui débute le prochain tour (perdant).
	 */
	public static void afficherRecapManche(Joueur[] joueurs, int noTour, 
			                                                 int premier) {
		
		System.out.println(joueurs[premier].getPseudo() + " a perdu(e) le "
				           + "tour numéro " + (noTour + 1) + " sur 13.\n");
		
		System.out.println("\t\t" + joueurs[2].getPseudo() + " (" 
		                   + joueurs[2].getPointsManche() + " points)\n\n");
		System.out.println(joueurs[1].getPseudo() + " (" 
		                   + joueurs[1].getPointsManche() 
		                   + " points)\t\t\t" + joueurs[3].getPseudo() 
		                   + " (" + joueurs[3].getPointsManche() 
		                   + " points)\n\n");
		System.out.println("\t\t" + joueurs[0].getPseudo() + " (" 
		                   + joueurs[0].getPointsManche() + " points)");
		
		// Saut d'une ligne pour aérer l'affichage.
		System.out.println();
	}
	
	
	/**
	 * Affiche un récapitulatif des points totaux de chaque joueurs.
	 * @param joueurs Les joueurs de la partie.
	 */
	public static void afficherRecapPartie(Joueur[] joueurs) {
		System.out.println("Récapitulatif des points de la partie : \n");
		
		System.out.println("\t\t" + joueurs[2].getPseudo() 
				           + " (" + joueurs[2].getPointsTot() 
				           + " points)\n\n");
		System.out.println(joueurs[1].getPseudo() + " (" 
				           + joueurs[1].getPointsTot() + " points)\t\t\t" 
				           + joueurs[3].getPseudo() + " (" 
				           + joueurs[3].getPointsTot() + " points)\n\n");
		System.out.println("\t\t" + joueurs[0].getPseudo() 
				           + " (" + joueurs[0].getPointsTot() + " points)");
		
		// Saut d'une ligne pour aérer l'affichage.
		System.out.println();
	}
	
	
	/**
	 * Affiche le plateau dans son état final, à la fin d'un tour avec les 
	 * quatre cartes disposées sur le plateau.
	 * @param plateau Le plateau de la partie.
	 * @param joueurs Les joueurs de la partie.
	 */
	public static void afficherPlateau(Plateau plateau, Joueur[] joueurs) {
		/* 
		 * Affichage d'un message pour indiquer que le plateau au cours d'un 
		 * tour est affiché. Ce plateau est dans un état intermédiaire, il n'y 
		 * a pas les quatre cartes disposées sur celui-ci.
		 */
		if (plateau.getCartes().size() != 4) {
			// Message indiquant que le plateau actuel est affiché.
			System.out.println("Le plateau actuel : ");
		
		/*
		 * Sinon si le plateau a une taille strictement égale à quatre 
		 * (le nombre de cartes maximum qu'un même plateau peut accueillir) 
		 * alors la méthode affiche le plateau final.
		 */
		} else {
			// Message indiquant que le plateau final est affiché.
			System.out.println("Le plateau final : ");
		}
		
		// Parcours de toutes les cartes disposées sur le plateau.
		for (Carte carte : plateau.getCartes()) {
			
			// Pour chaque carte, on cherche le joueur ayant joué cette carte.
			int indiceJoueur = rechercherCarte(joueurs, carte.getSymbole(), 
					                                    carte.getValeur());
			
			/* 
			 * Affichage de la carte avec le pseudonyme du joueur ayant 
			 * joué cette carte (pour aider l'humain dans sa stratégie).
			 */
			System.out.println("=> " + carte + " (" 
			                   + joueurs[indiceJoueur].getPseudo() + ")");
		}
		
		// Saut d'une ligne pour aérer l'affichage de la liste de cartes.
		System.out.println();
	}
	
	
	/** 
	 * Affiche le numéro du tour en cours. 
	 * @param noTour Le numéro du tour en cours pendant une manche.
	 */
	public static void afficherNumeroTour(int noTour) {
		System.out.println("/!\\ Début du tour numéro " 
	                       + (noTour + 1) + ".\n");
	}
	
	
	/** 
	 * Affiche le numéro de la manche en cours. 
	 * @param noManche Le numéro de la manche en cours durant une partie.
	 */
	public static void afficherNumeroManche(int noManche) {
		System.out.println("/!\\ Début de la manche numéro " 
	                       + (noManche + 1) + ".\n");
	}
	
	
	/* * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * *
	 * * * * * * * * * * * PARTIE CHANGEMENT PSEUDOS * * * * * * * * * * * *
	 * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * */
	
	/**
	 * Demande au joueur humain d'entrer une option.
	 * @param message Le message à afficher pour inviter le joueur à entrer 
	 *                une option.
	 * @return L'option valide choisie par le joueur.
	 */
	public static char lireOption(String message) {
		boolean nok;       // Indicateur de mauvaise option choisie.
		String reponse;    // Réponse saisie par le joueur humain.
		char option;       // Option qui est déduite de l'option saisie.
		
		/*
		 * Demande au joueur d'entrer une option. Cette option est 
		 * systématiquement (O = oui) ou (N = non). Si l'option saisie n'est 
		 * pas l'une des options précédemment dites alors la saisie d'une 
		 * nouvelle option est recommencée. 
		 */
		do {
			// Affichage d'un message demandant d'entrer une option.
			System.out.print(message);
			
			// Demande et stockage de la réponse du joueur humain à la requête.
			reponse = sc.next() + sc.nextLine();
			
			// Détermination de l'option saisie par le joueur.
			option = reponse.toUpperCase().charAt(0);
			
			// Vérification de la validité de l'option entrée.
			nok = (reponse.length() != 1 || (option != 'O' && option != 'N'));
			
			/* 
			 * Si une mauvaise option a été saisie alors un message 
			 * d'avertissement est affiché au joueur pour lui indiquer les 
			 * options possibles et la saisie est recommencée.
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
	 * Change le pseudo des joueurs de la partie. Cette décision peut seulement 
	 * être prise par le joueur humain.
	 * @param joueurs Les joueurs de la partie.
	 */
	public static void changerPseudos(Joueur[] joueurs) {
		String pseudo;         // Stocke un pseudo entré par le joueur humain.
		char optionChoisie;    // L'option valide saisie par le joueur humain.
		
		/*
		 * Demande une option au joueur pour savoir si il veut changer son 
		 * propre pseudonyme ou non.
		 */
		optionChoisie = lireOption("Votre pseudo actuel est (" 
		                           + joueurs[0].getPseudo() 
		                           + "). Voulez-vous le changer ? (O/N) : ");
		
		/* 
		 * Si le joueur répond a répondu positivement à la requête précédemment 
		 * faite alors on lui demande d'entrer un nouveau pseudo qu'il va 
		 * devoir garder durant tout le déroulement de la partie.
		 */
		if (optionChoisie == 'O') {
			System.out.print("Entrez votre nouveau pseudo : ");
			
			// Demande et stocke le pseudo choisi par le joueur.
			pseudo = sc.next() + sc.nextLine();
			
			// Met à jour le pseudonyme du joueur humain.
			joueurs[0].setPseudo(pseudo);
			
			// Affichage d'un message de confirmation.
			System.out.println("\nVotre pseudo a bien été changé.\n");
		}
		
		/* 
		 * Demande d'une option au joueur pour savoir si il veut changer le 
		 * pseudonyme des trois IA ou non.
		 */
		optionChoisie = lireOption("Voulez-vous changer le pseudo des IA ? "
				                   + "(O/N) : ");
		/* 
		 * Si le joueur répond a répondu positivement à la requête précédemment 
		 * faite alors on lui demande d'entrer un nouveau pseudo pour chaque 
		 * intelligence artificielle (IA).
		 */
		if (optionChoisie == 'O') {
			
			// Parcours des trois IA de la partie.
			for (int i = 1 ; i < joueurs.length ; i++) {
				System.out.print("Le pseudo actuel de l'IA numéro " + i 
						         + " est (" + joueurs[i].getPseudo() 
						         + ").\nEntrez un nouveau pseudo : ");
				
				// Demande et stocke le pseudo choisi par le joueur.
				pseudo = sc.next() + sc.nextLine();
				
				// Met à jour le pseudonyme du joueur courant.
				joueurs[i].setPseudo(pseudo);
				
				// Affichage d'un message de confirmation.
				System.out.println("\nLe pseudo a bien été changé.\n");
			}
		}
	}
	
	
	/* * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * *
	 * * * * * * * * * * * * * * PARTIE VIDAGE * * * * * * * * * * * * * * *
	 * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * */
	
	/**
	 * Efface la console texte pour pour que le jeu soit plus compréhensible 
	 * par le joueur humain.
	 */
	public static void cls() {
		try {
			/* 
			 * Récupère le nom du système d'exploitation sur lequel 
			 * l'application est lancée.
			 */
			final String OS = System.getProperty("os.name");
			
			/* 
			 * Si le joueur a lancé l'application sur Windows alors une 
			 * commande 'cls' est effectuée pour nettoyer la console texte.
			 */
			if (OS.contains("Windows")) {
				new ProcessBuilder("cmd", "/c", "cls").inheritIO().start()
			                                                      .waitFor();
				
			/*
			 * Si le joueur a lancé l'application sur un Linux ou un Mac alors 
			 * une commande 'clear' est effectuée pour nettoyer la console 
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
	 * Demande au joueur d'appuyer sur la touche entrée du clavier pour 
	 * continuer la partie en cours.
	 */
	public static void continuer() {
		// Affichage d'un message pour informer le joueur.
		System.out.println("\n\nAppuyez sur entrée pour continuer "
				           + "la partie ...");
		
		// Attend que le joueur appui sur la touche entrée.
		sc.nextLine();
		
		// Nettoyage de la console texte.
		cls();
	}
	
}
