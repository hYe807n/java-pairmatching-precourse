package pairmatching.view;

import java.util.List;
import java.util.StringJoiner;
import java.util.stream.Collectors;
import pairmatching.enums.Form;
import pairmatching.model.Crew;

public class OutputView {

    public static void printMainOptions() {
        System.out.println(Form.MAIN_SELECT.getMessage());
    }

    public static void printException(String message) {
        System.out.println(new StringJoiner("", Form.START_ERROR.getMessage(), message));
    }

    public static void printRematch() {
        System.out.println(Form.REMATCH.getMessage());
    }

    public static void printInform() {
        System.out.print(Form.INFORM.getMessage());
    }

    public static void printLevelSelect() {
        System.out.println(Form.LEVEL_SELECT.getMessage());
    }

    public static void printStartPairs() {
        System.out.println(Form.RESULT_MATCHING.getMessage());
    }

    public static void printPairsByCrew(List<Crew> crews) {
        System.out.println(crews.stream().map(Crew::getName).collect(
            Collectors.joining(" : ")));
    }

    public static void printInitialize() {
        System.out.println(Form.PAIR_INITIALIZE.getMessage());
    }
}
