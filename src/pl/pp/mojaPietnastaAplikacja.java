package pl.pp;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class mojaPietnastaAplikacja {
    public static void main(String[] args) {
        System.out.println("--- System Wynajmu Rowerów i Hulajnóg ---");

        StacjaWynajmu stacjaCentrum = new StacjaWynajmu("ST001", "Stacja Centrum");
        StacjaWynajmu stacjaPark = new StacjaWynajmu("ST002", "Stacja Parkowa");

        System.out.println("\n--- Inicjalizacja pojazdów i stacji ---");
        Rower rowerMiejski1 = new Rower("R001", "CityBike Pro", "Czerwony", 10.0,
                stacjaCentrum.getNazwaLokalizacji(), 7, TypRoweru.MIEJSKI);
        Rower rowerGorski1 = new Rower("R002", "MountainX 3000", "Czarny", 15.0,
                stacjaCentrum.getNazwaLokalizacji(), 21, TypRoweru.GORSKI);
        Hulajnoga hulajnogaElek1 = new Hulajnoga("H001", "EcoRide", "Zielona", 8.0,
                stacjaCentrum.getNazwaLokalizacji(), TypHulajnogi.ELEKTRYCZNA, 50.0, 0.2); // 50kWh, 0.2kWh/km
        Hulajnoga hulajnogaMan1 = new Hulajnoga("H002", "KickScoot", "Niebieska", 5.0,
                stacjaPark.getNazwaLokalizacji(), TypHulajnogi.MANUALNA, 0.0, 0.0); // Manualna nie ma baterii

        stacjaCentrum.dodajPojazd(rowerMiejski1);
        stacjaCentrum.dodajPojazd(rowerGorski1);
        stacjaCentrum.dodajPojazd(hulajnogaElek1);
        stacjaPark.dodajPojazd(hulajnogaMan1);

        Klient klientJan = new Klient("KL001", "Jan", "Kowalski", "123-456-789", 50.0); // Saldo początkowe 50 PLN
        Klient klientAnna = new Klient("KL002", "Anna", "Nowak", "987-654-321", 10.0); // Saldo początkowe 10 PLN

        stacjaCentrum.wyswietlInformacjeOStacji();
        stacjaPark.wyswietlInformacjeOStacji();
        stacjaCentrum.wyswietlDostepnePojazdy();
        stacjaPark.wyswietlDostepnePojazdy();
        klientJan.wyswietlInformacje();
        klientAnna.wyswietlInformacje();

        System.out.println("\n--- Symulacja wynajmu i zwrotu ---");

        System.out.println("\n>>> Scenariusz 1: Jan wynajmuje rower miejski");
        PojazdDoWynajecia wynajetyRowerJana = stacjaCentrum.wynajmijPojazd(klientJan, "R001");
        if (wynajetyRowerJana != null) {
            System.out.println("Jan próbuje 'używać' roweru przez 3 godziny...");
        }
        stacjaCentrum.wyswietlDostepnePojazdy();
        klientJan.wyswietlWynajetePojazdy();

        System.out.println("\n>>> Jan zwraca rower miejski po 3 godzinach do Stacji Parkowej");
        if (wynajetyRowerJana != null) {
            stacjaPark.zwrocPojazdNaStacje(klientJan, wynajetyRowerJana, 3.0);
        }
        klientJan.wyswietlInformacje();
        stacjaCentrum.wyswietlDostepnePojazdy();
        stacjaPark.wyswietlDostepnePojazdy();
        stacjaPark.wyswietlInformacjeOStacji();

        System.out.println("\n>>> Scenariusz 2: Anna próbuje wynająć hulajnogę elektryczną");
        PojazdDoWynajecia hulajnogaAnny = stacjaCentrum.wynajmijPojazd(klientAnna, "H001");
        klientAnna.wyswietlInformacje();

        System.out.println("\n>>> Scenariusz 3: Anna dodaje środki i wynajmuje hulajnogę");
        klientAnna.dodajSrodki(20.0); // Anna dodaje środki
        hulajnogaAnny = stacjaCentrum.wynajmijPojazd(klientAnna, "H001"); // Ponowna próba wynajmu
        if (hulajnogaAnny instanceof Hulajnoga) {
            Hulajnoga h = (Hulajnoga) hulajnogaAnny;
            System.out.println("Anna jeździ hulajnogą przez 10 km...");
            h.jedz(10.0);
            System.out.println("Anna jeździ hulajnogą przez kolejne 20 km (może zabraknąć baterii)...");
            h.jedz(20.0);
            h.wyswietlInformacje();
        }
        klientAnna.wyswietlWynajetePojazdy();

        System.out.println("\n>>> Anna zwraca hulajnogę po 2 godzinach do Stacji Centrum");
        if (hulajnogaAnny != null) {
            stacjaCentrum.zwrocPojazdNaStacje(klientAnna, hulajnogaAnny, 2.0);
            if (hulajnogaAnny instanceof Hulajnoga) {
                Hulajnoga h = (Hulajnoga) hulajnogaAnny;
                System.out.println("Hulajnoga po zwrocie: ");
                h.wyswietlInformacje();
                System.out.println("Anna ładuje hulajnogę na stacji...");
                h.naladuj(30.0);
                h.wyswietlInformacje();
            }
        }
        klientAnna.wyswietlInformacje();
        stacjaCentrum.wyswietlDostepnePojazdy();
        stacjaCentrum.wyswietlInformacjeOStacji();

        System.out.println("\n--- Końcowy stan systemu ---");
        stacjaCentrum.wyswietlDostepnePojazdy();
        stacjaPark.wyswietlDostepnePojazdy();
        klientJan.wyswietlInformacje();
        klientJan.wyswietlWynajetePojazdy();
        klientAnna.wyswietlInformacje();
        klientAnna.wyswietlWynajetePojazdy();

        System.out.println("\n--- Koniec symulacji ---");
    }
}
enum TypRoweru {
    MIEJSKI("Rower Miejski"),
    GORSKI("Rower Górski"),
    SZOSOWY("Rower Szosowy");

