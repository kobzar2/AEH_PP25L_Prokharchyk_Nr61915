package pl.pp;
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.*;
public class mojaCzternastaAplikacja {
        public static void main(String[] args) {
            System.out.println("--- Tworzenie i testowanie pojazdów ---");

            Osobowe autoBenzynowe = new Osobowe("WA1234B", "VINAUTO001", "Czerwony", 65000,
                    7.5, 40.0, 15000, 5, RodzajPaliwa.BENZYNA);

            Osobowe autoElektryczne = new Osobowe("EL007EV", "VINAUTO002", "Biały Perłowy", 125000,
                    18.0, 50.0, 5200, 5, RodzajPaliwa.ELEKTRYK);

            Ciezarowka tirDiesel = new Ciezarowka("WGM555TR", "VINTIR001", "Niebieski Metalik", 280000,
                    30.0, 200.0, 350000, 24.5, RodzajPaliwa.DIESEL);

            Motocykl motocyklSportowy = new Motocykl("SCZ01MS", "VINMOTO001", "Czarny Mat", 32000,
                    4.2, 10.0, 8300, false, RodzajPaliwa.BENZYNA);

            SprzetBudowlany koparka = new SprzetBudowlany("BUD001EX", "VINKOP001", "Żółty", 190000,
                    10.5, 80.0, 510, 1250.5, RodzajPaliwa.DIESEL);

            // Wyświetlanie informacji początkowych
            System.out.println("\n*** Stan początkowy pojazdów ***");
            autoBenzynowe.wyswietlInformacje();
            autoElektryczne.wyswietlInformacje();
            tirDiesel.wyswietlInformacje();
            motocyklSportowy.wyswietlInformacje();
            koparka.wyswietlInformacje();

            System.out.println("\n--- Testowanie metod dla poszczególnych pojazdów ---");

            // Testy dla samochodu osobowego (benzyna)
            System.out.println("\n>>> Testy dla: " + autoBenzynowe.getNrRejestracyjny() + " (" + autoBenzynowe.getTypPaliwa().getOpis() + ")");
            autoBenzynowe.prowadz(100);      // Zużyje 7.5L, zostanie 32.5L
            autoBenzynowe.zatankuj(20);      // Będzie 52.5L
            autoBenzynowe.prowadz(800);      // Potrzebuje 60L. Za mało.
            autoBenzynowe.prowadz(600);      // Potrzebuje 45L. Wystarczy. Zostanie 7.5L.
            autoBenzynowe.wyswietlInformacje();

            // Testy dla samochodu elektrycznego
            System.out.println("\n>>> Testy dla: " + autoElektryczne.getNrRejestracyjny() + " (" + autoElektryczne.getTypPaliwa().getOpis() + ")");
            autoElektryczne.prowadz(100);    // Zużyje 18kWh, zostanie 32kWh
            autoElektryczne.zatankuj(30);    // Będzie 62kWh (zatankuj oznacza tu naładuj)
            autoElektryczne.prowadz(300);    // Potrzebuje 54kWh. Wystarczy. Zostanie 8kWh.
            autoElektryczne.wyswietlInformacje();

            // Testy dla ciężarówki
            System.out.println("\n>>> Testy dla: " + tirDiesel.getNrRejestracyjny() + " (" + tirDiesel.getTypPaliwa().getOpis() + ")");
            tirDiesel.prowadz(500);        // Zużyje 150L, zostanie 50L
            tirDiesel.zatankuj(250);       // Będzie 300L
            tirDiesel.wyswietlInformacje();

            // Testy dla motocykla
            System.out.println("\n>>> Testy dla: " + motocyklSportowy.getNrRejestracyjny() + " (" + motocyklSportowy.getTypPaliwa().getOpis() + ")");
            motocyklSportowy.prowadz(300);   // Potrzebuje 12.6L. Za mało (ma 10L).
            motocyklSportowy.zatankuj(5);    // Ma 15L
            motocyklSportowy.prowadz(300);   // Teraz wystarczy. Zostanie 2.4L.
            motocyklSportowy.wyswietlInformacje();

            // Testy dla sprzętu budowlanego
            System.out.println("\n>>> Testy dla: " + koparka.getNrRejestracyjny() + " (" + koparka.getTypPaliwa().getOpis() + ")");
            koparka.prowadz(10);           // Jazda: Zużyje 1.05L
            koparka.dodajPrzepracowaneGodziny(5.5); // Praca
            koparka.dodajPrzepracowaneGodziny(-2); // Błędna wartość
            koparka.zatankuj(20);
            koparka.wyswietlInformacje();

            // Demonstracja pobierania typu paliwa
            System.out.println("\n--- Demonstracja metody getTypPaliwa ---");
            Pojazd[] pojazdy = {autoBenzynowe, autoElektryczne, tirDiesel, motocyklSportowy, koparka};
            for (Pojazd p : pojazdy) {
                if (p instanceof TypPaliwa) {
                    TypPaliwa tp = (TypPaliwa) p;
                    System.out.println("Pojazd " + p.getNrRejestracyjny() + " używa paliwa typu: " + tp.getTypPaliwa() + " (" + tp.getTypPaliwa().getOpis() + ")");
                }
            }
        }
    }