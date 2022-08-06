package Code.Math;

public class Sqrt {
    public static void main(String[] args) {
        Sqrt sqrt = new Sqrt();


    }

    public int sqrt(int number) {
        int low = 0;
        int high = number;
        while (low <= high) {
            int mid = low + (high - low) / 2;
            int sqrtMid = mid * mid;
            if (sqrtMid == number) {
                return mid;
            }
            if (sqrtMid > number) {
                high = mid - 1;
            }
            if (sqrtMid < number) {
                low = mid + 1;
            }
        }
        return low - 1;
    }
}
