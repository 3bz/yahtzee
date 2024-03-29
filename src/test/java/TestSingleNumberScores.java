import org.junit.Assert;
import org.junit.Test;

public class TestSingleNumberScores {
    public int[] diceSet = new int[]{1,2,3,4,5};
    public Game testGame = new Game(diceSet);

    @Test
    public void testChanceScore()
    {
        int expectedOutput = 15;

        int chanceScore = testGame.chanceScore(diceSet);
        Assert.assertEquals(expectedOutput, chanceScore);
    }

    @Test
    public void testOnesScore()
    {
        int expectedOutput = 1;

        int onesScore = testGame.singleNumberCategoryScore(diceSet,1);
        Assert.assertEquals(expectedOutput, onesScore);
    }

    @Test
    public void testTwosScore()
    {
        int expectedOutput = 2;

        int twosScore = testGame.singleNumberCategoryScore(diceSet,2);
        Assert.assertEquals(expectedOutput, twosScore);
    }

    @Test
    public void testThreesScore()
    {
        int expectedOutput = 3;

        int threesScore = testGame.singleNumberCategoryScore(diceSet,3);
        Assert.assertEquals(expectedOutput, threesScore);
    }

    @Test
    public void testFoursScore()
    {
        int expectedOutput = 4;

        int foursScore = testGame.singleNumberCategoryScore(diceSet,4);
        Assert.assertEquals(expectedOutput, foursScore);
    }

    @Test
    public void testFivesScore()
    {
        int expectedOutput = 5;

        int fivesScore = testGame.singleNumberCategoryScore(diceSet,5);
        Assert.assertEquals(expectedOutput, fivesScore);
    }

    @Test
    public void testSixesScore()
    {
        int expectedOutput = 0;

        int sixesScore = testGame.singleNumberCategoryScore(diceSet,6);
        Assert.assertEquals(expectedOutput, sixesScore);
    }
}
