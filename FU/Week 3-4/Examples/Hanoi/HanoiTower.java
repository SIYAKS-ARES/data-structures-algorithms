import java.util.Scanner;

public class HanoiTower {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Kullanıcıdan disk sayısını al
        System.out.print("Kaç disk kullanmak istiyorsunuz? ");
        int disks = scanner.nextInt();

        // Hanoi Kuleleri çözümünü hesapla ve ekrana yazdır
        System.out.println("\nHanoi Kuleleri Çözümü:");
        solveHanoi(disks, 'A', 'B', 'C');

        scanner.close();
    }

    /**
     * Hanoi Kuleleri problemi için özyinelemeli çözüm.
     * @param n: Taşınacak disk sayısı
     * @param source: Kaynak çubuk
     * @param auxiliary: Yardımcı çubuk
     * @param destination: Hedef çubuk
     */
    public static void solveHanoi(int n, char source, char auxiliary, char destination) {
        if (n == 1) {
            System.out.println(source + " -> " + destination);
        } else {
            solveHanoi(n - 1, source, destination, auxiliary);
            System.out.println(source + " -> " + destination);
            solveHanoi(n - 1, auxiliary, source, destination);
        }
    }
}