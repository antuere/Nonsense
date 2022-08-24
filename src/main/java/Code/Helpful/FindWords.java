package Code.Helpful;

import java.io.*;
import java.util.regex.Pattern;

public class FindWords {
    public static void main(String[] args) throws IOException {

        BufferedReader bufferedReader = new BufferedReader(new FileReader("C:\\Users\\user\\Desktop\\ENRUS.txt"));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter("C:\\Users\\user\\Desktop\\result.txt", true));

        while (bufferedReader.ready()) {
            String line = bufferedReader.readLine();
            int mid = line.length() / 2;
            if (Pattern.matches("(^g.+k$)|(^G.+k$)", line) && line.charAt(mid) == 'n') {
                bufferedWriter.write(line + "\n");
            }
        }

        bufferedReader.close();
        bufferedWriter.close();
    }
}


