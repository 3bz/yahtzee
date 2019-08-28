import org.junit.Assert;
import org.junit.Test;

public class TestUtilityMethods {

    @Test
    public void testGetDice() {
        int[] diceSet = new int[]{1, 2, 3, 4, 5};
        Game testGame = new Game(diceSet);

        int[] result = testGame.getDice();
        Assert.assertEquals(5, result[4]);
    }

    @Test
    public void testContains() {
        int[] diceSet = new int[]{1, 2, 3, 4, 5};
        Game testGame = new Game(diceSet);

        boolean containedInSet = testGame.checkNumberContainedInDiceSet(diceSet, 1);
        Assert.assertEquals(true, containedInSet);
    }

    @Test
    public void testContainsReturnsFalse() {
        int[] diceSet = new int[]{1, 2, 3, 4, 5};
        Game testGame = new Game(diceSet);

        boolean containedInSet = testGame.checkNumberContainedInDiceSet(diceSet, 6);
        Assert.assertEquals(false, containedInSet);
    }
}
