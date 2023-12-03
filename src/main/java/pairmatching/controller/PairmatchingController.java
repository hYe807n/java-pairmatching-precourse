package pairmatching.controller;

import pairmatching.enums.Option;
import pairmatching.exception.Validation;
import pairmatching.model.Matcher;
import pairmatching.view.InputView;
import pairmatching.view.OutputView;

public class PairmatchingController {

    private Matcher matcher;

    public void run() {
        this.matcher = new Matcher();
        String answer = selectOption();
        choiceOption(answer);
    }

    private String selectOption() {
        String answer = InputView.readOption();
        try {
            Validation.checkOption(answer);
        } catch (Exception exception) {
            OutputView.printException(exception.getMessage());
            selectOption();
        }
        return answer;
    }

    private void choiceOption(String answer) {
        if (answer.equals(Option.MATCHING.getValue())) {
            pairMatching();
        }
    }

    private void pairMatching() {
        String answer = InputView.readMatchingLevel();
        try {
            if (matcher.isDuplicatedLevel(answer)) {
                pairRematch();
            }
            matcher.matchPairs(answer);
        } catch (Exception exception) {
            OutputView.printException(exception.getMessage());
            pairMatching();
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
