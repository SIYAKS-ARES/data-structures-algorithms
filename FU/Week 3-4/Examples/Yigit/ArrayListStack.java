import java.util.*;

public class ArrayListStack<T> implements Stack<T> {
    private ArrayList<T> array; // yığıt elemanlarını tutan dizi

    public ArrayListStack() {
        array = new ArrayList<T>();
    }

    public boolean empty() {
        return array.size() == 0;
    }

    public T top() {
        if (empty()) return null;
        return array.get(array.size() - 1);
    }

    public T pop() {
        if (empty()) return null;
        return array.remove(array.size() - 1);
    }

    public void push(T item) {
        array.add(item);
    }

    public void clear() {
        array.clear();
    }
}