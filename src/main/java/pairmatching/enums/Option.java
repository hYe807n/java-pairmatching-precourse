package pairmatching.enums;

public enum Option {
    MATCHING(1),
    QUERY(2),
    INITIALIZE(3),
    EXIT(4);

    private final int value;

    Option(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }
}
