package ua.javarush.lutsenko.quest.repo.RepoCheckers;

import ua.javarush.lutsenko.quest.errors.RepoProblem;


//RCI (Repo Check Interface)
public interface RCI {
    RepoProblem check();
}
