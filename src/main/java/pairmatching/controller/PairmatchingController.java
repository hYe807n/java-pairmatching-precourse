package pairmatching.controller;

import pairmatching.exception.Validation;
import pairmatching.view.InputView;
import pairmatching.view.OutputView;

public class PairmatchingController {

    public void run() {
        String answer = selectOption();
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
}
