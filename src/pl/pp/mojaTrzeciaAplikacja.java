package pl.pp;
import java.util.Scanner;
public class mojaTrzeciaAplikacja {
        public static void main(String[] args) {
            mojaTrzeciaAplikacja app = new mojaTrzeciaAplikacja();
            Scanner scanner = new Scanner(System.in);
            System.out.print("Prosze podacz ilosc dni: ");
                    int days = scanner.nextInt();
                if (days < 0) {
                    System.out.println("Koniec");
                    return;
                }

                int weeks = days / 7;
                int remainingDays = days % 7;

                System.out.println(days + " dni to " + weeks + " tygodni i " + remainingDays + " dni.");
                }
}

