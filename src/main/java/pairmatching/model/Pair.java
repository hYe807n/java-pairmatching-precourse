package pairmatching.model;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import pairmatching.enums.Level;
import pairmatching.exception.Validation;

public class Pair {

    private static final int INDEX_OF_LEVEL = 1;

    private final List<Crew> crews;

    public Pair(String level, List<Crew> crews) {
        String levelValue = level.split(",")[INDEX_OF_LEVEL];
        Level crewLevel = Arrays.stream(Level.values()).filter(levels -> levels.getName().equals(levelValue))
            .findFirst().get();
        Validation.checkPairs(crewLevel, crews);
        addPreviousPair(crewLevel, crews);
        this.crews = crews;
    }

    private void addPreviousPair(Level crewLevel, List<Crew> crews) {
        crews.forEach(myCrew ->
            myCrew.addPreviousPair(crewLevel, crews.stream().filter(
                crew -> !crew.isSameName(myCrew.getName())).collect(Collectors.toList())));
    }

    public List<Crew> getCrews() {
        return crews;
    }
}
