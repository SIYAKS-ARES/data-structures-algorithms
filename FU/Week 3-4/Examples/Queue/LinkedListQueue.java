public class LinkedListQueue<T> implements Queue<T> {
    private Node<T> front, back;
    
    public LinkedListQueue() {
        clear();
    }
    
    public boolean empty() {
        return front == null;
    }
    
    public T getFront() {
        if (empty()) return null;
        return front.data;
    }
    
    public T dequeue() {
        if (empty()) return null;
        T temp = front.data;
        front = front.next;
        return temp;
    }
    
    public void enqueue(T item) {
        if (empty())
            front = back = new Node<T>(item, null);
        else
            back = back.next = new Node<T>(item, null);
    }
    
    public void clear() {
        front = back = null;
    }
    
    private class Node<T> {
        private T data;
        private Node<T> next;
        
        public Node(T data, Node<T> next) {
            this.data = data;
            this.next = next;
        }
    }
    
    public static void main(String[] args) {
        Queue<Integer> kuyruk = new LinkedListQueue<Integer>();
        for (int j = 1, i = 1; i <= 20; i++) {
            if ((int) (Math.random() * 2) == 1) {
                System.out.println("Kuyruga ekle: " + j);
                kuyruk.enqueue(j++);
            } else {
                System.out.println("Kuyrugun onundeki " + kuyruk.dequeue() + " cikarildi..");
            }
        }
    }
}