    private final String opis;

    TypRoweru(String opis) {
        this.opis = opis;
    }

    public String getOpis() {
        return opis;
    }
}

enum TypHulajnogi {
    ELEKTRYCZNA("Hulajnoga elektryczna"),
    MANUALNA("Hulajnoga manualna");

    private final String opis;

    TypHulajnogi(String opis) {
        this.opis = opis;
    }

    public String getOpis() {
        return opis;
    }
}

interface PojazdElektryczny {
    void naladuj(double iloscEnergii);
    double getPoziomBaterii();
    double getMaksymalnyPoziomBaterii();
}

abstract class PojazdDoWynajecia {
    private String id;
    private String model;
    private String kolor;
    private double cenaZaGodzine;
    private boolean czyDostepny;
    private String aktualnaLokalizacja;
    private double calkowityCzasWynajmu;

    public PojazdDoWynajecia(String id, String model, String kolor, double cenaZaGodzine,
                             String aktualnaLokalizacja) {
        this.id = id;
        this.model = model;
        this.kolor = kolor;
        this.cenaZaGodzine = cenaZaGodzine;
        this.czyDostepny = true;
        this.aktualnaLokalizacja = aktualnaLokalizacja;
        this.calkowityCzasWynajmu = 0.0;
    }

    public String getId() { return id; }
    public String getModel() { return model; }
    public String getKolor() { return kolor; }
    public double getCenaZaGodzine() { return cenaZaGodzine; }
    public boolean isCzyDostepny() { return czyDostepny; }
    public String getAktualnaLokalizacja() { return aktualnaLokalizacja; }
    public double getCalkowityCzasWynajmu() { return calkowityCzasWynajmu; }

    public void setCzyDostepny(boolean czyDostepny) { this.czyDostepny = czyDostepny; }
    public void setAktualnaLokalizacja(String aktualnaLokalizacja) { this.aktualnaLokalizacja = aktualnaLokalizacja; }

    public void wynajmij() {
        if (this.czyDostepny) {
            this.czyDostepny = false;
            System.out.println("Pojazd " + id + " (" + model + ") został pomyślnie wynajęty.");
        } else {
            System.out.println("Pojazd " + id + " (" + model + ") jest aktualnie niedostępny do wynajęcia.");
        }
    }

