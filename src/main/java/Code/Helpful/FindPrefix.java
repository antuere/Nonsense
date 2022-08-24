package Code.Helpful;

import java.util.Date;

public class FindPrefix{
    public static void main(String[] args) {

        String[] words = {"Antonchic", "Antona", "Antos", "Antorn"};


        String result = findPrefix(words);

        String secResult = findPrefixNew(words);


        System.out.println(result + " - old");
        System.out.println(secResult + " - new");
    }

    public static String findPrefix(String[] strings) {
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

    public static String findPrefixNew(String[] strings) {

//        StringBuilder result = new StringBuilder();
//
//
//        for (int j = 0; j < strings[0].length(); j++) {
//            char currentChar = strings[0].charAt(j);
//
//            for (int i = 1; i < strings.length; i++) {
//                if (currentChar != strings[i].charAt(j) && strings[i].length() <= j) {
//                    return result.toString();
//                }
//            }
//
//            result.append(currentChar);
//        }
//
//        return result.toString();
//    }
        return null;
    }
}
