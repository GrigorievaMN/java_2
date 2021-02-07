package ru.geekbrains.courses.java_2;

import java.util.concurrent.ThreadLocalRandom;

public class Robot implements RunJump{
    private final int limitRun;
    private final int limitJump;

    public Robot(){
        limitRun = ThreadLocalRandom.current().nextInt(100,3001);
        limitJump = ThreadLocalRandom.current().nextInt(1,5);
    }

    @Override
    public void run() {

        System.out.println("Robot running");
    }

    @Override
    public void jump() {

        System.out.println("Robot jumping");
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