    public double zwrocPojazd(double przepracowaneGodziny, String lokalizacjaZwrotu) {
        if (!this.czyDostepny) {
            if (przepracowaneGodziny <= 0) {
                System.out.println("Czas użytkowania musi być wartością dodatnią. Brak naliczenia opłaty.");
                return 0.0;
            }
            this.czyDostepny = true;
            this.calkowityCzasWynajmu += przepracowaneGodziny;
            this.aktualnaLokalizacja = lokalizacjaZwrotu;
            double kosztWynajmu = przepracowaneGodziny * cenaZaGodzine;
            System.out.println("Pojazd " + id + " (" + model + ") zwrócony na stację " + lokalizacjaZwrotu + " po " + String.format("%.1f", przepracowaneGodziny) + " godzinach użytkowania. Koszt wynajmu: " + String.format("%.2f", kosztWynajmu) + " PLN.");
            return kosztWynajmu;
        } else {
            System.out.println("Pojazd " + id + " (" + model + ") jest już dostępny i nie znajduje się w wynajmie.");
            return 0.0;
        }
    }

    public abstract void wyswietlInformacje();
}

// --- KLASA: Rower ---
class Rower extends PojazdDoWynajecia {
    private int liczbaBiegow;
    private TypRoweru typRoweru;

    public Rower(String id, String model, String kolor, double cenaZaGodzine,
                 String aktualnaLokalizacja, int liczbaBiegow, TypRoweru typRoweru) {
        super(id, model, kolor, cenaZaGodzine, aktualnaLokalizacja);
        this.liczbaBiegow = liczbaBiegow;
        this.typRoweru = typRoweru;
    }

    public int getLiczbaBiegow() {
        return liczbaBiegow;
    }

    public TypRoweru getTypRoweru() {
        return typRoweru;
    }

    @Override
    public void wyswietlInformacje() {
        System.out.println("------------------------------------");
        System.out.println("ID: " + getId());
        System.out.println("Model: " + getModel());
        System.out.println("Kolor: " + getKolor());
        System.out.println("Cena za godzinę: " + String.format("%.2f", getCenaZaGodzine()) + " PLN/h");
        System.out.println("Dostępny: " + (isCzyDostepny() ? "Tak" : "Nie"));
        System.out.println("Aktualna lokalizacja: " + getAktualnaLokalizacja());
        System.out.println("Całkowity czas wynajmu: " + String.format("%.1f", getCalkowityCzasWynajmu()) + " h");
        System.out.println("Typ pojazdu: Rower");
        System.out.println("Typ roweru: " + typRoweru.getOpis());
        System.out.println("Liczba biegów: " + liczbaBiegow);
        System.out.println("------------------------------------");
    }
}

class Hulajnoga extends PojazdDoWynajecia implements PojazdElektryczny {
    private TypHulajnogi typHulajnogi;
    private double maksymalnyPoziomBaterii;
    private double poziomBaterii;
    private double zuzycieEnergiiNaKm;

    public Hulajnoga(String id, String model, String kolor, double cenaZaGodzine,
                     String aktualnaLokalizacja, TypHulajnogi typHulajnogi,
                     double maksymalnyPoziomBaterii, double zuzycieEnergiiNaKm) {
        super(id, model, kolor, cenaZaGodzine, aktualnaLokalizacja);
        this.typHulajnogi = typHulajnogi;
        this.maksymalnyPoziomBaterii = maksymalnyPoziomBaterii;
        this.poziomBaterii = maksymalnyPoziomBaterii;
        this.zuzycieEnergiiNaKm = zuzycieEnergiiNaKm;
    }

    public TypHulajnogi getTypHulajnogi() {
        return typHulajnogi;
    }

    @Override
    public void wynajmij() {
        if (this.typHulajnogi == TypHulajnogi.ELEKTRYCZNA && this.poziomBaterii < (maksymalnyPoziomBaterii * 0.1)) { // Np. wymagaj 10% baterii
            System.out.println("Hulajnoga " + getId() + ": Zbyt niski poziom baterii (" + String.format("%.1f", this.poziomBaterii) + "kWh). Proszę naładować przed wynajmem.");
            return;
        }
        super.wynajmij();
    }

