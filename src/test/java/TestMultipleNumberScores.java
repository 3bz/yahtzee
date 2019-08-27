import org.junit.Assert;
import org.junit.Test;

public class TestMultipleNumberScores {

    @Test
    public void testChanceScore()
    {
        int[] diceSet = new int[]{5, 4, 3, 2, 1};
        Player testPlayer = new Player(diceSet);
        int expectedOutput = 15;

        int chanceScore = testPlayer.chanceScore();
        Assert.assertEquals(expectedOutput, chanceScore);
    }

    @Test
    public void testSmallStraightScore()
    {
        int[] diceSet = new int[]{1, 2, 3, 4, 5};
        Player testPlayer = new Player(diceSet);
        int expectedOutput = 15;

        int chanceScore = testPlayer.smallStraightScore();
        Assert.assertEquals(expectedOutput, chanceScore);
    }

    @Test
    public void testSmallStraightScoreZeroReturn()
    {
        int[] diceSet = new int[]{1, 2, 3, 4, 6};
        Player testPlayer = new Player(diceSet);
        int expectedOutput = 0;

        int straightScore = testPlayer.smallStraightScore();
        Assert.assertEquals(expectedOutput, straightScore);
    }

    @Test
    public void testSmallStraightScoreUnordered()
    {
        int[] diceSet = new int[]{4, 2, 1, 6, 5};
        Player testPlayer = new Player(diceSet);
        int expectedOutput = 0;

        int straightScore = testPlayer.smallStraightScore();
        Assert.assertEquals(expectedOutput, straightScore);
    }

    @Test
    public void testLargeStraightScore() {
        int[] diceSet = new int[]{2, 3, 4, 5, 6};
        Player testPlayer = new Player(diceSet);
        int expectedOutput = 20;

        int chanceScore = testPlayer.largeStraightScore();
        Assert.assertEquals(expectedOutput, chanceScore);
    }

    @Test
    public void testLargeStraightScoreZeroReturn() {
        int[] diceSet = new int[]{2, 3, 4, 5, 1};
        Player testPlayer = new Player(diceSet);
        int expectedOutput = 0;

        int chanceScore = testPlayer.largeStraightScore();
        Assert.assertEquals(expectedOutput, chanceScore);
    }

    @Test
    public void testLargeStraightScoreUnordered() {
        int[] diceSet = new int[]{6, 4, 3, 5, 2};
        Player testPlayer = new Player(diceSet);
        int expectedOutput = 20;

        int chanceScore = testPlayer.largeStraightScore();
        Assert.assertEquals(expectedOutput, chanceScore);
    }
}
