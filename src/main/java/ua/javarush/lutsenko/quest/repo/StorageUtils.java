package ua.javarush.lutsenko.quest.repo;


import ua.javarush.lutsenko.quest.entity.PartI;
import ua.javarush.lutsenko.quest.entity.Question;
import ua.javarush.lutsenko.quest.entity.Quit;
import ua.javarush.lutsenko.quest.problemsEntity.RepoProblem;

import java.util.Map;

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

    private static Integer checkIsAllPartsHere(){
        int temp = -1;
        for(int num : PartsStorage.parts.keySet()){
            if(num == (temp + 1)){
                temp++;
            }else {
                break;
            }
        }

        return temp;
    }


    //    check (private List<Integer> answers) in Questions
    private static int checkAnswersReference(){
        int temp = 0;

        for(PartI part : PartsStorage.parts.values()){
            if(part instanceof Question){
                for (Integer answer : ((Question) part).getAnswers()){
                    if(answer < 1 || answer > PartsStorage.parts.size()){
                        break;
                    }
                }
            }
            temp++;
        }

        return temp;
    }


    public static RepoProblem check(){
        int temp;
        if((temp = checkIsAllPartsHere()) != PartsStorage.parts.size() - 1){
            return new RepoProblem("Json file is not available: you have a mistake in structure: part number - " + (temp+1) + " isn't in the list");
        }else if ((temp = checkAnswersReference()) != PartsStorage.parts.size()){
            return new RepoProblem("Json file is not available: you have a mistake in structure of Question: reference in question number - " + (temp+1) + " isn't in the list");
        }else if(PartsStorage.parts.get(0) == null){
            return new RepoProblem("Json file is not available: you don't have condition");
        }else if(PartsStorage.parts.get(1) instanceof Quit){
            return new RepoProblem("Json file is not available: 1 level can't be quit");
        }

        return null;
    }
}
