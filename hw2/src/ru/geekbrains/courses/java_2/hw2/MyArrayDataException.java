package ru.geekbrains.courses.java_2.hw2;

public class MyArrayDataException extends RuntimeException{

    private int row;
    private int col;

    public int getRow() {
        return row;
    }

    public int getCol() {
        return col;
    }

    public MyArrayDataException (String message, int row, int col) {
        super(message);
        this.row = row;
        this.col = col;


    }


}
