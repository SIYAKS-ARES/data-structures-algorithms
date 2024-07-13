public class Recursion {

    // Ana metod: verilen diziyi sıralar
    public static void mergeSort(int[] array) {
        if (array.length > 1) {
            // Ortayı bul ve diziyi iki alt diziye ayır
            int mid = array.length / 2;

            // Sol alt diziyi oluştur
            int[] left = new int[mid];
            for (int i = 0; i < mid; i++) {
                left[i] = array[i];
            }

            // Sağ alt diziyi oluştur
            int[] right = new int[array.length - mid];
            for (int i = mid; i < array.length; i++) {
                right[i] = array[i];
            }

            // Sol ve sağ alt dizileri özyinelemeli olarak sırala
            mergeSort(left);
            mergeSort(right);

            // İki sıralı alt diziyi birleştir
            merge(array, left, right);
        }
    }

    // Birleştirme metodunu
    private static void merge(int[] array, int[] left, int[] right) {
        int i = 0, j = 0, k = 0;

        // Sol ve sağ dizileri karşılaştırarak ana diziye yerleştir
        while (i < left.length && j < right.length) {
            if (left[i] <= right[j]) {
                array[k++] = left[i++];
            } else {
                array[k++] = right[j++];
            }
        }

        // Kalan elemanları ana diziye yerleştir
        while (i < left.length) {
            array[k++] = left[i++];
        }
        while (j < right.length) {
            array[k++] = right[j++];
        }
    }

    // Ana metod: diziyi oluşturur ve sıralar
    public static void main(String[] args) {
        int[] array = {38, 27, 43, 3, 9, 82, 10};
        System.out.println("Sıralanmamış Dizi: ");
        printArray(array);

        mergeSort(array);

        System.out.println("Sıralanmış Dizi: ");
        printArray(array);
    }

    // Diziyi yazdıran yardımcı metod
    private static void printArray(int[] array) {
        for (int i : array) {
            System.out.print(i + " ");
        }
        System.out.println();
    }
}