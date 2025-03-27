public class FibonacciComparison {

    // Recursive Fibonacci (O(2^N)) - Exponential time complexity
    public static int fibonacciRecursive(int n) {
        if (n <= 1) return n;
        return fibonacciRecursive(n - 1) + fibonacciRecursive(n - 2);
    }

    // Iterative Fibonacci (O(N)) - Linear time complexity
    public static int fibonacciIterative(int n) {
        if (n <= 1) return n;
        int a = 0, b = 1, sum;
        for (int i = 2; i <= n; i++) {
            sum = a + b;
            a = b;
            b = sum;
        }
        return b;
    }

    // Measure execution time of recursive method
    public static void testRecursive(int n) {
        System.out.println("Calculating Fibonacci(" + n + ") using recursion...");
        long start = System.nanoTime();
        int result = fibonacciRecursive(n);
        long elapsedTime = System.nanoTime() - start;
        System.out.println("Recursive Fibonacci Result: " + result);
        System.out.println("Execution Time: " + (elapsedTime / 1_000_000) + " ms\n");
    }

    // Measure execution time of iterative method
    public static void testIterative(int n) {
        System.out.println("Calculating Fibonacci(" + n + ") using iteration...");
        long start = System.nanoTime();
        int result = fibonacciIterative(n);
        long elapsedTime = System.nanoTime() - start;
        System.out.println("Iterative Fibonacci Result: " + result);
        System.out.println("Execution Time: " + (elapsedTime / 1_000_000) + " ms\n");
    }

    public static void main(String[] args) {
        int smallN = 10, mediumN = 30, largeN = 50;

        testRecursive(smallN);
        testIterative(smallN);

        testRecursive(mediumN);
        testIterative(mediumN);

        System.out.println("Recursive Fibonacci skipped for N = " + largeN + " (Too slow)");
        testIterative(largeN);
    }
}
