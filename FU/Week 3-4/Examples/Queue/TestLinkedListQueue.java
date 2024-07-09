public class TestLinkedListQueue {
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