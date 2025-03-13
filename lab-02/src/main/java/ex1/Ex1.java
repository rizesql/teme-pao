package ex1;

import java.util.Arrays;
import java.util.Scanner;

/*
1. Implementati o aplicatie Java in care:
    a) cititi de la tastatura un numar intreg n cuprins intre [0, 5].
       Nota: interactiunea cu userul va continua atat timp cat acesta nu a furnizat o valoare valida.
    b) creati un tablou unidimensional de lungime n, ale carui elemente intregi le cititi de la tastatura.
    c) implementati o metoda care realizeaza inversarea ordinii initiale a elementelor tabloului si afisarea lui in consola.

exemplu: Input: [2, 4, 1, 5, 3]
         Output: [3, 5, 1, 4, 2]
*/

public class Ex1 {
    public static void main(String[] args) {
        try (var in = new Scanner(System.in)) {
            int n;
            while (!withinRange(n = in.nextInt())) {
                System.out.println("Numarul trebuie sa fie inclus in intervalul [" + rangeMin + "," + rangeMax + "]");
            }

            var vec = new int[n];
            for (int idx = 0; idx < n; idx++) {
                vec[idx] = in.nextInt();
            }

            printReversed(vec);
        }
    }

    private static int rangeMin = 0;
    private static int rangeMax = 5;

    private static boolean withinRange(int n) {
        return rangeMin <= n && n <= rangeMax;
    }

    private static void printReversed(int[] arr) {
        for (var idx = 0; idx < arr.length / 2; idx++) {
            int tmp = arr[idx];
            arr[idx] = arr[arr.length - 1 - idx];
            arr[arr.length - 1 - idx] = tmp;
        }

        System.out.println(Arrays.toString(arr));
    }
}
