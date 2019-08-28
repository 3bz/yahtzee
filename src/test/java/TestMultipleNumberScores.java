import org.junit.Assert;
import org.junit.Test;

public class TestMultipleNumberScores {

    @Test
    public void testChanceScore()
    {
        int[] diceSet = new int[]{5, 4, 3, 2, 1};
        Game testGame = new Game(diceSet);
        int expectedOutput = 15;

        int chanceScore = testGame.chanceScore();
        Assert.assertEquals(expectedOutput, chanceScore);
    }

    @Test
    public void testSmallStraightScore()
    {
        int[] diceSet = new int[]{1, 2, 3, 4, 5};
        Game testGame = new Game(diceSet);
        int expectedOutput = 15;

        int chanceScore = testGame.smallStraightScore();
        Assert.assertEquals(expectedOutput, chanceScore);
    }

    @Test
    public void testSmallStraightScoreZeroReturn()
    {
        int[] diceSet = new int[]{1, 2, 3, 4, 6};
        Game testGame = new Game(diceSet);
        int expectedOutput = 0;

        int straightScore = testGame.smallStraightScore();
        Assert.assertEquals(expectedOutput, straightScore);
    }

    @Test
    public void testSmallStraightScoreUnordered()
    {
        int[] diceSet = new int[]{4, 2, 1, 6, 5};
        Game testGame = new Game(diceSet);
        int expectedOutput = 0;

        int straightScore = testGame.smallStraightScore();
        Assert.assertEquals(expectedOutput, straightScore);
    }

    @Test
    public void testLargeStraightScore() {
        int[] diceSet = new int[]{2, 3, 4, 5, 6};
        Game testGame = new Game(diceSet);
        int expectedOutput = 20;

        int score = testGame.largeStraightScore();
        Assert.assertEquals(expectedOutput, score);
    }

    @Test
    public void testLargeStraightScoreZeroReturn() {
        int[] diceSet = new int[]{2, 3, 4, 5, 1};
        Game testGame = new Game(diceSet);
        int expectedOutput = 0;

        int score = testGame.largeStraightScore();
        Assert.assertEquals(expectedOutput, score);
    }

    @Test
    public void testLargeStraightScoreUnordered() {
        int[] diceSet = new int[]{6, 4, 3, 5, 2};
        Game testGame = new Game(diceSet);
        int expectedOutput = 20;

        int score = testGame.largeStraightScore();
        Assert.assertEquals(expectedOutput, score);
    }
}
