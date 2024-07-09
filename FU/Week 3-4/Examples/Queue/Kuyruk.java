public class Kuyruk {
    private int boyut;
    private int[] kuyrukDizi;
    private int bas;
    private int son;
    private int elemanSayisi;
    
    public Kuyruk(int s) {
        boyut = s;
        kuyrukDizi = new int[boyut];
        bas = 0;
        son = -1;
        elemanSayisi = 0;
    }
    
    public void ekle(int j) {
        if (son == boyut - 1) son = -1;
        kuyrukDizi[++son] = j;
        elemanSayisi++;
    }
    
    public int cikar() {
        int temp = kuyrukDizi[bas++];
        if (bas == boyut) bas = 0;
        elemanSayisi--;
        return temp;
    }
    
    public boolean bosMu() {
        return (elemanSayisi == 0);
    }
    
    public static void main(String args[]) {
        Kuyruk k = new Kuyruk(25);
        k.ekle(1);
        k.ekle(2);
        System.out.println(k.cikar());
        k.ekle(3);
        for (int i = 4; i < 10; ++i)
            k.ekle(i);
        while (!k.bosMu())
            System.out.println(k.cikar());
    }
}