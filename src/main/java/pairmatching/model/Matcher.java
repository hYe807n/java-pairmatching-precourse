package pairmatching.model;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import pairmatching.exception.Validation;

public class Matcher {


    private static final Map<String, List<Pairs>> pairsResult = new LinkedHashMap<>();

    private final Crews crews;

    public Matcher() {
        crews = new Crews();
    }
    public void matchPairs(String level) {
        Validation.checkPairSelect(level);
        crews.getCrewsOfCourse(level);

    }

}
