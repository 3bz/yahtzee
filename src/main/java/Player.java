public class Player {
    private int[] dice = new int[5];
    private static final int INDICATOR_FOR_EMPTY_DIE = 9;

    public Player(int[] aDiceSet) {
        System.arraycopy(aDiceSet, 0, this.dice, 0, 5);
    }

    public int chanceScore() {
        return returnTotal();
    }

    public int singleNumberCategoryScore(int numberToScore) {
        return returnTotal(numberToScore);
    }

    public int onePairScore() {
        int foundPair = 0;
        int result = 0;
        for (int i = 0; i < dice.length; i++) {
            if (dice[i] != foundPair) {
                int toBeCompared = dice[i];
                for (int j = i + 1; j < dice.length; j++) {
                    if (toBeCompared == dice[j]) {
                        foundPair = toBeCompared;
                        result = foundPair * 2;
                        break;
                    }
                }
            }
        }
        return Math.max(foundPair * 2, result);
    }

    public int twoPairScore() {
        //22216
        int foundPair = 0;
        int result = 0;
        int storedDice;
        for (int i = 0; i < dice.length; i++) {
            storedDice = dice[i];
            if (storedDice != foundPair) {
                for (int j = i + 1; j < dice.length; j++) {
                    if (storedDice == dice[j]) {
                        if (foundPair == 0) {
                            foundPair = storedDice;
                            break;
                        } else
                            result = foundPair * 2 + storedDice * 2;
                    }
                }
            }
        }
        return result;
    }

    public int threeOfAKindScore() {
        return returnSetOfNumber(3);
    }

    public int fourOfAKindScore() {
        return returnSetOfNumber(4);
    }

    public int yahtzeeScore() {
        return returnSetOfNumber(5);
    }

    public int smallStraightScore() {
        if (checkNumberContainedInDiceSet(dice, 1) &&
                checkNumberContainedInDiceSet(dice, 2) &&
                checkNumberContainedInDiceSet(dice, 3) &&
                checkNumberContainedInDiceSet(dice, 4) &&
                checkNumberContainedInDiceSet(dice, 5))
            return 15;
        return 0;
    }

    public int largeStraightScore() {
        if (checkNumberContainedInDiceSet(dice, 2) &&
                checkNumberContainedInDiceSet(dice, 3) &&
                checkNumberContainedInDiceSet(dice, 4) &&
                checkNumberContainedInDiceSet(dice, 5) &&
                checkNumberContainedInDiceSet(dice, 6))
            return 20;
        return 0;
    }

    public int fullHouseScore() {
        int threeOAK = returnSetOfNumber(3) / 3;
        removeDiceFromSet(threeOAK);
        int twoOAK = returnSetOfNumber(2);

        if ((twoOAK != 0) && (threeOAK != 0))
            return (threeOAK * 3) + twoOAK;
        return 0;
    }

    public boolean checkNumberContainedInDiceSet(int[] diceSet, int number) {
        for (int i : diceSet) {
            if (i == number)
                return true;
        }
        return false;
    }

    private void removeDiceFromSet(int numToRemove) {
        for (int i = 0; i < dice.length; i++) {
            if (dice[i] == numToRemove)
                dice[i] = INDICATOR_FOR_EMPTY_DIE;
        }
        //dice = Arrays.stream(dice).filter(x -> x != numToRemove).toArray();
    }

    private int returnTotal(int numberToScore)
    {
        int result = 0;
        for (int die : dice) {
            if (die == numberToScore)
                result += die;
        }
        return result;
    }

    private int returnTotal()
    {
        int result = 0;
        for (int die : dice)
            result += die;
        return result;
    }

    private int returnSetOfNumber(int howManyInSet) {
        int diceUsedToCheck;
        int haveWeFoundEnough;
        for (int i = 0; i < dice.length; i++) {
            diceUsedToCheck = dice[i];
            haveWeFoundEnough = 0;
            for (int j = 0; j < dice.length; j++) {
                if ((diceUsedToCheck == dice[j]) && (diceUsedToCheck != INDICATOR_FOR_EMPTY_DIE)) {
                    haveWeFoundEnough++;
                }
                if (haveWeFoundEnough == howManyInSet && howManyInSet == 5)
                    return 50;
                if (haveWeFoundEnough == howManyInSet)
                    return diceUsedToCheck * howManyInSet;
            }
        }
        return 0;
    }

    public int[] getDice() {
        return dice;
    }

}
