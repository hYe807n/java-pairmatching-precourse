package pairmatching.model;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Pairs {
    private final List<Pair> pairs;

    public Pairs(List<Crew> crews) {
        this.pairs = splitPairs(crews);
    }

    private List<Pair> splitPairs(List<Crew> crews) {
        List<Pair> pair = new ArrayList<>();
        for (int i = 0; i < crews.size(); i += 2) {
            if (isOddSize(crews) && i + 2 == crews.size()) {
                pair.add(new Pair(Arrays.asList(crews.get(i), crews.get(i + 1), crews.get(i + 2))));
                continue;
            }
            pair.add(new Pair(Arrays.asList(crews.get(i), crews.get(i + 1))));
        }
        return pair;
    }

    private boolean isOddSize(List<Crew> crews) {
        return (crews.size() % 2 == 1);
    }

}
