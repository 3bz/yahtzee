import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import java.util.Arrays;
import java.util.Collection;

@RunWith(Parameterized.class)
public class TestYahtzee {

    @Parameterized.Parameters()
    public static Collection<Object[]> testData()
    {
        return Arrays.asList(new Object[][]
                {
                        {new int[]{1,2,3,4,5}}
                });
    }

    @Parameterized.Parameter
    public int[] diceSet;

    @Before
    public void createObjects()
    {
        Player testPlayer = new Player(diceSet);
        Yahtzee testGame = new Yahtzee(testPlayer);
    }

    @Test
    public void testChance()
    {
        int expectedOutput = 15;
        Player testPlayer = new Player(diceSet);
        Yahtzee testGame = new Yahtzee(testPlayer);

        int chanceScore = testGame.selectChance(testPlayer);
        Assert.assertEquals(expectedOutput, chanceScore);
    }

    @Test
    public void testScoreOnes()
    {
        int expectedOutput = 1;
        Player testPlayer = new Player(diceSet);
        Yahtzee testGame = new Yahtzee(testPlayer);
        int onesScore = testGame.singleNumberCategory(1, testPlayer);
        Assert.assertEquals(expectedOutput, onesScore);
    }

    @Test
    public void testScoreTwos()
    {
        int expectedOutput = 2;
        Player testPlayer = new Player(diceSet);
        Yahtzee testGame = new Yahtzee(testPlayer);

        int twosScore = testGame.singleNumberCategory(2, testPlayer);
        Assert.assertEquals(expectedOutput, twosScore);
    }

    @Test
    public void testScoreThrees()
    {
        int expectedOutput = 3;
        Player testPlayer = new Player(diceSet);
        Yahtzee testGame = new Yahtzee(testPlayer);

        int threesScore = testGame.singleNumberCategory(3, testPlayer);
        Assert.assertEquals(expectedOutput, threesScore);
    }

    @Test
    public void testScoreFours()
    {
        int expectedOutput = 4;
        Player testPlayer = new Player(diceSet);
        Yahtzee testGame = new Yahtzee(testPlayer);

        int foursScore = testGame.singleNumberCategory(4, testPlayer);
        Assert.assertEquals(expectedOutput, foursScore);
    }

    @Test
    public void testScoreFives()
    {
        int expectedOutput = 5;
        Player testPlayer = new Player(diceSet);
        Yahtzee testGame = new Yahtzee(testPlayer);

        int fivesScore = testGame.singleNumberCategory(5, testPlayer);
        Assert.assertEquals(expectedOutput, fivesScore);
    }

    @Test
    public void testScoreSixes()
    {
        int expectedOutput = 0;
        Player testPlayer = new Player(diceSet);
        Yahtzee testGame = new Yahtzee(testPlayer);

        int sixesScore = testGame.singleNumberCategory(6, testPlayer);
        Assert.assertEquals(expectedOutput, sixesScore);
    }
}
