package ua.javarush.lutsenko.quest.entity;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;

@Data
@AllArgsConstructor
public class Question implements PartI{
    public Question(){}
    private String condition;
    private List<String> questions;
    private List<Integer> answers;
    private int number;
}
