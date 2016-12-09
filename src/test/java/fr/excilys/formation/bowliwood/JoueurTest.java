package fr.excilys.formation.bowliwood;

import org.junit.Test;
import fr.ensta.metier.Joueur;
import fr.ensta.metier.Score;
import junit.framework.TestCase;

public class JoueurTest extends TestCase {

    @Test
    public void testCalculScoreSimple() {

	Joueur j = new Joueur("toto");

	int[] tab = new int[21];
	tab[0] = 5;
	tab[1] = 2;
	tab[2] = 2;
	tab[3] = 4;
	tab[4] = 6;
	tab[5] = 0;
	tab[6] = 0;
	tab[7] = 0;
	Score score = new Score();
	score.setTabScore(tab);
	j.setScore(score);

	assertEquals(19, j.getScore().calculScore());
    }

    @Test
    public void testCalculScoreSpare() {

	Joueur j = new Joueur("toto");

	int[] tab = new int[21];
	tab[0] = 5;
	tab[1] = 5;
	tab[2] = 4;
	tab[3] = 4;
	tab[4] = 6;
	tab[5] = 4;
	tab[6] = 0;
	tab[7] = 8;
	Score score = new Score();
	score.setTabScore(tab);
	j.setScore(score);

	assertEquals(40, j.getScore().calculScore());
    }

    @Test
    public void testCalculScoreStrike() {

	Joueur j = new Joueur("toto");

	int[] tab = new int[21];
	tab[0] = 5;
	tab[1] = 2;
	tab[2] = 10;
	tab[3] = 0;
	tab[4] = 10;
	tab[5] = 0;
	tab[6] = 0;
	tab[7] = 2;
	Score score = new Score();
	score.setTabScore(tab);
	j.setScore(score);

	assertEquals(41, j.getScore().calculScore());
    }

    @Test
    public void testCalculScoreTout() {

	Joueur j = new Joueur("toto");

	int[] tab = new int[21];
	tab[0] = 10;
	tab[1] = 0;
	tab[2] = 2;
	tab[3] = 8;
	tab[4] = 10;
	tab[5] = 0;
	tab[6] = 4;
	tab[7] = 2;
	Score score = new Score();
	score.setTabScore(tab);
	j.setScore(score);

	assertEquals(62, j.getScore().calculScore());
    }

}
