import java.util.Arrays;
import java.util.Random;

public class SortingComparison {

    // Bubble Sort - O(N²)
    public static void bubbleSort(int[] arr) {
        int n = arr.length;
        boolean swapped;
        for (int i = 0; i < n - 1; i++) {
            swapped = false;
            for (int j = 0; j < n - i - 1; j++) {
                if (arr[j] > arr[j + 1]) {
                    // Swap elements
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                    swapped = true;
                }
            }
            // If no two elements were swapped in inner loop, break
            if (!swapped) break;
        }
    }

    // Merge Sort - O(N log N)
    public static void mergeSort(int[] arr, int left, int right) {
        if (left < right) {
            int mid = left + (right - left) / 2;
            mergeSort(arr, left, mid);
            mergeSort(arr, mid + 1, right);
            merge(arr, left, mid, right);
        }
    }

    private static void merge(int[] arr, int left, int mid, int right) {
        int n1 = mid - left + 1;
        int n2 = right - mid;

        int[] leftArr = Arrays.copyOfRange(arr, left, mid + 1);
        int[] rightArr = Arrays.copyOfRange(arr, mid + 1, right + 1);

        int i = 0, j = 0, k = left;
        while (i < n1 && j < n2) {
            arr[k++] = (leftArr[i] <= rightArr[j]) ? leftArr[i++] : rightArr[j++];
        }

        while (i < n1) arr[k++] = leftArr[i++];
        while (j < n2) arr[k++] = rightArr[j++];
    }

    // Quick Sort - O(N log N)
    public static void quickSort(int[] arr, int low, int high) {
        if (low < high) {
            int pivot = partition(arr, low, high);
            quickSort(arr, low, pivot - 1);
            quickSort(arr, pivot + 1, high);
        }
    }

    private static int partition(int[] arr, int low, int high) {
        int pivot = arr[high];
        int i = low - 1;
        for (int j = low; j < high; j++) {
            if (arr[j] < pivot) {
                i++;
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
            }
        }
        int temp = arr[i + 1];
        arr[i + 1] = arr[high];
        arr[high] = temp;
        return i + 1;
    }

    // Helper function to generate a random dataset
    public static int[] generateDataset(int size) {
        Random rand = new Random();
        int[] dataset = new int[size];
        for (int i = 0; i < size; i++) {
            dataset[i] = rand.nextInt(size * 10);
        }
        return dataset;
    }

    // Measure sorting performance
    public static void measurePerformance(int size) {
        int[] dataset1 = generateDataset(size);
        int[] dataset2 = Arrays.copyOf(dataset1, dataset1.length);
        int[] dataset3 = Arrays.copyOf(dataset1, dataset1.length);

        System.out.println("\nDataset Size: " + size);

        // Bubble Sort
        long start = System.nanoTime();
        bubbleSort(dataset1);
        long bubbleTime = System.nanoTime() - start;
        System.out.println("Bubble Sort Time: " + (bubbleTime / 1_000_000) + " ms");

        // Merge Sort
        start = System.nanoTime();
        mergeSort(dataset2, 0, dataset2.length - 1);
        long mergeTime = System.nanoTime() - start;
        System.out.println("Merge Sort Time: " + (mergeTime / 1_000_000) + " ms");

        // Quick Sort
        start = System.nanoTime();
        quickSort(dataset3, 0, dataset3.length - 1);
        long quickTime = System.nanoTime() - start;
        System.out.println("Quick Sort Time: " + (quickTime / 1_000_000) + " ms");
    }

    public static void main(String[] args) {
        int[] sizes = {1_000, 10_000, 100_000}; // Dataset sizes
        for (int size : sizes) {
            measurePerformance(size);
        }
    }
}
