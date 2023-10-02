package ua.javarush.lutsenko.quest.problemsEntity;

import lombok.AllArgsConstructor;
import lombok.Data;

//Class for describing problem that could occur somewhere in app, we can send it to jsp then use explanation var as a store for text of problem
@Data
@AllArgsConstructor
public class RepoProblem {
    private String explanation;
}
