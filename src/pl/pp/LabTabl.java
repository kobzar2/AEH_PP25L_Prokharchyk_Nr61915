package pl.pp;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Random;
import java.util.Scanner;
import java.util.Set;
public class LabTabl {
 public static void main(String[] args) {
  int[] tablica1 = new int[6];
  int[] tablica2 = new int[6];
  Random random = new Random();
  Set<Integer> wylosowaneLiczby = new HashSet<>();
  System.out.println("Losowanie 6 unikalnych liczb do pierwszej tablicy...");
  for (int i = 0; i < tablica1.length; i++) {
   int wylosowana;
   do {
    wylosowana = random.nextInt(49) + 1;
   } while (wylosowaneLiczby.contains(wylosowana));
   tablica1[i] = wylosowana;
   wylosowaneLiczby.add(wylosowana);
   System.out.print(tablica1[i] + " ");
  }
  System.out.println();
  wylosowaneLiczby.clear();
  Scanner scanner = new Scanner(System.in);
  System.out.println("\nPodaj 6 różnych liczb z przedziału od 1 do 49 dla drugiej tablicy:");
  for (int i = 0; i < tablica2.length; i++) {
   int liczbaOdUzytkownika;
   while (true) {
    System.out.print("Podaj liczbę " + (i + 1) + ": ");
    if (scanner.hasNextInt()) {
     liczbaOdUzytkownika = scanner.nextInt();
     if (liczbaOdUzytkownika >= 1 && liczbaOdUzytkownika <= 49) {
      if (!wylosowaneLiczby.contains(liczbaOdUzytkownika)) {
       tablica2[i] = liczbaOdUzytkownika;
       wylosowaneLiczby.add(liczbaOdUzytkownika);
       break;
      } else {
       System.out.println("Ta liczba już została podana. Podaj inną.");
      }
     } else {
      System.out.println("Podana liczba jest spoza zakresu (1-49). Spróbuj ponownie.");
     }
    } else {
     System.out.println("To nie jest poprawna liczba. Spróbuj ponownie.");
     scanner.next();
    }
   }
  }
  scanner.close();
  System.out.println("\nZawartość pierwszej tablicy: " + Arrays.toString(tablica1));
  System.out.println("Zawartość drugiej tablicy: " + Arrays.toString(tablica2));
  int licznikPowtorzen = 0;
  for (int liczba1 : tablica1) {
   for (int liczba2 : tablica2) {
    if (liczba1 == liczba2) {
     licznikPowtorzen++;
     break;
    }
   }
  }
  System.out.println("\nLiczba powtarzających się liczb w obu tablicach: " + licznikPowtorzen);
 }
}