package ua.javarush.lutsenko.quest.dbo;


import ua.javarush.lutsenko.quest.entity.PartI;

import java.util.Map;
import java.util.Properties;

//interface for describing the method of parsing from a database
public interface DBI {
    Map<Integer, PartI> parse(Properties properties);
}
