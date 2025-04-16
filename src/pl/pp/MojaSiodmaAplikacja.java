package pl.pp;
public class MojaSiodmaAplikacja { // Można rozważyć zmianę nazwy na bardziej opisową, np. MainApp
 public static void main(String[] args) {
  Person person1 = new Person();
  person1.hiToAll();
  person1.forename = "Mateusz";
  person1.surname = "Karmazyn";
  person1.age = 24;
  person1.hiToAll();

  Person person2 = new Person("Dariusz", "Walendziak", 42);
  person2.hiToAll();

  person1.growOld();
  for (int i = 0; i < 3; i++) {
   person2.growOld();
  }

  person1.hiToAll();
  person2.hiToAll();

  System.out.println(person1.getName());
  person1.setName("Lolo");
  System.out.println(person1.getName());
  person1.hiToAll();
 }
}