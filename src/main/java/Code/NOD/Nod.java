package Code.NOD;


import java.util.Scanner;

public class Nod {
    public static void main(String[] args) throws Exception {
        Scanner scanner = new Scanner(System.in);
        int first = scanner.nextInt();
        int second = scanner.nextInt();
        int NOD = 0;
        for (int i = 1; i < 1000; i++){
            if (first % i == 0 && second % i == 0){
                NOD = i;
            }
        }
        System.out.println(NOD);

    }
}