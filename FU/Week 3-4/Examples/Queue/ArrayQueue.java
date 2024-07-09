public class ArrayQueue<T> implements Queue<T> {
    private static final int DEFAULT_SIZE = 10;
    private T[] array;
    private int size;
    private int front;
    private int back;
    
    public ArrayQueue() {
        array = (T[]) new Object[DEFAULT_SIZE];
        clear();
    }
    
    public boolean empty() {
        return size == 0;
    }
    
    public T getFront() {
        if (empty()) return null;
        return array[front];
    }
    
    public T dequeue() {
        if (empty()) return null;
        size--;
        T temp = array[front];
        front = increment(front);
        return temp;
    }
    
    public void enqueue(T item) {
        if (size == array.length) {
            T[] newArray = (T[]) new Object[array.length * 2];
            for (int i = 0; i < size; i++, front = increment(front))
                newArray[i] = array[front];
            array = newArray;
        }
        back = increment(back);
        array[back] = item;
        size++;
    }
    
    private int increment(int i) {
        i++;
        if (i == array.length) i = 0;
        return i;
    }
    
    public void clear() {
        size = 0;
        front = 0;
        back = -1;
    }
    
    public static void main(String[] args) {
        Queue<Integer> kuyruk = new ArrayQueue<Integer>();
        for (int i = 1; i <= 25; i++)
            kuyruk.enqueue(i);
        int say = 1;
        while (!kuyruk.empty())
            System.out.println((say++) + ".kuyruk elemani: " + kuyruk.dequeue());
    }
}