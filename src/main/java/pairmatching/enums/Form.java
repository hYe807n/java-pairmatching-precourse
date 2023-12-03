package pairmatching.enums;

public enum Form {
    MAIN_SELECT("\n기능을 선택하세요.\n1. 페어 매칭\n2. 페어 조회\n3. 페어 초기화\nQ. 종료"),
    START_ERROR("[ERROR] "),
    REMATCH("\n매칭 정보가 있습니다. 다시 매칭하시겠습니까?\n네 | 아니오"),
    INFORM("#############################################\n"
        + "과정: 백엔드 | 프론트엔드\n"
        + "미션:\n"
        + "  - 레벨1: 자동차경주 | 로또 | 숫자야구게임\n"
        + "  - 레벨2: 장바구니 | 결제 | 지하철노선도\n"
        + "  - 레벨3: \n"
        + "  - 레벨4: 성능개선 | 배포\n"
        + "  - 레벨5: \n"
        + "############################################\n"
        + "과정, 레벨, 미션을 선택하세요.\n"
        + "ex) 백엔드, 레벨1, 자동차경주");

    private final String message;

    Form (String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
