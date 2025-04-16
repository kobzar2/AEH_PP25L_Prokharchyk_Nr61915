package pl.pp;

public class Person {
 public String forename;
 public String surname;
 public int age;
 public String address; // Dodane pole adres
 public int birthYear;  // Dodane pole rok urodzenia

 public Person() {
  // Konstruktor domyślny
 }

 public Person(String initForename, String initSurname, int initAge, String initAddress, int initBirthYear) {
  forename = initForename;
  surname = initSurname;
  age = initAge;
  address = initAddress;
  birthYear = initBirthYear;
 }

 public void hiToAll() {
  System.out.println("Nazywam się " + forename + " " + surname + ". Mam " + age + " lat.");
  System.out.println("Mieszkam pod adresem: " + address + ". Urodziłem/am się w roku: " + birthYear + ".");
 }

 // Zmodyfikowana metoda growOld() przyjmuje argument increaseAge
 public int growOld(int increaseAge) {
  age = age + increaseAge;
  return age;
 }

 public String getName() {
  return forename;
 }

 public void setName(String nameToSet) {
  forename = nameToSet;
 }

 // Dodana metoda beYounger() zmniejszająca wiek o 1
 public int beYounger() {
  age = age - 1;
  return age;
 }

 // Dodane metody do ustawiania i pobierania nowych pól (opcjonalnie, ale dobra praktyka)
 public String getAddress() {
  return address;
 }

 public void setAddress(String addressToSet) {
  address = addressToSet;
 }

 public int getBirthYear() {
  return birthYear;
 }

 public void setBirthYear(int birthYearToSet) {
  birthYear = birthYearToSet;
 }
}