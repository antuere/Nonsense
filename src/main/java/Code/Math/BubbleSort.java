package Code.Math;

import java.util.Arrays;

public class BubbleSort {
    public static void main(String[] args) {
        int[] array = {10, 5, 61, 2, 1, 7, 18, 15, 12};
        bubbleSort(array);

        System.out.println("Итог  " +  Arrays.toString(array));
    }

    public static void bubbleSort(int[] array) {
        boolean isSort = false;

        while (!isSort) {
            isSort = true;

            for (int i = 1; i < array.length; i++) {
                if (array[i - 1] > array[i]) {
                    int temp = array[i - 1];
                    array[i - 1] = array[i];
                    array[i] = temp;

                    isSort = false;
                }
            }

            System.out.println(Arrays.toString(array));
        }
    }
}
