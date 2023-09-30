package ua.javarush.lutsenko.quest.entity;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Condition implements PartI{
    public Condition(){}
    private String condition;
}
