package fr.ensta.metier;

/**
 * Classe joueur
 * @author user
 *
 */
public class Joueur {

    private final String name;
    private Score score;

    public Joueur(String name) {
	this.name = name;
	this.score = new Score();
    }

    public String getName() {
	return name;
    }

    public Score getScore() {
	return score;
    }

    public void setScore(Score score) {
	this.score = score;
    }

    @Override
    public String toString() {
	return this.getName() + " - Score : " + this.getScore().getScoreTotal() + " points";
    }

}
