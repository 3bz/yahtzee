public class Player {
    private int[] dice = new int[5];

    public Player(int[] aDiceSet)
    {
        for (int  i = 0; i < 5; i++)
        {
            this.dice[i] = aDiceSet[i];
        }
    }

    public int getOneDie(int d) {
        return dice[d];
    }

    public int[] getDice() {
        return dice;
    }
}
