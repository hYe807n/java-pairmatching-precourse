package pairmatching.model;

import java.util.Arrays;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import pairmatching.enums.Course;

class PairsTest {

    @DisplayName("pairs 가 담은 pair 에 \"하연\"crew 를 담음")
    @Test
    void pairsOfPair() {
        Crew crewHaYeon = new Crew(Course.BACKEND, "A");
        Crew crewYeonHa = new Crew(Course.BACKEND, "B");
        Pairs pairs = new Pairs("백엔드,레벨1,자동차경주",
            Arrays.asList(crewHaYeon, crewYeonHa));
        Assertions.assertEquals(pairs.getPairs().get(0).getCrews().get(0), crewHaYeon);
    }

    @DisplayName("페어가 홀수라면 마지막 페어가 3 명으로 구성")
    @Test
    void pairsByOddNumber() {
        Crew crewA = new Crew(Course.BACKEND, "A");
        Crew crewB = new Crew(Course.BACKEND, "B");
        Crew crewC = new Crew(Course.BACKEND, "C");
        Pairs pairs = new Pairs("백엔드,레벨1,자동차경주",
            Arrays.asList(crewA, crewB, crewC));
        Assertions.assertEquals(pairs.getPairs().get(0).getCrews(), Arrays.asList(crewA, crewB, crewC));
    }
}