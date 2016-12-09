package fr.ensta.utilitaires;

import java.util.Scanner;

public final class Util {

    public static int readNbPlayersInput() {
	@SuppressWarnings("resource")
	Scanner sin = new Scanner(System.in);

	boolean done = false;
	int nbPlayers = 0;
	do {
	    try {
		System.out.println("Veuillez saisir le nombre de joueurs : ");
		nbPlayers = Integer.parseInt(sin.nextLine());
		done = true;
	    } catch (NumberFormatException nfe) {
		System.err.println("Format incorrect!");
	    }
	} while (!done);

	return nbPlayers;
    }

    public static int readScoreInput() {
	@SuppressWarnings("resource")
	Scanner sin = new Scanner(System.in);

	boolean done = false;
	int score = 0;
	do {
	    try {
		System.out.println("Saisir votre score : ");
		score = Integer.parseInt(sin.nextLine());
		if (score <= 10) {
		    done = true;
		}
	    } catch (NumberFormatException nfe) {
		System.err.println("Score incorrect !");
	    }
	} while (!done);

	return score;
    }
}
