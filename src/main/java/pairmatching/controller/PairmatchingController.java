package pairmatching.controller;

import pairmatching.view.InputView;

public class PairmatchingController {

    public void run() {
        selectOption();
    }

    private void selectOption() {
        InputView.readOption();
    }
}
