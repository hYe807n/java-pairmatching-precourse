package pairmatching.model;

import java.util.stream.Stream;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import pairmatching.enums.Course;

class CrewTest {

    private static Stream<Arguments> compareCourse() {
        return Stream.of(
            Arguments.arguments(Course.BACKEND, "백엔드", true),
            Arguments.arguments(Course.FRONTEND, "프론트엔드", false)
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
}