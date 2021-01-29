package ru.geekbrains.courses.java_2;

public class Cat implements RunJump{
    @Override
    public void run() {
        System.out.println("Cat run");
    }

    @Override
    public void jump() {
        System.out.println("Cat jump");
    }
}

