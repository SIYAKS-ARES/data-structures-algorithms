import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        HashMap hashMap = new HashMap();

        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("Seçiminizi yapın: 1. Ekle, 2. Getir, 3. Kaldır, 4. Çıkış");
            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    System.out.print("Anahtar: ");
                    int keyToAdd = scanner.nextInt();
                    System.out.print("Değer: ");
                    int valueToAdd = scanner.nextInt();
                    hashMap.put(keyToAdd, valueToAdd);
                    break;

                case 2:
                    System.out.print("Anahtar: ");
                    int keyToGet = scanner.nextInt();
                    int value = hashMap.get(keyToGet);
                    if (value == -1) {
                        System.out.println("Anahtar bulunamadı.");
                    } else {
                        System.out.println("Değer: " + value);
                    }
                    break;

                case 3:
                    System.out.print("Anahtar: ");
                    int keyToRemove = scanner.nextInt();
                    hashMap.remove(keyToRemove);
                    System.out.println("Anahtar kaldırıldı.");
                    break;

                case 4:
                    scanner.close();
                    System.out.println("Çıkış yapılıyor.");
                    return;

                default:
                    System.out.println("Geçersiz seçim.");
            }
        }
    }
}