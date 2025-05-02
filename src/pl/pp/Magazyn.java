package pl.pp;

public class Magazyn{
    private String numerMagazynu;
    private int dostepnaPrzestrzen;
    private int zajetaPrzestrzen;
    private String nazwaWlasciciela;
    private String emailWlasciciela;
    private String telefonWlasciciela;

    public Magazyn(String numerMagazynu, int dostepnaPrzestrzen, String nazwaWlasciciela, String emailWlasciciela, String telefonWlasciciela) {
        this.numerMagazynu = numerMagazynu;
        this.dostepnaPrzestrzen = dostepnaPrzestrzen;
        this.zajetaPrzestrzen = 0;
        this.nazwaWlasciciela = nazwaWlasciciela;
        this.emailWlasciciela = emailWlasciciela;
        this.telefonWlasciciela = telefonWlasciciela;
    }

    public String getNumerMagazynu() {
        return numerMagazynu;
    }

    public void setNumerMagazynu(String numerMagazynu) {
        this.numerMagazynu = numerMagazynu;
    }

    public int getDostepnaPrzestrzen() {
        return dostepnaPrzestrzen;
    }

    public void setDostepnaPrzestrzen(int dostepnaPrzestrzen) {
        this.dostepnaPrzestrzen = dostepnaPrzestrzen;
    }

    public int getZajetaPrzestrzen() {
        return zajetaPrzestrzen;
    }

    private void setZajetaPrzestrzen(int zajetaPrzestrzen) {
        this.zajetaPrzestrzen = zajetaPrzestrzen;
    }

    public String getNazwaWlasciciela() {
        return nazwaWlasciciela;
    }

    public void setNazwaWlasciciela(String nazwaWlasciciela) {
        this.nazwaWlasciciela = nazwaWlasciciela;
    }

    public String getEmailWlasciciela() {
        return emailWlasciciela;
    }

    public void setEmailWlasciciela(String emailWlasciciela) {
        this.emailWlasciciela = emailWlasciciela;
    }

    public String getTelefonWlasciciela() {
        return telefonWlasciciela;
    }

    public void setTelefonWlasciciela(String telefonWlasciciela) {
        this.telefonWlasciciela = telefonWlasciciela;
    }

    public void dodajTowar(int ilosc) {
        if (ilosc > 0) {
            if (zajetaPrzestrzen + ilosc <= dostepnaPrzestrzen) {
                zajetaPrzestrzen += ilosc;
                System.out.printf("Dodano %d jednostek towaru. Pozostała przestrzeń magazynowa: %d jednostek.%n", ilosc, dostepnaPrzestrzen - zajetaPrzestrzen);
            } else {
                System.out.printf("Za mało miejsca w magazynie. Pozostała przestrzeń magazynowa: %d jednostek.%n", dostepnaPrzestrzen - zajetaPrzestrzen);
            }
        } else {
            System.out.println("Ilość dodawanego towaru musi być większa od zera.");
        }
    }

    public void usunTowar(int ilosc) {
        if (ilosc > 0) {
            if (zajetaPrzestrzen >= ilosc) {
                zajetaPrzestrzen -= ilosc;
                System.out.printf("Usunięto %d jednostek towaru. Pozostała przestrzeń magazynowa: %d jednostek.%n", ilosc, dostepnaPrzestrzen - zajetaPrzestrzen);
            } else {
                System.out.println("Nie można usunąć więcej towaru niż znajduje się w magazynie.");
            }
        } else {
            System.out.println("Ilość usuwanego towaru musi być większa od zera.");
        }
    }

    public void sprawdzZajetosc() {
        System.out.printf("Zajęta przestrzeń magazynowa: %d jednostek.%n", zajetaPrzestrzen);
        System.out.printf("Dostępna przestrzeń magazynowa: %d jednostek.%n", dostepnaPrzestrzen - zajetaPrzestrzen);
    }

    public void aktualizujKontakt(String nowyEmail, String nowyTelefon) {
        this.emailWlasciciela = nowyEmail;
        this.telefonWlasciciela = nowyTelefon;
        System.out.println("Zaktualizowano dane kontaktowe właściciela.");
        System.out.printf("Nowy email: %s%n", this.emailWlasciciela);
        System.out.printf("Nowy numer telefonu: %s%n", this.telefonWlasciciela);
    }

    public static void main(String[] args) {
        Magazyn magazyn1 = new Magazyn("MAG001", 5000, "Jan Kowalski", "jan.kowalski@example.com", "123-456-789");

        magazyn1.dodajTowar(3000);
        magazyn1.usunTowar(1000);
        magazyn1.dodajTowar(2500);
        magazyn1.sprawdzZajetosc();
        magazyn1.aktualizujKontakt("owner@magazyn.pl", "+48 123 456 789");
        magazyn1.dodajTowar(600);
    }
}
