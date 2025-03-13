package ex2;

/*
2. Implementati o aplicatie Java in care:
    a) creati 2 tablouri unidimensionale de lungimi diferite, cu cate cel putin 5 elemente intregi.
    b) implementati o metoda de sortare in ordine crescatoare a elementelor fiecarui tablou creat anterior.
       Nota: se va folosi o implementare proprie, nu pe cea din clasa Arrays.
    c) creati si afisati la consola un al treilea tablou in care veti insera in ordine crescatoare toate elementele din primele 2 tablouri.

Pentru eficienta si complexitate de timp liniara, utilizati o tehnica de implementare cu 2 pointeri (cate unul pt elementele fiecarui tablou initial).
exemplu:
   Array1 initial: [1, 7, 4, 3, 9, 1]
   Array1 sortat crescator: [1, 1, 3, 4, 7, 9]
   Array2 initial: [6, 4, 2, 8]
   Array2 sortat crescator: [2, 4, 6, 8]
   Output: [1, 1, 2, 3, 4, 4, 6, 7, 8, 9]
*/

import java.util.Arrays;

public class Ex2 {
    public static void main(String[] args) {
        var arr1 = new int[]{1, 7, 4, 3, 9, 1};
        quickSort(arr1);

        var arr2 = new int[]{6, 4, 2, 8};
        quickSort(arr2);

        var merged = new int[arr1.length + arr2.length];

        var ptr1 = 0;
        var ptr2 = 0;
        var ptr = 0;
        while (ptr1 < arr1.length && ptr2 < arr2.length) {
            if (arr1[ptr1] < arr2[ptr2]) {
                merged[ptr++] = arr1[ptr1++];
            } else {
                merged[ptr++] = arr2[ptr2++];
            }
        }

        while (ptr1 < arr1.length) {
            merged[ptr++] = arr1[ptr1++];
        }
        while (ptr2 < arr2.length) {
            merged[ptr++] = arr2[ptr2++];
        }

        System.out.println(Arrays.toString(merged));
    }

    private static void swap(int[] arr, int i, int j) {
        int tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }

    private static int partition(int[] arr, int low, int high) {
        var pivot = arr[high];
        var ptr = low - 1;

        for (int idx = low; idx < high; idx++) {
            if (arr[idx] >= pivot) {
                continue;
            }

            ptr++;
            swap(arr, ptr, idx);
        }

        swap(arr, ptr + 1, high);
        return ptr + 1;
    }

    private static void quickSort(int[] arr) {
        quickSort(arr, 0, arr.length - 1);
    }

    private static void quickSort(int[] arr, int lhs, int rhs) {
        if (lhs >= rhs) {
            return;
        }

        var partIdx = partition(arr, lhs, rhs);
        quickSort(arr, lhs, partIdx - 1);
        quickSort(arr, partIdx + 1, rhs);
    }
}
