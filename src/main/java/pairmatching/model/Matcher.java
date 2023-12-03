package pairmatching.model;

import java.util.Map;
import pairmatching.exception.Validation;

public class Matcher {


    private Map<String, Pairs> pairsResult;

    private final Crews crews;

    public Matcher() {
        crews = new Crews();
    }

    public Pairs getPairsByLevel(String level) {
        return pairsResult.get(level);
    }

    public void matchPairs(String level) {
        Validation.checkPairSelect(level);
        pairsResult.put(level, new Pairs(crews.getCrewsOfCourse(level)));
    }

    public boolean isDuplicatedLevel(String level) {
        return pairsResult.containsKey(level);
    }
}
