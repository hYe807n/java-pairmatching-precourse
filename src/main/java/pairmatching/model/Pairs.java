package pairmatching.model;

import static camp.nextstep.edu.missionutils.Randoms.shuffle;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Pairs {

    private static final int INDEX_OF_LAST_PAIR = 3;

    private final List<Pair> pairs;

    public Pairs(String level, List<Crew> crews) {
        this.pairs = pairsOfCrews(level, crews);
    }

    public List<Pair> getPairs() {
        return pairs;
    }

    private List<Pair> pairsOfCrews(String level, List<Crew> crews) {
        List<Pair> pairsOfCrews = new ArrayList<>();
        for (int i = 0; i < crews.size() - 1; i += 2) {
            pairsOfCrews.add(new Pair(level, pairOfCrews(crews, i)));
        }
        return pairsOfCrews;
    }

    private List<Crew> pairOfCrews(List<Crew> crews, int index) {
        if (index + INDEX_OF_LAST_PAIR == crews.size()) {
            return Arrays.asList(crews.get(index), crews.get(index + 1), crews.get(index + 2));
        }
        return Arrays.asList(crews.get(index), crews.get(index + 1));
    }

    private List<Crew> exceptSelfInPair(Crew crew) {
        Pair myPair = pairs.stream().filter(pair -> pair.getCrews().contains(crew)).findFirst().get();
        return myPair.getCrews().stream().filter(crews -> !crews.isSameName(crew.getName()))
            .collect(Collectors.toList());
    }
}
