package TimeComplaxity;

public class FibonacciIterative {
    public static int fibonacci(int n) {
        int a = 0, b = 1, sum;
        for (int i = 2; i <= n; i++) {
            sum = a + b;
            a = b;
            b = sum;
        }
        return b;
    }

    public static void main(String[] args) {
        int n = 30; // Test with a large number
        System.out.println(fibonacci(n));
    }
}
