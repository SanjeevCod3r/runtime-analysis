import java.util.*;

public class DataStructureSearchComparison {

    private static final int SMALL_N = 1_000;
    private static final int MEDIUM_N = 100_000;
    private static final int LARGE_N = 1_000_000;

    // Helper method to generate test data
    private static int[] generateArray(int n) {
        int[] arr = new int[n];
        Random random = new Random();
        for (int i = 0; i < n; i++) {
            arr[i] = random.nextInt(n * 10); // Avoid duplicates
        }
        return arr;
    }

    // Linear Search in Array (O(N))
    public static boolean searchInArray(int[] arr, int target) {
        for (int num : arr) {
            if (num == target) {
                return true;
            }
        }
        return false;
    }

    // Measure search time in Array
    public static void testArraySearch(int[] arr, int target) {
        long start = System.nanoTime();
        boolean found = searchInArray(arr, target);
        long elapsedTime = System.nanoTime() - start;
        System.out.println("Array Search (O(N)) Time: " + (elapsedTime / 1_000_000) + " ms | Found: " + found);
    }

    // Measure search time in HashSet (O(1))
    public static void testHashSetSearch(HashSet<Integer> set, int target) {
        long start = System.nanoTime();
        boolean found = set.contains(target);
        long elapsedTime = System.nanoTime() - start;
        System.out.println("HashSet Search (O(1)) Time: " + (elapsedTime / 1_000_000) + " ms | Found: " + found);
    }

    // Measure search time in TreeSet (O(log N))
    public static void testTreeSetSearch(TreeSet<Integer> set, int target) {
        long start = System.nanoTime();
        boolean found = set.contains(target);
        long elapsedTime = System.nanoTime() - start;
        System.out.println("TreeSet Search (O(log N)) Time: " + (elapsedTime / 1_000_000) + " ms | Found: " + found);
    }

    public static void main(String[] args) {
        int[] sizes = {SMALL_N, MEDIUM_N, LARGE_N};

        for (int n : sizes) {
            System.out.println("\nTesting with N = " + n);
            int[] array = generateArray(n);
            HashSet<Integer> hashSet = new HashSet<>();
            TreeSet<Integer> treeSet = new TreeSet<>();

            // Populate HashSet and TreeSet
            for (int num : array) {
                hashSet.add(num);
                treeSet.add(num);
            }

            int target = array[n / 2]; // Pick a middle element as search target

            testArraySearch(array, target);
            testHashSetSearch(hashSet, target);
            testTreeSetSearch(treeSet, target);
        }
    }
}
