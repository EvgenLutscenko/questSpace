package ua.javarush.lutsenko.quest.entity;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;


//Question class that implement PartI interface use to store question from json (number - question queue number)
@Data
@AllArgsConstructor
public class Question implements PartI{
    public Question(){}
    private String condition;
    private List<String> questions;
    private List<Integer> answers;
    private int number;
}
