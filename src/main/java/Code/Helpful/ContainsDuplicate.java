package Code.Helpful;

import java.util.Arrays;
import java.util.Set;
import java.util.stream.Collectors;

public class ContainsDuplicate {
    public static void main(String[] args) {
        int[] test1 = {1, 2, 3, 4, 5};
        int[] test2 = {1, 2, 5, 4, 5};

        System.out.println(isDuplicate(test1));
        System.out.println(isDuplicate(test2));
    }

    public static boolean isDuplicate(int[] array) {
        Set<Integer> temp = Arrays.stream(array).boxed().collect(Collectors.toSet());
        return temp.size() != array.length;

    }
}
