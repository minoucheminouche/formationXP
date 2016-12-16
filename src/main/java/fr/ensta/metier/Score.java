package fr.ensta.metier;

/**
 * Classe score
 * @author user
 *
 */
public class Score {
    private Integer scoreTotal;
    private int[] tabScore;
    private int tourEnCours;
    final static int VALEUR_STRIKE = 10;
    final static int NB_TOURS = 10;

    public Score() {
	scoreTotal = 0;
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

    public Integer getScoreTotal() {
	return this.scoreTotal;
    }

    /**
     * Calcule le score total du joueur
     */
    public int calculScore() {
	this.scoreTotal = 0;
	int indicetab = 0;

	for (int i = 0; i < NB_TOURS; i++) {
	    if (isStrike(indicetab)) {
		this.scoreTotal += VALEUR_STRIKE + strikeBonus(indicetab + 2);

	    } else if (isSpare(indicetab)) {
		this.scoreTotal += VALEUR_STRIKE + spareBonus(indicetab);

	    } else {
		this.scoreTotal += sommeLancers(indicetab);
	    }
	    indicetab += 2;
	}
	return this.scoreTotal;
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
	    score = VALEUR_STRIKE + tabScore[indiceLancer + 2];
	} else {
	    score = sommeLancers(indiceLancer);
	}
	return score;
    }

    private int spareBonus(int indiceLancer) {
	return tabScore[indiceLancer + 2];
    }

}
