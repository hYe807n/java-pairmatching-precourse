package pairmatching.view;

import java.util.List;
import java.util.StringJoiner;
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
        System.out.println(Form.REMATCH);
    }

    public static void printInform() {
        System.out.println(Form.INFORM.getMessage());
    }

    public static void printPairsByCrew(List<Crew> crews) {
        System.out.println(new StringJoiner(" : ","",""));
    }
}
