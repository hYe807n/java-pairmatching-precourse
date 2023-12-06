package pairmatching.model;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class MatcherTest {

    @DisplayName("페어 매칭 결과와, 레벨 명을 통해 저장된 결과 pairs 가 일치")
    @Test
    void matchPairs() {
        Matcher matcher = new Matcher();
        Assertions.assertEquals(matcher.matchPairs("백엔드,레벨1,자동차경주"),
            matcher.getPairsByLevel("백엔드,레벨1,자동차경주"));
    }

    @DisplayName("매칭 이력이 없는 레벨 검색 시, 에러 발생")
    @Test
    void noneMatchPairs() {
        Matcher matcher = new Matcher();
        Assertions.assertThrows(IllegalArgumentException.class,
            () -> matcher.getPairsByLevel("백엔드,레벨1,자동차경주"));
    }

    @DisplayName("매칭 이력이 있는 레벨이라면, true 반환")
    @Test
    void isAlreadyMatched() {
        Matcher matcher = new Matcher();
        matcher.matchPairs("백엔드,레벨1,자동차경주");
        Assertions.assertTrue(matcher.isDuplicatedLevel("백엔드,레벨1,자동차경주"));
    }

    @DisplayName("매칭 이력이 있는 레벨이라면, false 반환")
    @Test
    void isNotMatched() {
        Matcher matcher = new Matcher();
        matcher.matchPairs("백엔드,레벨1,자동차경주");
        Assertions.assertFalse(matcher.isDuplicatedLevel("프론트엔드,레벨1,자동차경주"));
    }
}