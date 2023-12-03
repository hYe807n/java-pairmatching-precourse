package pairmatching.model;

import static camp.nextstep.edu.missionutils.Randoms.shuffle;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Pairs {

    private static final int INDEX_OF_LAST_PAIR = 3;

    private final List<Pair> pairs;

    public Pairs(List<Crew> crews) {
        this.pairs = pairsOfCrews(crews);
    }

    public List<Pair> getPairs() {
        return pairs;
    }

    private List<Pair> pairsOfCrews(List<Crew> crews) {
        List<Crew> shuffledCrew = shuffle(crews);
        List<Pair> pairsOfCrews = new ArrayList<>();
        for (int i = 0; i < shuffledCrew.size() - 1; i += 2) {
            pairsOfCrews.add(new Pair(pairOfCrews(crews, i)));
        }
        return pairsOfCrews;
    }

    private List<Crew> pairOfCrews(List<Crew> crews, int index) {
        if (index - INDEX_OF_LAST_PAIR == crews.size()) {
            return Arrays.asList(crews.get(index), crews.get(index + 1), crews.get(index + 2));
        }
        return Arrays.asList(crews.get(index), crews.get(index + 1));
    }
}
