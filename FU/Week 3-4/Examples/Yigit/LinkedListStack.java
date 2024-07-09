public class LinkedListStack<T> implements Stack<T> {
    private Node<T> top = null; // yığıtın tepesindeki eleman

    public boolean empty() {
        return top == null;
    }

    public T top() {
        if (empty()) return null;
        return top.data;
    }

    public T pop() {
        if (empty()) return null;
        T temp = top.data;
        top = top.next;
        return temp;
    }

    public void push(T item) {
        Node<T> newNode = new Node<T>();
        newNode.data = item;
        newNode.next = top;
        top = newNode;
    }

    public void clear() {
        top = null;
    }

    // Yığıt elemanlarını tutan liste elemanı (inner class)
    class Node<T> {
        public T data;
        public Node<T> next;
    }
}