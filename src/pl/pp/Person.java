package pl.pp;

public class Person {
    // pola (atrybuty) klasy określającej obiekt "Person" (jego parametry/cechy)
    private String forename; // pole przechowujące cechę imię
    private String surname; // pole przechowujące cechę nazwisko
    private int age; // pole przechowujące cechę wiek

    /**
     * Konstruktor domyślny - element inicjalizujący pola obiektu podczas jego tworzenia
     * (jeśli sami nie podamy żadnych parametrów)
     */
    public Person() {

    }

    /**
     * Konstruktor z trzema parametrami, które możemy podać przy jego tworzeniu,
     * wykorzystanie "this" pozwala m.in. na skorzystanie z tych samych nazw
     * pól i zmiennych
     */
    public Person(String forename, String surname, int age) {
        this.forename = forename;
        this.surname = surname;
        this.age = age;
    }

    // metody klasy określające akcje możliwe do wykonania przez obiekt
    public void hiToAll(){
        System.out.println("Nazywam się " + forename + " " + surname + ". " + "Mam " + age + " lat.");
    }

    // przykładowa metoda growOld, która zwiększa dany wiek obiektu o jeden za każdym jej wywołaniem
    public int growOld(int age){
        this.age += age;
        return age;
    }

    //tzw. "gettery" i "settery" pól prywatnych
    public String getForename(){
        return forename;
    }
    public void setForename(String forename){
        this.forename = forename;
    }
    public String getSurname(){
        return surname;
    }
    public void setSurname(String surname){
        this.surname = surname;
    }
    public int getAge(){
        return age;
    }
    public void setAge(int age){
        this.age = age;
    }
}