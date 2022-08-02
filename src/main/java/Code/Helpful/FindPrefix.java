package Code.Helpful;

import java.util.Date;

public class FindPrefix {
    public static void main(String[] args) {

        String[] words = {"Antonsad", "Antona", "Antos", "Antrn"};


        String result = findPrefix(words);

        String secResult = findPrefixNew(words);


        System.out.println(result + " - old");
        System.out.println(secResult + " - new");
    }

    public static String findPrefix(String[] strings) {

        StringBuilder result = new StringBuilder();
        char[][] matrix = new char[strings.length][10];

        int countRepeat = 1;

        for (int i = 0; i < strings.length; i++) {
            String currentWord = strings[i];
            for (int j = 0; j < currentWord.length(); j++) {
                matrix[i][j] = strings[i].charAt(j);
            }
        }

        for (int i = 0; i < matrix[0].length; i++) {
            for (int j = 0, k = 1; k < matrix.length; j++, k++) {
                if (matrix[j][i] == matrix[k][i]) {
                    countRepeat++;
                } else {
                    break;
                }
            }
            if (countRepeat == matrix.length) {
                result.append(matrix[0][i]);
                countRepeat = 1;
            } else {
                break;
            }
        }

        return result.toString().trim();
    }

    public static String findPrefixNew(String[] strings) {

        StringBuilder result = new StringBuilder();


        for (int j = 0; j < strings[0].length(); j++) {
            char currentChar = strings[0].charAt(j);

            for (int i = 1; i < strings.length; i++) {
                if (currentChar != strings[i].charAt(j) && strings[i].length() <= j) {
                    return result.toString();
                }
            }

            result.append(currentChar);
        }

        return result.toString();
    }
}
