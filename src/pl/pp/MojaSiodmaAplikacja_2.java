package pl.pp;
class mojaSiodmaAplikacja_2 {
 public static void main(String[] args) {
  Person person1 = new Person("Mateusz", "Karmazyn", 24, "ul. Kwiatowa 10, Warszawa", 2001);
  person1.hiToAll();

  person1.growOld(5); // Zwiększ wiek o 5
  System.out.println("Wiek po postarzeniu: " + person1.age);

  person1.beYounger(); // Zmniejsz wiek o 1
  System.out.println("Wiek po odmłodzeniu: " + person1.age);

  person1.setAddress("al. Niepodległości 50, Kraków");
  System.out.println("Nowy adres: " + person1.getAddress());
 }
}