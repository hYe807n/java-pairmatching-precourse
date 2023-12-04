package pairmatching.model;

import static camp.nextstep.edu.missionutils.Randoms.shuffle;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import pairmatching.exception.Validation;

public class Matcher {


    private Map<String, Pairs> pairsResult;

    private final Crews crews;

    public Matcher() {
        crews = new Crews();
        pairsResult = new LinkedHashMap<>();
    }

    public Pairs getPairsByLevel(String level) {
        return pairsResult.get(level);
    }

    public Pairs matchPairs(String level) {
        Validation.checkPairSelect(level);

        List<String> shuffledCrew = shuffle(crewsToString(crews.getCrewsOfCourse(level)));

        pairsResult.put(level, new Pairs(stringToCrews(shuffledCrew)));
        return pairsResult.get(level);
    }

    private List<Crew> stringToCrews(List<String> crewsName){
        return crewsName.stream().map(this.crews::findCrewByName).collect(Collectors.toList());
    }

    private List<String> crewsToString(List<Crew> crews) {
        return crews.stream().map(Crew::getName).collect(Collectors.toList());
    }

    public boolean isDuplicatedLevel(String level) {
        return pairsResult.containsKey(level);
    }
}
