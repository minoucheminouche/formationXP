package fr.ensta.metier;

public class Score {
    private int score;
    private int[] tabScore;
    private int tourEnCours;
    final static int VALEUR_STRIKE = 10;
    final static int NB_TOURS = 10;

    public Score() {
	score = 0;
	tabScore = new int[21];
	tourEnCours = 0;
    }

    public int[] getTabScore() {
	return tabScore;
    }

    public void setTabScore(int[] tabScore) {
	this.tabScore = tabScore;
    }

    public int getScore(int indice) {
	return tabScore[indice];
    }

    public void setScore(int score, int indiceScore) {
	tabScore[indiceScore] = score;
    }

    public int getTourEnCours() {
	return tourEnCours;
    }

    public void setTourEnCours(int tourEnCours) {
	this.tourEnCours = tourEnCours;
    }

    /**
     * Calcule le score total du joueur
     */
    public int calculScore() {
	int scoreTotal = 0;
	int indicetab = 0;

	for (int i = 0; i < NB_TOURS; i++) {
	    if (isStrike(indicetab)) {
		scoreTotal += VALEUR_STRIKE + strikeBonus(indicetab);
		indicetab += 2;
	    } else if (isSpare(indicetab)) {
		scoreTotal += VALEUR_STRIKE + spareBonus(indicetab);
		indicetab += 2;
	    } else {
		scoreTotal += sommeLancers(indicetab);
		indicetab += 2;
	    }
	}
	return scoreTotal;
    }

    public boolean isStrike(int indiceLancer) {
	return tabScore[indiceLancer] == VALEUR_STRIKE;
    }

    public boolean isSpare(int indiceLancer) {
	return sommeLancers(indiceLancer) == VALEUR_STRIKE;
    }

    private int sommeLancers(int indiceLancer) {
	return tabScore[indiceLancer] + tabScore[indiceLancer + 1];
    }

    private int strikeBonus(int indiceLancer) {
	int score = 0;

	if (isStrike(indiceLancer)) {
	    score = sommeLancers(indiceLancer + 2);
	} else {
	    score = sommeLancers(indiceLancer + 1);
	}
	return score;
    }

    private int spareBonus(int indiceLancer) {
	return tabScore[indiceLancer + 2];
    }
}
