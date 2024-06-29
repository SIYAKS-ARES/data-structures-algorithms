import java.util.Arrays;
import java.util.Collections;

public class MergeAndSortArrays {

    public static void main(String[] args) {
        int[] array1 = {1, 3, 5, 7, 9};
        int[] array2 = {2, 4, 6, 8, 10};
        int n = 5;

        Integer[] mergedArray = mergeAndSort(array1, array2, n);
        System.out.println(Arrays.toString(mergedArray));
    }

    public static Integer[] mergeAndSort(int[] array1, int[] array2, int n) {
        int length = array1.length + array2.length;
        Integer[] mergedArray = new Integer[length];

        int i = 0;
        for (int num : array1) {
            mergedArray[i++] = num;
        }
        for (int num : array2) {
            mergedArray[i++] = num;
        }

        Arrays.sort(mergedArray, 0, n);
        Arrays.sort(mergedArray, n, length, Collections.reverseOrder());

        return mergedArray;
    }
}