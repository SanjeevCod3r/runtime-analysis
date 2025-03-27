import java.util.Arrays;
import java.util.Random;

public class SearchComparison {
    
    // Linear Search - O(N)
    public static int linearSearch(int[] arr, int target) {
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == target) {
                return i;
            }
        }
        return -1;
    }

    // Binary Search - O(log N)
    public static int binarySearch(int[] arr, int target) {
        int left = 0, right = arr.length - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (arr[mid] == target) {
                return mid;
            } else if (arr[mid] < target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return -1;
    }

    // Helper function to generate random dataset
    public static int[] generateDataset(int size) {
        Random rand = new Random();
        int[] dataset = new int[size];
        for (int i = 0; i < size; i++) {
            dataset[i] = rand.nextInt(size * 10);  // Random numbers within range
        }
        return dataset;
    }

    // Measure performance
    public static void measurePerformance(int size) {
        int[] dataset = generateDataset(size);
        int target = dataset[new Random().nextInt(size)];  // Pick a random element as target

        // Linear Search
        long start = System.nanoTime();
        linearSearch(dataset, target);
        long linearTime = System.nanoTime() - start;

        // Sorting before Binary Search
        Arrays.sort(dataset);
        start = System.nanoTime();
        binarySearch(dataset, target);
        long binaryTime = System.nanoTime() - start;

        // Print results
        System.out.printf("Dataset Size: %d | Linear Search: %d ns | Binary Search (incl. sort): %d ns%n",
                size, linearTime, binaryTime);
    }

    public static void main(String[] args) {
        int[] sizes = {1_000, 10_000, 1_000_000}; // Dataset sizes
        for (int size : sizes) {
            measurePerformance(size);
        }
    }
}
