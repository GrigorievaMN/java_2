package ru.geekbrains.courses.java_2;

import java.util.concurrent.ThreadLocalRandom;

public class Human implements RunJump{
    private final int limitRun;
    private final int limitJump;

    public Human(){
        limitRun = ThreadLocalRandom.current().nextInt(100,3001);
        limitJump = ThreadLocalRandom.current().nextInt(1,11);
            }


    @Override
    public void run() {

        System.out.println("Human running");
    }

    @Override
    public void jump() {

        System.out.println("Human jumping");
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
