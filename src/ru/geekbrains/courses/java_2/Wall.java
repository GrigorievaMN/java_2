package ru.geekbrains.courses.java_2;


import java.lang.reflect.InvocationTargetException;
import java.util.concurrent.ThreadLocalRandom;

public class Wall extends Obstacle {

    private final int height;

    public Wall(String name) {
        super(name);
        height = ThreadLocalRandom.current().nextInt(1, 11);
    }

    @Override
    public boolean passing(RunJump runJump) {
        System.out.println("Obstacle: " + super.getName() + " height: " + height + " м.");
        if (height > runJump.getLimitJump()) {
            System.out.println("Retired from the race");
            return false;
        }
        runJump.jump();
        return true;
    }

}
