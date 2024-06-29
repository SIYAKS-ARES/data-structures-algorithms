class CircularLinkedList {
    Node head;
    Node tail;

    class Node {
        int data;
        Node next;

        Node(int data) {
            this.data = data;
        }
    }

    // Baştan ekleme
    public void addAtBeginning(int data) {
        Node newNode = new Node(data);
        if (head == null) {
            head = newNode;
            tail = newNode;
            newNode.next = head;
        } else {
            newNode.next = head;
            head = newNode;
            tail.next = head;
        }
    }

    // Sondan ekleme
    public void addAtEnd(int data) {
        Node newNode = new Node(data);
        if (tail == null) {
            head = newNode;
            tail = newNode;
            newNode.next = head;
        } else {
            tail.next = newNode;
            tail = newNode;
            tail.next = head;
        }
    }

    // İstenilen sırada ekleme
    public void addAtPosition(int data, int position) {
        if (position == 0) {
            addAtBeginning(data);
            return;
        }

        Node newNode = new Node(data);
        Node current = head;
        for (int i = 1; i < position; i++) {
            current = current.next;
            if (current == head) {
                throw new IndexOutOfBoundsException("Position out of bounds");
            }
        }
        newNode.next = current.next;
        current.next = newNode;
        if (newNode.next == head) {
            tail = newNode;
        }
    }

    // Baştan silme
    public void deleteFromBeginning() {
        if (head == null) {
            return;
        }
        if (head == tail) {
            head = null;
            tail = null;
        } else {
            head = head.next;
            tail.next = head;
        }
    }

    // Sondan silme
    public void deleteFromEnd() {
        if (head == null) {
            return;
        }
        if (head == tail) {
            head = null;
            tail = null;
        } else {
            Node current = head;
            while (current.next != tail) {
                current = current.next;
            }
            current.next = head;
            tail = current;
        }
    }

    // İstenilen sırada silme
    public void deleteFromPosition(int position) {
        if (position == 0) {
            deleteFromBeginning();
            return;
        }

        Node current = head;
        Node previous = null;
        for (int i = 0; i < position; i++) {
            previous = current;
            current = current.next;
            if (current == head) {
                throw new IndexOutOfBoundsException("Position out of bounds");
            }
        }
        previous.next = current.next;
        if (current == tail) {
            tail = previous;
        }
    }

    // Listeyi yazdırma
    public void display() {
        if (head == null) {
            System.out.println("List is empty");
            return;
        }
        Node current = head;
        do {
            System.out.print(current.data + " ");
            current = current.next;
        } while (current != head);
        System.out.println();
    }

    public static void main(String[] args) {
        CircularLinkedList list = new CircularLinkedList();

        // Ekleme işlemleri
        list.addAtBeginning(1);
        list.addAtEnd(3);
        list.addAtPosition(2, 1);
        list.display(); // Çıktı: 1 2 3

        // Silme işlemleri
        list.deleteFromBeginning();
        list.display(); // Çıktı: 2 3

        list.deleteFromEnd();
        list.display(); // Çıktı: 2

        list.addAtEnd(4);
        list.addAtEnd(5);
        list.display(); // Çıktı: 2 4 5

        list.deleteFromPosition(1);
        list.display(); // Çıktı: 2 5
    }
}