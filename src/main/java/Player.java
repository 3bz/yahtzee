import java.util.Scanner;

public class Player {
    private int[] diceSet;
    private int score;
    private int rolls;
    private Scanner scn = new Scanner(System.in);

    public Player()
    {
        score = 0;
        rolls = 0;
        diceSet = new int[6];
        rollDice();
    }

    public void rollDice()
    {
        System.out.println("Rolling Dice!");
        for (int i = 0; i < diceSet.length; i++)
            diceSet[i] = RNG();
        rolls++;
    }

    private void newTurn() {
        for (int i = 0; i < diceSet.length; i++) {
            diceSet[i] = i+1;
        }
    }

    public void selectDiceToHold()
    {
        System.out.println("Which dice would you like to keep?");
        readDice();
        System.out.println("9: Stop");
        int playerSelection;
        //boolean playerContinues = true;
        //while(playerContinues) {
            playerSelection = scn.nextInt();
            if (playerSelection > 0 && playerSelection < 7)
                holdDice(playerSelection);
            //else if (playerSelection == 9)
             //   playerContinues = false;
            else
                System.out.println("Please enter a valid selection");
        }
    //}

    private void holdDice(int diceNumberInSet)
    {
        int storedValue = diceSet[diceNumberInSet - 1];
        System.out.println("Held dice with value: " + storedValue);
        rollDice();
        diceSet[diceNumberInSet - 1] = storedValue;
    }

    public void readDice()
    {
        System.out.println("1: " + diceSet[0]);
        System.out.println("2: " + diceSet[1]);
        System.out.println("3: " + diceSet[2]);
        System.out.println("4: " + diceSet[3]);
        System.out.println("5: " + diceSet[4]);
        System.out.println("6: " + diceSet[5]);
    }

    private int RNG()
    {
        return (int) ( (Math.random() * 6) + 1);
    }
}
