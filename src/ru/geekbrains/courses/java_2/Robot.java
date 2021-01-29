package ru.geekbrains.courses.java_2;

public class Robot implements RunJump{
    @Override
    public void run() {
        System.out.println("Robot run");
    }

    @Override
    public void jump() {
        System.out.println("Robot jump");
    }
}
