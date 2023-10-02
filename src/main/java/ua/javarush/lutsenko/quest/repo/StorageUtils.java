package ua.javarush.lutsenko.quest.repo;


import ua.javarush.lutsenko.quest.entity.PartI;
import ua.javarush.lutsenko.quest.problemsEntity.RepoProblem;
import ua.javarush.lutsenko.quest.repo.RepoCheckers.RepoProblemChecker;

import java.util.Map;



//Utils for PartsStorage class
public class StorageUtils {

    public static void init(Map<Integer, PartI> map){
        if(PartsStorage.parts == null){
            PartsStorage.parts = map;
        }
    }
    public static Map<Integer, PartI> get(){
        return PartsStorage.parts;
    }
    public static PartI getPart(int number){
        return PartsStorage.parts.get(number);
    }

    public static RepoProblem check(){
        return new RepoProblemChecker(PartsStorage.parts).check();
    }
}
