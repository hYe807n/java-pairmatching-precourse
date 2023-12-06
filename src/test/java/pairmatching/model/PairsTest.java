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
        Crew crewHaYeon = new Crew(Course.BACKEND, "하연");
        Crew crewYeonHa = new Crew(Course.BACKEND, "연하");
        Pairs pairs = new Pairs("백엔드,레벨1,자동차경주",
            Arrays.asList(crewHaYeon, crewYeonHa));
        Assertions.assertEquals(pairs.getPairs().get(0).getCrews().get(0), crewHaYeon);
    }
}