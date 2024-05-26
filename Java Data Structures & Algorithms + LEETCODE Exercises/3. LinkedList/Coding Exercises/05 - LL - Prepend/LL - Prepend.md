# LL - Prepend

Implement a method called prepend that adds a new node at the beginning of the linked list.

Return type: void

The method should perform the following tasks:

Accept an integer value as an argument, which will be the value of the new node.

Create a new Node object called newNode with the given value.

If the length of the linked list is 0, set both the head and tail pointers of the list to the newNode.

If the length of the linked list is greater than 0, perform the following tasks:

Set the next attribute of newNode to the current head node.

Update the head pointer of the list to point to the newNode.

Increment the length attribute of the list by 1.

## Solution Explanation

    public void prepend(int value) {
        Node newNode = new Node(value);
        if (length == 0) {
            head = newNode;
            tail = newNode;
        } else {
            newNode.next = head;
            head = newNode;
        }
        length++;
    }

The prepend() method adds a new node with the specified value to the beginning of the linked list.

The method creates a new Node with the specified value and points the head instance variable at the new Node.

If the linked list is currently empty (i.e., its length instance variable is 0), then the tail variable is also pointed at the new Node.

If the linked list is not empty, the next instance variable of the new node is pointed at the same node that the head instance variable points to (the first node in the LL) and then head is pointed at the new Node.

Finally, the length instance variable of the LinkedList object is incremented to reflect the addition of the new node to the linked list.

Code with inline comments:

public void prepend(int value) {
    // create a new node with the specified value
    Node newNode = new Node(value);
    // if the linked list is currently empty
    if (length == 0) {
        // set the new node as both the head and tail of the linked list
        head = newNode;
        tail = newNode;
    } else {
        // set the new node's next reference to the current head node
        newNode.next = head;
        // set the new node as the new head node of the linked list
        head = newNode;
    }
    // increment the length of the linked list
    length++;
}
