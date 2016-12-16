package fr.ensta;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import fr.ensta.metier.ComparatorScore;
import fr.ensta.metier.Joueur;
import fr.ensta.utilitaires.Util;

public class Game {
    final static int VALEUR_STRIKE = 10;
    final static int NB_TOURS = 10;
    private int nbPlayers;
    private List<Joueur> lstPlayers;

    public Game init() {

	nbPlayers = Util.readNbPlayersInput();

	return this;
    }

    public void run() {
	// On crée autant de joueurs que renseigné
	lstPlayers = new ArrayList<>();

	for (int i = 0; i < nbPlayers; i++) {
	    String nom = Util.readNameInput();
	    lstPlayers.add(new Joueur(nom));
	}

	for (int i = 0; i < NB_TOURS; i++) { // lancement des 10 tours de jeu
	    System.out.println("***** TOUR " + (i + 1) + " *****");

	    for (Joueur joueur : lstPlayers) {
		System.out.println(">>>" + joueur.getName() + "(" + joueur.getScore().calculScore() + " pts)");
		print();
		int score = 0;

		for (int j = 0; j < 3; j++) {
		    int scorePrecedent = score;
		    score = Util.readScoreInput(scorePrecedent);
		    joueur.getScore().setScore(score, (i * 2) + j);

		    // Analyse du score pour savoir s'il rejoue ou non
		    if (j == 0 && score == VALEUR_STRIKE && i < NB_TOURS - 1) {

			System.out.println("STRIIIIIIIIKE !!!");
			j = 2;
			break; // strike donc fin du tour
		    }

		    if (j == 1 && i < NB_TOURS - 1) { // pour sortir après le
						      // lancer 2
			if ((score + scorePrecedent) == VALEUR_STRIKE)
			    System.out.println("SPAAAAAARE !!!");

			j = 2;
			break;
		    }

		    if (i == NB_TOURS - 1 && score != VALEUR_STRIKE && j == 1
			    && (score + scorePrecedent < VALEUR_STRIKE)) { // on
			// sort
			j = 2;
			break;
		    }
		}

	    }
	}

	// afficher le classement final
	System.out.println("Fin de la partie. Classement final :\n");
	print();
	// tri des joueurs en fonction de leur score final
	Collections.sort(lstPlayers, new ComparatorScore());

	for (Joueur joueur : lstPlayers) {
	    System.out.println(joueur.toString());
	}
    }

    /**
     * Affiche un tableau récapitulatif des scores de la partie en cours
     */
    private void print() {
	System.out.println(
		"---------------------------------------------------------------------------------------------------------------");
	System.out.println(
		"\t\t|   1   |   2   |   3   |   4   |   5   |   6   |   7   |   8   |   9   |    10     |  TOTAL");
	System.out.println(
		"---------------------------------------------------------------------------------------------------------------");

	for (Joueur joueur : lstPlayers) {
	    System.out.print(String.format("%16s", joueur.getName()));
	    System.out.print("|");
	    for (int i = 0; i < joueur.getScore().getTabScore().length; i++) {
		if (i % 2 == 0) {
		    if (joueur.getScore().getScore(i) == VALEUR_STRIKE) {
			System.out.print(String.format("%3s", "X"));
		    } else {
			System.out.print(String.format("%3d", joueur.getScore().getScore(i)));
		    }
		} else {
		    if (joueur.getScore().getScore(i) + joueur.getScore().getScore(i - 1) == VALEUR_STRIKE
			    && joueur.getScore().getScore(i - 1) != VALEUR_STRIKE) {
			System.out.print(String.format("%3s", "/"));
		    } else {
			System.out.print(String.format("%3d", joueur.getScore().getScore(i)));
		    }
		}
		System.out.print("|");
	    }
	    System.out.print("  " + joueur.getScore().getScoreTotal() + " pts\n");
	    System.out.println(
		    "--------------------------------------------------------------------------------------------------------------");
	}

    }

    public static void main(String[] args) {

	new Game().init().run();
    }

}
