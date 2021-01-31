package ru.geekbrains.courses.java_2;

import java.util.concurrent.ThreadLocalRandom;

public class Cat implements RunJump {
    private final int limitRun;
    private final int limitJump;

    public Cat() {
        limitRun = ThreadLocalRandom.current().nextInt(100, 3001);
        limitJump = ThreadLocalRandom.current().nextInt(1, 11);
    }

    @Override
    public void run() {

        System.out.println("Cat running");
    }

    @Override
    public void jump() {

        System.out.println("Cat jumping");
    }

    @Override
    public int getLimitRun() {
        return limitRun;
    }

    @Override
    public int getLimitJump() {
        return limitJump;
    }


}

