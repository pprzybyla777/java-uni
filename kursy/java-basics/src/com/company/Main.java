package com.company;

import java.util.*;

// Hash Map

public class Main {

    public static void main(String[] args) {

        // 1:42:16

    }
}

/*

// HashSet

public class Main {

    public static void main(String[] args) {
        Set<String> meals = new HashSet<>();

        meals.add("Pizza");
        meals.add("Pizza"); // pozbędzie się duplikatów
        meals.add("Jajka");
        meals.add("Masło");
        meals.add("Truskawki");

        System.out.println(meals);

        for (String meal : meals) {
            System.out.println(meal);
        }

    }
}

*/


// Array List


/*

public class Main {

    public static void main(String[] args) {

        List<String> names = new ArrayList<>();
        names.add("Ola");
        names.add("Jan");

        System.out.println(names);

        for ( String name : names ) {
            System.out.println(name);
        }

        // Usuwanie

        names.remove(0); // po indeksie

        System.out.println(names);

        names.remove("Jan"); // po pierwszym znalezionym elemencie

        System.out.println(names);

        // Dodawanie - nawet na wskazane miejsce

        // .contains()
        System.out.println(names.contains("Jan"));

        // branie z listy - .get() -> w Arr to by było names[0];

        names.add("Ola");

        System.out.println(names.get(0));
        // System.out.println(names.get(-1)); // out Of Bounds err

        // getting last item of an arry
        System.out.println(names.get(names.size() - 1));

        // isEmpty()

        // sortowanie

        names.add("Adam");
        names.add("Zenek");

        Collections.sort(names);

        System.out.println(names);

    }
}

*/


/*

// TABLICE

public class Main {

    public static void main(String[] args) {

    // Arrays - zawsze trzeba podać długość

       String[] names = new String[4];
       names[0] = "Ania";
       names[1] = "Ola";
       names[2] = "Ela";
       names[3] = "Ala";

       // lub

        String[] names2 = {"Marek", "Arek", "Czarek"}; // inicjalizacja array'a z wartościami

        System.out.println(Arrays.toString(names));
        names[2] = "Krzysiuuuu"; // reassignment
        System.out.println(Arrays.toString(names));

        System.out.println("");

        for (int i = 0; i < names.length; i++) {
            System.out.println(names[i]);
        }

        System.out.println("");

        for (String name : names) {
            System.out.println(name);
        }

        System.out.println("");

        for (String name : names2 ) {
            System.out.println(name);
        }

    }
}

*/


// zgadywanie liczby od 1 do 1000

/*

public class Main {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        Random random = new Random();
        int numberToGuess = random.nextInt(1000) + 1;

        boolean flag = true;

        while (flag) {

            System.out.print("Enter number: ");
            int guess = scanner.nextInt();

            if (guess == numberToGuess) {
                System.out.println("Congratulations!!!");
                flag = false;
            } else if (guess > numberToGuess) {
                System.out.println("Entered number is too high");
            } else {
                System.out.println("Entered number is too low");
            }
        }
    }
}

*/



/*

// FizzBuzz

public class Main {

    public static void main(String[] args) {

        for (int i = 1; i < 101; i++) {

            if (i % 15 == 0) {
                System.out.println("FizzBuzz");
            } else if (i % 3 == 0) {
                System.out.println("Fizz");
            } else if (i % 5 == 0) {
                System.out.println("Buzz");
            } else {
                System.out.println(i);
            }
        }
    }
}
*/


/*

// Pętla for

public class Main {

    public static void main(String[] args) {

        // pętla for
        for (int i = 0, j = 4; i < 4 ; i++, j--) {
            System.out.println(i);
            // i++, i--, i+= 2
            System.out.println(j);
        }

        // pętla while
        int i = 0;

        while (i < 4) {
            System.out.println("i mniejesze od 4");
            i++;
        }

        //  do while

        do {
            System.out.println("always at least once");
        } while (false);

        // ! dla pętl istnieją słowa kluczowe break oraz continue

    }
}

*/


/*

// typ String, typy numeryczne, typ boolean

public class Main {

    public static void main(String[] args) {

        String firstName = "Kamil";
        String lastName = "Ślimak";

        // łączenie
        System.out.println(firstName + " " + lastName);

        // na liczbach można wykonywać wszystkie działania arytmetyczne

        int a = 6;
        int b = 3;

        System.out.println(a / b);
        System.out.println(b / a); // int nie przechowują liczb po przecinku

        double a2 = 6.0;
        double b2 = 3.0;

        System.out.println(b2 / a2);

        // operator modulo %
        System.out.println(a % b);
        System.out.println(7 % 3);

        // operatory dla liczb: >, <, ==, !=, >=, <=
        // ! String są porównywane przez isEqual() !

        boolean isSkyBlue = true;

        if (isSkyBlue) {
            System.out.println("wow such blue sky!");
        } else {
            System.out.println(" sky is not blue");
        }

    }
}
*/


/*

// program pobierający wiek użytkownika i sprawdzający pełnoletność

public class Main {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        System.out.print("age: ");
        int age = scanner.nextInt();

        if ( age >= 18 ) {
            System.out.println("Pełnoletni");
        } else {
            System.out.println("Nie pełnoletni");
        }

        // Typy:
        // Prymitywne - przechowują wartość
        // [8]: byte, short, int, long, float, double, boolean, char
        // Referencyjne - mają metody

        // Java to język statycznie typowany
        // deklarując zmienną podajemy typ, który nie może ulec zmianie

        // Type inference
        // var name = "Ola" // name automatycznie ma typ String

    }
}

*/


// program pobierający imię i witający użytkownika

/*

public class Main {

    public static void main(String[] args) {


        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter name: ");
        String name = scanner.nextLine(); // camelCase in vars' naming

        if ( !name.equals("Barnaba") && name.endsWith("a")) {
            System.out.println("jesteś kobietą");
        } else if (!name.isEmpty() || name.equals("Barnaba")) {
            System.out.println("jesteś mężczyzną");
        }

        // operatory: &&, ||, !

        System.out.println("Hi " + name);


    }
}

*/