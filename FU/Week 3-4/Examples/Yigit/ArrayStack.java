public class ArrayStack<T> implements Stack<T> {
    private static final int DEFAULT_SIZE = 10;
    private T[] array; // yığıt elemanlarını tutan dizi
    private int top; // son eklenen elemanın indisi

    public ArrayStack() {
        array = (T[]) new Object[DEFAULT_SIZE];
        top = -1;
    }

    public boolean empty() {
        return (top == -1);
    }

    public T top() {
        if (empty()) return null;
        return array[top];
    }

    public T pop() {
        if (empty()) return null;
        return array[top--];
    }

    public void push(T item) {
        if (top + 1 == array.length) {
            T[] newArray = (T[]) new Object[array.length * 2];
            for (int i = 0; i < array.length; i++)
                newArray[i] = array[i];
            array = newArray;
        }
        array[++top] = item;
    }

    public void clear() {
        top = -1;
    }
}