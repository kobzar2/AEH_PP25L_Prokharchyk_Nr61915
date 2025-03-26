package pl.pp;
import java.util.Scanner;
public class mojaCzwartaAplikacja2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.print("Podaj liczbe 1: ");
            if (!scanner.hasNextDouble()) {
                System.out.println("Niepoprawny input. Wprowadź liczbę.");
                scanner.next();
                continue; // Вернуться к началу цикла
            }
            double num1 = scanner.nextDouble();
            System.out.print("Wybierz operacje (+, -, *, /) lub 'Koniec': ");
            String operation = scanner.next();
            if (operation.equals("Koniec")) {
                System.out.println("Koniec");
            }
            System.out.print("Wybierz liczbe 2: ");
            double num2 = scanner.nextDouble();
            double result = 0;
            switch (operation) {
                case "+":
                    result = num1 + num2;
                    break;
                case "-":
                    result = num1 - num2;
                    break;
                case "*":
                    result = num1 * num2;
                    break;
                case "/":
                    if (num2 != 0) {
                        result = num1 / num2;
                    } else {
                        System.out.println("Blad");
                    }
                    break;
            }
            System.out.println(" " + num1 + " " + operation + " " + num2 + " = " + result);
            System.out.println();
        }
    }
}
