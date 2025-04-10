package pl.pp;
import java.util.Scanner;

public class Lab_6_1 {

    public static long obliczSilnieIteracyjnie(int n) {
        if (n < 0) {
            throw new IllegalArgumentException("Silnia nie jest zdefiniowana dla liczb ujemnych.");
        }
        if (n == 0) {
            return 1;
        }
        long wynik = 1;
        for (int i = 1; i <= n; i++) {
            wynik *= i;
        }
        return wynik;
    }

    public static long obliczSilnieRekurencyjnie(int n) {
        if (n < 0) {
            throw new IllegalArgumentException("Silnia nie jest zdefiniowana dla liczb ujemnych.");
        }
        if (n == 0) {
            return 1;
        } else {
            return n * obliczSilnieRekurencyjnie(n - 1);
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Podaj nieujemną liczbę całkowitą N: ");
        int n = scanner.nextInt();

        long startTimeIteracyjny = System.nanoTime();
        long silniaIteracyjna = obliczSilnieIteracyjnie(n);
        long endTimeIteracyjny = System.nanoTime();
        long czasWykonaniaIteracyjny = endTimeIteracyjny - startTimeIteracyjny;

        // Pomiar czasu wykonania metody rekurencyjnej
        long startTimeRekurencyjny = System.nanoTime();
        long silniaRekurencyjna = obliczSilnieRekurencyjnie(n);
        long endTimeRekurencyjny = System.nanoTime();
        long czasWykonaniaRekurencyjny = endTimeRekurencyjny - startTimeRekurencyjny;

        System.out.println("Dla liczby N = " + n + ":");
        System.out.println("Silnia (iteracyjnie): " + silniaIteracyjna + ", czas wykonania: " + czasWykonaniaIteracyjny + " nanosekund");
        System.out.println("Silnia (rekurencyjnie): " + silniaRekurencyjna + ", czas wykonania: " + czasWykonaniaRekurencyjny + " nanosekund");

        scanner.close();
    }
}