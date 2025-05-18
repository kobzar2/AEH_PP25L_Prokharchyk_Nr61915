package pl.pp;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class MojaJedenastaAplikacja {
}
    class Student {
        private String numerIndeksu;
        private String imie;
        private String nazwisko;
        private List<Integer> oceny;

        public Student(String numerIndeksu, String imie, String nazwisko, List<Integer> oceny) {
            this.numerIndeksu = numerIndeksu;
            this.imie = imie;
            this.nazwisko = nazwisko;
            this.oceny = oceny;
        }

        public String getNumerIndeksu() {
            return numerIndeksu;
        }

        public String getImie() {
            return imie;
        }

        public String getNazwisko() {
            return nazwisko;
        }

        public List<Integer> getOceny() {
            return oceny;
        }

        public double obliczSredniaOcen() {
            if (oceny.isEmpty()) {
                return 0.0;
            }
            int sumaOcen = 0;
            for (int ocena : oceny) {
                sumaOcen += ocena;
            }
            return (double) sumaOcen / oceny.size();
        }

        @Override
        public String toString() {
            return imie + " " + nazwisko + " (" + numerIndeksu + ") - Average: " + String.format("%.2f", obliczSredniaOcen());
        }
    }

