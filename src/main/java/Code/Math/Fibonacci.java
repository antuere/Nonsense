package Code.Math;

import java.util.stream.Stream;

public class Fibonacci {

    public static void main(String[] args) {
        Fibonacci solution = new Fibonacci();

//        System.out.println(solution.fibonacci(9));
//        System.out.println(solution.fibonacci(5));
//        System.out.println(solution.fibonacci(2));
//        System.out.println(solution.fibonacci(1));

        int limit = 10;
        int n = 8;
        int result = Stream.iterate(new int[]{0, 1}, arg -> new int[]{arg[1], arg[0] + arg[1]})
                .limit(limit)
                .map(x -> x[0]).toList().get(n);

        System.out.println(result);
    }


    public int fibonacci(int n) {
        if (n == 0) {
            return 0;
        } else if (n == 1) {
            return 1;
        } else {
            return fibonacci(n - 1) + fibonacci(n - 2);
        }

    }
}
