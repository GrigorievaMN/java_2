package ru.geekbrains.courses.java_2;

import java.util.concurrent.ThreadLocalRandom;

public class Road extends Obstacle{
    private final int length;

    public Road(String name) {
        super(name);
        length = ThreadLocalRandom.current().nextInt (100,3001);
    }

    @Override
    public boolean passing(RunJump runJump) {
        System.out.println("Obstacle: " + super.getName() + " length: " + length + " м.");
        if (length > runJump.getLimitRun()) {
            System.out.println("Retired from the race");
            return false;
        }
        runJump.run();
        return true;
    }

}
