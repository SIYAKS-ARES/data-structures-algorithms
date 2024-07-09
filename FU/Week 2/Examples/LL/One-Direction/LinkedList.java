public class LinkedList {
    private Node ilk, son;

    // Bir BListe nesnesi yaratıldığında boş liste olarak açılır.
    public LinkedList() {
        ilk = null;
    }

    // Liste başına eleman ekler
    public void basaEkle(int data) {
        Node yeni = new Node();
        yeni.veri = data;
        yeni.kuyruk = ilk;
        ilk = yeni;
        if (son == null) {
            son = yeni;
        }
    }

    // Liste sonuna eleman ekler
    public void sonaEkle(int data) {
        Node yeni = new Node();
        yeni.veri = data;
        yeni.kuyruk = null;
        if (ilk == null) {
            ilk = yeni;
            son = yeni;
        } else {
            son.kuyruk = yeni;
            son = yeni;
        }
    }

    // Listeyi yazdırır
    public void yazdir() {
        Node mevcut = ilk;
        while (mevcut != null) {
            mevcut.yazdir();
            mevcut = mevcut.kuyruk;
        }
        System.out.println();
    }
}