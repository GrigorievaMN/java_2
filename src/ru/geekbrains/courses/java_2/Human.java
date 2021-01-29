package ru.geekbrains.courses.java_2;

public class Human implements RunJump{
    @Override
    public void run() {
        System.out.println("Human run");
    }

    @Override
    public void jump() {
        System.out.println("Human jump");
    }
}
