package ua.javarush.lutsenko.quest.entity;

import lombok.AllArgsConstructor;
import lombok.Data;


//Condition class that implement PartI interface use to store condition from json in the String
@Data
@AllArgsConstructor
public class Condition implements PartI{
    public Condition(){}
    private String condition;
}
