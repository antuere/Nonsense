package Code.SortBytes;

import java.io.FileInputStream;
import java.util.ArrayList;
import java.util.Scanner;

public class Solution {
        public static void main(String[] args) throws Exception {
            Scanner scanner = new Scanner(System.in);
            String path = scanner.nextLine();
            int minCount = 256;

            FileInputStream fileInputStream = new FileInputStream(path);
            int[] bytesCount = new int[256];

            while (fileInputStream.available() > 0){
                bytesCount[fileInputStream.read()]++;
            }

            for (int element : bytesCount){
                if (element > 0 && element < minCount) minCount = element;
            }

            ArrayList<Integer> result = new ArrayList<>();
            for (int i = 0; i < bytesCount.length; i++){
                if (bytesCount[i] == minCount) result.add(i);
            }

            for (Integer element : result){
                System.out.print(element + " ");
            }
            fileInputStream.close();
        }
    }

