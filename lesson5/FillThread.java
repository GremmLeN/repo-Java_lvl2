package lesson5;

public class FillThread extends Thread {

    private final float[] arr;
    private float offset;

    FillThread(float[] arr, int offset) {
        this.arr = arr;
        this.offset = offset;
        start();
    }

    @Override
    public void run() {
        float offsetI;
        for (int i = 0; i < arr.length; i++) {
            offsetI = i + this.offset;
            arr[i] = (float) (arr[i] * Math.sin(0.2f + offsetI / 5) * Math.cos(0.2f + offsetI / 5) * Math.cos(0.4f + offsetI / 2));
        }
    }
}
