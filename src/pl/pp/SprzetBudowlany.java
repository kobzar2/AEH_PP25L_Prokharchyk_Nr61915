package pl.pp;

public class SprzetBudowlany extends Pojazd implements TypPaliwa {
    private double przepracowaneGodziny;
    private RodzajPaliwa rodzajPaliwa;

    public SprzetBudowlany(String nrRejestracyjny, String numerVin, String kolor, double cena,
                           double spalanie, double poziomPaliwa, double przebieg,
                           double przepracowaneGodziny, RodzajPaliwa rodzajPaliwa) {
        super(nrRejestracyjny, numerVin, kolor, cena, spalanie, poziomPaliwa, przebieg);
        this.przepracowaneGodziny = przepracowaneGodziny;
        this.rodzajPaliwa = rodzajPaliwa;
    }

    public double getPrzepracowaneGodziny() {
        return przepracowaneGodziny;
    }

    public void dodajPrzepracowaneGodziny(double godziny) {
        if (godziny > 0) {
            this.przepracowaneGodziny += godziny;
            System.out.println(getNrRejestracyjny() + ": Dodano " + godziny + " godzin pracy. Łącznie przepracowane: " + String.format("%.1f", this.przepracowaneGodziny) + "h.");
            // Uwaga: Zużycie paliwa podczas pracy nie jest tutaj modelowane,
            // 'spalanie' z klasy Pojazd dotyczy metody 'prowadz'.
        } else {
            System.out.println(getNrRejestracyjny() + ": Liczba godzin pracy musi być dodatnia.");
        }
    }

    @Override
    public RodzajPaliwa getTypPaliwa() {
        return rodzajPaliwa;
    }

    @Override
    public void wyswietlInformacje() {
        super.wyswietlInformacje();
        System.out.println("Typ pojazdu: Sprzęt budowlany");
        System.out.println("Przepracowane godziny: " + String.format("%.1f", przepracowaneGodziny) + " h");
        System.out.println("------------------------------------");
    }
}