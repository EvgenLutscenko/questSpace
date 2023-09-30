package ua.javarush.lutsenko.quest.dbo;


import ua.javarush.lutsenko.quest.entity.PartI;

import java.util.Map;
import java.util.Properties;

//interface для описывания подстановки в инициализацию типа bd, у нас json файл
public interface DBI {
    Map<Integer, PartI> parse(Properties properties);
}
