package pairmatching.model;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import pairmatching.enums.Course;

class CrewTest {

    @DisplayName("백엔드 크루가 백엔드인지 확인하기 위해 비교하는 함수를 통해 true 반환")
    @Test
    void isSameCourse() {
        Crew crew = new Crew(Course.BACKEND, "하연");
        Assertions.assertTrue(crew.isSameCourse(Course.BACKEND));
    }
}