import java.util.Scanner;

public class BinarySearch {

    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10}; // Örnek sıralı dizi
        Scanner scanner = new Scanner(System.in);
        while (true) { // Kullanıcıdan sürekli yeni hedef değer alarak arama yap
            System.out.print("Enter the target value (or type 'exit' to quit): ");
            String input = scanner.nextLine();
            if (input.equalsIgnoreCase("exit")) {
                break; // Kullanıcı 'exit' yazarsa döngüden çık ve programı sonlandır
            }
            try {
                int target = Integer.parseInt(input); // Kullanıcı girdisini tamsayıya çevir
                searchAndPrint(arr, target); // Hedef değeri arayın ve sonucu yazdırın
            } catch (NumberFormatException e) {
                System.out.println("Invalid input. Please enter a valid integer or type 'exit' to quit.");
            }
        }
        scanner.close(); // Scanner nesnesini kapat
    }
    // Binary search işlemini gerçekleştiren ve sonucu yazdıran bir yardımcı fonksiyon
    public static void searchAndPrint(int[] arr, int target) {
        int left = 0; // Arama aralığının sol sınırı
        int right = arr.length - 1; // Arama aralığının sağ sınırı
        boolean found = false; // Hedefin bulunup bulunmadığını kontrol eden değişken
        // Binary search işlemini gerçekleştir
        while (left <= right) {
            int mid = left + (right - left) / 2; // Orta indeksi hesapla
            if (arr[mid] == target) { // Orta elemanın hedef olup olmadığını kontrol et
                System.out.println("Target " + target + " found at index " + mid); // Bulunan hedefin indeksini yazdır
                found = true; // Hedef bulundu olarak değişkeni ayarla
                break; // Hedef bulunduğu için döngüden çık
            } else if (arr[mid] < target) { // Hedef orta elemandan büyükse
                left = mid + 1; // Sol sınırı mid + 1 yap
            } else { // Hedef orta elemandan küçükse
                right = mid - 1; // Sağ sınırı mid - 1 yap
            }
        }
        // Eğer hedef bulunmadıysa, mesaj yazdır
        if (!found) {
            System.out.println("Target " + target + " not found in the array.");
        }
    }
    /*int ikiliArama(int A[], int N, int sayi){
        int sol = 0;
        int sag = N-1;
        while (sol <= sag){
        int orta = (sol+sag)/2; // Test edilecek sayının indeksi
        if (A[orta] == sayi) return orta; // Aranan sayı bulundu. İndeksi döndür

        else if (sayi < A[orta]) sag = orta - 1; // Sağ tarafı ele
        else sol = orta+1; // Sol tarafı ele
        } //bitti-while

        return -1; // Aranan sayı bulunamadı
        } //End-ikiliArama */
}
