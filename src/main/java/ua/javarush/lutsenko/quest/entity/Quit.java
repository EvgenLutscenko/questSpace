package ua.javarush.lutsenko.quest.entity;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Quit implements PartI{
    public Quit(){}
    private String conclusion;
    private Exodus exodus;
    private int number;
}
