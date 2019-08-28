import java.util.Scanner;

public class Player {
    private int[] diceSet;
    private int[] diceHolding;
    private int score;
    private int rolls;
    private Scanner scn = new Scanner(System.in);

    public Player()
    {
        score = 0;
        diceSet = new int[5];
        diceHolding = new int[]{0,0,0,0,0};
    }

    public void takeTurn()
    {
        //while categories aren't depleted
        newTurn();
        while (rolls < 3) {
            selectDiceToHold();
            reRollConsideringHeldDice();
            clearHeldDice();
        }
        readDice();
        pickSelection();
    }

    public void pickSelection()
    {
        if(anySelectionsLeft()) {

            for (scoreSelections selection : scoreSelections.values()) {
                if (selection.getValue() == true)
                    System.out.println(selection);
            }
        }
    }

    public boolean anySelectionsLeft()
    {
        for(scoreSelections selection: scoreSelections.values()) {
            if(selection.getValue() == true)
                return true;
        }
        return false;
    }

    //public

    public void rollDice()
    {
        System.out.println("Rolling Dice!");
        for (int i = 0; i < diceSet.length; i++)
            diceSet[i] = RNG();
        rolls++;
    }

    private void newTurn() {
        rolls = 0;
        rollDice();
    }

    public void selectDiceToHold()
    {
        System.out.println("Which dice would you like to keep?");
        readDice();
        System.out.println("9: Stop");
        int playerSelection;
        boolean playerContinues = true;
        while(playerContinues) {
            playerSelection = scn.nextInt();

            if (playerSelection > 0 && playerSelection < 7)
                holdDice(playerSelection);
            else if (playerSelection == 9) {
                playerContinues = false;
            }
            else
                System.out.println("Please enter a valid selection");
        }
    }

    private void holdDice(int diceNumberInSet)
    {
        int storedValue = diceSet[diceNumberInSet - 1];
        System.out.println("Held dice with value: " + storedValue);
        diceHolding[diceNumberInSet -1] = diceSet[diceNumberInSet -1];
    }

    private void reRollConsideringHeldDice()
    {
        rollDice();
        for (int i = 0; i < diceSet.length; i++) {
            if (diceHolding[i] != 0)
                diceSet[i] = diceHolding[i];
        }

    }

    public void readDice()
    {
        for (int i = 0; i < diceSet.length; i++)
            System.out.println(i+1 + ": " + diceSet[i]);
    }

    private void clearHeldDice()
    {
        for (int i = 0; i < diceHolding.length; i++)
            diceHolding[i] = 0;
    }

    private int RNG()
    {
        return (int) ( (Math.random() * 6) + 1);
    }
}
//
//
//public class ActualOutputMngr implements Output
//{
//    public void print(String message)
//    {
//        System.out.println(message);
//    }
//}
//
//public class TestOutputMngr implements Output
//{
//    public String message;
//    public void print(String message)
//    {
//        message = message;
//    }
//}
//
//public interface Output
//{
//    void print(String message);
//}
//
//public class Test
//{
//    public void testplayer()
//    {
//        Output output = new TestOutputMngr();
//        Player player = new Player(output);
//        player.testMethod()
//                Assert
//    }
//}