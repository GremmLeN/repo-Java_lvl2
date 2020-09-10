package lesson5;

import java.util.Arrays;

public class main {

    private static final int size = 10_000_000;
    private static final int h = size / 2;
    private static final float[] arr1 = new float[size];
    private static final float[] arr2 = new float[size];

    public static void main(String[] args) {

        Arrays.fill(arr1, 1f);
        Arrays.fill(arr2, 1f);

        fillArray(arr1);
        fillArrayThread(arr2);

    }

    public static void fillArray(float[] arr) {

        long a = System.currentTimeMillis();

        for (int i = 0; i < arr.length; i++) {
            arr[i] = (float)(arr[i] * Math.sin(0.2f + i / 5) * Math.cos(0.2f + i / 5) * Math.cos(0.4f + i / 2));
        }

        System.out.println("Время работы fillArray: " + (System.currentTimeMillis() - a));
    }

    public static void fillArrayThread(float[] arr) {

        float[] arr1 = new float[h];
        float[] arr2 = new float[h];
        long a = System.currentTimeMillis();

        System.arraycopy(arr, 0, arr1, 0, h);
        System.arraycopy(arr, h, arr2, 0, h);
        System.out.println("fillArrayThread - Разбили на два массива за: " + (System.currentTimeMillis() - a));
        a = System.currentTimeMillis();

        Thread thread1 = new Thread(new FillThread(arr1, 0));
        Thread thread2 = new Thread(new FillThread(arr2, h));

        try {
            thread1.join();
            System.out.println("fillArrayThread - Посчитали первую часть массива: " + (System.currentTimeMillis() - a));
            a = System.currentTimeMillis();

            thread2.join();
            System.out.println("fillArrayThread - Посчитали вторую часть массива: " + (System.currentTimeMillis() - a));
            a = System.currentTimeMillis();

        } catch (InterruptedException e) {
            e.printStackTrace();
            thread1.interrupt();
            thread2.interrupt();
        }

        System.arraycopy(arr1, 0, arr, 0, h);
        System.arraycopy(arr2, 0, arr, h, h);
        System.out.println("fillArrayThread - Склеили два массива в один за: " + (System.currentTimeMillis() - a));

    }
}
