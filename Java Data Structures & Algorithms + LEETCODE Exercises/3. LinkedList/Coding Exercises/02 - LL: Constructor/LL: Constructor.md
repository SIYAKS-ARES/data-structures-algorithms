# Coding Exersize

LL: Constructor

Understand the Node Structure:

Before writing the constructor, ensure you're familiar with the Node class, which is a nested class within the LinkedList class. Each Node should hold an integer value and a reference to the next node (Node next). For the initial node, next will be null.

Constructor Signature:

Your constructor should be public and named LinkedList. It will accept a single integer argument, value, which represents the data to store in the list's first node.

Create the First Node:

Inside the constructor, use the passed value to create a new instance of the Node class. This instance will be the first and only node in your linked list upon creation.

Initialize Head and Tail:

Assign the newly created node to both the head and tail of the linked list. This is because, initially, the list contains only one node, making it both the beginning and end of the list.

Set the List Length:

Initialize the length of the linked list to 1, reflecting that the list currently contains a single node.

## Solution Explanation

    public LinkedList(int value) {
        Node newNode = new Node(value);
        head = newNode;
        tail = newNode;
        length = 1;
    }

This code is a constructor for a LinkedList class. The constructor is used to create a new instance of a LinkedList object with a single node. Here's a breakdown of its components:

public LinkedList(int value) {: This line defines the constructor for the LinkedList class. It takes a single integer parameter named value, which represents the data that will be stored in the first node of the list.

Node newNode = new Node(value);: Inside the constructor, a new Node object is created using the value passed into the constructor. This Node is intended to be the first node of the linked list. The Node class is a nested class within the LinkedList class, designed to represent the elements of the list. Each Node object has an int value that holds the data and a Node reference to the next node in the list.

head = newNode;: The head variable of the LinkedList object is set to reference the newly created node. In a linked list, the head refers to the first node in the list. Since this is the initial setup of the list, the new node is the first and only node, making it the head of the list.

tail = newNode;: Similarly, the tail variable of the LinkedList is set to reference the new node. The tail in a linked list refers to the last node in the list. At this point, because there's only one node, it is both the head and the tail of the list.

length = 1;: This sets the length property of the LinkedList object to 1, indicating that there is currently one node in the list. The length property is used to keep track of how many nodes are in the list, allowing for easy retrieval of the size of the list without needing to traverse it.
