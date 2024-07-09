public interface Queue<T> {
    public boolean empty();
    public T getFront();
    public T dequeue();
    public void enqueue(T item);
    public void clear();
}