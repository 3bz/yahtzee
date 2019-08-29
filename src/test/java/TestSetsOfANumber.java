import org.junit.Assert;
import org.junit.Test;

public class TestSetsOfANumber {

    @Test
    public void testOnePairScore() {
        int[] diceSet = new int[]{1, 1, 2, 3, 4};
        Game testGame = new Game();
        int expectedOutput = 2;

        int pairScore = testGame.onePairScore(diceSet);
        Assert.assertEquals(expectedOutput, pairScore);
    }

    @Test
    public void testPairDisplacement() {
        int[] diceSet = new int[]{4, 1, 3, 1, 2};
        Game testGame = new Game();
        int expectedOutput = 2;

        int pairScore = testGame.onePairScore(diceSet);
        Assert.assertEquals(expectedOutput, pairScore);
    }

    @Test
    public void testStrongestPair() {
        int[] diceSet = new int[]{1, 2, 3, 1, 2};
        Game testGame = new Game();
        int expectedOutput = 4;

        int pairScore = testGame.onePairScore(diceSet);
        Assert.assertEquals(expectedOutput, pairScore);
    }

    @Test
    public void testLastPair() {
        int[] diceSet = new int[]{1, 2, 3, 4, 4};
        Game testGame = new Game();
        int expectedOutput = 8;

        int pairScore = testGame.onePairScore(diceSet);
        Assert.assertEquals(expectedOutput, pairScore);
    }

    @Test
    public void testTwoPairScore() {
        int[] diceSet = new int[]{1, 3, 3, 4, 4};
        Game testGame = new Game();
        int expectedOutput = 14;

        int twoPairScore = testGame.twoPairScore(diceSet);
        Assert.assertEquals(expectedOutput, twoPairScore);
    }

    @Test
    public void testTwoPairDisplacement() {
        int[] diceSet = new int[]{2, 1, 2, 1, 6};
        Game testGame = new Game();
        int expectedOutput = 6;

        int twoPairScore = testGame.twoPairScore(diceSet);
        Assert.assertEquals(expectedOutput, twoPairScore);
    }

    @Test
    public void testTwoPairZeroReturn() {
        int[] diceSet = new int[]{2, 2, 2, 1, 6};
        Game testGame = new Game();
        int expectedOutput = 0;

        int twoPairScore = testGame.twoPairScore(diceSet);
        Assert.assertEquals(expectedOutput, twoPairScore);
    }

    @Test
    public void testThreeOfAKindScore() {
        int[] diceSet = new int[]{2, 1, 1, 1, 6};
        Game testGame = new Game();
        int expectedOutput = 3;

        int threeOfAKindScore = testGame.threeOfAKindScore(diceSet);
        Assert.assertEquals(expectedOutput, threeOfAKindScore);
    }

    @Test
    public void testThreeOfAKindDisplacement() {
        int[] diceSet = new int[]{2, 1, 2, 1, 2};
        Game testGame = new Game();
        int expectedOutput = 6;

        int threeOfAKindScore = testGame.threeOfAKindScore(diceSet);
        Assert.assertEquals(expectedOutput, threeOfAKindScore);
    }

    @Test
    public void testThreeOfAKindZeroReturn() {
        int[] diceSet = new int[]{2, 1, 3, 1, 2};
        Game testGame = new Game();
        int expectedOutput = 0;

        int threeOfAKindScore = testGame.threeOfAKindScore(diceSet);
        Assert.assertEquals(expectedOutput, threeOfAKindScore);
    }

    @Test
    public void testThreeOfAKindOnlyInLargerSet() {
        int[] diceSet = new int[]{2, 2, 2, 2, 2};
        Game testGame = new Game();
        int expectedOutput = 6;

        int actualScore = testGame.threeOfAKindScore(diceSet);
        Assert.assertEquals(expectedOutput, actualScore);
    }

    @Test
    public void testFourOfAKindScore() {
        int[] diceSet = new int[]{2, 2, 2, 2, 3};
        Game testGame = new Game();
        int expectedOutput = 8;

        int actualScore = testGame.fourOfAKindScore(diceSet);
        Assert.assertEquals(expectedOutput, actualScore);
    }

    @Test
    public void testFourOfAKindDisplacement() {
        int[] diceSet = new int[]{2, 2, 3, 2, 2};
        Game testGame = new Game();
        int expectedOutput = 8;

        int actualScore = testGame.fourOfAKindScore(diceSet);
        Assert.assertEquals(expectedOutput, actualScore);
    }

    @Test
    public void testFourOfAKindZeroReturn() {
        int[] diceSet = new int[]{2, 4, 2, 2, 3};
        Game testGame = new Game();
        int expectedOutput = 0;

        int actualScore = testGame.fourOfAKindScore(diceSet);
        Assert.assertEquals(expectedOutput, actualScore);
    }

    @Test
    public void testYahtzeeScore() {
        int[] diceSet = new int[]{2, 2, 2, 2, 2};
        Game testGame = new Game();
        int expectedOutput = 50;

        int actualScore = testGame.yahtzeeScore(diceSet);
        Assert.assertEquals(expectedOutput, actualScore);
    }

    @Test
    public void testYahtzeeZeroReturn() {
        int[] diceSet = new int[]{2, 2, 2, 2, 1};
        Game testGame = new Game();
        int expectedOutput = 0;

        int actualScore = testGame.yahtzeeScore(diceSet);
        Assert.assertEquals(expectedOutput, actualScore);
    }

    @Test
    public void testFullHouseScore() {
        int[] diceSet = new int[]{1, 1, 1, 2, 2};
        Game testGame = new Game();
        int expectedOutput = 7;

        int actualScore = testGame.fullHouseScore(diceSet);
        Assert.assertEquals(expectedOutput, actualScore);
    }

    @Test
    public void testFullHouseZeroReturnNoPair() {
        int[] diceSet = new int[]{1, 1, 1, 2, 3};
        Game testGame = new Game();
        int expectedOutput = 0;

        int actualScore = testGame.fullHouseScore(diceSet);
        Assert.assertEquals(expectedOutput, actualScore);
    }

    @Test
    public void testFullHouseZeroReturnNoThreeOAK() {
        int[] diceSet = new int[]{1, 1, 2, 2, 3};
        Game testGame = new Game();
        int expectedOutput = 0;

        int actualScore = testGame.fullHouseScore(diceSet);
        Assert.assertEquals(expectedOutput, actualScore);
    }

    @Test
    public void testFullHouseDisplacement() {
        int[] diceSet = new int[]{1, 2, 1, 2, 1};
        Game testGame = new Game();
        int expectedOutput = 7;

        int actualScore = testGame.fullHouseScore(diceSet);
        Assert.assertEquals(expectedOutput, actualScore);
    }
}
