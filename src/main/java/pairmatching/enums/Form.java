package pairmatching.enums;

public enum Form {
    MAIN_SELECT("기능을 선택하세요.\n1. 페어 매칭\n2. 페어 조회\n3. 페어 초기화\nQ. 종료"),
    START_ERROR("[ERROR] ");

    private final String message;

    Form (String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
