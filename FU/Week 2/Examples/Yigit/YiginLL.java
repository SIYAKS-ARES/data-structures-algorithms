class YiginLL {
    private LinkedListStack ust;

    public YiginLL() {
        ust = null;
    }

    public void koy(int eleman) {
        LinkedListStack x = new LinkedListStack(eleman);
        x.sonraki = ust;
        ust = x;
    }

    public boolean bosmu() {
        return ust == null;
    }

    public int al() {
        if (bosmu()) {
            System.out.println("Stack underflow");
            return -1;
        }
        LinkedListStack temp = ust;
        ust = ust.sonraki;
        return temp.eleman;
    }

    public int ust() {
        if (bosmu()) {
            System.out.println("Stack underflow");
            return -1;
        }
        return ust.eleman;
    }

    public static void main(String[] args) {
        YiginLL y = new YiginLL();
        if (y.bosmu())
            System.out.println("Yığın boş");
        y.koy(49);
        y.koy(23);
        System.out.println("Yığının ilk elemanı: " + y.al());
        y.koy(44);
        y.koy(22);
        System.out.println("Yığının ilk elemanı: " + y.al());
        System.out.println("Yığının ilk elemanı: " + y.al());
        System.out.println("Yığının ilk elemanı: " + y.ust());
        System.out.println("Yığının ilk elemanı: " + y.al());
        if (y.bosmu())
            System.out.println("Yığın boş");
    }
}