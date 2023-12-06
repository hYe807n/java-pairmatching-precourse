package pairmatching.model;

import java.util.Arrays;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import pairmatching.enums.Course;

class PairTest {

    @DisplayName("레벨1-하연:연하 크루로 이루어진 페어 생성")
    @Test
    void pairOfCrew() {
        Crew crewHaYeon = new Crew(Course.BACKEND, "하연");
        Crew crewYeonHa = new Crew(Course.BACKEND, "연하");
        Pair pair = new Pair("백엔드,레벨1,자동차경주",
            Arrays.asList(crewHaYeon, crewYeonHa));
        Assertions.assertTrue(pair.getCrews().contains(crewHaYeon));
    }
}