public enum scoreSelections {
    CHANCE_SCORE(true),
    ONES(true),
    TWOS(true),
    THREES(true),
    FOURS(true),
    FIVES(true),
    SIXES(true),
    ONE_PAIR(true),
    TWO_PAIR(true),
    SMALL_STRAIGHT(true),
    LARGE_STRAIGHT(true),
    FULL_HOUSE(true),
    THREE_OF_A_KIND(true),
    FOUR_OF_A_KIND(true),
    YAHTZEE(true);

    private boolean value;
    private int listNumber;

    scoreSelections(boolean value) {this.value = value;}
    public boolean getValue() {return value; }

}
