package pairmatching.model;


import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import pairmatching.enums.Course;

public class Crews {

    private final List<Crew> crews;

    public Crews() {
        List<Crew> crews = new ArrayList<>();
        List<Crew> backend = FileLoader.loadBackend().stream()
            .map(crewName -> new Crew(Course.BACKEND, crewName)).collect(Collectors.toList());
        List<Crew> frontend = FileLoader.loadFrontend().stream()
            .map(crewName -> new Crew(Course.FRONTEND, crewName)).collect(Collectors.toList());
        crews.addAll(backend);
        crews.addAll(frontend);
        this.crews = crews;
    }

    public List<Crew> getBackendCrews() {
        return crews.stream()
            .filter( crew -> crew.isSameCourse(Course.BACKEND))
            .collect(Collectors.toList());
    }

    public List<Crew> getFrontendCrews() {
        return crews.stream()
            .filter( crew -> crew.isSameCourse(Course.BACKEND))
            .collect(Collectors.toList());
    }
}
