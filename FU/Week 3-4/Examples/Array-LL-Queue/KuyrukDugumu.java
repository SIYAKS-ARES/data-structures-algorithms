public class KuyrukDugumu {
    public int eleman;
    public KuyrukDugumu sonraki; 
    
    public KuyrukDugumu(int e){
        eleman = e;
        sonraki = null;
    }
}

public class Kuyruk {
    private KuyrukDugumu on; // Kuyruğun önü
    private KuyrukDugumu arka; // Kuyruğun arkası
    
    // Yapıcı metot
    public Kuyruk() {
        on = arka = null;
    }
    
    // Kuyruk boş mu kontrolü
    public boolean bosmu() {
        return on == null;
    }
    
    // Kuyruğa yeni bir eleman ekle
    public void ekle(int eleman) {
        KuyrukDugumu yeni = new KuyrukDugumu(eleman);
        if (bosmu()) {
            on = arka = yeni;
        } else {
            arka.sonraki = yeni;
            arka = yeni;
        }
    }
    
    // Kuyruğun başındaki elemanı çıkart ve döndür
    // Kuyruk boşsa -1 döndür
    public int cikart() {
        if (bosmu()) {
            System.out.println("Kuyruk boş.");
            return -1;
        }
        int cikartilan = on.eleman;
        on = on.sonraki;
        if (on == null) {
            arka = null;
        }
        return cikartilan;
    }
    
    public static void main(String[] args) {
        Kuyruk k = new Kuyruk();
        
        if (k.bosmu()) 
            System.out.println("Kuyruk boş.");
        
        k.ekle(49);
        k.ekle(23);
        System.out.println("Kuyruğun önü: " + k.cikart());
        
        k.ekle(44);
        k.ekle(22);
        System.out.println("Kuyruğun ilk elemanı: " + k.cikart());
        System.out.println("Kuyruğun ilk elemanı: " + k.cikart());
        System.out.println("Kuyruğun ilk elemanı: " + k.cikart());
        System.out.println("Kuyruğun ilk elemanı: " + k.cikart()); 
        
        if (k.bosmu()) 
            System.out.println("Kuyruk boş.");
    }
}