    public void jedz(double kilometry) {
        if (kilometry <= 0) {
            System.out.println(getId() + ": Dystans musi być wartością dodatnią.");
            return;
        }

        if (this.typHulajnogi == TypHulajnogi.ELEKTRYCZNA) {
            double energiaPotrzebna = kilometry * zuzycieEnergiiNaKm;
            if (energiaPotrzebna <= this.poziomBaterii) {
                this.poziomBaterii -= energiaPotrzebna;
                System.out.println("Hulajnoga " + getId() + " przejechała " + kilometry + " km. Pozostało baterii: " + String.format("%.2f", this.poziomBaterii) + " kWh.");
            } else {
                System.out.println("Hulajnoga " + getId() + ": Za mało energii, aby przejechać " + kilometry + " km. Potrzebne: " + String.format("%.2f", energiaPotrzebna) + " kWh, dostępne: " + String.format("%.2f", this.poziomBaterii) + " kWh.");
            }
        } else {
            System.out.println("Hulajnoga " + getId() + " (manualna) przejechała " + kilometry + " km.");
        }
    }

    @Override
    public void naladuj(double iloscEnergii) {
        if (this.typHulajnogi == TypHulajnogi.ELEKTRYCZNA) {
            if (iloscEnergii <= 0) {
                System.out.println(getId() + ": Ilość energii do naładowania musi być dodatnia.");
                return;
            }
            double nowaBateria = this.poziomBaterii + iloscEnergii;
            this.poziomBaterii = Math.min(nowaBateria, maksymalnyPoziomBaterii);
            System.out.println("Hulajnoga " + getId() + " naładowana o " + iloscEnergii + " kWh. Aktualny poziom baterii: " + String.format("%.2f", this.poziomBaterii) + " kWh.");
        } else {
            System.out.println("Hulajnoga " + getId() + " jest manualna i nie wymaga ładowania.");
        }
    }

    @Override
    public double getPoziomBaterii() {
        return poziomBaterii;
    }

    @Override
    public double getMaksymalnyPoziomBaterii() {
        return maksymalnyPoziomBaterii;
    }

    @Override
    public void wyswietlInformacje() {
        System.out.println("------------------------------------");
        System.out.println("ID: " + getId());
        System.out.println("Model: " + getModel());
        System.out.println("Kolor: " + getKolor());
        System.out.println("Cena za godzinę: " + String.format("%.2f", getCenaZaGodzine()) + " PLN/h");
        System.out.println("Dostępny: " + (isCzyDostepny() ? "Tak" : "Nie"));
        System.out.println("Aktualna lokalizacja: " + getAktualnaLokalizacja());
        System.out.println("Całkowity czas wynajmu: " + String.format("%.1f", getCalkowityCzasWynajmu()) + " h");
        System.out.println("Typ pojazdu: Hulajnoga");
        System.out.println("Typ hulajnogi: " + typHulajnogi.getOpis());
        if (typHulajnogi == TypHulajnogi.ELEKTRYCZNA) {
            System.out.println("Poziom baterii: " + String.format("%.2f", poziomBaterii) + " / " + String.format("%.2f", maksymalnyPoziomBaterii) + " kWh");
            System.out.println("Zużycie energii: " + String.format("%.2f", zuzycieEnergiiNaKm) + " kWh/km");
        }
        System.out.println("------------------------------------");
    }
}

class Klient {
    private String idKlienta;
    private String imie;
    private String nazwisko;
    private String numerTelefonu;
    private double saldo; // Balans konta klienta
    private List<PojazdDoWynajecia> wynajetePojazdy; // Lista aktualnie wynajętych pojazdów

    public Klient(String idKlienta, String imie, String nazwisko, String numerTelefonu, double saldoPoczatkowe) {
        this.idKlienta = idKlienta;
        this.imie = imie;
        this.nazwisko = nazwisko;
        this.numerTelefonu = numerTelefonu;
        this.saldo = saldoPoczatkowe;
        this.wynajetePojazdy = new ArrayList<>();
    }

    public String getIdKlienta() { return idKlienta; }
    public String getImie() { return imie; }
    public String getNazwisko() { return nazwisko; }
    public String getNumerTelefonu() { return numerTelefonu; }
    public double getSaldo() { return saldo; }
    public List<PojazdDoWynajecia> getWynajetePojazdy() { return wynajetePojazdy; }

