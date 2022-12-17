package by.jekslab.cfr.poker.card;

public enum CardRank {
    TWO(2, "2"),
    THREE(3, "3"),
    FOUR(4, "4"),
    FIVE(5, "5"),
    SIX(6, "6"),
    SEVEN(7, "7"),
    EIGHT(8, "8"),
    NINE(9, "9"),
    TEN(10, "T"),
    JACK(11, "J"),
    QUEEN(12, "Q"),
    KING(13, "K"),
    ACE(14, "A");

    private int intValue;
    private String charValue;

    CardRank(int intValue, String charValue) {
        this.intValue = intValue;
        this.charValue = charValue;
    }

    public int getIntValue() {
        return intValue;
    }

    public String getCharValue() {
        return charValue;
    }
}
