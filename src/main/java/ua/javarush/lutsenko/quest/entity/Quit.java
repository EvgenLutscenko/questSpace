package ua.javarush.lutsenko.quest.entity;

import lombok.AllArgsConstructor;
import lombok.Data;


//Quit class that implement PartI interface use to store condition from json in the String(number - question queue number)
@Data
@AllArgsConstructor
public class Quit implements PartI{
    public Quit(){}
    private String conclusion;
    private Exodus exodus;
    private int number;
}
