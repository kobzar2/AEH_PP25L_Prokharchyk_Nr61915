package pl.pp;

public class Motocykl extends Pojazd implements TypPaliwa {
    private boolean posiadaDostawke; // np. kufer boczny, dostawka
    private RodzajPaliwa rodzajPaliwa;

    public Motocykl(String nrRejestracyjny, String numerVin, String kolor, double cena,
                    double spalanie, double poziomPaliwa, double przebieg,
                    boolean posiadaDostawke, RodzajPaliwa rodzajPaliwa) {
        super(nrRejestracyjny, numerVin, kolor, cena, spalanie, poziomPaliwa, przebieg);
        this.posiadaDostawke = posiadaDostawke;
        this.rodzajPaliwa = rodzajPaliwa;
    }

    public boolean isPosiadaDostawke() {
        return posiadaDostawke;
    }

    @Override
    public RodzajPaliwa getTypPaliwa() {
        return rodzajPaliwa;
    }

    @Override
    public void wyswietlInformacje() {
        super.wyswietlInformacje();
        System.out.println("Typ pojazdu: Motocykl");
        System.out.println("Posiada dostawkę/bagażnik: " + (posiadaDostawke ? "Tak" : "Nie"));
        System.out.println("------------------------------------");
    }
}
