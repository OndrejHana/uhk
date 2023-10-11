import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        var bob = new Scanner(System.in);

//        var bob = new Scanner(System.in);
//
//        System.out.println("choose a number");
//        var a = bob.nextInt();
//
//        if (a > 10) {
//            System.out.println("Vetsi nez 10");
//        } else {
//            System.out.println("10 nebo mene");
//        }

//
//        System.out.println("choose a number");
//        var a = bob.nextInt();
//
//        var factorial = factorial(a);
//
//        System.out.println(factorial);
//

//        int correct = 10;
//        int guess;
//        do {
//            System.out.println("Guess a number");
//            guess = bob.nextInt();
//        } while (correct != guess);
//        System.out.println("Correct!");

        int count = 10;

        int n1 = 0;
        int n2 = 1;

        for(int i=0; i<=count; i++) {
            int curr = n1 + n2;
            System.out.println(curr);
            n1 = n2;
            n2 = curr;
        }
    }

    public static int factorial(int n) {
        int factorial = 1;

        for (int i = n; i > 0; i--) {
            factorial *= i;
        }

        return factorial;
    }

}
