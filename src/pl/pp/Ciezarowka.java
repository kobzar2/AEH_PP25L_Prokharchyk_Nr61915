package pl.pp;

public class Ciezarowka extends Pojazd implements TypPaliwa {
    private double ladownosc; // w tonach
    private RodzajPaliwa rodzajPaliwa;

    public Ciezarowka(String nrRejestracyjny, String numerVin, String kolor, double cena,
                      double spalanie, double poziomPaliwa, double przebieg,
                      double ladownosc, RodzajPaliwa rodzajPaliwa) {
        super(nrRejestracyjny, numerVin, kolor, cena, spalanie, poziomPaliwa, przebieg);
        this.ladownosc = ladownosc;
        this.rodzajPaliwa = rodzajPaliwa;
    }

    public double getLadownosc() {
        return ladownosc;
    }

    @Override
    public RodzajPaliwa getTypPaliwa() {
        return rodzajPaliwa;
    }

    @Override
    public void wyswietlInformacje() {
        super.wyswietlInformacje();
        System.out.println("Typ pojazdu: Ciężarówka");
        System.out.println("Ładowność: " + ladownosc + " ton");
        System.out.println("------------------------------------");
    }
}
