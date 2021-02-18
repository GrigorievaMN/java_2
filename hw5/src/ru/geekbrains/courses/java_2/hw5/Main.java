package ru.geekbrains.courses.java_2.hw5;


import java.util.Arrays;

public class Main {
    static final int SIZE = 10000000;
    static final int PART = 8;
    static final int HALF = SIZE / PART;

    public static void main(String[] args) {
        float[] arr = new float[SIZE];
        Arrays.fill(arr, 1);
        System.out.println("The execution time of the task number one = " + updateArray1(arr) + "ms");
        System.out.println("sum of all array elements = " + sumArray(arr));

        Arrays.fill(arr, 1);
        System.out.println("The execution time of the task number two = " + updateArray2(arr) + "ms");
        System.out.println("sum of all array elements = " + sumArray(arr));

    }

    public static float sumArray(float[] arr){
        float sum = 0;
        for (float val: arr){
            sum += val;
        }
        return sum;
    }

    public static long updateArray1(float[] arr) {
        long beginTime = System.currentTimeMillis();
        for (int i = 0; i < arr.length; i++) {
            arr[i] = (float) (arr[i] * Math.sin(0.2f + i / 5) * Math.cos(0.2f + i / 5) * Math.cos(0.4f + i / 2));
        }
        long endTime = System.currentTimeMillis();
        return endTime - beginTime;
    }

    public static long updateArray2(float[] arr) {
        long beginTime = System.currentTimeMillis();
        float[][] arrCopy = new float[PART][];
        for (int i = 0; i < arrCopy.length; i++) {
            arrCopy[i] = new float[HALF];
            if (i == arrCopy.length - 1) {
                arrCopy[i] = new float[SIZE - i * HALF];
                System.arraycopy(arr, i * HALF, arrCopy[i], 0, SIZE - i * HALF);
            } else {
                arrCopy[i] = new float[HALF];
                System.arraycopy(arr, i * HALF, arrCopy[i], 0, HALF);
            }

        }

        Thread[] thread = new Thread[PART];

        for (int i = 0; i < PART; i++) {
            int iTmp = i;
            thread[i] = new Thread(() -> {
                setArr(arrCopy[iTmp], iTmp * HALF);
            });
        }

        for (int i = 0; i < PART; i++) {
            thread[i].start();
        }

        for (int i = 0; i < PART; i++) {
            try {
                thread[i].join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        for (int i = 0; i < arrCopy.length; i++) {
            if (i == arrCopy.length - 1) {
                System.arraycopy(arrCopy[i], 0, arr, i * HALF, SIZE - i * HALF);
            } else {
                System.arraycopy(arrCopy[i], 0, arr, i * HALF, HALF);
            }
        }
        long endTime = System.currentTimeMillis();
        return endTime - beginTime;
    }

    public static void setArr(float[] arr, int growth) {
        for (int i = 0; i < arr.length; i++) {
            arr[i] = (float) (arr[i] * Math.sin(0.2f + (i + growth) / 5) * Math.cos(0.2f + (i + growth) / 5)
                    * Math.cos(0.4f + (i + growth) / 2));
        }
    }
}



