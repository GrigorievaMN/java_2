package ru.geekbrains.courses.java_2;

import javax.xml.soap.Name;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class Main {

    public static void main(String[] args) throws NoSuchMethodException {
        RunJump[] member = {
                new Human(),
                new Cat(),
                new Human(),
                new Robot()
        };

        Obstacle[] barriers = {
                new Wall("wall_1"),
                new Road("road_1"),
                new Wall("wall_2"),
                new Road("road_2"),
                new Wall("wall_3"),
                new Road("road_3"),
                new Wall("wall_4"),
                new Road("road_4"),

        };


        for (RunJump m : member) {

            System.out.printf("\nA new participant enters the obstacle course.\n%s limitRun: %d limitJump: %d \n", m.getClass().getSimpleName(), m.getLimitRun(), m.getLimitJump());

            for (Obstacle b : barriers) {
                if (!b.passing(m)) {
                    break;
                }
                ;
            }

        }
    }
}
