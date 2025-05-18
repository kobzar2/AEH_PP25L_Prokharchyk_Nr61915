package pl.pp;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class MojaJedenastaAplikacjaDruga {

    public static void main(String[] args) {
        List<Student> students = new ArrayList<>();
        students.add(new Student("12345", "Jan", "Kowalski", List.of(4, 5, 3, 5)));
        students.add(new Student("67890", "Anna", "Nowak", List.of(5, 5, 4, 4)));
        students.add(new Student("54321", "Paweł", "Wiśniewski", List.of(2, 3, 2, 4)));
        students.add(new Student("09876", "Katarzyna", "Kowalczyk", List.of(5, 4, 4, 5)));
        Student studentZNajwyzszaSrednia = null;
        double najwyzszaSrednia = -1.0;

        for (Student student : students) {
            double srednia = student.obliczSredniaOcen();
            if (srednia > najwyzszaSrednia) {
                najwyzszaSrednia = srednia;
                studentZNajwyzszaSrednia = student;
            }
        }
        System.out.println("Student z najwyższą średnią: " + studentZNajwyzszaSrednia);
        double sumaSrednich = 0;
        for (Student student : students) {
            sumaSrednich += student.obliczSredniaOcen();
        }
        double sredniaWszystkichStudentow = students.isEmpty() ? 0 : sumaSrednich / students.size();
        System.out.println("Średnia ocen wszystkich studentów: " + String.format("%.2f", sredniaWszystkichStudentow));

        students.sort(Comparator.comparing(Student::getNazwisko).thenComparing(Student::getImie));
        System.out.println("\nStudenci posortowani według nazwisk:");
        for (Student student : students) {
            System.out.println(student);
        }
    }
}