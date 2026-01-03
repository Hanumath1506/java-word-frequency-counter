import java.io.*;
import java.util.*;
import java.util.Map.Entry;

public class WordFrequency {
    public static void main(String[] args) {
        String filePath = " "; // Enter the file path

        try {
            // Read the file and process words
            BufferedReader reader = new BufferedReader(new FileReader(filePath));
            HashMap<String, Integer> wordMap = new HashMap<>();
            String line;

            while ((line = reader.readLine()) != null) {
                String[] words = line.toLowerCase().split("\\W+"); // Split words, ignore punctuation
                for (String word : words) {
                    if (!word.isEmpty()) {
                        wordMap.put(word, wordMap.getOrDefault(word, 0) + 1);
                    }
                }
            }
            reader.close();

            // Display the HashMap contents
            System.out.println("Word Frequency Map:");
            for (Map.Entry<String, Integer> entry : wordMap.entrySet()) {
                System.out.println(entry.getKey() + ": " + entry.getValue());
            }

            // Convert the map to a set and then an array
            Set<Entry<String, Integer>> entrySet = wordMap.entrySet();
            Entry<String, Integer>[] entryArray = entrySet.toArray(new Entry[0]);

            // Sort by key (alphabetical order)
            Arrays.sort(entryArray, Comparator.comparing(Entry::getKey));
            System.out.println("\nSorted by Key:");
            for (Entry<String, Integer> entry : entryArray) {
                System.out.println(entry.getKey() + ": " + entry.getValue());
            }

            // Sort by frequency (descending order)
            Arrays.sort(entryArray, (a, b) -> b.getValue().compareTo(a.getValue()));
            System.out.println("\nSorted by Frequency (Descending):");
            for (Entry<String, Integer> entry : entryArray) {
                System.out.println(entry.getKey() + ": " + entry.getValue());
            }
        } catch (FileNotFoundException e) {
            System.out.println("Error: File not found at path: " + filePath);
        } catch (IOException e) {
            System.out.println("Error: An I/O error occurred while processing the file.");
        } catch (Exception e) {
            System.out.println("An unexpected error occurred: " + e.getMessage());
        }
    }
}
