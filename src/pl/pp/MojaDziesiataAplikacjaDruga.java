package pl.pp;
public class MojaDziesiataAplikacjaDruga {

    public static int[] countAndSumElements(int[] input) {
        if (input == null || input.length == 0) {
            return new int[0];
        }

        int negativeCount = 0;
        int positiveSum = 0;

        for (int number : input) {
            if (number < 0) {
                negativeCount++;
            } else if (number > 0) {
                positiveSum += number;
            }
            // Pomijamy zera, zgodnie z przykładem
        }

        return new int[]{negativeCount, positiveSum};
    }

    public static void main(String[] args) {
        // Przykładowe użycie
        int[] inputArray = {1, 2, 3, 4, 5, -3, -2, -1};
        int[] result = countAndSumElements(inputArray);

        if (result.length == 0) {
            System.out.println("Pusta tablica");
        } else {
            System.out.println("Liczba ujemnych: " + result[0] + ", Suma dodatnich: " + result[1]); // Oczekiwany wynik: Liczba ujemnych: 3, Suma dodatnich: 15
        }

        // Dodatkowe testy
        int[] emptyArray = {};
        int[] nullArray = null;
        int[] onlyPositiveArray = {1, 2, 3};
        int[] onlyNegativeArray = {-1, -2, -3};
        int[] mixedArrayWithZero = {1, 2, 0, -1, -2};

        System.out.println("Test dla pustej tablicy: " + java.util.Arrays.toString(countAndSumElements(emptyArray))); // Oczekiwany wynik: []
        System.out.println("Test dla null tablicy: " + java.util.Arrays.toString(countAndSumElements(nullArray)));   // Oczekiwany wynik: []
        System.out.println("Test dla tablicy z samymi dodatnimi: " + java.util.Arrays.toString(countAndSumElements(onlyPositiveArray))); // Oczekiwany wynik: [0, 6]
        System.out.println("Test dla tablicy z samymi ujemnymi: " + java.util.Arrays.toString(countAndSumElements(onlyNegativeArray))); // Oczekiwany wynik: [3, 0]
        System.out.println("Test dla tablicy z zerem: " + java.util.Arrays.toString(countAndSumElements(mixedArrayWithZero)));  // Oczekiwany wynik: [2, 3]
    }
}
