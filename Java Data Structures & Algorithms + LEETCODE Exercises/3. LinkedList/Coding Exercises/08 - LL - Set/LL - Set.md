# LL: Set

Implement a method called set that updates the value of a node in the linked list by its index.

Return type: boolean

Method signature: public boolean set(int index, int value)

The method should perform the following tasks:

Accept an integer index as an argument, representing the index of the node to be updated.

Accept an integer value as an argument, representing the new value to set for the node at the specified index.

Call the get method with the provided index to obtain a pointer to the node at the specified index.

If the node exists (i.e., the get method returns a non-null value), update the node's value with the provided value and return true.

If the node does not exist (i.e., the get method returns null), return false.

## SOLUTION

    public boolean set(int index, int value) {
        Node temp = get(index);
        if (temp != null) {
            temp.value = value;
            return true;
        }
        return false;
    }

The set(int index, int value) method sets the value of the node at the specified index in the linked list.

The method first calls the get(int index) method to retrieve a pointer to the node at the specified index. If the get method returns null (which means the index is out of bounds), the set method returns false.

If the get method returns a pointer to a valid node, the method sets the value of that node to the specified value and returns true.

Code with inline comments:

public boolean set(int index, int value) {
    // retrieve the node at the specified index
    Node temp = get(index);

    // if the index is out of bounds, return false
    if (temp != null) {
        // if the node is found, set the value of the node
        temp.value = value;
        // return true to indicate that the value was set successfully
        return true;
    }
    // return false if the index is out of bounds
    return false;
}
