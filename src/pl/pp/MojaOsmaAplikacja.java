package pl.pp;
import pl.pp.Person;
import pl.pp.circle;
public class MojaOsmaAplikacja {
    public static void main(String[] args) {
        Person person1 = new Person("Test", "Testowy", 25); //nowy obiekt klasy Person
        person1.hiToAll(); //wywołanie metody hiToAll() z obiektu person1 klasy Person

        person1.growOld(10); //wywołanie metody growOld( z obiektu person1 klasy Person
        person1.hiToAll();
        person1.setForename("ZmienionyTest"); //wywołanie metody tzw. "settera" do zmiany imienia
        person1.hiToAll();

        String personName = person1.getForename(); //wywołanie metody tzw. "gettera" do pobrania imienia
        int personAge = person1.getAge(); //wywołanie metody tzw. "gettera" do pobrania wieku
        System.out.println("Pobrane imię to " + personName + " z wiekiem = " + personAge);

        circle circle1 = new circle(1.2); //nowy obiekt klasy Circle
        circle1.getInfo(); //wywołanie metody getInfo() z obiektu circle1 klasy Circle
        circle1.setRadius(2.6); //wywołanie metody tzw. "settera" do zmiany promienia
        circle1.getInfo();

    }
}