    public void dodajSrodki(double kwota) {
        if (kwota > 0) {
            this.saldo += kwota;
            System.out.println("Klient " + imie + " " + nazwisko + ": Dodano " + String.format("%.2f", kwota) + " PLN. Nowe saldo: " + String.format("%.2f", this.saldo) + " PLN.");
        } else {
            System.out.println("Kwota do dodania musi być dodatnia.");
        }
    }

    public boolean odejmijSrodki(double kwota) {
        if (kwota > 0 && this.saldo >= kwota) {
            this.saldo -= kwota;
            System.out.println("Klient " + imie + " " + nazwisko + ": Odjęto " + String.format("%.2f", kwota) + " PLN. Nowe saldo: " + String.format("%.2f", this.saldo) + " PLN.");
            return true;
        } else {
            System.out.println("Klient " + imie + " " + nazwisko + ": Niewystarczające środki lub nieprawidłowa kwota. Dostępne: " + String.format("%.2f", this.saldo) + " PLN, wymagane: " + String.format("%.2f", kwota) + " PLN.");
            return false;
        }
    }

    public void wyswietlWynajetePojazdy() {
        if (wynajetePojazdy.isEmpty()) {
            System.out.println("Klient " + imie + " " + nazwisko + " nie ma aktualnie wynajętych pojazdów.");
            return;
        }
        System.out.println("--- Wynajęte pojazdy klienta " + imie + " " + nazwisko + " ---");
        for (PojazdDoWynajecia pojazd : wynajetePojazdy) {
            System.out.println("- ID: " + pojazd.getId() + ", Model: " + pojazd.getModel() + ", Lokalizacja: " + pojazd.getAktualnaLokalizacja());
        }
        System.out.println("------------------------------------");
    }

    public void dodajWynajetyPojazd(PojazdDoWynajecia pojazd) {
        this.wynajetePojazdy.add(pojazd);
    }

    public void usunWynajetyPojazd(PojazdDoWynajecia pojazd) {
        this.wynajetePojazdy.remove(pojazd);
    }

    public void wyswietlInformacje() {
        System.out.println("--- Dane Klienta ---");
        System.out.println("ID Klienta: " + idKlienta);
        System.out.println("Imię: " + imie);
        System.out.println("Nazwisko: " + nazwisko);
        System.out.println("Numer telefonu: " + numerTelefonu);
        System.out.println("Saldo: " + String.format("%.2f", saldo) + " PLN");
        System.out.println("Liczba aktualnie wynajętych pojazdów: " + wynajetePojazdy.size());
        System.out.println("--------------------");
    }
}

class StacjaWynajmu {
    private String idStacji;
    private String nazwaLokalizacji;
    private List<PojazdDoWynajecia> dostepnePojazdy; // Pojazdy aktualnie na stacji
    private List<PojazdDoWynajecia> wynajetePojazdy; // Pojazdy, które zostały wynajęte z tej stacji i jeszcze nie wróciły

    public StacjaWynajmu(String idStacji, String nazwaLokalizacji) {
        this.idStacji = idStacji;
        this.nazwaLokalizacji = nazwaLokalizacji;
        this.dostepnePojazdy = new ArrayList<>();
        this.wynajetePojazdy = new ArrayList<>();
    }

    public String getIdStacji() { return idStacji; }
    public String getNazwaLokalizacji() { return nazwaLokalizacji; }
    public List<PojazdDoWynajecia> getDostepnePojazdy() { return dostepnePojazdy; }
    public List<PojazdDoWynajecia> getWynajetePojazdy() { return wynajetePojazdy; }

    public void dodajPojazd(PojazdDoWynajecia pojazd) {
        if (!dostepnePojazdy.contains(pojazd)) {
            dostepnePojazdy.add(pojazd);
            pojazd.setCzyDostepny(true);
            pojazd.setAktualnaLokalizacja(this.nazwaLokalizacji);
            System.out.println("Stacja " + nazwaLokalizacji + ": Dodano pojazd " + pojazd.getId() + " (" + pojazd.getModel() + ").");
        } else {
            System.out.println("Stacja " + nazwaLokalizacji + ": Pojazd " + pojazd.getId() + " jest już na tej stacji.");
        }
    }

    private void usunPojazdZeStacji(PojazdDoWynajecia pojazd) {
        dostepnePojazdy.remove(pojazd);
    }

