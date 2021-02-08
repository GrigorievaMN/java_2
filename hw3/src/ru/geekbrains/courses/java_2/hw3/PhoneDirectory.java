package ru.geekbrains.courses.java_2.hw3;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class PhoneDirectory {

    private ArrayList<String> phoneNumberList;
    private Map<String, ArrayList<String>> directory = new HashMap<>();

    public void addPhoneDirectory(String surname, String phoneNumber){
        phoneNumberList = directory.getOrDefault(surname, new ArrayList<>());
        phoneNumberList.add(phoneNumber);
        directory.put(surname, phoneNumberList);
    }

    public ArrayList<String> getPhoneNumbers (String surname) {
        return directory.get(surname);
    }



}
