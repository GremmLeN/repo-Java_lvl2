package lesson2;

import java.util.Arrays;

public class main {

    public static void main(String[] args) {
        String str = "10 3 1 2\n2 3 2 2\n5 6 7 1\n300 3 1 0";
        String[] str1 = str.split("\n");
        String[] str2 = str1[1].split(" ");
        //System.out.println(Arrays.toString(str1));
        //System.out.println(str1.length);
        //System.out.println(Arrays.deepToString(str2));
        String[][] result;

        try {
           result = convertStringToArray(str, 4);
           System.out.println(Arrays.deepToString(result));
           System.out.println(sumArrEle(result, 2));
        } catch (ArraySizeException | ArrayElementException ex) {
            System.out.println(ex.getMessage());
        }
    }

    private static String[][] convertStringToArray(String str, int arrlenght) throws ArraySizeException {
        String[] str1 = str.split("\n");
        if (str.split("\n").length > arrlenght) throw new ArraySizeException("размерность массива получаемого из String > " + arrlenght);
        String[][] arr = new String[str1.length][str1.length];
        for (int i = 0; i < str1.length; i++) {
            if (str1[i].split(" ").length == arrlenght) {
                arr[i] = str1[i].split(" ");
            } else {
                throw new ArraySizeException("Кол-во елементов полученных из String > " + arrlenght);
            }
        }
        return arr;
    }

    private static int sumArrEle(String[][] arr, int devision ) throws ArrayElementException{
        int sum = 0;
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[i].length; j++) {
                if (arr[i][i].matches("\\d+")) {
                    sum = sum + Integer.parseInt(arr[i][j]);
                } else {
                    throw new ArrayElementException(i, j);
                }
            }
        }
        return (sum / devision);
    }
}
