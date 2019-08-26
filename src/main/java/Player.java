public class Player {
    private int[] dice = new int[5];

    public Player(int[] aDiceSet)
    {
        for (int  i = 0; i < 5; i++)
        {
            this.dice[i] = aDiceSet[i];
        }
    }

    public int selectChance()
    {
        int result = 0;
        for (int i = 0; i < getDice().length; i++)
            result += getDice()[i];
        return result;
    }

    public int singleNumberCategory(int numberToScore)
    {
        int result = 0;
        for (int i = 0; i< getDice().length; i++)
            if (getDice()[i] == numberToScore)
                result += getDice()[i];
        return result;
    }

    public int selectOnePair()
    {
        int foundPair = 0;
        int result = 0;
        for (int i = 0; i < getDice().length; i++)
        {
            if (getDice()[i] != foundPair) {
                int toBeCompared = getDice()[i];
                for (int j = i+1; j < getDice().length; j++) {
                    if (toBeCompared == getDice()[j]) {
                        foundPair = toBeCompared;
                        result = foundPair*2;
                        break;
                    }
                }
            }
        }
        if (foundPair*2 > result)
            return foundPair*2;
        return result;
    }

    public int[] getDice() {
        return dice;
    }
}
