# LL: Reverse

Implement a method called reverse that reverses the order of the nodes in the linked list.

When solving the reverse() method, students are not allowed to create a new list or use any additional data structures besides the linked list itself.

They must reverse the nodes in the existing linked list by manipulating the pointers between them.

Return type: void

The method should perform the following tasks:

The process of reversing the linked list should be done in one pass of the linked list.

Create a temporary Node object called temp and set it to the head attribute of the list.

Set the head attribute of the list to the current tail attribute.

Set the tail attribute of the list to the temporary Node object.

Create a Node object called after and set it to the next attribute of the temporary Node object.

Create a Node object called before and initialize it to null.

Loop through the linked list using a for loop with a counter variable i, starting from 0 and ending at the length attribute of the list. a. Set the after attribute to the next attribute of the temporary Node object. b. Set the next attribute of the temporary Node object to the before attribute. c. Set the before attribute to the temporary Node object. d. Set the temporary Node object to the after attribute.

The method has no return value.

## HINTS

Here is a breakdown of what the code is doing:

The first three lines of the method swap the head and tail pointers of the linked list, effectively reversing the order of the list.

The next line initializes a variable called after to the next node of the original head node.

The next line initializes a variable called before to null.

The for loop then iterates through the linked list length number of times, where length is the number of nodes in the linked list.

In each iteration of the loop, the after variable is set to the next node of the current node, which will become the new temp node in the next iteration.

The next pointer of the current node is then set to before, which effectively reverses the order of the nodes in the list.

The before variable is set to the current node, which will become the new temp node in the next iteration.

The temp variable is then set to after, which sets up the next iteration of the loop.

## SOLUTION

    public void reverse() {
        Node temp = head;
        head = tail;
        tail = temp;
        Node after = temp.next;
        Node before = null;
        for (int i = 0; i < length; i++) {
        // Instead of the for loop you could use:
        // while (temp != null) {
            after = temp.next;
            temp.next = before;
            before = temp;
            temp = after;
        }
    }

This is a method that reverses the linked list by changing the order of the nodes in the list. The method starts by swapping the head and tail nodes of the list, which effectively reverses the direction of the list.

After swapping the head and tail nodes, the method then uses a loop to iterate through the nodes in the list and reverse the order of the links between the nodes. It does this by keeping track of three nodes: the current node (which starts as the original head node), the node before the current node (which starts as null), and the node after the current node.

On each iteration of the loop, the method updates the "before" and "after" nodes to be the next nodes in the list (i.e., the nodes immediately before and after the current node), and then changes the "next" pointer of the current node to point to the "before" node. It then updates the "before" node to be the current node, and the "current" node to be the "after" node, and continues the loop.

By the time the loop finishes iterating through all the nodes in the list, the order of the links between the nodes will have been reversed, effectively reversing the entire list.

Code with inline comments:

public void reverse() {
    // Set temp to the current head of the linked list
    Node temp = head;
    // Set the new head to be the current tail
    head = tail;
    // Set the new tail to be the previous head (stored in temp)
    tail = temp;

    // Set after to be the next node after the current head
    Node after = temp.next;
    // Initialize before to null, as the first node in the reversed list will not have a previous node
    Node before = null;

    // Loop through the linked list, reversing the order of the nodes
    for (int i = 0; i < length; i++) {
        // Set after to be the next node after the current node
        after = temp.next;
        // Set the current node's next pointer to the previous node
        temp.next = before;
        // Set before to be the current node, as it will be the previous node in the next iteration of the loop
        before = temp;
        // Set temp to be the next node in the linked list
        temp = after;
    }
}
