package pairmatching.exception;

import java.util.Arrays;
import java.util.Collections;
import java.util.stream.Stream;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import pairmatching.enums.Course;
import pairmatching.enums.Level;
import pairmatching.model.Crew;

class ValidationTest {

    private static Stream<Arguments> exceptWrongForm() {
        return Stream.of(
            Arguments.arguments("코스", "안드로이드,레벨1,자동차경주"),
            Arguments.arguments("레벨", "백엔드,레벨10,자동차경주"),
            Arguments.arguments("미션", "백엔드,레벨1,짝페어매칭")
        );
    }

    @DisplayName("같은 레벨에서 페어였던 크루와 다시 페어가 됐다면 예외 발생")
    @Test
    void validateDuplicatedPair() {
        Crew crew1 = new Crew(Course.BACKEND, "A");
        Crew crew2 = new Crew(Course.BACKEND, "B");
        crew1.addPreviousPair(Level.LEVEL1, Collections.singletonList(crew2));
        crew2.addPreviousPair(Level.LEVEL1, Collections.singletonList(crew1));
        Assertions.assertThrows(IllegalArgumentException.class, () ->
            Validation.checkPairs(Level.LEVEL1, Arrays.asList(crew1, crew2)));
    }

    @DisplayName("재매치 시도 횟수가 3 번 이상이라면 예외 발생")
    @Test
    void validateRetryCount() {
        Assertions.assertThrows(IllegalArgumentException.class, () ->
            Validation.checkRetryCount(3));
    }

    @ParameterizedTest(name = "코스,레벨,미션 양식에서 {0}가 존재하지 않는다면 예외 발생")
    @MethodSource("exceptWrongForm")
    void validatePairSelectWrongForm(String error, String level) {
        Assertions.assertThrows(IllegalArgumentException.class, () ->
            Validation.checkPairSelect(level));
    }
}