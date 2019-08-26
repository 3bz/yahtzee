import org.junit.Assert;
import org.junit.Test;


public class TestPairs {

    @Test
    public void testOnePair()
    {
        int[] diceSet = new int[]{1,1,2,3,4};
        Player testPlayer = new Player(diceSet);
        int expectedOutput = 2;

        int pairScore = testPlayer.selectOnePair();
        Assert.assertEquals(expectedOutput, pairScore);
    }

    @Test
    public void testPairDisplacement()
    {
        int[] diceSet = new int[]{4,1,3,1,2};
        Player testPlayer = new Player(diceSet);
        int expectedOutput = 2;

        int pairScore = testPlayer.selectOnePair();
        Assert.assertEquals(expectedOutput, pairScore);
    }

    @Test
    public void testStrongestPair()
    {
        int[] diceSet = new int[]{1,2,3,1,2};
        Player testPlayer = new Player(diceSet);
        int expectedOutput = 4;

        int pairScore = testPlayer.selectOnePair();
        Assert.assertEquals(expectedOutput, pairScore);
    }

    @Test
    public void testLastPair()
    {
        int[] diceSet = new int[]{1,2,3,4,4};
        Player testPlayer = new Player(diceSet);
        int expectedOutput = 8;

        int pairScore = testPlayer.selectOnePair();
        Assert.assertEquals(expectedOutput, pairScore);
    }
}
