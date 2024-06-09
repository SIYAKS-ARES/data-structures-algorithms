# LL: Find Kth Node From End ( ** Interview Question) (So Good!)

Implement a method called findKthFromEnd that returns the k-th node from the end of the list.

If the list has fewer than k nodes, the method should return null.

Note: This implementation of the Linked List class does not have the length attribute.

Method signature:

public Node findKthFromEnd(int k)

Example:

LinkedList myList = new LinkedList(1);
myList.append(2);
myList.append(3);
myList.append(4);
myList.append(5);

Node result = myList.findKthFromEnd(2); // Output: Node with value 4

result = myList.findKthFromEnd(5); // Output: Node with value 1

result = myList.findKthFromEnd(6); // Output: null

Note:

In this problem, you should use the two-pointer technique to efficiently find the k-th node from the end of the linked list.

## My Attempt

    public class LinkedList {

        private Node head;
        private Node tail;

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
        }

        public Node getHead() {
            return head;
        }

        public Node getTail() {
            return tail;
        }

        public void printList() {
            Node temp = head;
            while (temp != null) {
                System.out.println(temp.value);
                temp = temp.next;
            }
        }

        public void printAll() {
            if (head == null) {
                System.out.println("Head: null");
                System.out.println("Tail: null");
            } else {
                System.out.println("Head: " + head.value);
                System.out.println("Tail: " + tail.value);
            }
            System.out.println("\nLinked List:");
            if (head == null) {
                System.out.println("empty");
            } else {
                printList();
            }
        }

        public void makeEmpty() {
            head = null;
            tail = null;
        }

        public void append(int value) {
            Node newNode = new Node(value);
            if (head == null) {
                head = newNode;
                tail = newNode;
            } else {
                tail.next = newNode;
                tail = newNode;
            }
        }

        public Node findKthFromEnd(int k){
            // if (tail.index < k) return null;
            Node fast = head;
            Node slow = head;
            for (int i = 0; i < k; i++){
                if (fast == null){
                    return null;
                }
                fast = fast.next;
            }
            while (fast!=null){
                slow = slow.next;
                fast = fast.next;
            }

            return slow;

        }

    // WRITE FINDKTHFROMEND METHOD HERE //
    //                                  //
    //                                  //
    //                                  //
    //                                  //
    //////////////////////////////////////

    }

## Hint

Pseudo Code:

Initialize two pointers: slow and fast, both pointing to the head of the list.

Move fast k steps ahead:

Start a for loop that iterates k times.

Inside the loop, check if fast is null. If it is, the list has fewer than k nodes, so return null.

Move fast one step ahead (i.e., fast = fast.next).

Start a while loop that continues until fast is null:

Move slow one step ahead (i.e., slow = slow.next).

Move fast one step ahead (i.e., fast = fast.next).

When the while loop ends, slow will point to the k-th node from the end of the list. Return slow.

This algorithm uses the two-pointer technique to efficiently find the k-th node from the end of the linked list.

Explained another way:

The algorithm uses two pointers, called 'slow' and 'fast'. Both of these pointers start at the head of the list (the beginning of the chain).

First, 'fast' is moved 'k' steps along the list. If 'fast' encounters the end of the list (represented by 'null') before it has taken 'k' steps, the function returns 'null' because the list is shorter than 'k' elements.

If 'fast' successfully takes 'k' steps without reaching the end of the list, then the game changes. Now, both 'slow' and 'fast' start moving along the list at the same pace, one step at a time.

Here's the clever bit: by the time 'fast' hits the end of the list, 'slow' will be 'k' steps behind it - and therefore 'k' steps from the end of the list. So the function returns 'slow'.

This is a common technique in computer science known as the 'fast-pointer / slow-pointer' or 'runner' technique, and it's a neat way of finding a position relative to the end of a list in a single pass.

Explained yet another way:

This code is kind of like a game of tag, where you and your friend are running along a straight line of stones (these stones are like the "nodes" of our linked list). You're "slow" and your friend is "fast".

The rule of the game is your friend gets a head start and runs "k" stones ahead first.

If your friend runs out of stones before counting to "k" (when fast equals null), then you know the line of stones is not long enough (return null).

But if there are enough stones, after your friend's head start, you both start running together. If your friend hits the end of the line (when fast equals null again), the stone you are standing on is "k" stones from the end.

And that's the stone this code is trying to find!

## Solution Explanation

    public Node findKthFromEnd(int k) {
        Node slow = head;
        Node fast = head;

        for (int i = 0; i < k; i++) {
            if (fast == null) {
                return null;
            }
            fast = fast.next;
        }

        while (fast != null) {
            slow = slow.next;
            fast = fast.next;
        }

        return slow;
    }

This code defines a method called findKthFromEnd inside a LinkedList class, which takes an integer k as input and returns the kth node from the end of the LinkedList.

The method initializes two pointers, slow and fast, both pointing to the head of the LinkedList.

It then moves the fast pointer k steps ahead in the LinkedList. If fast becomes null at any point during this process, it means that k is out of bounds (greater than the length of the LinkedList), so the method returns null.

After moving the fast pointer k steps ahead, the method enters a while loop. This loop continues until the fast pointer reaches the end of the LinkedList (i.e., fast becomes null).

Inside the while loop, both the slow and fast pointers move one step at a time. Since the fast pointer is already k steps ahead of the slow pointer, when the fast pointer reaches the end of the LinkedList, the slow pointer will be at the kth node from the end.

Finally, the method returns the slow pointer, which now points to the kth node from the end of the LinkedList.

Code with inline comments:

    public Node findKthFromEnd(int k) {
        Node slow = head; // Initialize slow pointer at head
        Node fast = head; // Initialize fast pointer at head

        // Move fast pointer k steps ahead
        for (int i = 0; i < k; i++) {
            if (fast == null) { // If k is out of bounds, return null
                return null;
            }
            fast = fast.next; // Move the fast pointer to the next node
        }

        // Move both pointers until fast reaches the end
        while (fast != null) {
            slow = slow.next; // Move the slow pointer to the next node
            fast = fast.next; // Move the fast pointer to the next node
        }

        return slow; // Return the kth node from the end (slow pointer)
    }
