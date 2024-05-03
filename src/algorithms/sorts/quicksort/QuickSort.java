package algorithms.sorts.quicksort;

import java.util.Arrays;

public class QuickSort {

    private static void swap(int[] array, int firstIndex, int secondIndex) {
        int temp = array[firstIndex];
        array[firstIndex] = array[secondIndex];
        array[secondIndex] = temp;
    }

    public static int pivot(int[] array, int pivotIndex, int endIndex) {
        int swapIndex = pivotIndex;
        for (int i = pivotIndex + 1; i <= endIndex; i++) {
            if (array[i] < array[pivotIndex]) {
                swapIndex++;
                swap(array, swapIndex, i);
            }
        }
        swap(array, pivotIndex, swapIndex);

        return swapIndex;
    }

//    public static void quickSort(int[] array, int left, int right) {
//        if (left >= right) return;
//
//        int pivotIndex = pivot(array, left, right);
//        quickSort(array, left, pivotIndex-1);
//        quickSort(array, pivotIndex+1, right);
//    }
//
//    public static void quickSort(int[] array) {
//        quickSort(array, 0, array.length-1);
//    }

    private static void quickSortHelper(int[] array, int left, int right) {
        if (left < right) {
            int pivotIndex = pivot(array, left, right);
            quickSortHelper(array, left, pivotIndex-1);
            quickSortHelper(array, pivotIndex+1, right);
        }
    }

    public static void quickSort(int[] array) {
        quickSortHelper(array, 0, array.length-1);
    }



    public static void main(String[] args) {

        int[] myArray = {4,6,1,7,3,2,5};

        int returnedIndex = pivot(myArray, 0, 6);

        System.out.println( "\nReturned Index: " + returnedIndex);

        System.out.println( Arrays.toString( myArray ) );

        /*
            EXPECTED OUTPUT:
            ----------------
            Returned Index: 3
            [2, 1, 3, 4, 6, 7, 5]

         */

    }

}

