package pairmatching.model;

import java.util.stream.Stream;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import pairmatching.enums.Course;

class CrewsTest {

    private static Stream<Arguments> crewsByLevel() {
        return Stream.of(
            Arguments.arguments("백엔드", "백엔드,레벨1,자동차경주", Course.BACKEND),
            Arguments.arguments("프론트엔드", "프론트엔드,레벨1,자동차경주", Course.FRONTEND)
        );
    }

    @ParameterizedTest(name = "Crew 들 중에서 {0} crew list 만 반환")
    @MethodSource("crewsByLevel")
    void findCrewsByLevel(String level, String fullLevel, Course course) {
        Crews crews = new Crews();
        Assertions.assertTrue(crews.getCrewsOfCourse(fullLevel).stream()
            .allMatch(crew -> crew.isSameCourse(course)));
    }

    @DisplayName("crews 들 중 \"백호\" crew 이름을 통해 crew 객체 반환")
    @Test
    void findCrewByName() {
        Crews crews = new Crews();
        Assertions.assertEquals(crews.findCrewByName("백호").getName(), "백호");
    }
}