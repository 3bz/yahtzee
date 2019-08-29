public class Game {
    private int[] dice = new int[5];
    private static final int INDICATOR_FOR_EMPTY_DIE = 9;

    public Game(int[] aDiceSet) {
        System.arraycopy(aDiceSet, 0, this.dice, 0, 5);
    }

    public Game(){}

    public int chanceScore(int[] diceSet) {
        return returnTotal(diceSet);
    }

    public int singleNumberCategoryScore(int[] diceSet, int numberToScore) {
        return returnTotal(diceSet, numberToScore);
    }

    public int onePairScore(int[] diceSet) {
        int foundPair = findPair(diceSet);
        diceSet = removeDiceFromSet(diceSet, findPair(diceSet)/2);
        int potentialStrongerPair = findPair(diceSet);
        return Math.max(foundPair, potentialStrongerPair);
    }

    public int twoPairScore(int[] diceSet) {
        int firstPair = findPair(diceSet);
        removeDiceFromSet(diceSet, firstPair/2);
        int secondPair = findPair(diceSet);

        if (firstPair > 0 && secondPair > 0)
            return firstPair + secondPair;
        return 0;
    }

    public int threeOfAKindScore(int[] diceSet) {
        return returnSetOfNumber(diceSet, 3);
    }

    public int fourOfAKindScore(int[] diceSet) {
        return returnSetOfNumber(diceSet, 4);
    }

    public int yahtzeeScore(int[] diceSet) {
        return returnSetOfNumber(diceSet, 5);
    }

    public int smallStraightScore(int[] diceSet) {
        if (checkNumberContainedInDiceSet(diceSet, 1) &&
                checkNumberContainedInDiceSet(diceSet, 2) &&
                checkNumberContainedInDiceSet(diceSet, 3) &&
                checkNumberContainedInDiceSet(diceSet, 4) &&
                checkNumberContainedInDiceSet(diceSet, 5))
            return 15;
        return 0;
    }

    public int largeStraightScore(int[] diceSet) {
        if (checkNumberContainedInDiceSet(diceSet, 2) &&
                checkNumberContainedInDiceSet(diceSet, 3) &&
                checkNumberContainedInDiceSet(diceSet, 4) &&
                checkNumberContainedInDiceSet(diceSet, 5) &&
                checkNumberContainedInDiceSet(diceSet, 6))
            return 20;
        return 0;
    }

    public int fullHouseScore(int[] diceSet) {
        int threeOfAKind = threeOfAKindScore(diceSet);
        removeDiceFromSet(diceSet, threeOfAKind / 3);
        int onePair = onePairScore(diceSet);

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

    private int findPair(int[] diceSet)
    {
        int toBeCompared;
        for (int i = 0; i < diceSet.length; i++) {
            if (diceSet[i] != INDICATOR_FOR_EMPTY_DIE) {
                toBeCompared = diceSet[i];
                for (int j = i + 1; j < diceSet.length; j++) {
                    if (toBeCompared == diceSet[j]) {
                        return toBeCompared * 2;
                    }
                }
            }
        }
        return 0;
    }

    private int[] removeDiceFromSet(int[] diceSet, int numToRemove) {
        for (int i = 0; i < diceSet.length; i++) {
            if (diceSet[i] == numToRemove)
                diceSet[i] = INDICATOR_FOR_EMPTY_DIE;
        }
        return diceSet;
        //dice = Arrays.stream(dice).filter(x -> x != numToRemove).toArray();
    }

    private int returnTotal(int[] diceSet, int numberToScore)
    {
        int result = 0;
        for (int die : diceSet) {
            if (die == numberToScore)
                result += die;
        }
        return result;
    }

    private int returnTotal(int[] diceSet)
    {
        int result = 0;
        for (int die : diceSet)
            result += die;
        return result;
    }

    private int returnSetOfNumber(int[] diceSet, int howManyInSet) {
        int diceUsedToCheck;
        int haveWeFoundEnough;
        for (int i = 0; i < diceSet.length; i++) {
            diceUsedToCheck = diceSet[i];
            haveWeFoundEnough = 0;
            for (int j = 0; j < diceSet.length; j++) {
                if ((diceUsedToCheck == diceSet[j]) && (diceUsedToCheck != INDICATOR_FOR_EMPTY_DIE)) {
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
