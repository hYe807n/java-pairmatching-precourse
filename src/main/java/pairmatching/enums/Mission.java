package pairmatching.enums;

public enum Mission {
    RACING("자동차경주"),
    LOTTO("로또"),
    BASEBALL("숫자야구게임"),
    BAG("장바구니"),
    PAYMENT("결제"),
    SUBWAY("지하철노선도"),
    DEVELOP("성능개선"),
    PUBLISH("배포");

    private final String name;

    Mission (String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
