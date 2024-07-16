import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        int[] array1 = {3, 1, 4};
        int[] array2 = {6, 5, 2};
        int n = 4;

        // İki diziyi birleştir
        int length1 = array1.length;
        int length2 = array2.length;
        int[] mergedArray = new int[length1 + length2];

        // İlk diziyi kopyala
        for (int i = 0; i < length1; i++) {
            mergedArray[i] = array1[i];
        }

        // İkinci diziyi kopyala
        for (int i = 0; i < length2; i++) {
            mergedArray[length1 + i] = array2[i];
        }

        // n. terime kadar olan kısmı küçükten büyüğe sırala
        Arrays.sort(mergedArray, 0, n);

        // n. terimden sonrası kısmı büyükten küçüğe sırala
        Arrays.sort(mergedArray, n, mergedArray.length);
        for (int i = n; i < (mergedArray.length + n) / 2; i++) {
            int temp = mergedArray[i];
            mergedArray[i] = mergedArray[mergedArray.length - 1 - (i - n)];
            mergedArray[mergedArray.length - 1 - (i - n)] = temp;
        }

        // Sonucu yazdır
        System.out.println(Arrays.toString(mergedArray));
    }
}