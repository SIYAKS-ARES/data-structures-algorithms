public interface Stack<T> {
    public boolean empty(); // yığıt boş mu test eder
    public T top(); // tepedeki elemanı ver (silme)
    public T pop(); // tepedeki elemanı sil ve ver
    public void push(T item); // item'i yığıtın tepesine ekle
    public void clear(); // Yığıtı boşalt
}