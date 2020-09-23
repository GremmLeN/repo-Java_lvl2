package lesson2;

public class ArrayElementException extends Exception {

    public ArrayElementException(int i, int j) {
        super("Ожидаем массив int, встертили не int в i = " + i + " j = " + j);
    }
}
