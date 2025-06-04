package pl.pp;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public class mojaTrzynastaAplikacjaDruga {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Path inputFilePath = null;
        Path outputFilePath;


        while (true) {
            System.out.print("Podaj ścieżkę do pliku tekstowego wejściowego: ");
            String inputPathStr = scanner.nextLine();
            inputFilePath = Paths.get(inputPathStr);

            if (Files.exists(inputFilePath) && Files.isRegularFile(inputFilePath)) {
                break;
            } else {
                System.out.println("BŁĄD: Plik wejściowy nie istnieje lub nie jest prawidłowym plikiem. Spróbuj ponownie.");
            }
        }

        System.out.print("Podaj ścieżkę do pliku wyjściowego, gdzie będzie zapisany wynik: ");
        String outputPathStr = scanner.nextLine();
        outputFilePath = Paths.get(outputPathStr);

        try {
            processFile(inputFilePath, outputFilePath);
            System.out.println("\nPrzetwarzanie pliku zakończone pomyślnie.");
            System.out.println("Wyniki zostały zapisane do pliku: " + outputFilePath.toAbsolutePath());
        } catch (IOException e) {
            System.err.println("Wystąpił krytyczny błąd podczas przetwarzania plików: " + e.getMessage());
            e.printStackTrace();
        } finally {
            scanner.close();
        }
    }

    private static void processFile(Path inputPath, Path outputPath) throws IOException {
        List<String> allWordsInFile = new ArrayList<>();
        Map<String, Integer> wordFrequencies = new HashMap<>();


        try (BufferedReader reader = Files.newBufferedReader(inputPath)) {
            String line;
            while ((line = reader.readLine()) != null) {

                String[] wordsInLine = line.toLowerCase().split("[^\\p{L}\\p{N}]+");
                for (String word : wordsInLine) {
                    if (!word.isEmpty()) {
                        allWordsInFile.add(word);
                    }
                }
            }
        }
        long totalWordCount = allWordsInFile.size();
        for (String word : allWordsInFile) {
            wordFrequencies.put(word, wordFrequencies.getOrDefault(word, 0) + 1);
        }
        Map<String, Integer> sortedWordFrequencies = new TreeMap<>(wordFrequencies);

        System.out.println("\n--- Statystyki Pliku Wejściowego ---");
        System.out.println("Nazwa pliku: " + inputPath.getFileName());
        System.out.println("Liczba wszystkich słów: " + totalWordCount);

        System.out.println("\n--- Częstotliwość Wystąpień Słów ---");
        if (sortedWordFrequencies.isEmpty()) {
            System.out.println("W pliku nie znaleziono żadnych słów.");
        } else {
            for (Map.Entry<String, Integer> entry : sortedWordFrequencies.entrySet()) {
                System.out.println("'" + entry.getKey() + "': " + entry.getValue());
            }
        }

        try (BufferedWriter writer = Files.newBufferedWriter(outputPath)) {
            writer.write("Nazwa pliku wejściowego: " + inputPath.getFileName());
            writer.newLine();
            writer.write("Liczba wszystkich słów: " + totalWordCount);
            writer.newLine();
            writer.newLine();
            writer.write("--- Częstotliwość Wystąpień Słów ---");
            writer.newLine();

            if (sortedWordFrequencies.isEmpty()) {
                writer.write("W pliku nie znaleziono żadnych słów.");
                writer.newLine();
            } else {
                for (Map.Entry<String, Integer> entry : sortedWordFrequencies.entrySet()) {
                    writer.write("'" + entry.getKey() + "': " + entry.getValue());
                    writer.newLine();
                }
            }
        }
    }
}