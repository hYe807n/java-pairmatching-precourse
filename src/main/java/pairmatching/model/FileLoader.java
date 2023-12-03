package pairmatching.model;

import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

public class FileLoader {

    public static List<String> loadBackend() {
        List<String> crewNames;
        try {
            crewNames = Files.readAllLines(Paths.get("src/main/resources/backend-crew.md"));
        } catch (Exception exception) {
            throw new RuntimeException("backend-crew 파일이 비어있습니다.");
        }
        return crewNames;
    }

    public static List<String> loadFrontend() {
        List<String> crewNames;
        try {
            crewNames = Files.readAllLines(Paths.get("src/main/resources/frontend-crew.md"));
        } catch (Exception exception) {
            throw new RuntimeException("frontend-crew 파일이 비어있습니다.");
        }
        return crewNames;
    }
}
