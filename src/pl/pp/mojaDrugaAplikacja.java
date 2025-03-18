package pl.pp;
import java.io.InputStream;
import java.util.Scanner;
public class mojaDrugaAplikacja {

        public static void main(String[] args) {
            Scanner scanner = new Scanner(System.in);

            System.out.print("Podaj swój wiek w latach: ");
            int wiekWLatach = scanner.nextInt();

            long wiekWSekundach = (long) wiekWLatach * 365 * 24 * 60 * 60;

            System.out.println("Twój wiek w sekundach wynosi: " + wiekWSekundach);

            scanner.close();
        }
    }