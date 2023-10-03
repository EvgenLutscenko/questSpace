package ua.javarush.lutsenko.quest.dbo;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import ua.javarush.lutsenko.quest.entity.Condition;
import ua.javarush.lutsenko.quest.entity.PartI;
import ua.javarush.lutsenko.quest.entity.Question;
import ua.javarush.lutsenko.quest.entity.Quit;

import java.util.Map;
import java.util.Properties;

import static org.junit.jupiter.api.Assertions.*;

class JSONParserTest {
    private JSONParser jsonParser;
    private Properties properties;

    @BeforeEach
    public void setUp() {
        jsonParser = new JSONParser();
        properties = new Properties();
        properties.setProperty("linkCondition", "condition.json");
        properties.setProperty("linkQuestions", "questions.json");
        properties.setProperty("linkQuits", "quits.json");
    }

    @Test
    public void testParseValidData() {
        Map<Integer, PartI> result = jsonParser.parse(properties);
        assertNotNull(result);
        assertFalse(result.isEmpty());

        // Check if the condition is parsed correctly
        Condition condition = (Condition) result.get(0);
        assertNotNull(condition);



        // Check if questions are parsed correctly
        for (int i = 0; i <= 10; i++) {
            if(i == 0){
                Condition condition1 = (Condition) result.get(i);
                assertNotNull(condition1);
            }else if(i == 1 || i == 2 || i == 4 || i == 5 || i == 6 || i == 8){
                Question question = (Question) result.get(i);
                assertNotNull(question);
                assertEquals(i, question.getNumber());
            }else {
                Quit quit = (Quit) result.get(i);
                assertNotNull(quit);
                assertEquals(i, quit.getNumber());
            }
        }
    }

    @Test
    public void testParseInvalidData() {
        // Provide incorrect property names to simulate invalid data
        properties.setProperty("linkCondition", "nonexistent_condition.json");
        properties.setProperty("linkQuestions", "nonexistent_questions.json");
        properties.setProperty("linkQuits", "nonexistent_quits.json");

        Map<Integer, PartI> result = jsonParser.parse(properties);
        assertNull(result);
    }
}