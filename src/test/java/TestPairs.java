import org.junit.Assert;
import org.junit.Test;


public class TestPairs {

    @Test
    public void testOnePair()
    {
        int[] diceSet = new int[]{1,1,2,3,4};

        int expectedOutput = 2;
        Player testPlayer = new Player(diceSet);
        Yahtzee testGame = new Yahtzee(testPlayer);

        int pairScore = testGame.selectOnePair(testPlayer);
        Assert.assertEquals(expectedOutput, pairScore);
    }

    @Test
    public void testPairDisplacement()
    {
        int[] diceSet = new int[]{4,1,3,1,2};

        int expectedOutput = 2;
        Player testPlayer = new Player(diceSet);
        Yahtzee testGame = new Yahtzee(testPlayer);

        int pairScore = testGame.selectOnePair(testPlayer);
        Assert.assertEquals(expectedOutput, pairScore);
    }

    @Test
    public void testStrongestPair()
    {
        int[] diceSet = new int[]{1,2,3,1,2};

        int expectedOutput = 4;
        Player testPlayer = new Player(diceSet);
        Yahtzee testGame = new Yahtzee(testPlayer);

        int pairScore = testGame.selectOnePair(testPlayer);
        Assert.assertEquals(expectedOutput, pairScore);
    }

    @Test
    public void testLastPair()
    {
        int[] diceSet = new int[]{1,2,3,4,4};

        int expectedOutput = 8;
        Player testPlayer = new Player(diceSet);
        Yahtzee testGame = new Yahtzee(testPlayer);

        int pairScore = testGame.selectOnePair(testPlayer);
        Assert.assertEquals(expectedOutput, pairScore);
    }
}
