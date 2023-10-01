package ua.javarush.lutsenko.quest.dbo;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import ua.javarush.lutsenko.quest.entity.Condition;
import ua.javarush.lutsenko.quest.entity.PartI;
import ua.javarush.lutsenko.quest.entity.Question;
import ua.javarush.lutsenko.quest.entity.Quit;

import java.io.File;
import java.io.InputStream;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Properties;

public class JSONParser implements DBI {
    @Override
    public Map<Integer, PartI> parse(Properties properties) {
        ClassLoader classLoader = JSONParser.class.getClassLoader();

        InputStream fileCondition = classLoader.getResourceAsStream(properties.getProperty("linkCondition"));
        InputStream fileQuestion = classLoader.getResourceAsStream(properties.getProperty("linkQuestions"));
        InputStream fileQuites = classLoader.getResourceAsStream(properties.getProperty("linkQuits"));

        ObjectMapper objectMapper = new ObjectMapper();
        List<Question> questions = null;
        List<Quit> quites = null;
        Condition condition = null;

        try {
            questions = objectMapper.readValue(
                    fileQuestion,
                    new TypeReference<>() {
                    }
            );
            quites = objectMapper.readValue(
                    fileQuites,
                    new TypeReference<>() {
                    }
            );

            condition = objectMapper.readValue(
                    fileCondition,
                    new TypeReference<>() {
                    }
            );
        } catch (Exception e) {
            return null;
        }

        Map<Integer, PartI> map = new HashMap<>();
        if(condition != null){
            map.put(0, condition);
        }
        if(questions != null && quites != null){
            questions.forEach(e -> map.put(e.getNumber(), e));
            quites.forEach(e -> map.put(e.getNumber(), e));
        }

        return map;
    }
}
