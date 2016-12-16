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

		if (nbPlayers > 0 && nbPlayers <= 10) {
		    done = true;
		} else {
		    System.err.println("Le nombre de joueur doit être entre 1 et 10 !");
		}
	    } catch (NumberFormatException nfe) {
		System.err.println("Format incorrect!");
	    }
	} while (!done);

	return nbPlayers;
    }

    public static int readScoreInput(int scorePrecedent) {
	@SuppressWarnings("resource")
	Scanner sin = new Scanner(System.in);

	boolean done = false;
	int score = 0;
	do {
	    try {
		System.out.println("Saisir votre score : ");
		score = Integer.parseInt(sin.nextLine());
		if (score >= 0 && score + scorePrecedent <= 10) {
		    done = true;
		} else {
		    System.err.println("Le score total doit être entre 0 et 10 !");
		}
	    } catch (NumberFormatException nfe) {
		System.err.println("Score incorrect !");
	    }
	} while (!done);

	return score;
    }

    public static String readNameInput() {
	@SuppressWarnings("resource")
	Scanner sin = new Scanner(System.in);

	String name = "";

	System.out.println("Nom du joueur : ");
	name = sin.nextLine();

	return name;
    }
}
