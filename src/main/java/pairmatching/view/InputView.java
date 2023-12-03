package pairmatching.view;

import static camp.nextstep.edu.missionutils.Console.readLine;

public class InputView {

    public static String readOption() {
        OutputView.printMainOptions();
        return readLine().trim();
    }

    public static String readMatchingLevel() {
        OutputView.printLevelSelect();
        return readLine().trim().replace(" ","");
    }

    public static String readRematch() {
        OutputView.printRematch();
        return readLine().trim();
    }
}
