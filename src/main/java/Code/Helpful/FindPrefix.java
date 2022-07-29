package Code.Helpful;

import java.util.Date;

public class FindPrefix {
    public static void main(String[] args) {

        String[] words = {"Anton", "nton", "Antos", "Antrn"};


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

        int countRepeat = 1;

        for (int i = 0; i < strings[0].length(); i++) {
            for (int j = 0, k = 1; k < strings.length; j++, k++) {

                if (strings[j].charAt(i) == strings[k].charAt(i)) {
                    countRepeat++;
                } else {
                    break;
                }
            }
            if (countRepeat == strings.length) {
                result.append(strings[0].charAt(i));
                countRepeat = 1;
            } else {
                break;
            }
        }

        return result.toString().trim();
    }
}
