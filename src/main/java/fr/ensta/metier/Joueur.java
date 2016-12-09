package fr.ensta.metier;

public class Joueur {

    private String name;
    private Score score;

    public Joueur(String name) {
	this.name = name;
	this.score = new Score();
    }

    public String getName() {
	return name;
    }

    public void setName(String name) {
	this.name = name;
    }

    public Score getScore() {
	return score;
    }

    public void setScore(Score score) {
	this.score = score;
    }

    /**
     * Place le score du joueur du lancer effectué (nombres de quilles tombées)
     * 
     * @param nbQuilles
     *            : le nombre de quilles tombées lors du tour
     */
    public void updateScore(int nbQuilles) {

    }

}