    public PojazdDoWynajecia wynajmijPojazd(Klient klient, String idPojazdu) {
        Optional<PojazdDoWynajecia> optionalPojazd = dostepnePojazdy.stream()
                .filter(p -> p.getId().equals(idPojazdu) && p.isCzyDostepny())
                .findFirst();

        if (optionalPojazd.isPresent()) {
            PojazdDoWynajecia pojazd = optionalPojazd.get();
            if (klient.getSaldo() >= pojazd.getCenaZaGodzine()) {
                pojazd.wynajmij();
                usunPojazdZeStacji(pojazd);
                wynajetePojazdy.add(pojazd);
                klient.dodajWynajetyPojazd(pojazd);
                System.out.println("Klient " + klient.getImie() + " " + klient.getNazwisko() + " wynajął pojazd " + pojazd.getModel() + " (ID: " + pojazd.getId() + ") ze stacji " + nazwaLokalizacji + ".");
                return pojazd;
            } else {
                System.out.println("Klient " + klient.getImie() + " " + klient.getNazwisko() + ": Niewystarczające saldo, aby wynająć pojazd " + pojazd.getId() + " (wymagane min. " + String.format("%.2f", pojazd.getCenaZaGodzine()) + " PLN).");
                return null;
            }
        } else {
            System.out.println("Pojazd o ID " + idPojazdu + " nie jest dostępny na stacji " + nazwaLokalizacji + ".");
            return null;
        }
    }

    public void zwrocPojazdNaStacje(Klient klient, PojazdDoWynajecia pojazd, double przepracowaneGodziny) {
        if (klient.getWynajetePojazdy().contains(pojazd)) {
            double koszt = pojazd.zwrocPojazd(przepracowaneGodziny, this.nazwaLokalizacji);
            if (klient.odejmijSrodki(koszt)) {
                klient.usunWynajetyPojazd(pojazd);
                wynajetePojazdy.remove(pojazd);
                dostepnePojazdy.add(pojazd);
                System.out.println("Pojazd " + pojazd.getId() + " zwrócony przez klienta " + klient.getImie() + " " + klient.getNazwisko() + " na stację " + nazwaLokalizacji + ".");
            } else {
                System.out.println("Nie udało się pobrać opłaty od klienta " + klient.getImie() + " " + klient.getNazwisko() + " za zwrot pojazdu " + pojazd.getId() + ". Pojazd pozostaje wynajęty w systemie.");
            }
        } else {
            System.out.println("Pojazd " + pojazd.getId() + " nie jest wynajęty przez klienta " + klient.getImie() + " " + klient.getNazwisko() + ".");
        }
    }


    public void wyswietlDostepnePojazdy() {
        System.out.println("\n--- Dostępne pojazdy na stacji " + nazwaLokalizacji + " ---");
        if (dostepnePojazdy.isEmpty()) {
            System.out.println("Brak dostępnych pojazdów na tej stacji.");
            return;
        }
        for (PojazdDoWynajecia pojazd : dostepnePojazdy) {
            pojazd.wyswietlInformacje();
        }
        System.out.println("------------------------------------");
    }

    public void wyswietlWynajetePojazdyZeStacji() {
        System.out.println("\n--- Pojazdy wynajęte ze stacji " + nazwaLokalizacji + " (jeszcze nie zwrócone) ---");
        if (wynajetePojazdy.isEmpty()) {
            System.out.println("Brak aktualnie wynajętych pojazdów z tej stacji.");
            return;
        }
        for (PojazdDoWynajecia pojazd : wynajetePojazdy) {
            System.out.println("- ID: " + pojazd.getId() + ", Model: " + pojazd.getModel());
        }
        System.out.println("------------------------------------");
    }

    public void wyswietlInformacjeOStacji() {
        System.out.println("\n=== Informacje o Stacji Wynajmu ===");
        System.out.println("ID Stacji: " + idStacji);
        System.out.println("Lokalizacja: " + nazwaLokalizacji);
        System.out.println("Liczba dostępnych pojazdów: " + dostepnePojazdy.size());
        System.out.println("Liczba wynajętych pojazdów (z tej stacji): " + wynajetePojazdy.size());
        System.out.println("===================================\n");
    }
}


