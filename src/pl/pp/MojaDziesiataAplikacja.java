package pl.pp;

import java.util.*;

public class MojaDziesiataAplikacja {
        public static void main(String[] args) {
                // Deklaracje tablic - przykładowo
                int[] a = new int[100]; // tablica int o nazwie a zawierająca 100 elementów
                long b[] = new long[10]; // tablica long o nazwie b zawierająca 10 elementów
                String[] c = new String[5]; // tablica String o nazwie c zawierająca 5 elementów
                c[0] = "Test 0"; // wpisanie łańcucha znaków "Test" do pierwszego elementu tablicy c
                c[3] = "Test 3"; // wpisanie łańcucha znaków "Test" do pierwszego elementu tablicy c

                System.out.println(c[0]); // wypisanie do konsoli wcześniej wpisanego łańcucha znaków

                // Tablice można wypełnić w pętli
                for (var i = 0; i < 100; i++) {
                        a[i] = i; // wypełnienie  tablicy a wartościami od 0 do 99
                }
                for (var i = 0; i < 100; i++) {
                        System.out.println(a[i]); // wypisanie do konsoli wszystkich elementów tablicy a
                }

                // Nie zawsze trzeba znać długość tablicy - można skorzystać z właściwości length
                for (var i = 0; i < c.length; i++) {
                        System.out.println(c[i]);
                }
                // Można też wykonać pętle dla każdego elementu w wersji pętli foreach
                System.out.println("==================================================");
                for (var element : c) {
                        System.out.println(element);
                }

                // Są też bardziej zaawansowane struktury danych - tzw. kolekcje (listy, zbiory, mapa - słownik
                // Listy
                System.out.println("LISTY");
                List<Integer> list1 = new ArrayList<>();
                list1.add(1);
                list1.add(2);
                list1.add(3);

                List<Integer> list2 = new ArrayList<>();
                list2.add(4);
                list2.add(0, 5);  // liczba 5 trafia na początek listy nr 2
                list1.addAll(2, list2); // do listy 1 dodaję listę 2, od trzeciej pozycji (czyli po kolei: 1,2,5,4,3)

                // Elementy listy można wyświetlić w pętli, np. foreach
                for (var element : list1) {
                        System.out.println(element);
                }
                // Można się odwołać do poszczególnych elementów listy
                System.out.println(list1.get(0));
                System.out.println(list1.get(3));

                // Można wyświetlić indeks konkretnej wartości albo ją usunąć albo obliczyć wielkość
                System.out.println("Pozycja liczby 3 to: " + list1.indexOf(3)); // indeksy numerowane są od zera
                list1.remove(2); // usunięcie trzeciego elementu
                System.out.println("Pozycja liczby 3 to: " + list1.indexOf(3));

                list1.set(0, 10); // zamieniam pierwszy element na 10
                System.out.println("Pierwszy element kolekcji: " + list1.get(0));

                System.out.println("Liczba elementów przed czyszczeniem: " + list1.size());
                list1.clear(); // wyczyszczenie listy
                System.out.println("Liczba elementów po czyszczeniu: " + list1.size());

                //Zbiory
                System.out.println("ZBIORY");
                Set<Integer> set1 = new TreeSet<>();
                Set<Integer> set2 = new HashSet<>();

                set1.add(1);  // dodawanie elementów
                set1.add(2);
                set1.add(3);

                set2.add(5);
                set2.add(4);

                set1.addAll(set2); // łączenie kolekcji

                System.out.println("Elementy: ");
                for (var element : set1) {
                        System.out.println(element);
                }

                System.out.println("Liczba elementów: " + set1.size());
                set1.remove(2); // usunięcie liczby dwa!
                System.out.println("Liczba elementów: " + set1.size());

                set1.clear();
                System.out.println("Liczba elementów: " + set1.size());

                // Mapy
                System.out.println("MAPY");
                Map<Integer, String> map1 = new TreeMap<>();
                Map<Integer, String> map2 = new HashMap<>();

                map1.put(1, "jeden");  // dodawanie elementów
                map1.put(2, "dwa");
                map1.put(3, "trzy");

                map2.put(5, "pięć");
                map2.put(4, "cztery");

                map1.putAll(map2); // łączenie kolekcji

                System.out.println("Klucze: ");
                for (var key : map1.keySet()) {
                        System.out.println(key);
                }

                System.out.println("Wartości: ");
                for (var value : map1.values()) {
                        System.out.println(value);
                }

                System.out.println("Pary: ");
                for (var entry : map1.entrySet()) {
                        System.out.println(entry.getKey() + " -> " + entry.getValue());
                }

                System.out.println("Liczba elementów: " + map1.size());
                map1.remove(2); // usunięcie pary pod kluczem dwa!
                System.out.println("Liczba elementów: " + map1.size());

                map1.clear();
                System.out.println("Liczba elementów: " + map1.size());
        }
}