package pairmatching.exception;

import java.util.Arrays;
import pairmatching.enums.Option;

public class Validation {

    public static void checkOption(String userAnswer) {
        if (Arrays.stream(Option.values()).noneMatch(
            option -> option.getValue().equals(userAnswer))) {
            throw new IllegalArgumentException("1, 2, 3, Q 중에 입력해주세요.");
        }
    }
}
