package pairmatching.exception;

import java.util.Arrays;
import java.util.List;
import pairmatching.enums.Course;
import pairmatching.enums.Level;
import pairmatching.enums.Mission;
import pairmatching.enums.Option;

public class Validation {

    private static final int INDEX_COURSE = 0;
    private static final int INDEX_LEVEL = 1;
    private static final int INDEX_MISSION = 2;


    public static void checkOption(String userAnswer) {
        if (Arrays.stream(Option.values()).noneMatch(
            option -> option.getValue().equals(userAnswer))) {
            throw new IllegalArgumentException("1, 2, 3, Q 중에 입력해주세요.");
        }
    }

    public static void checkPairSelect(String inform) {
        List<String> userAnswer = Arrays.asList((inform.split(",")));
        checkCourse(userAnswer.get(INDEX_COURSE));
        checkLevel(userAnswer.get(INDEX_LEVEL));
        checkMission(userAnswer.get(INDEX_MISSION));
    }

    private static void checkCourse(String userAnswer) {
        if (Arrays.stream(Course.values()).noneMatch(
            course -> course.getName().equals(userAnswer))) {
            throw new IllegalArgumentException("존재하지 않는 과정입니다.");
        }
    }

    private static void checkLevel(String userAnswer) {
        if (Arrays.stream(Level.values()).noneMatch(
            course -> course.getName().equals(userAnswer))) {
            throw new IllegalArgumentException("존재하지 않는 레벨입니다.");
        }
    }

    private static void checkMission(String userAnswer) {
        if (Arrays.stream(Mission.values()).noneMatch(
            course -> course.getName().equals(userAnswer))) {
            throw new IllegalArgumentException("존재하지 않는 미션입니다.");
        }
    }
}
