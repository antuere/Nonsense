package Code.OccurrenceOfSymbols;

/*
Встречаемость символов
*/

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader( new FileReader(args[0]));
        int [] asc = new int[128];
        while (bufferedReader.ready()) {
            asc[bufferedReader.read()]++;
        }
        for (int i = 0; i < asc.length; i++){
            char current = (char) i;
            if(asc[i] != 0) {
                System.out.println(current + " " + asc[i]);
            }
        }
        bufferedReader.close();
    }
}
