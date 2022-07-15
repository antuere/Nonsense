package Code.ReplaceAndDeleteProduct;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.Scanner;

public class Solution {
    public static void main(String[] args) throws Exception {
        if (args.length == 0) {
            return;
        }

        Scanner scanner = new Scanner(System.in);
        String fileName = scanner.nextLine();
        BufferedReader bufferedReader = new BufferedReader(new FileReader(fileName));
        ArrayList<String> lines = new ArrayList<>();
        String temp;
        int needId = Integer.parseInt(args[1]);
        int current = 0;

        while (bufferedReader.ready()) {
            lines.add(bufferedReader.readLine());
        }

        for (String el : lines) {
            temp = el.substring(0, 8).trim();
            current = Integer.parseInt(temp);
            if (current == needId) {
                if (args[0].equals("-u")) {
                    {
                        StringBuilder productName = new StringBuilder();
                        for (int i = 2; i < args.length - 2; i++) {
                            productName.append(args[i]).append(" ");
                        }
                        if (productName.length() > 30) productName = new StringBuilder(productName.substring(0, 30));
                        while (productName.length() < 30) {
                            productName.append(" ");
                        }

                        StringBuilder price = new StringBuilder(args[args.length - 2]);
                        if (price.length() > 8) price = new StringBuilder(price.substring(0, 8));
                        while (price.length() < 8) {
                            price.append(" ");
                        }

                        StringBuilder quantity = new StringBuilder(args[args.length - 1]);
                        if (quantity.length() > 4) quantity = new StringBuilder(quantity.substring(0, 4));
                        while (quantity.length() < 4) {
                            quantity.append(" ");
                        }

                        StringBuilder id = new StringBuilder(temp);
                        if (id.length() > 8) id = new StringBuilder(id.substring(0, 8));
                        while (id.length() < 8) {
                            id.append(" ");
                        }
                        String newline = id + productName.toString() + price + quantity;

                        lines.set(lines.indexOf(el), newline);
                        break;
                    }
                }
                if (args[0].equals("-d")) {
                    lines.remove(lines.indexOf(el));
                    break;
                }
            }
        }

        FileWriter fileWriter = new FileWriter(fileName);
        for (String el : lines) {
            fileWriter.write(el + System.lineSeparator());
        }

        fileWriter.close();
        bufferedReader.close();
    }

}