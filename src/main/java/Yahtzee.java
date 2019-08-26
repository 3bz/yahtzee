public class Yahtzee {
    private Player myPlayer;

    public Yahtzee(Player aPlayer)
    {
        myPlayer = aPlayer;
    }

    public int selectChance(Player aPlayer)
    {
        int result = 0;
        for (int i = 0; i < aPlayer.getDice().length; i++)
            result += aPlayer.getOneDie(i);
        return result;
    }

    public int singleNumberCategory(int numberToScore, Player aPlayer)
    {
        int result = 0;
        for (int i = 0; i< aPlayer.getDice().length; i++)
            if (aPlayer.getOneDie(i) == numberToScore)
                result += aPlayer.getOneDie(i);
        return result;
    }

    public int selectOnePair(Player aPlayer)
    {
        int foundPair = 0;
        int result = 0;
        for (int i = 0; i < aPlayer.getDice().length; i++)
        {
            if (aPlayer.getDice()[i] != foundPair) {
                int toBeCompared = aPlayer.getDice()[i];
                for (int j = i+1; j < aPlayer.getDice().length; j++) {
                    if (toBeCompared == aPlayer.getDice()[j]) {
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
}
