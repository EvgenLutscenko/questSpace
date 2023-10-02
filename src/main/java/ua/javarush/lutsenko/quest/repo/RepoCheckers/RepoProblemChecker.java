package ua.javarush.lutsenko.quest.repo.RepoCheckers;

import lombok.AllArgsConstructor;
import ua.javarush.lutsenko.quest.entity.Condition;
import ua.javarush.lutsenko.quest.entity.PartI;
import ua.javarush.lutsenko.quest.entity.Question;
import ua.javarush.lutsenko.quest.entity.Quit;
import ua.javarush.lutsenko.quest.problemsEntity.RepoProblem;

import java.util.Map;


//Class that implement RCI and check problem with map in the storage
@AllArgsConstructor
public class RepoProblemChecker implements RCI{
    private Map<Integer, PartI> map;
    private Integer checkIsAllPartsHere(){
        int temp = -1;
        for(int num : map.keySet()){
            if(num == (temp + 1)){
                temp++;
            }else {
                break;
            }
        }

        return temp;
    }


    //    check (private List<Integer> answers) in Questions
    private int checkAnswersReference(){
        int temp = 0;

        for(PartI part : map.values()){
            if(part instanceof Question){
                for (Integer answer : ((Question) part).getAnswers()){
                    if(answer < 1 || answer > map.size()){
                        break;
                    }
                }
            }
            temp++;
        }

        return temp;
    }

    public RepoProblem check(){
        int temp;
        if(map == null){
            return new RepoProblem("You have a problem with path to one of json files, check it please");
        }else if(!(map.get(0) instanceof Condition)){
            return new RepoProblem("Questions start from 1 node, edit the questions.json file.");
        }else if(map.keySet().iterator().next() < 0){
            return new RepoProblem("Questions start from 1 node, edit the questions.json file.");
        } else if((temp = checkIsAllPartsHere()) != map.size() - 1){
            return new RepoProblem("Json file is not available: you have a mistake in structure: part number - " + (temp+1) + " isn't in the list");
        }else if ((temp = checkAnswersReference()) != map.size()){
            return new RepoProblem("Json file is not available: you have a mistake in structure of Question: reference in question number - " + (temp+1) + " isn't in the list");
        }else if(map.get(0) == null){
            return new RepoProblem("Json file is not available: you don't have condition");
        }else if(map.get(1) instanceof Quit){
            return new RepoProblem("Json file is not available: 1 level can't be quit");
        }

        return null;
    }
}
