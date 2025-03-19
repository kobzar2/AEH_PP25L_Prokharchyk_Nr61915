package pl.pp;

import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.util.Locale;
import java.util.Scanner;

class mojaTrzeciaAplikacjaDruga {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        double fahrenheit;

       DecimalFormat df = new DecimalFormat("#.##", DecimalFormatSymbols.getInstance(Locale.US)); // Формат для двух знаков после запятой

        while (true) {
            System.out.print("Nipisz temperatur w skali Farenheit (-1 dla wyjscia): ");
            fahrenheit = scanner.nextDouble();

            if (fahrenheit == -1) {
                System.out.println("Wyjscie.");
                break;
            }

            double Celsius = (fahrenheit - 32) / 1.8;
            double Kelvin = Celsius + 273.16;

            System.out.println("Farenheit: " + df.format(fahrenheit) + "°F");
            System.out.println("Celsjusz: " + df.format(Celsius) + "°C");
            System.out.println("Kelwin: " + df.format(Kelvin) + " K");
        }

        scanner.close();
    }
}
