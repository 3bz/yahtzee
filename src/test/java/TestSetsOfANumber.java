import org.junit.Assert;
import org.junit.Test;

public class TestSetsOfANumber {

    @Test
    public void testOnePairScore() {
        int[] diceSet = new int[]{1, 1, 2, 3, 4};
        Player testPlayer = new Player(diceSet);
        int expectedOutput = 2;

        int pairScore = testPlayer.onePairScore();
        Assert.assertEquals(expectedOutput, pairScore);
    }

    @Test
    public void testPairDisplacement() {
        int[] diceSet = new int[]{4, 1, 3, 1, 2};
        Player testPlayer = new Player(diceSet);
        int expectedOutput = 2;

        int pairScore = testPlayer.onePairScore();
        Assert.assertEquals(expectedOutput, pairScore);
    }

    @Test
    public void testStrongestPair() {
        int[] diceSet = new int[]{1, 2, 3, 1, 2};
        Player testPlayer = new Player(diceSet);
        int expectedOutput = 4;

        int pairScore = testPlayer.onePairScore();
        Assert.assertEquals(expectedOutput, pairScore);
    }

    @Test
    public void testLastPair() {
        int[] diceSet = new int[]{1, 2, 3, 4, 4};
        Player testPlayer = new Player(diceSet);
        int expectedOutput = 8;

        int pairScore = testPlayer.onePairScore();
        Assert.assertEquals(expectedOutput, pairScore);
    }

    @Test
    public void testTwoPairScore() {
        int[] diceSet = new int[]{1, 3, 3, 4, 4};
        Player testPlayer = new Player(diceSet);
        int expectedOutput = 14;

        int twoPairScore = testPlayer.twoPairScore();
        Assert.assertEquals(expectedOutput, twoPairScore);
    }

    @Test
    public void testTwoPairSpacing() {
        int[] diceSet = new int[]{2, 1, 2, 1, 6};
        Player testPlayer = new Player(diceSet);
        int expectedOutput = 6;

        int twoPairScore = testPlayer.twoPairScore();
        Assert.assertEquals(expectedOutput, twoPairScore);
    }

    @Test
    public void testTwoPairZeroReturn() {
        int[] diceSet = new int[]{2, 2, 2, 1, 6};
        Player testPlayer = new Player(diceSet);
        int expectedOutput = 0;

        int twoPairScore = testPlayer.twoPairScore();
        Assert.assertEquals(expectedOutput, twoPairScore);
    }

    @Test
    public void testThreeOfAKindScore() {
        int[] diceSet = new int[]{2, 1, 1, 1, 6};
        Player testPlayer = new Player(diceSet);
        int expectedOutput = 3;

        int threeOfAKindScore = testPlayer.threeOfAKindScore();
        Assert.assertEquals(expectedOutput, threeOfAKindScore);
    }

    @Test
    public void testThreeOfAKindSpacing() {
        int[] diceSet = new int[]{2, 1, 2, 1, 2};
        Player testPlayer = new Player(diceSet);
        int expectedOutput = 6;

        int threeOfAKindScore = testPlayer.threeOfAKindScore();
        Assert.assertEquals(expectedOutput, threeOfAKindScore);
    }

    @Test
    public void testThreeOfAKindZeroReturn() {
        int[] diceSet = new int[]{2, 1, 3, 1, 2};
        Player testPlayer = new Player(diceSet);
        int expectedOutput = 0;

        int threeOfAKindScore = testPlayer.threeOfAKindScore();
        Assert.assertEquals(expectedOutput, threeOfAKindScore);
    }

    @Test
    public void testThreeOfAKindScoreOnly() {
        int[] diceSet = new int[]{2, 2, 2, 2, 2};
        Player testPlayer = new Player(diceSet);
        int expectedOutput = 6;

        int actualScore = testPlayer.threeOfAKindScore();
        Assert.assertEquals(expectedOutput, actualScore);
    }

    @Test
    public void testFourOfAKindScore() {
        int[] diceSet = new int[]{2, 2, 2, 2, 3};
        Player testPlayer = new Player(diceSet);
        int expectedOutput = 8;

        int actualScore = testPlayer.fourOfAKindScore();
        Assert.assertEquals(expectedOutput, actualScore);
    }

    @Test
    public void testFourOfAKindSpacedSet() {
        int[] diceSet = new int[]{2, 2, 3, 2, 2};
        Player testPlayer = new Player(diceSet);
        int expectedOutput = 8;

        int actualScore = testPlayer.fourOfAKindScore();
        Assert.assertEquals(expectedOutput, actualScore);
    }

    @Test
    public void testFourOfAKindZeroReturn() {
        int[] diceSet = new int[]{2, 4, 2, 2, 3};
        Player testPlayer = new Player(diceSet);
        int expectedOutput = 0;

        int actualScore = testPlayer.fourOfAKindScore();
        Assert.assertEquals(expectedOutput, actualScore);
    }

    @Test
    public void testYahtzeeScore() {
        int[] diceSet = new int[]{2, 2, 2, 2, 2};
        Player testPlayer = new Player(diceSet);
        int expectedOutput = 50;

        int actualScore = testPlayer.yahtzeeScore();
        Assert.assertEquals(expectedOutput, actualScore);
    }

    @Test
    public void testYahtzeeZeroReturn() {
        int[] diceSet = new int[]{2, 2, 2, 2, 1};
        Player testPlayer = new Player(diceSet);
        int expectedOutput = 0;

        int actualScore = testPlayer.yahtzeeScore();
        Assert.assertEquals(expectedOutput, actualScore);
    }

    @Test
    public void testFullHouseScore() {
        int[] diceSet = new int[]{1, 1, 1, 2, 2};
        Player testPlayer = new Player(diceSet);
        int expectedOutput = 7;

        int actualScore = testPlayer.fullHouseScore();
        Assert.assertEquals(expectedOutput, actualScore);
    }
}
