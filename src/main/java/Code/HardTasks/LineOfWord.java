package Code.HardTasks;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

public class LineOfWord {
    public static void main(String[] args) throws IOException {
        Scanner scanner = new Scanner(System.in);
        String fileName = scanner.nextLine();
        ArrayList<String> words = new ArrayList<>();
        BufferedReader bufferedReader = new BufferedReader(new FileReader(fileName));

        while (bufferedReader.ready()) {
            words.addAll(List.of(bufferedReader.readLine().split(" ")));
        }
        StringBuilder result = getLine(getWords(words));
        System.out.println(result.toString());
    }

    public static StringBuilder getLine(String... words) {
        // можно доработать, работает не всегда
        ArrayList<String> wordsList = new ArrayList<>(Arrays.stream(words).toList());
        ArrayList<String> copy = new ArrayList<>(wordsList);
        int countWords = 1;
        Collections.sort(wordsList);
        Collections.sort(copy);
        StringBuilder result = null;
        String cuurentWord = null;
        for (int i = 0; i < copy.size(); i++) {
            if (cuurentWord == null && result == null){
                cuurentWord = copy.get(i);
                result = new StringBuilder(cuurentWord + " ");
            }
            for (int j = 0; j < wordsList.size(); j++){
                String currentChar = String.valueOf(cuurentWord.charAt(cuurentWord.length() - 1));
                String nextWord = wordsList.get(j);
                String nextChar = String.valueOf(nextWord.charAt(0));
                if (currentChar.equalsIgnoreCase(nextChar) && !cuurentWord.equals(nextWord)){
                    result.append(nextWord + " ");
                    wordsList.remove(cuurentWord);
                    cuurentWord = nextWord;
                    j = -1;
                    countWords++;
                }
            }
            if (countWords != copy.size()){
                countWords = 1;
                cuurentWord = null;
                result = null;
                wordsList = new ArrayList<>(copy);
            }

        }
        System.out.println(countWords);
        return result;
    }

    private static String[] getWords(List<String> list) {
        String[] array = new String[list.size()];
        for (int i = 0; i < list.size(); i++) {
            array[i] = list.get(i);
        }
        return array;
    }
}
