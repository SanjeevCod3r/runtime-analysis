public class StringConcatenationComparison {

    private static final int SMALL_N = 1_000;
    private static final int MEDIUM_N = 10_000;
    private static final int LARGE_N = 1_000_000;

    // Measure performance of String concatenation (O(N²))
    public static void testStringConcatenation(int n) {
        long start = System.nanoTime();
        String str = "";
        for (int i = 0; i < n; i++) {
            str += "A"; // Creates a new String object every iteration (very slow)
        }
        long timeElapsed = System.nanoTime() - start;
        System.out.println("String (O(N²)) Time for " + n + ": " + (timeElapsed / 1_000_000) + " ms");
    }

    // Measure performance of StringBuilder (O(N))
    public static void testStringBuilder(int n) {
        long start = System.nanoTime();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < n; i++) {
            sb.append("A"); // Efficient, mutable (fast)
        }
        long timeElapsed = System.nanoTime() - start;
        System.out.println("StringBuilder (O(N)) Time for " + n + ": " + (timeElapsed / 1_000_000) + " ms");
    }

    // Measure performance of StringBuffer (O(N))
    public static void testStringBuffer(int n) {
        long start = System.nanoTime();
        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < n; i++) {
            sb.append("A"); // Thread-safe but slightly slower
        }
        long timeElapsed = System.nanoTime() - start;
        System.out.println("StringBuffer (O(N)) Time for " + n + ": " + (timeElapsed / 1_000_000) + " ms");
    }

    public static void main(String[] args) {
        int[] sizes = {SMALL_N, MEDIUM_N, LARGE_N}; // Different dataset sizes

        for (int size : sizes) {
            System.out.println("\nTesting with N = " + size);
            if (size <= 10_000) {
                testStringConcatenation(size); // Avoid running String test for large N
            } else {
                System.out.println("String (O(N²)) skipped for N = " + size + " (Too slow)");
            }
            testStringBuilder(size);
            testStringBuffer(size);
        }
    }
}
