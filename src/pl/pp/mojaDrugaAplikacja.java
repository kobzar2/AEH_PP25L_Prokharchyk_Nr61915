package pl.pp;
import java.io.InputStream;
import java.util.Scanner;
public class mojaDrugaAplikacja {
    public static void main(String[] args) {
        int x = 10;
        Scanner scanner = new Scanner(System.in);

        var
                result = x;
        System.out.println("x = " + result);

        result = x * 2;
        System.out.println("x * 2 = " + result);

        result = x * x;
        System.out.println("x * x = " + result);
    }
}