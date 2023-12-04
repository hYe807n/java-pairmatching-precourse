package pairmatching.model;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import pairmatching.enums.Course;
import pairmatching.enums.Level;

public class Crew {

    private final Course course;
    private final String name;
    private final Map<Level, List<Crew>> previousPair;

    public Crew(Course course, String name) {
        this.course = course;
        this.name = name;
        this.previousPair = new LinkedHashMap<>();
        initializePreviousPair();
    }

    private void initializePreviousPair() {
        Arrays.stream(Level.values()).forEach(level -> this.previousPair.put(level, new ArrayList<>()));
    }

    public String getName() {
        return this.name;
    }

    public boolean isSameCourse(Course course) {
        return this.course.equals(course);
    }

    public boolean isSameName(String name) {
        return this.name.equals(name);
    }

    public void addPreviousPair(Level level, List<Crew> crews) {
        crews.forEach(crew -> this.previousPair.get(level).add(crew));
    }

    public boolean isPreviousPair(Level level, List<Crew> crews) {
        return crews.stream().anyMatch(crew -> this.previousPair.get(level).contains(crew));
    }
}
