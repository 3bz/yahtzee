import java.util.Scanner;

public class Player {
    private int[] diceSet;
    private int[] diceHolding;
    private int score;
    private int rolls;
    Game myGame = new Game();
    private Scanner scn = new Scanner(System.in);
    private int MAX_AMOUNT_OF_CATAGORIES = 15;
    private String CATEGORY_USED_MSG = "Category already used for this round.";

    public Player() {
        score = 0;
        diceSet = new int[5];
        diceHolding = new int[]{0, 0, 0, 0, 0};
    }

    public void takeTurn() {
        while (anyScoreCategoriesLeft()) {
            newTurn();
            while (rolls < 3) {
                selectDiceToHold();
                reRollConsideringHeldDice();
                clearHeldDice();
            }
            readDice();
            printScoreCategory();
            selectScoreCategory();
            readScore();
        }
    }

    public void printScoreCategory() {
        for (int i = 0; i < MAX_AMOUNT_OF_CATAGORIES; i++) {
            System.out.print(i + 1 + ": ");
            if (scoreSelections.values()[i].getBoolValue() == true)
                System.out.println(scoreSelections.values()[i]);
            else
                System.out.println(CATEGORY_USED_MSG);
        }
    }

    public void selectScoreCategory() {
        int playerSelection = scn.nextInt();
        while (scoreSelections.values()[playerSelection - 1].getBoolValue() == false) {
            System.out.println("Select a valid category");
            playerSelection = scn.nextInt();
        }
        switch (playerSelection) {
            case (1):
                score += myGame.chanceScore(diceSet);
                break;
            case(2):
                score += myGame.singleNumberCategoryScore(diceSet, 1);
                break;
            case(3):
                score += myGame.singleNumberCategoryScore(diceSet, 2);
                break;
            case(4):
                score += myGame.singleNumberCategoryScore(diceSet, 3);
                break;
            case(5):
                score += myGame.singleNumberCategoryScore(diceSet, 4);
                break;
            case(6):
                score += myGame.singleNumberCategoryScore(diceSet, 5);
                break;
            case(7):
                score += myGame.singleNumberCategoryScore(diceSet, 6);
                break;
            case(8):
                score += myGame.onePairScore(diceSet);
                break;
            case(9):
                score += myGame.twoPairScore(diceSet);
                break;
            case(10):
                score += myGame.smallStraightScore(diceSet);
                break;
            case(11):
                score += myGame.largeStraightScore(diceSet);
                break;
            case(12):
                score += myGame.fullHouseScore(diceSet);
                break;
            case(13):
                score += myGame.threeOfAKindScore(diceSet);
                break;
            case(14):
                score += myGame.fourOfAKindScore(diceSet);
                break;
            case(15):
                score += myGame.yahtzeeScore(diceSet);
                break;
        }
        scoreSelections.values()[playerSelection-1].setBoolValue(false);
    }

    public boolean anyScoreCategoriesLeft() {
        for (scoreSelections selection : scoreSelections.values()) {
            if (selection.getBoolValue() == true)
                return true;
        }
        return false;
    }

    //public

    public void rollDice() {
        System.out.println("Rolling Dice!");
        for (int i = 0; i < diceSet.length; i++)
            diceSet[i] = RNG();
        rolls++;
    }

    private void newTurn() {
        rolls = 0;
        rollDice();
    }

    public void selectDiceToHold() {
        System.out.println("Which dice would you like to keep?");
        readDice();
        System.out.println("9: Stop");
        int playerSelection;
        boolean playerContinues = true;
        while (playerContinues) {
            playerSelection = scn.nextInt();

            if (playerSelection > 0 && playerSelection < 7)
                holdDice(playerSelection);
            else if (playerSelection == 9) {
                playerContinues = false;
            } else
                System.out.println("Please enter a valid selection");
        }
    }

    private void holdDice(int diceNumberInSet) {
        int storedValue = diceSet[diceNumberInSet - 1];
        System.out.println("Held dice with value: " + storedValue);
        diceHolding[diceNumberInSet - 1] = diceSet[diceNumberInSet - 1];
    }

    private void reRollConsideringHeldDice() {
        rollDice();
        for (int i = 0; i < diceSet.length; i++) {
            if (diceHolding[i] != 0)
                diceSet[i] = diceHolding[i];
        }

    }

    public void readDice() {
        for (int i = 0; i < diceSet.length; i++)
            System.out.println(i + 1 + ": " + diceSet[i]);
    }

    private void clearHeldDice() {
        for (int i = 0; i < diceHolding.length; i++)
            diceHolding[i] = 0;
    }

    public void readScore()
    {
        System.out.println("Current Score: " + score);
    }

    private int RNG() {
        return (int) ((Math.random() * 6) + 1);
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