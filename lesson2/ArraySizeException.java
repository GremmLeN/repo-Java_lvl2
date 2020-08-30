package lesson2;

public class ArraySizeException extends Exception {

    public ArraySizeException(String mess) {
        super(String.valueOf(mess));
    }
}
