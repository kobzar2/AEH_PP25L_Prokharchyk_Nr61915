package pl.pp;


public enum RodzajPaliwa {
    DIESEL("Olej napędowy"),
    BENZYNA("Benzyna"),
    ELEKTRYK("Energia elektryczna");

    private final String opis;

    RodzajPaliwa(String opis) {
        this.opis = opis;
    }

    public String getOpis() {
        return opis;
    }
}