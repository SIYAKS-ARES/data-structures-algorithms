public class Dugum {
    public int veri;
    public Dugum sonraki;
    public Dugum onceki; // İki yönlü bağlı liste için eklendi

    public Dugum(int gelenVeri) {
        veri = gelenVeri;
    }

    public void yazdir() {
        System.out.print(" " + veri);
    }
}