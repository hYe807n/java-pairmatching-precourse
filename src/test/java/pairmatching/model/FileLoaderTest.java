package pairmatching.model;

import java.util.List;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class FileLoaderTest {

    @DisplayName("./resources/backend-crew.md 파일에서 백엔드 크루 이름 불러오기")
    @Test
    void loadBackendFile() {
        List<String> crews = FileLoader.loadBackend();
        Assertions.assertTrue(crews.contains("백호"));
    }

    @DisplayName("./resources/frontend-crew.md 파일에서 프론트엔드 크루 이름 불러오기")
    @Test
     void loadFrontendFile() {
        List<String> crews = FileLoader.loadFrontend();
        Assertions.assertTrue(crews.contains("다비"));
    }
}