package pairmatching.model;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Stream;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import pairmatching.enums.Course;
import pairmatching.enums.Level;

class CrewTest {

    private static Stream<Arguments> compareCourse() {
        return Stream.of(
            Arguments.arguments(Course.BACKEND, "백엔드", true),
            Arguments.arguments(Course.FRONTEND, "프론트엔드", false)
        );
    }

    private static Stream<Arguments> compareName() {
        return Stream.of(
            Arguments.arguments("하연", true, ""),
            Arguments.arguments("연하", false, "불")
        );
    }

    private static Stream<Arguments> comparePreviousPair() {
        Crew crew1 = new Crew(Course.BACKEND, "연하");
        Crew crew2 = new Crew(Course.BACKEND, "하영");
        return Stream.of(
            Arguments.arguments(Level.LEVEL1, Arrays.asList(crew1, crew2),
                Collections.singletonList(crew1), "", true),
            Arguments.arguments(Level.LEVEL1, Arrays.asList(crew1, crew2),
                Collections.singletonList(new Crew(Course.BACKEND, "영영")), "안", false)
        );
    }

    public static Crew initializeCrew() {
        return new Crew(Course.BACKEND, "하연");
    }

    @ParameterizedTest(name = "백엔드 크루가 {1}인지 확인하기 위해 비교하는 함수를 통해 {2} 반환")
    @MethodSource("compareCourse")
    void isSameCourse(Course course, String courseName, boolean value) {
        Assertions.assertEquals(initializeCrew().isSameCourse(course), value);
    }

    @ParameterizedTest(name = "{0} 크루와 이름이 {2}일치하면 {1} 반환")
    @MethodSource("compareName")
    void isSameName(String name, boolean value, String result) {
        Assertions.assertEquals(initializeCrew().isSameName(name), value);
    }

    @ParameterizedTest(name = "이전에 페어로 {3} 만난 페어라면, {4} 반환")
    @MethodSource("comparePreviousPair")
    void isPreviousPair(Level level, List<Crew> crews, List<Crew> crew, String result, boolean value) {
        Crew myCrew = initializeCrew();
        myCrew.addPreviousPair(level, crews);
        Assertions.assertEquals(myCrew.isPreviousPair(level, crew), value);
    }
}