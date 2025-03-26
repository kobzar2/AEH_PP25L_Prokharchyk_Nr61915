
import java.util.Scanner;
public class mojaCzwartaAplikacja {
    public static void main(String[] args) {
        mojaCzwartaAplikacja app = new mojaCzwartaAplikacja();
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.print("Podaj min i max limity:");
            int min = scanner.nextInt();
            int max = scanner.nextInt();
            if (min == max) {
                System.out.println("Koniec");
                break;
            }
            if (min >= max) {
                System.out.print("Max powinien byc wiekszy, niz Min. Sproboj ponownie.");
                break;
            }
            int square1 = min * min;
            int square2 = max * max;

            int sumaKwadratow = 0;
            for (int i = min; i <= max; i++) {
                int kwadrat = i * i;
                sumaKwadratow += kwadrat;
            }
            System.out.println("Kwadrat min: " +square1);
            System.out.println("Kwadrat max: " +square2);
            System.out.println("Kwadrat od min do max: "+sumaKwadratow);
        }
    }
}
