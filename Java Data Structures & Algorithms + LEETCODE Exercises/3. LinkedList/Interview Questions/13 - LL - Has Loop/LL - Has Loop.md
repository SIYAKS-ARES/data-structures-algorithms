# LL: Has Loop ( ** Interview Question)

Write a method called hasLoop that is part of the linked list class.

The method should be able to detect if there is a cycle or loop present in the linked list.

You are required to use Floyd's cycle-finding algorithm (also known as the "tortoise and the hare" algorithm) to detect the loop.

This algorithm uses two pointers: a slow pointer and a fast pointer. The slow pointer moves one step at a time, while the fast pointer moves two steps at a time. If there is a loop in the linked list, the two pointers will eventually meet at some point. If there is no loop, the fast pointer will reach the end of the list.

The method should follow these guidelines:

Create two pointers, slow and fast, both initially pointing to the head of the linked list.

Traverse the list with the slow pointer moving one step at a time, while the fast pointer moves two steps at a time.

If there is a loop in the list, the fast pointer will eventually meet the slow pointer. If this occurs, the method should return true.

If the fast pointer reaches the end of the list or encounters a null value, it means there is no loop in the list. In this case, the method should return false.

Output:

Return true if the linked list has a loop.

Return false if the linked list does not have a loop.

Constraints:

You are not allowed to use any additional data structures (such as arrays) or modify the existing data structure.

You can only traverse the linked list once.

Method signature:

public boolean hasLoop()

If your Linked List contains a loop, it indicates a flaw in its implementation. This situation can manifest in several ways:

![alt text](https://img-c.udemycdn.com/redactor/raw/coding_exercise_instructions/2023-09-23_16-44-06-2c9d03890de71b1b59ccbbdce809f186.png)

![alt text](https://img-c.udemycdn.com/redactor/raw/coding_exercise_instructions/2023-09-23_16-44-06-d3aa6028d032c1e2768a686e703a6d82.png)

![alt text](https://img-c.udemycdn.com/redactor/raw/coding_exercise_instructions/2024-02-05_17-26-29-93e236365742f0a0269c6316cbe326c5.png)

Note:

In this problem, you should use the slow and fast pointer technique (also known as Floyd's Tortoise and Hare algorithm) to efficiently detect the presence of a loop in the linked list.

![alt text](https://img-c.udemycdn.com/redactor/raw/coding_exercise_instructions/2023-06-10_22-14-06-7509c1961eb87b1827dde3f992600554.png)

## Some Informations About "tortoise and the hare"

Floyd's cycle-finding algorithm, also known as the "tortoise and the hare" algorithm, is an efficient way to detect cycles in a linked list. It uses two pointers that traverse the list at different speeds. Here is a detailed explanation of the algorithm and how to implement it in a linked list class.

Explanation
Initialize Two Pointers: Start with two pointers, slow and fast. Both pointers begin at the head of the linked list.
Traversal:
Move the slow pointer one step at a time.
Move the fast pointer two steps at a time.
Cycle Detection:
If there is no cycle, the fast pointer will reach the end of the list (null) before the slow pointer, indicating there is no cycle.
If there is a cycle, the fast pointer will eventually meet the slow pointer within the cycle.

## My Attempt

    public class LinkedList {

        private Node head;
        private Node tail;
        private int length;

        class Node {
            int value;
            Node next;

            Node(int value) {
                this.value = value;
            }
        }

        public LinkedList(int value) {
            Node newNode = new Node(value);
            head = newNode;
            tail = newNode;
            length = 1;
        }

        public Node getHead() {
            return head;
        }

        public Node getTail() {
            return tail;
        }

        public int getLength() {
            return length;
        }

        public void printList() {
            Node temp = head;
            while (temp != null) {
                System.out.println(temp.value);
                temp = temp.next;
            }
        }

        public void printAll() {
            if (length == 0) {
                System.out.println("Head: null");
                System.out.println("Tail: null");
            } else {
                System.out.println("Head: " + head.value);
                System.out.println("Tail: " + tail.value);
            }
            System.out.println("Length:" + length);
            System.out.println("\nLinked List:");
            if (length == 0) {
                System.out.println("empty");
            } else {
                printList();
            }
        }

        public void makeEmpty() {
            head = null;
            tail = null;
            length = 0;
        }

        public void append(int value) {
            Node newNode = new Node(value);
            if (length == 0) {
                head = newNode;
                tail = newNode;
            } else {
                tail.next = newNode;
                tail = newNode;
            }
            length++;
        }

        public boolean hasLoop(){
            Node fast = head;
            Node slow = head;
            while(fast != null && fast.next != null){
                slow = slow.next;
                fast = fast.next.next;
                if (fast == slow){
                    return true;
                }
            }
            return false;
        }

    // WRITE HASLOOP METHOD HERE //
    //                           //
    //                           //
    //                           //
    //                           //
    ///////////////////////////////

    }

## Hint

Pseudo Code:

Initialize two pointers: slow and fast, both pointing to the head of the list.

Start a while loop that continues until both fast is null and the next node of fast is null:

Move slow one step ahead (i.e., slow = slow.next).

Move fast two steps ahead (i.e., fast = fast.next.next).

Check if slow is equal to fast. If they are equal, it means the list has a loop, so return true.

If the while loop ends without finding a loop, return false.

This algorithm uses the slow and fast pointer technique (also known as Floyd's Tortoise and Hare algorithm) to efficiently detect the presence of a loop in the linked list.

## Solution Explanation

    public boolean hasLoop() {
        Node slow = head;
        Node fast = head;

        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;

            if (slow == fast) {
                return true;
            }
        }

        return false;
    }

In this code, the hasLoop method uses two pointers to traverse the linked list: slow and fast. The slow pointer moves one step at a time, while the fast pointer moves two steps at a time. If there is a loop in the linked list, the slow and fast pointers will eventually meet, and the method will return true. If there is no loop in the linked list, the fast pointer will eventually reach the end of the list, and the method will return false.

FAQ

Question:
Why are fast != null and fast.next != null both necessary in the while loop?

Answer:
In the while condition, fast != null and fast.next != null are both necessary to ensure that the code doesn't throw a NullPointerException.

Here's why each condition is necessary:

fast != null: This condition checks if the fast pointer has reached the end of the list. If the list doesn't have a loop, the fast pointer will eventually reach the end of the list (i.e., it will become null).

fast.next != null: Since the fast pointer moves two nodes at a time, this condition checks if there is at least one more node after the current fast node before trying to move to the next node. If this condition wasn't there and fast was at the last node in the list, trying to move two nodes ahead with fast.next.next would result in a NullPointerException.

Code with inline comments:

    public boolean hasLoop() {
        // Initialize slow pointer to the head of the linked list
        Node slow = head;

        // Initialize fast pointer to the head of the linked list
        Node fast = head;

        // Traverse the linked list with two pointers: slow and fast
        // slow moves one node at a time, while fast moves two nodes at a time
        while (fast != null && fast.next != null) {
            // Move slow pointer to the next node
            slow = slow.next;

            // Move fast pointer to the next two nodes
            fast = fast.next.next;

            // If slow pointer meets fast pointer, then there is a loop in the linked list
            if (slow == fast) {
                return true;
            }
        }

        // If the loop has not been detected after the traversal, then there is no loop in the linked list
        return false;
    }
