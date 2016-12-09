package fr.ensta;

import java.util.ArrayList;
import fr.ensta.metier.Joueur;
import fr.ensta.utilitaires.Util;

public class Game {

    final static int NB_TOURS = 10;
    private int nbPlayers;

    public Game init() {

	nbPlayers = Util.readNbPlayersInput();

	return this;
    }

    public void run() {
	// On crée autant de joueurs que renseigné
	ArrayList<Joueur> lstPlayers = new ArrayList<>();

	for (int i = 0; i < nbPlayers; i++) {
	    lstPlayers.add(new Joueur("Joueur" + (i + 1)));
	}

	for (int i = 0; i < NB_TOURS; i++) { // lancement des 10 tours de jeu
	    System.out.println("***** TOUR " + (i + 1) + "*****");
	    for (Joueur joueur : lstPlayers) {
		System.out.println(">>>" + joueur.getName());
		int score = 0;
		for (int j = 0; j < 3; j++) {
		    int m = score;
		    score = Util.readScoreInput();
		    joueur.getScore().setScore(score, i + j);

		    // Analyse du score pour savoir s'il rejoue ou non
		    if (score == 10 && i < 9) {
			j = 2;
			break; // strike donc fin du tour
		    }

		    if (j == 1 && i < 9) { // pour sortir après le lancer 2
			j = 2;
			break;
		    }

		    if (i == 9 && score != 10 && j == 1 && (score + m < 10)) { // on
									       // sort
			j = 2;
			break;
		    }
		}

	    }
	    // TODO : afficher les scores
	}

	// TODO : afficher le classement final
    }

    public static void main(String[] args) {

	new Game().init().run();
    }

}
