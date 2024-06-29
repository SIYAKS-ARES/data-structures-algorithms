import java.util.Arrays;

public class MergeAndSortArrays {
    /* Javadoc kullanımı
     * Verilen 2 diziyi birleştirip n. terime kadar küçükten büyüğe n. terimden sonra büyükten küçüğe sıralama
     */

    public static void main(String[] args) {
        int[] array1 = {1, 3, 5, 7, 9}; // İlk dizi
        int[] array2 = {2, 4, 6, 8, 10}; // İkinci dizi
        int n = 5; // Kaçıncı terime kadar küçükten büyüğe sıralanacağını belirten değişken

        // mergeAndSort metodunu çağırarak iki diziyi birleştirip sıralanmış bir dizi elde ediyoruz
        Integer[] mergedArray = mergeAndSort(array1, array2, n);
        // Sıralanmış diziyi ekrana yazdırıyoruz
        System.out.println(Arrays.toString(mergedArray));
    }

    /**
     * Verilen iki diziyi birleştirir ve n. terime kadar küçükten büyüğe, n. terimden sonra ise büyükten küçüğe sıralar
     * @param array1 Birinci dizi
     * @param array2 İkinci dizi
     * @param n Kaçıncı terime kadar küçükten büyüğe sıralanacağını belirten değişken
     * @return Birleştirilmiş ve sıralanmış dizi
     */
    public static Integer[] mergeAndSort(int[] array1, int[] array2, int n) {
        int length = array1.length + array2.length; // İki dizinin toplam uzunluğu
        Integer[] mergedArray = new Integer[length]; // Birleştirilmiş diziyi oluşturmak için yeni bir dizi

        int i = 0; // Birleştirilmiş diziye eleman eklemek için kullanılan indeks
        for (int num : array1) { // Dizinin tüm elemanlarını sırayla geçer ve her elemanı num değişkenine atar.
            mergedArray[i++] = num; // Birinci dizinin elemanlarını birleştirilmiş diziye ekler
        }

        // İkinci dizinin elemanlarını sondan başlayarak birleştirilmiş diziye ekler
        for (int j = array2.length - 1; j >= 0; j--) { // Dizinin tüm elemanlarını sondan başlayarak sırayla num'a atar.
            mergedArray[i++] = array2[j];
        }

        // İlk n elemanı küçükten büyüğe sıralar
        selectionSort(mergedArray, 0, n, true);
        // n. elemandan itibaren büyükten küçüğe sıralar
        selectionSort(mergedArray, n, length, false);

        return mergedArray; // Birleştirilmiş ve sıralanmış diziyi döndürür
    }

    /**
     * Verilen aralıktaki elemanları belirtilen sırada sıralar
     * @param array Sıralanacak dizi
     * @param start Başlangıç indeksi
     * @param end Bitiş indeksi
     * @param ascending Artan sırada sıralama yapılacaksa true, azalan sırada sıralama yapılacaksa false
     */
    private static void selectionSort(Integer[] array, int start, int end, boolean ascending) {
        for (int i = start; i < end - 1; i++) {
            int index = i;
            for (int j = i + 1; j < end; j++) {
                if (ascending ? array[j] < array[index] : array[j] > array[index]) {
                    index = j;
                }
            }
            // Swap elements
            int temp = array[index];
            array[index] = array[i];
            array[i] = temp;
        }
    }
}