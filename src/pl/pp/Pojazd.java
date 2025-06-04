package pl.pp;


public abstract class Pojazd {
    private String nrRejestracyjny;
    private String numerVin;
    private String kolor;
    private double cena; // np. wartość pojazdu
    private double spalanie; // L/100km lub kWh/100km
    private double poziomPaliwa; // L lub kWh
    private double przebieg; // km

    public Pojazd(String nrRejestracyjny, String numerVin, String kolor, double cena, double spalanie, double poziomPaliwa, double przebieg) {
        this.nrRejestracyjny = nrRejestracyjny;
        this.numerVin = numerVin;
        this.kolor = kolor;
        this.cena = cena;
        this.spalanie = spalanie;
        this.poziomPaliwa = poziomPaliwa;
        this.przebieg = przebieg;
    }

    // Gettery
    public String getNrRejestracyjny() { return nrRejestracyjny; }
    public String getNumerVin() { return numerVin; }
    public String getKolor() { return kolor; }
    public double getCena() { return cena; }
    public double getSpalanie() { return spalanie; }
    public double getPoziomPaliwa() { return poziomPaliwa; }
    public double getPrzebieg() { return przebieg; }

    // Settery (opcjonalne)
    public void setKolor(String kolor) { this.kolor = kolor; }
    public void setCena(double cena) { this.cena = cena; }

    public void prowadz(double kilometry) {
        if (kilometry <= 0) {
            System.out.println(nrRejestracyjny + ": Dystans musi być wartością dodatnią.");
            return;
        }

        if (this.spalanie < 0) {
            System.out.println(nrRejestracyjny + ": Nieprawidłowa (ujemna) wartość spalania: " + this.spalanie + ". Nie można jechać.");
            return;
        }

        if (this.spalanie == 0) { // Pojazd jedzie bez zużywania paliwa/energii
            this.przebieg += kilometry;
            System.out.println("Pojazd " + nrRejestracyjny + " przejechał " + kilometry + " km (zerowe spalanie). Aktualny przebieg: " + String.format("%.1f", this.przebieg) + " km.");
            return;
        }

        // spalanie > 0
        double paliwoPotrzebne = (kilometry / 100.0) * this.spalanie;

        if (paliwoPotrzebne <= this.poziomPaliwa) {
            this.poziomPaliwa -= paliwoPotrzebne;
            this.przebieg += kilometry;
            System.out.println("Pojazd " + nrRejestracyjny + " przejechał " + kilometry + " km. Pozostało paliwa/energii: " + String.format("%.2f", this.poziomPaliwa) + " jednostek. Przebieg: " + String.format("%.1f", this.przebieg) + " km.");
        } else {
            System.out.println("Pojazd " + nrRejestracyjny + ": Za mało paliwa/energii, aby przejechać " + kilometry + " km. Potrzebne: " + String.format("%.2f", paliwoPotrzebne) + ", dostępne: " + String.format("%.2f", this.poziomPaliwa));
        }
    }

    public void zatankuj(double ilosc) {
        if (ilosc <= 0) {
            System.out.println(nrRejestracyjny + ": Ilość paliwa/energii do zatankowania/naładowania musi być dodatnia.");
            return;
        }
        this.poziomPaliwa += ilosc;
        System.out.println("Pojazd " + nrRejestracyjny + " został zatankowany/naładowany o " + ilosc + " jednostek. Aktualny poziom paliwa/energii: " + String.format("%.2f", this.poziomPaliwa));
    }

    public void wyswietlInformacje() {
        System.out.println("------------------------------------");
        System.out.println("Nr rejestracyjny: " + nrRejestracyjny);
        System.out.println("VIN: " + numerVin);
        System.out.println("Kolor: " + kolor);
        System.out.println("Cena: " + String.format("%.2f", cena) + " PLN");
        System.out.println("Przebieg: " + String.format("%.1f", przebieg) + " km");

        if (this instanceof TypPaliwa) {
            TypPaliwa tp = (TypPaliwa) this;
            RodzajPaliwa rodzaj = tp.getTypPaliwa();
            System.out.println("Typ paliwa: " + rodzaj.getOpis());
            String jednostkaSpalania = (rodzaj == RodzajPaliwa.ELEKTRYK) ? "kWh/100km" : "L/100km";
            String jednostkaPoziomu = (rodzaj == RodzajPaliwa.ELEKTRYK) ? "kWh" : "L";
            System.out.println("Spalanie: " + String.format("%.1f", spalanie) + " " + jednostkaSpalania);
            System.out.println("Poziom paliwa/energii: " + String.format("%.2f", poziomPaliwa) + " " + jednostkaPoziomu);
        } else {
            System.out.println("Spalanie: " + String.format("%.1f", spalanie));
            System.out.println("Poziom paliwa/energii: " + String.format("%.2f", poziomPaliwa));
        }
    }
}