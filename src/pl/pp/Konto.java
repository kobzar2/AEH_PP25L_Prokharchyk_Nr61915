package pl.pp;

public class Konto {
        private String numerKonta;
        private double saldo;
        private String wlasciciel;
        private String email;
        private String telefon;

        public Konto(String numerKonta, String wlasciciel, String email, String telefon, double saldoPoczatkowe) {
            this.numerKonta = numerKonta;
            this.saldo = saldoPoczatkowe;
            this.wlasciciel = wlasciciel;
            this.email = email;
            this.telefon = telefon;
        }

        public String getNumerKonta() {
            return numerKonta;
        }

        public void setNumerKonta(String numerKonta) {
            this.numerKonta = numerKonta;
        }

        public double getSaldo() {
            return saldo;
        }

        public void setSaldo(double saldo) {
            this.saldo = saldo;
        }

        public String getWlasciciel() {
            return wlasciciel;
        }

        public void setWlasciciel(String wlasciciel) {
            this.wlasciciel = wlasciciel;
        }

        public String getEmail() {
            return email;
        }

        public void setEmail(String email) {
            this.email = email;
        }

        public String getTelefon() {
            return telefon;
        }

        public void setTelefon(String telefon) {
            this.telefon = telefon;
        }

        public void wplata(double kwota) {
            if (kwota > 0) {
                this.saldo += kwota;
                System.out.printf("Wpłata PLN %.2f została wykonana. Nowe saldo PLN %.2f%n", kwota, this.saldo);
            } else {
                System.out.println("Kwota wpłaty musi być większa od zera.");
            }
        }

        public void wyplata(double kwota) {
            if (kwota > 0) {
                if (this.saldo >= kwota) {
                    this.saldo -= kwota;
                    System.out.printf("Pobrano PLN %.2f z konta, Pozostałe saldo = PLN %.2f%n", kwota, this.saldo);
                } else {
                    System.out.printf("Brak środków. Masz PLN %.2f na koncie.%n", this.saldo);
                }
            } else {
                System.out.println("Kwota wypłaty musi być większa od zera.");
            }
        }

        public static void main(String[] args) {
            Konto konto1 = new Konto("1234567890", "Jan Kowalski", "jan.kowalski@example.com", "123-456-789", 1000.0);

            konto1.wyplata(900.0);
            konto1.wplata(250.0);
            konto1.wyplata(50.0);
            konto1.wyplata(500.0);
        }
    }
