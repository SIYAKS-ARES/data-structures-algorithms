public class BListe {
    private Dugum bas;
    private Dugum son;

    public BListe() {
        bas = null;
        son = null;
    }

    public void basaEkle(int yeniEleman) {
        Dugum yeniDugum = new Dugum(yeniEleman);
        yeniDugum.sonraki = bas;
        if (bas != null) {
            bas.onceki = yeniDugum;
        }
        bas = yeniDugum;
        if (son == null) {
            son = yeniDugum;
        }
    }

    public void sonaEkle(int yeniEleman) {
        Dugum yeni = new Dugum(yeniEleman);
        yeni.sonraki = null;
        if (bas == null) {
            bas = yeni;
            son = yeni;
        } else {
            son.sonraki = yeni;
            yeni.onceki = son;
            son = yeni;
        }
    }

    public Dugum bul(int anahtar) {
        Dugum etkin = bas;
        while (etkin.veri != anahtar) {
            if (etkin.sonraki == null) {
                return null;
            } else {
                etkin = etkin.sonraki;
            }
        }
        return etkin;
    }

    public Dugum sil(int anahtar) {
        Dugum etkin = bas;
        Dugum onceki = bas;
        while (etkin.veri != anahtar) {
            if (etkin.sonraki == null) {
                return null;
            } else {
                onceki = etkin;
                etkin = etkin.sonraki;
            }
        }
        if (etkin == bas) {
            bas = bas.sonraki;
            if (bas != null) {
                bas.onceki = null;
            }
        } else {
            onceki.sonraki = etkin.sonraki;
            if (etkin.sonraki != null) {
                etkin.sonraki.onceki = onceki;
            }
        }
        return etkin;
    }

    public void listele() {
        System.out.println();
        System.out.print("Bastan Sona Liste : ");
        Dugum etkin = bas;
        while (etkin != null) {
            etkin.yazdir();
            etkin = etkin.sonraki;
        }
        System.out.println();
    }
}