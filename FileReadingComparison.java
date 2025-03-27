import java.io.*;

public class FileReadingComparison {

    private static final String FILE_PATH = "large_file.txt"; 

    // Using FileReader (Character Stream) - Reads character by character (O(N))
    public static void readUsingFileReader(String filePath) {
        long start = System.nanoTime();
        try (FileReader fileReader = new FileReader(filePath)) {
            while (fileReader.read() != -1) {
                // Reading character by character (slow)
            }
        } catch (IOException e) {
            System.out.println("Error reading file using FileReader: " + e.getMessage());
        }
        long elapsedTime = System.nanoTime() - start;
        System.out.println("FileReader Time: " + (elapsedTime / 1_000_000) + " ms");
    }

    // Using InputStreamReader (Byte Stream) - Reads bytes and converts to characters (O(N))
    public static void readUsingInputStreamReader(String filePath) {
        long start = System.nanoTime();
        try (InputStreamReader inputStreamReader = new InputStreamReader(new FileInputStream(filePath))) {
            while (inputStreamReader.read() != -1) {
                // Reading character by character, but from byte stream (faster)
            }
        } catch (IOException e) {
            System.out.println("Error reading file using InputStreamReader: " + e.getMessage());
        }
        long elapsedTime = System.nanoTime() - start;
        System.out.println("InputStreamReader Time: " + (elapsedTime / 1_000_000) + " ms");
    }

    public static void main(String[] args) {
        System.out.println("Comparing FileReader vs. InputStreamReader Performance\n");

        System.out.println("Reading a large file...");
        readUsingFileReader(FILE_PATH);
        readUsingInputStreamReader(FILE_PATH);
    }
}
