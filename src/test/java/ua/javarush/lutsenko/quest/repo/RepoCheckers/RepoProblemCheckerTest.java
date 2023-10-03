package ua.javarush.lutsenko.quest.repo.RepoCheckers;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import ua.javarush.lutsenko.quest.entity.*;
import ua.javarush.lutsenko.quest.errors.RepoProblem;

import java.util.*;

import static org.junit.jupiter.api.Assertions.*;

class RepoProblemCheckerTest {
    private RepoProblemChecker repoProblemChecker;
    private Map<Integer, PartI> map;

    @BeforeEach
    public void setUp() {
        map = new HashMap<>();
        repoProblemChecker = new RepoProblemChecker(map);
    }

    @Test
    public void testNullMap() {
        RepoProblem repoProblem = repoProblemChecker.check();
        assertNotNull(repoProblem);
        assertEquals("You have a problem with path to one of JSON files, check it please", repoProblem.getExplanation());
    }

    @Test
    public void testIncorrectStartNode() {
        map.put(0, new Question());
        RepoProblem repoProblem = repoProblemChecker.check();
        assertNotNull(repoProblem);
        assertEquals("Questions start from 1 node, edit the questions.json file.", repoProblem.getExplanation());
    }

    @Test
    public void testMissingPart() {
        map.put(0, new Condition());
        map.put(2, new Question());
        RepoProblem repoProblem = repoProblemChecker.check();
        assertNotNull(repoProblem);
        assertEquals("JSON file is not available: you have a mistake in structure: part number - 1 isn't in the list", repoProblem.getExplanation());
    }

    @Test
    public void testMissingAnswerReference() {
        map.put(0, new Condition());
        map.put(1, new Question("", List.of("", ""), List.of(-1, 3), 1));
        RepoProblem repoProblem = repoProblemChecker.check();
        assertNotNull(repoProblem);
        assertEquals("JSON file is not available: you have a mistake in structure of Question: reference in question number - 1 isn't in the list", repoProblem.getExplanation());
    }

    @Test
    public void testMissingCondition() {
        map.put(1, new Question());
        RepoProblem repoProblem = repoProblemChecker.check();
        assertNotNull(repoProblem);
        assertEquals("JSON file is not available: you don't have a condition", repoProblem.getExplanation());
    }

    @Test
    public void testQuitAtLevel1() {
        map.put(0, new Condition());
        map.put(1, new Quit());
        RepoProblem repoProblem = repoProblemChecker.check();
        assertNotNull(repoProblem);
        assertEquals("JSON file is not available: 1 level can't be quit", repoProblem.getExplanation());
    }

    @Test
    public void testValidScenario() {
        map.put(0, new Condition("some text"));
        map.put(1, new Question("condition", new ArrayList<>(Arrays.asList("1 question", "2 question")), List.of(1, 2), 1));
        map.put(2, new Question("condition", new ArrayList<>(Arrays.asList("1 question", "2 question")), List.of(1, 2), 2));
        map.put(3, new Question("condition", new ArrayList<>(Arrays.asList("1 question", "2 question")), List.of(1, 2), 3));
        map.put(4, new Quit("conclusion", Exodus.POSITIVE, 4));
        RepoProblem repoProblem = repoProblemChecker.check();
        assertNull(repoProblem);
    }

}