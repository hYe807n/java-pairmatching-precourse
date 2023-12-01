package pairmatching.controller;

import pairmatching.enums.Option;
import pairmatching.exception.Validation;
import pairmatching.view.InputView;
import pairmatching.view.OutputView;

public class PairmatchingController {

    public void run() {
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
            Validation.checkPairSelect(answer);
        } catch (Exception exception) {
            OutputView.printException(exception.getMessage());
            pairMatching();
        }
    }
}
