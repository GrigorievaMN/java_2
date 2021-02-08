package ru.geekbrains.courses.java_2.hw2;

public class Main {
    static int SIZE = 4;

    public static void main(String[] args) {
        String[][] arr = {
                {"1", "2", "3", "4"},
                {"1", "2error", "3", "4"},
                {"1", "2", "3", "4"},
                {"1", "2", "3", "4"/*, "5"*/},
                //{"1", "2", "3", "4"}
        };
        try {
            System.out.println(sumArray(arr));
        } catch (MyArraySizeException e) {
            e.printStackTrace();
        } catch (MyArrayDataException e) {
            e.printStackTrace();
            System.out.println("Error value: " + arr[e.getRow()][e.getCol()]);
        }
    }


    public static int sumArray(String[][] arr) throws MyArraySizeException, MyArrayDataException {
        if (arr.length != SIZE) {
            throw new MyArraySizeException();
        }
        for (int i = 0; i < arr.length; i++) {

            if (arr[i].length != SIZE) {
                throw new MyArraySizeException();
            }
        }
        int sum = 0;
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[i].length; j++) {
                try {
                    sum += Integer.parseInt(arr[i][j]);
                } catch (NumberFormatException e) {
                    throw new MyArrayDataException("Error row: " + i + " column: " + j, i, j);

                }

            }
        }

        return sum;

    }
}

