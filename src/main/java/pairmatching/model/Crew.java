package pairmatching.model;

import java.util.List;
import java.util.Map;
import pairmatching.enums.Course;
import pairmatching.enums.Level;

public class Crew {

    private final Course course;
    private final String name;
    private Map<Level, List<Crew>> previousPair;

    public Crew(Course course, String name) {
        this.course = course;
        this.name = name;
    }

    public String getName() {
        return this.name;
    }

    public boolean isSameCourse(Course course) {
        return this.course.equals(course);
    }

    public boolean isPreviousPair(Level level, Crew crew) {
        return this.previousPair.get(level).stream().anyMatch(
            previousCrew -> previousCrew.equals(crew));
    }
}
