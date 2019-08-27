public class Player {
    private int[] dice = new int[5];

    public Player(int[] aDiceSet) {
        for (int i = 0; i < 5; i++) {
            this.dice[i] = aDiceSet[i];
        }
    }

    public int chanceScore() {
        int result = 0;
        for (int i = 0; i < getDice().length; i++)
            result += getDice()[i];
        return result;
    }

    public int singleNumberCategory(int numberToScore) {
        int result = 0;
        for (int i = 0; i < getDice().length; i++)
            if (getDice()[i] == numberToScore)
                result += getDice()[i];
        return result;
    }

    public int onePairScore() {
        int foundPair = 0;
        int result = 0;
        for (int i = 0; i < getDice().length; i++) {
            if (getDice()[i] != foundPair) {
                int toBeCompared = getDice()[i];
                for (int j = i + 1; j < getDice().length; j++) {
                    if (toBeCompared == getDice()[j]) {
                        foundPair = toBeCompared;
                        result = foundPair * 2;
                        break;
                    }
                }
            }
        }
        if (foundPair * 2 > result)
            return foundPair * 2;
        return result;
    }

    public int twoPairScore() {
        //22216
        int foundPair = 0;
        int result = 0;
        int storedDice;
        for (int i = 0; i < getDice().length; i++) {
            storedDice = getDice()[i];
            if (storedDice != foundPair) {
                for (int j = i + 1; j < getDice().length; j++) {
                    if (storedDice == getDice()[j]) {
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
        return containsSetOfNumber(3);
    }

    public int fourOfAKindScore() {
        return containsSetOfNumber(4);
    }

    public int yahtzeeScore() {
        int diceUsedToCheck;
        int howWeFindYahtzee;
        for (int i = 0; i < getDice().length; i++) {
            diceUsedToCheck = getDice()[i];
            howWeFindYahtzee = 0;
            for (int j = 0; j < getDice().length; j++) {
                if (diceUsedToCheck == getDice()[j]) {
                    howWeFindYahtzee++;
                }
                if (howWeFindYahtzee == 5)
                    return 50;
            }
        }
        return 0;
    }

    public int containsSetOfNumber(int howManyInSet) {
        int diceUsedToCheck;
        int haveWeFoundEnough;
        for (int i = 0; i < getDice().length; i++) {
            diceUsedToCheck = getDice()[i];
            haveWeFoundEnough = 0;
            for (int j = 0; j < getDice().length; j++) {
                if (diceUsedToCheck == getDice()[j]) {
                    haveWeFoundEnough++;
                }
                if (haveWeFoundEnough == howManyInSet)
                    return diceUsedToCheck*howManyInSet;
            }
        }
        return 0;
    }


    public int[] getDice() {
        return dice;
    }
}
