package Code.Math;

import java.util.Scanner;

public class TableUmnoj {
    public static int[][] MULTIPLICATION_TABLE;

    public static void main(String[] args) {
        Scanner num = new Scanner(System.in);
        System.out.println("Введите высоту таблицы:");
        int height = num.nextInt();
        System.out.println("Введите ширину таблицы:");
        int weight = num.nextInt();
        MULTIPLICATION_TABLE = new int[height][weight];
        for (int i = 0, a = 1; i < height; i++, a++) {
            for (int j = 0, c = 0; j < weight; j++, c = c + a) {
                MULTIPLICATION_TABLE[i][j] = a + c;
            }
        }
        for (int i = 0, a = 1; i < height; i++, a++) {
            for (int j = 0, c = 0; j < weight; j++, c = c + a) {
                System.out.print(MULTIPLICATION_TABLE[i][j] + "\t");
            }
            System.out.println();
        }
    }
}
