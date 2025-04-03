package pl.pp;
public class mojaPiataAplikacja {
    public static void main(String[] args) {

 // Obliczenia i wyświetlenie wyniku dla wartości przypisanych w kodzie aplikacji
 System.out.println("Obliczenia i wyświetlenie wyniku dla wartości przypisanych w kodzie aplikacji");
 boolean gameOver = true;
int score = 800;
 int levelCompleted = 5;
 int bonus = 100;

 int finalScore = score;
 if (gameOver) {
 finalScore += (levelCompleted * bonus);
 finalScore += 1000;
 System.out.println("Twoj wynik #1 to " + finalScore);
 }

 // Obliczenia i wyświetlenie wyniku dla wartości przypisanych w kodzie aplikacji (innych niż poprzednio)
 System.out.println("Obliczenia i wyświetlenie wyniku dla wartości przypisanych w kodzie aplikacji (innych niż poprzednio)");
 score = 10000;
 levelCompleted = 8;
bonus = 200;
finalScore = score;
 if (gameOver) {
 finalScore += (levelCompleted * bonus);
 finalScore += 1000;
 System.out.println("Twoj wynik #2 to " + finalScore);
}
 // Obliczenia za pomocą metody calculateScore_noArguments(), ale nadal dla wartości przypisanych w kodzie metody
 System.out.println("Obliczenia za pomocą metody calculateScore_noArguments(), ale nadal dla wartości przypisanych w kodzie metody");
 calculateScore_noArguments();

 // Obliczenia za pomocą metody calculateScore(), ale tym razem dla wartości wpisanych do argumentu wywołania metody
 System.out.println("Obliczenia za pomocą metody calculateScore(), ale tym razem dla wartości wpisanych do argumentu wywołania metody");
 calculateScore_arguments(true, 2500, 9, 2500);
 // można to wywołać za pomocą wcześniej zadeklarowanych zmiennych
 calculateScore_arguments(gameOver, score, levelCompleted, bonus);
 // ale widzicie, że wyświetlanie funkcji jest również z numerkiem #4 (bo takie wyświetlanie jest zapisane
 // w metodzie. Co zrobić, żeby tak nie było? Poniżej:

 // Obliczenia i wyświetlanie można uniezależnić od siebie dodając parametr, który ta metoda będzie zwracać
System.out.println("Obliczenia i wyświetlanie można uniezależnić od siebie dodając parametr, który ta metoda będzie zwracać za pomocą return");
finalScore = calculateScore_argumentsReturn(gameOver, score, levelCompleted, bonus);
 System.out.println("Twoj wynik #5 to " + finalScore);
 }

   private static void calculateScore_noArguments() {
boolean gameOver = true;
 int score = 150;
 int levelCompleted = 2;
 int bonus = 1000;

 int finalScore = score;
 if (gameOver) {
 finalScore += (levelCompleted * bonus);
 finalScore += 1000;
 System.out.println("Twoj wynik #3 to " + finalScore);
}
}
 private static void calculateScore_arguments(boolean gameOver, int score, int levelCompleted, int bonus) {
 int finalScore = score;
 if (gameOver) {
 finalScore += (levelCompleted * bonus);
 finalScore += 1000;
 System.out.println("Twoj wynik #4 to " + finalScore);
 }
 }
private static int calculateScore_argumentsReturn(boolean gameOver, int score, int levelCompleted, int bonus) {
 int finalScore = score;
 if (gameOver) {
 finalScore += (levelCompleted * bonus);
 finalScore += 1000;
 }
 return finalScore;
 }
}