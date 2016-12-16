package fr.ensta.metier;

import java.util.Comparator;

public class ComparatorScore implements Comparator<Joueur> {

    @Override
    public int compare(Joueur joeur1, Joueur joueur2) {

	// tri desc
	if (joeur1.getScore().getScoreTotal().compareTo(joueur2.getScore().getScoreTotal()) == 1) {
	    return -1;
	} else if (joeur1.getScore().getScoreTotal().compareTo(joueur2.getScore().getScoreTotal()) == -1) {
	    return 1;
	} else {
	    return 0;
	}

    }

}
