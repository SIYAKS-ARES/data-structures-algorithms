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

## My Attempt

