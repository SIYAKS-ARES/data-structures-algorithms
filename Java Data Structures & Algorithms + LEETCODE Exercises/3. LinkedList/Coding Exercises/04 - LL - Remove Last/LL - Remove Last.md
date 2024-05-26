# LL: Remove Last

Implement a method called removeLast that removes the last node from the linked list.

Return type: Node (we are returning the Node that is being removed)

The method should perform the following tasks:

If the length of the linked list is 0, return null.

Create two variables that can point to a Node , temp and pre, both initially pointing to the head of the linked list.

Traverse the linked list until temp.next is null, performing the following tasks during traversal:

Update pre to point to the current temp node.

Update temp to point to the next node in the linked list.

After traversal, set the tail pointer to pre.

Set the next attribute of the tail node to null.

Decrement the length attribute of the list by 1.

If the length of the linked list becomes 0 after removing the last node, set both the head and tail pointers to null.

Return the removed node (pointed to by temp).

## Hints

Draw out a small linked list on paper and walk through the steps of the method manually.

Start at the head of the linked list and iterate through each node until you reach the last node. Make sure you keep track of the previous node along the way.

Then, update the tail of the linked list to be the previous node, remove the reference to the original tail node, and decrement the length of the linked list. Finally, make sure to handle the case where the linked list is now empty.

Walking through the method manually on a small linked list can help to visualize the steps and understand how they work together to remove the last node from the linked list.

## Solution Explanation

Solution from the video:

    public Node removeLast() {
        if (length == 0) return null;
        Node temp = head;
        Node pre = head;
        while(temp.next != null) {
            pre = temp;
            temp = temp.next;
        }
        tail = pre;
        tail.next = null;
        length--;
        if (length == 0) {
            head = null;
            tail = null;
        }
        return temp;
    }

Alternative Solution:

    public Node removeLast() {
        if (length == 0) return null;
        if (length == 1) {
            Node temp = head;
            head = null;
            tail = null;
            length--;
            return temp;
        } else {
            Node temp = head;
            while (temp.next.next != null) {
                temp = temp.next;
            }
            Node lastNode = temp.next;
            temp.next = null;
            tail = temp;
            length--;
            return lastNode;
        }
    }


The removeLast() method removes the last node of the linked list and returns it.

The method first checks if the length of the linked list is 0 (you could also check to see if (head == null) ), which means there are no nodes to remove, and in that case, it returns null.

Otherwise, the method starts at the head node and iterates through the linked list until it reaches the second-to-last node, which is the node that points to the last node.

Once the second-to-last node is found, the tail instance variable of the LinkedList object is pointed to it, and its next reference is set to null. This effectively removes the last node from the linked list.

The length instance variable of the LinkedList object is then decremented, and if the length of the linked list is now 0, the head and tail instance variables are set to null.

Finally, the method returns the removed node, which is the original tail node.

Code with inline comments:

public Node removeLast() {
    // if the length of the linked list is 0, return null
    if (length == 0) return null;

    // start at the head node
    Node temp = head;
    Node pre = head;
    // iterate through the linked list until the last node is reached
    while(temp.next != null) {
        pre = temp;  // keep track of the second-to-last node
        temp = temp.next;
    }
    // set the new tail node to be the second-to-last node
    tail = pre;
    // remove the reference to the former tail node
    tail.next = null;
    // decrement the length of the linked list
    length--;
    // if the linked list is now empty, set head and tail to null
    if (length == 0) {
        head = null;
        tail = null;
    }
    // return the removed node
    return temp;
}
