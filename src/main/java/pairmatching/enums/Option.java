package pairmatching.enums;

public enum Option {
    MATCHING("1"),
    QUERY("2"),
    INITIALIZE("3"),
    EXIT("Q"),
    REMATCH("네"),
    NO_REMATCH("아니오");

    private final String value;

    Option(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}
