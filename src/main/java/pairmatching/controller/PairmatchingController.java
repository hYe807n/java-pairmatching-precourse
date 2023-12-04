package pairmatching.controller;

import java.util.List;
import pairmatching.enums.Option;
import pairmatching.exception.Validation;
import pairmatching.model.Matcher;
import pairmatching.model.Pair;
import pairmatching.view.InputView;
import pairmatching.view.OutputView;

public class PairmatchingController {

    private static final int COUNT_MATCH_FIRST = 0;

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
        if (answer.equals(Option.QUERY.getValue())) {
            OutputView.printInform();
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
            checkMatchRetry(answer, COUNT_MATCH_FIRST);
        }
    }

    private void checkMatchRetry(String answer, int count) {
        try {
            matchByLevel(answer);
        } catch (Exception exception) {
            Validation.checkRetryCount(count);
            checkMatchRetry(answer, count + 1);
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
            checkMatchRetry(level, COUNT_MATCH_FIRST);
        }
        if (answer.equals(Option.NO_REMATCH.getValue())) {
            pairMatching();
        }
    }
}
