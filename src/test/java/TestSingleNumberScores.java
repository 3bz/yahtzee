import org.junit.Assert;
import org.junit.Test;

public class TestSingleNumberScores {
    public int[] diceSet = new int[]{1,2,3,4,5};
    public Player testPlayer = new Player(diceSet);

    @Test
    public void testChanceScore()
    {
        int expectedOutput = 15;

        int chanceScore = testPlayer.chanceScore();
        Assert.assertEquals(expectedOutput, chanceScore);
    }

    @Test
    public void testOnesScore()
    {
        int expectedOutput = 1;

        int onesScore = testPlayer.singleNumberCategoryScore(1);
        Assert.assertEquals(expectedOutput, onesScore);
    }

    @Test
    public void testTwosScore()
    {
        int expectedOutput = 2;

        int twosScore = testPlayer.singleNumberCategoryScore(2);
        Assert.assertEquals(expectedOutput, twosScore);
    }

    @Test
    public void testThreesScore()
    {
        int expectedOutput = 3;

        int threesScore = testPlayer.singleNumberCategoryScore(3);
        Assert.assertEquals(expectedOutput, threesScore);
    }

    @Test
    public void testFoursScore()
    {
        int expectedOutput = 4;

        int foursScore = testPlayer.singleNumberCategoryScore(4);
        Assert.assertEquals(expectedOutput, foursScore);
    }

    @Test
    public void testFivesScore()
    {
        int expectedOutput = 5;

        int fivesScore = testPlayer.singleNumberCategoryScore(5);
        Assert.assertEquals(expectedOutput, fivesScore);
    }

    @Test
    public void testSixesScore()
    {
        int expectedOutput = 0;

        int sixesScore = testPlayer.singleNumberCategoryScore(6);
        Assert.assertEquals(expectedOutput, sixesScore);
    }
}
