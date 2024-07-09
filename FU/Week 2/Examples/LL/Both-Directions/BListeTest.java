public class BListeTest {
    public static void main(String[] args) {
        BListe liste = new BListe();
        liste.basaEkle(9);
        for (int i = 8; i >= 1; --i) {
            liste.basaEkle(i);
        }
        liste.listele();

        int deger = 5;
        Dugum d = liste.bul(deger);
        if (d == null) {
            System.out.println("\n" + deger + " Listede Yok");
        } else {
            System.out.println("\n" + deger + " Bulundu");
        }

        Dugum s = liste.sil(5);
        liste.listele();
        System.err.println(s);
    }
}