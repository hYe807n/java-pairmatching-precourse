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
            OutputView.printInform();
            pairMatching();
        }
    }

    private void pairMatching() {
        String answer = InputView.readMatchingLevel();
        try {
            checkPairRematch(answer);
        } catch (Exception exception) {
            OutputView.printException(exception.getMessage());
            pairMatching();
        }
    }

    private void checkPairRematch(String answer) {
        if (matcher.isDuplicatedLevel(answer)) {
            pairRematch(answer);
        }
        if (!matcher.isDuplicatedLevel(answer)) {
            matchByLevel(answer);
        }
    }

    private void matchByLevel(String answer) {
        List<Pair> pairs = matcher.matchPairs(answer).getPairs();
        OutputView.printStartPairs();
        for (Pair pair : pairs) {
            OutputView.printPairsByCrew(pair.getCrews());
        }
    }

    private void pairRematch(String level) {
        String rematch = InputView.readRematch();
        try {
            Validation.checkRematchAnswer(rematch);
            checkAnswerRematch(rematch, level);
        } catch (Exception exception) {
            OutputView.printException(exception.getMessage());
            pairRematch(level);
        }
    }

    private void checkAnswerRematch(String answer, String level) {
        if (answer.equals(Option.REMATCH.getValue())) {
            matchByLevel(level);
        }
        if (answer.equals(Option.NO_REMATCH.getValue())) {
            pairMatching();
        }
    }
}
