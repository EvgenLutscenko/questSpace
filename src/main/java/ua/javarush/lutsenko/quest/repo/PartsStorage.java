package ua.javarush.lutsenko.quest.repo;


import ua.javarush.lutsenko.quest.entity.PartI;

import java.util.Map;


//PartStorage use to store our Parts of quest, var parts is package-private to be visible in the StorageUtils class
public class PartsStorage {
    static Map<Integer, PartI> parts;
}
