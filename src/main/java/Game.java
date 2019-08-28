public class Game {
    private int[] dice = new int[5];
    private static final int INDICATOR_FOR_EMPTY_DIE = 9;

    public Game(int[] aDiceSet) {
        System.arraycopy(aDiceSet, 0, this.dice, 0, 5);
    }

    public int chanceScore() {
        return returnTotal();
    }

    public int singleNumberCategoryScore(int numberToScore) {
        return returnTotal(numberToScore);
    }

    public int onePairScore() {
        int foundPair = findPair();
        removeDiceFromSet(findPair()/2);
        int potentialStrongerPair = findPair();
        return Math.max(foundPair, potentialStrongerPair);
    }

    public int twoPairScore() {
        int firstPair = findPair();
        removeDiceFromSet(firstPair/2);
        int secondPair = findPair();

        if (firstPair > 0 && secondPair > 0)
            return firstPair + secondPair;
        return 0;
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
        int threeOfAKind = threeOfAKindScore();
        removeDiceFromSet(threeOfAKind / 3);
        int onePair = onePairScore();

        if ((onePair > 0) && (threeOfAKind > 0))
            return threeOfAKind + onePair;
        return 0;
    }

    public boolean checkNumberContainedInDiceSet(int[] diceSet, int number) {
        for (int i : diceSet) {
            if (i == number)
                return true;
        }
        return false;
    }

    private int findPair()
    {
        int toBeCompared;
        for (int i = 0; i < dice.length; i++) {
            if (dice[i] != INDICATOR_FOR_EMPTY_DIE) {
                toBeCompared = dice[i];
                for (int j = i + 1; j < dice.length; j++) {
                    if (toBeCompared == dice[j]) {
                        return toBeCompared * 2;
                    }
                }
            }
        }
        return 0;
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
