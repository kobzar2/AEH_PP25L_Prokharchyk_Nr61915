package pl.pp;


public class Osobowe extends Pojazd implements TypPaliwa {
    private int liczbaDrzwi;
    private RodzajPaliwa rodzajPaliwa;

    public Osobowe(String nrRejestracyjny, String numerVin, String kolor, double cena,
                   double spalanie, double poziomPaliwa, double przebieg,
                   int liczbaDrzwi, RodzajPaliwa rodzajPaliwa) {
        super(nrRejestracyjny, numerVin, kolor, cena, spalanie, poziomPaliwa, przebieg);
        this.liczbaDrzwi = liczbaDrzwi;
        this.rodzajPaliwa = rodzajPaliwa;
    }

    public int getLiczbaDrzwi() {
        return liczbaDrzwi;
    }

    @Override
    public RodzajPaliwa getTypPaliwa() {
        return rodzajPaliwa;
    }

    @Override
    public void wyswietlInformacje() {
        super.wyswietlInformacje();
        System.out.println("Typ pojazdu: Samochód osobowy");
        System.out.println("Liczba drzwi: " + liczbaDrzwi);
        System.out.println("------------------------------------");
    }
}
