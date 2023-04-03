import java.math.BigInteger;
import java.util.Scanner;

// 2^n

public class Main {
    public static void main(String[] args) {
        System.out.println("Ta klasa służy do liczenia 2 do potęgi n");

            Scanner scanner = new Scanner(System.in);
            System.out.print("Podaj liczbę n: ");
            int n = scanner.nextInt();
            BigInteger result = factorial(n);
            System.out.println(n + "! = " + result);

    }

    public static BigInteger factorial(int n) {

        if (n < 0) {
            throw new IllegalArgumentException("Nie można liczyć silni z ujemnej liczby");
        }

        BigInteger result = BigInteger.ONE;
        for (int i = 1; i <= n; i++) {
            result = result.multiply(BigInteger.valueOf(i));
        }
        return result;
    }
}

// SILNIA

//public class Main {
//    public static void main(String[] args) {
//        System.out.println("Ta klasa służy do printowania silni!");
//
//            boolean isOn = true;
//
//            while(isOn) {
//                Scanner scanner = new Scanner(System.in);
//                System.out.print("Podaj liczbę n: ");
//                int n = scanner.nextInt();
//                BigInteger result = factorial(n);
//                System.out.println(n + "! = " + result);
//
//                System.out.print("Wpisz -1 aby zakończyć program: ");
//                int answer = scanner.nextInt();
//
//                if (answer == -1) {
//                    isOn = false;
//                    System.out.print("Program zakończony");
//                }
//            }
//    }
//
//    public static BigInteger factorial(int n) {
//
//        if (n < 0) {
//            throw new IllegalArgumentException("Nie można liczyć silni z ujemnej liczby");
//        }
//
//        BigInteger result = BigInteger.ONE;
//        for (int i = 1; i <= n; i++) {
//            result = result.multiply(BigInteger.valueOf(i));
//        }
//        return result;
//    }
//}