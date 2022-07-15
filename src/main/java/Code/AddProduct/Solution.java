package Code.AddProduct;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.Scanner;

public class Solution {
    public static void main(String[] args) throws Exception {

        if (args.length == 0){
            return;
        }

        if (args[0].equals("-c")) {

            Scanner scanner = new Scanner(System.in);
            String fileName = scanner.nextLine();
            BufferedReader bufferedReader = new BufferedReader(new FileReader(fileName));
            FileWriter fileWriter = new FileWriter(fileName, true);

            StringBuilder productName = new StringBuilder(args[1]);
            while (productName.length() < 30) {
                productName.append(" ");
            }

            StringBuilder price = new StringBuilder(args[2]);
            while (price.length() < 8) {
                price.append(" ");
            }

            StringBuilder quantity = new StringBuilder(args[3]);
            while (quantity.length() < 4) {
                quantity.append(" ");
            }

            ArrayList<String> lines = new ArrayList<>();
            String temp;
            int maxId = 0;
            int current = 0;

            while (bufferedReader.ready()) {
                lines.add(bufferedReader.readLine());
            }

            for (String el : lines) {
                temp = el.substring(0, 8).trim();
                current = Integer.parseInt(temp);

                if (current > maxId) maxId = current;
            }

            fileWriter.write(System.lineSeparator() + ++maxId + productName + price + quantity);

            fileWriter.close();
            bufferedReader.close();
        }
    }
}