public class Main {
    public static void main(String[] args) {
        LinkedList liste = new LinkedList();
        liste.basaEkle(1);
        liste.basaEkle(2);
        liste.sonaEkle(3);
        liste.sonaEkle(4);
        liste.yazdir(); // Çıktı: 2 1 3 4
    }
}