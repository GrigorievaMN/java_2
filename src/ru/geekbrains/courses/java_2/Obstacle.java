package ru.geekbrains.courses.java_2;

public abstract class Obstacle {
    private String name;

    public Obstacle(String name) {
        this.name = name;
    }

    public abstract boolean passing(RunJump runJump);

    public String getName() {
        return name;
    }
}
