public class Kuyruk {
    private static final int N = 100; // Maksimum kuyruk boyutu
    private int[] K;    // kuyruk elemanlarını tutan dizi
    private int on;     // kuyruğun başı
    private int arka;   // kuyruğun sonu
    private int elemanSayisi; // kuyruktaki eleman sayısı
    
    // Yapıcı metot
    public Kuyruk() {
        K = new int[N];
        on = arka = elemanSayisi = 0;
    }
    
    // Kuyruk boş mu kontrolü
    public boolean bosmu() {
        return elemanSayisi == 0;
    }
    
    // Kuyruk dolu mu kontrolü
    public boolean dolumu() {
        return elemanSayisi == N;
    }
    
    // Kuyruğa yeni bir eleman ekle
    // Başarılı olursa 0, başarısız olursa -1 döndür
    public int ekle(int yeni) {
        if (dolumu()) {
            System.out.println("Kuyruk dolu.");
            return -1;
        }
        K[arka] = yeni;   // Yeni elemanı sona koy
        arka++;
        if (arka == N) arka = 0;
        elemanSayisi++;
        return 0;
    }
    
    // Kuyruğun önündeki elemanı çıkart ve döndür
    // Kuyruk boşsa -1 döndür
    public int cikart() {
        if (bosmu()) {
            System.out.println("Kuyruk boş.");
            return -1;
        }
        int cikartilan = K[on];  // İlk elemanı al
        on++;
        if (on == N) on = 0;
        elemanSayisi--;
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