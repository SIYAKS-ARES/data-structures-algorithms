public class TestArrayQueue {
    public static void main(String[] args) {
        Queue<Integer> kuyruk = new ArrayQueue<Integer>();
        for (int i = 1; i <= 25; i++)
            kuyruk.enqueue(i);
        int say = 1;
        while (!kuyruk.empty())
            System.out.println((say++) + ".kuyruk elemani: " + kuyruk.dequeue());
    }
}