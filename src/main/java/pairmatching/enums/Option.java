package pairmatching.enums;

public enum Option {
    MATCHING("1"),
    QUERY("2"),
    INITIALIZE("3"),
    EXIT("Q");

    private final String value;

    Option(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}
