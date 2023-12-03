package pairmatching.controller;

import java.util.List;
import pairmatching.enums.Option;
import pairmatching.exception.Validation;
import pairmatching.model.Matcher;
import pairmatching.model.Pair;
import pairmatching.view.InputView;
import pairmatching.view.OutputView;

public class PairmatchingController {

    private Matcher matcher;

    public void run() {
        this.matcher = new Matcher();
        String answer = "";
        while (!answer.equals(Option.EXIT.getValue())) {
            answer = selectOption();
            choiceOption(answer);
        }
    }

    private String selectOption() {
        String answer = InputView.readOption();
        try {
            Validation.checkOption(answer);
            return answer;
        } catch (Exception exception) {
            OutputView.printException(exception.getMessage());
            answer = selectOption();
        }
        return answer;
    }

    private void choiceOption(String answer) {
        if (answer.equals(Option.MATCHING.getValue())) {
            pairMatching();
        }
        if (answer.equals(Option.EXIT.getValue())) {
            return;
        }
    }

    private void pairMatching() {
        String answer = InputView.readMatchingLevel();
        try {
            if (matcher.isDuplicatedLevel(answer)) {
                pairRematch();
            }
            printPairsByLevel(answer);
        } catch (Exception exception) {
            OutputView.printException(exception.getMessage());
            pairMatching();
        }
    }

    private void printPairsByLevel(String answer) {
        List<Pair> pairs = matcher.matchPairs(answer).getPairs();
        for (Pair pair : pairs) {
            OutputView.printPairsByCrew(pair.getCrews());
        }
    }

    private void pairRematch() {
        String rematch = InputView.readRematch();
        Validation.checkRematchAnswer(rematch);
        if (rematch.equals(Option.REMATCH.getValue())) {
            return;
        }
        if (rematch.equals(Option.NO_REMATCH.getValue())) {
            pairMatching();
        }
    }
}
