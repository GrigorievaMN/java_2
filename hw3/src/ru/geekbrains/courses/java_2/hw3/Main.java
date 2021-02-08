
package ru.geekbrains.courses.java_2.hw3;

import static ru.geekbrains.courses.java_2.hw3.CntValues.cntValues;

public class Main {

    public static void main(String[] args) {

        System.out.println(cntValues());

        PhoneDirectory directory = new PhoneDirectory();

        directory.addPhoneDirectory("Petrov", "89123567895");
        directory.addPhoneDirectory("Ivanov", "89131568403");
        directory.addPhoneDirectory("Petrov", "89216547238");
        directory.addPhoneDirectory("Sidorov", "3164867");
        directory.addPhoneDirectory("Ivanov", "35987413");
        directory.addPhoneDirectory("Sidorov", "9999999999");


        System.out.println(directory.getPhoneNumbers("Petrov"));
        System.out.println(directory.getPhoneNumbers("Ivanov"));
        System.out.println(directory.getPhoneNumbers("Sidorov"));

    }
}








