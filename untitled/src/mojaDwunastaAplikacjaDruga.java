import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Scanner;

public class mojaDwunastaAplikacjaDruga {

    /**
     * Counts the number of lines in a given text file.
     *
     * @param inputFilePath The path to the input text file.
     * @return The number of lines in the file, or -1 if the file cannot be read or found.
     */
    public static int countLinesInFile(String inputFilePath) {
        int lineCount = 0;
        try (BufferedReader reader = new BufferedReader(new FileReader(inputFilePath))) {
            while (reader.readLine() != null) {
                lineCount++;
            }
            return lineCount;
        } catch (IOException e) {
            System.err.println("Błąd podczas odczytu pliku: " + e.getMessage());
            return -1;
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String inputFilePath = "";
        Path inputPath;

        // Loop to get a valid input file path
        while (true) {
            System.out.print("Podaj ścieżkę do pliku tekstowego wejściowego: ");
            inputFilePath = scanner.nextLine();
            inputPath = Paths.get(inputFilePath);

            if (!Files.exists(inputPath)) {
                System.out.println("Plik '" + inputFilePath + "' nie istnieje. Proszę podać inną ścieżkę.");
            } else if (!Files.isRegularFile(inputPath)) {
                System.out.println("Ścieżka '" + inputFilePath + "' nie wskazuje na plik. Proszę podać inną ścieżkę.");
            } else {
                break; // Valid file found, exit loop
            }
        }

        System.out.print("Podaj ścieżkę do pliku wyjściowego (gdzie zostanie zapisany wynik): ");
        String outputFilePath = scanner.nextLine();

        int lineCount = countLinesInFile(inputFilePath);

        if (lineCount != -1) {
            System.out.println("\nPlik '" + inputFilePath + "' zawiera " + lineCount + " linii.");

            try (BufferedWriter writer = new BufferedWriter(new FileWriter(outputFilePath))) {
                // Get just the file name from the path
                Path fileNamePath = Paths.get(inputFilePath);
                String fileName = fileNamePath.getFileName().toString();

                writer.write("Nazwa pliku wejściowego: " + fileName);
                writer.newLine(); // Add a new line
                writer.write("Liczba linii: " + lineCount);
                System.out.println("Wynik został zapisany do pliku '" + outputFilePath + "'.");
            } catch (IOException e) {
                System.err.println("Błąd zapisu do pliku wyjściowego '" + outputFilePath + "': " + e.getMessage());
            }
        }

        scanner.close();
    }
}